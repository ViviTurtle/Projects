<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="WebApplication5.WebForm2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <asp:Image ID="Banner" ImageUrl="~/images/10582969_10203971090171936_1600147872448650832_o.jpg" runat="server" Height="140" Width="600" />
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
                "Please Doctor, Don't SQL inject me" on 10/16
            </p>
            <br />
            <p>
                Cyber Collegiate Cyber Defense Season starts. We are in need of people interested in System/Network Adminstration. Please contact Anthony.Langga@sjsu.edu.
            </p>
            <br />
            <p>
                In search for a new T-shirt design, or a self-created spartan logo to update our current. Please submit your designs to sjsu.infosec@gmail.com
            </p>
            <br />
            <p>
                If you have a blog post you want to share, please send me an email Anthony.Langga@sjsu.edu
            </p>
        </div>
        <div class="coolbox">
            <h1>Social media</h1>
            <script type="text/javascript">

           

            </script>


            <%--<li>--%>
            <asp:ImageButton ID="ImageButton1" runat="server" OnClick="redirect_fb" ImageUrl="~/images/facebook_icon.png" Height="32" Width="32" />
            <%--</li>--%>
                 
                &nbsp;
                <%--<li>--%>
            <asp:ImageButton ID="ImageButton2" runat="server" OnClick="redirect_gh" ImageUrl="~/images/GitHub-Mark-64px.png" Height="32" Width="32" />
            <%--</li>--%>
                 &nbsp;
                    <asp:ImageButton ID="ImageButton3" runat="server" OnClick="redirect_li" ImageUrl="~/images/LinkedIn_logo_initials.png" Height="32" Width="32" />


        </div>
    </div>

    <div class="span6 offset1">
        <h2>InfoSec Blog Posts</h2>

        <div class="align_left hotbox">
            <%--THE HACKERS WEAPON--%>
            <h5>Friday, May 9, 2014</h5>
            <h3>The Hacker's Weapon</h3>
            <div class="separator" style="clear: both; text-align: center;">
                <a href="http://1.bp.blogspot.com/-xRI_dkVRFk4/U23DPtaDDpI/AAAAAAAABlA/1sxWG63swr0/s1600/terms-superman-357-thor-vs-superman-98-superman-vs-thor-97-superman.jpg" imageanchor="1" style="clear: left; float: left; margin-bottom: 1em; margin-right: 1em;">
                    <img border="0" src="http://1.bp.blogspot.com/-xRI_dkVRFk4/U23DPtaDDpI/AAAAAAAABlA/1sxWG63swr0/s1600/terms-superman-357-thor-vs-superman-98-superman-vs-thor-97-superman.jpg" height="146" width="200" /></a>
            </div>
            With every superhero, comes a weapon of choice. Batman has his bat tools; Superman has super-human strength, and Thor has the Mjolnir, a hammer forged in Asgard by the command of Odin. The hacker, the underground hero with the power to manipulate any of the world's technology to his/her will, also has his/her own set of tools. Whether they're reverse engineering, compromising servers, or simply sniffing networks, the hacker has a different tool for each.<br />
            <br />
            <br />
            <a href="http://4.bp.blogspot.com/-N7zfN3qGgBc/U23DMzmG3VI/AAAAAAAABkw/DERZmF_7Vdw/s1600/IdaPro.jpg" imageanchor="1" style="clear: right; float: right; margin-bottom: 1em; margin-left: 1em;">
                <img border="0" src="http://4.bp.blogspot.com/-N7zfN3qGgBc/U23DMzmG3VI/AAAAAAAABkw/DERZmF_7Vdw/s1600/IdaPro.jpg" height="111" width="200" /></a>If the hacker wanted to reverse engineer a program to create exploits, it would not be uncommon&nbsp; for him/her to use IdaPro. According to their website, IdaPro is an "i<span class="textunderline">nteractive</span>,
          <span class="textunderline"><a href="https://www.hex-rays.com/products/ida/tech/idc.shtml">programmable</a></span>,
          <span class="textunderline">extendible</span>,
          <span class="textunderline"><a href="https://www.hex-rays.com/products/ida/processors.shtml">multi-processor</a></span>
            disassembler
          hosted on Windows, Linux, or Mac OS X." IdaPro has become one of the most standard programs in the Information Security world. Not only that, there are many add-ons the hacker can add to simplify what used to take weeks to do in a few seconds.<br />
            <br />
            <a href="http://3.bp.blogspot.com/-zPAL5vy27J0/U23DLozM2vI/AAAAAAAABko/KBcAUKyDX7E/s1600/metasploit_logo-300x73.png" imageanchor="1" style="clear: left; float: left; margin-bottom: 1em; margin-right: 1em;">
                <img border="0" src="http://3.bp.blogspot.com/-zPAL5vy27J0/U23DLozM2vI/AAAAAAAABko/KBcAUKyDX7E/s1600/metasploit_logo-300x73.png" height="48" width="200" /></a>One of the most important tools every hacker will use is Metasploit. According to Metasploit, Metasploit is the "World's most used penetrating testing software." This is not an understatement. Metasploit is a collection of existing exploits used against vulnerabilities in a server. You can say this is the hacker's utility belt that carries all his/her tools for combat. The hacker can also create any other exploit he wants and add it to his collection. When penetration testing, one of the first things a hacker will do is pull out this software.<br />
            <br />
            <a href="http://1.bp.blogspot.com/-78T7bdAJHMc/U23DOO7WXmI/AAAAAAAABk4/eIAPF9uqzcA/s1600/6a00e008d95770883400e54f354d4b8834-800wi.jpg" imageanchor="1" style="clear: right; float: right; margin-bottom: 1em; margin-left: 1em;">
                <img border="0" src="http://1.bp.blogspot.com/-78T7bdAJHMc/U23DOO7WXmI/AAAAAAAABk4/eIAPF9uqzcA/s1600/6a00e008d95770883400e54f354d4b8834-800wi.jpg" height="67" width="200" /></a>Lastly, if the hacker wanted to sniff through network packets, it would be fairly common to see him/her using Wireshark.<i>&nbsp; </i>According to their website, "<span class="st"><i>Wireshark</i> is a network protocol analyzer for Unix and Windows." Wireshark is one of the world's most used tools because if its simplicity, flexibility, and community. It is a GUI based network sniffer and is fairly simple to use.</span><br />
            <br />
            <span class="st">Now that you know some of the tools of the hacker, you too can join the war in the Information Security world. Will you also become a superhero? Maybe even a super villain? Train your combat skills and prepare yourself for the worst. See you in the battlefield. </span>
            <br />
            <span class="st">
                <br />
            </span>
            <br />
            <div id="export-html">
                <div class="mla7">
                    <div class="hang">
                        "Download." <i>Wireshark · Go Deep.</i> N.p., n.d. Web. 10 May 2014.                   
                    </div>
                    <div class="hang">
                        "Geek-Prime Homepage - Geek Prime." <i>Geek Prime</i>. N.p., n.d. Web. 10 May 2014.                   
                    </div>
                    <div class="hang">
                        "Mjolnir." <i>Marvel Universe Wiki RSS</i>. N.p., n.d. Web. 10 May 2014.                   
                    </div>
                    <div class="hang">
                        "Our Product." <i>IDA: Overview</i>. N.p., n.d. Web. 10 May 2014.                   
                    </div>
                    <div class="hang">
                        "Penetration Testing Software, Pen Testing Security | Metasploit." <i>Metasploit</i>. N.p., n.d. Web. 09 May 2014.                   
                    </div>
                </div>
            </div>

            <br />
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:HyperLink ID="HyperLink4" runat="server" NavigateUrl="http://anthonylangga.blogspot.com/"> - CTF Lead: Anthony Langga</asp:HyperLink>
        </div>
        <br />
        <br />


        <%--  CTF COMPETITIONS--%>
        <div class="align_left hotbox">
            <h5>Wednesday, May 7, 2014</h5>
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
        <br />
        <br />

      


        <%--   TECH BLOGS TO FOLLOW--%>
        <div class="align_left hotbox">
            <h5>Tuesday, April 1, 2014</h5>
            <h3>Tech Blogs we must follow</h3>
            <a href="http://4.bp.blogspot.com/-4EkEm8WXaGc/Uzp8DfFf5RI/AAAAAAAABi4/x8NWvx1LAuc/s1600/Google-Logo.gif" imageanchor="1" style="clear: left; float: left; margin-bottom: 1em; margin-right: 1em;">
                <img border="0" src="http://4.bp.blogspot.com/-4EkEm8WXaGc/Uzp8DfFf5RI/AAAAAAAABi4/x8NWvx1LAuc/s1600/Google-Logo.gif" height="141" width="200" /></a>Over the course of developing your technical skills, you will come across a wide variety of blogs. Most of it is thanks to Google, the programmer and a hacker's most useful tool. Whether it's looking up how to configure your first web server or learning what a "Segmentation fault" is; Google has always been the techy's best friend. As a result, Google will sometimes lead you to a couple of technical blogs. From a programmer and Information Security aspect, I would like to share with you some of the few blogs I follow.<br />
            <br />
            The first is <a href="http://openmymind.net/">Karl Seguin</a>. He is a jack of many trades and his blog posts consists of poetry, to programming, to information security. Not only are they informal, but they do provide some interesting insight and opinions. It differs well from other blogs, because it's not a tutorial blog or a recent news blog. It's a blog about his inner thoughts and experiences in the technical world. If you're looking for someone interesting to follow, while not being bored by formal writing, Karl Seguin is the man to go to.<br />
            <br />
            The second I would like to show you is <a href="http://colesec.inventedtheinternet.com/">ColeSec Security</a>. His blogs consists of very basic cyber-security tutorials. There is no doubt to in my mind, that his blog is one of the very few blogs that translate complicated information security terms, into something noobies can comprehend. It is one of the first blogs I followed and it helped me get started in the field. If you're new to the InfoSec field, I would definitely recommend looking at a few of his blogs.<br />
            <br />
            <a href="http://1.bp.blogspot.com/-ffUx-S-tbI4/Uzp8FW2o2dI/AAAAAAAABjA/YuyCTd20T6M/s1600/ie8.png" imageanchor="1" style="clear: right; float: right; margin-bottom: 1em; margin-left: 1em;">
                <img border="0" src="http://1.bp.blogspot.com/-ffUx-S-tbI4/Uzp8FW2o2dI/AAAAAAAABjA/YuyCTd20T6M/s1600/ie8.png" height="241" width="320" /></a>The last is <a href="http://blog.commandlinekungfu.com/">Command Line Kung Fu</a>. This blog consist of different people whom are masters in their own operating system whether its Windows or Linux. The blog, although hard to follow for new people, give some of the best shortcuts one can use in the field. I was actually was able to learn directly from Hal Pomeranz and he was able to do some very interesting Computer Forensics challenges quite quickly with just the command line. For example, some commands include a bash script that converts a Windows document to a Linux document or even more complicated commands like creating a script that monitors the network. The blog proves that all the programs you need, can be accomplished with just a few lines of code, if done right.<br />
            <br />
            Because of the lack of resources in the Information Security Field, I hope that the increase of popularity in technical blogs fill in the empty shelves of our technical library. Throughout the course of time, technical blogs will have the ability to be a great influence to technology and our engineers. Eventually, the next generation will be able to lead the Information Security and Software Engineering fields with the help of the library many of us created.<br />
            <br />
            <div id="export-html">
                <div class="mla7">
                    <div class="hang">
                        "Google." <i>Google</i>. N.p., n.d. Web. 01 April 2014.
                    </div>
                    <div class="hang">
                    </div>
                    <div class="hang">
                        Pomeranz, Hal, Tim Medin, Ed Skoudis, and Pauk Asadoorian. "Command Line Kung Fu." <i>Command Line Kung Fu</i>. Google, n.d. Web. 01 April 2014.                   
                    </div>
                    <div class="hang">
                    </div>
                </div>
            </div>
            <br />
            <br />
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:HyperLink ID="HyperLink3" runat="server" NavigateUrl="http://anthonylangga.blogspot.com/"> - CTF Lead: Anthony Langga</asp:HyperLink>
        </div>
        <br />
        <br />

        <%--  PORTS OF CYBER_SECURITY--%>
        <div class="align_left hotbox">
            <h5>Tuesday, March 11, 2014</h5>
            <h3>The Ports of Cyber-Security</h3>
            <a href="http://1.bp.blogspot.com/-5VoDMQUOjuw/Ux7PAWN0d7I/AAAAAAAABiE/ddJnKSEZ4Hs/s1600/header-logo.png" style="clear: left; float: left; margin-bottom: 1em; margin-right: 1em;">
                <img border="0" src="http://1.bp.blogspot.com/-5VoDMQUOjuw/Ux7PAWN0d7I/AAAAAAAABiE/ddJnKSEZ4Hs/s1600/header-logo.png" height="200" width="200" /></a>From my experience there are many paths to learn the cyber-security field. Some are lucky and are taught to use Linux by their parents. Others have the opportunity to be coached in middle school, high school, and college levels for competitions such as Cyber Patriots and the National Cyber-Collegiate Competitions. Sadly, most people are taught after college graduation; when they get a job in system administration.&nbsp; Because of our lack of attention to the Cyber-Security realm many of our networks, systems, and applications are insecure. As such, we should be targeting this field at earlier levels such as elementary school. If you're reading this you are probably already an expert in the field or barely starting. If you're in the latter there are a few things tips that will guide you in the field.<br />
            <br />
            <div class="separator" style="clear: both; text-align: center;">
                <a href="http://4.bp.blogspot.com/-29_5U9Kpl4o/Ux7PFJFKJhI/AAAAAAAABiU/cjGtBJ6THQk/s1600/InfoSec+Banner.jpg" style="clear: right; float: right; margin-bottom: 1em; margin-left: 1em;">
                    <img border="0" src="http://4.bp.blogspot.com/-29_5U9Kpl4o/Ux7PFJFKJhI/AAAAAAAABiU/cjGtBJ6THQk/s1600/InfoSec+Banner.jpg" height="133" width="200" /></a>
            </div>
            First, is to join a society or club. The field itself has one of the largest learning curves than any other field. Joining a club or society will give you a resource to translate complicated concepts to simpler terms. To name a few clubs: San Jose State University's Information Security Club, Cal-Poly's SWIFT, and Carnegie Mellon University's Plaid Parliament of Pwning (PPP).<br />
            <br />
            <a href="http://4.bp.blogspot.com/-WtKjlWsl3IM/Ux7Po6C3NmI/AAAAAAAABik/sq47ah-ZL2s/s1600/Defcon-logo.jpg" style="clear: left; float: left; margin-bottom: 1em; margin-right: 1em;">
                <img border="0" src="http://4.bp.blogspot.com/-WtKjlWsl3IM/Ux7Po6C3NmI/AAAAAAAABik/sq47ah-ZL2s/s1600/Defcon-logo.jpg" height="150" width="200" /></a>Second, is to attend professional conferences. There are many professional meetings for cyber-security. These give you a gateway to the field and one of the best networks you can have. Like any other field, these meetings have some of the most well-known innovators in the field, as well as some of the the best events. Some meetings are cheap like Defcon and B-Sides and some are expensive like Blackhat and the RSA conferences.<br />
            <br />
            Third, is to choose your path. The field is very vast and complicated. Some of the branches are, Exploit Mitigation, Reverse Engineering, Penetration Testing, and Computer Forensics. Within these branches are many smaller branches that one can specialize in.
            <br />
            <br />
            Lastly, of course is to continue studying on your own. Information security is a very dynamic field. Things are always changing. Using your networks and Google-Fu skills, you can find many resources online to learn the field. Most of it is very hard to find, but it they exists. Some examples are SecurityTube.net, Hackthissite.org, and YouTube's Hak5.
            <br />
            <br />
            Be prepared to struggle in the field. It's a long and hard path, but the skill set you learn in this field is irreplaceable and always wanted. For every engineer, you need a security expert to match it. We have many engineers in school and in the field, yet we have barely any cyber-security experts.<br />
            <br />
            "DEF CON Hacking Conference." <i>DEF CON® Hacking Conference</i>. N.p., n.d. Web. 011 March 2014. 
            <br />
            <br />
            <br />
            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:HyperLink ID="HyperLink2" runat="server" NavigateUrl="http://anthonylangga.blogspot.com/"> - CTF Lead: Anthony Langga</asp:HyperLink>
        </div>



    </div>



</asp:Content>
