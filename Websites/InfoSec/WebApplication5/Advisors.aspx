<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Advisors.aspx.cs" Inherits="WebApplication5.Advisors" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Meet our Advisors</h1>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
     <style>
        .normal {
            font-size: small;
        }

        .Name {
            font-weight: bold;
            font-size: large;
        }

        .auto-style1 {
            width: 53px;
            height: 23px;
        }

        .auto-style2 {
            height: 23px;
        }

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

        .auto-style3 {
            width: 30px;
        }

        .auto-style4 {
            width: 53px;
            height: 37px;
        }

        .auto-style5 {
            width: 30px;
            height: 37px;
        }

        .auto-style6 {
            height: 37px;
        }

       .hotbox {
            background-color: #FFFFFF;
            border: 2px solid #808080;
            padding: 10px;
        }
    </style>


    <div class="span8">
        <div></div>
 <%--Virginia--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="lblPresident" runat="server" Text="SJSU STEM Director: Virginia Lehmkuhl-Dakhwe"></asp:Label>
                     
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Virginia.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label5" runat="server" Text="Dr. Virginia Lehmkuhl-Dakhwe is the Director of the SJSU Jay Pinson STEM Education Program.  She has extensive experience developing and implementing STEM programming for k-12 and university students.  She coordinated the 2013 and 2014 USCC Western Regional Cybersecurity camps at SJSU and established the Youth STEM Network: Cyber program.  She served as the first faculty advisor for the SJSU InfoSec club and continues to support their efforts. "></asp:Label>


                    </td>
                </tr>
            </table>


        </div>
        <%--Tom Austin--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label12" runat="server" Text="SJSU Faculty: Tom Austin"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Austin.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label3" runat="server" Text="Prof. Austin earned his Master's degree from San Jose State before getting his PhD from UC Santa Cruz. He has worked with Mozilla's Research group, ESIEA Ouest's Cryptology and Operational Virology lab, and CloudFlare CDN. His interests are in web security, language-based security, and malware analysis."></asp:Label>
                    </td>
                </tr>
            </table>


        </div>



    </div>
    <div class="span2">

        <div class="coolbox">
            <h1 class="">The Other Years</h1>
            <ul>
                <li><a href="Team2014.aspx">~ Class of 2014</a>
                </li>
                <li><a href="Team2013.aspx">~ Class of 2013</a>
                </li>
            </ul>
        </div>
    </div>


</asp:Content>
