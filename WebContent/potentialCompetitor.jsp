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
	
	<table width="680" border="0" cellspacing="0" cellpadding="0"
		height="100%">
		<tr>
			<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"
				height="30">
			<table cellpadding="0" cellspacing="0" border="0" width="680">
				<tr height="35">
					<td align="left" valign="middle"><font
						style="color: #EDEDED; padding-left: 20px;" width="110">For
					profile</font></td>
					<td align="left" valign="middle" width="570">
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
			<table width="650" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<tr bgcolor="#F2F2F2">
					<td width="50" align="center" valign="top"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;"><img
						src="../images/Logo1.gif" border="0" /></td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptUserId">User ID
					<div class="PotentComptUserData">@influencer #1</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptFirst">First
					<div class="PotentComptFirstData">John</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptLast">Last
					<div class="PotentComptLastData">Marks</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptBrand">Brand Name
					<div class="PotentComptBrandData">Nike</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptProduct">Product
					<div class="PotentComptProductData">Shoes</div>
					</div>
					</td>
					<td align="center" valign="middle" width="250"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<table width="150" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="center" width="85"><img
								src="../images/Alert/addorangeButton.gif" border="0"
								style="margin-right: 5px; cursor: pointer;" /></td>
							<td valign="middle" align="left" class="PotentComptOR">or</td>
							<td valign="middle" align="left" class="PotentComptDelete">DELETE</td>
						</tr>
					</table>

					</td>
				</tr>
				<tr bgcolor="#F2F2F2">
					<td width="50" align="center" valign="top"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;"><img
						src="../images/Logo1.gif" border="0" /></td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptUserId">User ID
					<div class="PotentComptUserData">@influencer #1</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptFirst">First
					<div class="PotentComptFirstData">John</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptLast">Last
					<div class="PotentComptLastData">Marks</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptBrand">Brand Name
					<div class="PotentComptBrandData">Nike</div>
					</div>
					</td>
					<td align="left" valign="middle"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<div class="PotentComptProduct">Product
					<div class="PotentComptProductData">Shoes</div>
					</div>
					</td>
					<td align="center" valign="middle" width="250"
						style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
					<table width="150" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="center" width="85"><img
								src="../images/Alert/addorangeButton.gif" border="0"
								style="margin-right: 5px; cursor: pointer;" /></td>
							<td valign="middle" align="left" class="PotentComptOR">or</td>
							<td valign="middle" align="left" class="PotentComptDelete">DELETE</td>
						</tr>
					</table>

					</td>
				</tr>
				<tr>
					<td colspan="7" height="10"></td>
				</tr>
				<tr>
					<td colspan="6" align="left" valign="top" width="570"><a
						href="#"
						onclick="parent.document.getElementById('floatingDiv1').style.display='none'; parent.document.getElementById('GRButton').click(); parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';">
						<img src="../images/Alert/General/submitButtonOrange.gif" border="0" 
						onmouseover="changeImage(this,'../images/Alert/General/submitButtonOrangeRollover.gif');" 
					    onmouseout="changeImage(this,'../images/Alert/General/submitButtonOrange.gif');" />
					    </a></td>
					<td class="closeOrangeText" valign="middle" width="110"
						align="right"><a
						onclick="parent.document.getElementById('floatingDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
						href="#" class="closeOrangeTextAlert"
						style="color: #F2A413; text-decoration: none;"> CLOSE </a></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</ui:composition>
