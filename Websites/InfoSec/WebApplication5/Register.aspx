<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="WebApplication5.Vulnerable3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Register</h1>
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
    </style>
    <div class="span6">

        <asp:Label ID="Label1" runat="server" CssClass="title" Text="Hi guys, Please register here to join the club"></asp:Label>
        <br />
        <br />
        <table class="extra_edit">
            <tr>
                <td class="auto-style1">First Name:
                </td>
                <td>
                    <asp:TextBox ID="tb_FNAME" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_FNAME_VALIDATOR" ControlToValidate="tb_FNAME" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>

                </td>

            </tr>
            <tr>
                <td class="auto-style1">Last Name:
                </td>
                <td>
                    <asp:TextBox ID="tb_LNAME" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_LNAME_VALIDATOR" ControlToValidate="tb_LNAME" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>

                </td>

            </tr>
            <tr>
                <td class="auto-style1">Student ID:
                </td>
                <td>
                    <asp:TextBox ID="tb_SID" runat="server"></asp:TextBox>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                    <asp:RequiredFieldValidator CssClass="red" ID="tb_SID_VALIDATOR" ControlToValidate="tb_SID" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>
                </td>

            </tr>
            <tr>
                <td class="auto-style1">Phone number:
                </td>
                <td>
                    <asp:TextBox ID="tb_PHNUM" runat="server"></asp:TextBox>

                </td>

            </tr>
            <tr>
                <td class="auto-style1">Email:
                </td>
                <td>
                    <asp:TextBox ID="tb_EMAIL" runat="server"></asp:TextBox>

                </td>

            </tr>
            <tr>
                <td class="auto-style1">MAJOR:
                </td>
                <td>

                    <asp:DropDownList ID="ddlMAJOR" runat="server"  AppendDataBoundItems="True" DataSourceID="InfosecConnectionString" DataTextField="MAJOR" DataValueField="VALUE">
                        <asp:ListItem Text="Please Select a Major" Value="0"> </asp:ListItem>
                    </asp:DropDownList>
                    <asp:SqlDataSource ID="InfosecConnectionString" runat="server" ConnectionString="<%$ ConnectionStrings:InfosecConnectionString %>" SelectCommand="SP_GET_MAJORS" SelectCommandType="StoredProcedure"></asp:SqlDataSource>
                    <asp:Label Text="* " CssClass="red" runat="server"></asp:Label>
                 
                    <asp:RequiredFieldValidator CssClass="red" ID="ddlMAJOR_VALIDATOR" InitialValue="0" ControlToValidate="ddlMAJOR" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>
                </td>

            </tr>
        </table>
        <asp:Button ID="Button1" runat="server" Text="Button" />

    </div>
</asp:Content>
