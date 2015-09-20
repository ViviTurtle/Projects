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
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Log_In(object sender, EventArgs e)
        {
            String redirection = "/Pass.aspx?";
            if (validAuthentication(tb_USERNAME2.Text, tb_PASSWORD2.Text))
            {
                Label2.Text = "Please Login";
                Response.Redirect(redirection);
            }
            else
            {
                Image2.Visible = true;
                Label2.Text = "Invalid Login Credentials";
            }


        }
        protected Boolean validAuthentication(String username, String password)
        {
            string response;
            String connection = ConfigurationManager.ConnectionStrings["InfoGuest"].ConnectionString;
            SqlConnection sqlConnection1 = new SqlConnection(connection);
            SqlCommand cmd = new SqlCommand();

            cmd.CommandText = "[SP_BRUTE_ME]";
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

    }
}