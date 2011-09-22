<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<link href="../css/twt.css" rel="stylesheet" type="text/css" />
	<link href="../css/top.css" rel="stylesheet" type="text/css" />

	<script language="JavaScript" src="../js/top.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js"></script>
	<script language="JavaScript" src="../js/twitterChannelNew.js"></script>
	<script language="JavaScript" src="../js/twt.js"></script>
	<script language="JavaScript" src="../js/rtopapi.js"></script>	
	<script language="JavaScript" src="../js/editProfile.js"></script>
	<script language="JavaScript" src="../js/ajaxForGeo.js"></script> <!-- Caution : Don't use this line  anywhere except twitterChannelOptimization.jsp-->
	
	<title>Channel Optimization | Optimizer</title>
	<body style="margin: 0px;" onLoad="twitSuccess('#{twitterController.operated}','#{twitterController.clickedIndex}','#{twitterController.totalClicked}');" onscroll="hideAllNew(); hideAllActions();" onclick="hideAllNew();">
    <f:view contentType="text/html">    
    <h:inputHidden value="#{twitterController.profileImageAndLocationFirstTime}"/>
        
    <a4j:outputPanel rendered="#{userProfileController.refresh}">
    
		<script>
			// this will always refresh with latest data
		</script>
	</a4j:outputPanel>

    <div class="page" id="pageT">
    
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top" align="left">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
      <td valign="top" align="center">

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
             <td align="left" valign="top">
                <div class="mainBodyTopTotal">
			       <a4j:include viewId="templates/twitterTemplates/topTemplateTwitter.jsp"/>
			    </div>
			  </td>
           </tr>
           <tr>
              <td align="left" valign="top">
				 <div class="mainBodyTop">
					<div class="TCOMenu">
						<div  class="TCOMenuLeft">
							<a href="mainScreen.jsp">
							<img alt="ChannelPerformance" src="../images/channelPerformance.gif" border="0" height="35" onclick="clickLink('closeBtnForm:closeBtn')"
								onmouseover="changeImage(this,'../images/channelPerformance_rollover.gif');" onmouseout="changeImage(this,'../images/channelPerformance.gif');"/>
							</a>
						</div>
						<div  class="TCOMenuMiddle">
						</div>
						<div class="TCOMenuRight">
							<img src="../images/channelOptimizationSelected.gif" border="0"/> 
						</div>
					</div>
				  </div>
                </td>
              </tr>
                                 
<!--**************************************** Top Menu Section End *******************************************-->
<!--**************************************** Body ROI Optimization Section Start *******************************************-->
			  <tr>
                <td valign="top" align="center">
                  <div class="bodyTop">
                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td valign="top" align="left">
                             <div class="bodyTopFirst" onclick="hideAllNew(); hideAllActions();">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                       <td colspan="3" bgcolor="#EDEDED" class="topFirsthd" valign="middle" align="left" width="300">ROI Optimization</td>
                                    </tr>
                                    <tr>
                                       <td valign="top" align="center" width="240" style="border-right:1px solid #F6F6F6;">
                                          <table width="240" border="0" cellspacing="0" cellpadding="0">
                                              <tr>
                                                 <td valign="middle" align="left">
                                                    <table cellpadding="0" cellspacing="0">
                                                       	<tr>
                                                           <td valign="middle" align="left"  class="topFirstTablehd">Goal</td>
                                                           <td valign="middle" align="left">
                                                              <h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" 
                                                              				  onmouseout="this.src='../images/bulb.jpg';">
															     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																	<span>
																	   <h:outputText value="This is the target you've chosen to achieve in your goal of improving your performance relative to your competitors.  
																			Moderate - reduce the gap between you and your competitors
																			Aggressive - close the gap between you and your competitors
																			Very Aggressive - outperform your competitors"/>
																	</span>
																 </rich:toolTip>
														      </h:graphicImage>
                                                           </td>
                                                        </tr>
                                                    </table>
                                                 </td>
                                              </tr>
                                              <tr>
                                                 <td valign="middle" align="left">
                                                    <table width="240" border="0" cellpadding="0" cellspacing="0">
                                                       <tr>
                                                          <td valign="middle" align="left" class="topFirstTableMatter" width="80">                                                          
                                                          <div id="rtoGoalPercentage"></div></td>
                                                          <td valign="middle" align="left" class="topFirstTableMatter" width="135">
	                                                          <div id="rtostarcounter"></div>
	                                                       		<rich:toolTip id="rtoGoalTooltip" for="rtostarcounter" 
	                                                       			styleClass="tooltip" 
	                                                       			showEvent="onmouseover" 
	                                                       			direction="bottom-right" 
	                                                       			mode="client" 	                                                       			
	                                                       			layout="block">																	
																</rich:toolTip>
                                                            </td>
                                                        </tr>
                                                      </table>
                                                    </td>
                                              </tr>
                                              <tr>
                                                 <td valign="middle" align="left">
                                                    <table width="240" border="0" cellpadding="0" cellspacing="0">
                                                       <tr>
                                                          <td valign="middle" align="left" class="topFirstTableMatterGray" width="100">
                                                              #{userProfileController.userProfile.improvementLevelName}
                                                          </td>
                                                          <td valign="middle" align="left" class="topFirstTableMatter" width="15">
													 		<h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
															  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															  <span>
															  <h:outputText value="This is the target you've chosen to achieve in your goal of improving your performance relative to your competitors. Moderate - reduce the gap between you and your competitors.
																			Aggressive - close the gap between you and your competitors. Very Aggressive - outperform your competitors." />
															  </span>
															 </rich:toolTip>
															</h:graphicImage>                   
                                                          </td>
                                                          <td valign="middle" align="center" class="topFirstTableMatterGreen">
                                                           	  <!--<a href="#" onclick="openPopup('Edit Profile Preferences',254, 3, 770, 800, 6, false, true, false, 'editProfile.jsp')" 
                                                                 style="color:#77C442; text-decoration:none;">CHANGE</a>
                                                         -->
                                                         <a href="#" onclick="change1(); openPopupR('Edit Profile Preferences', '', '#E7E7E7', '#787E89', '*Required', 254, 3, 766, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
                                                         	CHANGE
                                                         </a>
                                                         </td>
                                                       </tr>
                                                     </table>
                                                  </td>
                                              </tr>                                                                                      
                                          </table>
                                       </td>
