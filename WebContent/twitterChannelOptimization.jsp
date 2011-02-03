<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/profile.css" rel="stylesheet" type="text/css" />
    <link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
    <script language="JavaScript" src="../js/designMainScreen.js"></script>

	<script language="JavaScript">
		function setProfileId(profileName){
			document.getElementById('captionDiv').innerHTML="@" + profileName;
		}
		function setSortById(name){
			document.getElementById('captionDivSortby').innerHTML=name;
			// this is tempo solution to replace the textarea content and textarea footer to the selected item from the sortbylist
			//document.getElementById('tarea1').value=name;
		}
	</script>
    <f:view>
    <div class="page">
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
					<table width="400" border="0" cellspacing="0" cellpadding="0" style="margin-left: 15px; margin-top: 41px;">
					   <tr>
					     <td valign="bottom" align="center" width="208">													
							<a href="mainScreen.jsp"> 
							  <img src="../images/channelPerformanceGeneral.gif" border="0"	style="margin-bottom: 4px;"/> 
							</a>
						  </td>
						  <td width="10"></td>
							<td valign="bottom" align="center" width="177"> 
							  <img	src="../images/channelOptimizationSelected.gif" border="0"/> 
							</td>
					   </tr>
					</table>
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
                             <div class="bodyTopFirst">
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
                                                          <td valign="middle" align="left" class="topFirstTableMatter" width="50">#{userProfileController.userProfile.improvementLevel.pctValue}</td>
                                                          <td valign="middle" align="left" class="topFirstTableMatter" width="145">
                                                            <h:form id="generateStarForm">
                                                             <a4j:repeat value="#{userProfileController.userProfile.generateStar}" rowKeyVar="i">
																<h:graphicImage value="../images/yellowStar.gif" onmouseover="this.src='../images/yellowStar.gif';" onmouseout="this.src='../images/yellowStar.gif';" style=" margin-right:5px">
																	<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																	<span>
																	  <h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." />
																	</span>
																	</rich:toolTip>
																</h:graphicImage> 
															  </a4j:repeat>
															</h:form>	
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
                                                           	  <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 6, false, true, false, 'editProfile.jsp')" 
                                                                 style="color:#77C442; text-decoration:none;">CHANGE</a>
                                                         </td>
                                                       </tr>
                                                     </table>
                                                  </td>
                                              </tr>                                                                                      
                                          </table>
                                       </td>
                                       <td valign="top" align="center" width="380" style="border-right:1px solid #F6F6F6;">
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

				<!-- loop through outbound metrics and list only the required metrics -->
<!-- 
				<a4j:repeat value="#{channelPerformanceController.outboundMetricsDummy}" var="overallOutbounds" rowKeyVar="i"> 
				<a4j:outputPanel  rendered="#{overallOutbounds.channelOptActionDisplay}" >
					<tr>
						<td valign="middle" align="left" class="topFirstTableinflu" width="95">
							<a4j:repeat value="#{overallOutbounds.counter}">
								<h:graphicImage value="../images/orangeLogo.gif" 
	  											onmouseover="this.src='../images/orangeLogo.gif';" onmouseout="this.src='../images/orangeLogo.gif';">
	 											<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
	     											<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
	 											</rich:toolTip>
								</h:graphicImage>
							</a4j:repeat>
							
							<a4j:repeat value="#{overallOutbounds.starCounter}">
								<h:graphicImage value="../images/yellowStar.gif" 
						      		onmouseover="this.src='../images/yellowStar.gif';" onmouseout="this.src='../images/yellowStar.gif';" style=" margin-right:5px">
						     		<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
						         		<span><h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." /></span>
						     		</rich:toolTip>
								</h:graphicImage> 
							</a4j:repeat>	
						</td>
						<td valign="middle" align="left" class="topFirstTableinflu" width="205">
							#{overallOutbounds.alertMessage}
						</td>
						<td valign="middle" align="left" class="topFirstTableinflu" width="70">
							<a href="#" onclick="openPopup('',324, 90, 870, 460, 10, false, true, false, 'optimization1.jsp')">
								<img src="../images/optimizeButton.gif" border="0"/>
							</a>
						</td>
					</tr>
				</a4j:outputPanel>
				</a4j:repeat>
