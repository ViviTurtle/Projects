<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Vulnerable3.aspx.cs" Inherits="WebApplication5.Vulnerable31" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>SQL Injection Module 1</h1>
     <p class="span9 offset1">The Information Security club does not claim any damage caused by this website. This module is to be used simply for education purposes. By using this site you are abiding by these conditions and will not in anyway use the module for malicious use</p>
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <style>
        .title {
            font-size: 15px;
            font-weight: bold;
        }
     
        .auto-style1 {
            width: 265px;
        }

        .red {
            color: red;
        }

        .extra_edit {
            text-align: left;
            vertical-align: top;
        }
        .auto-style2 {
            width: 112px;
        }
    </style>
    <div class="span6 offset1">
         <asp:UpdatePanel runat="server">
        <ContentTemplate>
        <asp:Image ID="Image1" runat="server"  ImageUrl="~/images/error.jpg" Visible="false"/>
        <asp:Label ID="Label1" runat="server" CssClass="title" Text="Hi guys, Please register to join this module"></asp:Label>
        <br />
        <br />
        <table class="extra_edit">
               <tr>
                <td class="auto-style2">Username:
                </td>
                <td>
                    <asp:TextBox ID="tb_USRNAME" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="RequiredFieldValidator1" ControlToValidate="tb_USRNAME" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>

            </tr>
                          <tr>
                <td class="auto-style1"> Password:
                </td>
                <td>
                    <asp:TextBox ID="tb_PASSWORD" UseSystemPasswordChar="*" runat="server"></asp:TextBox>
                </td>

            </tr>
            <tr>
                <td class="auto-style2">First Name:
                </td>
                <td>
                    <asp:TextBox ID="tb_FNAME" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_FNAME_VALIDATOR" ControlToValidate="tb_FNAME" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>

            </tr>
            <tr>
                <td class="auto-style2">Last Name:
                </td>
                <td>
                    <asp:TextBox ID="tb_LNAME" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_LNAME_VALIDATOR" ControlToValidate="tb_LNAME" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>

                </td>

            </tr>
            <tr>
                <td class="auto-style2">Student ID:
                </td>
                <td>
                    <asp:TextBox ID="tb_SID" runat="server" MaxLength="9"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_SID_VALIDATOR" ControlToValidate="tb_SID" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>

            </tr>
            <tr>
                <td class="auto-style2">Phone number:
                </td>
                <td>
                    <asp:TextBox ID="tb_PHNUM" runat="server" MaxLength="10" ></asp:TextBox>

                </td>

            </tr>
            <tr>
                <td class="auto-style2">Email:
                </td>
                <td>
                    <asp:TextBox ID="tb_EMAIL" runat="server"></asp:TextBox>

                </td>

            </tr>
            <tr>
                <td class="auto-style2">Major:
                </td>
                <td>

                    <asp:DropDownList ID="ddlMAJOR" runat="server"  AppendDataBoundItems="True" DataSourceID="InfosecConnectionString" DataTextField="MAJOR" DataValueField="VALUE">
                        <asp:ListItem Text="Please Select a Major" Value="0"> </asp:ListItem>
                    </asp:DropDownList>
                    <asp:SqlDataSource ID="InfosecConnectionString" runat="server" ConnectionString="<%$ ConnectionStrings:InfosecConnectionString %>" SelectCommand="SP_GET_MAJORS" SelectCommandType="StoredProcedure"></asp:SqlDataSource>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                 
                    <asp:RequiredFieldValidator CssClass="red" ID="ddlMAJOR_VALIDATOR" InitialValue="0" ControlToValidate="ddlMAJOR" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>

            </tr>
        </table>
        <asp:Button ID="Button1" runat="server" Text="Register" />
        </ContentTemplate>
    </asp:UpdatePanel>
    </div>

    <asp:UpdatePanel runat="server">
        <ContentTemplate>
            <asp:Panel DefaultButton="Button2" runat="server">
      <div class ="span5">
          <asp:Image ID="Image2" runat="server" ImageUrl="~/images/error.jpg"  Visible="false"/>
          <asp:Label ID="Label2" runat="server" CssClass="title" Text="You can also Log In to use this module"></asp:Label>
        <br />
        <br />
        <table class="extra_edit">
               <tr>
                <td class="auto-style1"> Username:
                </td>
                <td>
                    <asp:TextBox ID="tb_USERNAME2" runat="server"></asp:TextBox>
                </td>

            </tr>
                     <tr>
                <td class="auto-style1"> Password:
                </td>
                <td>
                    <asp:TextBox ID="tb_PASSWORD2" PasswordChar ="*"  runat="server"></asp:TextBox>
                </td>

            </tr>
            </table>
          <asp:Button ID="Button2" runat="server" Text="Log in" CausesValidation="false"  OnClick="Log_In"/>
          </div>
                 </asp:Panel>
            </ContentTemplate>
    </asp:UpdatePanel>
</asp:Content>