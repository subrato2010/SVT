
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">
	<ui:define name="title">
		Overall Score
	</ui:define>
	<ui:define name="menu">
		<ui:include src="/templates/leftDynamicMenuSVT.jsp">
			<ui:param name="menu" value="#{overallScoreController}" />
		</ui:include>
	</ui:define>
	<ui:define name="tabs">
		<ui:include src="/inc/overallScoreTabs.jsp">
			<ui:param name="currentTab" value="overallscore" />
		</ui:include>
	</ui:define>
	<ui:define name="body_right_pannel">
		<table border="0" width="100%">
			<tr>
				<td><!-- *************Body Right Pannel TOP Start ***************-->

				<div id="right_pannel_top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="margin-top: 10px;">
					<tr>
						<td valign="top" bgcolor="#FFFFFF" width="250px"
							class="dash_dial_table" style="border-bottom: 1px solid #DBDCE0;">
						<script language="JavaScript">
					setScoreCount(#{overallScoreController.count});
				</script>
						<table cellspacing="0" cellpadding="0" bgcolor="#ffffff"
							width="250px" style="margin-top: 10px;">
							<a4j:repeat value="#{overallScoreController.competitorScoreList}"
								var="competitor" rowKeyVar="i">
								<tr id="tr_#{i}">
									<td align="left" id="td_#{i}" style="margin-left: 4px;"
										onmouseover="dcMouseOver(this)" onmouseout="dcMouseOut(this)">
									<span id="flashSpan_#{i}"
										style="#{(i == 0)? 'display:block;' : 'display: none;'}; left:536px; margin-top:112px;"
										class="dash_dial_span"></span>

									<div id="smallFlashDiv_#{i}"></div>
									<script language="JavaScript">
						      var flashvars_#{i} = {};
						      flashvars_#{i}.outerLabels = "#{competitor.outerScoreLabel}";
						      flashvars_#{i}.outerScores = "#{competitor.outerScoreValue}";
						      flashvars_#{i}.innerLabels = "#{competitor.innerScoreLabel}";
						      flashvars_#{i}.innerScores = "#{competitor.innerScoreValue}";
						      flashvars_#{i}.totalScore = "#{competitor.overallScore}";
						      flashvars_#{i}.company = "#{competitor.companyDTO.companyName}";
						      flashvars_#{i}.flashImgNumber ="#{i}";
						      showSWF("tss_#{i}","../flash/TotalScoreSmall.swf", "smallFlashDiv_#{i}", "250", "290", flashvars_#{i});
						    </script></td>
								</tr>
							</a4j:repeat>
						</table>
						<script language="javascript">
				 document.getElementById("tr_0").style.backgroundColor = "#efeef3";
					document.getElementById("tr_0").style.border = "1px solid #e0e0e0";
				 </script></td>
						<td align="center" valign="top"
							style="padding-left: 30px; background-color: #ffffff; border-bottom: 1px solid #DBDCE0; border-top: 1px solid #DBDCE0; border-right: 1px solid #DBDCE0;">
						<a4j:repeat value="#{overallScoreController.competitorScoreList}"
							var="score" rowKeyVar="j">
							<div id="bigFlashDiv_#{j}"
								style="#{(j == 0)? 'display:block;' : 'display: none;'}"
								class="tsDiv">
							<div id="flashDiv"></div>
							<script language="JavaScript">
						      var flashvars_#{j} = {};
						      flashvars_#{j}.outerLabels = "#{score.outerScoreLabel}";
						      flashvars_#{j}.outerScores = "#{score.outerScoreValue}";
						      flashvars_#{j}.innerLabels = "#{score.innerScoreLabel}";
						      flashvars_#{j}.innerScores = "#{score.innerScoreValue}";
						      flashvars_#{j}.totalScore = "#{score.overallScore}";
						      flashvars_#{j}.company = "#{score.companyDTO.companyName}";
						      showSWF("os_#{j}","../flash/overallscoreChart.swf", "flashDiv", "656", "640", flashvars_#{j});
						    </script></div>
						</a4j:repeat></td>
					</tr>
				</table>
				</div>
				<!-- *************Body Right Pannel TOP End ***************--></td>
			</tr>
			<tr>
				<td><!-- *************Body Left Pannel BOTTOM Start ***************-->
				<div class="right_pannel_bottom" id="body_bottom_open">
				<div class="wt_open">
				<table width="85%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>

						<p class="matter_home">WHAT'S THIS?<font> <a
							href="javascript:closeMe('body_bottom_open','body_bottom_close')"
							class="close">CLOSE</a></font></p>
						<p class="matter_index"><b>Overall Score:</b> A weighted
						average of all channel scores. (100 represents the pinnacle of
						channel optimization relative to competitive and industry
						parallels.) <br />
						<b>Channel Score:</b> A weighted average of inbound vs. outbound
						performance. Value represents how well your channels are capable
						of performing hard and soft conversions. <br />
						<b>Inbound Attributes:</b> Actual metrics associated with inbound
						activities (interaction with channel users) that are scored based
						on industry standards and adjusted relative to the competitive
						set. <br />
						<b>Outbound Attributes:</b> Actual metrics associated with
						outbound activities (construction of the channel itself) that are
						scored based on industry standards and adjusted relative to the
						competitive set. <br />
						<b>Social Intelligence:</b> Inbound metrics categorized and
						weighted according to individual measures. Value represents the
						size and strength of your sphere of influence and the likelihood
						that someone will listen or act upon a message.</p>
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
				<!-- *************Body Right Pannel BOTTOM End ***************--></td>
			</tr>
		</table>
	</ui:define>
</ui:composition>
