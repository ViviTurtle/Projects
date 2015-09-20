using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Security; 

namespace WebApplication5
{
    public partial class Vulnerable1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
           
            String name = Request.QueryString["userName"];
            if (Page.IsPostBack)
            {
                lblsubmitComment.Text = txtComment.Text;
                lblsubmitName.Text = txtName.Text;
                lblsubmitComment.Visible = true;
                lblsubmitName.Visible = true;
                lbltest.Visible = true;
            }
            else 
            {
                lblsubmitName.Text = "Hi " +name;
                lblsubmitName.Visible = true;
            }
        }
      
    }
}