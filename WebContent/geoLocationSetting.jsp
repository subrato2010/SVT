<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js" />
	<table width="410" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"
				height="30">
			<table cellpadding="0" cellspacing="0" border="0" width="370">
				<tr height="35">
					<td align="left" valign="middle"><font
						style="color: #EDEDED; padding-left: 20px;" width="110">For
					profile</font></td>
					<td align="left" valign="middle" width="260">
					<div class="fileinputs1" style="width: 30px; color: #7D848B;">
					<t:selectOneMenu id="profile" value="abcd" styleClass="state11"
						onchange="selectedItem('profile', 'vkprofile', this.value)">
						<f:selectItem itemValue="@Customer1" enabledClass="state11" />
						<f:selectItem itemValue="@Customer2" enabledClass="state11" />
						<f:selectItem itemValue="@Customer3" enabledClass="state11" />
						<f:selectItem itemValue="@Customer4" enabledClass="state11" />
						<f:selectItem itemValue="@Customer5" enabledClass="state11" />
						<f:selectItem itemValue="@Customer6" enabledClass="state11" />
					</t:selectOneMenu>
					<div class="alertDropDown"><input id="vkprofile" type="text"
						value="@Customer1" class="vk_text"
						style="background-color: transparent; border-width: 0px; padding-top: 2px; background-image: none; color: #7D848B; font-size: 10px; font-weight: bold;" />
					</div>
					<script>
      				selectedItem();           
                  </script></div>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td valign="top" align="left">
			<div
				style="width: 350px; height: auto; margin-top: 7px; margin-left: 30px;">
			<div id="top_geoPopup"></div>
			<div id="border_geoPopup"></div>
			<div id="body_geoPopup">
			<div id="geoTotalBody">RESULTS</div>
			<div id="geoSettingResult">Newburyport, MA</div>
			<div id="geoTotalBodyFooter">SAVE AS MY LOCATION</div>
			</div>
			<div id="border_geoPopup"></div>
			<div id="footer_geoPopup">
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td valign="bottom" align="left"><img
						src="../images/Alert/submitButtonOrange.gif" border="0"
						style="margin-right: 5px; cursor: pointer;"
						onclick="parent.document.getElementById('GRButton').click();" /></td>
					<td valign="bottom" align="right"><a
						onclick="parent.document.getElementById('floatingDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
						href="#" class="closeOrangeTextAlert"
						style="color: #F2A413; text-decoration: none;"> CLOSE </a></td>
				</tr>
			</table>
			</div>
			</div>
			</td>
		</tr>
	</table>
</ui:composition>
