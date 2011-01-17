
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
			<ui:param name="menu" value="#{channelROIController}"/>
		</ui:include>
	</ui:define>
	<ui:define name="tabs">
		<ui:include src="/inc/dashBoardTabs.jsp">
			<ui:param name="currentTab" value="roi"/>
		</ui:include>
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
                                   			<td class="roi_hd">#{overallROIController.currentMenu.currentChannelDTO.channelName} Optimization</td>
                                   			
                                   			
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
												<a  href="overallROI.jsp?channelName=Overall Score">
													<div class="mainDiv_green1">
													<div class="captionDiv" style="color:#ffffff;">Select overall</div> 
													</div>
												</a> 
													
													

										</td>
                                   		</tr>
                                   	
                                   	</table>
                                   	

                                   </div>
                               	<div class="roi_inside_top2_border">
                                   </div>
                               	<div class="roi_inside_top2_matter">
                                   
                                  <font class="roi_text"> The following is an interactive table that lists the outbound channel metrics that are sorted by highest weight (or importance) and lowest score relative to the competitor average. You can select or de-select the metric category you'd like to include in your campaign and adjust the suggested target scores if you would like increase or decrease your targeted score for the campaign and click "Save". To reset to the suggested target, click "Reset" below. </font>
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
                                                   	<font class="roi_row_hd_text">
                                                   	<h:inputText 
                                                   	value="#{overallROIController.roiCampaignDTO.campaignName}" 
                                                   	size="8" disabled="true"/></font>
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
                                                   
                                                   	<rich:calendar id="benchmrkStDate" 
                                                   	value="#{overallROIController.roiCampaignDTO.roiOverallHeaderDto.benchmarkStDate}" 
                                                   	inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy" disabled="true"/>
                                                   	
                                               </div>
                                               	<div class="roi_bottom_row_title">
                                                   	<font class="roi_row_hd_text" style="padding-left:2px">to End</font>
                                                   </div>
                                               	<div class="roi_bottom_row_matter">
                                                   
                                                   	<rich:calendar id="benchmrkEdDate" 
                                                   	value="#{overallROIController.roiCampaignDTO.roiOverallHeaderDto.benchmarkEdDate}" 
                                                   	inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy" disabled="true"/>
                                                   	
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
                                                   
                                                   	<rich:calendar id="cpgnStDate" 
                                                   	value="#{overallROIController.roiCampaignDTO.campaignStDate}" 
                                                   	inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy" disabled="true"/>
                                                   	
                                               </div>
                                               	<div class="roi_bottom_row_title">
                                                   	<font class="roi_row_hd_text" style="padding-left:2px">to End</font>
                                                   </div>
                                               	<div class="roi_bottom_row_matter">
                                                   
                                                   	<rich:calendar id="cpgnEndDate" 
                                                   	value="#{overallROIController.roiCampaignDTO.campaignEdDate}" 
                                                   	inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy" disabled="true"/>
                                                   	
                                                   </div>
                                               </div>
                                               
                                               </td>
                                             </tr>
                                             
                                       </table>

                                       
                                       </div>
                                       
                                       
                                   	<div class="roi_inside_top2_bottom_middle">
                                       
                                       <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                                 <tr>
                                                   <td class="roi_text1">Target Percentage of Competitor</td>
                                                   <td width="16" align="center" valign="middle">
                                                   <img src="../images/bulb.jpg" border="0" onmouseover="javascript:document.getElementById('img_tooltip').style.display='block'" onmouseout="javascript:document.getElementById('img_tooltip').style.display='none'"/></td>
                                                 </tr>
                                                 <tr>
                                                   <td colspan="2" align="center" valign="middle">
                                                   
                                                   <h:inputText value="#{overallROIController.headerDTO.defaultTargetCompPct}" 
                                                   id="competitor" styleClass="roi_textbox1" disabled="true"
                                                   style="font-size: 26px; color: #666A70;" /><font class="roi_hd1">%</font>
                                                   
                                                   </td>
                                                 </tr>
                                       </table>
                                       </div>
                                   	<div class="roi_inside_top2_bottom_right_web1">
                                       
                                       
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
                                                   <font class="roi_row_hd_text">
                                                   <h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/></font>
                                                   </div>
                                               </div>
                                               
                                               </td>
                                             </tr>

                                             <tr>
                                               <td height="22" valign="top">
                                               
                                               <div class="roi_bottom_row">
                                               
                                               <table width="185">
                                               	<tr>
                                               		<td align="left" valign="top">
	                                               		<div class="roi_bottom_row_left">
	                                               		<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="Simply, the average channel score of your competitors." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
	                                                 	</div>
                                                 	</td>
                                               		<td align="left" valign="top" class="roi_row_hd_text">
                                               		Average Competitor Channel Score:<font class="roi_row_hd_text" style="padding-left: 5px;">
                                               		<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/></font>
                                               		</td>
                                               		
                                               	</tr>
                                               </table>
                                              
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
                                                   	<font class="roi_row_hd_text">
                                                   	<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/></font>
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
					            								<h:outputText value="Adjusted Channel Score" />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
                                                   </div>
                                               	<div class="roi_bottom_row_title">
                                                   	<font class="roi_row_hd_text">Adjusted Channel Score:</font>
                                                   </div>
                                               	<div class="roi_bottom_row_matter">
                                                   	<font class="roi_row_hd_text">
                                                   	<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/></font>
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
                                                   	<font class="roi_row_hd_text">Campaign Investment:<font class="roi_row_hd_text" style="padding-left: 4px;">
                                                   	<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="12" disabled="true"/></font></font>
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
		                                               	<div class="roi_bottom_row_left">
		                                               	<h:graphicImage value="../images/bulb.jpg" 
                  									onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';"  style="margin-left:5px">
					        						<rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" 
					         							onshow="" onhide="" >
					            						<span>
					            								<h:outputText value="The average sale amount for your product." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Average Sales Price:</font>
		                                                   </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">$<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="8" disabled="true"/></font>
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
					            								<h:outputText value="The average time it takes to close a sale for your product." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Average Sales Cycle:</font>
		                                                   </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">
		                                                   	<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/></font>
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
					            								<h:outputText value="The number of sales prospects in your pipeline." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">No. of Sales in Pipeline:</font>
		                                                   </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text"><h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/></font>
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
					            								<h:outputText value="The current rate of conversion of prospects to actual sales." />
					            						</span>
					        						</rich:toolTip>
					   							</h:graphicImage>
		                                                </div>
		                                               	<div class="roi_bottom_row_title">
		                                                   	<font class="roi_row_hd_text">Sales Conversion Rate:</font>
		                                                   </div>
		                                               	<div class="roi_bottom_row_matter">
		                                                   	<font class="roi_row_hd_text">
		                                                   	<h:inputText value="#{overallROIController.roiCampaignDTO.campaignName}" size="3" disabled="true"/>%</font>
		                                                   </div>
                                         		</div>                                       			
                                       			</td>
                                       		</tr>                                           		
                                       		<tr>
                                       			<td valign="top" align="left">
		                                       			<div>
			                                       			<div class="roi_web1">
									                             <table height="100%" width="100%">
																	<tr>
																		<td align="left" valign="middle" class="roi_text_roi_web">Potential % Channel ROI</td>
																	<td align="left" valign="middle" class="roi_table_number_topright_web">56%</td>
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
							
							
							
							<div class="website_roi_inside_bottom_lower" style="width:907px;height:100%;overflow:auto;">
							<table border="0" cellspacing="0" cellpadding="0" height="100%" >
								<tr bgcolor="#F2F2F2">
									<td class="roi_table_hd" align="center" valign="middle"
										width="80">Select</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="80">Category</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="70">Weight</td>
									<td>
									<table cellspacing="0" cellpadding="0">
										<tr bgcolor="#F2F2F2">
											<td><h:graphicImage value="../images/favicon.ico"
												onmouseover="this.src='../images/favicon.ico';"
												onmouseout="this.src='../images/favicon.ico';"
												style="margin-left: 5px;">
												<rich:toolTip styleClass="tooltip" showEvent="onmouseover"
													direction="bottom-right" mode="client" layout="block"
													onshow="" onhide="" style="text-align: justify;">
													<span> <h:outputText
														value="The associated weight given to a metric or channel relative to its ability to generate conversion activity. It is derived from performance data gathered over time tracked by you and your competitive set." />
													</span>
												</rich:toolTip>
											</h:graphicImage></td>
											<td class="roi_table_hd" align="center" valign="middle"
												width="30">Terametric<br />
											Efficiency</td>
										</tr>
									</table>
									</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="100">Benchmark<br />
									Score</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="130">Average<br />
									Competitor Score</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="120">Campaign<br />
									Targeted Score</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="120">Campaign <br />
									Adjusted Score</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="100">% Campaign <br />
									Contribution</td>
									<td class="roi_table_hd" align="center" valign="middle"
										width="100">$Campaign <br />
									Contribution</td>

								</tr>
								<tr>
									<td colspan="9" height="7px"></td>
								</tr>

								<a4j:repeat value="#{channelROIController.categoryDtoList }"
									var="dto" rowKeyVar="iRow">

									<tr>
										<td align="center" valign="middle" bgcolor="#F8F8F8"
											style="border-top: 1px solid #E5E5E5;"><!-- <input type="image" src="../images/roi/selectGreenRight.gif" border="0"/> -->
										<input type="checkbox" id="chkOne" name="chk" value="aaaa"
											checked="checked" onclick="SingleSelect('chk',this);"
											class="styled" /></td>
										<td valign="middle" bgcolor="#fbfbfb" align="left"
											style="border-top: 1px solid rgb(229, 229, 229);">
										<table width="100%" cellspacing="0" cellpadding="0" border="0">
											<tr>
												<td valign="middle" align="left" class="roi_table_text">
												<div class="roi_table_text1"><font
													class="roi_row_hd_text_new">#{dto.categoryDto.categoryName}</font>
												</div>
												</td>
												<td valign="middle" align="left"><h:graphicImage
													value="../images/bulb.jpg"
													rendered="#{dto.categoryDto.categoryDesc != null}"
													onmouseover="this.src='../images/bulb_green.jpg';"
													onmouseout="this.src='../images/bulb.jpg';"
													style="margin-left:5px">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover"
														direction="bottom-right" mode="client" layout="block"
														rendered="#{dto.categoryDto.categoryDesc != null}"
														onshow="" onhide="">
														<span> <h:outputText
															value="#{dto.categoryDto.categoryDesc}" /> </span>
													</rich:toolTip>
												</h:graphicImage></td>
											</tr>
										</table>
										</td>
										<td align="center" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5" width="160">
										<table width="100%">
											<tr>
												<td valign="top" align="right">
												<div class="roi_table_number1_2">#{dto.outboundWeightPct
												}%</div>
												</td>
												<td valign="top" align="left"><h:graphicImage
													value="../images/roi/weights.gif"
													onmouseover="this.src='../images/roi/weights_roll.gif';"
													onmouseout="this.src='../images/roi/weights.gif';"
													style="margin-left: 5px;">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover"
														direction="bottom-right" mode="client" layout="block"
														onshow="" onhide="" style="text-align: justify;">
														<span> <h:outputText
															value="The associated weight given to a metric or channel relative to its ability to generate conversion activity. It is derived from performance data gathered over time tracked by you and your competitive set." />
														</span>
													</rich:toolTip>
												</h:graphicImage></td>
											</tr>
										</table>

										</td>
										<!-- Added By Neel Started Here -->
										<td align="center" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5" width="10">
										<table align="left">
											<tr>
												<td valign="top" align="right">
												<div class="roi_table_number1_2">#{dto.rawEfficiency}</div>
												</td>
												<td valign="top" align="left"><rich:toolTip
													styleClass="tooltip" showEvent="onmouseover"
													direction="bottom-right" mode="client" layout="block"
													onshow="" onhide="" style="text-align: justify;">

												</rich:toolTip></td>
											</tr>
										</table>

										</td>
										<!-- Added By Neel Ended Here -->
										<td align="center" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5">
										<div class="roi_table_number1">#{dto.clientScore}</div>
										</td>
										<td align="center" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5">
										<div class="roi_table_number2">#{dto.compAvg }</div>
										</td>
										<td align="center" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5">
										<div class="roi_table_number3">4?</div>
										</td>
										<td align="left" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="center" valign="middle">
												<div class="roi_table_selection"><input type="text"
													name="camp_score" class="roi_textbox"
													value="#{dto.clientAdjustedScore}" /></div>
												<!-- Added By Neel --></td>
											</tr>
										</table>
										</td>
										<td align="left" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="center" valign="middle">
												<div class="roi_table_selection"><input type="text"
													name="camp_score" class="roi_textbox"
													value="#{dto.campaignContriPct}" /></div>
												</td>
											</tr>
										</table>
										</td>
										<td align="left" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="center" valign="middle">
												<div class="roi_table_selection"><input type="text"
													name="camp_score" class="roi_textbox"
													value="#{dto.campaignContriDollar}" /></div>
												</td>
											</tr>
										</table>
										</td>
										<td align="left" valign="middle" bgcolor="#FBFBFB"
											style="border-top: 1px solid #E5E5E5"></td>
									</tr>


								</a4j:repeat>



								<tr>
									<td colspan="9" height="70" valign="middle">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="85" align="left" valign="middle"><h:commandLink
												action="toBeGiven">
												<img src="../images/roi/roi_save.gif" border="0"
													onmouseover="this.src='../images/roi/roi_saveRollovers.gif'"
													onmouseout="this.src='../images/roi/roi_save.gif'" />
											</h:commandLink></td>
											<td class="save_text" width="20" align="center"
												valign="bottom">or</td>
											<td class="save_text1" valign="bottom" align="left"><h:commandLink
												action="toBeGiven" value="RESET" style="color: #79BF41" />
											</td>
										</tr>
									</table>


									</td>
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
				Your human and capital investment is factored into the outbound channel improvements that you're making. The return on that investment is calculated after the campaign has ended and the results of the inbound channel performance is calculated against the benchmark.
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
