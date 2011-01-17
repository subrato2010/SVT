<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j">
	<!--*****************FOR EDIT PROFILE POPUP WITH  Required FIELD************ -->
	<div id="floatingDiv" class="glass" style="display:none;">
			<div id="innerMainDiv" class="innerMain">

				<div class="header"  id="popupHeader">
					<div class="menuItem demo active" title="containerIframe"></div>
					<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="left" style="padding-left:10px">
							<div class="title" id="title"></div>
							</td>
							<td valign="middle" align="right">
							<div class="edit_left_textEPP" align="right">
								* Required
							<!--
							<a href="#" onclick="closePopup()" >
									<img id="popupCloseButton" src="../images/close.gif" style="border:0px; padding-top: 5px;"  name="but1"   onmouseover="document.but1.src='../images/closeRollovers.gif'" onmouseout="document.but1.src='../images/close.gif'" />
								</a>
							-->
							</div>
							</td>
						</tr>
					</table>
				</div>
				<iframe id="frame" width="10%" height="10%" frameborder="0" scrolling="auto"></iframe>
			</div>
	</div>
	
	
	
	
	<!-- Added By Neel -->
		<div id="floatingDiv11" class="glass" style="display: none;">
		<div id="innerMainDiv11" class="innerMain1">

		<div class="header" id="popupHeader11">
		<div class="menuItem demo active" title="containerIframe11"></div>
		<table width="100%" height="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="middle" align="left">
					<div class="title11" id="title11"></div>
				</td>
				<td style="padding-left: 10px; padding-top: 5px;" valign="middle"
					align="left">
					<div class="mainDiv" id="main_xb1">
						<div id="captionDivM0" class="captionDiv">Customer #1</div>
						<div class="textDiv"><h:inputText type="text" 
								class="fakeText" onblur="closeList('xb1')"
								onclick="toggleList1('xb1')" readonly="readonly"
								style="cursor:auto; text-align:right; " value="" />
						</div>
					</div>
					
					<div class="listDiv" id="list_xb1" onmouseover="setInList(true);"
						onmouseout="setInList(false);">
					<div class="itemDiv"><a
						onclick="setCmptId('0','Customer #1'); toggleList1('xb1');" href="#"
						class="optiontext" >Customer #1</a></div>
					<div class="itemDiv"><a
						onclick="setCmptId('1','Customer #2'); toggleList1('xb1');" href="#"
						class="optiontext">Customer #2</a></div>
					<div class="itemDiv"><a
						onclick="setCmptId('2','Customer #3'); toggleList1('xb1');" href="#"
						class="optiontext">Customer #3</a></div>
					<div class="listBottomDiv"></div>
					</div>
				
				</td>

				<td valign="top" align="left">
				<div class="close" align="right" id="imageDiv"><a
					style="margin-left: 395px;" href="#" onclick=" parent.location.reload(); closePopupNew1();">
				<img id="popupCloseButton" src="../images/Alert/closeGaryButton.gif"
					style="border: 0px; padding-top: 5px; margin-right: 10px;" name="but1"
					onmouseover="document.but1.src='../images/Alert/closeGaryButton.gif'"
					onmouseout="document.but1.src='../images/Alert/closeGaryButton.gif'" />
				</a></div>
				</td>
			</tr>
		</table>

		<div class="close"></div>
		</div>
		<iframe id="frame11" width="10%" height="10%" frameborder="0"
			scrolling="auto"></iframe></div>
		</div>
		<!--  Added By Neel -->
		
		
		
		
		
		
		
		<div id="floatingDiv12" class="glass" style="display: none;">
		<div id="innerMainDiv12" class="innerMain1">

		<div class="header" id="popupHeader12">
		<div class="menuItem demo active" title="containerIframe12"></div>
		<table width="100%" height="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="middle" align="left">
					<div class="title12" id="title12"></div>
				</td>
				<td style="padding-left: 10px; padding-top: 5px;" valign="middle"
					align="left">
					<div class="mainDiv" id="main_xb2">
						<div id="captionDivM0" class="captionDiv">Customer #1</div>
						<div class="textDiv"><h:inputText type="text" 
								class="fakeText" onblur="closeList('xb2')"
								onclick="toggleList2('xb2')" readonly="readonly"
								style="cursor:auto; text-align:right; " value="" />
						</div>
					</div>
					
					<div class="listDiv" id="list_xb2" onmouseover="setInList(true);"
						onmouseout="setInList(false);">
					<div class="itemDiv"><a
						onclick="setCmptId('0','Customer #1'); toggleList2('xb2');" href="#"
						class="optiontext" >Customer #1</a></div>
					<div class="itemDiv"><a
						onclick="setCmptId('1','Customer #2'); toggleList2('xb2');" href="#"
						class="optiontext">Customer #2</a></div>
					<div class="itemDiv"><a
						onclick="setCmptId('2','Customer #3'); toggleList2('xb2');" href="#"
						class="optiontext">Customer #3</a></div>
					<div class="listBottomDiv"></div>
					</div>
				
				</td>

				<td valign="top" align="left">
				<div class="close" align="right" id="imageDiv"><a
					style="margin-left: 395px;" href="#" onclick="closePopupNew12(); parent.location.reload();">
				<img id="popupCloseButton" src="../images/Alert/closeGaryButton.gif"
					style="border: 0px; padding-top: 5px; margin-right: 10px;" name="but1"
					onmouseover="document.but1.src='../images/Alert/closeGaryButton.gif'"
					onmouseout="document.but1.src='../images/Alert/closeGaryButton.gif'" />
				</a></div>
				</td>
			</tr>
		</table>

		<div class="close"></div>
		</div>
		<iframe id="frame12" width="10%" height="10%" frameborder="0"
			scrolling="auto"></iframe></div>
		</div>
		
		
		
		
		
		
		<div class="backDrop" id="backDrop" style="display:none;"></div> 
	<div id="floatingDiv1" class="glass" style="display:none;">
			<div id="innerMainDiv1" class="innerMain1">
				<div class="headerNew"  id="popupHeader1">
					<div class="menuItem demo active1" title="containerIframe1"></div>
						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td valign="middle" align="center"  width="60">
									<img src="../images/Alert/alertSign.gif" border="0"/>
								</td>
								<td valign="middle" align="left">
								<div class="title1" id="title1"></div>
								</td>
								
						    	<td valign="top" align="left">
							    	<div class="close1">
											<a href="#" onclick="parent.location.reload(); closePopupNew(); parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';">
												<img id="popupCloseButton1" src="../images/Alert/closeButtonOrange.gif" 
												style="border:0px; padding-top: 5px;"  name="but2"   
												onmouseover="document.but2.src='../images/Alert/closeButtonOrange.gif'" 
												onmouseout="document.but2.src='../images/Alert/closeButtonOrange.gif'" />
											</a>
									</div>
							    </td>
						    </tr>
						    </table>
					
				</div>
				<iframe id="frame1" width="10%" height="10%" frameborder="0" scrolling="auto"></iframe>
			</div>
			<div style="display: none;">
			<form action="">
				<input type="button" id="GRButton" onclick="openPopup2('Optimization Completed',424, 150, 430, 190, 10, false, true, false, 'optimizationComptAlert.jsp')"/>

			</form>
			<form action="">
				<input type="button" id="GRButton1" onclick="parent.document.getElementById('ALMore').style.display='block';"/>
				<input type="button" id="GRButton2" onclick="parent.document.getElementById('ALMore1').style.display='block';"/>
				<input type="button" id="GRButton3" onclick="parent.document.getElementById('ALMore2').style.display='block';"/>
				<input type="button" id="GRButton4" onclick="parent.document.getElementById('ALMore3').style.display='block';"/>

			</form>
			</div>
	</div>
	<div class="backDrop1" id="backDrop1" style="display:none;"></div>
	
	
	
	
	
	

	<!--Green POPUP-->
	
