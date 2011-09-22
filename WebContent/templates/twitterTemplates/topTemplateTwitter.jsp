<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:sdh="http://richfaces.org/session-data-helper"
	xmlns:a4j="http://richfaces.org/a4j">
<link REL="SHORTCUT ICON" HREF="../images/favicon.ico"/>	
	<script language="JavaScript">
		function showHost(str)
		{
			var myRegExp = /twitterroiqa/;
			var matchPos = str.search(myRegExp);
			if(matchPos != -1)
				document.getElementById('testDiv').innerHTML = "Test Environment";
			else
				document.getElementById('testDiv').innerHTML =  "";
		}
	</script>
	<script language="JavaScript" src="./../js/all.js"></script>
	
<f:view>
<div id="transParentDocDiv" class="transparentClass" style="position:absolute;
     background: url('../images/transPBack.png') repeat;
     display: none;width:100%; height:1000px; margin:0 auto; z-index: 1000000;" >
        <table width="100%" border="0" height="100%">
	        <tr>
		         <td align="center" valign="middle">
			         <div id="loader" style="display:none;">
			         	<img id="preloader" src="../images/preloader3.gif" style="position: fixed;" alt="preloader"/>
			         </div>     
		         </td>
	        </tr>
       	</table>
      </div>
	         
      <div id="transParentDiv" style="position:absolute; display: none;width:100%; height:1000px; background: url('../images/transPBack.png') repeat; z-index: 3;">
     <table width="100%" border="0" height="100%" style="">
        <tr>
         <td align="center" valign="middle"></td>
        </tr>
       </table>
     </div>
	<h:form id="toptemplatetwitterForm" style="margin-top: 0px;">
		<h:inputHidden id="rtopurl" value="#{userProfileController.rtopURL}"/>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="../js/designMainScreen.js" />	
		<h:inputHidden value="#{userProfileDetailDTO.workAddressLine1}"/>	
		<div class="arrowlistmenu" style="margin-top: 0px;">
		<div class="header">
		<div class="headerTop">
		<table width="100%">
			<tr><td class="headerText" style="padding-left: 10px"><div id="testDiv"></div></td>
			<td>
				<table width="250" border="0" cellspacing="0" cellpadding="0"
					height="30" align="right" style="margin-right: 10px;">
					<tr>
						<td class="headerText" width="100" align="center" valign="middle">
						<a href="http://www.terametric.com" target="_blank"
							style="color: #ffffff; text-decoration: none">terametric.com</a>
						</td>
						<td class="headerText" width="20" align="center" valign="middle">|</td>
						<td class="headerText" width="70" align="center" valign="middle">
						<a href="http://getsatisfaction.com/twitteroptimizer"
							target="_blank" style="color: #ffffff; text-decoration: none">Get
						Help</a></td>
						<td class="headerText" width="20" align="center" valign="middle">|</td>
						<td class="headerText" width="70" align="center" valign="middle">
						<a href="../Logout" style="color: #FFFFFF; text-decoration: none">Logout</a>
						</td>
					</tr>
				</table>
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
						<td valign="bottom" align="center" width="80">
							<div id="header_left_logo">
							<a4j:outputPanel rendered="#{userProfileController.userProfile.photoSize == true}">
								<a4j:mediaOutput element="img"
									cacheable="false" session="false"
									createContent="#{userProfileController.paintPhotoOrDefault}"
									value="#{sdh:storeDataAndGetKey(userProfileController.userProfile.photo)}"
									mimeType="image/jpg" />
							</a4j:outputPanel>
							
							<a4j:outputPanel rendered="#{!(userProfileController.userProfile.photoSize == true)}">
								<img src="../images/demoPerson.png" border="0"/>
							</a4j:outputPanel>
							</div>
						</td>
						<td class="welcome_text" align="left" valign="bottom">Hi,
						#{userProfileController.userProfile.name}</td>
					</tr>
				</table>
				</div>
				</td>
				<td valign="bottom" align="right">
				<div class="headerBottomRight">
				<div style="width: 350px;">
				<div
					style="width: 166px; height: 54px; float: left; margin-top: 20px; margin-right: 10px;">
				<img src="../images/twitterFullLogo.gif" border="0" /></div>
				<div
					style="width: 172px; height: 36px; float: right; margin-top: 44px;">
				<div class="mainDivTopAcc" id="main_xT">
				<div class="captionDivTopAcc" style="width: 135px;">ACCOUNT OPTIONS</div>
				<div class="textDiv" style="float: left;"><input type="text" value=""
					class="fakeTextTop" onblur="closeList('xT');"
					onclick="toggleList('xT')" readonly="readonly"
					style="cursor: pointer; width: 22px;" /></div>
				</div>
				<div class="listDivTopAcc" id="list_xT" onmouseover="setInList(true);" onmouseout="setInList(false);">
				
				<a4j:repeat value="#{userProfileController.userProfile.accountOptions}" var="menuList">	
	   				<div class="itemDivTopAcc">
						<a4j:commandLink value="#{menuList}" rendered="#{menuList == 'View Profile' }" onclick="location.href='profile.jsp';" styleClass="optiontext" />
						<a4j:commandLink value="#{menuList}" rendered="#{menuList != 'View Profile' }" onclick="toggleList('xT');" styleClass="optiontext" />
	   				</div>	
				</a4j:repeat>
				
				<!--<div class="itemDivTopAcc"><a href="profile.jsp"
					class="optiontext">View My Profile</a></div>
				<div class="itemDivTopAcc"><a href="#" onclick="toggleList('xT');" class="optiontext">Manage
				Users</a></div>
				<div class="itemDivTopAcc"><a href="#" onclick="openPopup('Create Your Profile',400, 3, 450, 800, 10, false, true, false, 'createProfile.jsp')" 
					                                    style="text-decoration:none;">
					                             Administration</a>
											 
				<a href="#">Administration</a></div>
				--><div class="listBottomDivAcc"></div>
				</div>
				</div>
				</div>
				</div>
				</td>
			</tr>
		</table>
		</div>
		</div>
		</div>
		<script language="javascript">
			showHost(location.href);
		</script>
	</h:form>
</f:view>
</html>