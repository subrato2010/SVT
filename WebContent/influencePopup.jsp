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
	<script language="JavaScript" src="../js/svt.js"/>
		
	<script language="JavaScript">
		function setInfluenceId(influenceId,name){
		document.getElementById('dummyholderinfluence').value=influenceId;
		document.getElementById('captionDivI').innerHTML=name;
		}
	</script>
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
		<h:form>
		<input type="hidden" id="dummyholderinfluence" value="0"/>
		<div class="total">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" height="97%">
			<tr>
				<td valign="top" align="left">
				<div class="heading_total">
			
				<table>
						<tr><td><font class="heading_text" style="padding-left:15px;">Influence Score </font></td>
						<td>
							<div class="mainDiv" id="main_xc">
								<div id="captionDivI" class="captionDiv">All</div> 
								<div class="textDiv" >
									<h:inputText  type="text" class="fakeText" onblur="closeList('xc');" onclick="toggleList('xc')" 
										readonly="readonly" style="cursor:auto; text-align:right; " 
										value=""/>
								</div>						    
							</div>
							<div class="listDiv" id="list_xc" onmouseover="setInList(true);" onmouseout="setInList(false);">
								<div class="itemDiv"><a  onclick="setInfluenceId('0','Score1');toggleList('xc');" href="#" class="optiontext">Score1</a></div>
								<div class="itemDiv"><a  onclick="setInfluenceId('1','Score2');toggleList('xc');" href="#" class="optiontext">Score2</a></div>
								<div class="itemDiv"><a  onclick="setInfluenceId('2','Score3');toggleList('xc');" href="#" class="optiontext">Score3</a></div>
								<div class="listBottomDiv"></div>
							</div>
						</td>
						</tr>
				</table>
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
					@username
					</div>
					<div class="lowerPart2">
					<font style="font-weight: bold;">John Marks</font>
					<br/>
					<font style="font-weight: bold;">BIO:</font> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					
					</div>
					<div class="lowerPart3">

					<table>
						<tr>
							<td width="26" align="left" valign="middle">
								<img alt="Heart" src="../images/influLogo.gif" border="0"/>
							</td>
							<td align="left" valign="middle" class="lowerPart3">
							5
							</td>
						</tr>
					</table>
					</div>
					
				</div>
			
		
				
				
				
				
				
				<div class="lowerPartTotalGray">
					<div class="lowerPart1">
					@username
					</div>
					<div class="lowerPart2">
					<font style="font-weight: bold;">John Marks</font>
					<br/>
					<font style="font-weight: bold;">BIO:</font> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					
					</div>
					<div class="lowerPart3">

					<table>
						<tr>
							<td width="26" align="left" valign="middle">
								<img alt="Heart" src="../images/influLogo.gif" border="0"/>
							</td>
							<td align="left" valign="middle" class="lowerPart3">
							5
							</td>
						</tr>
					</table>
					</div>
					
				</div>
				
		
				
				
				
				<div class="lowerPartTotal">
					<div class="lowerPart1">
					@username
					</div>
					<div class="lowerPart2">
					<font style="font-weight: bold;">John Marks</font>
					<br/>
					<font style="font-weight: bold;">BIO:</font> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					
					</div>
					<div class="lowerPart3">

					<table>
						<tr>
							<td width="26" align="left" valign="middle">
								<img alt="Heart" src="../images/influLogo.gif" border="0"/>
							</td>
							<td align="left" valign="middle" class="lowerPart3">
							5
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
			
			<!-- Header Part -->
			
	
			<!-- Middle Part  -->
	
			

			<!-- Footer navigations -->
			
		</div>
	</h:form>
	</f:view>
	</body>
</html>