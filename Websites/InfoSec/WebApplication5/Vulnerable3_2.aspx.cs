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
    public partial class Vulnerable3_2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            String username = Request.QueryString["username"];
            String password = Request.QueryString["password"];
            checkCredentials(username, password);
        }
        protected void checkCredentials(String username, String password)
        {
            //if (validAuthentication(username, password))
            //{
                String connection = ConfigurationManager.ConnectionStrings["SQLi1"].ConnectionString;
                string command = @"SELECT * FROM T_MEMBERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";
                SqlDataAdapter objDA = new SqlDataAdapter(command, connection);
                DataSet objDS = new DataSet();
                SqlCommandBuilder cmdBuilder;
                cmdBuilder = new SqlCommandBuilder(objDA);
                objDA.Fill(objDS);
                Label1.Text = "Username: " + objDS.Tables[0].Rows[0]["USERNAME"].ToString();
                Label2.Text = "First name: " + objDS.Tables[0].Rows[0]["FIRST_NAME"].ToString();
                Label3.Text = "Last name: " + objDS.Tables[0].Rows[0]["LAST_NAME"].ToString();
                Label4.Text = "Student ID: " + objDS.Tables[0].Rows[0]["STUDENT_ID"].ToString();
                Label5.Text = "Email Address: " + objDS.Tables[0].Rows[0]["EMAIL"].ToString();
                Label6.Text = "Phone Number: " + objDS.Tables[0].Rows[0]["PHONE_NUMBER"].ToString();
                Label7.Text = "Major: " + objDS.Tables[0].Rows[0]["MAJOR"].ToString();

                if (Label1.Text == "Username: Admin")
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "congrats", "alert('Congratulations, You got it!');", true);
                }
            //}
            //else
            //{
            //    Label1.Text = "Invalid Login Beezy";
            //    hide_all();
            //}
            //sqlConnection1.Close();

        }
        protected Boolean validAuthentication(String username, String password)
        {
            string response;
            String connection = ConfigurationManager.ConnectionStrings["InfosecConnectionString"].ConnectionString;
            SqlConnection sqlConnection1 = new SqlConnection(connection);
            SqlCommand cmd = new SqlCommand();

            cmd.CommandText = "SP_CHECK_CREDENTIALS";
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Connection = sqlConnection1;
            cmd.Parameters.Add("@USERNAME", SqlDbType.VarChar, 20);
            cmd.Parameters["@USERNAME"].Value = username;
            cmd.Parameters.Add("@PASSWORD", SqlDbType.VarChar, 20);
            cmd.Parameters["@PASSWORD"].Value = password;
           
            SqlDataAdapter objDA = new SqlDataAdapter();
            objDA.SelectCommand = cmd;
            sqlConnection1.Open();
            DataSet objDS = new DataSet();
            response = cmd.ExecuteScalar().ToString();

            //objDA.Fill(objDS);
            if (response.Equals("1"))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        protected void hide_all()
        {
            
            Label2.Visible = false;
            Label3.Visible = false;
            Label4.Visible = false;
            Label5.Visible = false;
            Label6.Visible = false;
            Label7.Visible = false;

        }
    }
}