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

        .align_left {
            text-align: left;
        }

        .hotbox {
            background-color: #FFFFFF;
            border: 2px solid #808080;
            padding: 10px;
        }
    </style>

    <div class="span2">
        <div class="coolbox">
            <h1>Annoucements</h1>
            <p>
                Officially Launched website

            </p>
            <br />
            <p>
                Virtual Box Networking on 10/9
            </p>
            <br />
            <p>
                CCDC Season starts, Please contact Anthony.Langga@sjsu.edu if you have Sys Admin Experience or want to learn           
            </p>
            <br />
            <p>
                In search for a new T-shirt design, or a self-created spartan logo to update our current. Please submit your designs to sjsu.infosec@gmail.com
            </p>
            <br />
            <p>
                If you have a blog post you want to share, please me an email Anthony.Langga@sjsu.edu
            </p>
        </div>
        <div class="coolbox">
            <h1>Social media</h1>
            <script type="text/javascript">

           

            </script>
            <ul>
                <li>
                    <asp:ImageButton ID="ImageButton1" runat="server" OnClick="redirect" ImageUrl="~/images/FB_FindUsOnFacebook-1024.png" Height="35" Width="150" />
                </li>
                <li><a href="https://www.linkedin.com/groups?home=&gid=6689971&trk=anet_ug_hm">LinkedIn</a>
                </li>

            </ul>
        </div>
    </div>

    <div class="span6 offset1">
        <h2>InfoSec Blog Posts</h2>
        <div class="align_left hotbox">
            <h5> Wednesday, May 7, 2014</h5>
            <h3>Capture the Flag Competitions</h3> 
            What is the role of Capture the Flag (CTF) competitions in the field of Information Security? Well, the field of Information Security has two sides to it: The offensive Red Team and the defensive Blue Team. The Red team, usually mislabeled as Hackers or Crackers, consists of people or groups who are trying to break the security of a computer, server, or company. It should be noted that it is not always true that the Red Team exists only for criminal activities. An example of that are Penetration Testers, InfoSec gurus whom get hired to test a company's software or servers to gain information on how to patch it.<br />
            <br />
            The other side consists of the Blue Team, the defenders of security. These guys do anything from Computer Forensics, to System Administration, to Network Sniffing. They use any means possible to prevent a server or company from being compromised. So what does this have to do with Capture the Flag?<br />
            <br />
            Capture the Flag competitions in the Information Security world are competitions that let you simulate a real world environment of Red Team vs. Blue Team. They give competitors a dynamic and engaging experience to test and learn information security skills. As most know, it is usually illegal to test your Red Team skills (such as hacking). You are however, allowed to use those skills Capture the Flag competitions. There are a variety of CTF competitions, but they usually branch to either a Jeapordy type competition or a Red Team vs. Blue Team Competition. Both give the experience to learn skills like Reverse Engineering, Exploitation, System Administration, and Network Sniffing.<br />
            <br />
            While CTF competitions are one of the most important aspects to learning the world of Information Security, it may be quite an adventure trying to look for them. They're several must know websites to follow.<br />
            <br />
            <div class="separator" style="clear: both; text-align: center;">
                <a href="http://3.bp.blogspot.com/-nX370gjvV30/U2q8KKPVtJI/AAAAAAAABkY/dMYmJ-j4UKw/s1600/CTF.png" imageanchor="1" style="clear: left; float: left; margin-bottom: 1em; margin-right: 1em;">
                    <img border="0" src="http://3.bp.blogspot.com/-nX370gjvV30/U2q8KKPVtJI/AAAAAAAABkY/dMYmJ-j4UKw/s1600/CTF.png" /></a>
            </div>
            The first is<a href="https://ctftime.org/" target="_blank"> CTF Time. </a>According to CTF Time, the site is an archive of upcoming competitions with "CTF-related info - current overall CTFs team <a href="https://ctftime.org/rating-formula/">rating</a>, per-team statistics etc." Most of the competitions listed are usually remote, as such anyone within a minute can be ready to engage in their first test of their InfoSec Skills.<br />
            <br />
            <a href="http://2.bp.blogspot.com/-b0DvYrjWZJk/U2q8IHIT5UI/AAAAAAAABkQ/594IkQQcxtk/s1600/training.jpg" imageanchor="1" style="clear: right; float: right; margin-bottom: 1em; margin-left: 1em;">
                <img border="0" src="http://2.bp.blogspot.com/-b0DvYrjWZJk/U2q8IHIT5UI/AAAAAAAABkQ/594IkQQcxtk/s1600/training.jpg" /></a>The other two are <a href="http://www.hackthissite.org/pages/index/index.php" target="_blank">Hack This Site</a> and <a href="http://io.smashthestack.org:84/" target="_blank">Smash The Stack</a>. Although these are not conventional CTF competitions, they have an archive of challenges that are similar to the ones given in an actual CTF. These are usually targeted for new people willing to learn the world of Cyber-Security.<br />
            <br />
            I hope with this information I'll get to play some of you guys in the near future. I look forward to seeing you guys at the competitions. Some last minute tips? Always feel free to google writeups of last year's competitions. For example, googling "Exploit 200 writeup" (Jeapordy style) or "DefCon Qualifiers writeup" will get you some good tutorials on some great hacks of the past. GL and HF.
            <br />
            <br />
            <br />
            <div id="export-html">
                <div class="mla7">
                    <div class="header">
                    </div>
                    <div class="hang">
                        "CTFtime.org / All about CTF." <i>CTFtime.org / All about CTF</i>. N.p., n.d. Web. 07 May 2014.&nbsp;
                    </div>
                    <div class="hang">
                    </div>
                    <div class="hang">
                        "Hack This Site!" <i>Hack This Site!</i> N.p., n.d. Web. 07 May 2014.                   
                    </div>
                </div>
            </div>
            <br />
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="http://anthonylangga.blogspot.com/"> - CTF Lead: Anthony Langga</asp:HyperLink>
        </div>
    </div>



</asp:Content>
