<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j">
<body style="margin: 0px;">
<f:view>
	
	
			
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
	<script language="JavaScript" src="../js/designMainScreen.js"/>	
	
		<div class="arrowlistmenu">
		<div class="header">
		<div class="headerTop">
		<table width="250" border="0" cellspacing="0" cellpadding="0"
			height="30" align="right" style="margin-right: 10px;">
			<tr>
				<td class="headerText" width="100" align="center" valign="middle">
				<a href="http://www.terametric.com" target="_blank" style="color: #ffffff; text-decoration: none">terametric.com</a>
				</td>
				<td class="headerText" width="20" align="center" valign="middle">|</td>
				<td class="headerText" width="70" align="center" valign="middle">
				<a href="http://getsatisfaction.com/twitteroptimizer" target="_blank" style="color: #ffffff; text-decoration: none">Get Help</a>
				</td>
				<td class="headerText" width="20" align="center" valign="middle">|</td>
				<td class="headerText" width="70" align="center" valign="middle">
				<a href="../Logout" style="color: #FFFFFF; text-decoration: none">Logout</a>
				</td>
			</tr>
		</table>

		</div>
		<div class="headerBottom">
		<table width="100%" border="0" height="85" cellspacing="0"
					cellpadding="0">
			<tr>
				<td valign="bottom" align="left">
				<div class="headerBottomLeft">

				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					height="65">
					<tr>
						<td valign="bottom" align="center" width="80"><img
							src="../images/demoPerson.png" width="40" height="40" /></td>
						<td class="welcome_text" align="left" valign="bottom">
						Hi, #{userProfileController.userProfile.name}</td>
					</tr>
				</table>
				</div>
				</td>
				<td valign="bottom" align="right">
				<div class="headerBottomRight">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					height="85">
					<tr>
						<td valign="middle" align="center"><img
							src="../images/twitterFullLogo.gif" border="0" /></td>
						<td valign="bottom" align="center">
							<div class="mainDivTopAcc" id="main_xT">
								<div class="textDiv">
									<input  type="text" value="" class="fakeTextTop" onblur="closeList('xT');" 
									onclick="toggleList('xT')" readonly="readonly" style="cursor:auto; text-align:right; "/>
								</div>
								<div class="captionDivTopAcc">ACCOUNT OPTIONS</div> 
							</div>
							<div class="listDivTopAcc" id="list_xT" onmouseover="setInList(true);" onmouseout="setInList(false);">
								<div class="itemDivTopAcc">
									<a href="profile.jsp" class="optiontext" >View My Profile</a>
								</div>
								<div class="itemDivTopAcc">
									<a href="#" class="optiontext">Manage Users</a>
								</div>
								<div class="itemDivTopAcc">
									<a href="#" onclick="openPopup('Create Your Profile',400, 3, 410, 800, 10, false, true, false, 'createProfile.jsp')" 
                                                                       		style="text-decoration:none;">
                                                                       		Administration</a>
								</div>
								<div class="listBottomDivAcc"></div>
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



</f:view>
</body>
</html>