<td valign="top" align="center" width="380" style="border-right:1px solid #F6F6F6;">
                                       
<!-- ********************************************************************************************************************************* -->                                       
<!-- ****************************************** This block is for ROI Optimization 'Action' ****************************************** -->
<div style="display: none;">
	<a4j:outputPanel id="channelOptimizationDataGeneratorPanel" layout="none">
		<a4j:outputPanel rendered="#{rtopHandler.renderChannelOptimizationDataGeneratorPanel}">
			<h:form id="channelOptimizationOutboundAndProfileActionListForm">
	    		<h:inputHidden id="channelOptimizationOutboundAndProfileActionListHidden" 
	    			value="#{rtopHandler.channelOptimizationOutboundAndProfileActionList}" />
	    	</h:form>	
		</a4j:outputPanel>
	</a4j:outputPanel>
</div>                                          
<div id="roiOptimizeDiv" style="width: 380px; height: auto;">
	<a4j:outputPanel id="profilealertpanelDisplay">	
		<a4j:form id="optimizeActionROI" style="margin: 0px;">  		
			<a4j:outputPanel id="profilealertpanel" rendered="#{rtopHandler.displayProfileAlert}" >
				<a4j:outputPanel id="roiOptimizePanel" rendered="#{rtopHandler.renderROIOptimizePanel}">				
						<table width="380" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="middle" align="left" colspan="3">
									<table cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="left"  class="topFirstTablehd">Action</td>
											<td valign="middle" align="left">
												<h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
														<span>
															<h:outputText value="Profile Actions are outbound activities that will help you to reach your goal." />
														</span>
													</rich:toolTip>
												</h:graphicImage> 
											</td>
										</tr>
									</table>
								</td>
							</tr>	
							<a4j:repeat value="#{rtopHandler.optimizeActionList}" var="actionOptimize" rowKeyVar="i">									                       		
								<tr>
									<td>
										<div id="actionFlameCount#{i}" style="width: 110px;" align="left">
											<h:outputText escape="false" value="#{actionOptimize.imageTagScript}"/>
										</div>
										<rich:toolTip for="actionFlameCount#{i}" styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
											<span>
												<a4j:outputPanel rendered="#{(actionOptimize.actionFlameCount > 0)}">
													<h:outputText value="Flames represent actual performance degradation in this metric." />
												</a4j:outputPanel>
												<a4j:outputPanel rendered="#{(actionOptimize.actionStarCount > 0)}">
													<h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." />
												</a4j:outputPanel>
											</span>
										</rich:toolTip>									
									</td>
									<td>
										<div id="actionOptimizeLabel#{i}" class="topFirstTableinflu" style="width: 170px;" align="left">#{actionOptimize.label}</div>
									</td>
									<td>
										<div id="actionOptimizeButton#{i}" class="topFirstTableinflu" style="width: 70px;" align="left">	                    
											<a4j:commandButton actionListener="#{rtopHandler.optimizeAction}" image="../images/Buttons/General/optimizeGeneral.gif" style="border: 0px; cursor: pointer; text-decoration: none;"
												onclick="document.getElementById('actionIdHiddenForm:actionIdHidden').value=#{actionOptimize.actionId};change();"			 								
												onmouseover="changeImage(this,'../images/Buttons/rollover/optimizeRollover.gif');" onmouseout="changeImage(this,'../images/Buttons/General/optimizeGeneral.gif');" 
												oncomplete="document.getElementById('transParentDocDiv').style.display='none';openPopupTB('#{actionOptimize.titleBarText}', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', '#{actionOptimize.pageLeft}', '#{actionOptimize.pageTop}', '#{actionOptimize.pageWidth}', '#{actionOptimize.pageHeight}', 10, false, true, false, '#{actionOptimize.jspPageToDisplay}', '#{actionOptimize.actionId}');">		    				
												
												<a4j:actionparam name="firstActionInfluencerName" value="#{rtopHandler.firstActionInfluencerTwitterAccount}"/>
				    							<a4j:actionparam name="actionId" value="#{actionOptimize.actionId}"/>
				    						</a4j:commandButton>			 									 							
				                       	</div>
									</td>
								</tr>
							</a4j:repeat> 
						</table>								   					                                                                                                                      
					</a4j:outputPanel>
				</a4j:outputPanel>		
					
				<a4j:jsFunction name="reRenderPanel" reRender="profilealertpanel" oncomplete="document.getElementById('transParentDocDiv').style.display='none';"/>			
		</a4j:form>		
	</a4j:outputPanel>
