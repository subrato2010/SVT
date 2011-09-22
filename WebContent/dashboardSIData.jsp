<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>
	<input type="hidden" id="sortOrder" value="A" />
	<tr>
		<td valign="top" align="left">
			<div class="bodyTopSecondChannelPerf">  
				<table width="#{tablewidth}" border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #D4D4D4;">
					<tr  height="25">
						<td width="24" align="center" valign="middle">
						 	<a id="displayTextData" href="#{jvmethod}"><img src="../images/grayDropDown.gif" border="0" /></a>
						</td>
						<td align="left" valign="middle" width="600">
							
									<table cellpadding="0" cellspacing="0">
                                         	<tr>
                                         		<td valign="middle" align="left" class="topFirstTablehdCategory">
                                         		#{siname}
                                         		</td>
                                         		<td valign="middle" align="left">
                                         		<h:graphicImage value="../images/bulb.gif" 
												      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
												<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
												    <span><h:outputText value="#{tooltip}" /></span>
												</rich:toolTip>
												</h:graphicImage>
                                         		</td>
                                         	</tr>
                                    </table>
									
						</td>
						<td align="center" valign="middle" width="158"></td>
						<td align="center" valign="middle" width="170"></td>
					</tr>
				</table>          
				<div id="#{toggleId}" style="display: none">         
					<table  width="1050" border="0" cellpadding="0" cellspacing="0">
						<tr height="40">
							<td width="24" class="topFirstTablehdCategory" valign="middle" align="center"></td>
							<td width="170" class="topFirstTablehdCategory" valign="middle" align="center"></td>
							<td width="120" valign="middle" align="center">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" align="center"  class="topFirstTablehdCategory">
		                 				<h:commandLink id="yv#{si}" value="Your Average Daily Volume (Current)" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="#{si}" />
											<f:param name="col" value="yv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
									</td>
									<td valign="top" align="left">
									<h:graphicImage value="../images/bulb.gif" 
									 onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
									<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									<span><h:outputText value="We calculate the Average Daily Volume by taking an average of your volumes for the previous 14 days." /></span>
									</rich:toolTip>
									</h:graphicImage>
								</td>
								</tr>
							</table>
								
								
							</td>
							<td width="225" valign="middle" align="center">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" align="center"  class="topFirstTablehdCategory">
		                 				<h:commandLink id="cv#{si}" value="Competitors' Average Daily Volume (Current)" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="#{si}" />
											<f:param name="col" value="cv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
									</td>
									<td valign="top" align="left">
									<h:graphicImage value="../images/bulb.gif" 
									      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
									<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									         <span><h:outputText value="We calculate the Average Daily Volume by taking an average of your competitors' volumes for the previous 14 days." /></span>
									</rich:toolTip>
									</h:graphicImage> 
									</td>
								</tr>
							</table>
							</td>
							<td width="225" valign="middle" align="center">
	                 		<table cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="top" align="center" class="topFirstTablehdCategory">
	                 					<h:commandLink id="yb#{si}" value="Your Average Daily Volume (Benchmark)" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="#{si}" />
											<f:param name="col" value="yb" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
	                 				</td>
	                 				<td valign="top" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
							     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
							         <span><h:outputText value="Your baseline average daily volume or the date your campaign started." /></span>
							     </rich:toolTip>
							</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		</td>
							<td width="110" valign="middle" align="center">
								<table cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" align="center"  class="topFirstTablehdCategory">
		                 				<h:commandLink id="yt#{si}" value="Campaign Progress" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="#{si}" />
											<f:param name="col" value="yt" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
									</td>
									<td valign="top" align="left">
										<h:graphicImage value="../images/bulb.gif" 
										      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
										<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         <span><h:outputText value="A measure of how far you are from your goal." /></span>
										</rich:toolTip>
										</h:graphicImage>
									</td>
								</tr>
								</table>
								
								
								
							</td>
							<!--
							<td width="95" class="topFirstTablehdCategory" valign="middle" align="center">
								<table cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" align="center"  class="topFirstTablehdCategory">
		                 				<h:commandLink id="pi#{si}" value="% Increase" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="#{si}" />
											<f:param name="col" value="pi" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
									</td>
									<td valign="top" align="left">
									<h:graphicImage value="../images/bulb.gif" 
								      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="The percentage you've increased your performance relative to your goal." /></span>
								</rich:toolTip>
								</h:graphicImage></td>
								</tr>
								</table>
							</td>
							-->
							<td width="150" class="topFirstTablehdCategory" valign="middle" align="center"></td>
							<td width="170" class="topFirstTablehdCategory" valign="middle" align="center"></td>
							<td width="100" class="topFirstTablehdCategory" valign="middle" align="center"></td>
						</tr>
						<a4j:repeat value="#{data}" var="row" rowKeyVar="i">
						<tr  bgcolor="#{(i%2==0)?('ededed'):('white')}">
							<td width="24" class="topFirstTablehdCategory" valign="middle" align="center"></td>
							<td width="170" class="topFirstTablehdCategory" valign="middle" align="left">
								<table border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
									<tr>
										<td>
											<div class="OM">
											#{row.metricsName}
											</div>
										</td>
										<td>
											<h:graphicImage value="../images/bulb.gif" 
											onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
											<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
											    <span><h:outputText value="#{row.metricsDesc}" /></span>
											</rich:toolTip>
											</h:graphicImage>
										</td>
									</tr>
								</table>
							</td>
							
							<td width="120" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
								<table cellspacing="0" cellpadding="0" border="0" width="120">
									<tr>
										<td class="topFirstTablehdCategoryDataLast" align="center" valign="middle">										
											<a4j:outputPanel rendered="#{row.dataProcessed}">#{row.custVolumeRoundUp}</a4j:outputPanel>
											<a4j:outputPanel rendered="#{!(row.dataProcessed)}"><img src="../images/gears.gif" border="0"/></a4j:outputPanel>
										</td>
										<td  align="left" valign="middle" width="30">
											<a4j:outputPanel rendered="#{(row.custVolumeTrend == 1)}">
												<h:graphicImage value="../images/uparrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Up: Volume over the last 14 days has been trending up overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
											</a4j:outputPanel>
											<a4j:outputPanel rendered="#{(row.custVolumeTrend == -1)}">
												<h:graphicImage value="../images/downarrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Down: Volume over the last 14 days has been trending down overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
											</a4j:outputPanel>
										</td>
									</tr>
								</table>
							</td>
							<td width="195" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
								<table cellspacing="0" cellpadding="0" border="0" width="120">
								<tr>
									<td class="topFirstTablehdCategoryDataLast" align="center" valign="middle">
									<a4j:outputPanel rendered="#{row.dataProcessedCmpt}">#{row.cmptVolumeRoundUp}</a4j:outputPanel>
									<a4j:outputPanel rendered="#{!(row.dataProcessedCmpt)}">NA</a4j:outputPanel>									
									</td>
									<td  align="left" valign="middle" width="30">
										<a4j:outputPanel rendered="#{(row.cmptVolumeTrend == 1)}">
											<h:graphicImage value="../images/uparrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Up: Volume over the last 14 days has been trending up overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
										</a4j:outputPanel>
										<a4j:outputPanel rendered="#{(row.cmptVolumeTrend == -1)}">
											<h:graphicImage value="../images/downarrow.gif" style="border: 0">
												<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									         		<span>
									         			<h:outputText value="Trending Down: Volume over the last 14 days has been trending down overall." />
									         		</span>
									     		</rich:toolTip>
											</h:graphicImage>
										</a4j:outputPanel>
									</td>
								</tr>
								</table>
							</td>
							<td width="120" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
							<a4j:outputPanel rendered="#{row.dataProcessed}">#{row.calculatedYourVolumeRoundUp}</a4j:outputPanel>
							<a4j:outputPanel rendered="#{!(row.dataProcessed)}">NA</a4j:outputPanel>
                 			</td>
							<td width="100" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">							
							<a4j:outputPanel rendered="#{row.dataProcessed}">#{row.currentTargetRawString}</a4j:outputPanel>
							<a4j:outputPanel rendered="#{!(row.dataProcessed)}">NA</a4j:outputPanel>
							</td>
                 		    <!--
                 		    <td width="80" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
                 		    <a4j:outputPanel rendered="#{row.dataProcessed}">#{row.percentIncreaseRawScale100}%</a4j:outputPanel>
							<a4j:outputPanel rendered="#{!(row.dataProcessed)}">NA</a4j:outputPanel>
                 		    </td>
							-->
							<td width="150" class="topFirstTablehdCategoryDataLast" valign="middle" align="center"></td>
							<td width="170" class="topFirstTablehdCategoryDataLast1" valign="middle" align="left"></td>
							<td width="100" class="topFirstTablehdCategoryDataLast" valign="middle" align="center"></td>
						</tr>
						</a4j:repeat>
					</table>
					<div style="border:1px solid #D4D4D4; margin-top:10px;"></div>      
				</div>         
			</div>
		</td>
	</tr>
</ui:composition>