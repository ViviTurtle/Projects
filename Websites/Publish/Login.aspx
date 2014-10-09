<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" MasterPageFile="~/Site1.Master" Inherits="WebApplication5.WebForm1" %>

<asp:Content runat="server" ContentPlaceHolderID ="head">


        <h1>Meet the Team!</h1>

</asp:Content>


<asp:Content runat="server" ContentPlaceHolderID="body">

    <asp:Login ID="Login1" DestinationPageUrl ="Home.aspx" runat="server"></asp:Login>


</asp:Content >