</div>
<div id="roiOptimizeLoadingDiv" style="width: 380px; height: auto;">
	<img id="preloader" src="../images/indicator.gif" style="position: center;" alt="preloader"/>
</div>
<a4j:outputPanel id="roiOptimizeScriptPanel">
	<script language="JavaScript">
		//<![CDATA[
			document.getElementById('roiOptimizeDiv').style.display = '#{rtopHandler.roiOptimizeDivDisplay}';
			document.getElementById('roiOptimizeLoadingDiv').style.display = '#{rtopHandler.roiOptimizeLoadingDivDisplay}';
		//]]>
	</script>
</a4j:outputPanel>

<!-- ********************************************************************************************************************************* -->                                          
</td>

<!-- END of This block is for ROI Optimization 'Action' -->
                                       <td valign="top" align="center" width="430" style="border-right:1px solid #F6F6F6;">
                                          <table width="430" border="0" cellspacing="0" cellpadding="0">
                                               <tr>
                                                  <td valign="middle" align="left" class="topFirstTableMatter">
                                                     <img width="410" border="0" src="../images/engagementMetrics.jpg" style="margin-top:5px;"/>
                                                  </td>
                                               </tr>
                                          </table>
                                       </td>
                                    </tr>
                                </table>
                             </div>
                           </td>
                        </tr>
                     </table>                                                           
                  </div>												 
               </td>
           </tr>
<!--**************************************** Body ROI Optimization Section End *******************************************-->                                  
        </table>
      </td>
    </tr>
  <!--********************************** Total Top three Section End **************************************-->          
 <!--******************************************* MIDDLE SECTION START ******************************************--> 
    <tr>
       <td valign="top" align="left"><div class="border"></div></td>
    </tr>
	<tr style="display: none;">
       <td width="1050" valign="top" align="left">
           <div class="bodyTopSecondChannelPerf">  
            	<table width="1050" border="0" cellspacing="0" cellpadding="0" style="border-bottom:1px solid #D4D4D4;border-top:1px solid #D4D4D4; margin-bottom:10px; margin-top:10px;">
            		<tr>
                	   <td width="1" align="left" valign="middle">
                 		  <a id="displayTextOM" href="javascript:toggleOM();">
                 		    <img src="../images/grayDropDown.gif" border="0" />
                 		  </a>
                	   </td>
                	   <td class="topFirstTablehdCategoryDrop" align="left" valign="middle" width="1000">
	                      <table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
	                         <tr>
	                            <td valign="middle" align="left">Goal Tracking</td>
	                            <td valign="middle" align="left">
									<h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
										 <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
											<span><h:outputText value="Each of your Outbound metrics is tracked with its current score and your selected goal's target score." /></span>
										 </rich:toolTip>
									</h:graphicImage>
								 </td>                           
	                           </tr>
	                    	</table>
                		 </td>
            		  </tr>
          			</table>
              </div>
          </td>
      </tr>
      <tr style="display: none;">
         <td width="1050" valign="top" align="left">
             <div class="bodyTopSecondChannelPerf">  
                  <div id="toggleTextOM" style="display: none">
