<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="FAQ.aspx.cs" Inherits="WebApplication5.FAQ" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Frequently Asked Questions
    </h1>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <div class="span10 offset1">
        <h3>FAQ</h3>
        <div class="accordion" id="accordion2">
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">What does the club do?
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse">
                    <div class="accordion-inner">
                        This club aims to teach students and its community about Information Security, especially on the technical level. We are also a competition teach and eventually hope to compete at the national level.
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">Who can join?
                    </a>
                </div>
                <div id="collapseTwo" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Any SJSU student can join the club regardless of your experience in the field or major.
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseThree">How do I join?
                    </a>
                </div>
                <div id="collapseThree" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Contact any officer of the club or just email the club's email at sjsu.infosec@gmail.com. The best bet would be to go directly to Duncan Hall 8 ask the people there.
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#collapseFour">What type of security do you guys do?
                    </a>
                </div>
                <div id="collapseFour" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Anywhere between general IT to the Physical Layer of security such as picklocking and social engineering. We are currently focused on Reverse Engineering, although our team is interested in a broad view of the field.
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion5" href="#collapseFive">Do you guys go on trips?
                    </a>
                </div>
                <div id="collapseFive" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Yes, we try to go to Defcon together as a club and participate and learn over there. 
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion6" href="#collapseSix">I'm not a student but I want to help your club
                    </a>
                </div>
                <div id="collapseSix" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Great! We can use all the help we can get. We are currently looking for sponsors to help the club out. Feel free to email the club at sjsu.infosec@gmail.com. Thanks again, and of course general donations are always welcome.
                    </div>
                </div>
            </div>
                   <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion7" href="#collapseSeven"> When and where are the general club meeting.
                    </a>
                </div>
                <div id="collapseSeven" class="accordion-body collapse">
                    <div class="accordion-inner">
                        The club generally has meetings every Thursday at 5pm. Although because school jsut started we will be adjusting the times accordingly. We are located at Duncan Hall 8.
                    </div>
                </div>
            </div>
        </div>
               <br />
    <br />
    <br />
    <br />
</asp:Content>
