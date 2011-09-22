<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j">
<script language="JavaScript" src="../js/popup.js"></script>
<link href="../css/popup.css" rel="stylesheet" type="text/css" />
<a4j:include viewId="commonAlertForCreatePopup.jsp" />

<script language="JavaScript">
	function initPage() {
		parent.document.getElementById('floatingDiv').style.display='none';
		parent.document.getElementById('backDrop').style.display='none'; 
		document.getElementById('ALMore').style.display='none'; 
		document.getElementById('ALMore1').style.display='none';  
		document.getElementById('ALMore2').style.display='none';  
		document.getElementById('ALMore3').style.display='none';
	}
</script>

<div class="backDrop" id="backDrop" style="display: none;"></div>
<div id="floatingDiv" class="glass" style="display: none;">
<div id="innerMainDiv" class="innerMain">
<div class="header" id="popupHeader">
<div class="menuItem demo active" title="containerIframe"></div>
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td valign="middle" align="left"
			style="padding-left: 10px; width: 40px;" id="imgleft">
		<div class="imgleft" id="imgleft"></div>
		</td>
		<td valign="middle" align="left" style="padding-left: 10px">
		<div class="title" id="title"></div>
		</td>
		<td valign="middle" align="right"><a href="#"
			style="color: #787E89; text-decoration: none;"
			onclick="initPage()">
		<div class="edit_left_textEPP" align="right" id="closeParameter"></div>
		</a></td>
	</tr>
</table>
</div>
<iframe id="frame" name="frame" width="10%" height="10%" frameborder="0"
	scrolling="auto"  style="overflow-x:hidden;"></iframe></div>
<div style="display: none;">
<form action=""><input type="button" id="GRButton"
	onclick="openPopup('Optimization Completed','../images/Alert/alertRightButton.gif', '#98C841', '#ffffff', '../images/Alert/closeButtonGreen.gif', 424, 150, 430, 190, 10, false, true, false, 'optimizationComptAlert.jsp')" />
</form>
<form action=""><input type="button" id="GRButton5"
	onclick="openPopup('Search Locations','', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 300, 250, 450, 470, 10, false, true, false, 'searchLocationDetails.jsp')" />
</form>



<!-- Added by NEEL dated 2-6-2011 -->

<a4j:form action=""><input type="button" id="fromReplyLocationButtonPressed"
	onclick="openPopup1('Search Locations','', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 300, 250, 520, 180, 10, false, true, false, 'searchReplyLocation.jsp')" />
</a4j:form>

<a4j:form action=""><input type="button" id="fromReplyLocationDetailButtonPressed"
	onclick="openPopup1('Search Locations','', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 300, 250, 450, 410, 10, false, true, false, 'searchReplyLocationDetails.jsp')" />
</a4j:form>

<!--  Ended Here  -->




<form action=""><input type="button" id="GRButton1"
	onclick="parent.document.getElementById('ALMore').style.display='block';" />
<input type="button" id="GRButton2"
	onclick="parent.document.getElementById('ALMore1').style.display='block';" />
<input type="button" id="GRButton3"
	onclick="parent.document.getElementById('ALMore2').style.display='block';" />
<input type="button" id="GRButton4"
	onclick="parent.document.getElementById('ALMore3').style.display='block';" />
</form>
</div>
</div>
<div class="backDrop" id="backDrop" style="display: none;"></div>
<div id="floatingDivR" class="glass" style="display: none;">
<div id="innerMainDivR" class="innerMainR">
<div class="headerR" id="popupHeaderR">
<div class="menuItem demo active" title="containerIframeR"></div>
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td valign="middle" align="left"
			style="padding-left: 10px; width: 40px;" id="imgleftR">
		<div class="imgleftR" id="imgleftR"></div>
		</td>
		<td valign="middle" align="left" style="padding-left: 10px">
		<div class="titleR" id="titleR"></div>
		</td>
		<td valign="middle" align="right">
		<div class="edit_left_textEPP" align="right" id="closeParameterR"></div>
		</td>
	</tr>