<a4j:outputPanel id="performanceControllerPanel">
<a4j:outputPanel rendered="#{rtopHandler.renderPerformanceControllerPanel}">
<h:inputHidden id="outboundMetricslist" value="#{channelPerformanceController.channelOptimizationOutbound}" />
	<h:form id="performanceCOntrollerForm">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topFirstTablehdCategory" valign="middle" align="left" width="350">
					Outbound Metrics <font style="font-weight: normal;">(Sorted by most underperforming metric relative to the competitor average)</font> 
					<h:graphicImage value="../images/bulb.jpg"
						onmouseover="this.src='../images/bulb_green.jpg';"
						onmouseout="this.src='../images/bulb.jpg';">
						<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
							<span>
								<h:outputText value="A measure of activities that relate to your use of Twitter." />
							</span>
						</rich:toolTip>
					</h:graphicImage>
				</td>
				<td valign="middle" align="center" width="120">
					<table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
						<tr>
							<td valign="middle" align="center">Current</td>
							<td valign="middle" align="left">
								<h:graphicImage value="../images/bulb.jpg"
									onmouseover="this.src='../images/bulb_green.jpg';"
									onmouseout="this.src='../images/bulb.jpg';">
									<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										<span>
											<h:outputText value="This is your current score for the Outbound metric." />
										</span>
									</rich:toolTip>
								</h:graphicImage>
							</td>
						</tr>
					</table>
				</td>
				<td valign="middle" align="center" width="120">
					<table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
						<tr>
							<td valign="middle" align="center">Target</td>
							<td valign="middle" align="left">
								<h:graphicImage value="../images/bulb.jpg"
									onmouseover="this.src='../images/bulb_green.jpg';"
									onmouseout="this.src='../images/bulb.jpg';">
									<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										<span>
											<h:outputText value="This is your target score (based on your selected goal) for the Outbound metric." />
										</span>
									</rich:toolTip>
								</h:graphicImage>
							</td>
						</tr>
					</table>
				</td>
				<td valign="middle" align="left">
					<table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
						<tr>
							<td valign="middle" align="left">Performance</td>
							<td valign="middle" align="left">
								<h:graphicImage value="../images/bulb.jpg"
									onmouseover="this.src='../images/bulb_green.jpg';"
									onmouseout="this.src='../images/bulb.jpg';">
									<rich:toolTip styleClass="tooltip"
										showEvent="onmouseover" direction="bottom-right"
										mode="client" layout="block">
										<span>
											<h:outputText value="Performance towards or against reaching your goal." />
										</span>
									</rich:toolTip>
								</h:graphicImage>
							</td>
						</tr>
					</table>
				</td>
			</tr>

				

			<a4j:repeat value="#{channelPerformanceController.bottom10OutboundMetricsDummy}" var="overallOutbounds" rowKeyVar="i">
				<tr bgcolor="#{(i%2==0)?('ededed'):('white')}">
					<td align="left" valign="middle"
						class="topFirstTablehdCategory">
						<div class="COGoal">
							#{overallOutbounds.metricsName}
							<h:graphicImage value="../images/bulb.gif"
								onmouseover="this.src='../images/bulb_green.gif';"
								onmouseout="this.src='../images/bulb.gif';">
								<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									<span>
										<h:outputText value="#{overallOutbounds.metricsDesc}" />
									</span>
								</rich:toolTip>
							</h:graphicImage>
						</div></td>
					<td align="center" valign="middle" class="topFirstTablehdCategoryDataLast">#{overallOutbounds.custVolumeRoundUp}</td>
					<td align="center" valign="middle" class="topFirstTablehdCategoryDataLast">#{overallOutbounds.custTargetRaw}</td>
					<td align="left" valign="middle" class="topFirstTablehdCategoryCOGreen">
						<a4j:repeat value="#{overallOutbounds.counter}">
							<h:graphicImage value="../images/orangeFlameSmall.gif"
								onmouseover="this.src='../images/orangeFlameSmall.gif';"
								onmouseout="this.src='../images/orangeFlameSmall.gif';">
								<rich:toolTip styleClass="tooltip"
									showEvent="onmouseover" direction="bottom-right"
									mode="client" layout="block">
									<span>
										<h:outputText value="Flames represent actual performance degradation in this metric." />
									</span>
								</rich:toolTip>
							</h:graphicImage>
						</a4j:repeat> 
						<a4j:repeat value="#{overallOutbounds.starCounter}">
							<h:graphicImage value="../images/yellowStarSmall.gif"
								onmouseover="this.src='../images/yellowStarSmall.gif';"
								onmouseout="this.src='../images/yellowStarSmall.gif';"
								style=" margin-right:5px">
								<rich:toolTip styleClass="tooltip"
									showEvent="onmouseover" direction="bottom-right"
									mode="client" layout="block">
									<span>
										<h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." />
									</span>
								</rich:toolTip>
							</h:graphicImage>
						</a4j:repeat>
					</td>
				</tr>
			</a4j:repeat>
		</table>
		 
	</h:form>
	
	</a4j:outputPanel>
</a4j:outputPanel>

<a4j:form>
	<a4j:poll id="fiveMinutePoll" onsubmit="jsForFiveMinutePoll('none', 'block');" interval="#{rtopHandler.interval}" />
		
	<a4j:jsFunction name="jsForFiveMinutePoll" reRender="roiOptimizeScriptPanel" oncomplete="jsToFireActionListnerToRenderProfilealertpanelDisplay();">
		<a4j:actionparam name="paramRoiOptimizeDivDisplay" assignTo="#{rtopHandler.roiOptimizeDivDisplay}" />
		<a4j:actionparam name="paramRoiOptimizeLoadingDivDisplay" assignTo="#{rtopHandler.roiOptimizeLoadingDivDisplay}" />
	</a4j:jsFunction>
	
	<a4j:jsFunction name="jsToFireActionListnerToRenderProfilealertpanelDisplay" actionListener="#{rtopHandler.reRenderOptimizeActionsAfter5Minute}" 
		oncomplete="jsForFiveMinutePollOnComplete('block', 'none');" />
	
	<a4j:jsFunction name="jsForFiveMinutePollOnComplete" reRender="profilealertpanelDisplay, roiOptimizeScriptPanel">
		<a4j:actionparam name="paramRoiOptimizeDivDisplay" assignTo="#{rtopHandler.roiOptimizeDivDisplay}" />
		<a4j:actionparam name="paramRoiOptimizeLoadingDivDisplay" assignTo="#{rtopHandler.roiOptimizeLoadingDivDisplay}" />
	</a4j:jsFunction>
