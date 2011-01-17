<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	<a4j:loadStyle src="../css/sentiment.css" />
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-store"/>	
	</head>
	
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	
	<script language="JavaScript" src="../js/popup.js" />
	<script language="JavaScript" src="../js/svt.js"/>	

	<script language="JavaScript">
		function setMentionsId(mentionsId,MentionsName){
		document.getElementById('dummyholdermentions').value=mentionsId;
		document.getElementById('captionDivM').innerHTML=MentionsName;
		}
	</script>
	
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
		<h:form>
		<input type="hidden" id="dummyholdermentions" value="0"/>
		
		<div class="total">
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" height="97%">
			<tr>
				<td valign="top" align="left">
				<div class="heading_total">
				<div class="heading">
				<table>
						<tr><td><font class="heading_text">Mentions about </font></td>
						<td>
							<div class="mainDiv" id="main_xa">
							<div id="captionDivM" class="captionDiv">Product</div>
							<div class="textDiv"><h:inputText type="text"
								class="fakeText" onblur="closeList('xa');"
								onclick="toggleList('xa')" readonly="readonly"
								style="cursor:auto; text-align:right; " value="" /></div>
							</div>
							<div class="listDiv" id="list_xa" onmouseover="setInList(true);"
								onmouseout="setInList(false);">
							<div class="itemDiv"><a
								onclick="setMentionsId('0','Product');toggleList('xa');" href="#"
								class="optiontext">Product</a></div>
							<div class="itemDiv"><a
								onclick="setMentionsId('1','Industry');toggleList('xa');" href="#"
								class="optiontext">Industry</a></div>
							<div class="itemDiv"><a
								onclick="setMentionsId('2','Brand');toggleList('xa');" href="#"
								class="optiontext">Brand</a></div>
							<div class="listBottomDiv"></div>
							</div>
				</td>

						</tr>
				</table>
				</div>
				<div class="heading2">
					<font class="heading_text2">Channel:</font>
					<font class="heading_text3">Twitter</font>
				</div>
				<div class="heading3" style="padding-bottom:4px;">
					<font class="heading_text4">Results 1-15 of 118 mentions.</font>
				</div>
				<div class="border_toppannel"></div>

			</div>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left">
				<div class="lowerpart">
				<div class="lowerPartTotal">
					<div class="lowerPart1">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor....
					</div>
					<div class="lowerPart2">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					<br/>
					<font class="lowerPart1" style="font-weight: normal;"> www.prnewswire.com/.../john-long-joins-integrascreen-group-as-global-ceo-58173417.html<br/>
					<font style="color: #8B8B8B;">3 HOURS AGO</font> - on yahoo</font>
					</div>
					<div class="lowerPart3">

					<table>
						<tr>
							<td width="26" align="left" valign="middle">
								<img alt="Heart" src="../images/heart.gif" border="0"/>
							</td>
							<td align="left" valign="middle" class="lowerPart3">
							3.93
							</td>
						</tr>
					</table>
					</div>
					
				</div>
				
				<div class="lowerPartTotalGray">
					<div class="lowerPart1">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor....
					</div>
					<div class="lowerPart2">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					<br/>
					<font class="lowerPart1" style="font-weight: normal;"> www.prnewswire.com/.../john-long-joins-integrascreen-group-as-global-ceo-58173417.html<br/>
					<font style="color: #8B8B8B;">3 HOURS AGO</font> - on yahoo</font>
					</div>
					<div class="lowerPart3">

					<table>
						<tr>
							<td width="26" align="left" valign="middle">
								<img alt="Heart" src="../images/heart.gif" border="0"/>
							</td>
							<td align="left" valign="middle" class="lowerPart3">
							3.93
							</td>
						</tr>
					</table>
					</div>
					
				</div>
				
		
				
				
				
				<div class="lowerPartTotal">
					<div class="lowerPart1">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor....
					</div>
					<div class="lowerPart2">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					<br/>
					<font class="lowerPart1" style="font-weight: normal;"> www.prnewswire.com/.../john-long-joins-integrascreen-group-as-global-ceo-58173417.html<br/>
					<font style="color: #8B8B8B;">3 HOURS AGO</font> - on yahoo</font>
					</div>
					<div class="lowerPart3">

					<table>
						<tr>
							<td width="26" align="left" valign="middle">
								<img alt="Heart" src="../images/heart.gif" border="0"/>
							</td>
							<td align="left" valign="middle" class="lowerPart3">
							3.93
							</td>
						</tr>
					</table>
					</div>
					
				</div>
				
			
			</div>
				</td>
			</tr>
			<tr>
				<td valign="bottom" align="left">
				<div class="footerInflu">
				<img src="../images/pagination.gif" border="0"/>
				
				</div>
				</td>
			</tr>
		
		
		
		</table>
		
			 
	
			<!-- Middle Part  -->
	
			

			<!-- Footer navigations -->
			
		</div>
	</h:form>
	</f:view>
	</body>
</html>