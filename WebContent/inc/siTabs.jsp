<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>
	
	<h:form id="si">
		<table  border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'overallsi' }">
						<img src="../images/overallsocialintelligence/selected/OverallsocialintelligenceSelect.jpg" border="0" />	
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'overallsi')}">
					   <h:outputLink value="overallSI.jsp">
					      <img src="../images/overallsocialintelligence/general/overall.gif" border="0"  name="pic1"  id="pic1" onmouseover="document.getElementById('pic1').src='../images/overallsocialintelligence/rollover/overallRollover.gif'" onmouseout="document.getElementById('pic1').src='../images/overallsocialintelligence/general/overall.gif'" />
					   </h:outputLink>
				   </a4j:outputPanel>
				</td>
				<td width="5px"></td> 
				<td align="center" valign="middle" width="108">
					<a4j:outputPanel rendered="#{currentTab eq 'Sentiment' }">
					<img src="../images/overallsocialintelligence/selected/sentimentSelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'Sentiment')}">
						 <h:outputLink value="sentiment.jsp">
				   			<img src="../images/overallsocialintelligence/general/sentiment.gif" border="0"  name="pic2" id="pic2"  onmouseover="document.getElementById('pic2').src='../images/overallsocialintelligence/rollover/sentimentRollover.gif'" onmouseout="document.getElementById('pic2').src='../images/overallsocialintelligence/general/sentiment.gif'" />
				   		</h:outputLink>	
					</a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="102">
				<a4j:outputPanel rendered="#{currentTab eq 'Influence' }">
					<img src="../images/overallsocialintelligence/selected/influenceSelect.jpg" border="0" />
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{!(currentTab eq 'Influence') }">
				   <h:outputLink value="influence.jsp">
				      <img src="../images/overallsocialintelligence/general/influence.gif" border="0"  name="pic3"  id="pic3" onmouseover="document.getElementById('pic3').src='../images/overallsocialintelligence/rollover/influenceRollover.gif'" onmouseout="document.getElementById('pic3').src='../images/overallsocialintelligence/general/influence.gif'" />
				   </h:outputLink>
				 </a4j:outputPanel>
				</td> 
				<td width="5px"></td>
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'Reach' }">
						<img src="../images/overallsocialintelligence/selected/reachSelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'Reach')}">
					   <h:outputLink  value="reach.jsp">
							<img src="../images/overallsocialintelligence/general/reach.gif" border="0"  name="pic4"  id="pic4" onmouseover="document.getElementById('pic4').src='../images/overallsocialintelligence/rollover/reachRollover.gif'" onmouseout="document.getElementById('pic4').src='../images/overallsocialintelligence/general/reach.gif'" />
					   </h:outputLink>	
					 </a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'Engagement' }">
						<img src="../images/overallsocialintelligence/selected/engagementSelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'Engagement')}">
					   <h:outputLink  value="engagement.jsp">
							<img src="../images/overallsocialintelligence/general/engagement.gif" border="0"  name="pic5" id="pic5"  onmouseover="document.getElementById('pic5').src='../images/overallsocialintelligence/rollover/engagementRollover.gif'" onmouseout="document.getElementById('pic5').src='../images/overallsocialintelligence/general/engagement.gif'" />
					   </h:outputLink>
					 </a4j:outputPanel>
				</td>				
				<td width="5px"></td>
				<td align="center" valign="middle">		
					<a4j:outputPanel rendered="#{currentTab eq 'Loyalty' }">
						<img src="../images/overallsocialintelligence/selected/loyaltySelect.jpg" border="0" />
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'Loyalty')}">
					   <h:outputLink  value="loyalty.jsp" width="102">
							<img src="../images/overallsocialintelligence/general/loyality.gif" border="0"  name="pic6" id="pic6"  onmouseover="document.getElementById('pic6').src='../images/overallsocialintelligence/rollover/loyaltyRollover.gif'" onmouseout="document.getElementById('pic6').src='../images/overallsocialintelligence/general/loyality.gif'" />
					   </h:outputLink>
				   </a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle">		
					<a4j:outputPanel rendered="#{currentTab eq 'Retention'}">
				   		<img src="../images/overallsocialintelligence/selected/retentionSelect.jpg" border="0" />
				   	</a4j:outputPanel>
				   	<a4j:outputPanel rendered="#{!(currentTab eq 'Retention')}">
					   	<h:outputLink  value="retention.jsp" width="102">
							<img src="../images/overallsocialintelligence/general/retention.gif" border="0"  name="pic7" id="pic7"  onmouseover="document.getElementById('pic7').src='../images/overallsocialintelligence/rollover/retentionRollover.gif'" onmouseout="document.getElementById('pic7').src='../images/overallsocialintelligence/general/retention.gif'" />
					   	</h:outputLink>
					</a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle">	
					<a4j:outputPanel rendered="#{currentTab eq 'Demographics'}">
						<img src="../images/overallsocialintelligence/selected/demographicsSelect.jpg" border="0" />	
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'Demographics')}">
					   <h:outputLink value="demographics.jsp" width="102">
							<img src="../images/overallsocialintelligence/general/demographics.gif" border="0"  name="pic8" id="pic8"  onmouseover="document.getElementById('pic8').src='../images/overallsocialintelligence/rollover/demographicsRollover.gif'" onmouseout="document.getElementById('pic8').src='../images/overallsocialintelligence/general/demographics.gif'" />
					   </h:outputLink>
					</a4j:outputPanel>
				</td>
			</tr>
		</table>
		
	</h:form>
	
	</ui:composition>