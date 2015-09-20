<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Account.aspx.cs" Inherits="WebApplication5.Account" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1>Account</h1>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <style>
        .required {
        }

        .auto-style1 {
            width: 112px;
        }



        .required {
            color: red;
        }

        .bold {
            font-weight: bold;
        }
    </style>


    <div class="span5 offset1">
        <asp:Label ID="Label4" CssClass="bold" runat="server" Text="Please make sure your security questions are set
"></asp:Label>
        <br />
        <br />
        <table class="extra_edit">

            <tr>
                <td class="auto-style1">
                    <asp:Label ID="lbl_FName_Text" runat="server" Text="First Name: "></asp:Label>
                </td>
                <td>

                    <asp:Label ID="lbl_Name_Value" runat="server"></asp:Label>
                </td>
            </tr>
             <tr>
                <td class="auto-style1">
                    <asp:Label ID="lbl_LName_Text" runat="server" Text="Last Name: "></asp:Label>
                </td>
                <td>

                    <asp:Label ID="lbl_LName_Value" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:Label ID="lbl_Gender" runat="server" Text="Gender: "></asp:Label>
                </td>
                <td>
               <asp:DropDownList ID="ddlGender" runat="server">
                   <asp:ListItem Text="Male" Value="M"></asp:ListItem>
                   <asp:ListItem Text="Female" Value="F"></asp:ListItem>
                   <asp:ListItem Text="Gender-Neutral" Value="N"></asp:ListItem>
               </asp:DropDownList>
                </td>
            </tr>
              <tr>
                <td class="auto-style1">
                    <asp:Label ID="lbl_Phone" runat="server" Text="Phone Number: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="tb_Phone" runat="server"></asp:TextBox>
                    <asp:Label ID="Label5" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" CssClass="required" ControlToValidate="tb_Phone" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:Label ID="lblEmail" runat="server" Text="Preferred Email: "></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="tb_EMail" runat="server"></asp:TextBox>
                    <asp:Label ID="Label3" ForeColor="red" runat="server" Text="*"></asp:Label>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" CssClass="required" ControlToValidate="tb_Email" runat="server" ErrorMessage="Required"></asp:RequiredFieldValidator>
                </td>
            </tr>
          <tr>
                <td class="auto-style1">
                    <asp:Label ID="Label1" runat="server" Text="Major: "></asp:Label>
                </td>
                <td>
               <asp:DropDownList ID="ddl_Major" runat="server" DataSourceID="SqlDataSource1_Major" DataTextField="MAJOR" DataValueField="VALUE">
                 
               </asp:DropDownList>
                    <asp:SqlDataSource ID="SqlDataSource1_Major" runat="server" ConnectionString="<%$ ConnectionStrings:InfoGuest %>" SelectCommand="SP_GET_MAJORS" SelectCommandType="StoredProcedure"></asp:SqlDataSource>
                </td>
            </tr>
        </table>
      
        <asp:Button ID="Button1" runat="server" Text="Submit" />

    </div>

    <div class="span5">
        
    </div>



</asp:Content>
