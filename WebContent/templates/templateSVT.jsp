<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:sdh="http://richfaces.org/session-data-helper"
	xmlns:a4j="http://richfaces.org/a4j">
<f:view>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="cache-control" content="no-store" />
	<title>:: netezza.terametric.com ::</title>
	<link rel="shortcut icon" href="../images/favicon.ico"
		type="image/x-icon" />
	<a4j:loadScript src="/js/ddaccordion.js" />
	<!--  a4j:loadScript src="/js/jquery.min.js" -->
	<a4j:loadScript src="/js/swfobject.js" />
	<a4j:loadScript src="/js/svt.js" />
	<a4j:loadStyle src="/style/style.css" />
	<ui:insert name="pageCSS"></ui:insert>
	<ui:insert name="pageScripts"></ui:insert>
	<script type="text/javascript">
	
	
	function closeMe(a,b){
		document.getElementById(a).style.visibility = "hidden";
		document.getElementById(b).style.visibility = "visible";
	}
	</script>

	<a4j:loadStyle src="/ddlevelsfiles/ddlevelsmenu-base.css" />
	<a4j:loadStyle src="/ddlevelsfiles/ddlevelsmenu-topbar.css" />
	<a4j:loadStyle src="/ddlevelsfiles/ddlevelsmenu-sidebar.css" />
	<a4j:loadStyle src="/ddlevelsfiles/ddlevelsmenu-topbar1.css" />

	<a4j:loadScript src="/ddlevelsfiles/ddlevelsmenu.js" />
	<!-- head inclusion option -->
	<ui:insert name="head" />

	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="-1" />
	</head>

	<body bgcolor="">

	<!--    ****************************** Page Start ***********************************-->
	<div id="page">

	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2"><!--    ******************** Header Section Start ********************************-->
			<div id="header">
			<div id="header_left">
			<table border="0">
				<tr>
					<td>
					<div id="header_left_logo"><a4j:mediaOutput element="img"
						cacheable="false" session="false"
						createContent="#{userProfileController.paintPhotoOrDefault}"
						value="#{sdh:storeDataAndGetKey(userProfileController.userProfile.photo)}"
						mimeType="image/jpg" /></div>
					</td>
					<td style="padding-left: 10px;">
					<p class="welcome_text">Hi,<a href="profile.jsp"
						style="text-decoration: none; color: #777A7F; padding-left: 0px"
						class="welcome_text" onmouseout="this.style.color='#777A7F';"
						onmouseover="this.style.color='#AAAAAA'; this.style.cursor='hand';">#{userProfileController.userProfile.name}</a></p>
					</td>
				</tr>
			</table>
			</div>
			<div id="header_right">
			<div id="header_right_top">
			<table width="37%" border="0" align="right" cellpadding="0"
				cellspacing="0">
				<tr>
					<td><a href="http://www.terametric.com" target="_blank"
						style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: #777A7F; padding-right: 4px;"
						onmouseout="this.style.color='#777A7F';"
						onmouseover="this.style.color='#AAAAAA'; this.style.cursor='hand';">terametric.com</a>
					| <a href="mailto:support@terametric.com"
						style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: #777A7F; padding-right: 4px;"
						onmouseout="this.style.color='#777A7F';"
						onmouseover="this.style.color='#AAAAAA'; this.style.cursor='hand';">help</a>
					| <a href="../Logout"
						style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; color: #777A7F; padding-left: 4px;"
						onmouseout="this.style.color='#777A7F';"
						onmouseover="this.style.color='#AAAAAA'; this.style.cursor='hand';">logout</a>
					</td>
				</tr>
				<tr>
					<td height="15"></td>
				</tr>
				<tr>

					<td><img src="../images/name.png" /></td>

				</tr>

			</table>
			</div>
			<div id="header_right_bottom">
			<table width="64%" border="0" align="right">
				<tr>
					<td valign="bottom">


					<div id="header_right_bottom_search"><input type="text"
						style="margin-top: 4px; margin-left: 6px; border: 0; padding-top: 4px; color: #787E89"
						value="Search" onfocus="if(this.value=='Search') this.value='';"
						onblur="if(this.value=='') this.value='Search';" /></div>
					<div id="header_right_bottom_account">

					<table width="100%" border="0">
						<tr>
							<td>

							<div class="mainDivTop" id="main_xT">

							<div class="textDiv"><input type="text" value=""
								class="fakeTextTop" onBlur="closeList('xT');"
								onClick="toggleList('xT')" readonly="readonly"
								style="cursor: auto; text-align: right;" /></div>
							<div class="captionDivTop">ACCOUNT OPTIONS</div>
							</div>
							<div class="listDivTop" id="list_xT"
								onmouseover="setInList(true);" onmouseout="setInList(false);">

							<div class="itemDivTop"><a href="profile.jsp"
								class="optiontext">View My Profile</a></div>
							<div class="itemDivTop"><a href="#" class="optiontext">Manage
							Users</a></div>
							<div class="itemDivTop"><a href="#" class="optiontext">Administration</a>
							</div>

							<div class="listBottomDiv"></div>
							</div>







							</td>


						</tr>
					</table>
					</div>
					</td>
				</tr>
			</table>

			</div>
			</div>
			</div>

			<div id="border"></div>
			<!--    ******************** Header Section End ********************************-->
			<!--    ******************** Top Pannel Start ********************************-->

			<div id="top_pannel"><ui:include src="topMenuSVT.jsp" /></div>
			<div id="border"></div>

			<!-- ************************* Top Pannel End **********************************  -->
			</td>
		</tr>
		<tr>
			<td colspan="2"><!-- ************************** Individual Top Header Start ********************************-->
			<div id="top_head">

			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="260px">
					<div id="top_head_left"></div>
					</td>
					<td
						style="background-image: url(../images/tab_back.jpg); background-repeat: repeat">
					<div id="top_head_right">
					<div id="top_head_right_top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="title_text"><ui:insert name="title" /></td>
							<td>&nbsp;</td>

						</tr>
					</table>


					</div>
					<div id="top_head_right_bottom"><ui:insert name="tabs" /></div>
					</div>
					</td>
				</tr>
			</table>
			</div>
			<!--    ******************** Individual Top Header End ********************************-->

			</td>
		</tr>
		<tr>
			<td colspan="2"><!--    ******************** Body Start ********************************-->
			<div id="total_body">

			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td valign="top" width="260px"><!-- ************ Left Menu Section *********************-->
					<div id="left_pannel"><ui:insert name="menu" /></div>
					<div style="width: 100%; height: 100%"></div>
					<!-- *************Left Menu Section End *****************--></td>
					<td valign="top"><!-- *************Body Right Pannel Start ***************-->

					<div class="right_pannel"><ui:insert name="body_right_pannel" />
					</div>

					<!-- ********************* Body Right Pannel End *****************************-->
					<div style="width: 100%; height: 100%"></div>
					</td>
				</tr>
			</table>


			</div>
			<!-- **************************** Body End ********************************-->
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<div id="border"></div>
			</td>
		</tr>
		<tr>
			<td>
			<div id="footer_left">
			<p class="help">Need help?</p>
			<p class="matter">Email us- <a
				href="mailto:support@terametric.com"
				onMouseOver="this.style.color='#63881A'; this.style.cursor='hand';"
				onMouseOut="this.style.fontSize='12px'; this.style.color='#AECE6F';"
				style="color: #AECE6F"><font style="font-size: 12px;">support@terametric.com</font></a></p>
			<p class="matter">©2010 terametric</p>
			</div>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	</div>
	<!--    **************************************************** Page End*****************************************************************-->
	<!--                         for flash                    -->
	<noscript><object
		classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="100%"
		height="100%" id="DashBoard">

		<param name="quality" value="high" />
		<param name="wmode" value="transparent" />
		<param name="allowScriptAccess" value="sameDomain" />
		<param name="allowFullScreen" value="true" />
		<!--[if !IE]>--> <object type="application/x-shockwave-flash"
			data="DashBoard.swf" width="100%" height="100%">
			<param name="quality" value="high" />
			<param name="wmode" value="transparent" />
			<param name="allowScriptAccess" value="sameDomain" />
			<param name="allowFullScreen" value="true" />
			<!--<![endif]--> <!--[if gte IE 6]>-->
			<p>Either scripts and active content are not permitted to run or
			Adobe Flash Player version 10.0.0 or greater is not installed.</p>
			<!--<![endif]--> <a href="http://www.adobe.com/go/getflashplayer">
			<img
				src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif"
				alt="Get Adobe Flash Player" /> </a> <!--[if !IE]>--> </object> <!--<![endif]-->
	</object></noscript>


	</body>

</f:view>
</html>