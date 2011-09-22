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
	
	
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
		
	<script language="JavaScript">
		function setInfluenceId(influenceId,name){
		document.getElementById('dummyholderinfluence').value=influenceId;
		document.getElementById('captionDivI').innerHTML=name;
		}
	</script>
	</head>
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
		<h:form style="margin-bottom: 0px">
		<input type="hidden" id="dummyholderinfluence" value="0"/>
		<div class="totalInfluenceNew">
		<table width="980" border="0" cellpadding="0" cellspacing="0" height="575">
			<tr>
				<td valign="top" align="left">
				<div class="heading_totalInfluenceNew">
			
				<table width="960" border="0" cellpadding="0" cellspacing="0">
						<tr>
						<td valign="top" align="left" width="170">
						<font class="heading_text">Influence Score </font></td>
						<td valign="top" align="left">
							<div class="mainDiv" id="main_xc">
								<div id="captionDivI" class="captionDiv">All</div> 
								<div class="textDiv" >
									<h:inputText  styleClass="fakeText" onblur="closeList('xc');" onclick="toggleList('xc')" 
										readonly="readonly" style="cursor:pointer; text-align:right; " 
										value=""/>
								</div>						    
							</div>
							<div class="listDiv" id="list_xc" onmouseover="setInList(true);" onmouseout="setInList(false);">
								<div class="itemDiv"><a  onclick="setInfluenceId('0','1');toggleList('xc');" href="#" class="optiontext">1</a></div>
								<div class="itemDiv"><a  onclick="setInfluenceId('1','2');toggleList('xc');" href="#" class="optiontext">2</a></div>
								<div class="itemDiv"><a  onclick="setInfluenceId('2','3');toggleList('xc');" href="#" class="optiontext">3</a></div>
								<div class="itemDiv"><a  onclick="setInfluenceId('4','4');toggleList('xc');" href="#" class="optiontext">4</a></div>
								<div class="itemDiv"><a  onclick="setInfluenceId('5','5');toggleList('xc');" href="#" class="optiontext">5</a></div>
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
				<td valign="top" align="center">
					<div id="influBody">
						<a href="#" onmouseover="document.getElementById('influBodyLeft').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('influBodyLeft').style.backgroundColor='#ffffff';" style="cursor: hand; text-decoration: none;">
						<div id="influBodyLeft">
							<div id="influBodyLeftImg">
								<div id="influBodyLeftImgTop">
								</div>
								<div id="influBodyLeftImgBottom">
									<div id="influBodyLeftImgBottomLeft">
										<img alt="Influence" src="../images/influLogoPopup.gif" border="0"/>
									</div>
									<div id="influBodyLeftImgBottomRight">5
									</div>
								</div>
							</div>
							
							<div id="influBodyLeftMatter">
							<div id="influBodyLeftMatterTop">
						    <div class="influBottomMatterGreen">@username<br/></div>	
							<div class="influBottomMatterGray">John Marks<br/></div>
							<div class="influBottomMatterGray" style="float: left;">ROLE:</div><div class="influBottomMatterGray1"  style="float: left; width: 180px;">Director of Awesomeness<br/></div>
							<div class="influBottomMatterGray" style="float: left;">SITE:</div><div class="influBottomMatterGreen1" style="float: left; width: 180px;">http://www.johnmarks.com</div>
							</div>
							<div id="influBodyLeftMatterBottom">
							<div class="influBottomMatterGray">STATS:<br/></div>
							<div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Brand Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Product Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Industry Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div style="width: 108px; height: 30px;">
							

							<img src="../images/Buttons/General/followingGeneral.gif" id="follow" border="0" onmouseover="this.src='../images/Buttons/rollover/followingRollover.gif'" onmouseout="this.src='../images/Buttons/General/followingGeneral.gif';" style="cursor: hand;"/>
							
							</div>
							</div>
							
							
							</div>
							
						
						</div>
						</a>
					
						
						<a href="#" onmouseover="document.getElementById('influBodyMiddle').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('influBodyMiddle').style.backgroundColor='#ffffff';" style="cursor: hand; text-decoration: none;">
						<div id="influBodyMiddle">
							<div id="influBodyLeftImg">
								<div id="influBodyLeftImgTop">
								</div>
								<div id="influBodyLeftImgBottom">
									<div id="influBodyLeftImgBottomLeft">
										<img alt="Influence" src="../images/influLogoPopup.gif" border="0"/>
									</div>
									<div id="influBodyLeftImgBottomRight">5
									</div>
								</div>
							</div>
							
							<div id="influBodyLeftMatter">
							<div id="influBodyLeftMatterTop">
						    <div class="influBottomMatterGreen">@username<br/></div>	
							<div class="influBottomMatterGray">John Marks<br/></div>
							<div class="influBottomMatterGray" style="float: left;">ROLE:</div><div class="influBottomMatterGray1"  style="float: left; width: 180px;">Director of Awesomeness<br/></div>
							<div class="influBottomMatterGray" style="float: left;">SITE:</div><div class="influBottomMatterGreen1" style="float: left; width: 180px;">http://www.johnmarks.com</div>
							</div>
							<div id="influBodyLeftMatterBottom">
							<div class="influBottomMatterGray">STATS:<br/></div>
							<div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Brand Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Product Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Industry Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div style="width: 108px; height: 30px;">
							

							<img src="../images/Buttons/General/followingGeneral.gif" id="follow" border="0" onmouseover="this.src='../images/Buttons/rollover/followingRollover.gif'" onmouseout="this.src='../images/Buttons/General/followingGeneral.gif';" style="cursor: hand;"/>
							
							</div>
							</div>
							
							
							</div>
							
						
						</div>
						</a>
						
						
						
						<a href="#" onmouseover="document.getElementById('influBodyRight').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('influBodyRight').style.backgroundColor='#ffffff';" style="cursor: hand; text-decoration: none;">
						<div id="influBodyRight">
							<div id="influBodyLeftImg">
								<div id="influBodyLeftImgTop">
								</div>
								<div id="influBodyLeftImgBottom">
									<div id="influBodyLeftImgBottomLeft">
										<img alt="Influence" src="../images/influLogoPopup.gif" border="0"/>
									</div>
									<div id="influBodyLeftImgBottomRight">5
									</div>
								</div>
							</div>
							
							<div id="influBodyLeftMatter">
							<div id="influBodyLeftMatterTop">
						    <div class="influBottomMatterGreen">@username<br/></div>	
							<div class="influBottomMatterGray">John Marks<br/></div>
							<div class="influBottomMatterGray" style="float: left;">ROLE:</div><div class="influBottomMatterGray1"  style="float: left; width: 180px;">Director of Awesomeness<br/></div>
							<div class="influBottomMatterGray" style="float: left;">SITE:</div><div class="influBottomMatterGreen1" style="float: left; width: 180px;">http://www.johnmarks.com</div>
							</div>
							<div id="influBodyLeftMatterBottom">
							<div class="influBottomMatterGray">STATS:<br/></div>
							<div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Brand Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Product Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Industry Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div style="width: 98px; height: 30px;">
							

							<img src="../images/Buttons/General/unfollowGeneral.gif" id="follow" border="0" onmouseover="this.src='../images/Buttons/rollover/unfollowRollover.gif'" onmouseout="this.src='../images/Buttons/General/unfollowGeneral.gif';" style="cursor: hand;"/>
							
							</div>
							</div>
							
							
							</div>
							
						
						</div>
						</a>
						
						
					</div>
					
				
				</td>
			</tr>
			
			
			<tr>
				<td valign="top" align="center">
					<div id="influBody">
						<a href="#" onmouseover="document.getElementById('influBodyLeft1').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('influBodyLeft1').style.backgroundColor='#ffffff';" style="cursor: hand; text-decoration: none;">
						<div id="influBodyLeft1">
							<div id="influBodyLeftImg">
								<div id="influBodyLeftImgTop">
								</div>
								<div id="influBodyLeftImgBottom">
									<div id="influBodyLeftImgBottomLeft">
										<img alt="Influence" src="../images/influLogoPopup.gif" border="0"/>
									</div>
									<div id="influBodyLeftImgBottomRight">5
									</div>
								</div>
							</div>
							
							<div id="influBodyLeftMatter">
							<div id="influBodyLeftMatterTop">
						    <div class="influBottomMatterGreen">@username<br/></div>	
							<div class="influBottomMatterGray">John Marks<br/></div>
							<div class="influBottomMatterGray" style="float: left;">ROLE:</div><div class="influBottomMatterGray1"  style="float: left; width: 180px;">Director of Awesomeness<br/></div>
							<div class="influBottomMatterGray" style="float: left;">SITE:</div><div class="influBottomMatterGreen1" style="float: left; width: 180px;">http://www.johnmarks.com</div>
							</div>
							<div id="influBodyLeftMatterBottom">
							<div class="influBottomMatterGray">STATS:<br/></div>
							<div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Brand Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Product Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Industry Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div style="width: 108px; height: 30px;">
							

							<img src="../images/Buttons/General/followingGeneral.gif" id="follow" border="0" onmouseover="this.src='../images/Buttons/rollover/followingRollover.gif'" onmouseout="this.src='../images/Buttons/General/followingGeneral.gif';" style="cursor: hand;"/>
							
							</div>
							</div>
							
							
							</div>
							
						
						</div>
						</a>
					
						
						<a href="#" onmouseover="document.getElementById('influBodyMiddle1').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('influBodyMiddle1').style.backgroundColor='#ffffff';" style="cursor: hand; text-decoration: none;">
						<div id="influBodyMiddle1">
							<div id="influBodyLeftImg">
								<div id="influBodyLeftImgTop">
								</div>
								<div id="influBodyLeftImgBottom">
									<div id="influBodyLeftImgBottomLeft">
										<img alt="Influence" src="../images/influLogoPopup.gif" border="0"/>
									</div>
									<div id="influBodyLeftImgBottomRight">5
									</div>
								</div>
							</div>
							
							<div id="influBodyLeftMatter">
							<div id="influBodyLeftMatterTop">
						    <div class="influBottomMatterGreen">@username<br/></div>	
							<div class="influBottomMatterGray">John Marks<br/></div>
							<div class="influBottomMatterGray" style="float: left;">ROLE:</div><div class="influBottomMatterGray1"  style="float: left; width: 180px;">Director of Awesomeness<br/></div>
							<div class="influBottomMatterGray" style="float: left;">SITE:</div><div class="influBottomMatterGreen1" style="float: left; width: 180px;">http://www.johnmarks.com</div>
							</div>
							<div id="influBodyLeftMatterBottom">
							<div class="influBottomMatterGray">STATS:<br/></div>
							<div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Brand Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Product Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Industry Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div style="width: 108px; height: 30px;">
							

							<img src="../images/Buttons/General/followingGeneral.gif" id="follow" border="0" onmouseover="this.src='../images/Buttons/rollover/followingRollover.gif'" onmouseout="this.src='../images/Buttons/General/followingGeneral.gif';" style="cursor: hand;"/>
							
							</div>
							</div>
							
							
							</div>
							
						
						</div>
						</a>
						
						
						
						<a href="#" onmouseover="document.getElementById('influBodyRight1').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('influBodyRight1').style.backgroundColor='#ffffff';" style="cursor: hand; text-decoration: none;">
						<div id="influBodyRight1">
							<div id="influBodyLeftImg">
								<div id="influBodyLeftImgTop">
								</div>
								<div id="influBodyLeftImgBottom">
									<div id="influBodyLeftImgBottomLeft">
										<img alt="Influence" src="../images/influLogoPopup.gif" border="0"/>
									</div>
									<div id="influBodyLeftImgBottomRight">5
									</div>
								</div>
							</div>
							
							<div id="influBodyLeftMatter">
							<div id="influBodyLeftMatterTop">
						    <div class="influBottomMatterGreen">@username<br/></div>	
							<div class="influBottomMatterGray">John Marks<br/></div>
							<div class="influBottomMatterGray" style="float: left;">ROLE:</div><div class="influBottomMatterGray1"  style="float: left; width: 180px;">Director of Awesomeness<br/></div>
							<div class="influBottomMatterGray" style="float: left;">SITE:</div><div class="influBottomMatterGreen1" style="float: left; width: 180px;">http://www.johnmarks.com</div>
							</div>
							<div id="influBodyLeftMatterBottom">
							<div class="influBottomMatterGray">STATS:<br/></div>
							<div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Brand Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Product Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div class="influBottomMatterGray1" style="float: left; padding-top: 0px; width: 150px;">No. of Industry Mentions:</div><div class="influBottomMatterGreen" style="float: left; padding-top: 0px; width: 20px;">5</div>
							<div style="width: 98px; height: 30px;">
							

							<img src="../images/Buttons/General/unfollowGeneral.gif" id="follow" border="0" onmouseover="this.src='../images/Buttons/rollover/unfollowRollover.gif'" onmouseout="this.src='../images/Buttons/General/unfollowGeneral.gif';" style="cursor: hand;"/>
							
							</div>
							</div>
							
							
							</div>
							
						
						</div>
						</a>
						
						
					</div>
					
				
				</td>
			</tr>
			<tr>
				<td valign="bottom" align="center">
					<div id="influNewFooter">
						<div id="influNewFooterLeft">
							<div id="influPrevButton">
							<table width="75" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center" class="influPrev">
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="ButtonPrev();">
									PREV
									</a>
									</td>
								</tr>
							</table>
							
							</div>
							<div id="influGeneralButton1">
							<table width="38" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center">
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="Button1();">1</a>
									</td>
								</tr>
							</table>
							</div>
							<div id="influGeneralButton2">
							<table width="38" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center" class="influPrev">
									
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="Button2();">
									2
									</a>
									
									</td>
								</tr>
							</table>
							</div>
							<div id="influGeneralButton3">
							<table width="38" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center" class="influPrev">
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="Button3();">
									3
									</a>
									</td>
								</tr>
							</table>
							</div>
							<div id="influGeneralButton4">
							<table width="38" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center" class="influPrev">
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="Button4();">
									4
									</a>
									</td>
								</tr>
							</table>
							</div>
							<div id="influGeneralButton5">
							<table width="38" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center" class="influPrev">
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="Button5();">
									5
									</a>
									</td>
								</tr>
							</table>
							</div>
							<div id="influNextButton">
							<table width="75" height="45" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="middle" align="center" class="influPrev">
									<a href="#" class="influPrev" style="color:#787E89; cursor: hand; text-decoration: none;" onclick="ButtonNext();">
									NEXT
									</a>
									</td>
								</tr>
							</table>
							
							</div>
						</div>
						<div id="influNewFooterRight">
						</div>
					</div>
				</td>
			</tr>
			
		</table>
		</div>
	</h:form>
	</f:view>
	</body>
</html>