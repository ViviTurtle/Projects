using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net;
using System.Net.Mail;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using System.Text;

namespace WebApplication5
{
    public partial class Confirmation : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string token = Request.QueryString["token"];
            if (token.Length == 0)
            {
                token = "";
            }
            if (validate(token) == false)
            {
                Response.Redirect("/Error.aspx?");
            }
            else
                ScriptManager.RegisterClientScriptBlock(Page, this.GetType(), "Success", "alert('Your email has been confirmed')", true);
           // sendAdminEmail(token);      
            }
        protected void sendAdminEmail(String token)
        {
            var fromAddress = new MailAddress("sjsu.infosec@gmail.com", "InfoSec Club");
            var toAddress = new MailAddress("Anthony.Langga@sjsu.edu", "Vivi Langga");
            const string fromPassword = "KickOutTheEpic";
            const string subject = "SJSU InfoSec Club Registration";
           // string body = "Hi " + tb_FNAME.Text + " " + tb_LNAME.Text + ",\n\nI would like to thank you for your interest in joining the SJSU Information Club. Please click in the following link to confirm your registration and create your account upon which an Admin will verify you are an SJSU Student.\n\nhttp://www.sjsuinfosecurity.com/Confirmation?token=" + token + "\n\n We look forward to seeing you work with the club\n\n- Vivi Langga\nCTF Web Administrator\nVivi.Langga@gmail.com";
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
           //     Body = body
            })
            {
                smtp.Send(message);
            }

        }
        protected Boolean validate(string token)
        {
                string response;
                String connection = ConfigurationManager.ConnectionStrings["InfoGuest"].ConnectionString;
                SqlConnection sqlConnection1 = new SqlConnection(connection);
                SqlCommand cmd = new SqlCommand();


                cmd.CommandText = "SP_VALIDATE_EMAIL";
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Connection = sqlConnection1;
                cmd.Parameters.Add("@TOKEN", SqlDbType.VarChar, 50);
                cmd.Parameters["@TOKEN"].Value = token;

                 SqlDataAdapter objDA = new SqlDataAdapter();
                objDA.SelectCommand = cmd;
                sqlConnection1.Open();
                DataSet objDS = new DataSet();
                response = cmd.ExecuteScalar().ToString();
                if (response.Equals("0"))
                {
                    return false;
                }
                else return true;
            }
        }
    }
