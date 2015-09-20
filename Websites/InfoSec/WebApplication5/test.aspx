<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="test.aspx.cs" Inherits="WebApplication5.test" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
   
    <script>$('#menu').slicknav({
    prependTo: '#demo1'
});</script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
   
    <div id="demo1">
          <ul id="menu">
	<li><a class="scroll" href="#features">Features</a></li>
	<li><a class="scroll" href="#usage">Usage Instructions</a></li>
	<li><a class="scroll" href="#examples">Examples</a></li>
	<li><a href="http://github.com">View on Github</a></li>
</ul>

    </div>
</asp:Content>
