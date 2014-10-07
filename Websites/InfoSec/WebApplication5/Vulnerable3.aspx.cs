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
    public partial class Vulnerable31 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack)
            {
                if (hasData())
                    insert_data();

            }
        }
        protected void Log_In(object sender, EventArgs e)
        {
            String redirection = "/Vulnerable3_2.aspx?";
            if (validAuthentication(tb_USERNAME2.Text, tb_PASSWORD2.Text))
            {
                redirection += "username=" + tb_USERNAME2.Text + "&password=" + tb_PASSWORD2.Text;
                Response.Redirect(redirection);
            }
            else
            {
                Image2.Visible=true;
                Label2.Text = "Invalid Login Credentials";
            }

        }
        protected Boolean hasData()
        {
            if (tb_USRNAME.Text.Equals(""))
            {
                return false;
            }
            if (tb_FNAME.Text.Equals(""))
            {
                return false;
            }
            if (tb_LNAME.Text.Equals(""))
            {
                return false;
            }
            if (tb_SID.Text.Equals(""))
            {
                return false;
            }
            if (ddlMAJOR.SelectedValue.Equals("0"))
            {
                return false;
            }
            return true;
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
        protected void insert_data()
        {
            string response;
            String redirection = "/Vulnerable3_2.aspx?";
            String connection = ConfigurationManager.ConnectionStrings["InfosecConnectionString"].ConnectionString;
            SqlConnection sqlConnection1 = new SqlConnection(connection);
            SqlCommand cmd = new SqlCommand();

            cmd.CommandText = "SP_REGISTER_USER";
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Connection = sqlConnection1;
            cmd.Parameters.Add("@USERNAME", SqlDbType.VarChar, 20);
            cmd.Parameters["@USERNAME"].Value = tb_USRNAME.Text;
            cmd.Parameters.Add("@PASSWORD", SqlDbType.VarChar, 20);
            cmd.Parameters["@PASSWORD"].Value = tb_PASSWORD.Text;
            cmd.Parameters.Add("@FIRST_NAME", SqlDbType.VarChar, 15);
            cmd.Parameters["@FIRST_NAME"].Value = tb_FNAME.Text;
            cmd.Parameters.Add("@LAST_NAME", SqlDbType.VarChar, 15);
            cmd.Parameters["@LAST_NAME"].Value = tb_LNAME.Text;
            cmd.Parameters.Add("@STUDENT_ID", SqlDbType.VarChar, 9);
            cmd.Parameters["@STUDENT_ID"].Value = tb_SID.Text;
            cmd.Parameters.Add("@EMAIL", SqlDbType.VarChar, 25);
            cmd.Parameters["@EMAIL"].Value = tb_EMAIL.Text;
            cmd.Parameters.Add("@PHONE_NUMBER", SqlDbType.VarChar, 10);
            cmd.Parameters["@PHONE_NUMBER"].Value = tb_PHNUM.Text;
            cmd.Parameters.Add("@MAJOR", SqlDbType.VarChar, 3);
            cmd.Parameters["@MAJOR"].Value = ddlMAJOR.SelectedValue;
            SqlDataAdapter objDA = new SqlDataAdapter();
            objDA.SelectCommand = cmd;
            sqlConnection1.Open();
            DataSet objDS = new DataSet();
            response = cmd.ExecuteScalar().ToString();

            //objDA.Fill(objDS);
            if (response.Equals("1"))
            {
                redirection += "username=" + tb_USRNAME.Text;
                redirection += "&password=" + tb_PASSWORD.Text;
                Response.Redirect(redirection);
            }
            else
            {
                Image1.Visible = true;
                Label1.Text = "Error: That username already exists";
            }
        }
    }
}