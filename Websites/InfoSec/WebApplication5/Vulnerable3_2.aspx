<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" ValidateRequest="false" CodeBehind="Vulnerable3_2.aspx.cs" Inherits="WebApplication5.Vulnerable3_2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>SQL Injection Module 1</h1>
     <p class="span9 offset1">The Information Security club does not claim any damage caused by this website. This module is to be used simply for education purposes. By using this site you are abiding by these conditions and will not in anyway use the module for malicious use</p>
   
    <p class="hotbox span9 offset1">I wonder what it feel's like to be an Admin</p>
 
     <div class="accordion span9 offset1" id="accordion2">
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">Hint Hint?
                </a>
            </div>
            <div id="collapseOne" class="accordion-body collapse">
                <div class="accordion-inner">
                    Look at the URL. Basic SQL injections
                </div>
            </div>

        </div>
    </div>
    <style>
         .hotbox {
            background-color: #FFFFFF;
            border: 2px solid #808080;
            padding: 10px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    <br />
    <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
    <br />
    <asp:Label ID="Label3" runat="server" Text="Label"></asp:Label>
    <br />
    <asp:Label ID="Label4" runat="server" Text="Label"></asp:Label>
    <br />
    <asp:Label ID="Label5" runat="server" Text="Label"></asp:Label>
    <br />
    <asp:Label ID="Label6" runat="server" Text="Label"></asp:Label>
    <br />
    <asp:Label ID="Label7" runat="server" Text="Label"></asp:Label>


</asp:Content>