</table>
</div>
<iframe id="frameR" name="frameR" width="10%" height="10%" frameborder="0"
	scrolling="auto"></iframe></div>
<div style="display: none;">
<form action=""><input type="button" id="GRButton"
	onclick="openPopup('Optimization Completed','../images/Alert/alertRightButton.gif', '#98C841', '#ffffff', '../images/Alert/closeButtonGreen.gif', 424, 150, 430, 190, 10, false, true, false, 'optimizationComptAlert.jsp')" />
</form>
<form action=""><input type="button" id="GRButton6"
	onclick="openPopup('Manage Your Subscription','', '#E7E7E7', '#787E89', '../images/Alert/closeGaryButton.gif', 224, 150, 765, 380, 10, false, true, false, 'manageSubscription.jsp')" />
</form>

<form action=""><input type="button" id="GRButton1"
	onclick="parent.document.getElementById('ALMore').style.display='block';" />
<input type="button" id="GRButton2"
	onclick="parent.document.getElementById('ALMore1').style.display='block';" />
<input type="button" id="GRButton3"
	onclick="parent.document.getElementById('ALMore2').style.display='block';" />
<input type="button" id="GRButton4"
	onclick="parent.document.getElementById('ALMore3').style.display='block';" />
</form>
</div>
</div>
<div id="floatingDiv1" class="glass" style="display: none; z-index: 1000;">
<div id="innerMainDiv1" class="innerMain">
<div class="header" id="popupHeader1">
<div class="menuItem demo active" title="containerIframe1"></div>
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td valign="middle" align="left" style="padding-left: 10px" width="40">
		<div class="imgleft" id="imgleft1"></div>
		</td>
		<td valign="middle" align="left" style="padding-left: 10px">
		<div class="title" id="title1"></div>
		</td>
		<td valign="middle" align="right"><a href="#"
			onclick="parent.document.getElementById('floatingDiv1').style.display='none';parent.document.getElementById('backDrop').style.display='none';">
		<div class="edit_left_textEPP" align="right" id="closeParameter1"></div>
		</a></td>
	</tr>
</table>
</div>
<iframe id="frame1" name="frame1" width="10%" height="10%" frameborder="0"
	scrolling="auto"></iframe></div>
<div style="display: none;">
<form action=""><input type="button" id="GRButton"
	onclick="openPopup('Optimization Completed','', '', '', '', 424, 150, 430, 190, 10, false, true, false, 'optimizationComptAlert.jsp')" />
</form>
<form action=""><input type="button" id="GRButton5"
	onclick="openPopup('Search Locations','', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 290, 420, 450, 540, 10, false, true, false, 'searchLocationDetails.jsp')" />
</form>
</div>
</div>
<div class="backDrop" id="backDrop" style="display: none;"></div>
<!-- Added By Neel -->
<div id="floatingDiv11" class="glass" style="display: none;">
<div id="innerMainDiv11" class="innerMain11">
<div class="header11" id="popupHeader11">
<div class="menuItem demo active" title="containerIframe11"></div>
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="middle" align="left" width="166">
		<div class="title11" id="title11"></div>
		</td>
		<td style="padding-left: 10px; padding-top: 5px;" valign="middle"
			align="left">
		<div class="mainDivNew" id="main_xb1">
		<div id="captionDivM0" class="captionDivNew">Customer #1</div>
		<div class="textDivNew"><h:inputText type="text"
			styleClass="fakeTextNew" onblur="closeList('xb1')"
			onclick="toggleList4('xb1')" readonly="readonly"
			style="cursor:auto; text-align:right; " value="" /></div>
		</div>
		<div class="listDiv" id="list_xb1" onmouseover="setInList(true);"
			onmouseout="setInList(false);">
		<div class="itemDiv"><a
			onclick="setCmptId('0','Customer #1'); toggleList4('xb1');" href="#"
			class="optiontext">Customer #1</a></div>
		<div class="itemDiv"><a
			onclick="setCmptId('1','Customer #2'); toggleList4('xb1');" href="#"
			class="optiontext">Customer #2</a></div>
		<div class="itemDiv"><a
			onclick="setCmptId('2','Customer #3'); toggleList4('xb1');" href="#"
			class="optiontext">Customer #3</a></div>
		<div class="listBottomDiv"></div>
		</div>
		</td>
		<td valign="middle" align="left" width="40">
		<div class="close" align="right" id="imageDiv"><a href="#"
			onclick="closePopupNew1();"> <img id="popupCloseButton"
			src="../images/Alert/General/closeGaryButtonPopup.gif" border="0" 
			style="border: 0px; padding-top: 5px; margin-right: 10px;"
			onmouseover="changeImage(this,'../images/Alert/Rollover/closeGaryButtonPopupRollover.gif');"
			onmouseout="changeImage(this,'../images/Alert/General/closeGaryButtonPopup.gif');"/>
		</a></div>
		</td>
	</tr>
