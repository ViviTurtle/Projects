﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true"  ValidateRequest="false" CodeBehind="Vulnerable1.aspx.cs" Inherits="WebApplication5.Vulnerable1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Warning: This page is vulnerable to XSS!</h1>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
  
    <style>

          .extra_edit {
            text-align: left;
             vertical-align:top;
        }
          .text_big
          {
              font-size: 50px;
          }

    </style>
    <div class="span5">
    <asp:Label ID="Label4" CssClass="bold" runat="server" Text="
        Please fill out the form to submit the comment
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
                    <asp:Label ID="lblComment" runat="server" Text="Comment: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox CssClass="text-left " ID="txtComment" runat="server" Height="102px" Width="265px"></asp:TextBox>
                    <asp:Label ID="Label2" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" CssClass="required" ControlToValidate="txtComment" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
        </table>
        <br />
        <asp:Button ID="Button1" runat="server" Text="Submit" />
        <br />
        <br />
       <br /><br /><br />
        <br />
        <br />

        </div>
    <div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        
        <asp:Label class="text_big" ID="lblsubmitComment" Visible="false" runat="server" Text=""></asp:Label>
        <br />
        <asp:Label class="text_big" ID="lbltest"  Visible= "false"  runat="server" Text="-"></asp:Label>
        <asp:Label class="text_big"  ID="lblsubmitName" Visible ="false" runat="server" Text=""></asp:Label>

    </div>
</asp:Content>