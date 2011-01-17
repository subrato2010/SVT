<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:a4j="http://richfaces.org/a4j">

<script language="JavaScript">
function setProfileId(profileId,profileName){
parent.document.getElementById('test:templateDateTwitterInclude:templateDateTwitter:dummyholder').value=profileId;
parent.document.getElementById('captionDiv').innerHTML=profileName;
}
</script>
<body>
<f:view>
	<h:form id="templateDateTwitter">
	 <link href="../css/style.css" rel="stylesheet" type="text/css"/>
	<script language="JavaScript" src="../js/designMainScreen.js"/>	
	<script language="JavaScript" src="../js/svt.js"/>
	<script language="JavaScript" src="../js/popup.js" />
	
	   <h:inputHidden id="dummyholder" value="#{channelPerformanceController.fromProfileId}"/>
			
		<div class="mainBodyTop2">
		<table width="98%" border="0" cellspacing="0" cellpadding="0"
			style="margin-left: 20px;">
			<tr>
				<!--<td class="topFirsthd" valign="middle" align="left" width="60">Show
				:</td>
				<td class="topChannelPerformanceDate" valign="middle" align="center"
					width="30">Start</td>
				<td width="160" valign="middle" align="center"><input
					type="text" name="startdate" /></td>
				<td class="topChannelPerformanceDate" valign="middle" align="center"
					width="50">to End</td>-->
				<td class="topChannelPerformanceDate" valign="middle" align="center" width="150">Select performance as of </td>	
				<td valign="middle" align="center" width="90">
					<rich:calendar id="performanceEndDate" 
                        value="#{channelPerformanceController.performanceAsOfDate}" 
                        inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"/>
				</td>
				<td class="topChannelPerformanceDate" valign="middle" align="center"  width="70">from profile</td>
				<td valign="middle" align="center" width="200">
					<div class="mainDiv" id="main_x">
						<div id="captionDiv" class="captionDiv">#{channelPerformanceController.selectedTwitterUsername}</div> 
						<div class="textDiv" >
							<h:inputText  type="text" class="fakeText" onblur="closeList('x');" onclick="toggleList('x')" 
								readonly="readonly" style="cursor:auto; text-align:right; " 
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
				<td valign="middle" align="left">
					<h:commandButton value=""	actionListener="#{channelPerformanceController.submitQuery}" 
										style="text-decoration: none;" image="../images/submitButton.gif">
	                </h:commandButton>
				</td>
			</tr>
		<tr>
			<td class="topChannelPerformanceDate" valign="middle" align="left" style="padding-left: 7px;">
			Change your Benchmark:
			</td>
			<td valign="middle" align="left" colspan="5">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td class="topChannelPerformanceDate" valign="middle" align="left" width="60" style="padding-left: 10px;">
							From Date:
						</td>
						<td valign="middle" align="center" width="90">
					<rich:calendar id="benchmarkStartDate" 
                        value="#{channelPerformanceController.benchmarkDateFrom}" 
                        inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"/>
						</td>
						<td class="topChannelPerformanceDate" valign="middle" align="right" width="70">
							To Date:
						</td>	
						<td valign="middle" align="center" width="90">
							<rich:calendar id="benchmarkEndDate" 
		                        value="#{channelPerformanceController.benchmarkDateTo}" 
		                        inputSize="6" cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy"/>
						</td>
						<td width="70" valign="middle" align="center">
							<h:commandButton value=""	actionListener="#{channelPerformanceController.submitQuery}" 
												style="text-decoration: none;" image="../images/submitButton.gif">
			                </h:commandButton>
						</td>
						<td  valign="middle" align="center">
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
</body>

</html>
