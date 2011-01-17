<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>
	
	<f:view>
	<h:form id="sIntellegence">
	<h:inputHidden id="sentimentName" value="#{commonController.currentSentimentName}" />
	<table border="0" width="100%"><tr><td>
		<!-- *************Body Right Pannel TOP Start ***************-->
                           
		<div class="right_pannel_social_inside">
		
			<table cellspacing="0" cellpadding="0" bgcolor="#ffffff" border="0" width="930" style="border-top: 1px solid #DBDCE0; border-right: 1px solid #DBDCE0;">
			<tr>
				<td align="center" style="padding-left:30px; border-right:3px solid #A1CE48;">
					<div id="flashDiv"></div>
<!-- 
					<script language="JavaScript">
				      var flashvars = {};				     
				      flashvars.dataXML = "#{socialIntelligenceController.dataXml}";
				      showSWF("os1","../flash/socialInte.swf", "flashDiv", "500", "750", flashvars);
				    </script>
-->
					<object>
						<param name="movie" value="socialInte.swf"/>
						<param name="quality" value="high" />
						<embed type="application/x-shockwave-flash" 
						src="../flash/socialInte.swf?dataXML=#{commonController.dataXml}"  
						height="500px" width="750px"/>
					</object>
				</td>
				<td bgcolor="#F6F6F6">
                                                                                    
                <div style="width:120px;height:100%;">
                	<ui:include src="overallSILegend.jsp"/>
                </div>
			 </td>
			</tr>
			</table>
		</div>
		<!-- *************Body Right Pannel TOP End ***************-->
		</td></tr>
		
		<tr><td>
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
					To provide an idea of the motivators of your audience as it relates to what they feel, how strongly they feel about it and their level of trust for your brand vs. your competitors'. Energy is a measure of the likelihood that individuals that are talking about your brand will do so repeatedly. Trust indicates the level of skepticism and willingness to believe your message.
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
		</td></tr></table>
		</h:form>
		</f:view>
		
	</ui:composition>