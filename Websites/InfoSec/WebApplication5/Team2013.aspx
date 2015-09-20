<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" ValidateRequest="false" AutoEventWireup="True" CodeBehind="Team2013.aspx.cs" Inherits="WebApplication5.Team2013" %>

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
        .box_header {
            font-family: 'Ubuntu', Helvetica, Arial, sans-serif;
            text-align: center;
            color: #808080;
            font-weight: 700;
            font-size: 15px;
        }
    </style>


    <div class="span8">
        <div></div>
        <%--PRESIDENT--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;
                        <asp:Label Font-Bold="true" Font-Size="Larger" ID="lblPresident" runat="server" Text="President: Vivi Langga"></asp:Label>

                        <script type="IN/MemberProfile" data-id="https://www.linkedin.com/in/vivilangga" data-format="hover" data-related="false"></script>
                        <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/images/GitHub-Mark-120px-plus.png" Height="16" Width="16" OnClick="GH_ANTHONY" />
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Vivi.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label5" runat="server" Text="Vivi Langga is currently in her 4th year studying Computer Science. She is the current Web Developer and Web Admin for the club. Her main skills are mainly backend Web Developement and Python scripting although her current interests include Reverse Engineering and Exploitation. She likes to practice her Social Engineering Skills so don't get confused if you know her by a different name and background."></asp:Label>


                    </td>
                </tr>
            </table>


        </div>
        <%--Vice President--%>

        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label12" runat="server" Text=" Vice President: Will Zegers"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Shirt Logo.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label3" runat="server" Text=" Will Zegers is one of the founding fathers of the club. He lead the team through many challenges with his Reverse Engineering Skills. No one has seen his face after 2013."></asp:Label>
                    </td>
                </tr>
            </table>


        </div>


        <%--CTF LEAD--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label1" runat="server" Text="CTF Lead: Joshua Wang"></asp:Label>
                        <script type="IN/MemberProfile" data-format="hover" data-id="https://www.linkedin.com/in/joshwang7" data-related="false"></script>
                        <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/GitHub-Mark-120px-plus.png" Height="16" Width="16" OnClick="GH_JOSH" />
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
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label6" runat="server" Text="Treasurer: Too many"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Shirt Logo.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label7" runat="server" Text="Credits to Justin Tieu and Amy Kreiger for volunteering, although they couldn't stay."></asp:Label>
                    </td>
                </tr>
            </table>


        </div>


        <%--Public Relations--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label10" runat="server" Text="Public Relations: Matt Chi"></asp:Label>
                        <script type="IN/MemberProfile" data-format="hover" data-id="https://www.linkedin.com/in/mattchi" data-related="false"></script>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/matt.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label11" runat="server" Text="Matt is a 3rd year undergraduate studying Computer Science. He is also an Army ROTC cadet, and will commission as a 2nd Lieutenant upon graduation. His background includes mobile programming for both iOS and Android, system administration, and project/team management. Currently he has no focus in information security but is looking more towards network security and systems administration, while having some understanding of other fields in security."></asp:Label>
                    </td>
                </tr>
            </table>


        </div>

        <%--VP of Marketing--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label4" runat="server" Text="VP of Marketing: Flora Lee"></asp:Label>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Flora.jpg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label8" runat="server" Text="Flora Lee graduated in Spring 2014 with a Bachelor of Science degree in Business Administration with a concentration in Management Information Systems, being the first alumni of the Information Security Club in San Jose State University. She previously worked for cyber initiatives on campus including outreach programs and cyber camps where she assisted in coordinating the events. For the club, she performed logistics for all the presentations and used marketing skills to scout for potential new members. She currently works for Workopia as a consultant specializing in Microsoft Dynamics CRM."></asp:Label>
                    </td>
                </tr>
            </table>


        </div>


        <%--SECRETARY--%>
        <div class="span9 offset1 left-justify">
            <table>
                <tr>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style6">&nbsp;<asp:Label Font-Bold="true" Font-Size="Larger" ID="Label14" runat="server" Text="Secretary: Dustin Tran"></asp:Label>
                          <script type="IN/MemberProfile" data-format="hover" data-id="http://www.linkedin.com/pub/dustin-tran/52/a0a/830" data-related="false"></script>
                    </td>

                </tr>
                <tr>
                    <td>
                        <img class="img-polaroid" src="images/Dustin.jpeg" height="200" width="100">
                    </td>
                    <td class="auto-style3"></td>
                    <td>
                        <asp:Label ID="Label9" runat="server" Text="Dustin is a undergraduate student studying Software Engineering. He is currently interning at Cisco Systems, Inc. He works side by side with engineers on the ASR 9k routers. Outside of work and school, he enjoys spending a majority of his time studying security topics or gaming."></asp:Label>
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

        <div class="coolbox">
            <asp:Label runat="server" class="box_header">Meet sure to check out our Advisors</asp:Label>
            <br />
             <br />
            <ul>
                <li><a href="Advisors.aspx">The people the club couldn't be without</a>
                </li>

            </ul>
        </div>
    </div>


</asp:Content>
