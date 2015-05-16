<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Resources.aspx.cs" Inherits="WebApplication5.Resources" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <h1> Tools and Resources
    </h1>
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="body" runat="server">
    <div class="span9 offset1">
           <asp:UpdatePanel runat="server">
        <ContentTemplate>
            Operating System: &nbsp;
    <asp:DropDownList ID="ddlOS" runat="server" OnSelectedIndexChanged="rebind" AutoPostBack="true" Height="29px" Width="259px">

        <asp:ListItem Text="Please Select an Operating System" Value="0"></asp:ListItem>
        <asp:ListItem Text="Any" Value="Any"></asp:ListItem>
        <asp:ListItem Text="Linux" Value="Linux"></asp:ListItem>
        <asp:ListItem Text="Mac" Value="Mac"></asp:ListItem>
        <asp:ListItem Text="Windows" Value="Windows"></asp:ListItem>
    </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;
    
     Category: &nbsp;
    <asp:DropDownList ID="ddlCATEGORY" runat="server" OnSelectedIndexChanged="rebind" AutoPostBack="true">
        <asp:ListItem Text="Please Select a Category" Value="0"></asp:ListItem>
        <asp:ListItem Text="Any" Value="Any"></asp:ListItem>
        <asp:ListItem Text="Cryptography" Value="Cryptography"></asp:ListItem>
        <asp:ListItem Text="Exploitation" Value="Exploitation"></asp:ListItem>
        <asp:ListItem Text="Malware Analysis" Value="Malware Analysis"></asp:ListItem>
        <asp:ListItem Text="Networking" Value="Networking"></asp:ListItem>
        <asp:ListItem Text="Reconnaissance" Value="Reconnaissance"></asp:ListItem>
        <asp:ListItem Text="Reverse Engineering" Value="Reverse Engineering"></asp:ListItem>
        <asp:ListItem Text="Web Application Penetration Testing" Value="Web Application Penetration Testing"></asp:ListItem>
    </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;
    <br />
        <br />
        <asp:GridView ID="gvRESOURCES" runat="server" AutoGenerateColumns="False" DataSourceID="dsRESOURCES" BackColor="White" BorderColor="#999999" BorderStyle="Solid" BorderWidth="1px" CellPadding="3" ForeColor="Black" GridLines="Vertical" Width="1400px" AllowSorting="True" >
            <AlternatingRowStyle BackColor="#CCCCCC" />
            <Columns>
                <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
                <asp:BoundField DataField="Category1" HeaderText="Category" SortExpression="Category1" />
                
                <asp:BoundField DataField="Operating_System1" HeaderText="Operating System" SortExpression="Operating_System1" />
                
                <asp:BoundField DataField="Description" HeaderText="Description" SortExpression="Description" />
                <asp:TemplateField>
                    <HeaderTemplate  > 
                        Link
                    </HeaderTemplate>
                    <ItemTemplate>
                        <a href='<%# Eval("Link") %>'> <%# Eval("Link") %></a>

                    </ItemTemplate>
                </asp:TemplateField>
               
              
            </Columns>
            <FooterStyle BackColor="#CCCCCC" />
            <HeaderStyle BackColor="Black" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
            <SelectedRowStyle BackColor="#000099" Font-Bold="True" ForeColor="White" />
            <SortedAscendingCellStyle BackColor="#F1F1F1" />
            <SortedAscendingHeaderStyle BackColor="#808080" />
            <SortedDescendingCellStyle BackColor="#CAC9C9" />
            <SortedDescendingHeaderStyle BackColor="#383838" />
        </asp:GridView>
           </ContentTemplate>
    </asp:UpdatePanel>
        <asp:SqlDataSource ID="dsRESOURCES" runat="server" ConnectionString="<%$ ConnectionStrings:InfoGuest %>" SelectCommand="SP_POPULATE_RESOURCES" SelectCommandType="StoredProcedure">
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlCATEGORY" Name="CATEGORY_FILTER" PropertyName="SelectedValue" Type="String" />
                <asp:ControlParameter ControlID="ddlOS" Name="OS_FILTER" PropertyName="SelectedValue" Type="String" />
            </SelectParameters>
        </asp:SqlDataSource>
    </div>
</asp:Content>
