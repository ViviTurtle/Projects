<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Logon.aspx.cs" Inherits="WebApplication5.WebForm3" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Log In</h1>
    <p class="span9 offset1">The Information Security club does not claim any damage caused by this website. This module is to be used simply for education purposes. By using this site you are abiding by these conditions and will not in anyway use the module for malicious use</p>

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
     <div class="span6 offset1">
<table class="extra_edit">
     <tr><td> </td>
         <td><asp:Label runat="server" Text="Please Login in order to use the BreakMe Practices" Font-Bold="true" ></asp:Label></td>
         <td></td>
   <tr>
      <td>Student ID:</td>
      <td><input id="txtUserName" type="text" runat="server"></td>
      <td><ASP:RequiredFieldValidator ControlToValidate="txtUserName"
           Display="Static" ErrorMessage="*" runat="server" 
           ID="vUserName" /></td>
   </tr>
   <tr>
      <td>Passphrase:</td>
      <td><input id="txtUserPass" type="password" runat="server"></td>
      <td><ASP:RequiredFieldValidator ControlToValidate="txtUserPass"
          Display="Static" ErrorMessage="*" runat="server" 
          ID="vUserPass" />
      </td>
   </tr>
   
    <tr>
      <td>Remember Me? </td>
      <td><ASP:CheckBox id="chkPersistCookie" runat="server" autopostback="false" /></td>
      <td></td>
   </tr>
     <tr>
      <td></td>
      <td><input type="submit" Value="Log in" runat="server" ID="cmdLogin"><p></p>
<asp:Label id="lblMsg" ForeColor="red" Font-Name="Verdana" Font-Size="10" runat="server" /></td>
      <td>
      </td>
   </tr>
     <tr>
      <td></td>
      <td><a href="Register.aspx">Need to Register? Click here!</a></td>
      <td>
      </td>
   </tr>
   
</table>
         </div>


</asp:Content>

