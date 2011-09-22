<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j">
<f:view>
	<h:form>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
		<link href="../css/profile.css" rel="stylesheet" type="text/css" />
		<link href="../css/popup.css" rel="stylesheet" type="text/css" />
		<a4j:loadScript src="/js/custom-form-elements.js" />
		<a4j:loadScript src="/js/designMainScreen.js" />
		<a4j:loadScript src="/js/svt.js" />
		<a4j:loadScript src="/js/popup.js" />
		<div class="footer">
		<div class="footer_left">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="help" valign="top" align="left">Need help?</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="matter">Email us- <a
					style="color: rgb(174, 206, 111); font-size: 12px; text-decoration: none;"
					onmouseout="this.style.fontSize='12px'; this.style.color='#AECE6F';"
					onmouseover="this.style.color='#63881A'; this.style.cursor='hand';"
					href="mailto:support@terametric.com">support@terametric.com</a></td>
			</tr>
			<tr>
				<td valign="top" align="left">
				<div style="height: 15px;"></div>
				</td>
			</tr>
			
			<tr>
				<td valign="top" align="left">
				<div style="height: 15px;"></div>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left" class="help">Follow Us On</td>
			</tr>
			<tr>
				<td valign="top" align="left">
				<table width="350" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" valign="middle" class="matter1" width="40">
						<a href="http://twitter.com/terametric" target="_blank"
							style="color: #AECE6F; text-decoration: none; font-size: 12px;">
						Twitter </a></td>
						<td align="center" valign="middle" width="30"><a
							href="http://twitter.com/terametric" target="_blank"> <img
							src="../images/twitterLogo.gif" border="0" /> </a></td>
						<td align="center" valign="middle" class="help" width="20">|</td>
						<td align="center" valign="middle" class="matter1" width="40">
						<a href="http://www.facebook.com/Terametric" target="_blank"
							style="color: #AECE6F; text-decoration: none; font-size: 12px;">
						Facebook </a></td>
						<td align="center" valign="middle" width="30"><a
							href="http://www.facebook.com/Terametric" target="_blank"> <img
							src="../images/facebookLogo.gif" border="0" /> </a></td>
						<td align="center" valign="middle" class="help" width="20">|</td>
						<td align="center" valign="middle" class="matter1" width="40">
						<a href="http://www.linkedin.com/company/terametric"
							target="_blank"
							style="color: #AECE6F; text-decoration: none; font-size: 12px;">
						LinkedIn </a></td>
						<td align="center" valign="middle" width="30"><a
							href="http://www.linkedin.com/company/terametric" target="_blank">
						<img src="../images/inLogo.gif" border="0" /> </a></td>
						<td align="center" valign="middle" class="help" width="20">|</td>
						<td align="center" valign="middle" class="matter1" width="40">
						<a href="http://terametric.com/component/wordpress/feed"
							target="_blank"
							style="color: #AECE6F; text-decoration: none; font-size: 12px;">
						Updates </a></td>
						<td align="center" valign="middle" width="30"><a
							href="http://terametric.com/component/wordpress/feed"
							target="_blank"> <img src="../images/updatesLogo.gif"
							border="0" /> </a></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left">
				<div style="height: 10px;"></div>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left"><font class="matter">Optimizer<sup>TM</sup> for Twitter
				is a product of</font> <font class="matter1"> <a
					href="http://www.terametric.com" target="_blank"
					style="color: #AECE6F; text-decoration: none; font-size: 12px;">Terametric.com</a>
				</font> <font class="matter"> | </font> <font class="matter1"> <a
					href="#"
					onclick="openPopup('Privacy - Security', '', '#E7E7E7', '#787E89', '../images/close.gif', 324, 90, 777, 343, 10, false, true, false, '../security.html')"
					style="color: #AECE6F; text-decoration: none; font-size: 12px;">
				Privacy &amp; Security </a> </font></td>
			</tr>
			<tr>
				<td valign="top" align="left" class="matter"><img
					src="../images/copyright.gif" border="0" />2011 Great Minds
				Interactive, Inc. | Build ph 1.000.000.0</td>
			</tr>
		</table>
		</div>
		</div>
		<a4j:include viewId="commonPopup.jsp" />
	</h:form>
	<input type="hidden" id="dummyholdercmptid" value="0" />
</f:view>
<script language="JavaScript">
		function setCmptId(cmptId,name){
		document.getElementById('dummyholdercmptid').value=cmptId;
		document.getElementById('captionDivM0').innerHTML=name;
		}
		function setCmptId1(cmptId,name){
			document.getElementById('dummyholdercmptid').value=cmptId;
			document.getElementById('captionDivM0N').innerHTML=name;
			}
	</script>
	<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-19606260-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</html>
