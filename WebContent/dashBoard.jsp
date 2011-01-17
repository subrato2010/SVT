
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"

	template="templates/templateSVT.jsp">
	
	<ui:define name="title">
		#{dashboardController.currentMenu.currentChannelDTO.channelName}
	</ui:define>
	<ui:define name="menu">
	
	<ui:include src="/templates/leftMenuSVT.jsp">
		<ui:param name="menu" value="#{dashboardController }"/>
	</ui:include>
	
	</ui:define>
	
	<ui:define name="tabs">
		<ui:include src="/inc/dashBoardTabs.jsp">
			<ui:param name="currentTab" value="dashboard"/>
		</ui:include>
	</ui:define>

	<ui:define name="body_right_pannel">
		<table width="100%">
			<tr>
				<td align="left" valign="top">
				<!-- *************Body Right Pannel TOP Start ***************-->
		<div id="right_pannel_top">
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
        <td valign="top" bgcolor="#FFFFFF" width="225px" class="dash_dial_table">
			<script language="JavaScript">
				setDashCount(#{dashboardController.metricsCount});
			</script>
			<table cellspacing="0" cellpadding="0"  bgcolor="#ffffff" width="225px">
			
			<a4j:repeat value="#{dashboardController.dashBoardMerticsList}" var="matrix" rowKeyVar="i">
			<tr id="tr_#{i}">
				<td align="center" id="td_#{i}" onmouseover="dcMouseOver(this)" onmouseout="dcMouseOut(this)">
				<a4j:outputPanel rendered="#{(matrix.sentimentName eq dashboardController.currentSentiment) and !matrix.blank}">
						<span id="flashSpan_#{i}" style="display:block;" class="dash_dial_span"></span>
						<script language="JavaScript">
							document.getElementById("tr_#{i}").style.backgroundColor = "#efeef3";
							document.getElementById("tr_#{i}").style.border = "1px solid #e0e0e0";
						</script>
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{!(matrix.sentimentName eq dashboardController.currentSentiment)}">
						<span id="flashSpan_#{i}" style="display:none;" class="dash_dial_span"></span>
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{!matrix.blank}" style="float:left; margin-left: 30px;">
					
					
					<DIV ID="flashDiv_#{i}" style="float:left; ">
					<script language="JavaScript">
						var flashvars#{i} = {};
						flashvars#{i}.score = "#{matrix.totalSentimentValue}";
						flashvars#{i}.label = "#{matrix.sentimentName}";
						flashvars#{i}.flashImgNumber = "#{i}";
						showSWF("DashBoard#{i}","../flash/DashBoard.swf", "flashDiv_#{i}", "172", "120", flashvars#{i});
					</script>
					</DIV>
				
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{matrix.blank}" style="float:left; margin-left: 30px;">
					<DIV ID="flashDiv_#{i}">
					<script language="JavaScript">
						var flashvars#{i} = {};
						flashvars#{i}.score = "nodata";
						flashvars#{i}.label = "#{matrix.sentimentName}";
						flashvars#{i}.flashImgNumber = "#{i}";
						showSWF("DashBoard#{i}","../flash/DashBoardBlank.swf", "flashDiv_#{i}", "172", "120", flashvars#{i});
					</script>
					</DIV>
				</a4j:outputPanel>
				</td>
			</tr>
			</a4j:repeat>
			</table>
		</td>
		<td valign="top">
           <ui:include src="inc/dashMetrics.jsf"/>
		</td>
	</tr>
	</table>
	</div>
				</td>
			</tr>
			<tr>
				<td align="left" valign="top">
				
				<!-- *************Body Left Pannel BOTTOM Start ***************-->
		<div class="right_pannel_bottom" id="body_bottom_open">
		<div class="wt_open">
		<table width="85%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>

				<p class="matter_home">WHAT'S THIS?<font> <a
					href="javascript:closeMe('body_bottom_open','body_bottom_close')"
					class="close">CLOSE</a></font></p>
				<p class="matter_index">
					Channel Dashboard: Your channel dashboard provides you with insights into your social intelligence generated from your inbound performance. Actual category metric scores are normalized between 0 (lowest score) and 5 (highest score) so that you can easily track performance across multiple channels and determine which channel is driving individual measures of social intelligence (e.g., you website is generating high loyalty, your blogosphere is contributing to low sentiment, etc.).
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
		<table width="85%" border="0" cellpadding="0" cellspacing="0">
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
				
				</td>
			</tr>
		</table>
		
	
	
	
	
	</ui:define>


</ui:composition>
