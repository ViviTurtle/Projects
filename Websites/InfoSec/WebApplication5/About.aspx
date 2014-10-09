<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="About.aspx.cs" Inherits="WebApplication5.Home" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>SJSU: Information Security Club</h1>
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

        <div class="span6 offset1 copy copy-right">
            <div class="hotbox">
                <p>
                    <label>
                    </label>
                    <asp:Label ID="Label1" runat="server" Text="The Information Security (Infosec) Club at San José State University was founded in late 2013 by a group of aspiring computer security professionals comprised of undergraduate, graduate, and alumni students from different majors with a strong sense of mission and a shared vision to increase awareness of the current issues surrounding cyber security. To accomplish this, the Infosec Club offers opportunities for members to gain hands-on experience practicing relevant skills such as reverse engineering, forensic analysis, exploit development, toolkit creation, vulnerability discovery, code auditing, and more.
"></asp:Label>
                </p>
            </div>
        </div>

        <div class="span5">
            <img class="img-polaroid" src="images/Shirt Logo2.jpg" height="480" width="300">
        </div>


    </div>



</asp:Content>
