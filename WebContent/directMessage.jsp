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
    <script language="JavaScript" src="../js/twt.js"></script>

	<f:view>
		
	   <h:form id="directMessage" style="margin: 0px;">
	   	
	   	<input type="hidden" id="directMessageTo" name="directMessageTo" value="#{param.dmTo}"/>
	   	<input type="hidden" id="directMessageBy" name="directMessageBy" value="#{twitterController.clickedCustomer}"/>
	   	<input type="hidden" id="tweetId" name="tweetId" value="#{param.tweetID}"/>
		
		<table width="430" border="0" cellspacing="0" cellpadding="0" align="center">
	  		<tr>
	  			<td valign="top" align="center">
				  	<table width="430" border="0" align="center" style="margin-top: 10px;">
				  		<tr>
				  			<td colspan="2" class="influAlert2" align="left" valign="top">
				  				<table border="0" width="430" class="topFirstTablehdCategory" cellspacing="0" cellpadding="0">
				      				<tr>
				      					<td align="left" valign="top">
				            				<textarea name="individualTweet" id="individualTweet" cols="30" rows="4" style="resize: none" class="sendDM" onkeydown="countTweetLimitChars(this,'none')" onkeyup="countTweetLimitChars(this,'none');" onfocus="countTweetLimitChars(this,'none');"></textarea>
				        				</td>
				        				<td valign="bottom"  align="center">
								        	<table border="0" cellspacing="0" cellpadding="0" height="100%" align="center">
								               <tr>
								                  	<td class="topFirstTablehdCategoryDate" valign="top">
								                  		<div class="tweet-counter" id="tweetWords" style="float: left;">0/140</div>
								                  	</td>
								                 </tr>
								                 <tr>
									                  <td valign="middle" align="right">
													  	<div id="composeEnabled_none">
														  <a4j:commandButton id="sendDM" image="../images/Buttons/General/sendTweetbuttonGeneral.gif" onmouseover="changeImage(this,'../images/Buttons/rollover/sendTweetbuttonRollover.gif');" 
														  	onmouseout="changeImage(this,'../images/Buttons/General/sendTweetbuttonGeneral.gif');"
														  	actionListener="#{popupController.directMessageToReturn}" style="text-decoration: none; cursor: pointer;">
											    			
								                          </a4j:commandButton>
								                      	</div>
								                      	
								                      	<div id="composeDisabled_none" style="display: none;">
															<img src="../images/Buttons/General/sendTweetGrayButton.png" border="0" width="117" style="text-decoration: none;"/>
														</div>
										      		 </td>
								               </tr>
								        	</table>
							      		</td>
				       				</tr>
				     			</table>
				     		</td>
				     	</tr>
				  	 	<tr>
				    		<td class="closeOrangeTextAlert" valign="middle">
								<a	onclick="parent.document.getElementById('floatingDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
								href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;"> CLOSE </a>
							</td>
				  	 	</tr>
				  	</table>
	  		  	</td>
	      	</tr>
	   	  </table>
		</h:form>
	</f:view>
</ui:composition>

