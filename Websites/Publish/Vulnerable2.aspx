﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" ValidateRequest="false" CodeBehind="Vulnerable2.aspx.cs" Inherits="WebApplication5.Vulnerable2" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>WARNING: THIS PAGE IS VULNERABLE TO XSS</h1>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
        <style>

          .extra_edit {
            text-align: left;
            vertical-align:top;
           
        }
          .text_big
          {
              font-size: 40px;
          }

    </style>
    <div class ="span5">
    <asp:Label ID="Label1" runat="server" Text="Please select a comment: "></asp:Label>
    <asp:DropDownList ID="ddlComments"   runat="server" AutoPostBack="true" OnSelectedIndexChanged="ddlComments_SelectedIndexChanged" ></asp:DropDownList>
         <br />
    <br />
            <br />
    <br />   <br />
    <br />
    <asp:Label ID="Label3" class="text_big" runat="server" Text=""></asp:Label>
       <br />
     <br />
        </div>
    <div class ="span5">
    Please Submit a Comment: <asp:TextBox ID="TextBox1" runat="server"> </asp:TextBox> 
    <asp:Button runat="server" Text="Submit"></asp:Button>
    <br />
    <br />
            <br />
    <br />   <br />
    <br />
          <br />
   <asp:Label class="text_big"  ID="Label2" runat="server" Text=""></asp:Label>
    <br />
    <br />
    <br />   <br />
    <br />
    <br />   <br />
    <br />
    <br />   <br />
    <br />
    <br />   <br />
    <br />
          <br />
  
        </div>
</asp:Content>
