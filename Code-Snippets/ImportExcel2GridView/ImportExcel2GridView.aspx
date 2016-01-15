<%@ Page Title="" MaintainScrollPositionOnPostback="true" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="yourPage.aspx.cs" Inherits="yourProject.yourPage" %>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="ajaxToolkit" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentBody" runat="server">

    </style>

    <fieldset id="forms">
        <legend>Import Excel to GridView</legend>
        
        <%--Excel Upload--%>
        <asp:UpdatePanel runat="server" ID="UP_Forms">
            <ContentTemplate>
                <table style="width: 80%">
                    <tr>
                        <td class="Col1" style="width: 138px">
                            <%-- Form Title--%>
                            <asp:Label runat="server" Style="font-weight: bold;" ID="lblFormTitle" Text="Excel Upload"></asp:Label>
                        </td>
                    </tr>
                    <%-- File Upload--%>
                    <caption>
                        <tr>
                            <td class="Col1" style="width: 138px">
                                <asp:FileUpload ID="FileUpload1" runat="server"  />

                            </td>
                            <td>

                                <button id="btnConfirm" runat="server" causesvalidation="false">Confirm</button>

                            </td>
                        </tr>
                    
                       
                    </caption>
                </table>
                <br />
                <%--Upload Button--%>

                <asp:Button ID="btnUpload" runat="server" Text="Upload"
                    OnClick="btnUpload_Click"
                     UseSubmitBehavior="true" />
            </ContentTemplate>
            <Triggers>
                <asp:PostBackTrigger ControlID="btnUpload" />

            </Triggers>
        </asp:UpdatePanel>

    </fieldset>

    <br />
    <br />
    <asp:UpdatePanel runat="server" ID="UP_GridView">
        <ContentTemplate>
            <%-- Grid View--%>

            <asp:GridView ID="GridView1" DataKeyNames="key_id" 
                runat="server" EmptyDataText="No Results" BackColor="White" BorderColor="#999999" BorderStyle="Solid" BorderWidth="1px" 
                CellPadding="3" ForeColor="Black" GridLines="Vertical" Width="100%" AllowSorting="True" RowStyle-Wrap="true">
                <AlternatingRowStyle BackColor="#CCCCCC" />
                <FooterStyle BackColor="#CCCCCC" />
                <PagerSettings Mode="NumericFirstLast" FirstPageText="1" PreviousPageText="Previous" NextPageText="Next" />
                <HeaderStyle BackColor="#00306C" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <RowStyle Wrap="True"></RowStyle>
                <SelectedRowStyle BackColor="#000099" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#808080" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#383838" />
                <Columns>
                    <asp:BoundField DataField="key_id"  HeaderText="Key ID" />
                    <asp:BoundField DataField="Column1"  HeaderText="Column 1" />
                    <asp:BoundField DataField="Column2"  HeaderText="Column 2" />
                </Columns>
            </asp:GridView>
        </ContentTemplate>
    </asp:UpdatePanel>
</asp:Content>
