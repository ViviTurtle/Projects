    <%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Vulnerable4.aspx.cs" Inherits="WebApplication5.Vulnerable4"  ValidateRequest="false" EnableViewState ="false" EnableSessionState="False" EnableEventValidation="False"%>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>SQL Injection Module 2</h1>
     <p class="span9 offset1">The Information Security club does not claim any damage caused by this website. This module is to be used simply for education purposes. By using this site you are abiding by these conditions and will not in anyway use the module for malicious use</p>
    <style>
        .align_left {
            text-align: left;
            vertical-align: text-top;
        }
          .hotbox {
            background-color: #FFFFFF;
            border: 2px solid #808080;
            padding: 10px;
        }
                  .red {
            color: red;
        }
        .auto-style1 {
            width: 236px;
        }
        .bold
        {
            font-weight:bold;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <!--Inserts into the T_SURVEY Table-->
    <div class="row-fluid ">
    <p class="span9 offset1 hotbox">Mission Debriefing: The Web admin was having a bad day and accidently submitted his passwords to this form thinking it was a login page. He also somehow forgot the password to the SQL server so he can't even delete the records. You've been asked by the Club to retrieve the passwords. Good luck</p>
    <br />
           <br />
          <br />
           <br />  <br />
    <div class="span5 offset1 align_left">
        <asp:Label ID="lblTITLE" runat="server" Text="InfoSec Club Survey" class="bold"></asp:Label>
        <table>
            <tr>    
                <td class="auto-style1">Name:
                </td>
                <td>
                    <asp:TextBox ID="tbNAME" runat="server"></asp:TextBox>   <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tbNAME_VALIDATOR" ControlToValidate="tbNAME" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">How would you rate this club from 1-10?
                </td>
                <td>
                    <asp:DropDownList ID="ddlRATE" runat="server">
                        <asp:ListItem Text="Please select a rating" Value="THE CAKE WAS A LIE"></asp:ListItem>
                        <asp:ListItem Text="1" Value="1"></asp:ListItem>
                        <asp:ListItem Text="2" Value="2"></asp:ListItem>
                        <asp:ListItem Text="3" Value="3"></asp:ListItem>
                        <asp:ListItem Text="4" Value="4"></asp:ListItem>
                        <asp:ListItem Text="5" Value="5"></asp:ListItem>
                        <asp:ListItem Text="6" Value="6"></asp:ListItem>
                        <asp:ListItem Text="7" Value="7"></asp:ListItem>
                        <asp:ListItem Text="8" Value="8"></asp:ListItem>
                        <asp:ListItem Text="9" Value="9"></asp:ListItem>
                        <asp:ListItem Text="10" Value="10"></asp:ListItem>
                    </asp:DropDownList>
                       <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="ddlRATE_VALIDATOR" InitialValue="THE CAKE WAS A LIE" ControlToValidate="ddlRATE" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">What do you like the most about the club?
                </td>
                <td>
                    <asp:TextBox ID="tbFAVORITE" runat="server" Height="137px" Width="205px"></asp:TextBox>
                       <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tbFAVORITE_VALIDATOR" ControlToValidate="tbFAVORITE" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">What is your least favorite thing about the club?
                </td>
                <td>
                    <asp:TextBox ID="tbLEAST" runat="server"></asp:TextBox>
                       <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tbLEAST_VALIDATOR" ControlToValidate="tbLEAST" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">Who is your favorite officer in the club?
                </td>
                <td>
                    <asp:DropDownList ID="ddlOFFICER" runat="server">
                        <asp:ListItem Text="Please Select an officer" Value="ITS A TRAP"></asp:ListItem>
                        <asp:ListItem Text="Josh Wang" Value="JOSH"></asp:ListItem>
                        <asp:ListItem Text="Anthony Langga" Value="TODD"></asp:ListItem>
                        <asp:ListItem Text="Matt Chi" Value="CHIRIO"></asp:ListItem>
                        <asp:ListItem Text="Armen Boursalian" Value="ARE MEAN"></asp:ListItem>
                        <asp:ListItem Text="Calvin Nixon" Value="CHIPMUNK"></asp:ListItem>

                    </asp:DropDownList>
                       <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="ddlOFFICER_VALIDATOR" InitialValue="ITS A TRAP" ControlToValidate="ddlOFFICER" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">Why?
                </td>
                <td>
                    <asp:TextBox ID="tbWHY" runat="server" Height="130px" Width="207px"></asp:TextBox>
                       <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tbWHY_VALIDATOR" ControlToValidate="tbWHY" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>

        </table>
        <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="insertData" />

    </div>
    <div class="span4">
          <br />
          <br />
          <br />  <br />
           <br />  <br />
        <asp:Image ID="Image1"  CssClass="img-polaroid" runat="server" ImageUrl="~/images/golden_sparkly_panda_forest_by_azurespiritwolf-d3b3unr.png" AlternateText="Golden Sparkly Panda Forest by azurespiritwolf" Height="350" Width="400" />
    </div>
        </div>
</asp:Content>
