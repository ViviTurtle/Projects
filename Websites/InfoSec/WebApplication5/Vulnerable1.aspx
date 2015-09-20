<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" ValidateRequest="false" CodeBehind="Vulnerable1.aspx.cs" Inherits="WebApplication5.Vulnerable1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Cross Site Scripting Module 1</h1>
    <h3>Warning: This page is vulnerable to XSS!</h3>

    <p class="span9 offset1">The Information Security club does not claim any damage caused by this website. This module is to be used simply for education purposes. By using this site you are abiding by these conditions and will not in anyway use the module for malicious use</p>
  <br />
    
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
     
     
    <style>
        .extra_edit {
            text-align: left;
            vertical-align: top;
        }

        .text_big {
            font-size: 50px;
        }

        .left {
            text-align: left;
            
        }

        .bold {
            font-weight: bold;
        }
    </style>

    <div class="span5 offset1 left">
        <asp:Label ID="Label4" CssClass="bold" runat="server" Text="
        Please fill out the form to submit a comment
"></asp:Label>
         <a href="http://lmgtfy.com/?q=Cross+Site+Scripting+Tutorial" target="_blank"> Hint Hint?</a>
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
                    <asp:Label ID="lblComment" runat="server" Text="Comment: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox CssClass="text-left " ID="txtComment" runat="server" Height="102px" Width="250px"></asp:TextBox>
                    <asp:Label ID="Label2" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" CssClass="required" ControlToValidate="txtComment" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
        </table>
        <br />
        <asp:Button ID="Button1" runat="server" Text="Submit" />
        <br />

    </div>
    <div class="span4 offset1 left">
   
        <br />
        <br />
        <asp:Label class="text_big" ID="lblsubmitComment" Visible="false" runat="server" Text=""></asp:Label>
       
        <asp:Label class="text_big" ID="lbltest" Visible="false" runat="server" Text="-"></asp:Label>
     

    <asp:Label class="text_big" ID="lblsubmitName" Visible="false" runat="server" Text=""></asp:Label>
          
    </div>
</asp:Content>