-->

<!-- This block will be removed after clarification from Wendy -->
                                                                     
                                               <tr>
                                                  <td valign="middle" align="left" class="topFirstTableinflu" width="95">
                                                    <h:graphicImage value="../images/orangeLogo.gif" onmouseover="this.src='../images/orangeLogo.gif';" onmouseout="this.src='../images/orangeLogo.gif';">
														<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														</rich:toolTip>
													</h:graphicImage> 
													<h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														</rich:toolTip>
													</h:graphicImage> 
													<h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														</rich:toolTip>
													</h:graphicImage>
													<h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														</rich:toolTip>
													</h:graphicImage>      
                                                 </td>
                                                 <td valign="middle" align="left" class="topFirstTableinflu" width="205">25 influencers to follow</td>
												 <td valign="middle" align="left" class="topFirstTableinflu" width="70">
                                                     <a href="#" onclick="openPopup1('Influencers to Follow',424, 150, 410, 295, 10, false, true, false, 'influFollowAlert.jsp')">
                                                        <img src="../images/optimizeButton.gif" border="0"/>
                                                     </a>
                                                 </td>
                                               </tr>
                                               <tr>
                                                  <td valign="middle" align="left" class="topFirstTableinflu" width="95">
                                                     <h:graphicImage value="../images/orangeLogo.gif" onmouseover="this.src='../images/orangeLogo.gif';" onmouseout="this.src='../images/orangeLogo.gif';">
														 <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														 </rich:toolTip>
													 </h:graphicImage> 
													 <h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															 <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														  </rich:toolTip>
													  </h:graphicImage> 
													  <h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															 <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														  </rich:toolTip>
													  </h:graphicImage>
													  <h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															  <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														  </rich:toolTip>
													  </h:graphicImage>      
                                                   </td>
                                                   <td valign="middle" align="left" class="topFirstTableinflu" width="205">5 influencers to list</td>
												   <td valign="middle" align="left" class="topFirstTableinflu" width="70">
                                                       <a href="#" onclick="openPopup1('Add to List',84, 90, 800, 350, 10, false, true, false, 'addToListAlert.jsp')">
                                                          <img src="../images/optimizeButton.gif" border="0"/>
                                                       </a>
                                                   </td>
                                                </tr>
                                                <tr>
                                                   <td valign="middle" align="left" class="topFirstTableinflu" width="95">
                                                      <h:graphicImage value="../images/orangeLogo.gif" onmouseover="this.src='../images/orangeLogo.gif';" onmouseout="this.src='../images/orangeLogo.gif';">
														  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															 <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														  </rich:toolTip>
													  </h:graphicImage> 
													  <h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
														     <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														  </rich:toolTip>
													  </h:graphicImage> 
													  <h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														   <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
															   <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														   </rich:toolTip>
														   </h:graphicImage>
													 <h:graphicImage value="../images/grayLogo.gif" onmouseover="this.src='../images/grayLogo.gif';" onmouseout="this.src='../images/grayLogo.gif';" style="margin-left: 4px;">
														 <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
														    <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
														 </rich:toolTip>
													 </h:graphicImage>      
                                                   </td>
                                                   <td valign="middle" align="left" class="topFirstTableinflu" width="205">25 Tweets to favorite</td>
												   <td valign="middle" align="left" class="topFirstTableinflu" width="70">
                                                       <a href="#" onclick="openPopup1('Tweets to Favorite',424, 150, 430, 325, 10, false, true, false, 'tweetsFavoriteAlert.jsp')">
                                                          <img src="../images/optimizeButton.gif" border="0"/>
                                                       </a>
                                                   </td>
                                                </tr>
