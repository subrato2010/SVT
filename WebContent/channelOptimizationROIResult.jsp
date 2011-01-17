
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">
	<ui:define name="head">
		<a4j:loadStyle src="/style/roi.css" />
		<a4j:loadScript src="/js/roi.js" />
		<a4j:loadScript src="/js/custom-form-elements.js" />
	</ui:define>
	<ui:define name="title">
		ROI Optimization
	</ui:define>
	<ui:define name="menu">
		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{overallROIController}"/>
		</ui:include>
	</ui:define>
	<ui:define name="tabs">
	<h:form >
		<table  border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="middle"  width="102">
					<h:commandLink action="overallscore" value="">
						<img src="../images/overallscore/general/dashboard.gif" border="0"  name="pic1"   onmouseover="document.pic1.src='../images/overallscore/rollover/dashboardRollover.gif'" onmouseout="document.pic1.src='../images/overallscore/general/dashboard.gif'" />
					</h:commandLink>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle"  width="102">		
					<h:commandLink action="analysis" value="">
						<img src="../images/overallscore/general/analysis.gif" border="0"  name="pic2"   onmouseover="document.pic2.src='../images/overallscore/rollover/analysisRollover.gif'" onmouseout="document.pic2.src='../images/overallscore/general/analysis.gif'" />
					</h:commandLink>		   					
				</td> 
				<td width="5px"></td>
				<td align="center" valign="middle"  width="102">
					<h:commandLink action="datainput" value="">
						<img src="../images/overallscore/general/datainput.gif" border="0"  name="pic3"   onmouseover="document.pic3.src='../images/overallscore/rollover/datainputRollover.gif'" onmouseout="document.pic3.src='../images/overallscore/general/datainput.gif'" />
					</h:commandLink>					
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="105">
					<img src="../images/overallscore/inactive/trendingInactive.jpg" border="0"/>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="154">
						<img src="../images/overallscore/selected/roiSelected.jpg" border="0"/>
				</td>
			</tr>
		</table>
	</h:form>
	</ui:define>
	<ui:define name="body_right_pannel">
		<h:form id="roi">
		
			<h:inputHidden id="channel0" value="#{overallROIController.channelA.adjTargetScore }" />
			<h:inputHidden id="channel1" value="#{overallROIController.channelB.adjTargetScore }" />
			<h:inputHidden id="channel2" value="#{overallROIController.channelC.adjTargetScore }" />
			<h:inputHidden id="channel3" value="#{overallROIController.channelD.adjTargetScore }" />
			<h:inputHidden id="channel4" value="#{overallROIController.channelE.adjTargetScore }" />
			<h:inputHidden id="channel5" value="#{overallROIController.channelF.adjTargetScore }" />
			<h:inputHidden id="channel6" value="#{overallROIController.channelG.adjTargetScore }" />
			<h:inputHidden id="channel7" value="#{overallROIController.channelH.adjTargetScore }" />
			<h:inputHidden id="channel8" value="#{overallROIController.channelI.adjTargetScore }" />
				
				
		<table border="0" width="100%"><tr><td>
		<!-- *************Body Right Pannel TOP Start ***************-->

				<div id="right_pannel_top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top">
						<!--****************************Top Pannel Start**********************************-->
						<div class="roi_inside">
						<div class="roi_inside_top">
                           	<div class="roi_inside_top1">
                               </div>
                           	<div class="roi_inside_top2">
                               	<div class="roi_inside_top2_heading">
                                   	<table width="100%">
                                   		<tr>
                                   			<td class="roi_hd">Website Optimization</td>
                                   			
                                   			
                                   			<td class="roi_hdSelectChannel" align="right" width="100px">CHANNEL OPTIMIZATION</td>
                                   			<td width="183px" valign="bottom" align="left">
													<div class="mainDiv_green" id="main_x5">
													<div class="captionDiv" style="color:#ffffff;">Select channel</div> 
													<div class="textDiv">
														<input  type="text" value="" class="fakeText" onblur="closeList('x5');" onclick="toggleList('x5')" readonly="readonly" style="cursor:auto; text-align:right; "/>
													      
													</div>
													</div>
													<div class="listDiv_green" id="list_x5" onmouseover="setInList(true);" onmouseout="setInList(false);">
													<ui:repeat value="#{listItemMgr.channelDTOList}" var="channel">
													    <div class="itemDiv_green">
														    <a  href="channelOptimizationROI.jsp?channelName=#{channel.channelNameEscaped}" class="optiontext">
														     	#{channel.channelName}
														    </a>
													    </div>
													  
													</ui:repeat>
													<div class="listBottomDiv_green"></div>
													</div>


										</td>
										<td class="roi_hdSelectChannel" align="right" width="100px">OVERALL OPTIMIZATION</td>
                                   			<td width="183px" valign="top" align="left">
													<!-- <a  href="overallROI.jsp"> -->
													<div class="mainDiv_green1">
													<div class="captionDiv" style="color:#ffffff;">Select overall</div> 
													</div>
													<!-- </a> -->
													
													

										</td>
                                   		</tr>
                                   	
                                   	</table>
                                   	
                                   
								</div>
                               	<div class="roi_inside_top2_border">
                                </div>
                               	<div class="roi_inside_top2_matter">
                                 	  <font class="roi_text"> The following metrics were used for optimization in this campaign.</font>
                                </div>
                               	<div class="roi_inside_top2_bottom">
                                   	<div class="roi_inside_top2_bottom_left">
                                     	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                             <tr>
	                                               <td height="22" valign="top">
	                                              		<div class="roi_bottom_row">
			                                               	<div class="roi_bottom_row_left">
			                                    <h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The name you choose for your campaign for identification purposes." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
			                                                </div>
			                                               	<div class="roi_bottom_row_title">
			                                                   	<font class="roi_row_hd_text">Campaign Name:</font>
			                                                </div>
			                                               	<div class="roi_bottom_row_matter">
			                                                   	<font class="roi_row_hd_text"><h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="8"/></font>
			                                                </div>
	                                               		</div>
	                                               </td>
                                          	</tr>
											<tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
			                                               	<div class="roi_bottom_row_left">
			                                                <h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The time period you choose to use as a point of comparison for your campaign." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
					   										</div>
			                                               	<div class="roi_bottom_row_title">
			                                                   	<font class="roi_row_hd_text">Benchmark Date Range:</font>
			                                                </div>
			                                               	<div class="roi_bottom_row_matter">
			                                                </div>
	                                               </div>
                                               </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row_left1">
	                                               </div>
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_matter">
		                                                   <font class="roi_row_hd_text">12/10/10</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text" style="padding-left: 6px">to End</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   <font class="roi_row_hd_text">13/10/10</font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr>
                                             <tr>
                                               <td height="30" valign="middle">
                                               
                                               <div class="roi_bottom_row">
                                               	<div class="roi_bottom_row_left">
                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The time period you choose to set to optimize your channels for improved performance that will be measured against your benchmark performance." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
                                                 </div>
                                               	<div class="roi_bottom_row_title">
                                                   	<font class="roi_row_hd_text">Campaign Date Range:</font>
                                                   </div>
                                               	<div class="roi_bottom_row_matter">
                                                   
                                                   	
                                                   	
                                                   </div>
                                               </div>
                                               
                                               </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
                                               <div class="roi_bottom_row_left1">
                                               </div>
                                               <div class="roi_bottom_row">
                                               	<div class="roi_bottom_row_matter">
                                                   <font class="roi_row_hd_text">12/10/10</font>
                                               </div>
                                               	<div class="roi_bottom_row_title">
                                                   	<font class="roi_row_hd_text" style="padding-left: 6px">to End</font>
                                                   </div>
                                               	<div class="roi_bottom_row_matter">
                                                  <font class="roi_row_hd_text">13/10/10</font>
                                                   </div>
                                               </div>
                                               
                                               </td>
                                             </tr>
                                             
                                             
                                             
                                             <!-- <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Campaign Start Date :</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   <font class="roi_row_hd_text">12/10/10</font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Campaign End Date :</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   <font class="roi_row_hd_text">13/10/10</font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr> -->
                                       </table>
									</div>
                                       
                                       
                                   	<div class="roi_inside_top2_bottom_middle">
                                       <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                                 <tr>
                                                   <td class="roi_text1">Target Percentage of Competitor</td>
                                                   <td width="16" align="center" valign="middle">
                                                   <img src="../images/bulb.jpg" border="0" onmouseover="javascript:document.getElementById('img_tooltip').style.display='block'" onmouseout="javascript:document.getElementById('img_tooltip').style.display='none'" /></td>
                                                 </tr>
                                                 <tr>
                                                   <td colspan="2" align="left" valign="middle">
                                                   		<font class="roi_table_number_topright" style="margin-top: 20px">95%</font>
                                                   </td>
                                                </tr>
                                       </table>
									</div>
                                   	<div class="roi_inside_top2_bottom_right_web2">
                                       <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The overall score of an individual channel of your within the date range of your benchmark analysis." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Channel Score:</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   <font class="roi_row_matter_number">43</font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr>
											  <tr>
	                                               <td height="22" valign="top">
	                                               	<div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_title">
		                                               		<table width="170">
		                                               			<tr>
		                                               				<td class="roi_bottom_row_left" align="left" valign="top">
		                                               				
		                                               				<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Simply, the average channel score of your competitors." />
					            						</span>
					        						</rich:toolTip>
					   											</h:graphicImage>
		                                               				
		                                               				</td>
		                                               				<td class="roi_row_hd_text" valign="top" align="left">Average Competitor Channel Score:<font class="roi_row_matter_number" style="padding-left: 6px;">61</font></td>
		                                               			</tr>
		                                               		</table>
		                                               	</div>
	                                               </div>
	                                            </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
	                                              	<div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Based on the number that is entered into the 'Target Percentage of Competitor', the channel score that is projected within the time frame and chosen channel metric to be used in the campaign (e.g. If you intend to increase your performance to 50% of the average channel competitor score, your channel score will increase from 32 to 48.)." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Targeted Channel Score:</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_matter_number">53</font>
		                                                </div>
	                                               </div>
                                              </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Adjusted Channel Score." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
					   							
					   							
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Adjusted Channel Score:</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text"><h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3"/></font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
	                                               	<div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The amount you intend to spend on the channel optimization campaign." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Campaign Investment:</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">$<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="12"/></font>
		                                                </div>
	                                               </div>
	                                           </td>
                                             </tr>
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_title">
		                                                   	<table width="180">
		                                                   		<tr>
		                                                   			<td class="roi_bottom_row_left" align="left" valign="top">
		                                                   			<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Total Increase in Channel Performance." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                   			</td>
		                                                   			<td class="roi_row_hd_text" align="left" valign="top">Total Increase in Channel Performance:<font class="roi_row_matter_number" style="padding-left: 6px;">54</font></td>
		                                                   		</tr>
		                                                   	</table>
		                                               </div>
	                                               </div>
                                              </td>
                                             </tr>             
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Actual Sales." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Actual Sales:</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">$<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="12"/></font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr> 
                                             <!-- 
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Projected ROI." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Actual Sales:</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">$<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="12"/></font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr>            
                                              -->
                                             <tr>
                                               <td height="22" valign="top">
	                                               <div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Actual Sales Cycle(Days)." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Actual Sales Cycle(Days):</font>
		                                                </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text"><h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="12"/></font>
		                                                </div>
	                                               </div>
                                               </td>
                                             </tr>            
                                          </table>
                                     </div>
   
                                      <div class="roi_inside_top2_bottom_right1_website">
                                       <table width="290">
                                       		<tr>
                                       			<td valign="top" align="left">
	                                       			<div class="roi_bottom_row">
			                                               	<div class="roi_bottom_row_title">
				                                               	<table width="195">
				                                               		<tr>
				                                               			<td class="roi_bottom_row_left" align="left" valign="top">
				                                               			<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The average time it takes to close a sale for your product." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
				                                               			
				                                               			</td>
				                                               			<td class="roi_row_hd_text" valign="top" align="left">Average Sales Cycle(Trending):</td>
				                                               			<td class="roi_row_matter_number" valign="bottom" align="left" width="70">3 months</td>
				                                               		</tr>
				                                               	</table>
			                                               </div>
													</div>
                                       			</td>
                                       		</tr>
                                       		<tr>
                                       			<td valign="top" align="left">
                                       				<div class="roi_bottom_row">
			                                            <div class="roi_bottom_row_title">
			                                               	<table width="153">
			                                               		<tr>
			                                               			<td class="roi_bottom_row_left">
			                                               			
			                                               			<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The number of sales prospects in your pipeline." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
			                                               			</td>
			                                               			<td class="roi_row_hd_text" valign="top" align="left">No. of Sales in Pipeline(Trending):</td>
			                                               			<td class="roi_row_matter_number" valign="bottom" align="left">12</td>
			                                               		</tr>
			                                               	</table>
                 										</div>
		                                          </div>                                       			
                                       			</td>
                                       		</tr>
                                        	<tr>
                                       			<td valign="top" align="left">
	                                       			<div class="roi_bottom_row">
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Projected ROI." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Projected ROI:</font>
		                                                 </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">$</font><font class="roi_row_matter_number">4,000,000</font>
		                                                </div>
	                                         		</div>                                       			
                                       			</td>
                                       		</tr>                                      		
                                       		<tr>
                                       			<td valign="top" align="left">
	                                       			<div>
		                                       			<div class="roi_web3">
								                           <table height="100%" width="100%">
																<tr>
																	<td align="left" valign="middle" class="roi_text_roi">Actual % Channel ROI</td>
																</tr>
																<tr>
																	<td align="left" valign="middle" class="roi_table_number_topright">11%</td>
																</tr>
															</table>
								                       </div> 
		                                       			<div class="roi_web2">
								                           <table height="100%" width="100%">
																<tr>
																	<td align="left" valign="middle" class="roi_text_roi">Potential Channel ROI</td>
																</tr>
																<tr>
																	<td align="left" valign="middle" class="roi_table_number_topright">$5,000</td>
																</tr>
															</table>
								                       </div> 
	                                       			</div>                                      			
                                       			</td>
                                       		</tr>
                                       		<tr>
                                       			<td>
                                       				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                           				<tr>
                                           					<td align="left">
					                                             <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:30px">
					                                                 <tr>
					                                                   <td width="85" align="left" valign="middle">
					                                                   <a href="#" onclick="openPopup('Save Campaign',324, 90, 582, 272, 10, false, true, false, '')">
					                                                   <img src="../images/roi/roi_save.gif" border="0"   onmouseover="this.src='../images/roi/roi_saveRollovers.gif'" onmouseout="this.src='../images/roi/roi_save.gif'"/>
					                                                   </a>
					                                                   </td>
					                                                   <td class="save_text" width="20" align="center" valign="bottom">or</td>
					                                                   <td class="save_text1" valign="bottom" align="left">RESET</td>
					                                                 </tr>
					                                             </table>

		                                            		</td>
                                           				</tr>
                                      		 		</table>
                                       			</td>
                                       	   </tr>
                                       </table>
                                  	</div> 
								</div>
                       		</div>
                           	<div class="roi_inside_top3">
                            </div>
 							<div class="website_roi_inside_middle">
								<p class="roi_text">Select the metrics you'd like to include
								in your campaign and/or adjust the targeted scores and click
								"Save" to create or modify a campaign or "Reset" to revert to
								the suggested targeted score. (Metrics are ranked highest
								according to largest impact it will have on your overall
								performance.)</p>
							</div>
							<div class="website_roi_inside_bottom_lower">
							
							<table width="900" border="0" cellspacing="0" cellpadding="0">
                               <tr bgcolor="#F2F2F2">
                                 <td class="roi_table_hd" align="center" valign="middle" width="50">Select</td>
                                 <td class="roi_table_hd" align="center" valign="middle" width="80">Category</td>
                                 <td class="roi_table_hd" align="center" valign="middle" width="80">Weight</td>
                                 <td class="roi_table_hd" align="center" valign="middle" width="80">Benchmark Score</td>
                                 <td class="roi_table_hd" align="center" valign="middle" width="130">Average<br/> Competitor Score</td>
                                 <td class="roi_table_hd" align="center" valign="middle" width="130">Campaign<br/> Targeted Score</td>
                                 
                                 <td class="roi_table_hd" align="center" valign="middle" width="100">% Campaign <br/>Contribution</td>
                                 <td class="roi_table_hd" align="center" valign="middle" width="100">$Campaign <br/>Contribution</td>
                               	<td class="roi_table_hd" align="center" valign="middle" width="230"></td>
                               </tr>
                               <tr>
                               <td colspan="9" height="7px"></td>
                               </tr>
                               
                               <a4j:repeat value="#{overallROIController.roiHeaderList }" var="dto" rowKeyVar="iRow">
                               
		                               <tr>
		                                 <td align="center" valign="middle" bgcolor="#F8F8F8" style="border-top:1px solid #E5E5E5;">
		                                 <!-- 
		                                 	<input type="image" src="../images/roi/selectGreenRight.gif" border="0"/>
		                                  -->
		                                 <input type="checkbox" id="chkOne" name="chk" value="aaaa" checked="checked" onclick="SingleSelect('chk',this);" class="styled"/>
		                                 </td>
		                                 <td valign="middle" bgcolor="#fbfbfb" align="left" style="border-top: 1px solid rgb(229, 229, 229);">
										        <table width="100%" cellspacing="0" cellpadding="0" border="0">
										            <tr>
										                <td valign="middle" align="left" class="roi_table_text">
										                 <div class="roi_table_text1">
										                        
										                        <font class="roi_row_hd_text_new">Performance Category Metric #1</font>
										                 </div>
										                 </td>
										                 <td valign="middle" align="left">
										                    <img border="0" src="../images/roi/roi_bulb.gif"/>
										                 </td>
										             </tr>
										       </table>
										</td>
										<td align="center" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5">
		                                 	<div class="roi_table_number1_2">42%
											<h:graphicImage value="../images/roi/weights.gif" 
                  									onmouseover="this.src='../images/roi/weights_roll.gif';" onmouseout="this.src='../images/roi/weights.gif';" style="margin-left: 5px;">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide=""  style="text-align: justify;">
					            						<span>
					            								<h:outputText value="The associated weight given to a metric or channel relative to its ability to generate conversion activity. It is derived from performance data gathered over time tracked by you and your competitive set." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
                                 		
                                 	
											</div>
		                                 </td>
		                                 
		                                 <td align="center" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5">
		                                 <div class="roi_table_number1">60</div></td>
		                                 <td align="center" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5">
		                                 <div class="roi_table_number2">69</div>
		                                 </td>
		                                 <td align="center" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5">
		                                 <div class="roi_table_number3">4</div>
		                                 </td>
		                                 
		          						<td align="left" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5">
		                                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                                                   <tr>
		                                                     <td align="center" valign="middle"> 
		                                                         <div class="roi_table_selection">
		                                                           <input type="text" name="camp_score" class="roi_textbox"/>
		                                                         </div>
		                                                     </td>
		                                                   </tr>
		                                     </table>
		                                 </td> 
		          						<td align="left" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5">
		                                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                                                   <tr>
		                                                     <td align="center" valign="middle"> 
		                                                         <div class="roi_table_selection">
		                                                           <input type="text" name="camp_score" class="roi_textbox"/>
		                                                         </div>
		                                                     </td>
		                                                   </tr>
		                                     </table>
		                                 </td> 
		                                <td align="left" valign="middle"  bgcolor="#FBFBFB" style="border-top:1px solid #E5E5E5"></td>                    
		                               </tr>
                               </a4j:repeat>
                              
                               <tr>
                               <td colspan="9" height="20px"></td>
                               </tr>
                          </table>
						</div>
                     </div>
				</div>
			</td>
		</tr>
	</table>
