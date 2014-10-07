<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="WebApplication5.WebForm2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <asp:Image ID="Banner" ImageUrl="~/images/InfoBanner2.jpg" runat="server" Height="125" Width="600" />
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">

    <style>
        .coolbox {
            background-color: #1b1b1b;
            border: 10px solid #1b1b1b;
            margin-bottom: 20px;
            padding: 0;
        }

            .coolbox h1 {
                font-size: medium;
                color: #808080;
            }
                 .coolbox p {
                font-size: small;
                color: white;
            }
               .align_left
               {
                   text-align: left;
               }
    </style>
 
    <div class="span2">
        <div class="coolbox">
            <h1>Annoucements</h1>
            <p>
                Website Under Construction

            </p>
            <br />
            <p>
                Flare-On Reverse Engineering Talk on 9/25
            </p>
        </div>
        <div class="coolbox">
            <h1>Social media</h1>
                    <ul>
                <li><a href="https://www.facebook.com/groups/725725020776252/">Facebook</a>
                </li>
                <li><a href="https://www.linkedin.com/groups?home=&gid=6689971&trk=anet_ug_hm">LinkedIn</a>
                </li>

            </ul>
        </div>
    </div>
    <div class="span6">

        <h2>InfoSec Blog Posts</h2>
        <p>

            Seriously though we need blogs here
        </p>
    </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />


    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />


</asp:Content>