</a4j:form>

<div style="border:1px solid #D4D4D4; margin-top:10px;"></div>
<a4j:form>	
	<a4j:poll id="roiOptimizePanelPoll" interval="2000" 
		reRender="channelOptimizationDataGeneratorPanel" 
		actionListener="#{rtopHandler.reRenderROIOptimizePanel}" rendered="#{rtopHandler.renderRoiOptimizePanelPoll}" oncomplete="jym();">
	</a4j:poll>
	
	<a4j:jsFunction name="jym" reRender="profilealertpanelDisplay, roiOptimizePanelPoll, roiOptimizeScriptPanel, performanceControllerPanel, scriptPanel" />	
	
</a4j:form>
												      
                 </div> 
              </div>
         </td>
     </tr>
     
     
     <tr>
     <td valign="top" align="left">
     <div class="mainBody" onscroll="hideAll(); hideAllNew();  hideAllActions();" onclick="hideAllNew(); hideAllActions();">
     	<h:form>
     	<!-- a4j:poll id="poll" interval="600000" enabled="true" reRender="updateList"/-->
     	</h:form>
     	<a4j:outputPanel id="updateList">
         
         <div class="mainBodyBottom">
              <!--****************** Main Body Middle Section Start***************-->                                      
             <div class="mainBodyBottomUpper">
             	<div class="mainBodyBottomUpper11">
             	
		             	<a4j:outputPanel rendered="#{!(twitterController.availableList)}">  
			             	<a4j:form id="dropWin">
			        			<a4j:commandLink id="dropWindow" actionListener="#{twitterController.openCloseWindow}"  
									reRender="updateList" style="text-decoration:none;" immediate="true"
									oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none';
									newToggleRTO();">
									<img src="../images/dropDown.gif" border="0" onclick="change();"/>
							    </a4j:commandLink>
							</a4j:form>
						</a4j:outputPanel>
						
						<a4j:outputPanel rendered="#{twitterController.availableList}"> 
							<a id="displayTextRTO" href="javascript:toggleRTO();">
		                         <img src="../images/dropDown.gif" border="0"/></a>
						</a4j:outputPanel>
        		</div>
        		<div class="mainBodyBottomUpper22">
        			<div  class="mainBodyBottomUpperLeftText">Real-Time Optimization</div>
        		</div>
        		<div class="mainBodyBottomUpper33">
        		<div class="mainDivTop" id="main_x1">
        		
        				<a4j:outputPanel rendered="#{!(twitterController.firstCustomerName eq '')}">
							<div id="captionDiv" class="captionDivTop">@#{twitterController.firstCustomerName}</div>
								<div class="textDiv" style="float: left;">
        							<input  type="text" value="" class="fakeText" onblur="closeList('x1');" 
        									onclick="toggleList('x1')" readonly="readonly"  
        									style="cursor:pointer; width: 30px;"/>
       							</div>
						</a4j:outputPanel>	    
					</div>
					<div class="listDivTop" id="list_x1" onmouseover="setInList(true);" onmouseout="setInList(false);">
						 <ui:repeat value="#{channelPerformanceController.twitterAccount}" var="twitterAccount">
							<div class="itemDivTop">
								<h:form>
									<a4j:commandButton value="@#{twitterAccount.twitterUsername}" id="selectedHandler"
										actionListener="#{twitterController.fetchTwitterAccount}" reRender="channelOptimizationDataGeneratorPanel, updateList, whatsHappening, profilealertpanelDisplay"
										styleClass="optiontext"										
										onclick="change(); setProfileId('#{twitterAccount.twitterUsername}');toggleList('x1');"
										style="background-image: inherit; background: transparent; background-color: transparent;
											   color: #707071; border-color: transparent;cursor: pointer; font-size: 12px;
											   font-family: Verdana,Arial,Helvetica,sans-serif;text-align: left; text-indent: 0px;
											   text-decoration: none"
											   oncomplete="javascript:openRTO(); document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();">
											   <!-- <f:param name="authName" value="#{twitterAccount.twitterUsername}"/>  -->
										<f:param name="handlerFromList" value="#{twitterAccount.twitterUsername}"/>
                         			</a4j:commandButton>
                          		</h:form>
						    </div>
						 </ui:repeat>
						 <div class="listBottomDiv"></div>
					</div>
        		</div>
				<div class="mainBodyBottomUpper44">
        			<div class="mainBodyBottomUpperLeftText">Filter By :</div>
        		</div>
        			<ui:include src="/filterMenu.jsp"/> <!-- Add all the menu  -->

				<div class="mainBodyBottomUpper66"></div>
        		
        		<div class="mainBodyBottomUpper77">
	        		<a4j:outputPanel rendered="#{!(twitterController.availableList)}">  
						<a4j:form id="refreshLink1">
		        			<a4j:commandLink value="" id="refreshList"
								actionListener="#{twitterController.twittMessage}" 
								reRender="updateList" style="text-decoration: none; visibility: visible;" 
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();">
								<img src="../images/refreshButton.gif" border="0" onclick="change();"/>
						    </a4j:commandLink>
						</a4j:form>
					</a4j:outputPanel> 
					
					<a4j:outputPanel rendered="#{(twitterController.availableList) and (twitterController.alwaysAskPopupOpen == false)}">  
		        		<a4j:form id="refreshLink2">
		        			<a4j:commandLink value="" id="refreshList"
								actionListener="#{twitterController.twittMessage}" 
								reRender="updateList" style="text-decoration: none; visibility: visible;" 
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();">
								<img src="../images/refreshButton.gif" border="0" onclick="change();"/>
						    </a4j:commandLink>
						</a4j:form>
					</a4j:outputPanel> 
					
					<a4j:outputPanel rendered="#{(twitterController.availableList) and (twitterController.alwaysAskPopupOpen == true)}">  
		        		<div class="mainBodyBottomUpper77">
			        		<a href="#" onclick="document.getElementById('refreshpopup').style.display='block';" style="visibility: visible;">
          							<img src="../images/refreshButton.gif" border="0"/>
          					</a>
						</div>
					</a4j:outputPanel>
					
						<!-- <a4j:include viewId="tweetsLostAlert.jsp"/>  It displays the refresh tweet pop-up -->
			   </div>
        		
             </div>
             <div class="mainBodyBottomUpperGeo">
             <table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory" align="right" style="padding-bottom: 0px; padding-top: 2px; padding-right: 4px;">
	                  			<tr>
	                  			<!--
	                    			<td valign="middle" align="left">
										<h:graphicImage value="../images/bulbGrayGeo.gif" 
										      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulbGrayGeo.gif';">
										     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         <span><h:outputText value="Filter your real time optimization to your locale using Twitter's geolocation service." /></span>
										     </rich:toolTip>
										</h:graphicImage>
									</td>
									<td valign="middle" align="left" style="padding-right: 10px;">
							            GEOLOCATION
							        </td>
							        
									<td valign="middle" align="left">
										<font style="color:#8B8B8B; font-size:11px; font-weight:bold; padding-right: 5px;">
												<a id="displayTextGEO" href="#" 
													onclick="setLongLatitude();toggleTextGEO();" style="text-decoration: none;">ON</a>
										</font>
										
										<font style="color:#8B8B8B; font-size:11px; font-weight:bold; padding-right: 5px;">|</font>
										
										<font style="color:#ffffff; font-size:11px; font-weight:bold; padding-right: 5px;">
											<a id="displayTextGEOOFF" href="#" onclick="toggleTextGEOOFF(); closeList('x6');" 
											   style="text-decoration: none; color: #ffffff;">OFF</a>
										</font>
									</td>
									 
									<td valign="top">
					
						
						<ui:include src="/geoLocation.jsp"/>
						
				
				</td>                    
	          -->
	          </tr>
	    </table>
      </div>
            
         <div id="toggleTextRTO" style="display:none">
               <table width="1030" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                <tr>
                	<td>
                	<div id="mainRTOBodyBottomLower" class="mainBodyBottomLower" onscroll="hideAll(); hideAllActions();" onclick="hideAllActions();">
                	
                		<a4j:form id="twtText" style="margin: 0px;">
	                		<input type="hidden" name="populateTokenText" id="populateTokenText" value=""/>
	                		<input type="hidden" name="populateTokenId" id="populateTokenId" value=""/>
	                		
	                		<a4j:commandLink id="populateTokenHidden" actionListener="#{rtopHandler.viewTextSuggestion}" reRender="tokenCountPanel" oncomplete="setCountData();">
	                			<f:param name="suggestionTokenAction" value="populateTokenHidden"/>
	                		</a4j:commandLink>
	                		
	                		<a4j:outputPanel id="tokenCountPanel">
	                			<input type="hidden" name="tokenCount" id="tokenCount" value="#{rtopHandler.tokenCount}"/>
	                		</a4j:outputPanel>
                		</a4j:form>
                		
                        	<a4j:form id="displayForm" reRender="updateList">
							<a4j:repeat value="#{twitterController.twitterInfoList}" var="twitterList" rowKeyVar="i">
							  <table width="1030" border="0" cellspacing="0" cellpadding="0">
							  <tr>
							  
								<td id="#{twitterList.dtoLeft.cnt}" width="515" valign="top" align="left" style="border-right:1px solid #dddddd; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<a4j:outputPanel rendered="#{!(twitterList.dtoLeft == null)}">
										<ui:include src="/realTimeOptimizationDataLeft.jsp">
											<ui:param name="imglogo" value="#{twitterList.dtoLeft.profileImage}"/>
											<ui:param name="textarealogo" value="#{twitterList.dtoLeft.textAreaImage}"/>
											<ui:param name="textarealogotooltip" value="#{twitterList.dtoLeft.textAreaLogoTooltip}"/>
											<ui:param name="textareacontent" value="#{twitterList.dtoLeft.individualMessage}"/>
											<ui:param name="textareacontentcolor" value=""/>						
											<ui:param name="textareafooter" value="#{twitterList.dtoLeft.tweetReferenceType}"/>
											<ui:param name="msgtype" value="#{twitterList.dtoLeft.tweetReferenceType}"/>
											<ui:param name="twtName" value="#{twitterList.dtoLeft.twitterName}"/>
											<ui:param name="twtScreenName" value="#{twitterList.dtoLeft.twitterScreenName}"/>
											<ui:param name="twtMessage" value="#{twitterList.dtoLeft.twittMessage}"/>
											<ui:param name="twtTweets" value="#{twitterList.dtoLeft.noOfTweets}"/>
											<ui:param name="twtFollows" value="#{twitterList.dtoLeft.noOfFollowers}"/>
											<ui:param name="twtFollowing" value="#{twitterList.dtoLeft.noOfFollowings}"/>
											<ui:param name="twtListed" value="#{twitterList.dtoLeft.noOfListed}"/>
											<ui:param name="twtLocation" value="#{twitterList.dtoLeft.twittLocation}"/>
											<ui:param name="twtDate" value="#{twitterList.dtoLeft.twittDate}"/>
											<ui:param name="twtSource" value="#{twitterList.dtoLeft.source}"/>
											<ui:param name="twtbackGroundImage" value="#{twitterList.dtoLeft.backGroundImage}"/>
											<ui:param name="referenceName" value="#{twitterList.dtoLeft.referenceName}"/>
											<ui:param name="referenceType" value="#{twitterList.dtoLeft.referenceType}"/>
											<ui:param name="boxheaderColor" value="#{twitterList.dtoLeft.boxHeaderColor}"/>
											<ui:param name="boxTextColor" value="#{twitterList.dtoLeft.boxTextColor}"/>
											<ui:param name="tdid" value="#{twitterList.dtoLeft.cnt}"/>
											<ui:param name="twtInfluence" value="#{twitterList.dtoLeft.influence}"/>
											<ui:param name="fullTweetMsg" value="#{twitterList.dtoLeft.fullTweetMsg}"/>
											<ui:param name="twitterStatusID" value="#{twitterList.dtoLeft.twitterStatusID}"/>
											<ui:param name="isFriend" value="#{twitterList.dtoLeft.is_friend}"/>
										</ui:include>
									</a4j:outputPanel>									
									
								</td>
								<td id="#{twitterList.dtoRight.cnt}" width="515" valign="top" align="right" 
								    style="font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
								    <a4j:outputPanel rendered="#{!(twitterList.dtoRight == null)}">
									<ui:include src="/realTimeOptimizationDataRight.jsp">
										<ui:param name="imglogo" value="#{twitterList.dtoRight.profileImage}"/>
										<ui:param name="textarealogo" value="#{twitterList.dtoRight.textAreaImage}"/>
										<ui:param name="textarealogotooltip" value="#{twitterList.dtoRight.textAreaLogoTooltip}"/>
										<ui:param name="textareacontent" value=""/>
										<ui:param name="textareacontentcolor" value=""/>					
										<ui:param name="textareafooter" value="#{twitterList.dtoRight.tweetReferenceType}"/>
										<ui:param name="msgtype" value="#{twitterList.dtoRight.tweetReferenceType}"/>
										<ui:param name="twtName" value="#{twitterList.dtoRight.twitterName}"/>
										<ui:param name="twtScreenName" value="#{twitterList.dtoRight.twitterScreenName}"/>
										<ui:param name="twtMessage" value="#{twitterList.dtoRight.twittMessage}"/>
										<ui:param name="twtTweets" value="#{twitterList.dtoRight.noOfTweets}"/>
										<ui:param name="twtFollows" value="#{twitterList.dtoRight.noOfFollowers}"/>
										<ui:param name="twtFollowing" value="#{twitterList.dtoRight.noOfFollowings}"/>
										<ui:param name="twtListed" value="#{twitterList.dtoRight.noOfListed}"/>
										<ui:param name="twtLocation" value="#{twitterList.dtoRight.twittLocation}"/>
										<ui:param name="twtDate" value="#{twitterList.dtoRight.twittDate}"/>
										<ui:param name="twtSource" value="#{twitterList.dtoRight.source}"/>
										<ui:param name="twtbackGroundImage" value="#{twitterList.dtoRight.backGroundImage}"/>
										<ui:param name="referenceName" value="#{twitterList.dtoRight.referenceName}"/>
										<ui:param name="referenceType" value="#{twitterList.dtoRight.referenceType}"/>
										<ui:param name="boxheaderColor" value="#{twitterList.dtoRight.boxHeaderColor}"/>
										<ui:param name="tdid" value="#{twitterList.dtoRight.cnt}"/>
										<ui:param name="twtInfluence" value="#{twitterList.dtoRight.influence}"/>
										<ui:param name="fullTweetMsg" value="#{twitterList.dtoRight.fullTweetMsg}"/>
										<ui:param name="twitterStatusID" value="#{twitterList.dtoRight.twitterStatusID}"/>
										<ui:param name="isFriend" value="#{twitterList.dtoRight.is_friend}"/>
									</ui:include>
									</a4j:outputPanel>
								</td>
								
								
							 </tr>
							 </table>
							</a4j:repeat>
							
							<a4j:outputPanel rendered="#{!twitterController.tweetInfoList}">
								<div class="twtsuccess" style="text-align: left; width: 505px;">No Results!</div>											 									
    						</a4j:outputPanel>
    						
							</a4j:form>
                  </div>
                	</td>
                </tr>          
            </table>           
        </div>
        <!--****************** Main Body Middle Section Start***************--> 
       </div>
       
    </a4j:outputPanel>
    
    <ui:include src="/whatsHappening.jsp"/>
    
	</div>
     </td>
  </tr>