</table>
<div class="close"></div>
</div>
<iframe id="frame11" name="frame11" width="10%" height="10%" frameborder="0"
	scrolling="auto"></iframe></div>
</div>
<div class="backDrop" id="backDrop" style="display: none;"></div>
<!--  Added By Neel -->













<!-- Added By Neel -->
<div id="floatingDivInfu" class="glass" style="display: none;">
<div id="innerMainDivInfu" class="innerMainInfu">
<div class="headerInfu" id="popupHeaderInfu">
<div class="menuItem demo active" title="containerIframeInfu"></div>
<input type="hidden" id="dummyholderinfluence" value="0"/>
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="middle" align="left" width="166">
		<div class="titleInfu" id="titleInfu"></div>
		</td>
		<td style="padding-left: 10px; padding-top: 5px;" valign="middle"
			align="left">
		<div class="mainDivNew" id="main_xb4">
		<div id="captionDivM0N" class="captionDivNew">Customer #1</div>
		<div class="textDivNew"><h:inputText type="text"
			styleClass="fakeTextNew" onblur="closeList('xb4')"
			onclick="toggleList5('xb4')" readonly="readonly"
			style="cursor:auto; text-align:right; " value="" /></div>
		</div>
		<div class="listDiv" id="list_xb4" onmouseover="setInList(true);"
			onmouseout="setInList(false);">
		<div class="itemDiv"><a
			onclick="setCmptId1('0','Customer #1'); toggleList5('xb4');" href="#"
			class="optiontext">Customer #1</a></div>
		<div class="itemDiv"><a
			onclick="setCmptId1('1','Customer #2'); toggleList5('xb4');" href="#"
			class="optiontext">Customer #2</a></div>
		<div class="itemDiv"><a
			onclick="setCmptId1('2','Customer #3'); toggleList5('xb4');" href="#"
			class="optiontext">Customer #3</a></div>
		<div class="listBottomDiv"></div>
		</div>
		</td>
		<td valign="middle" align="left" width="40">
		<div class="close" align="right" id="imageDiv"><a href="#"
			onclick="closePopupNew1();"> <img id="popupCloseButton" alt="Close"
					src="../images/Alert/General/closeGaryButtonPopup.gif" border="0" 
					style="border: 0px; padding-top: 5px; margin-right: 10px;"
					onmouseover="changeImage(this,'../images/Alert/Rollover/closeGaryButtonPopupRollover.gif');"
					onmouseout="changeImage(this,'../images/Alert/General/closeGaryButtonPopup.gif');"/>
			
		</a></div>
		</td>
	</tr>
</table>
<div class="close"></div>
</div>
<iframe id="frame4" name="frame4" width="10%" height="10%" frameborder="0"
	scrolling="auto"></iframe></div>
</div>
<div class="backDrop" id="backDrop" style="display: none;"></div>
<!--  Added By Neel -->
</html>
