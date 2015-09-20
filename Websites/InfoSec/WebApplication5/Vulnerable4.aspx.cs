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
       
        }
        protected void insertData(object sender, EventArgs e)
        {
            String connection = ConfigurationManager.ConnectionStrings["SQLi2"].ConnectionString;
            string command = @"INSERT INTO T_SURVEY (NAME,RATING, FAVORITE, LEAST,OFFICER, WHY) VALUES ('" + tbNAME.Text + "', '" + ddlRATE.SelectedValue + "', '" + tbFAVORITE2.Value + "', '" + tbLEAST.Text + "', '" + ddlOFFICER.SelectedValue + "', '" + tbWHY2.Value + "')";
                SqlDataAdapter objDA = new SqlDataAdapter(command, connection);
                DataSet objDS = new DataSet();
                SqlCommandBuilder cmdBuilder;
                cmdBuilder = new SqlCommandBuilder(objDA);
                objDA.Fill(objDS);
                tbNAME.Text = "";
                ddlRATE.SelectedValue = "THE CAKE WAS A LIE";
                tbFAVORITE2.Value = "";
                tbLEAST.Text = "";
                ddlOFFICER.SelectedValue = "ITS A TRAP";
                tbWHY2.Value = "";
                Image1.ImageUrl = "~/images/Thankyou.jpg";
                lblTITLE.Text = "Thank you for your submission ";
        }
    }
}