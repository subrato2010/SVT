<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	
	<h:form>
		<table  border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'overallscore' }">
						<img src="../images/overallscore/selected/dashboardSelected.jpg" border="0"/>
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'overallscore') }">
						<h:outputLink value="overallscore.jsp">
							<img src="../images/overallscore/general/dashboard.gif" border="0"  name="pic1"  id="pic1"  onmouseover="document.getElementById('pic1').src='../images/overallscore/rollover/dashboardRollover.gif'" onmouseout="document.getElementById('pic1').src='../images/overallscore/general/dashboard.gif'" />
						</h:outputLink>	
					</a4j:outputPanel>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="102">	
					<a4j:outputPanel rendered="#{currentTab eq 'analysis' }">	
						<img src="../images/overallscore/selected/analysisSelected.jpg" border="0"/>
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'analysis') }">	
						<h:outputLink value="executiveOverallSummary.jsp">
							<img src="../images/overallscore/general/analysis.gif" border="0"  name="pic2" id="pic2"  onmouseover="document.getElementById('pic2').src='../images/overallscore/rollover/analysisRollover.gif'" onmouseout="document.getElementById('pic2').src='../images/overallscore/general/analysis.gif'" />
						</h:outputLink>
					</a4j:outputPanel>		   					
				</td> 
				<td width="5px"></td>
				<td align="center" valign="middle" width="102">
					<a4j:outputPanel rendered="#{currentTab eq 'datainput' }">	
						<img src="../images/overallscore/selected/datainputSelected.jpg" border="0"/>
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'datainput') }">	
						<h:outputLink  value="datainput.jsp">
							<img src="../images/overallscore/general/datainput.gif" border="0"  name="pic3" id="pic3"  onmouseover="document.getElementById('pic3').src='../images/overallscore/rollover/datainputRollover.gif'" onmouseout="document.getElementById('pic3').src='../images/overallscore/general/datainput.gif'"/>
						</h:outputLink>	
					</a4j:outputPanel>				
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="105">
					<img src="../images/overallscore/inactive/trendingInactive.jpg" border="0"/>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle" width="153">
					<a4j:outputPanel rendered="#{currentTab eq 'roi' }">	
						<img src="../images/overallscore/selected/roiSelected.jpg" border="0"/>
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(currentTab eq 'roi')}">	
						<h:outputLink  value="overallROI.jsp">
							<img src="../images/overallscore/general/roioptimization.gif" border="0"  name="pic4"  id="pic4" onmouseover="document.getElementById('pic4').src='../images/overallscore/rollover/roioptimizationRollovers.gif'" onmouseout="document.getElementById('pic4').src='../images/overallscore/general/roioptimization.gif'"/>
						</h:outputLink>
					</a4j:outputPanel>	
				</td>
			</tr>
		</table>
	</h:form>
	
	
</ui:composition>