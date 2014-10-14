<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Contact.aspx.cs" Inherits="WebApplication5.Contact" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Contact</h1>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">"
    <style>
        .required {
        }

        .auto-style1 {
            width: 112px;
        }

        .extra_edit {
            text-align: left;
        }

        .required {
            color: red;
        }

        .bold {
            font-weight: bold;
        }
    </style>
    

    <div class="span5 offset1">
        <asp:Label ID="Label4" CssClass="bold" runat="server" Text="Please fill out the form below and an administrator will contact you within the next 48 hours.
"></asp:Label>
        <br />
        <br />
        <table class="extra_edit">

            <tr>
                <td class="auto-extra_edit">
                    <asp:Label ID="lblName" runat="server" Text="Name: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
                    <asp:Label ID="Label1" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="required" ID="RequiredFieldValidator1" ControlToValidate="txtName" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:Label ID="lblPhone" runat="server" Text="Phone: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtPhone" runat="server" Width="143px" Height="17px"></asp:TextBox>
                </td>
            </tr>

            <tr>
                <td class="auto-style1">
                    <asp:Label ID="lblEmail" runat="server" Text="Email: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
                    <asp:Label ID="Label3" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" CssClass="required" ControlToValidate="txtEmail" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:Label ID="lblComment" runat="server" Text="Comment: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="txtComment" runat="server" Height="102px" Width="265px"></asp:TextBox>
                    <asp:Label ID="Label2" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" CssClass="required" ControlToValidate="txtComment" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
        </table>
        <asp:Button ID="Button1" runat="server" Text="Submit" OnClick="Email" />
      
    </div>

    <div class="span5">
        <asp:Image ID="Image1" runat="server" ImageUrl="/images/Mail.png" height="300" width="300" />
    </div>

   

</asp:Content>