<!-- END of This block will be removed after clarification from Wendy -->  
                                          </table>
                                       </td>
                                       <td valign="top" align="center" width="430" style="border-right:1px solid #F6F6F6;">
                                          <table width="430" border="0" cellspacing="0" cellpadding="0">
                                             <tr>
                                                <td valign="middle" align="left">
                                                   <table cellpadding="0" cellspacing="0">
                                                      <tr>
                                                         <td valign="middle" align="left" class="topFirstTablehd">Accomplishments</td>
                                                         <td valign="middle" align="left">
                                                           <h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
															   <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																  <span><h:outputText value="This tracks the number of real-time optimization improvements you've achieved to date." /></span>
															   </rich:toolTip>
														   </h:graphicImage> 
                                                          </td>
                                                       </tr>
                                                    </table>
												 </td>
                                               </tr>
                                               <tr>
                                                  <td valign="middle" align="left" class="topFirstTableMatter">
                                                      <table width="350" border="0" cellspacing="0" cellpadding="0">
                                                         <tr>
                                                            <td valign="middle" align="left">
                                                                <h:graphicImage value="../images/milestoneImage7.gif" onmouseover="this.src='../images/milestoneImage7.gif';" onmouseout="this.src='../images/milestoneImage7.gif';" style="margin-left: 4px;">
																    <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																		<span><h:outputText value="You have been Optimizing for 1 month and under." /></span>
																	</rich:toolTip>
																 </h:graphicImage>
                                                            </td>
                                                            <td valign="middle" align="left">
                                                                <h:graphicImage value="../images/milestoneImage1.gif" onmouseover="this.src='../images/milestoneImage1.gif';" onmouseout="this.src='../images/milestoneImage1.gif';" style="margin-left: 4px;">
																     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																		<span><h:outputText value="You have reached your Very Aggressive (gold), Aggressive (silver) or Moderate (bronze) goal." /></span>
																	 </rich:toolTip>
																</h:graphicImage>
															</td>
                                                            <td valign="middle" align="left">
                                                               <h:graphicImage value="../images/milestoneImage2.gif" onmouseover="this.src='../images/milestoneImage2.gif';" onmouseout="this.src='../images/milestoneImage2.gif';" style="margin-left: 4px;">
																   <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																	   <span><h:outputText value="Awarded each time you increase your Influence score." /></span>
																	</rich:toolTip>
															   </h:graphicImage>
															</td>
                                                            <td valign="middle" align="left">
                                                                <h:graphicImage value="../images/milestoneImage3.gif" onmouseover="this.src='../images/milestoneImage3.gif';" onmouseout="this.src='../images/milestoneImage3.gif';" style="margin-left: 4px;">
																	 <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																		<span><h:outputText value="Awarded each time you increase your #hashtag usage by at least 5%." /></span>
																	  </rich:toolTip>
																</h:graphicImage>               
															</td>
                                                            <td valign="middle" align="left">
                                                                <h:graphicImage value="../images/milestoneImage4.gif" onmouseover="this.src='../images/milestoneImage4.gif';" onmouseout="this.src='../images/milestoneImage4.gif';" style="margin-left: 4px;">
																    <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																		<span><h:outputText value="Awarded each time you increase your Bit.ly usage by at least 10%." /></span>
																	</rich:toolTip>
																</h:graphicImage>             
															</td>
                                                            <td valign="middle" align="left">
                                                                <h:graphicImage value="../images/milestoneImage5.gif" onmouseover="this.src='../images/milestoneImage5.gif';" onmouseout="this.src='../images/milestoneImage5.gif';" style="margin-left: 4px;">
																     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																		 <span><h:outputText value="Awarded each time you increase your Positive sentiment by at least 5% or decrease you Negative sentiment by at least 3%." /></span>
																	 </rich:toolTip>
																 </h:graphicImage>              
															</td>
                                                            <td valign="middle" align="left">
	                                                            <h:graphicImage value="../images/milestoneImage6.gif" onmouseover="this.src='../images/milestoneImage6.gif';" onmouseout="this.src='../images/milestoneImage6.gif';" style="margin-left: 4px;">
																    <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																	   <span><h:outputText value="Awarded each time you increase your references of Trending themes by at least 2%." /></span>
																	</rich:toolTip>
																</h:graphicImage>              
															</td>
                                                         </tr>
                                                         <tr>
                                                            <td valign="middle" align="left" height="35">
                                                                <div class="milestone1">Newbie</div>
                                                            </td>
                                                            <td valign="middle" align="center" height="35">
																<div class="milestone">22</div>
															</td>
                                                            <td valign="middle" align="center">
                                                                <div class="milestone">22</div>
                                                            </td>
                                                            <td valign="middle" align="center">
                                                                <div class="milestone">22</div>
															</td>
                                                            <td valign="middle" align="center">
                                                            	<div class="milestone">22</div>
															</td>
                                                            <td valign="middle" align="center">
                                                            	<div class="milestone">22</div>
															</td>
                                                            <td valign="middle" align="center">
                                                            	<div class="milestone">22</div>
															</td>
                                                          </tr>
                                                        </table>
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
	<tr>
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
      <tr>
         <td width="1050" valign="top" align="left">
             <div class="bodyTopSecondChannelPerf">  
                  <div id="toggleTextOM" style="display: none"> 
                       <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                             <td class="topFirstTablehdCategory" valign="middle" align="left" width="350">Outbound Metrics <font style="font-weight: normal;">(Sorted by most underperforming metric relative to the competitor average)</font>
                                 <h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
					 				  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										 <span><h:outputText value="A measure of activities that relate to your use of Twitter." /></span>
									  </rich:toolTip>
								 </h:graphicImage>
							 </td>
                             <td valign="middle" align="center" width="120">
                                 <table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                                    <tr>
                                       <td valign="middle" align="center">Current</td>
									   <td valign="middle" align="left">
										   <h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
											   <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
												  <span><h:outputText value="This is your current score for the Outbound metric." /></span>
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
											 <h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
												  <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
												      <span><h:outputText value="This is your target score (based on your selected goal) for the Outbound metric." /></span>
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
                                              <h:graphicImage value="../images/bulb.jpg" onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
												   <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
												  	 <span><h:outputText value="Performance towards or against reaching your goal." /></span>
												   </rich:toolTip>
											   </h:graphicImage>
                                           </td>
                                       </tr>
                                 </table>
                             </td>
                          </tr>
                                  