<div id="floatingDiv2" class="glass" style="display:none;z-index:200;">
			<div id="innerMainDiv2" class="innerMain2">

				<div class="headerNew2"  id="popupHeader2">
					
					<div class="menuItem demo active2" title="containerIframe2"></div>
					
					<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td valign="middle" align="center">
									<img src="../images/Alert/alertRightButton.gif" border="0"/>
								</td>
								<td valign="middle" align="left">
								<div class="title2" id="title2"></div>
								</td>
								
						    	<td valign="top" align="left">
							    	<div class="close2">
										<a href="#" onclick="parent.location.reload(); closePopupNew2()" >
											<img id="popupCloseButton2" src="../images/Alert/closeButtonGreen.gif" style="border:0px; padding-top: 5px;"  name="but3"   onmouseover="document.but3.src='../images/Alert/closeButtonGreen.gif'" onmouseout="document.but3.src='../images/Alert/closeButtonGreen.gif'" />
										</a>
									</div>
							    </td>
						    </tr>
						    </table>
					
				</div>

				<iframe id="frame2" width="10%" height="10%" frameborder="0" scrolling="auto" src="optimizationComptAlert.jsp"></iframe>
			</div>
	</div>
	<div class="backDrop" id="backDrop" style="display:none;"></div>	
	<a4j:include viewId="commonAlertForCreatePopup.jsp"/>
		<div id="floatingDiv3" class="glass" style="display:none;">
			<div id="innerMainDiv3" class="innerMain3">
				<div class="headerNew"  id="popupHeader3">
					<div class="menuItem demo active3" title="containerIframe3"></div>
						<table width="100%" height="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td valign="middle" align="center"  width="60">
									<img src="../images/Alert/alertSign.gif" border="0"/>
								</td>
								<td valign="middle" align="left">
								<div class="title3" id="title3"></div>
								</td>
								
						    	<td valign="top" align="left">
							    	<div class="close3">
											<a href="#" onclick="parent.location.reload(); closePopupNew3(); parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';">
												<img id="popupCloseButton1" src="../images/Alert/closeButtonOrange.gif" 
												style="border:0px; padding-top: 5px;"  name="but2"   
												onmouseover="document.but2.src='../images/Alert/closeButtonOrange.gif'" 
												onmouseout="document.but2.src='../images/Alert/closeButtonOrange.gif'" />
											</a>
									</div>
							    </td>
						    </tr>
						    </table>
					
				</div>
				<iframe id="frame3" width="10%" height="10%" frameborder="0" scrolling="auto"></iframe>
			</div>
			</div>
	<div class="backDrop1" id="backDrop1" style="display:none;"></div>
	
	
	
	
	
	<div class="backDrop" id="backDrop" style="display:none;"></div>
	<div id="floatingDiv4" class="glass" style="display:none;">
			<div id="innerMainDiv4" class="innerMain">

				<div class="header"  id="popupHeader4">
					<div class="menuItem demo active4" title="containerIframe4"></div>
					<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="left" style="padding-left:10px">
							<div class="title" id="title4"></div>
							</td>
							<td valign="middle" align="right">
							<div class="edit_left_textEPP" align="right">
								
							<a href="#" onclick="closePopupNew4()" >
									<img id="popupCloseButton" src="../images/close.gif" style="border:0px; padding-top: 5px;"  name="but5"   onmouseover="document.but5.src='../images/closeRollovers.gif'" onmouseout="document.but5.src='../images/close.gif'" />
								</a>
							
							</div>
							</td>
						</tr>
					</table>
				</div>
				<iframe id="frame4" width="10%" height="10%" frameborder="0" scrolling="auto"></iframe>
			</div>
	</div>
</html>	