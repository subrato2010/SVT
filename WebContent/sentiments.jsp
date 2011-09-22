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
	
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>

	<script language="JavaScript">
		function setMentionsId(mentionsId,MentionsName){
		document.getElementById('dummyholdermentions').value=mentionsId;
		document.getElementById('captionDivM').innerHTML=MentionsName;
		}

		function setInfluenceId(influenceId,name){
			document.getElementById('dummyholderinfluence').value=influenceId;
			document.getElementById('captionDivI').innerHTML=name;
			}
		
	</script>
	
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
		<h:form style="margin: 0px;">
		<input type="hidden" id="dummyholdermentions" value="0"/>
		<input type="hidden" id="dummyholderinfluence" value="0"/>
		<div class="total">
		<table width="760" border="0" cellpadding="0" cellspacing="0"  height="635">
		<tr>
			<td valign="top" align="center">
			<table width="750" border="0" cellpadding="0" cellspacing="0" height="520">
			<tr height="95">
				<td valign="top" align="left">
				<div class="heading_total">
				<div class="headingSent">
				<table width="550" border="0" cellpadding="0" cellspacing="0"  style="margin-left:10px; margin-top:8px;">
						<tr><td valign="top" align="left"><font class="heading_text">Mentions about </font></td>
						<td valign="top" align="left">
							<div class="mainDiv" id="main_xa">
							<div id="captionDivM" class="captionDiv">Product</div>
							<div class="textDiv"><h:inputText type="text"
								class="fakeText" onblur="closeList('xa');"
								onclick="toggleList('xa')" readonly="readonly"
								style="cursor:pointer; text-align:right; " value="" /></div>
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
				<td valign="top" align="left">
				
							
							
							
							
							<div class="mainDivSentNew" id="main_xc">
								<div id="captionDivI" class="captionDiv">All</div> 
								<div class="textDiv" >
									<h:inputText  styleClass="fakeTextSentNew" onblur="closeList('xc');" onclick="toggleList('xc')" 
										readonly="readonly" style="cursor:pointer; text-align:right; " 
										value=""/>
								</div>						    
							</div>
							<div class="listDivSentNew" id="list_xc" onmouseover="setInList(true);" onmouseout="setInList(false);">
								<div class="itemDivSentNew"><a  onclick="setInfluenceId('0','Score1');toggleList('xc');" href="#" class="optiontext">Score1</a></div>
								<div class="itemDivSentNew"><a  onclick="setInfluenceId('1','Score2');toggleList('xc');" href="#" class="optiontext">Score2</a></div>
								<div class="itemDivSentNew"><a  onclick="setInfluenceId('2','Score3');toggleList('xc');" href="#" class="optiontext">Score3</a></div>
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
			
			<div id="SentBody">
				<a href="#" style="text-decoration: none;" onmouseover="document.getElementById('SentBodyEach').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('SentBodyEach').style.backgroundColor='#F9F9F9';">
				<div id="SentBodyEach">
						<div id="SentiBodyEachTop">
							<div id="SentiBodyLeft">
								<img alt="logo" src="../images/SentLogoBird.gif" style="border:1px solid #D7D7D7"/>
							</div>
							<div id="SentiBodyRight">
								<div id="SentiBodyRight1">
								twiteconomy <font style="font-weight: normal;">Tweeter Economy</font>
								</div>
								
								<div id="SentiBodyRight2">
								Wash Post How to decipher text rumors the nerd equivalent of celbrity gossip
								</div>
								<div id="SentiBodyRight3">
								htt://wapo.st/fW0zxc #business
								</div>
								
								<div id="SentiBodyRight4">
								2 MINUTES AGO - on <font style="color: #77C442;">yahoo</font>
								</div>
								<div id="SentiBodyRight5">
								<table width="200" border="0" cellpadding="0" cellspacing="0" style="margin-top: 4px;">
								<tr>
									<td valign="top" align="left">
										<img alt="Favorite" src="../images/favorite.gif" border="0"/>
									</td>
									<td valign="top" align="left">
										<img alt="Retweet" src="../images/retweet.gif" border="0"/>
									</td>
									<td valign="top" align="left">
										<img alt="Reply" src="../images/reply.gif" border="0"/>
									</td>
								</tr>
								
								</table>
								</div>
							</div>
						</div>
						<div id="SentiBodyEachBottom">
						
							<div id="SentiBodyEachBottomLeft">
							<img src="../images/sentiHearts.gif" border="0"/>
							</div>
							<div id="SentiBodyEachBottomRight">
							3.93
							</div>
						</div>
				</div>
				</a>
				
				
				
				
				
				<a href="#" style="text-decoration: none;" onmouseover="document.getElementById('SentBodyEach1').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('SentBodyEach1').style.backgroundColor='#F9F9F9';">
				<div id="SentBodyEach1" style="margin-top: 10px;">
						<div id="SentiBodyEachTop">
							<div id="SentiBodyLeft">
								<img alt="logo" src="../images/SentLogoBird.gif" style="border:1px solid #D7D7D7"/>
							</div>
							<div id="SentiBodyRight">
								<div id="SentiBodyRight1">
								twiteconomy <font style="font-weight: normal;">Tweeter Economy</font>
								</div>
								
								<div id="SentiBodyRight2">
								Wash Post How to decipher text rumors the nerd equivalent of celbrity gossip
								</div>
								<div id="SentiBodyRight3">
								htt://wapo.st/fW0zxc #business
								</div>
								
								<div id="SentiBodyRight4">
								2 MINUTES AGO - on <font style="color: #77C442;">yahoo</font>
								</div>
								<div id="SentiBodyRight5">
								<table width="200" border="0" cellpadding="0" cellspacing="0" style="margin-top: 4px;">
								<tr>
									<td valign="top" align="left">
										<img alt="Favorite" src="../images/favorite.gif" border="0"/>
									</td>
									<td valign="top" align="left">
										<img alt="Retweet" src="../images/retweet.gif" border="0"/>
									</td>
									<td valign="top" align="left">
										<img alt="Reply" src="../images/reply.gif" border="0"/>
									</td>
								</tr>
								
								</table>
								</div>
							</div>
						</div>
						<div id="SentiBodyEachBottom">
						
							<div id="SentiBodyEachBottomLeft">
							<img src="../images/sentiHearts.gif" border="0"/>
							</div>
							<div id="SentiBodyEachBottomRight">
							3.93
							</div>
						</div>
				</div>
				</a>
				
				
				
				
				<a href="#" style="text-decoration: none;" onmouseover="document.getElementById('SentBodyEach2').style.backgroundColor='#E9FFD8';" onmouseout="document.getElementById('SentBodyEach2').style.backgroundColor='#F9F9F9';">
				<div id="SentBodyEach2" style="margin-top: 10px;">
						<div id="SentiBodyEachTop">
							<div id="SentiBodyLeft">
								<img alt="logo" src="../images/SentLogoBird.gif" style="border:1px solid #D7D7D7"/>
							</div>
							<div id="SentiBodyRight">
								<div id="SentiBodyRight1">
								twiteconomy <font style="font-weight: normal;">Tweeter Economy</font>
								</div>
								
								<div id="SentiBodyRight2">
								Wash Post How to decipher text rumors the nerd equivalent of celbrity gossip
								</div>
								<div id="SentiBodyRight3">
								htt://wapo.st/fW0zxc #business
								</div>
								
								<div id="SentiBodyRight4">
								2 MINUTES AGO - on <font style="color: #77C442;">yahoo</font>
								</div>
								<div id="SentiBodyRight5">
								<table width="200" border="0" cellpadding="0" cellspacing="0" style="margin-top: 4px;">
								<tr>
									<td valign="top" align="left">
										<img alt="Favorite" src="../images/favorite.gif" border="0"/>
									</td>
									<td valign="top" align="left">
										<img alt="Retweet" src="../images/retweet.gif" border="0"/>
									</td>
									<td valign="top" align="left">
										<img alt="Reply" src="../images/reply.gif" border="0"/>
									</td>
								</tr>
								
								</table>
								</div>
							</div>
						</div>
						<div id="SentiBodyEachBottom">
						
							<div id="SentiBodyEachBottomLeft">
							<img src="../images/sentiHearts.gif" border="0"/>
							</div>
							<div id="SentiBodyEachBottomRight">
							3.93
							</div>
						</div>
				</div>
				</a>
			
			</div>
			
			
			
			
			
			
			</td>
			</tr>
			
			
		
		
		
		</table>
			
			</td>
		</tr>
		<tr>
			<td valign="bottom" align="left">
			<div id="sentNewFooter">
						<div id="sentNewFooterLeft">
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
						<div id="sentNewFooterRight">
						</div>
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