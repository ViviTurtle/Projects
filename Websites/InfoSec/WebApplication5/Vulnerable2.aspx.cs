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
    public partial class Vulnerable2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            String temp;
            if (Page.IsPostBack)
            {
                if (!TextBox1.Text.Equals(""))
                {
                    submitText(TextBox1.Text);
                }
                ddlComments.DataBind();
            }
            temp = ddlComments.SelectedValue;
            pop_ddlCOMMENT();
            ddlComments.SelectedValue = temp;


        }
        protected void pop_ddlCOMMENT()
        {
            
            String connection = ConfigurationManager.ConnectionStrings["InfosecConnectionString"].ConnectionString;
            SqlConnection sqlConnection1 = new SqlConnection(connection);
            SqlCommand cmd = new SqlCommand();

            cmd.CommandText = "SP_GET_ALL_COMMENTS";
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Connection = sqlConnection1;
            SqlDataAdapter objDA = new SqlDataAdapter();
            objDA.SelectCommand = cmd;
            sqlConnection1.Open();
            DataSet objDS = new DataSet();


            objDA.Fill(objDS);
            ddlComments.DataSource = objDS;
            sqlConnection1.Close();
            ddlComments.DataTextField = "COMMENT_ID";
            ddlComments.DataValueField = "COMMENT";
            ddlComments.DataBind();

        }
        protected void submitText(String text)
        {
            string comment_ID;
            String connection = ConfigurationManager.ConnectionStrings["InfosecConnectionString"].ConnectionString;
            SqlConnection sqlConnection1 = new SqlConnection(connection);
            SqlCommand cmd = new SqlCommand();

            cmd.CommandText = "SP_INSERT_COMMENT";
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Connection = sqlConnection1;
            cmd.Parameters.Add("@COMMENT", SqlDbType.VarChar, -1);
            cmd.Parameters["@COMMENT"].Value = text;
            SqlDataAdapter objDA = new SqlDataAdapter();
            objDA.SelectCommand = cmd;
            sqlConnection1.Open();
            DataSet objDS = new DataSet();
            comment_ID = cmd.ExecuteScalar().ToString();

            //objDA.Fill(objDS);
            if (!comment_ID.Equals("1"))
            {
                Label2.Text = "Your comment ID is " + comment_ID;
            }
            TextBox1.Text = "";
            sqlConnection1.Close();
            ddlComments.DataBind();
        }


        protected void ddlComments_SelectedIndexChanged(object sender, EventArgs e)
        {

            Label3.Text = ddlComments.SelectedValue;

        }
    }
}