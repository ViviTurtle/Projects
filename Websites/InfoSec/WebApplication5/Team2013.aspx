<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" validateRequest="false" AutoEventWireup="True" CodeBehind="Team2013.aspx.cs" Inherits="WebApplication5.Team2013" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Meet the Team!</h1>
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
        <%--PRESIDENT--%>
        <div class="span9 offset1 copy copy-right">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="lblPresident" runat="server" Text="President: Anthony Langga"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="http://localhost:1440/images/Poochy.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label5" runat="server" Text="The founding president of the club, and now the CTF Lead. If you meet him, you won't know it. He is a super underground hacker with no face, although somehow has some cononection to the club. No has ever seen his face. At Defcon, he gets all the love :3"></asp:Label>


                    </td>
                </tr>
            </table>


        </div>
        <%--Vice President--%>

        <div class="span9 offset1 copy copy-right">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label12" runat="server" Text=" Vice President: Will Zegers"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/baby-squirrel.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label3" runat="server" Text=" Will Zegers is one of the founding fathers of the club. He lead the team through many challenges with his Reverse Engineering Skills. No one has seen his face after 2013."></asp:Label>
                    </td>
                </tr>
            </table>


        </div>


        <%--CTF LEAD--%>
        <div class="span9 offset1 copy copy-right">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label1" runat="server" Text="CTF Lead: Joshua Wang"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="http://localhost:1440/images/Josh.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label2" runat="server" Text="Joshua was one of the founding fathers of the club and was the club's first CTF Lead. He is now the President hoping to lead the club through many heights. He is an expert at Penetration testing because he works at some Brony Company. All the LGBT people love him, despite him not being a homosexual. We all have our doubts though. At Defcon, he apparantly likes to put condoms on everyone's bed and break people's toes.
"></asp:Label>
                    </td>
                </tr>
            </table>


        </div>

        <%--Treasurer--%>
        <div class="span9 offset1 copy copy-right">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label6" runat="server" Text="Treasurer: Too many"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="http://localhost:1440/images/Anony.png" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label7" runat="server" Text="We had too many of these guys. None stayed. "></asp:Label>
                    </td>
                </tr>
            </table>


        </div>


        <%--Public Relations--%>
        <div class="span9 offset1 copy copy-right">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label10" runat="server" Text="Public Relations: Flora Lee"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Friendly.png" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label11" runat="server" Text="She joined the club in the Spring and she quickly whipped up the club to active condition. She also did logistcal work for all our presentations. THe club wouldn't be alive without her today"></asp:Label>
                    </td>
                </tr>
            </table>


        </div>


        <%--SECRETARY--%>
        <div class="span9 offset1 copy copy-right">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label14" runat="server" Text="Secretary: Dustin Tran"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Shirt Logo.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label9" runat="server" Text="He did nothing
"></asp:Label>
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
