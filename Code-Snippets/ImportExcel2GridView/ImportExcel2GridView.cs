using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;
using System.IO;
using System.Data.OleDb;
using System.Data;
using System.Data.SqlClient;

namespace yourNamespace
{

    public partial class yourClass : System.Web.UI.Page
    {
        //*****NOTE Needs office and the following patches - https://social.msdn.microsoft.com/Forums/en-US/1d5c04c7-157f-4955-a14b-41d912d50a64/how-to-fix-error-the-microsoftaceoledb120-provider-is-not-registered-on-the-local-machine?forum=vstsdb
        protected void Page_Load(object sender, EventArgs e)
        {
           
        }
        /*
         * Initial Code from http://www.aspsnippets.com/Articles/Read-and-Import-Excel-File-into-DataSet-or-DataTable-using-C-and-VBNet-in-ASPNet.aspx
         * After clicking the Upload button it checks the filePath for that file and links it to the gridView
         * @param sender the button
         * @e the Upload onClick event
         */
        protected void btnUpload_Click(object sender, EventArgs e)
        {
            //if File exists
            if (FileUpload1.HasFile)
            {
                string FileName = Path.GetFileName(FileUpload1.PostedFile.FileName);
                string Extension = Path.GetExtension(FileUpload1.PostedFile.FileName);
                //Where to store the Excel Sheet
                string FolderPath = ConfigurationManager.AppSettings["FolderPath"];
                //Full path
                string FilePath = Server.MapPath(FolderPath + FileName);
                FileUpload1.SaveAs(FilePath);
                //Link to GridView
                Import_To_Grid(FilePath, Extension);
                //Show GridView, warnings, and GridView Submit button
                lblWarnings.Visible = false;
            }
        }

        /*
         * Initial Code from http://www.aspsnippets.com/Articles/Read-and-Import-Excel-File-into-DataSet-or-DataTable-using-C-and-VBNet-in-ASPNet.aspx
         * Takes the path to an Excel SpreadSheet and links it to the currentGridView
         * @param FilePath the FilePath to the Excel Spreadsheet
         * @param Extension the extension of the excel spreadsheet
         */
        private void Import_To_Grid(string FilePath, string Extension)
        {
            DataTable GridViewDataTable = new DataTable();
            DataColumn[] keyColumns = new DataColumn[1];
            string conStr = "";
            //use different ConnectionStrings depending on the year of the extension
            switch (Extension)
            {
                case ".xls": //Excel 97-03
                    conStr = ConfigurationManager.ConnectionStrings["Excel03ConString"]
                             .ConnectionString;
                    break;
                case ".xlsx": //Excel 07
                    conStr = ConfigurationManager.ConnectionStrings["Excel07ConString"]
                              .ConnectionString;
                    break;
            }
            //Creates the final connection String to use grab data from Excel sheet
            //@param "Yes" By default excel sheet header. If doesn't have not use No
            conStr = String.Format(conStr, FilePath, "Yes");
            //Excel Data Extraction Preperation
            OleDbConnection connExcel = new OleDbConnection(conStr);
            OleDbCommand cmdExcel = new OleDbCommand();
            string SheetName = null;
            OleDbDataAdapter oda = new OleDbDataAdapter();
            cmdExcel.Connection = connExcel;

            //Get the name of First Sheet
            connExcel.Open();
            DataTable dtExcelSchema;
            //Get skeleton of Excel Sheet (Sheet names, columns etc...)
            dtExcelSchema = connExcel.GetOleDbSchemaTable(OleDbSchemaGuid.Tables, null);
            //Each row represents a different sheet
            foreach (DataRow row in dtExcelSchema.Rows)
            {
                //If Excel has filters, it creates a hidden sheet for it. Needs to not contain "FilterDatabase" for our extraction to be valid
                if (!row["TABLE_NAME"].ToString().Contains("FilterDatabase"))
                {
                    //Sets Sheetname
                    SheetName = row["TABLE_NAME"].ToString();
                    break;
                }
            }
            connExcel.Close();

            //Read Data from First Sheet similar to SQL
            connExcel.Open();
            cmdExcel.CommandText = "SELECT * From [" + SheetName + "]";
            oda.SelectCommand = cmdExcel;


            //Fills our DataTable
            oda.Fill(GridViewDataTable);
            connExcel.Close();

            //Changes column names to be consistant with Backend SQL database
            GridViewDataTable.Columns[0].ColumnName = "Column1";
            GridViewDataTable.Columns[1].ColumnName = "Column2";

            //Clone Datatable to change Product ID to type string to enable Product ID's of non integers
            DataTable dtCloned = GridViewDataTable.Clone();
            dtCloned.Columns[6].DataType = typeof(string);
            foreach (DataRow row in GridViewDataTable.Rows)
            {
                dtCloned.ImportRow(row);
            }

            //Adds and stores an additional key_id column that comes from the SQL DB and not the Excel Sheet
            keyColumns[0] = dtCloned.Columns.Add("keyColumn", typeof(keyTypeHere));
            //Adds an additional column to store some data later
            dtCloned.Columns.Add("Additional Columns", typeof(string));
            //For each row in our current DataTable, we upload to the SQL Database to have it be reflected
            foreach (DataRow row in dtCloned.Rows)
            {
                //Inserts into SQL DB and sets the key_id in our DataTable
                int key_id = insertData(row[0].ToString().Trim(), row[1].ToString().Trim());
            }
            //Sets Primary Key
            dtCloned.PrimaryKey = keyColumns;
            //Bind Data to GridView
            GridView1.Caption = Path.GetFileName(FilePath);
            Session["GridData"] = dtCloned;
            rebindGridView1();
        }


        /*
         * Rebinds GridView1 and sets corresponding form to visible
         */
        private void rebindGridView1()
        {
            GridView1.DataSource = Session["GridData"];
            GridView1.DataBind();
            GridView1.Visible = true;
            btnSubmit.Visible = true;
        }



        /*
         * Inserts values into SQL DB table and returns the corresponding key_id from the table
         * @param data1 the data1 to insert
         * @param data2 the data2 to insert
         * @return the key_id of the new row in the SQL table
         */
        private int insertData(string data1, string data2)
        {
            //Executes byTopic.sp_inputForm_manage
            SqlConnection connection = new SqlConnection(ConfigurationManager.ConnectionStrings["yourConnectionString"].ConnectionString);
            string sqlProcedure = "YourInsertStoredProcedure";
            SqlCommand command = new SqlCommand(sqlProcedure, connection);
            command.CommandType = CommandType.StoredProcedure;
            //Parameters
            command.Parameters.Add("@data1", SqlDbType.VarChar, 30).Value = data1;
            command.Parameters.Add("@data2", SqlDbType.NVarChar, 50).Value = data2;
            //..Add more if needed
            connection.Open();
            SqlDataReader rdr = command.ExecuteReader();
            rdr.Read();
            //Reads and returns the new key
            int key_id = Int32.Parse(rdr["key_id"].ToString());
            connection.Close();
            return key_id;

        }

        
}
