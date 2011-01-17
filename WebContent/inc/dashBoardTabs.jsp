<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	
	<h:form>
		
	
	<table  border="0" cellpadding="0" cellspacing="0" width="1015">
			<tr>
			
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'dashboard' }">
						<img src="../images/channel/selected/dashboardSelect.jpg" border="0" />
					</a4j:outputPanel>
					
					<a4j:outputPanel rendered="#{!(currentTab eq 'dashboard')}">
						<h:outputLink  value="dashBoard.jsp">
							<img src="../images/channel/general/dashboard.gif" border="0"  name="pic1" id="pic1"  onmouseover="document.getElementById('pic1').src='../images/channel/rollover/dashboardRollover.gif'" onmouseout="document.getElementById('pic1').src='../images/channel/general/dashboard.gif'" />
						</h:outputLink>
					</a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'analysis' }">
						<img src="../images/channel/selected/analysisSelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'analysis')}">
					    <h:outputLink  value="executiveSummary.jsp" >
							<img src="../images/channel/general/analysis.gif" border="0"  name="pic2"  id="pic2" onmouseover="document.getElementById('pic2').src='../images/channel/rollover/analysisRollover.gif'" onmouseout="document.getElementById('pic2').src='../images/channel/general/analysis.gif'" />
						</h:outputLink>
					</a4j:outputPanel>
				</td>   
				<td width="5px"></td>
				<td align="center" valign="middle" width="153">
					<a4j:outputPanel rendered="#{currentTab eq 'outbound' }">
						<img src="../images/channel/selected/outboundmetricsSelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'outbound')}">
						<h:outputLink  value="outBound.jsp" >
						<img src="../images/channel/general/outboundmatrics.gif" border="0"  name="pic3" id="pic3"  onmouseover="document.getElementById('pic3').src='../images/channel/rollover/outboundmatricsRollover.gif'" onmouseout="document.getElementById('pic3').src='../images/channel/general/outboundmatrics.gif'" />
						</h:outputLink>
					</a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="153">
					<a4j:outputPanel rendered="#{currentTab eq 'inbound' }">
						<img src="../images/channel/selected/inboundmetricsSelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'inbound') }">
						<h:outputLink value="svtHome.jsp" >
							<img src="../images/channel/general/inboundmatrics.gif" border="0"  name="pic4" id="pic4"  onmouseover="document.getElementById('pic4').src='../images/channel/rollover/inboundmatricsRollover.gif'" onmouseout="document.getElementById('pic4').src='../images/channel/general/inboundmatrics.gif'" />
						</h:outputLink>
					</a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="153">
					<a4j:outputPanel rendered="#{currentTab eq 'roi' }">
						<img src="../images/channel/selected/roiSelected.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'roi') }">
						<h:outputLink value="channelOptimizationROI.jsp" >
							<img src="../images/channel/general/roioptimization.gif" border="0"  name="pic5" id="pic5"  onmouseover="document.getElementById('pic5').src='../images/channel/rollover/roioptimizationRollovers.gif'" onmouseout="document.getElementById('pic5').src='../images/channel/general/roioptimization.gif'" />
						</h:outputLink>
					</a4j:outputPanel>
				
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="105">
				<img src="../images/channel/inactive/trendingInactive.jpg" border="0"/>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="105">
				<img src="../images/channel/inactive/monitorInactive.jpg" border="0"/>
				
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle"  width="105">
				<img src="../images/channel/inactive/manageInactive.jpg" border="0"/>
				</td>
			</tr>
		</table>
	
	</h:form>
	
	
	
	
	
</ui:composition>