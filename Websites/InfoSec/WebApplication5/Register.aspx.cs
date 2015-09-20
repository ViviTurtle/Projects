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
using System.IO;
using System.Security.Cryptography;


namespace WebApplication5
{
    public partial class Vulnerable3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack)
            {


            }
        }

        //http://stackoverflow.com/questions/730268/unique-random-string-generation
        protected string RandomString(int length, string allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")
        {
            if (length < 0) throw new ArgumentOutOfRangeException("length", "length cannot be less than zero.");
            if (string.IsNullOrEmpty(allowedChars)) throw new ArgumentException("allowedChars may not be empty.");

            const int byteSize = 0x100;
            var allowedCharSet = new HashSet<char>(allowedChars).ToArray();
            if (byteSize < allowedCharSet.Length) throw new ArgumentException(String.Format("allowedChars may contain no more than {0} characters.", byteSize));

            // Guid.NewGuid and System.Random are not particularly random. By using a
            // cryptographically-secure random number generator, the caller is always
            // protected, regardless of use.
            using (var rng = new System.Security.Cryptography.RNGCryptoServiceProvider())
            {
                var result = new StringBuilder();
                var buf = new byte[128];
                while (result.Length < length)
                {
                    rng.GetBytes(buf);
                    for (var i = 0; i < buf.Length && result.Length < length; ++i)
                    {
                        // Divide the byte into allowedCharSet-sized groups. If the
                        // random value falls into the last group and the last group is
                        // too small to choose from the entire allowedCharSet, ignore
                        // the value in order to avoid biasing the result.
                        var outOfRangeStart = byteSize - (byteSize % allowedCharSet.Length);
                        if (outOfRangeStart <= buf[i]) continue;
                        result.Append(allowedCharSet[buf[i] % allowedCharSet.Length]);
                    }
                }
                return result.ToString();
            }
        }
        protected void ddlMAJOR_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void register(object sender, EventArgs e)
        {
            //http://stackoverflow.com/questions/27764692/validating-recaptcha-2-no-captcha-recaptcha-in-asp-nets-server-side
            string EncodedResponse = Request.Form["g-Recaptcha-Response"];
            bool IsCaptchaValid = (ReCaptchaClass.Validate(EncodedResponse) == "True" ? true : false);

            if (IsCaptchaValid)
            {
                //Valid Request

                if (tb_EMAIL.Text.Length > 9 && tb_EMAIL.Text.Substring(tb_EMAIL.Text.Length - 9).Equals("@sjsu.edu"))
                {
                    if (tb_passphrase.Text.Equals("") || tb_passphrase.Text.Equals(null))
                    {
                        ScriptManager.RegisterClientScriptBlock(Page, this.GetType(), "Invalid Password", "alert('A password is required')", true);
                    }
                    else
                    {
                        string confirmationString = RandomString(50);
                        if (registerUser(confirmationString) == true)
                        {
                            sendConfirmationEmail(confirmationString);
                            ScriptManager.RegisterClientScriptBlock(Page, this.GetType(), "Success", "alert('An Email has been sent to you sjsu.edu inbox. Please visit your inbox to verify your account')", true);

                        }
                        else
                        {
                            ScriptManager.RegisterClientScriptBlock(Page, this.GetType(), "Success", "alert('There is already an account under that Student ID')", true);

                        }
                    }
                }
                else
                {
                    ScriptManager.RegisterClientScriptBlock(Page, this.GetType(), "Invalid Email", "alert('You must be a student to join the club. Please provide a sjsu.edu email')", true);
                }
            }
        }

        protected Boolean registerUser(string token)
        {
            string response;
            String connection = ConfigurationManager.ConnectionStrings["InfoGuest"].ConnectionString;
            SqlConnection sqlConnection1 = new SqlConnection(connection);
            SqlCommand cmd = new SqlCommand();

            string hashed_password = hashPass(tb_passphrase.Text);
            cmd.CommandText = "SP_CREATE_ACCOUNT";
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Connection = sqlConnection1;
            cmd.Parameters.Add("@STUDENT_ID", SqlDbType.VarChar, 9);
            cmd.Parameters["@STUDENT_ID"].Value = tb_SID.Text;
            cmd.Parameters.Add("@PASSWORD", SqlDbType.VarChar, 48);
            cmd.Parameters["@PASSWORD"].Value = hashed_password;
            cmd.Parameters.Add("@FNAME", SqlDbType.VarChar, 25);
            cmd.Parameters["@FNAME"].Value = tb_FNAME.Text;
            cmd.Parameters.Add("@LNAME", SqlDbType.VarChar, 25);
            cmd.Parameters["@LNAME"].Value = tb_LNAME.Text;
            cmd.Parameters.Add("@GENDER", SqlDbType.VarChar, 1);
            cmd.Parameters["@GENDER"].Value = rb_Gender.SelectedValue.ToString();
            cmd.Parameters.Add("@PHONE_NUMBER", SqlDbType.VarChar, 25);
            cmd.Parameters["@PHONE_NUMBER"].Value = tb_PHNUM.Text;
            cmd.Parameters.Add("@EMAIL", SqlDbType.VarChar, -1);
            cmd.Parameters["@EMAIL"].Value = tb_EMAIL.Text;
            cmd.Parameters.Add("@MAJOR", SqlDbType.VarChar, 4);
            cmd.Parameters["@MAJOR"].Value = ddlMAJOR.SelectedValue.ToString();
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
        //http://stackoverflow.com/questions/4181198/how-to-hash-a-password
        protected string hashPass(string password)
        {
            // Create a byte array to hold the random value.  
            byte[] salt;
            new RNGCryptoServiceProvider().GetBytes(salt = new byte[16]);

            int myIterations = 10000;
            try
            {

                var pbkdf2 = new Rfc2898DeriveBytes(password, salt, myIterations);
                byte[] hash = pbkdf2.GetBytes(20);
                byte[] hashBytes = new byte[36];
                Array.Copy(salt, 0, hashBytes, 0, 16);
                Array.Copy(hash, 0, hashBytes, 16, 20);
                return Convert.ToBase64String(hashBytes);

            }

            catch (Exception e)
            {
                Console.WriteLine("Error: ", e);
                return "Erorr";
            }
        }

        protected void sendConfirmationEmail(String token)
        {
            var fromAddress = new MailAddress("sjsu.infosec@gmail.com", "InfoSec Club");
            var toAddress = new MailAddress(tb_EMAIL.Text, tb_FNAME.Text + " " + tb_LNAME.Text);
            const string fromPassword = "KickOutTheEpic";
            const string subject = "SJSU InfoSec Club Registration";
            string body = "Hi " + tb_FNAME.Text + " " + tb_LNAME.Text + ",\n\nI would like to thank you for your interest in joining the SJSU Information Club. Please click in the following link to confirm your registration and create your account upon which an Admin will verify you are an SJSU Student.\n\nhttp://www.sjsuinfosecurity.com/Confirmation?token=" + token + "\n\n We look forward to seeing you work with the club\n\n- Vivi Langga\nCTF Web Administrator\nVivi.Langga@gmail.com";
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