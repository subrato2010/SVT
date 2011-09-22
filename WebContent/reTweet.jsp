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
    <script language="JavaScript" src="../js/designMainScreen.js"></script>
    <script language="JavaScript" src="../js/twt.js"></script>
    <script language="JavaScript">
	function CloseWindow(str) {
		if(str==false || str=='false') {

		   var bd = parent.document.getElementById("floatingDiv1");
		   bd.style.display = "none";
		   bd1 = parent.document.getElementById("backDrop");
		   bd.style.display = "none";
		   parent.location.reload();
		}
	} 


	
	function CloseWindow1(str) {

		//alert(str);
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

 	</script>
	<f:view>
	<h:inputHidden value="#{twitterController.actionTaken}"/>
	<!--<body onload="CloseWindow(#{!replyTwitterDataController.closable});">-->
	<a4j:outputPanel rendered="#{!(replyTwitterDataController.closable)}">
   	<h:form id="reply">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<h:inputHidden value="#{replyTwitterDataController.twitterName}"/>
	<input type="hidden" name="reTweetMsg" id="reTweetMsg"/>
	
  		<tr>
  			<td valign="top" align="center">
  				<table width="95%" border="0" align="center" style="margin-top: 10px;">
  					<tr>
  						<td></td>
  						<td colspan="3" class="influAlert2" align="left" valign="top">
			  				<table border="0"  cellspacing="0" cellpadding="0" width="430">
							      <tr>
								 	<td align="left" width="50"><img width="48" height="48" src="#{replyTwitterDataController.twitterImagePath}"/></td>
							 		<td width="5"></td>
							 		<td>
						 				<div id="retweetText" class="reTweetArea" contenteditable="true" onkeydown="countRetweetLimitChars();" 
						 				onkeyup="countRetweetLimitChars(); setRTMsg();" onfocus="countRetweetLimitChars();"></div>
							 		</td>
								 </tr>
								 <tr>
									<td valign="top" align="right" colspan="3" class="topFirstTablehdCategoryDate">
						                  <div style="float: right;" id="reTweet" class="tweet-counter">0/140</div>
						            </td>
						        </tr>
								 
				                 <tr>
				              		<td valign="middle" align="right" colspan="3" height="40">
				              			
				              			<div id="reTweetEnabled">
											<a4j:commandButton value="" id="reply" image="../images/Buttons/General/sendTweetbuttonGeneral.gif"
												onmouseover="changeImage(this,'../images/Buttons/rollover/sendTweetbuttonRollover.gif');" 
												onmouseout="changeImage(this,'../images/Buttons/General/sendTweetbuttonGeneral.gif');"
												actionListener="#{twitterController.reTwittMessage}"
												style="text-decoration: none; cursor: pointer;" 
												oncomplete="javascript: CloseWindow1('#{twitterController.actionTaken}');">
												
												<f:param name="twtScreenName" value="#{replyTwitterDataController.twitterName}"/>
					                        </a4j:commandButton>
				                        </div>
				                        
				                        <div id="reTweetDisabled" style="display: none;">
											<img src="../images/Buttons/General/sendTweetGrayButton.png" border="0" width="117" style="text-decoration: none;"/>
										</div>
								     </td>
				                 </tr>
			     			</table>
     					</td>
     				</tr>
  					<tr>
    					<td class="closeOrangeTextAlert" valign="middle"></td>
  					</tr>
  					
  					<script>
							document.getElementById('retweetText').innerHTML = "RT @" + "#{replyTwitterDataController.twitterName}" + " " + "#{replyTwitterDataController.twitterMsg}";
					 		setTweetMsg();
					 		countRetweetLimitChars();
					</script>
  				</table>
  			</td>
  		</tr>
	</table>
	</h:form>
	</a4j:outputPanel>
	<!--</body>-->
  </f:view>
</ui:composition>

