<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../css/graph.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	
	<script language="JavaScript">
	function setProfileId1(profileId,profileName)
	{
		if(profileId == "0")
		{
			profileName="All";
		}
		parent.document.getElementById('graphTwitterId').value=profileId;
		//parent.document.getElementById('templatedatetwitterForm:dummyholder2').value=profileName;
		document.getElementById('captionDiv_y').innerHTML=profileName;
	}
</script>

	<f:view contentType="text/html">
	    <div id="trendingDiv" style="z-index: 100000000;">
			<div id="graphLoader">
				<img id="preloader" src="../images/preloader3.gif" style="position: center; margin-top: 150px;" alt="preloader"/>
			</div>
			<div id="trendingDivInside">
				<div id="trendingDiv_top">
					<table width="100%" height="30" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td valign="middle" align="left" class="titletrending">
								<div class="trendingTitleTotal">
			    				<div class="trendingTitleTotalLeft">Trending of</div>
			    				<div id="trendingTitle" class="trendingTitleTotalRight">Overall</div>
			    				</div>
			    				
			    				<div class="mainDivGraph" id="main_y">
									<div id="captionDiv_y" class="captionDivGraph">#{channelPerformanceController.selectedTwitterUsername}</div>
										<div class="textDiv">
											<h:inputText id="in1" styleClass="fakeText" onblur="closeList('y');" onclick="toggleListGraph('y')" readonly="true"
												style="cursor:auto; text-align:right; " value="" />
										</div>
								</div>
								<div class="listDivGraph" id="list_y" onmouseover="setInList(true);" onmouseout="setInList(false);">
									<div class="itemDiv">
										<a href="#" onclick="setProfileId1('0','All');toggleListGraph('y');" class="optiontext">All</a>
									</div>
									<ui:repeat value="#{channelPerformanceController.twitterAccount}" var="twitterAccount">
										<div class="itemDiv">
											<a	href="#" class="optiontext" 
											onclick="setProfileId1('#{twitterAccount.twitterAccountId}','#{twitterAccount.twitterUsername}');toggleListGraph('y');">#{twitterAccount.twitterUsername}</a>
										</div>
									</ui:repeat>
									<div class="listBottomDiv"></div>
								</div>
								<div class="trendinggraphCalenderLeft">
								<div class="trendinggraphCalenderLeft1">From Date:</div>
								<div class="trendinggraphCalenderLeft2">
								<rich:calendar id="graphPerformanceStartDate" value="" inputSize="6" cellWidth="9" cellHeight="12"
									 isDayEnabled="performanceCalender" datePattern="MM/dd/yyyy" />
								</div>
								</div>
								<div class="trendingGraphRightClaender">
									<div class="trendingGraphRightClaender1">to:</div>
									<div class="trendingGraphRightClaender2">
									<rich:calendar id="graphPerformanceEndDate" value="" inputSize="6" cellWidth="9" cellHeight="12"
									style="width: 100px;" isDayEnabled="performanceCalender" datePattern="MM/dd/yyyy" />
									</div>
								</div>
							</td>
							<td valign="middle" align="center" width="40"><a
								onclick="trendingGraphClose();"
								href="#"> <img alt="alert"
								src="../images/Alert/closeGaryButton.gif" border="0" /> </a></td>
						</tr>
					</table>
			</div>
			<div id="rendingDiv_bottom">
				<a4j:outputPanel id="trendingPanel">
					<div id="trendingDivGraph">
						<div id="flashContent">
							<p>
			          			To view this page ensure that Adobe Flash Player version 
			          			10.2.0 or greater is installed. 
			      			</p>
			      			 
						</div>
					</div>		
				</a4j:outputPanel>
		    </div>
		    <div id="trendingDivGraph" style="width: 740px; margin-top: 30px;">
				<table width="740" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="TPageGray" valign="middle" align="left" width="60">VIEW</td>
						<td class="TPageGray" valign="middle" align="left" width="15"><img
							src="../images/greenArrow.gif" border="0" width="11" /></td>
						<td valign="middle" align="left" width="70">
							<a4j:commandLink id="daily" value="Daily" style="color:#77C442; text-decoration: none;" styleClass="TPageGrayGraph"
							onclick="document.getElementById('graphDate').value=document.getElementById('dashboardOverallDataForm:trendGraph:graphPerformanceEndDateInputDate').value; document.getElementById('trendingDivGraph').style.display='none'; document.getElementById('graphLoader').style.display='block'; document.getElementById('dashboardOverallDataForm:trendGraph:daily').style.color='#77C442'; document.getElementById('dashboardOverallDataForm:trendGraph:weekly').style.color='#6E7177'; document.getElementById('dashboardOverallDataForm:trendGraph:monthly').style.color='#6E7177'; populateValueForTendingGraph('true',document.getElementById('trendingTitle').innerHTML, '1');"/>
						</td>
						<td valign="middle" align="left" width="80">
							<a4j:commandLink id="weekly" value="Weekly" style="color:#6E7177; text-decoration: none;" styleClass="TPageGrayGraph"
							onclick="document.getElementById('graphDate').value=document.getElementById('dashboardOverallDataForm:trendGraph:graphPerformanceEndDateInputDate').value; document.getElementById('trendingDivGraph').style.display='none'; document.getElementById('graphLoader').style.display='block'; document.getElementById('dashboardOverallDataForm:trendGraph:weekly').style.color='#77C442'; document.getElementById('dashboardOverallDataForm:trendGraph:daily').style.color='#6E7177'; document.getElementById('dashboardOverallDataForm:trendGraph:monthly').style.color='#6E7177'; populateValueForTendingGraph('true',document.getElementById('trendingTitle').innerHTML, '2');"/>
						</td>
						<td valign="middle" align="left" width="90">
							<a4j:commandLink id="monthly" value="Monthly" style="color:#6E7177; text-decoration: none;" styleClass="TPageGrayGraph"
							onclick="document.getElementById('graphDate').value=document.getElementById('dashboardOverallDataForm:trendGraph:graphPerformanceEndDateInputDate').value; document.getElementById('trendingDivGraph').style.display='none'; document.getElementById('graphLoader').style.display='block'; document.getElementById('dashboardOverallDataForm:trendGraph:monthly').style.color='#77C442'; document.getElementById('dashboardOverallDataForm:trendGraph:daily').style.color='#6E7177'; document.getElementById('dashboardOverallDataForm:trendGraph:weekly').style.color='#6E7177'; populateValueForTendingGraph('true',document.getElementById('trendingTitle').innerHTML, '3');"/>
						</td>
						<td class="topFirstTablehdCategory2" valign="middle" align="right"
							style="font-size: 13px; font-weight: normal;"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	</f:view>
</ui:composition>
