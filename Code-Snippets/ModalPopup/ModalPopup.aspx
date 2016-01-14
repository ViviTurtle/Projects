<%@ Page Title="" MaintainScrollPositionOnPostback="true" Language="C#" MasterPageFile="~/master.Master" AutoEventWireup="true" CodeBehind="yourCode.aspx.cs" Inherits="yourProject.yourPage" %>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="ajaxToolkit" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentBody" runat="server">

        function openModal() {
            document.getElementById("openModal").style.opacity = "1";
            document.getElementById("openModal").style.pointerEvents = "auto";

            //$('#openModal').modal({ show: true });
        }
        function closeModal() {
            document.getElementById("openModal").style.opacity = "0";
            document.getElementById("openModal").style.pointerEvents = "none";
        }
  
    </script>
    <style>
        .modalDialog {
            position: fixed;
            font-family: Arial, Helvetica, sans-serif;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background: rgba(0,0,0,0.8);
            z-index: 99999;
            opacity: 0;
            -webkit-transition: opacity 400ms ease-in;
            -moz-transition: opacity 400ms ease-in;
            transition: opacity 400ms ease-in;
            pointer-events: none;
        }

            .modalDialog:target {
                opacity: 1;
                pointer-events: auto;
            }

        .close {
            background: #606061;
            color: #FFFFFF;
            line-height: 25px;
            position: absolute;
            right: -12px;
            text-align: center;
            top: -10px;
            width: 24px;
            text-decoration: none;
            font-weight: bold;
            -webkit-border-radius: 12px;
            -moz-border-radius: 12px;
            border-radius: 12px;
            -moz-box-shadow: 1px 1px 3px #000;
            -webkit-box-shadow: 1px 1px 3px #000;
            box-shadow: 1px 1px 3px #000;
        }

            .close:hover {
                background: #00d9ff;
            }

        .modalDialog > div {
            width: 552px;
            position: relative;
            margin: 10% auto;
            padding: 5px 20px 13px 20px;
            border-radius: 10px;
            background: #fff;
            background: -moz-linear-gradient(#fff, #999);
            background: -webkit-linear-gradient(#fff, #999);
            background: #fff;
            top: 0px;
            left: 0px;
        }

 <asp:ImageButton ID="IB_OpenModal" runat="server" CausesValidation="False" ImageUrl="~/Images/Edit.png" Height="16"
   Width="16" OnClick="IB_OpenModal_Click" />
    <asp:UpdatePanel runat="server">
        <ContentTemplate>
            <div id="openModal" class="modalDialog">
                <div>
                    <a href="#close" title="Close" class="close" id="close" onclick="closeModal()">X</a>
                    <h2>Edit Data</h2>
                    any data can be put here
        </ContentTemplate>
    </asp:UpdatePanel>




</asp:Content>
