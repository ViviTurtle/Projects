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

namespace yourNameSpace
{

    public partial class yourClass : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        
        /*
         * Image Button rebinds data in Modalform
         */
        protected void IB_OpenModal_Click(object sender, ImageClickEventArgs e)
        {
           
            try
            {
            ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "openModal();", true);
            }
            catch (Exception ex)
            {
                lblWarnings.Text = "Error. Please refresh the page.";
            }
        }
        
    }
}


