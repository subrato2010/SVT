<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
		<script language="JavaScript" src="../js/svt.js"></script>
		<script language="JavaScript" src="../js/all.js"></script>
		<script language="JavaScript">
			function setProfileId(profileId,profileName){				
				if(profileId == "0"){
					profileName="All";
				}
				parent.document.getElementById('templatedatetwitterForm:dummyholder').value=profileId;
				parent.document.getElementById('templatedatetwitterForm:dummyholder2').value=profileName;
				parent.document.getElementById('captionDiv').innerHTML=profileName;								
			}
		</script>
		<script language="JavaScript" src="../js/calenderComp.js"></script>
		<script language="JavaScript">	
			function performanceCalender(day) {
		       	var bfrdt = '#{channelPerformanceController.minPerformanceAsofDiffFromCurrentDate}';
		    	var afterDt = '#{channelPerformanceController.maxPerformanceAsofDiffFromCurrentDate}';    	
		    	return disablementFunction(day , bfrdt , afterDt);
			}
			function populateGraphWithData(valueString) {
				var flashvars = {};
				flashvars.trendData = valueString;
				showSWF("Trending","../flash/Terametric.swf", "flashContent", "760", "320", flashvars);
				parent.document.getElementById('trendingTitle').innerHTML=document.getElementById('templatedatetwitterForm:trendingCategory').value;
				document.getElementById('trendingDiv').style.display='block';
			}
			function setCSSToClickableDate(day) {
				var minDate = #{channelPerformanceController.minDate};
				var maxDate = #{channelPerformanceController.maxDate};
				return cssClassesProvider(day, minDate, maxDate);
			}
			function setClickability(day) {
				var minDate = #{channelPerformanceController.minDate};
				var maxDate = #{channelPerformanceController.maxDate};
				return clickabilityProvider(day, minDate, maxDate);
			}	
			function setSelectedHandler(profileName) {		
				if(profileName){
					parent.document.getElementById("outboundMetricsForm1:selectedHandler").value=profileName;	
				} else {
					parent.document.getElementById("outboundMetricsForm1:selectedHandler").value='All';
				}				
			}
		</script>
	<style>
		.clickable {
			background-color: gray;
		}
	</style>
	<f:view>
		<h:form id="templatedatetwitterForm">
			<h:inputHidden id="dummyholder" value="#{channelPerformanceController.twitterAccountId}" />
			<h:inputHidden id="dummyholder2" value="#{channelPerformanceController.twitterAccountName}" />
			<h:inputHidden id="dummyholder1" value="#{channelPerformanceController.targetId}" />
			<input type="hidden" id="targetSelected" name="targetSelected" value="" />
			<h:inputHidden id="clickedSentiment" value="#{channelPerformanceController.clickedSentiment}" />
			<input type="hidden" name="graphDate" id="graphDate" value="" />
			<input type="hidden" name="graphTwitterId" id="graphTwitterId" value="" />

			<!--  This blocked portion is for trending graph and controlled from mainscreen.jsp -->
			<h:inputHidden id="trendingCategory" value="#{channelPerformanceController.trendingCategorySelected}" />
			<h:inputHidden id="trendingSelf" value="#{channelPerformanceController.trendingSelfSelected}" />
			<h:inputHidden id="trendingMode" value="#{channelPerformanceController.trendingModeDWMSelected}" />
			<a4j:commandLink id="viewTrendingHidden" value="" onclick="change();"
				actionListener="#{trendingGraphHandler.viewTrending}"
				oncomplete='populateGraphWithData("#{trendingGraphHandler.trendingXMLData}"); document.getElementById("graphLoader").style.display="none"; document.getElementById("trendingDivGraph").style.display="block";'
				reRender="trendingPanel" style="text-decoration: none;">
			</a4j:commandLink>
			<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->

			<div class="mainBodyTop2">
				<table width="640" border="0" cellspacing="0" cellpadding="0" style="margin-left: 20px;">
					<tr>
						<td class="topChannelPerformanceDate" valign="middle" align="center" width="170">
							Select performance as of 
							<h:graphicImage value="../images/bulb.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									<span>
										<h:outputText value="Select the date for which you'd like to view your overall performance scores. The performance as of date is also the end date of your performance improvement campaign." style="text-align: left;" />
									</span>
								</rich:toolTip>
							</h:graphicImage>
						</td>
						<td valign="middle" align="center" width="90">
							<rich:calendar id="performanceEndDate"
								value="#{channelPerformanceController.performanceAsOfDate}"
								inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"
								isDayEnabled="setClickability" dayStyleClass="setCSSToClickableDate" />
						</td>
						<td class="topChannelPerformanceDate" valign="middle" align="center" width="70">
							from profile
						</td>
						<td valign="middle" align="center" colspan="2">
							<table width="100%" cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="middle" align="center" width="190">
										<div class="mainDiv" id="main_x">
											<div id="captionDiv" class="captionDiv">
												#{channelPerformanceController.selectedTwitterUsername}											
											</div>
											<div class="textDiv" style="cursor: pointer;">
												<h:inputText id="in1" styleClass="fakeText" onblur="closeList('x');" onclick="toggleList('x')" readonly="true" style="cursor:auto; text-align:right;" value="" />
											</div>
										</div>
										<div class="listDiv" id="list_x" onmouseover="setInList(true);" onmouseout="setInList(false);">
											<div class="itemDiv">
												<a onclick="setProfileId('0','All');toggleList('x');setSelectedHandler('All');" href="#" class="optiontext">
													All
												</a>
											</div>
											<ui:repeat value="#{channelPerformanceController.twitterAccount}" var="twitterAccount">
												<div class="itemDiv">
													<a onclick="setProfileId('#{twitterAccount.twitterAccountId}','#{twitterAccount.twitterUsername}');toggleList('x'); setSelectedHandler('#{twitterAccount.twitterUsername}');" href="#" class="optiontext">
														#{twitterAccount.twitterUsername} 
													</a>
												</div>
											</ui:repeat>
											<div class="listBottomDiv"></div>
										</div>
									</td>
									<td valign="top" align="left" style="padding-left: 4px">
										<h:commandLink id="fromprofilesubmit" value="" style="text-decoration: none;"
											actionListener="#{channelPerformanceController.submitQuery}">
											<img src="../images/Buttons/General/submitGeneral.gif" border="0"
												onclick="if(change()){return true}else{return false};"
												onmouseover="changeImage(this,'../images/Buttons/rollover/submitRollover.gif');"
												onmouseout="changeImage(this,'../images/Buttons/General/submitGeneral.gif');"
												style="margin-top: 3px" />
											<f:param name="si" value="cc" />
											<f:param name="col" value="cv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
										</h:commandLink>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="topChannelPerformanceDate" valign="middle" align="left" style="padding-left: 7px;">
							Select benchmark as of 
							<h:graphicImage value="../images/bulb.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
									<span>
										<h:outputText value="Your benchmark is a baseline of your own performance against which your future performance will be measured. The default benchmark is automatically set data that is obtained in the first two weeks of optimization. You may change the date and recalculate your overall performance improvement or select 'Reset' to return to the original default data set. Set your benchmark date as the start date from which your performance campaign begins." style="text-align: left;" />
									</span>
								</rich:toolTip>
							</h:graphicImage>
						</td>
						<td valign="middle" align="left" colspan="5">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td valign="middle" align="center" width="90">
										<rich:calendar id="benchmarkEndDate" 
											value="#{channelPerformanceController.benchmarkDateTo}"
											inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"
											isDayEnabled="setClickability" dayStyleClass="setCSSToClickableDate" />
									</td>
									<td width="50" valign="middle" align="center">
										<h:commandLink value="" style="text-decoration: none;"
											actionListener="#{channelPerformanceController.submitQuery}">
											<img src="../images/Buttons/General/submitGeneral.gif" border="0"
												onclick="if(change()){return true}else{return false};"
												onmouseover="changeImage(this,'../images/Buttons/rollover/submitRollover.gif');"
												onmouseout="changeImage(this,'../images/Buttons/General/submitGeneral.gif');" />
											<f:param name="si" value="cc" />
											<f:param name="col" value="cv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
										</h:commandLink>
									</td>
									<td valign="middle" align="left">
										<font class="topFirsthd">or</font>
										<font class="topFirstTablehdCategory2" style="font-size: 12px; cursor: pointer;" onclick="setResetDate('benchmarkEndDate', '#{channelPerformanceController.resetDate}')">
											RESET 
										</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</h:form>
	</f:view>
</ui:composition>