<!--****************** HAPPENING SECTION Start***************-->                                                              
            <tr>
               <td colspan="2" height="5"></td>
            </tr>   
                                                                  
 <!--****************** HAPPENING SECTION End***************-->
            
            <tr>
                <td valign="bottom">
                    <div class="border" style="margin-top:10px;">
                    </div>
                </td>
            </tr>
<!--******************FOOTER START****************-->
            <tr>
                <td align="left" valign="top">
                     <a4j:include viewId="templates/twitterTemplates/footer.jsp"/>
                </td>
             </tr> 
<!--******************FOOTER END****************-->

       </table>
       </td>
	</tr>
	
	</table>
      </div> 
     
      <h:form id="twitterChannelOptimizerForm" enctype="multipart/form-data">
   		<h:inputHidden value="#{twitterController.twtmessage}"/>
   	  </h:form><!--
   	  
   	  <div id="Ed1" style="width: 800px; height: 700px; border: 1px solid; display: none;">
   	  <img src="../images/preloader3.gif"/>
   	  </div>
   	  
   	  
      -->
      
       <!-- tapasb -->      

		<h:form id="actionIdHiddenForm">
			<h:inputText id="actionIdHidden" value="#{rtopHandler.actionId}" style="visibility: hidden; display: none;" />
		</h:form>			
						
		<a4j:include viewId="userListPopup.jsp" id="userListPopup"/>     
     	     	
      <!-- tapasb -->      
