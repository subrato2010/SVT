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
	<table width="460" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"
				height="30">
			<table cellpadding="0" cellspacing="0" border="0" width="390">
				<tr height="35">
					<td align="left" valign="middle"><font
						style="color: #EDEDED; padding-left: 20px;" width="110">For
					profile</font></td>
					<td align="left" valign="middle" width="280">
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
			<td valign="top" align="center">
			<table width="400" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;" height="90%">
				<tr>
					<td width="50" align="center" valign="top"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;"><img
						src="../images/Logo1.gif" border="0" /></td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;"
						width="310">
					<div class="RTThanksUserId">User ID
					<div class="RTThanksUserData">@influencer #1</div>
					</div>
					</td>
					<td align="left" valign="middle"></td>
				</tr>
				<tr>
					<td width="50" align="center" valign="top"></td>
					<td align="left" valign="top"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<textarea name="" id=""
						style="width: 310px; height: 70px; background-image: none; border: 2px inset rgb(110, 113, 119); color:#717276; margin-right: 5px; padding-left: 3px; padding-top: 3px; font-size: 12px;"></textarea>
					</td>
					<td align="left" valign="top">
					<table cellspacing="0" cellpadding="0" border="0"
						style="height: 70px;">
						<tr>
							<td valign="top" align="left" class="topFirstTablehdCategoryDate">
							<div id="tweetWords" class="tweet-counter">0/140</div>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td align="left" valign="bottom" colspan="2">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="center" width="85"><img
								src="../images/Buttons/General/submitButtonOrange.gif" border="0"
								style="margin-right: 5px; cursor: pointer;"  
								onclick="parent.document.getElementById('GRButton').click();"
								onmouseover="changeImage(this,'../images/Buttons/rollover/submitButtonOrangeRollover.gif');" 
								onmouseout="changeImage(this,'../images/Buttons/General/submitButtonOrange.gif');"/></td>
							<td valign="middle" align="left" class="PotentComptOR">or</td>
							<td valign="middle" align="left" class="PotentComptDelete">DO
							NOT THANK</td>
						</tr>
					</table>
					</td>
					<td align="right" valign="bottom" width="120"><a
						onclick="parent.document.getElementById('floatingDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
						href="#" class="closeOrangeTextAlert"
						style="color: #F2A413; text-decoration: none;"> CLOSE </a></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</ui:composition>
