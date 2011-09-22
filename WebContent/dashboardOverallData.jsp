<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	<div id="overallDataTotal" class="topFirstTablehdCategoryN">
	<table width="80" height="20" align="center" border="0" cellpadding="0"
		cellspacing="0" style="margin-left: 20px;">
		<tr>
			<td valign="middle" align="left" width="30">
			<div id="overallData" class="topFirstTablehdCategory2">
				<a id="displayTextData" href="##{scrollto}" onclick="#{jvmethod}"
				style="color: gray; text-decoration: none; font-size: 15px;">
				#{gradevalue} </a>
			</div>
			</td>
			<td valign="middle" align="left" width="50">
			<div id="overallImg">
				<a4j:outputPanel rendered="#{!(gradevalue eq 'NA')}">
					<div style="width:23px; height:17px; float:left;">
					<a onclick="document.getElementById('captionDiv_y').innerHTML=document.getElementById('captionDiv').innerHTML; 
								document.getElementById('dashboardOverallDataForm:trendGraph:graphPerformanceEndDateInputDate').value=document.getElementById('templatedatetwitterForm:performanceEndDateInputDate').value; 
								populateValueForTendingGraph('#{overall.customer}','#{name}','1');" href="#">								
								<img src="../images/wave.gif" border="0"/>
					</a>
					</div>
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{(overall.customer) and (name eq 'Conversion')}">
				<div style="width:20px; height:16px; float:left; margin-left: 2px;">					
					<img src="../images/#{sentimentpopupicon }" border="0"/>
					</div>
				</a4j:outputPanel>

				<a4j:outputPanel rendered="#{(name eq 'Sentiment')}" style="border:0px none;">
					<div style="width:20px; height:16px; float:left; margin-left: 2px;">
					
					<!-- a href="#"
						onclick="openPopup11('@terametric',false,270, 90, 780, 700, 10, false, true, false, '#{sentimentpopup}')">
					<img src="../images/#{sentimentpopupicon }" border="0"/></a -->
					
					<img src="../images/#{sentimentpopupicon }" border="0"/>
					</div>
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{(name eq 'Influence')}">
					<div style="width:20px; height:16px; float:left; margin-left: 2px;">
					<!-- a href="#"
						onclick="openPopupinfu('This is the Customer',false,170, 90, 1000, 650, 10, false, true, false, '#{sentimentpopup}')">
					<img src="../images/#{sentimentpopupicon }" border="0"/></a -->
					<img src="../images/#{sentimentpopupicon }" border="0"/>
					</div>
				</a4j:outputPanel>
			</div>
			</td>
		</tr>
	</table>
	</div>
</ui:composition>