<a4j:outputPanel id="scriptPanel">
	<script language="JavaScript">
	   if(document.URL.indexOf("refresh")>0){
	    toggleRTO();
	   }
	   showPopup2('#{twitterController.openEditProfile}');
	   authValidation1('#{twitterController.validCredentials}');
	   
	   /*if('#{twitterController.openEditProfile}' != 'createProfileAuth'){
	   		authValidation('#{twitterController.validCredentials}');
	   	}*/
	
	   	updateRTOGoalPercentage('#{channelPerformanceController.rtoGoalPercentage}','#{channelPerformanceController.rtoStarCount}','#{channelPerformanceController.rtoFlameCount}');
	</script>
</a4j:outputPanel>    
<a4j:outputPanel id="channelPerformanceActionsPanel" rendered="#{rtopHandler.renderChannelPerformanceActionsPanel}">
	<a4j:outputPanel id="popupPanel" rendered="#{rtopHandler.renderPopupPanel}">
		<h:form>	
			<h:inputHidden value="#{rtopHandler.navigationActions}" />
			<script>openPopupTB('#{rtopHandler.popupDTO.titleBarText}', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', '#{rtopHandler.popupDTO.pageLeft}', '#{rtopHandler.popupDTO.pageTop}', '#{rtopHandler.popupDTO.pageWidth}', '#{rtopHandler.popupDTO.pageHeight}', 10, false, true, false, '#{rtopHandler.popupDTO.jspPageToDisplay}', '#{rtopHandler.popupDTO.actionId}');</script>															
		</h:form>
	</a4j:outputPanel>
	<a4j:outputPanel id="filterPanel" rendered="#{rtopHandler.renderFilterPanel}">
		<script>
			document.getElementById('#{rtopHandler.filterId}').click();
			document.getElementById("list_x1a").style.display = "none";;
		</script>
	</a4j:outputPanel>	
	<h:form>
		<h:inputHidden value="#{rtopHandler.factorInitializer}"/>
	</h:form>
</a4j:outputPanel>
  
      </f:view>
      </body>
	  
</ui:composition>