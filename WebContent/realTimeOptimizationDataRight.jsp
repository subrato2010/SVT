<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">


<script language="JavaScript">
		function showSuccessWindow(indexClicked) {
				   var tdID = parseInt(indexClicked)+1;
				   var realDivID = "realTime"+tdID;
				   var msgDivID = "msg"+tdID;
				   document.getElementById(realDivID).style.display = 'none';
				   document.getElementById(msgDivID).style.display = 'block';
		}
	
		function openTwitterPage(twitterName) {
	
			var url = "http://twitter.com/"+twitterName;
			window.open(url, '_blank');	 
		}
 </script>	

<f:view contentType="text/html">

<ui:include src="/templates/actionTitle.jsp" />
<div id="instanceDiv" class="countDetailsDivNew">
	<div id="instanceDivLoader">
		<table width="100%" height="60" border="0">
			<tr>
				<td valign="middle" align="center">
					<img id="preloader" src="../images/preloader3.gif" alt="preloader" width="20" height="20" style="margin-bottom: 5px;" />
				</td>
			</tr>	
		</table>		
	</div>
	<div id="instanceDivImg" style="height:0px; width:0px;padding-top:10px;padding-left:5px;"></div>
	<div id="instanceDivText" class="countDetailsTextDiv"></div>
</div>

	<table width="517" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="top" align="left">  
				 <table width="525" border="0" cellspacing="0" cellpadding="0" id="msg#{tdid}" style="display: none;"
				 	height="217">
				 	<tr style="border-color: white"  height="217">
				 		<td align="center" valign="middle"> 
				 			<div class="twtsuccess" style="text-align: center; width: 505px;">Tweet Success!</div>
				 		</td>
				 	</tr>
				 </table>
			</td>
		</tr>
	</table>
	<table width="505" border="0" cellspacing="0" cellpadding="0" id="realTime#{tdid}" style="padding-top: 6px; border-bottom:1px solid #F5F5F5;">
		<tr>
   			<td colspan="3" align="left" valign="top">
				   <div style="width: 505px; height: auto; padding-top: 4px;">
					   <table width="100%" cellpadding="0" cellspacing="0">
					   		<tr>
					   			<td valign="top" align="left">
					   				<div style="width: 60px; height: 50px; float: left;">
					   				 <h:graphicImage value="#{imglogo}" style="border-color: transparent; text-decoration: none; color: #6E7177; cursor: pointer"
					   					height="50" width="54" onclick="javascript: openTwitterPage('#{twtScreenName}');">
					             		<div style="text-align: left;">
										     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										             <span><h:outputText value="Name: " style="text-decoration: none; color: #6E7177;"/><h:outputText value="#{twtName}" style="font-weight:normal; text-decoration: none; color: #6E7177; "/></span><br/>
										             <span><h:outputText value="Location: " style="text-decoration: none; color: #6E7177;"/><h:outputText value="#{twtLocation}" style="font-weight:normal; text-decoration: none; color: #6E7177;"/></span><br/>
										             <span><h:outputText value="Tweets: " style="text-decoration: none; color: #6E7177;"/><h:outputText value="#{twtTweets}" style="font-weight:normal; text-decoration: none; color: #6E7177;"/></span><br/>
										             <span><h:outputText value="Follows: " style="text-decoration: none; color: #6E7177;"/><h:outputText value="#{twtFollows}" style="font-weight:normal; text-decoration: none; color: #6E7177;"/></span><br/>
										             <span><h:outputText value="Following: " style="text-decoration: none; color: #6E7177;"/><h:outputText value="#{twtFollowing}" style="font-weight:normal; text-decoration: none; color: #6E7177;"/></span><br/>
										             <span><h:outputText value="Listed: " style="text-decoration: none; color: #6E7177;"/><h:outputText value="#{twtListed}" style="font-weight:normal; text-decoration: none; color: #6E7177;"/></span><br/>
										     </rich:toolTip>
					      				</div>
					    				</h:graphicImage>      
					   				</div>
					   			</td>
					   			
				   				<td valign="top" align="left" bgcolor="#{boxheaderColor}">
				   					
				   					<a4j:outputPanel rendered="#{msgtype eq 'NEGATIVE'}">
				   						<div style="float: left;">
										   <div class="RTOBody"> 
										        <font style="color:#FFFFFF">@<a style='color:#3482BD;font-size:13px;text-decoration: none;cursor: pointer' target='_blank' href='http://twitter.com/#{twtScreenName}'>#{twtScreenName}</a></font> 
										        <font style="color:#FFFFFF"><h:outputFormat value="#{twtMessage}" escape="false" /></font>
										   </div>
								   		</div>
				   					</a4j:outputPanel>	
				   					
				   				<a4j:outputPanel rendered="#{!(msgtype eq 'NEGATIVE')}">
									<div style="float: left;">
										<div class="RTOBody">
											<div style="height: 15px; float: left; margin-right: 5px; width: 18px;">
			                            		<img id="twitterLogo_#{tdid}" style="cursor: pointer;" src="../images/twitterSmallLogoTextArea.gif" 
			                            			onmouseover="showScoreTooltip(this, 'twitterLogotextAreaTooltip_#{tdid}');" 
			                            			onmouseout="hideTwitterLogoToolTip('#{tdid}');"/>
			                            	</div>
	                   					
			             					<font style="color:#3482BD">@<a style='color:#3482BD;font-size:13px;text-decoration: none;cursor: pointer' target='_blank' href='http://twitter.com/#{twtScreenName}'>#{twtScreenName}</a></font> 
					        				<font style="color:#6E7177"><h:outputFormat value="#{twtMessage}" escape="false" /></font>
									        	
		             					</div>
									<div id="twitterLogotextAreaTooltip_#{tdid}" class="twitterLogotextAreaTooltipRight">
                    					<div id="mouseover_tooltip_section">
                        					<div id="mouseover_tooltip_section_left">
                           					<div id="mouseover_tooltip_section_left_arrow"></div>
                        					</div>
                        					<div id="mouseover_tooltip_section_right">
                                           	
                                           	<div id="mouseover_tooltip_section_right_middle">
                                                <h:outputText value="Influence Score: " styleClass="tweetToolTipTitle"/><br/>
                                                <div style="width: 130px; height: 20px; margin-left: 10px;">
	                                                <table width="100%">
		                                                <tr>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner1" class="influenceRound">
		                                                			<h:outputText value="1" styleClass="influenceRound" rendered="#{(twtInfluence) != 1}"/>
		                                                			<h:outputText value="#{twtInfluence}" styleClass="influenceRoundSelect" rendered="#{(twtInfluence) == 1}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner2"  class="influenceRound">
		                                                			<h:outputText value="2" styleClass="influenceRound" rendered="#{(twtInfluence) != 2}"/>
		                                                			<h:outputText value="#{twtInfluence}" styleClass="influenceRoundSelect" rendered="#{(twtInfluence) == 2}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner3" class="influenceRound">
		                                                			<h:outputText value="3" styleClass="influenceRound" rendered="#{(twtInfluence) != 3}"/>
		                                                			<h:outputText value="#{twtInfluence}" styleClass="influenceRoundSelect" rendered="#{(twtInfluence) == 3}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner4" class="influenceRound">
		                                                			<h:outputText value="4" styleClass="influenceRound" rendered="#{(twtInfluence) != 4}"/>
		                                                			<h:outputText value="#{twtInfluence}" styleClass="influenceRoundSelect" rendered="#{(twtInfluence) == 4}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner5" class="influenceRound">
		                                                			<h:outputText value="5" styleClass="influenceRound" rendered="#{(twtInfluence) != 5}"/>
		                                                			<h:outputText value="#{twtInfluence}" styleClass="influenceRoundSelect" rendered="#{(twtInfluence) == 5}"/>
		                                                		</div>
		                                                	</td>
		                                                </tr>
	                                                </table>
                                                </div>
                                               
                                                <h:outputText value="Friend Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{twtFollowing}" styleClass="tweetToolTipData"/><br/>
											    <h:outputText value="Follower Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{twtFollows}" styleClass="tweetToolTipData"/><br/>
											    <h:outputText value="Listed Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{twtListed}" styleClass="tweetToolTipData"/><br/>
											    <h:outputText value="Status Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{twtTweets}" styleClass="tweetToolTipData"/><br/>
                                           	</div>
                							</div>
            							</div>
           							</div>		             				
		             					

					   				</div>
			   					</a4j:outputPanel>
			   					</td>
			   					
					   			<td valign="top" align="left">
					   			<div style="float:  right;">
					   					
						   			<a4j:outputPanel rendered="#{msgtype eq 'NEGATIVE'}">
								   		<table width="100%" cellpadding="0" cellspacing="0">
										   <tr>
										   		<td valign="top" align="left" height="27">
										   			<a href="#" onclick="openPopup('Reply to @#{twtScreenName}', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 150, 470, 270, 10, false, true, false, 'reply.jsp?clickID=#{tdid-1}')">
										         		<img src="../images/Buttons/General/reply.gif" border="0"  onmouseover="this.src='../images/Buttons/rollover/replyRollover.gif';" onmouseout="this.src='../images/Buttons/General/reply.gif';"/>
										    		</a>
										    	</td>
										   </tr>
							   			</table>
								   </a4j:outputPanel>
								   
									<a4j:outputPanel rendered="#{!(msgtype eq 'NEGATIVE')}">
								   		<table width="100%" cellpadding="0" cellspacing="0">
						   					<tr>
						   						<td valign="top" align="left" height="25">
						              			 	<a href="#" onclick="openPopup('Retweet this to your followers?', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 150, 470, 220, 10, false, true, false, 'reTweet.jsp?clickID=#{tdid-1}')">
						                 				<img src="../images/Buttons/General/retweet.gif" border="0"   onmouseover="this.src='../images/Buttons/rollover/retweetRollover.gif';" onmouseout="this.src='../images/Buttons/General/retweet.gif';"/>
						                			</a>
						                		</td>
						   					</tr>
										   <tr>
										   		<td valign="top" align="left" height="27">
										   			<a href="#" onclick="openPopup('Reply to @#{twtScreenName}', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 150, 470, 270, 10, false, true, false, 'reply.jsp?clickID=#{tdid-1}')">
										         		<img src="../images/Buttons/General/reply.gif" border="0"  onmouseover="this.src='../images/Buttons/rollover/replyRollover.gif';" onmouseout="this.src='../images/Buttons/General/reply.gif';"/>
										    		</a>
										    	</td>
										   </tr>
										   
										   <tr>
									   		   <td valign="top" align="left" height="25">
									   		   	<img id="twitterActions_#{tdid}" style="cursor: pointer;" src="../images/actionButtonGeneral.png" 
									   		   		onmouseover="this.src='../images/actionButtonrollover.png'; hideAllActions(); showActionPopup('#{tdid}');" 
									   		   		onmouseout="this.src='../images/actionButtonGeneral.png'; closeActionPopupTime();"/>
									    	  </td>
										  </tr>
							   		</table>
							   		<input type="hidden" id="fullTweet_#{tdid}" name="fullTweet_#{tdid}" value="#{fullTweetMsg}"/>
							   		<input type="hidden" name="tweetToFavorite_#{tdid}" id="tweetToFavorite_#{tdid}" value="#{twitterStatusID}" />
							   		<div id="twitterOptActions_#{tdid}" class="twitterOptActionsRight" onmouseover="cancelCloseTime();" 
								   		onmouseout="closeActionPopupTime();">
                                         <div id="mouseoverTwitterActions">             
                                         		<h:graphicImage value="../images/actionsDirectMessageGeneral.png" style="border: 0; cursor: pointer;" rendered="#{isFriend}"
                                         			onclick="openPopup('DM to @#{twtScreenName}', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 350, 550, 550, 220, 10, false, true, false, 'directMessage.jsp?tweetID=#{twitterStatusID}&amp;dmTo=#{twtScreenName}')" 
                                       				onmouseover="this.src='../images/actionsDirectMessageRollover.png'; showTitle(this, 'actionTitleDiv', 100, 30, 'Direct Message #{twtName}');" 
                                       				onmouseout="this.src='../images/actionsDirectMessageGeneral.png'; hideTitle('actionTitleDiv');" />                                       				                            		                                       			                                       		
	                                         	<h:graphicImage value="../images/actionsDirectMessageGeneralDisable.png" style="border: 0; cursor: pointer;" rendered="#{!isFriend}" />
                                         			
                                         		<img id="composeTweetImg#{tdid}" src="../images/actionsTweetGeneral.png" border="0" 
                                         			style="cursor: pointer;"  
                                         			onclick="expandInputDiv('#{tdid-1}');countLimitChars('#{tdid-1}');" 
                                         			onmouseover="this.src='../images/actionsTweetRollover.png'; showTitle(this, 'actionTitleDiv', 100, 30, 'Compose Tweet to #{twtName}');" 
                                         			onmouseout="this.src='../images/actionsTweetGeneral.png'; hideTitle('actionTitleDiv');"/>
	                                         	
	                                         	<h:outputLink value="#"
		                                         	onclick="this.href='mailto:?subject=Check out this tweet from @#{twtScreenName}&amp;body=#{twtScreenName}: '+encodeURIComponent(document.getElementById('fullTweet_#{tdid}').value)+'%0A%0A Original Tweet:  http://twitter.com/#{twtScreenName}/statuses/#{twitterStatusID} %0A%0A%0A Sent via Optimizer for Twitter (www.terametric.com)';">
	                                         		<img id="emailTweetImg#{tdid}" src="../images/actionsEmaiGeneral.png"
	                                         			border="0" style="cursor: pointer;"                                          			 
	                                         			onmouseover="this.src='../images/actionsEmailRollover.png'; showTitle(this, 'actionTitleDiv', 50, 30, 'Email Tweet');" 
	                                         			onmouseout="this.src='../images/actionsEmaiGeneral.png'; hideTitle('actionTitleDiv');"/>
	                                         	</h:outputLink>
	                                         	
	                                         	<!-- <img src="../images/actionsRetweetGeneral.png" style="cursor: pointer;" title="Retweet" border="0" onclick="openPopup('Retweet this to your followers?', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 550, 470, 220, 10, false, true, false, 'reTweet.jsp?clickID=#{tdid-1}')" onmouseover="this.src='../images/actionsRetweetRollover.png';" onmouseout="this.src='../images/actionsRetweetGeneral.png';"/>
	                                         	<img src="../images/actionsReplyGeneral.png" style="cursor: pointer;" title="Reply" border="0" onclick="openPopup('Reply to @#{twtScreenName}', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 550, 470, 270, 10, false, true, false, 'reply.jsp?clickID=#{tdid-1}')" onmouseover="this.src='../images/actionsReplyRollover.png';" onmouseout="this.src='../images/actionsReplyGeneral.png';"/> -->
	                                         	
	                                         	<a4j:commandLink actionListener="#{popupController.tweetToFavorite}" oncomplete="document.getElementById('valueHidden#{tdid}').value='Yipee! Tweet successfully favorited.'; document.getElementById('xHidden#{tdid}').value='125';">	                                         		
	                                         		<img id="favImage_#{tdid}" src="../images/favoriteActionGeneral.png" 
	                                         			border="0" style="cursor: pointer;"
	                                         			onmouseover="this.src='../images/favoriteActionRollover.png'; showTitle(this, 'actionTitleDiv', document.getElementById('xHidden#{tdid}').value, 30, document.getElementById('valueHidden#{tdid}').value);" 
	                                         			onmouseout="this.src='../images/favoriteActionGeneral.png'; hideTitle('actionTitleDiv');"/>
	                                         		<f:param name="favoriteBy" value="#{twitterController.clickedCustomer}"/>
	                                         		<f:param name="forIndex" value="#{tdid}"/>
	                                         		<f:param name="fromTweetFeed" value="fromTweetFeed" />
	                                         	</a4j:commandLink>
	                                         	<input type="hidden" id="valueHidden#{tdid}" value="Favorite this Tweet" />  
	                                         	<input type="hidden" id="xHidden#{tdid}" value="70" />   
	                                         </div>
                 					</div>
                 						
								  </a4j:outputPanel>
						   					
						   					
					   					</div>
					   			</td>
					   		</tr>
						</table>
				   </div>
   				</td>
  		</tr>
        
        <tr>
			<td width="60">
				<div style="margin-left:15px;"><a href="" id="collapse_#{tdid-1}" style="text-decoration: none; cursor: pointer; font-size: 17px; color: #6E7177;" onclick="expandInputDiv('#{tdid-1}');countLimitChars('#{tdid-1}');"><img src="../images/plus.png" border="0"/></a></div>
			</td>
			<td  width="380" valign="top" align="left">
				<div  class="ratingTotal">
					<div class="ratingTotalLeft">
						<div class="ratingtotalleftTop">#{twtName}, #{twtDate}, via #{twtSource}</div>
						<!-- <div class="ratingTotalLeftBottom">REPORT THIS AS SPAM</div> -->
						
					</div>

				</div>
			</td>
			<td width="60" valign="top" align="left">
			</td>
		</tr>
		<tr height="7">
			<td colspan="3"></td>
		</tr>
        
        <tr>
			<td width="60"></td>
            <td colspan="2">
				<div id="inputDiv_#{tdid-1}" style="display: none;">	            
		            <h:form>
		            	<input type="hidden" id="twtTxtSelectedR_#{tdid-1}" name="twtTxtSelected_#{tdid-1}" value=""/>
						<table width="440" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
	
		                	<tr>
			                  <td valign="top" align="left" colspan="3">
			                  	                    
					                <div id="countdetails_#{tdid-1}" class="countDetailsDiv">
					       			<div id="countDetailsLoader_#{tdid-1}" class="countDetailsLoader">
											<img id="preloader" src="../images/preloader3.gif" style="position: center; margin-top: 10px; margin-left: 38px; width:20px;" alt="preloader"/>
									</div>
					       			<div id="countDetailsText_#{tdid-1}" class="countDetailsTextDiv"></div>
				      			</div>
				      			
			                  </td>
			           		</tr>
		                	
		                	<tr>
								<td width="50" valign="top" align="left">
		                              <h:graphicImage value="../images/#{textarealogo}" 
		     							onmouseover="this.src='../images/#{textarealogo}';" onmouseout="this.src='../images/#{textarealogo}';" style=" margin-right:5px">
		    							<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
		        							<span><h:outputText value="#{textarealogotooltip}" /></span>
		    							</rich:toolTip>
										</h:graphicImage>
		                         </td>
		                         <td valign="top" align="center">
		                         <input type="hidden" name="indexClicked" value="#{tdid-1}"/>
		                          <input type="hidden" name="sideClicked" value="Right"/>
		                          <input type="hidden" name="individualTweet" id="individualTweet_#{tdid-1}" value="#{referenceName}"/>
		                         	<!--<textarea name="individualTweet" id="individualTweet_#{tdid-1}"  
	                         	 		   style="width: 280px; height: 70px; background-image: none; border: 2px inset #6E7177;margin-right: 5px; 
	                         	 		   color: #B6D976; padding-left: 3px; padding-top: 3px; font-size: 12px; resize: none;"
	                         	 		   onkeydown="countLimitChars('#{tdid-1}');" onkeyup="setData('#{tdid-1}');">#{referenceName}
	                         	 	</textarea -->
	                         	 	<div id="referenceName_#{tdid-1}" contenteditable="true" class="tweet-area" 
		                         	  	onkeydown="countLimitChars('#{tdid-1}');createDynamicStyling(event);displayOff('#{tdid-1}');" 
		                         	  	onkeyup="countLimitChars('#{tdid-1}');setData('#{tdid-1}');" 
		                         	  	onmouseup="getMousePositionOnSelectionOnMouseUp(event); displayCountdetailsRTODivOn('#{tdid-1}', 'R', '../images/#{textarealogo}');" 
		                         	  	onblur="displayCountdetailsRTODivOff('#{tdid-1}', 'R');" onmousedown="getMousePositionOnSelectionOnMouseDown(event);">#{referenceName}</div>
		                         </td>
		                         <td width="120" valign="bottom">
		                         	 <table width="100%" border="0" cellspacing="0" cellpadding="0" height="55">
										<tr>
											<td class="topFirstTablehdCategoryDate" valign="top" align="left">
												<div class="one-fourty" id="numberofWord_#{tdid-1}">0/140</div>
											</td>
										</tr>
										<tr>
											<td valign="bottom" align="left" style="font-size: 24px; padding-top: 30px;">
												
												<div id="sendTweetEnabled_#{tdid-1}">
													<a4j:commandLink id="rightTWT" style="cursor: pointer;" action="#{twitterController.sendTweetBasedOnRule}"
														oncomplete="javascript: showSuccessWindow('#{tdid-1}'); document.getElementById('transParentDocDiv').style.display='none';"
														onclick="change()">
														<f:param name="index" value="#{tdid-1}"/>
														<f:param name="sideClk" value="Right"/>
														<img src="../images/Buttons/General/sendTweetbuttonGeneral.gif" border="0" width="117" onmouseover="changeImage(this,'../images/Buttons/rollover/sendTweetbuttonRollover.gif');" onmouseout="changeImage(this,'../images/Buttons/General/sendTweetbuttonGeneral.gif');" style="cursor: pointer; text-decoration: none;"/>
													</a4j:commandLink>
												</div>
												
												<div id="sendTweetDisabled_#{tdid-1}" style="display: none;">
													<img src="../images/Buttons/General/sendTweetGrayButton.png" border="0" width="117" style="text-decoration: none;"/>
												</div>
												
											</td>
										</tr>
		                              </table>
		                          </td>
							  </tr>
		                      <tr>
								 <td width="50" valign="top" align="left"></td>
		                         <td valign="top" align="center" colspan="2" class="RTOBody2">Tweet Input: #{textareafooter}</td>
		                      </tr>
		                  </table>
		                </h:form>
		               </div>
				</td>
			</tr>
		</table>
		<div id="countdetailsRTOR#{tdid-1}" class="countDetailsDivRTO">
    		<div id="countDetailsLoaderRTOR#{tdid-1}" class="countDetailsLoader">
				<img id="preloaderRTOR#{tdid-1}" src="../images/preloader3.gif" class="preloaderRTO" alt="preloader"/>								
			</div>
			<div id="countdetailsRTORImgDiv#{tdid-1}" class="countdetailsRTOImgDiv">
				<img id="countdetailsRTORImg#{tdid-1}" style="display: none;"/>
			</div>
    		<div id="countDetailsTextRTOR#{tdid-1}" class="countDetailsTextDivRTO"></div>
  	</div>
</f:view>
</ui:composition>