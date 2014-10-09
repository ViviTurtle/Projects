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
                        <script type="IN/MemberProfile" data-format="hover" data-id="http://www.linkedin.com/in/anthonylangga" data-related="false"></script>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Anthony.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label5" runat="server" Text="Anthony Langga is currently in his 4th year studying Computer Science. He is the current Web Developer and Web Admin for the club. His main skills are mainly backend Web Developement and Python scripting although his current interests include Reverse Engineering and Exploitation. He likes to practice his Social Engineering Skills so you get confused if you know him by a different name and background."></asp:Label>


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
                        <script type="IN/MemberProfile" data-format="hover" data-id="https://www.linkedin.com/in/joshwang7" data-related="false"></script>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Josh2.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label2" runat="server" Text="Josh is a 4th year undergraduate studying MIS and Computer Science. His current interests include exploiting memory corruption vulnerabilities, kernel module development and hacking embedded systems. He also has some experience pentesting for iSEC Partners. Currently, he looks forward to the release of “Blackhat” which is an upcoming cinematographic masterpiece based loosely on his life."></asp:Label>
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
                        <img class="img-polaroid" src="images/Anony.png" height="200" width="100">
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
