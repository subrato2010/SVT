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
    <script language="JavaScript" src="../js/twt.js"></script>
    <script language="JavaScript" src="../js/designMainScreen.js"/>	
    <script language="JavaScript" src="../js/tagsupport.js"></script>	
	<script language="JavaScript" src="/TWT/faces/a4j/g/3_3_2.SR1org/richfaces/renderkit/html/scripts/jquery/jquery.js"></script>
	
<a4j:form id="influencersToFollow" style="margin: 0px;">
	<div id="popupDiv">
	<div id="influencersLoader">
		<img id="preloader" src="../images/preloader3.gif" style="position: center; margin-top: 80px; margin-left: 280px;" alt="preloader"/>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
  	<table width="390" border="0" cellpadding="0" cellspacing="0">
  		<tr height="35">
  			<td align="left" valign="middle" width="110">
  			<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
  			</td>
  			<td align="left" valign="middle">
  			<div class="fileinputs1">          		
              	<twt:menu id="inflalertlist" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"
					options="#{rtopHandler.actionInfluencerTwitterAccounts}" 
					style="background-image: url('../images/dropCombo.gif');width:264px; height:22px;"
					listStyle="width:264px;"
					optionStyle="width:242px;">
					
					<a4j:support event="onchange" 
                		actionListener="#{rtopHandler.optimizeActionInfluencersChange}" reRender="influencerPanel" 
                		onsubmit="setDynamicLoaderDivStyle(document.getElementById('influencersLoader'));" 
                		oncomplete="document.getElementById('influencersLoader').style.display='none';">
                	
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
  	
  	<a4j:outputPanel id="influencerPanel">
  	
	  	<table width="95%" border="0" align="center" style="margin-top: 10px;">
				<a4j:repeat id="influencerDetailsPanel" value="#{rtopHandler.twitterActionsInfluencerDto.influencers}" var="influencers" rowKeyVar="i">
					<tr bgcolor="#F2F2F2">
						
						<td width="50" align="center" valign="top"	style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
							<h:graphicImage value="#{influencers.avatar}" style="border: 0px; height: 50px; width: 54px;">
								<div style="text-align: left;">
									<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="Name: "/><h:outputText value="#{influencers.name}" style="font-weight:normal;"/></span><br/>
								         <span><h:outputText value="Location: "/><h:outputText value="#{influencers.location}" style="font-weight:normal;"/></span><br/>
								         <span><h:outputText value="Tweets: "/><h:outputText value="#{influencers.statuses_count}" style="font-weight:normal;"/></span><br/>
								         <span><h:outputText value="Follows: "/><h:outputText value="#{influencers.friends_count}" style="font-weight:normal;"/></span><br/>
								         <span><h:outputText value="Following: "/><h:outputText value="#{influencers.followers_count}" style="font-weight:normal;"/></span><br/>
								         <span><h:outputText value="Listed: "/><h:outputText value="#{influencers.listed_count}" style="font-weight:normal;"/></span><br/>
									</rich:toolTip>
								  </div>
							</h:graphicImage>
						</td>
						
						<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
							<div id="AddListTotal" style="width: 130px; height: auto; margin-top: 5px;">
								
								<div id="AddListTotalTop" style="width: 130px; height: 10px;" class="topFirstTablehdCategoryAddList">User ID</div>
								
								<div id="AddListTotalBottom" style="width: 130px; height: auto;" class="topFirstTablehdCategoryDrop">
									<div style="float: left; width: auto;">
										<h:outputText value="#{influencers.screen_name}" />
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
		                                                			<h:outputText value="1" styleClass="influenceRound" rendered="#{(influencers.influence) != 1}"/>
		                                                			<h:outputText value="#{influencers.influence}" styleClass="influenceRoundSelect" rendered="#{(influencers.influence) == 1}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner2"  class="influenceRound">
		                                                			<h:outputText value="2" styleClass="influenceRound" rendered="#{(influencers.influence) != 2}"/>
		                                                			<h:outputText value="#{influencers.influence}" styleClass="influenceRoundSelect" rendered="#{(influencers.influence) == 2}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner3" class="influenceRound">
		                                                			<h:outputText value="3" styleClass="influenceRound" rendered="#{(influencers.influence) != 3}"/>
		                                                			<h:outputText value="#{influencers.influence}" styleClass="influenceRoundSelect" rendered="#{(influencers.influence) == 3}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner4" class="influenceRound">
		                                                			<h:outputText value="4" styleClass="influenceRound" rendered="#{(influencers.influence) != 4}"/>
		                                                			<h:outputText value="#{influencers.influence}" styleClass="influenceRoundSelect" rendered="#{(influencers.influence) == 4}"/>
		                                                		</div>
		                                                	</td>
		                                                	<td valign="middle" align="center" class="tweetToolTipDataBlue">
		                                                		<div id="inner5" class="influenceRound">
		                                                			<h:outputText value="5" styleClass="influenceRound" rendered="#{(influencers.influence) != 5}"/>
		                                                			<h:outputText value="#{influencers.influence}" styleClass="influenceRoundSelect" rendered="#{(influencers.influence) == 5}"/>
		                                                		</div>
		                                                	</td>
		                                                </tr>
	                                                </table>
                                                </div>
                                               
                                                <h:outputText value="Friend Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{influencers.friends_count}" styleClass="tweetToolTipData"/><br/>
											    <h:outputText value="Follower Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{influencers.followers_count}" styleClass="tweetToolTipData"/><br/>
											    <h:outputText value="Listed Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{influencers.listed_count}" styleClass="tweetToolTipData"/><br/>
											    <h:outputText value="Status Count: " styleClass="tweetToolTipTitle"/><h:outputText value="#{influencers.statuses_count}" styleClass="tweetToolTipData"/><br/>
                                           	</div>
                							</div>
            							</div>
           							</div>
								</div>
							</div>
						</td>
																		
						<td align="left" valign="top" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
							<div id="AddListTotal" style="width: 300px; height: auto; margin-top: 5px;">
								<div id="AddListTotalTop" style="width: 290px; height: 10px;" class="topFirstTablehdCategoryAddList">
								BIO
								</div>
								<div id="AddListTotalBottom" style="width: 290px; height: auto; font-weight: normal;" class="topFirstTablehdCategoryDrop">
								<h:outputText value="#{influencers.description}" />
								</div>
							</div>
						</td>
						
						<td align="center" valign="top" width="150" style="border-bottom: 4px solid #ffffff; border-right: 4px solid #ffffff;">
							<a4j:commandButton id="followInfluencer" actionListener="#{popupController.followSelectedUser }" 
								image="../images/Alert/General/followButtonOrange.gif" 
								style="border: 0px; width: 82px; margin-bottom: 5px; margin-top: 5px;"
					    		onmouseover="changeImage(this,'../images/Alert/Rollover/followButtonOrangeRollover.gif');" 
					    		onmouseout="changeImage(this,'../images/Alert/General/followButtonOrange.gif');" 
					    		onclick="setDynamicLoaderDivStyle(document.getElementById('influencersLoader'));"
					    		oncomplete="document.getElementById('influencersLoader').style.display='none'; renderScript();">
		    					
		    					<f:param name="followedBy" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"/>
		    					<f:param name="userToFollow" value="#{influencers.user_id}"/>
								<f:param name="userToFollowName" value="#{influencers.screen_name}"/>		    					
					    	</a4j:commandButton>
						</td>
						
						<td align="center" valign="top" width="45" style="border-bottom: 4px solid #ffffff;">
						
							<a4j:commandButton id="unFollowInfluencer" actionListener="#{popupController.unFollowSelectedUser}" 
								image="../images/Alert/General/closeGaryButtonPopup.gif" 
								style="border: 0px; margin-bottom: 5px; margin-top: 5px;"
					    		onmouseover="changeImage(this,'../images/Alert/Rollover/closeGaryButtonPopupRollover.gif');" 
					    		onmouseout="changeImage(this,'../images/Alert/General/closeGaryButtonPopup.gif');" 
					    		onclick="setDynamicLoaderDivStyle(document.getElementById('influencersLoader'));"
					    		oncomplete="document.getElementById('influencersLoader').style.display='none'; renderScript();">
		    					
		    					<f:param name="unFollowedBy" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"/>
		    					<f:param name="userToUnFollow" value="#{influencers.user_id}"/>
					    	</a4j:commandButton>
					    	
						</td>
		  			</tr>
			</a4j:repeat>
		</table>
  </a4j:outputPanel>
  
  </td>
  </tr>
  
  	<tr>
	<td class="closeOrangeText" valign="middle"  width="110" align="right">
	<a class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none; cursor: pointer; padding-right:25px;" 
		onclick="closePopupX();">
	 CLOSE
	</a>
	</td>
	</tr>

</table>
</div>
<a4j:jsFunction name="renderScript" reRender="scriptPanel" oncomplete="setCloseIt();" />
<a4j:jsFunction name="renderInfluencerPanel" reRender="influencerPanel" />
<a4j:jsFunction name="setCloseIt" actionListener="#{popupController.setCloseIt}" />
<div style="display: none;">
	<a4j:outputPanel id="scriptPanel">
		<script language="JavaScript">							
			if(#{rtopHandler.closeIt} == true) {
				closePopupX();
			} else {
				renderInfluencerPanel();
			}				
		</script>
	</a4j:outputPanel>
</div>		
		
</a4j:form>
</ui:composition>

