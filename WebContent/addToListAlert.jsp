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
	<link href="../css/tagsupport.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js" />
	<script language="JavaScript" src="../js/twt.js"></script>
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>	
	<script language="JavaScript" src="../js/tagsupport.js"></script>	
	<script language="JavaScript" src="/TWT/faces/a4j/g/3_3_2.SR1org/richfaces/renderkit/html/scripts/jquery/jquery.js"></script>
	
	<a4j:form id="addToList" style="margin: 0px;">
		<div id="popupDiv">				
			<div id="addToListLoader">
				<img id="preloader" src="../images/preloader3.gif" style="position: center; margin-top: 120px; margin-left: 360px;" alt="preloader" />
			</div>	
			<table width="800" border="0" cellspacing="0" cellpadding="0" height="100%">
				<tr>
					<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0" height="30">
						<table cellpadding="0" cellspacing="0" border="0" width="800">
							<tr height="35">
								<td align="left" valign="middle" width="120">
									<font style="color: #EDEDED; padding-left: 20px; width: 110px;">For profile</font>
								</td>
								<td align="left" valign="middle">
									<div class="fileinputs1" style="width: 30px; color: #7D848B;">										
										<twt:menu id="influencersToList" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"
											options="#{rtopHandler.actionInfluencerTwitterAccounts}" 
											style="background-image: url('../images/dropCombo.gif');width:264px; height:22px;"
											listStyle="width:264px;"
											optionStyle="width:242px;">
											
											<a4j:support event="onchange"
												actionListener="#{rtopHandler.optimizeActionInfluencersToListChange}"
												reRender="addToListPanel"
												onsubmit="hideUserListPopup(); setDynamicLoaderDivStyle(document.getElementById('addToListLoader'));"
												oncomplete="document.getElementById('addToListLoader').style.display='none';">
												
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
						<a4j:outputPanel id="addToListPanel" layout="block">
							<table width="750" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
								<a4j:repeat id="addToListDetailsPanel" value="#{rtopHandler.twitterActionsInfluencersListDTO.influencers_to_list}" var="influencersToList" rowKeyVar="i">
									<tr bgcolor="#F2F2F2">
										<td width="50" align="center" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
											<h:graphicImage value="#{influencersToList.avatar}" style="border: 0px; height: 50px; width: 54px;">
												<div style="text-align: left;">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
												         <span><h:outputText value="Name: "/><h:outputText value="#{influencersToList.name}" style="font-weight:normal;"/></span><br/>
												         <span><h:outputText value="Location: "/><h:outputText value="#{influencersToList.location}" style="font-weight:normal;"/></span><br/>
												         <span><h:outputText value="Tweets: "/><h:outputText value="#{influencersToList.statuses_count}" style="font-weight:normal;"/></span><br/>
												         <span><h:outputText value="Follows: "/><h:outputText value="#{influencersToList.friends_count}" style="font-weight:normal;"/></span><br/>
												         <span><h:outputText value="Following: "/><h:outputText value="#{influencersToList.followers_count}" style="font-weight:normal;"/></span><br/>
												         <span><h:outputText value="Listed: "/><h:outputText value="#{influencersToList.listed_count}" style="font-weight:normal;"/></span><br/>
													</rich:toolTip>
												</div>
											</h:graphicImage>
										</td>
										<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
											<div id="AddListTotal" style="width: 130px; height: auto; margin-top: 5px;">
												<div id="AddListTotalTop" style="width: 130px; height: 10px;" class="topFirstTablehdCategoryAddList">User ID</div>
												<div id="AddListTotalBottom" style="width: 130px; height: auto;" class="topFirstTablehdCategoryDrop">
													<div style="float: left; width: auto;">
														<h:outputText value="#{influencersToList.screen_name}" />
													</div>
													<div style="float: left; width: 18px; margin-top: 4px; margin-right: 10px; height: 15px; margin-left: 3px;">
														<a id="twitterLogo_#{i}"> 
															<img id="twitterLogoAddToList_#{i}"
																onmouseover="showPopupTooltip(this.id,'#{i}');" onmouseout="hidePopupTooltip('#{i}');"
																src="../images/twitterSmallLogoTextArea.gif"
																style="cursor: pointer;" /> 
														</a>
													</div>
													<div id="twitterLogotextAreaTooltip_#{i}" class="influFollowTooltip">
														<div id="mouseover_tooltip_section">
															<div id="mouseover_tooltip_section_left">
																<div id="mouseover_tooltip_section_left_arrow"></div>
															</div>
															<div id="mouseover_tooltip_section_right">
																<div id="mouseover_tooltip_section_right_middle">
																	<h:outputText value="Influence Score: " styleClass="tweetToolTipTitle" />
																	<br />
																	<div style="width: 130px; height: 20px; margin-left: 10px;">
																		<table width="100%">
																			<tr>
																				<td valign="middle" align="center" class="tweetToolTipDataBlue">
																					<div id="inner1" class="influenceRound">
																						<h:outputText value="1" styleClass="influenceRound" rendered="#{(influencersToList.influence) != 1}" />
																						<h:outputText value="#{influencersToList.influence}" styleClass="influenceRoundSelect" rendered="#{(influencersToList.influence) == 1}" />
																					</div>
																				</td>
																				<td valign="middle" align="center" class="tweetToolTipDataBlue">
																					<div id="inner2" class="influenceRound">
																						<h:outputText value="2" styleClass="influenceRound" rendered="#{(influencersToList.influence) != 2}" />
																						<h:outputText value="#{influencersToList.influence}" styleClass="influenceRoundSelect" rendered="#{(influencersToList.influence) == 2}" />
																					</div>
																				</td>
																				<td valign="middle" align="center" class="tweetToolTipDataBlue">
																					<div id="inner3" class="influenceRound">
																						<h:outputText value="3" styleClass="influenceRound" rendered="#{(influencersToList.influence) != 3}" />
																						<h:outputText value="#{influencersToList.influence}" styleClass="influenceRoundSelect" rendered="#{(influencersToList.influence) == 3}" />
																					</div>
																				</td>
																				<td valign="middle" align="center" class="tweetToolTipDataBlue">
																					<div id="inner4" class="influenceRound">
																						<h:outputText value="4" styleClass="influenceRound" rendered="#{(influencersToList.influence) != 4}" />
																						<h:outputText value="#{influencersToList.influence}" styleClass="influenceRoundSelect" rendered="#{(influencersToList.influence) == 4}" />
																					</div>
																				</td>
																				<td valign="middle" align="center" class="tweetToolTipDataBlue">
																					<div id="inner5" class="influenceRound">
																						<h:outputText value="5" styleClass="influenceRound" rendered="#{(influencersToList.influence) != 5}" />
																						<h:outputText value="#{influencersToList.influence}" styleClass="influenceRoundSelect" rendered="#{(influencersToList.influence) == 5}" />
																					</div>
																				</td>
																			</tr>
																		</table>
																	</div>
																	<h:outputText value="Friend Count: " styleClass="tweetToolTipTitle" />
																	<h:outputText value="#{influencersToList.friends_count}" styleClass="tweetToolTipData" />
																	<br />
																	<h:outputText value="Follower Count: " styleClass="tweetToolTipTitle" />
																	<h:outputText value="#{influencersToList.followers_count}" styleClass="tweetToolTipData" />
																	<br />
																	<h:outputText value="Listed Count: " styleClass="tweetToolTipTitle" />
																	<h:outputText value="#{influencersToList.listed_count}" styleClass="tweetToolTipData" />
																	<br />
																	<h:outputText value="Status Count: " styleClass="tweetToolTipTitle" />
																	<h:outputText value="#{influencersToList.statuses_count}" styleClass="tweetToolTipData" />
																	<br />
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</td>
										<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
											<div id="AddListTotal" style="width: 130px; height: auto; margin-top: 5px;">
												<div id="AddListTotalTop" style="width: 130px; height: 10px;" class="topFirstTablehdCategoryAddList">Name</div>
												<div id="AddListTotalBottom" style="width: 130px; height: auto;" class="topFirstTablehdCategoryDrop">
													<h:outputText value="#{influencersToList.name}" />
												</div>
											</div>
										</td>
										<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
											<div id="AddListTotal" style="width: 200px; height: auto; margin-top: 5px;">
												<div id="AddListTotalTop" style="width: 190px; height: 10px;" class="topFirstTablehdCategoryAddList">Title</div>
												<div id="AddListTotalBottom" style="width: 190px; height: auto;" class="topFirstTablehdCategoryDrop">
													<h:outputText value="#{influencersToList.description}" />
												</div>
											</div>
										</td>
										<td align="center" valign="top" width="150" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
											<a4j:commandButton id="addtoListButton"	actionListener="#{popupController.generateCustomerHandlerUserList}"
												image="../images/Alert/General/addToListButton.gif"
												style="border: 0px; margin-top: 5px; margin-right: 5px; cursor: pointer;"
												onclick="setLoaderDivStyle(document.getElementById('addToListLoader'));"
												oncomplete="callerForRendererOfUserList(this.id,'listPopup_', '#{i}');"
												onmouseover="changeImage(this,'../images/Alert/Rollover/addToListButtonRollover.gif');"
												onmouseout="changeImage(this,'../images/Alert/General/addToListButton.gif');">
	
												<!-- oncomplete="showPopupDivRespectToElement(this.id,'listPopup_', '#{i}', '#{rich:clientId('addToListPanel')}');" -->
												<a4j:actionparam name="handlerName" value="#{rtopHandler.firstActionInfluencerTwitterAccount}" />
												<a4j:actionparam name="index" value="#{i}" />
												<a4j:actionparam name="actionsInfluencersId" value="#{influencersToList.user_id}" />
												<a4j:actionparam name="actionId" value="#{rtopHandler.actionId}" />
											</a4j:commandButton>
										</td>
										<td align="center" valign="top" width="45" style="border-bottom: 4px solid #ffffff;">
											<a4j:commandButton id="deleteToListButton" actionListener="#{popupController.deleteInfulencerToList}"
												image="../images/Alert/General/closeGaryButtonPopup.gif"
												onclick="setDynamicLoaderDivStyle(document.getElementById('addToListLoader'));"
												onmouseover="changeImage(this,'../images/Alert/Rollover/closeGaryButtonPopupRollover.gif');"
												onmouseout="changeImage(this,'../images/Alert/General/closeGaryButtonPopup.gif');"
												oncomplete="document.getElementById('addToListLoader').style.display = 'none'; renderScript();">
												
												<a4j:actionparam name="user" value="#{influencersToList.user_id}" />												
											</a4j:commandButton>
										</td>
									</tr>
								</a4j:repeat>
								<tr>
									<td colspan="7" height="10"></td>
								</tr>
								<tr>
									<td colspan="5" align="left" valign="top"></td>
									<td class="closeOrangeText" valign="middle" width="110"
										align="right">
										<a onclick="hideUserListPopup(); closePopupX();" href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;"> 
											CLOSE 
										</a>
									</td>
								</tr>
							</table>						
						</a4j:outputPanel>
					</td>
				</tr>
			</table>
			<a4j:jsFunction name="renderScript" reRender="scriptPanel" oncomplete="setCloseIt();" />
			<a4j:jsFunction name="renderAddToListPanel" reRender="addToListPanel" />
			<a4j:jsFunction name="setCloseIt" actionListener="#{popupController.setCloseIt}" />			
		</div>		
		<div style="display: none;">
			<a4j:outputPanel id="scriptPanel">
				<script language="JavaScript">							
					if(#{rtopHandler.closeIt} == true) {
						closePopupX();
					} else {
						renderAddToListPanel();
					}				
				</script>
			</a4j:outputPanel>
		</div>		
				
	</a4j:form>
</ui:composition>