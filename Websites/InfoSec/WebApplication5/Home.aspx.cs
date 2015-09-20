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
        protected void redirect_fb(object sender, EventArgs e)
        {
            Response.Redirect("https://www.facebook.com/groups/1481343968813096/");
        }
        protected void redirect_gh(object sender, EventArgs e)
        {
            Response.Redirect("https://github.com/spartansecurity");
        }
        protected void redirect_li(object sender, EventArgs e)
        {
            Response.Redirect("https://www.linkedin.com/groups/InfoSec-Club-6689971");
        }
        protected void redirect_yt(object sender, EventArgs e)
        {
            Response.Redirect("https://www.youtube.com/channel/UCDNzNvZlYK8jZLsUbdiGrsQ");
        }
        
    }
}