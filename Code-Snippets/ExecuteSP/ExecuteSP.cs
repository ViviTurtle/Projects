using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace YourNameSpace
{
    public partial class yourClass : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
           //getUsername is however you plan to get the username
            lblUserName.Text = getUserName();
        }
        /*
         * When Query button is clicked, this populates the gridview
         * @param sender the button
         * @param e the onCLick event
         */
        protected void BtnQuery_Click(object sender, EventArgs e)
        {
            try
            {
                //Rebinds the Grid View and makes it Visible
                gv_Data.DataBind();
                gv_Data.Visible = true;
            }
            catch (Exception ex)
            {
                throw ex;
            }
          
        }
    }
}