</div>
				
				<!-- #####################################POPUP############################################# -->

	
				
				<!-- ################################################################################### -->
				<!-- *************Body Right Pannel TOP End ***************-->
		</td></tr>
		<tr><td>
		
		<!-- *************Body right Pannel BOTTOM Start ***************-->
		<div class="right_pannel_bottom" id="body_bottom_open">
		<div class="wt_open">
		<table width="85%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>

				<p class="matter_home">WHAT'S THIS?<font> <a
					href="javascript:closeMe('body_bottom_open','body_bottom_close')"
					class="close">CLOSE</a></font></p>
				<p class="matter_index">
				ROI Optimization provides a visualization of your benchmark channel performance and suggested target performance relative to the optional performance of 
				your competitors and relative weight or importance of the channel to the product, brand and industry as a whole.
				</p>
			</td>
			</tr>
		</table>
		</div>
		</div>
		<div style="background-color: #ffffff;">
		<div class="right_pannel_bottom" id="body_bottom_close"
			style="visibility: hidden;">
		<div class="wt_close">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>

				<p class="matter_home">WHAT'S THIS?<font> <a
					href="javascript:closeMe('body_bottom_close','body_bottom_open')"
					class="close"> OPEN</a></font></p>

				</td>
			</tr>
		</table>
		</div>
		</div>
		</div>
		<!-- *************Body Right Pannel BOTTOM End ***************-->
		</td></tr></table>
		
		</h:form>
	</ui:define>
</ui:composition>