<!-- Populating values for outbound --> 
							<h:form id="performanceCOntrollerForm">
							   <h:inputHidden id="outboundMetricslist" value="#{channelPerformanceController.channelOptimizationOutbound}"/>
							      <a4j:repeat value="#{channelPerformanceController.outboundMetricsDummy}" var="overallOutbounds" rowKeyVar="i"> 
								      <tr bgcolor="#{(i%2==0)?('ededed'):('white')}">
                                         <td align="left" valign="middle" class="topFirstTablehdCategory">
                                           <div class="COGoal">#{overallOutbounds.metricsName}
                                              <h:graphicImage value="../images/bulb.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
									     		   <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									         		  <span><h:outputText value="#{overallOutbounds.metricsDesc}" /></span>
									     		   </rich:toolTip>
											  </h:graphicImage>
											</div>
                                    	  </td>
                                    	  <td align="center" valign="middle" class="topFirstTablehdCategoryDataLast">#{overallOutbounds.custVolumeFormatted}</td>
										  <td align="center" valign="middle" class="topFirstTablehdCategoryDataLast">#{overallOutbounds.custTargetFormatted}</td>                                 
									      <td align="left" valign="middle" class="topFirstTablehdCategoryCOGreen">
											 <a4j:repeat value="#{overallOutbounds.counter}">
											 <h:graphicImage value="../images/orangeLogo.gif" onmouseover="this.src='../images/orangeLogo.gif';" onmouseout="this.src='../images/orangeLogo.gif';">
     											<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
         											<span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
     											</rich:toolTip>
											</h:graphicImage>
											</a4j:repeat>
											
											<a4j:repeat value="#{overallOutbounds.starCounter}">
											<h:graphicImage value="../images/yellowStar.gif" onmouseover="this.src='../images/yellowStar.gif';" onmouseout="this.src='../images/yellowStar.gif';" style=" margin-right:5px">
									     		<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									         		<span><h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." /></span>
									     		</rich:toolTip>
											</h:graphicImage> 
											</a4j:repeat>
										</td>
								  </tr>
							</a4j:repeat>
							</h:form>	
                       </table>
                    <div style="border:1px solid #D4D4D4; margin-top:10px;"></div>      
                 </div> 
              </div>
         </td>
     </tr>
     <tr>
     <td valign="top" align="left">
     <div class="mainBody">
         <div class="mainBodyBottom">
              <!--****************** Main Body Middle Section Start***************-->                                      
             <div class="mainBodyBottomUpper">
             	<div class="mainBodyBottomUpper11">
             		<a id="displayTextRTO" href="javascript:toggleRTO();">
                         <img src="../images/dropDown.gif" border="0"/>
                    </a>
        		</div>
        		<div class="mainBodyBottomUpper22">
        			<div  class="mainBodyBottomUpperLeftText">Real-Time Optimization</div>
        		</div>
        		<div class="mainBodyBottomUpper33">
        		<div class="mainDivTop" id="main_x1">
					<div id="captionDiv" class="captionDivTop">@Customer 1</div> 
					<div class="textDiv">
						<input  type="text" value="" class="fakeText" onblur="closeList('x1');" onclick="toggleList('x1')" readonly="readonly" style="cursor:auto; text-align:right; "/>
					</div>
					    
					</div>
					<div class="listDivTop" id="list_x1" onmouseover="setInList(true);" onmouseout="setInList(false);">
						 <ui:repeat value="#{channelPerformanceController.twitterAccount}" var="twitterAccount">
						              <div class="itemDivTop">
						              	<a onclick="setProfileId('#{twitterAccount.twitterUsername}');toggleList('x1');openRTO();" href="#" class="optiontext">
						               @#{twitterAccount.twitterUsername}
						               </a>
						               </div>
						 </ui:repeat>
						 <div class="listBottomDiv"></div>
					</div>
        		</div>
				<div class="mainBodyBottomUpper44">
        			<div class="mainBodyBottomUpperLeftText">Sort By:</div>
        		</div>
				<div class="mainBodyBottomUpper55">
        		<div class="mainDivTopSB" id="main_x1a">
								<div id="captionDivSortby" class="captionDivTop">All</div> 
								<div class="textDiv">
									<input  type="text" value="" class="fakeText" onblur="closeList('x1a');" onclick="toggleList('x1a')" readonly="readonly" style="cursor:auto; text-align:right; "/>
								</div>							    
							</div>
							<div class="listDivTop" id="list_x1a" onmouseover="setInList(true);" onmouseout="setInList(false);">
								<div class="itemDivTop"><a onclick="setSortById('All');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">All</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Theme');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Theme</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Hashtag');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Hashtag</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Bit.ly');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Bit.ly</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Negative Sentiment');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Negative Sentiment</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Positive Sentiment');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Positive Sentiment</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Influencer');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Influencer</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Brand Mention');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Brand Mention</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Product Mention');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Product Mention</a></div>
								<div class="itemDivTop"><a onclick="setSortById('Industry Mention');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">Industry Mention</a></div>
								<div class="itemDivTop"><a onclick="setSortById('All @mentions');toggleList('x1a');" href="javascript:openRTO();" class="optiontext">All @mentions</a></div>
								<div class="listBottomDiv"></div>
							</div>
        		
        		</div>
		<div class="mainBodyBottomUpper66">
        		</div>
        		<div class="mainBodyBottomUpper77">
        		<h:form id="refreshLink">
        			<h:commandLink value="" id="refreshTwitt"
						actionListener="#{twitterController.twittMessage}" 
						style="text-decoration: none;">
						<img src="../images/refreshButton.gif" border="0"/>
				    </h:commandLink>
				</h:form>
		</div>
        		
             </div>
             <div class="mainBodyBottomUpperGeo">
             <table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory" align="right">
	                  			<tr>
	                    			<td valign="middle" align="left">
	                    			Geolocation
	                 			</td>
	                    			<td valign="middle" align="left">
					<h:graphicImage value="../images/bulb.jpg" 
					      onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
					     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
					         <span><h:outputText value="Filter your real time optimization to your locale using Twitter's geolocation service." /></span>
					     </rich:toolTip>
					</h:graphicImage>
			</td>
			<td valign="middle" align="left">
				<h:form id="geoLocationToggle" style="margin-bottom: 0px; margin-top: 0px;">
				 		<h:commandLink value="#{twitterController.geoEnabled}" id="geoEnabled"
				 				actionListener="#{twitterController.geoLocationEnable}"
				 				style="text-decoration: none;color:#77C442; font-size:14px; font-weight:normal"/>
				 	
				</h:form>
			<!-- 	<font style="color:#77C442; font-size:14px; font-weight:normal">ON</font>   -->	
			</td>                     
	          </tr>
	          </table>
             </div>
         <div id="toggleTextRTO" style="display: none">
               <table width="100%" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                   <div class="mainBodyBottomLower">
                        <table width="1050" border="0" cellspacing="0" cellpadding="0" style="margin-left:15px;">
                        	<h:form id="displayForm">
							<a4j:repeat value="#{twitterController.twitterInfoList}" var="twitterList" rowKeyVar="i">
							<tr>
								<td id="#{twitterList.dtoLeft.cnt}" width="525" valign="top" align="left" 
									style="border-right:1px solid #dddddd; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationDataLeft.jsp">
										<ui:param name="imglogo" value="#{twitterList.dtoLeft.profileImage}"/>
										<ui:param name="textarealogo" value="1.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets that reference a theme or topic that is trending high within your network."/>
										<ui:param name="textareacontent" value="#{twitterList.dtoLeft.individualMessage}"/>
										<ui:param name="textareacontentcolor" value="#B6D976"/>						
										<ui:param name="textareafooter" value="THEME REFERENCE"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="twtName" value="#{twitterList.dtoLeft.twitterName}"/>
										<ui:param name="twtMessage" value="#{twitterList.dtoLeft.twittMessage}"/>
										<ui:param name="twtTweets" value="#{twitterList.dtoLeft.noOfTweets}"/>
										<ui:param name="twtFollows" value="#{twitterList.dtoLeft.noOfFollowers}"/>
										<ui:param name="twtFollowing" value="#{twitterList.dtoLeft.noOfFollowings}"/>
										<ui:param name="twtListed" value="#{twitterList.dtoLeft.noOfListed}"/>
										<ui:param name="twtLocation" value="#{twitterList.dtoLeft.twittLocation}"/>
										<ui:param name="twtDate" value="#{twitterList.dtoLeft.twittDate}"/>
										<ui:param name="twtbackGroundImage" value="#{twitterList.dtoLeft.backGroundImage}"/>
										<ui:param name="tdid" value="#{twitterList.dtoLeft.cnt}"/>
									</ui:include>
								</td>
								
								<td id="#{twitterList.dtoRight.cnt}" width="525" valign="top" align="right" 
								    style="border-bottom:1px solid #F5F5F5; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationDataRight.jsp">
										<ui:param name="imglogo" value="#{twitterList.dtoRight.profileImage}"/>
										<ui:param name="textarealogo" value="5.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets from Influencers within your network."/>
										<ui:param name="textareacontent" value="@influencer"/>
										<ui:param name="textareacontentcolor" value="#6E7177"/>					
										<ui:param name="textareafooter" value="INFLUENCER"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="twtName" value="#{twitterList.dtoRight.twitterName}"/>
										<ui:param name="twtMessage" value="#{twitterList.dtoRight.twittMessage}"/>
										<ui:param name="twtTweets" value="#{twitterList.dtoRight.noOfTweets}"/>
										<ui:param name="twtFollows" value="#{twitterList.dtoRight.noOfFollowers}"/>
										<ui:param name="twtFollowing" value="#{twitterList.dtoRight.noOfFollowings}"/>
										<ui:param name="twtListed" value="#{twitterList.dtoRight.noOfListed}"/>
										<ui:param name="twtLocation" value="#{twitterList.dtoRight.twittLocation}"/>
										<ui:param name="twtDate" value="#{twitterList.dtoRight.twittDate}"/>
										<ui:param name="twtbackGroundImage" value="#{twitterList.dtoRight.backGroundImage}"/>
										<ui:param name="tdid" value="#{twitterList.dtoRight.cnt}"/>
									</ui:include>
								</td>
							</tr>
							</a4j:repeat>
							</h:form>
							<!--<tr>
								<td id="varTdId2" width="525" valign="middle" align="left" 
									style="border-right:1px solid #dddddd; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationData.jsp">
										<ui:param name="imglogo" value="Logo2.gif"/>
										<ui:param name="textarealogo" value="2.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets that include a Hashtag."/>
										<ui:param name="textareacontent" value="#consecuter"/>	
										<ui:param name="textareacontentcolor" value="#B6D976"/>					
										<ui:param name="textareafooter" value="#HASHTAG REFERENCE"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="tdid" value="varTdId2"/>
									</ui:include>
								</td>
								<td id="varTdId3" width="525" valign="middle" align="right" 
								    style="border-bottom:1px solid #F5F5F5; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationData.jsp">
										<ui:param name="imglogo" value="Logo6.gif"/>
										<ui:param name="textarealogo" value="6.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets within the 'Twitterverse' that reference your Brand."/>
										<ui:param name="textareacontent" value="Brand Name"/>	
										<ui:param name="textareacontentcolor" value="#6E7177"/>						
										<ui:param name="textareafooter" value="BRAND MENTION"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="tdid" value="varTdId3"/>
									</ui:include>
								</td>
							</tr>
							 <tr>
								<td id="varTdId4" width="525" valign="middle" align="left" 
									style="border-right:1px solid #dddddd; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationData.jsp">
										<ui:param name="imglogo" value="Logo3.gif"/>
										<ui:param name="textarealogo" value="3.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets that include a Bit.ly reference."/>
										<ui:param name="textareacontent" value="http://bit.ly.12.31a"/>	
										<ui:param name="textareacontentcolor" value="#B6D976"/>					
										<ui:param name="textareafooter" value="BIT.LY"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="tdid" value="varTdId4"/>
									</ui:include>
								</td>
								<td id="varTdId5" width="525" valign="middle" align="right" 
								    style="border-bottom:1px solid #F5F5F5; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationData.jsp">
										<ui:param name="imglogo" value="Logo7.gif"/>
										<ui:param name="textarealogo" value="7.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets within the 'Twitterverse' that reference topics relating to your Industry."/>
										<ui:param name="textareacontent" value="Industry Keyword"/>	
										<ui:param name="textareacontentcolor" value="#6E7177"/>						
										<ui:param name="textareafooter" value="INDUSTRY MENTION"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="tdid" value="varTdId5"/>
									</ui:include>
								</td>
							</tr>
							<tr>
								<td id="varTdId6" width="525" valign="middle" align="left" 
									style="border-right:1px solid #dddddd; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationData.jsp">
										<ui:param name="imglogo" value="Logo4.gif"/>
										<ui:param name="textarealogo" value="4.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets that include Positive or Negative sentiment."/>
										<ui:param name="textareacontent" value="I dont like it :) adipiscing"/>	
										<ui:param name="textareacontentcolor" value="#B6D976"/>					
										<ui:param name="textareafooter" value="NEGATIVE"/>
										<ui:param name="msgtype" value="NEGATIVE"/>
										<ui:param name="tdid" value="varTdId6"/>
									</ui:include>
								</td>
								<td id="varTdId7" width="525" valign="middle" align="right" 
								    style="border-bottom:1px solid #F5F5F5; font-size: 32px; color: #EBEBEB; font-weight: bold; font-family: arial;">
									<ui:include src="/realTimeOptimizationData.jsp">
										<ui:param name="imglogo" value="Logo7.gif"/>
										<ui:param name="textarealogo" value="7.gif"/>
										<ui:param name="textarealogotooltip" value="Tweets within the 'Twitterverse' that reference topics relating to your Product."/>
										<ui:param name="textareacontent" value="Product Keyword"/>	
										<ui:param name="textareacontentcolor" value="#6E7177"/>						
										<ui:param name="textareafooter" value="PRODUCT MENTION"/>
										<ui:param name="msgtype" value=""/>
										<ui:param name="tdid" value="varTdId7"/>
									</ui:include>
								</td>
							</tr> -->
                     </table>
                  </div>       
            </table>           
        </div>
        <!--****************** Main Body Middle Section Start***************--> 
                                                       
                                                 </div>
                                   </div>
                  </td>
         	</tr>
