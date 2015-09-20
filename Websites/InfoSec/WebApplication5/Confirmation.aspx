<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Confirmation.aspx.cs" Inherits="WebApplication5.Confirmation" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1> Confirmation
    </h1>
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <style>
        .hotbox {
            background-color: #FFFFFF;
            border: 2px solid #808080;
            padding: 10px;
        }
    </style>
    <div class="row-fluid ">
           <p class="span9 offset1 hotbox">You email has been successfully verified. An email has been sent to an Admin to confirm you are account credentials. If you wish to change your account information please email Vivi.Langga@gmail.com. You now have access to the modules.</p>
     
    </div>
</asp:Content>
