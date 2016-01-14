<%@ Page Title="" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="yourClass.aspx.cs" Inherits="YourProject.yourClass" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentBody" runat="server">
    <%--Changes the header subtitle in the Master's header section--%>
    <script>
        headSubtitle.innerText = "YourTitle";
    </script>
    <fieldset>
        <legend>YourSubTitle</legend>
        <asp:ValidationSummary runat="server" ValidationGroup="Valid1" />
        <div>
            <div>
                <%--SWOD ID--%>
                <asp:Label AssociatedControlID="txtParam2" runat="server" Text="Param2 Text"></asp:Label>
                <asp:TextBox ID="txtParam2" runat="server" ></asp:TextBox>
                <asp:RegularExpressionValidator ID="REV_Valid" runat="server"
                    ControlToValidate="txtParam2" Display="None"
                    ErrorMessage="Invalid"
                    ValidationExpression="Some Expression"
                    ValidationGroup="Valid1"></asp:RegularExpressionValidator>
                &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  
                <%--Web URL--%>
                <asp:Label AssociatedControlID="txtParam3" runat="server" Text="Param3 Text"></asp:Label>
                <asp:TextBox ID="txtParam3" runat="server"></asp:TextBox>

            </div>
            <br />
            <div>
                <asp:Button ID="BtnQuery" runat="server" Text="Query" UseSubmitBehavior="true"
                    OnClick="BtnQuery_Click" ValidationGroup="Valid1" />
            </div>
        </div>
    </fieldset>
    <br />
    <br />
   <%-- Grid View--%>
    <asp:GridView ID="gv_Data" runat="server" DataSourceID="SqlDataSource1" Visible="false" AutoGenerateColumns="false" EmptyDataText="No Results" BackColor="White" BorderColor="#999999" BorderStyle="Solid" BorderWidth="1px" CellPadding="3" ForeColor="Black" GridLines="Vertical" Width="100%" AllowSorting="True" RowStyle-Wrap="true">
        <AlternatingRowStyle BackColor="#CCCCCC" />
        <FooterStyle BackColor="#CCCCCC" />
        <HeaderStyle BackColor="Black" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
        <SelectedRowStyle BackColor="#000099" Font-Bold="True" ForeColor="White" />
        <SortedAscendingCellStyle BackColor="#F1F1F1" />
        <SortedAscendingHeaderStyle BackColor="#808080" />
        <SortedDescendingCellStyle BackColor="#CAC9C9" />
        <SortedDescendingHeaderStyle BackColor="#383838" />
        <Columns>
            <asp:BoundField DataField="Data1" HeaderText="Data1 Title" SortExpression="Data1" ItemStyle-Width="27%" />
            <asp:BoundField DataField="Data2" HeaderText="Data2 Title" SortExpression="Data2" ItemStyle-Width="30%"/>
            <asp:BoundField DataField="Data3" HeaderText="Data3 Title" SortExpression="Data3"  ItemStyle-Width="27%"/>
            <asp:BoundField DataField="Data4" HeaderText="Data4 Title" SortExpression="Data4" ItemStyle-Width="5%" />
            <asp:BoundField DataField="Data5" HeaderText="Data5 Title" SortExpression="Data5" ItemStyle-Width="5%" />
        </Columns>
    </asp:GridView>
    <asp:Label ID="lblParam1" style="display: none;" runat="server"></asp:Label>
   <%-- SQL Data Source--%>
    <asp:SqlDataSource CancelSelectOnNullParameter="false" ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:YouConnectionString %>" SelectCommand="Your Stored Procedure" SelectCommandType="StoredProcedure">
        <SelectParameters>
            <asp:ControlParameter ControlID="lblParam1" Name="Param1" PropertyName="Text" Type="String"/>
            <asp:ControlParameter ControlID="txtParam2" Name="Param2" PropertyName="Text" Type="String" />
            <asp:ControlParameter ControlID="txtParam3" Name="Param3" PropertyName="Text" Type="String" />
        </SelectParameters>
    </asp:SqlDataSource>
     <p><a href="Default.aspx">&lt; Back to Home</a></p>
</asp:Content>