<!--****************** HAPPENING SECTION Start***************-->                                                              
            <tr>
            <td colspan="2" valign="middle" align="left">
                <div class="happening" style="margin-left:15px;">
                    <div class="happeningTop">
                        <table width="100%" border="0" class="topFirstTablehdCategory" cellspacing="0" cellpadding="0" height="30">
                                      <tr>
                                        <td class="mainBodyBottomUpperLeftHappiningText" valign="middle">WHAT'S HAPPENING</td>
                                      </tr>
                        </table>
                    </div>
                    <div class="happeningBottom">
                    <h:form id="happenning">
                        <table width="80%" border="0" class="topFirstTablehdCategory" cellspacing="0" cellpadding="0" style="margin-left:20px; margin-top:20px;">
                                      <tr>
                                        <td width="45" align="center" valign="top">
                                            <img src="../images/demoPerson.png" border="0"/>
                                        </td>
                                        <td width="330" align="center" valign="top">
                                            <h:inputTextarea value="#{twitterController.twtmessage}" cols="45" rows="3"/>
                                        </td>
                                        <td valign="bottom">
                                        <table width="100%"  border="0" cellspacing="0" cellpadding="0" height="55">
                                                          <tr>
                                                            <td class="topFirstTablehdCategoryDate" valign="top" align="left">
                                                            0/140
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                          
                                                            <td valign="center" align="left">
                                                            <h:commandLink value="" id="whatIsHappening"
																actionListener="#{twitterController.twittMessage}" 
																style="text-decoration: none;">
                                                            	<img src="../images/sendTweetButton.gif" border="0" style="margin-left:8px;"/>
                                                            </h:commandLink>
                                                            </td>
                                                           
                                                          </tr>
                                          </table>
                                        </td>
                                     </tr>
                                     <tr style="padding-left: 30px;">
                                     	<td class="matter" colspan="2" align="left" style="padding-left:72px;">
                                     		<img src="../images/gunPoint.PNG"/>
                                     		<font style="font-weight: normal; color: rgb(126, 190, 76); font-size: 14px;">Add your location</font>
                                     	</td>
                                     </tr>
                          </table>
                       </h:form>
                    </div>
                </div>
            </td>
          </tr> 
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
       
      </div> 
      <h:form id="twitterChannelOptimizerForm" enctype="multipart/form-data">
   		<h:inputHidden value="#{twitterController.twtmessage}"/>
   	  </h:form>
      </f:view>
<script language="JavaScript">
   if(document.URL.indexOf("refresh")>0){
    toggleRTO();
   }
   </script>
</ui:composition>

	

