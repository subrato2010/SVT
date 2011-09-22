<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:t="http://myfaces.apache.org/tomahawk">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/profile.css" rel="stylesheet" type="text/css" />
    <link href="../css/popup.css" rel="stylesheet" type="text/css" />
    <link href="../css/twt.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
    <script language="JavaScript" src="../js/designMainScreen.js"/>	
    <script language="JavaScript" src="../js/jquery-1.5.2.js"></script>
    <script language="JavaScript" src="../js/twt.js"></script>
    <script language="JavaScript" src="../js/ajaxForGeo.js"></script>
	<script language="JavaScript" src="../js/flexGeoPopup.js"></script>
<script language="JavaScript">
	function CloseWindow(str) {
		if(str==false) {
	
		   var bd = parent.document.getElementById("floatingDiv1");
		   bd.style.display = "none";
		   var bd = parent.document.getElementById("backDrop");
		   bd.style.display = "none";
		   parent.location.reload();
		}
	} 
	function CloseWindow1(str) {
		
			   var bd = parent.document.getElementById("floatingDiv");
			   bd.style.display = "none";
			   var bd1 = parent.document.getElementById("transParentDiv");
			   bd1.style.display = "none";

		if(str == 'true' || str == true) {
			   var clickID = parseInt(#{param.clickID})+1;
			   var realDivID = "realTime"+clickID;
			   var msgDivID = "msg"+clickID;
			   parent.document.getElementById(realDivID).style.display = 'none';
			   parent.document.getElementById(msgDivID).style.display = 'block';
		  }
	}	
	function resizeGeoLocationPopup() {
		document.getElementById('geoPopUp').style.left = 1;
		document.getElementById('geoPopUp').style.top = 120;
		
		parent.document.getElementById('floatingDiv').style.height = 400;
		parent.document.getElementById('innerMainDiv').style.height = 380;
		parent.document.getElementById('frame').style.height = 500;
	}
</script>

<f:view>
	<!--<body onload="CloseWindow(#{!replyTwitterDataController.closable});">-->
	<a4j:outputPanel rendered="#{!replyTwitterDataController.closable}">
	
	
   	<h:form id="reply">
   	<t:inputHidden value="#{replyTwitterDataController.completeFlag}" />
	<table width="430" border="0" cellspacing="0" cellpadding="0" align="center">
	<h:inputHidden value="#{replyTwitterDataController.twitterName}"/>
  		<tr>
  			<td valign="top" align="center">
			  	<table width="430" border="0" align="center" style="margin-top: 10px;">
			  		<tr>
			  			<td></td>
			  			<td colspan="2" class="influAlert2" align="left" valign="top">
			  				<table border="0" width="430" class="topFirstTablehdCategory" cellspacing="0" cellpadding="0">
			      				<tr>
			      					<td align="left" valign="top" colspan="2">
			            				<h:inputTextarea value="#{twitterController.replyMessage}" id="sendReply" cols="50" rows="6"
			            				style="resize: none" styleClass="sendrply" onkeydown="countReplyLimitChars()" onkeyup="countReplyLimitChars();" onfocus="countReplyLimitChars();"/>
			        				</td>
			       				</tr>
						       	<tr>
						        <td valign="bottom" colspan="2">
						        	<table width="430"  border="0" cellspacing="0" cellpadding="0" height="55">
						               <tr>
						                  <td class="topFirstTablehdCategoryDate" valign="top" align="right" 
						                     colspan="4">
						                  	<div class="tweet-counter" id="tweetReply" style="float: right;">0/140</div>
						                  </td>
						               </tr>
						               <tr>
							              <td class="matter" colspan="2" align="left">
							                  <!-- 
							                  <img src="../images/gunPoint.PNG"/></td><td>
							                  	<div id="addReplyLocation" style="font-weight: normal; color: rgb(126, 190, 76); 
							                  			font-size: 14px; text-decoration: none; background-image: none; background: transparent;
							                  			border-color: transparent; cursor: pointer"	
							                  			onclick="viewPopup(this);resizeGeoLocationPopup()">
							                  			Add your location 
							                  	</div>
							                  	 
							                  	<div style="width: 428px; display:none;border-width: .5em; 
							                  				border-style: solid; border-color: gray; position: absolute;" 
						                        	id="geoPopUp">
						                        	<ui:include src="searchWhatIsHappeningLocation.jsp"/> 
						                        </div> 
						                       -->
							              </td>
								          <td valign="middle" align="right">
								          
										  	<div id="replyEnabled">
											  <a4j:commandButton value="" id="reply" image="../images/Buttons/General/sendTweetbuttonGeneral.gif" 
											  	onmouseover="changeImage(this,'../images/Buttons/rollover/sendTweetbuttonRollover.gif');" 
											  	onmouseout="changeImage(this,'../images/Buttons/General/sendTweetbuttonGeneral.gif');"
											  	actionListener="#{twitterController.replyToTweet}"
											  	style="text-decoration: none; cursor: pointer;" oncomplete="javascript: CloseWindow1('#{twitterController.actionTaken}'); document.getElementById('locForTweet').value ='';">
					                          </a4j:commandButton>
					                      	</div>
					                      	
					                      	<div id="replyDisabled" style="display: none;">
												<img src="../images/Buttons/General/sendTweetGrayButton.png" border="0" width="117" style="text-decoration: none;"/>
											</div>
				                            
				                         <input type="hidden" id="locForTweet" name="locForTweet"/>
							      		 </td>
							      		   
						              </tr>
						        	</table>
						      	</td>
						     </tr>
						     <tr bgcolor="#f2f2f2">
							 	<td width="50">
							 		<img src="#{replyTwitterDataController.twitterImagePath}" height="50"/>
							 	</td>
							 	<td>
							 		<font class="rplymsg">
							 			<h:outputFormat value="#{replyTwitterDataController.twitterMsg}" escape="false" />
							 		</font>
							 	</td>
						 		
							</tr>
			     		</table>
			     	</td>
			     </tr>
			  	 <tr>
			    	<td class="closeOrangeTextAlert" valign="middle"></td>
			  	 </tr>
			  </table>
  		  </td>
      	</tr>
   	  </table>
	</h:form>
	</a4j:outputPanel>
	<!--</body>-->
</f:view>
</ui:composition>

