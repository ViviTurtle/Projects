using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication5
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void redirect(object sender, EventArgs e)
        {
            Response.Redirect("https://www.facebook.com/groups/725725020776252");
        }
    }
}