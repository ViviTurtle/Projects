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
                        This club aims to teach students and our local community about Information Security, especially on a technical level. We also have a competition team that participates in numerous CTFs such as PlaidCTF, CSAW Quals, DEFCON Prelims, Codegate CTF and more. 
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
                        Any SJSU student can join the club regardless of their experience in the field or major.
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
                        Contact any officer of the club or just send us an e-mail at sjsu.infosec@gmail.com. Your best bet would be to go directly to Duncan Hall 8 during one of our meeting times and ask the people there.
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
                        We teach all aspects of computer security. We cover everything from general IT security to physical security, such as picklocking, to social engineering, and everything in between. In the past we've also given talks on exploitation and reverse engineering as well.
                        Check out our <a href="https://github.com/spartansecurity">GitHub page</a> to view past presentations given by students.
                  
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
                        Yes, we try to go to Defcon, a security conference in Las Vegas, together every year as a club and attend the talks and participate in the various events. 
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion6" href="#collapseSix">I'm not a student. Can I still help the club?
                    </a>
                </div>
                <div id="collapseSix" class="accordion-body collapse">
                    <div class="accordion-inner">
                        Great! We can use all the help we can get. We are currently looking for sponsors to help fund some of the activities our club does. Feel free to email the club at sjsu.infosec@gmail.com. Thanks again, and of course general donations are always welcome.
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
                        The club has meetings every Monday and Thursday at 4:30 pm. We are located in Duncan Hall 8.
                    </div>
                </div>
            </div>
        </div>
  </div>
</asp:Content>
