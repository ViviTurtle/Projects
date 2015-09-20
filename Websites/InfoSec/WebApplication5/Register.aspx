<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="WebApplication5.Vulnerable3" %>



<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Register</h1>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <style>
        .title {
            font-size: 15px;
            font-weight: bold;
        }

        .auto-style1 {
            width: 265px;
        }

        .red {
            color: red;
        }

       
        .radioButtonList {
            list-style: none;
            margin: 0;
            padding: 0;
        }

            .radioButtonList.horizontal li {
                display: inline;
            }

            .radioButtonList label {
                display: inline;
            }

        
    </style>
    <div class="span6">

        <asp:Label ID="Label1" runat="server" CssClass="title" Text="Hi guys, Please register here to join the club"></asp:Label>
        <br />
        <br />
        <table class="extra_edit">
            <tr>
                <td class="auto-style1">SJSU Student ID:
                </td>
                <td>
                    <asp:TextBox ID="tb_SID" runat="server" MaxLength="9" TextMode="Number" ></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_SID_VALIDATOR" ControlToValidate="tb_SID" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>

            </tr>
                     <tr>
                <td class="auto-style1">Create a passphrase:
                </td>
                <td>
                    <asp:TextBox ID="tb_passphrase" runat="server" TextMode="password" ></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="RequiredFieldValidator4" ControlToValidate="tb_passphrase" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>

            </tr>
               
                  
            <tr>
                <td class="auto-style1">First Name:
                </td>
                <td>
                    <asp:TextBox ID="tb_FNAME" runat="server" ></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_FNAME_VALIDATOR" ControlToValidate="tb_FNAME" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>

            </tr>
            <tr>
                <td class="auto-style1">Last Name:
                </td>
                <td>
                    <asp:TextBox ID="tb_LNAME" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_LNAME_VALIDATOR" ControlToValidate="tb_LNAME" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>

            </tr>
            <tr>
                <td class="auto-style1">Gender:
                </td>
                <td>
                    <asp:RadioButtonList ID="rb_Gender" runat="server" CssClass="radioButtonList" RepeatDirection="Horizontal">
                        <asp:ListItem Text="Male" Value="M"></asp:ListItem>
                        <asp:ListItem Text="Female" Value="F"></asp:ListItem>
                        <asp:ListItem Text="Gender-neutral" Value="N"></asp:ListItem>

                    </asp:RadioButtonList>


                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="RequiredFieldValidator1" ControlToValidate="rb_Gender" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>

            </tr>

            <tr>
                <td class="auto-style1">Phone number:
                </td>
                <td>
                    <asp:TextBox ID="tb_PHNUM" runat="server" TextMode="Phone"></asp:TextBox>
                      <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="RequiredFieldValidator2" ControlToValidate="tb_PHNUM" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>   <tr>
                <td class="auto-style1">Student Email (Must end in @sjsu.edu):
                </td>
                <td>
                    <asp:TextBox ID="tb_EMAIL" runat="server" TextMode="Email"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="RequiredFieldValidator3" ControlToValidate="tb_EMAIL" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
           

                </td>

            </tr>
            <tr>
                <td class="auto-style1">Major:
                </td>
                <td>

                    <asp:DropDownList ID="ddlMAJOR" runat="server" AppendDataBoundItems="True" DataSourceID="InfosecConnectionString" DataTextField="MAJOR" DataValueField="VALUE">
                        <asp:ListItem Text="Please Select a Major" Value="0"> </asp:ListItem>
                    </asp:DropDownList>
                    <asp:SqlDataSource ID="InfosecConnectionString" runat="server" ConnectionString="<%$ ConnectionStrings:InfoGuest %>" SelectCommand="SP_GET_MAJORS" SelectCommandType="StoredProcedure"></asp:SqlDataSource>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>

                    <asp:RequiredFieldValidator CssClass="red" ID="ddlMAJOR_VALIDATOR" InitialValue="0" ControlToValidate="ddlMAJOR" runat="server" ErrorMessage="Required"  ></asp:RequiredFieldValidator>
                </td>

            </tr>
        </table>
        <div class="g-recaptcha offset1" data-sitekey="6LfF5AUTAAAAACnlxGweotO7HMXx2kbyE-j-P9CT"></div>
        <br /> 
        
        <asp:Button ID="Button1" runat="server" Text="Submit" OnClick="register" />
        

    </div>
       <div class="span5">
            <img class="img-polaroid mobileHide" src="images/Shirt Logo2.jpg" height="480" width="300">
        </div>
</asp:Content>
