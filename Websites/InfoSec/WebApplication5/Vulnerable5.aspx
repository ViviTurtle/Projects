<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Vulnerable5.aspx.cs" MasterPageFile="~/Site1.Master" Inherits="WebApplication5.WebForm1" %>

<asp:Content runat="server" ContentPlaceHolderID="head">


    <h1>Brute-Force</h1>
    <style>
        .extra_edit {
            vertical-align: top;
        }

       
    </style>

</asp:Content>


<asp:Content runat="server" ContentPlaceHolderID="body">
    <div class="row-fluid ">
        <div class="span9 offset1 hotbox">
            <p style="text-align: left;">From: n0013h4ck3rz@infosec.com</p>

            <p style="text-align: left;">To: InfoSecurity Team</p>

            <p style="text-align: left;">Subject: My account got hacked</p>

            <p style="text-align: left;">Body: </p>

            <p style="text-align: left;">Hi, InfoSec Team</p>
            <br />
            <p style="text-align: left;">The other day I got onto my account on here and I got this email. Can you believe it? This Nigerian Prince wanted to send money into my Bank account! I responded quickly and gave him my Bank Account information as well as my Email Information. I don't really know what happened but now I can't log in to my email. Can you log on for me?</p>
            <br />

            <p style="text-align: left;">Regards</p>
            <br />
            <p style="text-align: left;">-n0013h4ck3rz</p>
        </div>
        <br />

        <div class="span5 offset4" style="text-align: left;">
            <div class="accordion" id="accordion2">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">Hint Hint?
                        </a>
                    </div>
                    <div id="collapseOne" class="accordion-body collapse">
                        <div class="accordion-inner">
                            A hideous human female from Greek mythology with living venomous snakes in place of hair can help you here.
                        <br />
                            <br />
                            If you don't want to risk turning into stone, an ancient serpent-like water monster from Greek Mythology with reptilian traits that possesed many heads can also help. Have fun
                        </div>
                    </div>
                </div>
            </div>
            <asp:Image ID="Image2" runat="server" ImageUrl="~/images/error.jpg" Visible="false" />
            <asp:Label ID="Label2" runat="server" CssClass="title" Text="Please Login"></asp:Label>
            <br />
            <br />
            <table class="extra_edit">
                <tr>
                    <td class="auto-style1">Username:
                    </td>
                    <td>
                        <asp:TextBox ID="tb_USERNAME2" runat="server"></asp:TextBox>
                    </td>

                </tr>
                <tr>
                    <td class="auto-style1">Password:
                    </td>
                    <td>
                        <asp:TextBox ID="tb_PASSWORD2" PasswordChar="*" runat="server"></asp:TextBox>
                    </td>

                </tr>
            </table>
            <asp:Button ID="Button2" runat="server" Text="Log in" CausesValidation="false" OnClick="Log_In" />
        </div>
    </div>
</asp:Content>

