<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>

	<script language="JavaScript" src="../js/svt.js"></script>
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



<f:view>	
<h:form id="templatedatetwitterForm">	
	   <h:inputHidden id="dummyholder" value="#{channelPerformanceController.twitterAccountId}"/>
	   <h:inputHidden id="dummyholder2" value="#{channelPerformanceController.twitterAccountName}"/>
	   <h:inputHidden id="dummyholder1" value="#{channelPerformanceController.targetId}"/>	
		<div class="mainBodyTop2">
		<table width="640" border="0" cellspacing="0" cellpadding="0"
			style="margin-left: 20px;">
			<tr>

				<td class="topChannelPerformanceDate" valign="middle" align="center" width="150">Select performance as of </td>	
				<td valign="middle" align="center" width="90">
					<rich:calendar id="performanceEndDate" 
                        value="#{channelPerformanceController.performanceAsOfDate}" 
                        inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"/>
				</td>
				<td class="topChannelPerformanceDate" valign="middle" align="center"  width="70">from profile</td>
				<td valign="middle" align="center" colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td valign="middle" align="center" width="190">
							<div class="mainDiv" id="main_x">
						<div id="captionDiv" class="captionDiv">#{channelPerformanceController.selectedTwitterUsername}</div> 
						<div class="textDiv" >
							<h:inputText  id="in1" styleClass="fakeText" onblur="closeList('x');" onclick="toggleList('x')" 
								readonly="true" style="cursor:auto; text-align:right; " 
								value=""/>
						</div>
					    
					</div>
					<div class="listDiv" id="list_x" onmouseover="setInList(true);" onmouseout="setInList(false);">
						<div class="itemDiv">
							<a  onclick="setProfileId('0','All');toggleList('x');" href="#" class="optiontext">All
					    	</a>
						</div>
						<ui:repeat value="#{channelPerformanceController.twitterAccount}" var="twitterAccount">
							<div class="itemDiv">
					   			<a onclick="setProfileId('#{twitterAccount.twitterAccountId}','#{twitterAccount.twitterUsername}');toggleList('x');" href="#" class="optiontext">
									#{twitterAccount.twitterUsername}
					            </a>
						    </div>
						</ui:repeat>
						<div class="listBottomDiv"></div>
					</div>			
							</td>
							<td valign="top" align="left" style="padding-left:4px">
							   <h:commandLink value="" 
									actionListener="#{channelPerformanceController.submitQuery}" 
									style="text-decoration: none;">
							         <img src="../images/submitButton.gif" border="0"/>
							         		<f:param name="si" value="cc" />
											<f:param name="col" value="cv" />
							         
							    </h:commandLink>
							
							</td>
						</tr>
					</table>
						
				</td>				
				
			</tr>
		<tr>
			<td class="topChannelPerformanceDate" valign="middle" align="left" style="padding-left: 7px;">
			Change your Benchmark:
			</td>
			<td valign="middle" align="left" colspan="5">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td class="topChannelPerformanceDate" valign="middle" align="left" width="60" style="padding-left: 7px;">
							From Date:
						</td>
						<td valign="middle" align="center" width="90">
					<rich:calendar id="benchmarkStartDate" 
                        value="#{channelPerformanceController.benchmarkDateFrom}" 
                        inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"/>
						</td>
						<td class="topChannelPerformanceDate" valign="middle" align="left" width="45"  style="padding-left: 7px;">
							To Date:
						</td>	
						<td valign="middle" align="center" width="90">
							<rich:calendar id="benchmarkEndDate" 
		                        value="#{channelPerformanceController.benchmarkDateTo}" 
		                        inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"/>
						</td>
						<td width="50" valign="middle" align="center">
								<h:commandLink value="" 
									actionListener="#{channelPerformanceController.submitQuery}" 
									style="text-decoration: none;">
							         <img src="../images/submitButton.gif" border="0"/>
							         							         		<f:param name="si" value="cc" />
											<f:param name="col" value="cv" />
							         
							    </h:commandLink>

						</td>
						<td  valign="middle" align="left">
						<font class="topFirsthd">or</font> <font class="topFirstTablehdCategory2" style="font-size: 12px;">RESET</font>
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