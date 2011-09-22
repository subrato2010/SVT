<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:twt="http://richfaces.org/session-data-helper">
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<link href="../css/twt.css" rel="stylesheet" type="text/css" />
	<link href="../css/top.css" rel="stylesheet" type="text/css" />
	<link href="../css/tagsupport.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>	
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js" />
	<script language="JavaScript" src="../js/twt.js"></script>
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<script language="JavaScript" src="../js/top.js"></script>
	<script language="JavaScript" src="../js/tagsupport.js"></script>	
	<script language="JavaScript" src="/TWT/faces/a4j/g/3_3_2.SR1org/richfaces/renderkit/html/scripts/jquery/jquery.js"></script>
	
<a4j:form id="retweetToThank" style="margin: 0px;">
	<div id="popupDiv">
		<div id="rtThanksLoader">
			<img id="preloader" src="../images/preloader3.gif" style="position: center; margin-top: 80px; margin-left: 380px;" alt="preloader"/>
		</div>
		
		<table width="910" border="0" cellspacing="0" cellpadding="0" height="100%">
			<tr>
				<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0" height="30">
				<table cellpadding="0" cellspacing="0" border="0" width="800">
					<tr height="35">
						<td align="left" valign="middle" width="120">
							<font style="color: #EDEDED; padding-left: 20px; width: 110px;">For profile</font>
						</td>
						<td align="left" valign="middle">
							<div class="fileinputs1" style="width: 30px; color: #7D848B;">								
				             	<twt:menu id="rtThanksList" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"
									options="#{rtopHandler.actionInfluencerTwitterAccounts}" 
									style="background-image: url('../images/dropCombo.gif');width:264px; height:22px;"
									listStyle="width:264px;"
									optionStyle="width:242px;">
											
									<a4j:support event="onchange" 
				                		actionListener="#{rtopHandler.optimizeActionRetweetToThanksChange}" reRender="rtThanksPanel"
				                		onsubmit="setDynamicLoaderDivStyle(document.getElementById('rtThanksLoader'));" 
				                		oncomplete="document.getElementById('rtThanksLoader').style.display='none';">
				                	
				                		<a4j:actionparam name="actionId" value="#{rtopHandler.actionId}" />	
				                	</a4j:support>
								</twt:menu>
		                  </div>
					</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
				
				<a4j:outputPanel id="rtThanksPanel">
					<table width="750" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
					<a4j:repeat id="rtThanksDetailsPanel" value="#{rtopHandler.twitterActionsRTThanksDto.retweets}" var="retweets" rowKeyVar="i">
						<tr bgcolor="#F2F2F2">
							
							<td width="50" align="center" valign="top"	style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
								<h:graphicImage value="#{retweets.avatar}" style="border: 0px; height: 50px; width: 54px;">
									<div style="text-align: left;">
										<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									         <span><h:outputText value="Name: "/><h:outputText value="#{retweets.name}" style="font-weight:normal;"/></span><br/>
									         <span><h:outputText value="Location: "/><h:outputText value="#{retweets.location}" style="font-weight:normal;"/></span><br/>
									         <span><h:outputText value="Tweets: "/><h:outputText value="#{retweets.statuses_count}" style="font-weight:normal;"/></span><br/>
									         <span><h:outputText value="Follows: "/><h:outputText value="#{retweets.friends_count}" style="font-weight:normal;"/></span><br/>
									         <span><h:outputText value="Following: "/><h:outputText value="#{retweets.followers_count}" style="font-weight:normal;"/></span><br/>
									         <span><h:outputText value="Listed: "/><h:outputText value="#{retweets.listed_count}" style="font-weight:normal;"/></span><br/>
										</rich:toolTip>
									</div>
								</h:graphicImage>
							</td>
							
							<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
								<div id="AddListTotal" style="width: 130px; height: auto; margin-top: 5px;">
									<div id="AddListTotalTop" style="width: 130px; height: 10px;" class="topFirstTablehdCategoryAddList">RT Message of</div>
									
									<div id="AddListTotalBottom" style="width: 130px; height: auto;" class="topFirstTablehdCategoryDrop">
										
										<div style="float: left; width: auto;">
											<h:outputText value="@#{retweets.screen_name}" />
										</div>
										
										<div style="float: left; width: 18px; margin-top: 4px; margin-right: 10px; height: 15px; margin-left: 3px;">
											<a id="twitterLogo_#{i}" onmouseover="showPopupTooltip(this.id,'#{i}');" onmouseout="hidePopupTooltip('#{i}');">
												<img src="../images/twitterSmallLogoTextArea.gif" style="cursor: pointer;" />
											</a>
										</div>
										
										<div id="twitterLogotextAreaTooltip_#{i}" class="influFollowTooltip">
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
			                                                			<h:outputText value="1" styleClass="influenceRound" rendered="#{(retweets.influence) != 1}"/>
			                                                			<h:outputText value="#{retweets.influence}" styleClass="influenceRoundSelect" rendered="#{(retweets.influence) == 1}"/>
			                                                		</div>
			                                                	</td>
			                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
			                                                		<div id="inner2"  class="influenceRound">
			                                                			<h:outputText value="2" styleClass="influenceRound" rendered="#{(retweets.influence) != 2}"/>
			                                                			<h:outputText value="#{retweets.influence}" styleClass="influenceRoundSelect" rendered="#{(retweets.influence) == 2}"/>
			                                                		</div>
			                                                	</td>
			                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
			                                                		<div id="inner3" class="influenceRound">
			                                                			<h:outputText value="3" styleClass="influenceRound" rendered="#{(retweets.influence) != 3}"/>
			                                                			<h:outputText value="#{retweets.influence}" styleClass="influenceRoundSelect" rendered="#{(retweets.influence) == 3}"/>
			                                                		</div>
			                                                	</td>
			                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
			                                                		<div id="inner4" class="influenceRound">
			                                                			<h:outputText value="4" styleClass="influenceRound" rendered="#{(retweets.influence) != 4}"/>
			                                                			<h:outputText value="#{retweets.influence}" styleClass="influenceRoundSelect" rendered="#{(retweets.influence) == 4}"/>
			                                                		</div>
			                                                	</td>
			                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
			                                                		<div id="inner5" class="influenceRound">
			                                                			<h:outputText value="5" styleClass="influenceRound" rendered="#{(retweets.influence) != 5}"/>
			                                                			<h:outputText value="#{retweets.influence}" styleClass="influenceRoundSelect" rendered="#{(retweets.influence) == 5}"/>
			                                                		</div>
			                                                	</td>
			                                                </tr>
		                                                </table>
	                                                </div>
	                                               
	                                                <h:outputText value="Friend Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{retweets.friends_count}" styleClass="tweetToolTipData"/><br/>
												    <h:outputText value="Follower Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{retweets.followers_count}" styleClass="tweetToolTipData"/><br/>
												    <h:outputText value="Listed Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{retweets.listed_count}" styleClass="tweetToolTipData"/><br/>
												    <h:outputText value="Status Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{retweets.statuses_count}" styleClass="tweetToolTipData"/><br/>
	                                           	</div>
	                							</div>
	            							</div>
	           							</div>
									</div>								
								</div>							
							</td>
							<td valign="top" align="left" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
								<div class="topFirstTablehdCategoryAddList" id="tweetMsgDiv#{i}" style="width: 255; height: auto; margin-top: 5px;">
								
								</div>	
							</td>
							<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
								<div  id="RTthanksTextarea" style="width: 400px; height: 70px;">
								<table>
									<tr>
										<td valign="top" align="left">
											<input type="hidden" name="individualTweet" id="individualTweet_#{i}" value="@#{retweets.screen_name}"/>
											<div id="referenceName_#{i}" contenteditable="true" class="rttThanksArea" 
												onkeydown="countLimitChars('#{i}');createDynamicStyling(event);" 
												onkeyup="countLimitChars('#{i}');setData('#{i}');">@#{retweets.screen_name}</div>								
										</td>
										<td valign="top" align="left">
											<table cellspacing="0" cellpadding="0" border="0" style="height: 60px;">
												<tr>
													<td valign="top" align="left" class="countTableRTThanks">
														<div class="one-fourty" id="numberofWord_#{i}">0/140</div>
													</td>
												</tr>
												<tr>
													<td valign="bottom" align="left">
														<div id="sendTweetEnabled_#{i}">
															<a4j:commandButton id="reTweetToThank" actionListener="#{popupController.replyOnRetweet}" 
																image="../images/thankButtonGeneral.gif" style="border: 0px;"
									    						onmouseover="changeImage(this,'../images/thankButtonRollover.gif');" 
									    						onmouseout="changeImage(this,'../images/thankButtonGeneral.gif');" 
									    						onclick="setDynamicLoaderDivStyle(document.getElementById('rtThanksLoader'));"
									    						oncomplete="document.getElementById('rtThanksLoader').style.display='none';  renderScript();">
									    							    						
									    						<f:param name="replyBy" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"/>
									    						<f:param name="replyTo" value="#{retweets.screen_name}"/>
									    						<f:param name="tweetId" value="#{retweets.tweet_id}"/>
									    					</a4j:commandButton>
								    					</div>
								    					
								    					<div id="sendTweetDisabled_#{i}" style="display: none;">
															<img src="../images/Buttons/General/sendTweetGrayButton.png" border="0" width="117" style="text-decoration: none;"/>
														</div>
														
													</td>
												</tr>
											</table>
										</td>
									</tr>							
								</table>
								<script type="text/javascript">
									document.getElementById('tweetMsgDiv'+#{i}).innerHTML = '#{retweets.text}';
									setData('#{i}');
									countLimitChars('#{i}');
								</script>							
								</div>													
							</td>															
							<td align="center" valign="top" width="45" style="border-bottom: 4px solid #ffffff;">
								<a4j:commandButton id="deleteRetweet" actionListener="#{popupController.deleteTweet}" 
									image="../images/Alert/General/closeGaryButtonPopup.gif" style="border: 0px; margin-left: 5px; margin-right: 5px; margin-top: 5px; cursor: pointer;" 
									onmouseover="changeImage(this,'../images/Alert/Rollover/closeGaryButtonPopupRollover.gif');"
									onmouseout="changeImage(this,'../images/Alert/General/closeGaryButtonPopup.gif');"
									onclick="setDynamicLoaderDivStyle(document.getElementById('rtThanksLoader'));"
									oncomplete="document.getElementById('rtThanksLoader').style.display='none'; renderScript();">
									<f:param name="replyBy" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"/>
									<f:param name="replyTo" value="#{retweets.screen_name}"/>
									<f:param name="tweetId" value="#{retweets.tweet_id}"/>
								</a4j:commandButton>							
							</td>
						</tr>
					</a4j:repeat>
						<tr>
							<td colspan="5" height="10"></td>
						</tr>
						<tr>
							
							<td class="closeOrangeText" valign="middle" colspan="5"
								align="right">
								<a onclick="parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; closePopupX();"
									href="#" class="closeOrangeTextAlert"
									style="color: #F2A413; text-decoration: none;"> CLOSE </a>			
							</td>
						</tr>
		
					</table>
				</a4j:outputPanel>				
				</td>
			</tr>
		</table>			
	</div>
<a4j:jsFunction name="renderScript" reRender="scriptPanel" oncomplete="setCloseIt();" />
<a4j:jsFunction name="renderRTThanksPanel" reRender="rtThanksPanel" />
<a4j:jsFunction name="setCloseIt" actionListener="#{popupController.setCloseIt}" />
<div style="display: none;">
	<a4j:outputPanel id="scriptPanel">
		<script language="JavaScript">							
			if(#{rtopHandler.closeIt} == true) {
				closePopupX();
			} else {
				renderRTThanksPanel();
			}				
		</script>
	</a4j:outputPanel>
</div>		
		
</a4j:form>
</ui:composition>