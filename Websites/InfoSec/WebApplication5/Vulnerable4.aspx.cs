using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;

namespace WebApplication5
{
    public partial class Vulnerable4 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack)
            {
                lblTITLE.Text = "Thank you for your submission ";
                insertData();
            }
        }
        protected void insertData()
        {
             String connection = ConfigurationManager.ConnectionStrings["InfosecConnectionString"].ConnectionString;
                string command = @"INSERT INTO T_SURVEY VALUES '" + tbNAME.Text + "', '" + ddlRATE.SelectedValue + "', '" + tbFAVORITE + "', '" + tbLEAST + "', '" + ddlOFFICER.SelectedValue + "', '" +tbWHY + "'";
                SqlDataAdapter objDA = new SqlDataAdapter(command, connection);
                DataSet objDS = new DataSet();
                SqlCommandBuilder cmdBuilder;
                cmdBuilder = new SqlCommandBuilder(objDA);
                objDA.Fill(objDS);
        }
    }
}