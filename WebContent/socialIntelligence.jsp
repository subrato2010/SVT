
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">
	
	<ui:define name="title">
		Sentiment
	</ui:define>
	<ui:define name="menu">
		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{socialIntelligenceController }"/>
		</ui:include>
	</ui:define>
	<ui:define name="tabs">
	<h:form>
		<table  border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="middle">
				   <h:commandLink action="overallsi" value="">
				      <img src="../images/overallSI.jpg" border="0"/>
				   </h:commandLink>
				</td>
				<td width="5px"></td> 
				<td align="center" valign="middle">
					<img src="../images/sentiment_select.jpg" border="0" />
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle">
				   <h:commandLink action="influence" value="">
				      <img src="../images/influence.jpg" border="0"/>
				   </h:commandLink>
				</td> 
				<td width="5px"></td>
				<td align="center" valign="middle">
				   <h:commandLink action="reach" value="">
						<img src="../images/reach.jpg" border="0"/>
				   </h:commandLink>	
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle">
				   <h:commandLink action="engagement" value="">
						<img src="../images/engagement.jpg" border="0"/>
				   </h:commandLink>
				</td>				
				<td width="5px"></td>
				<td align="center" valign="middle">		
				   <h:commandLink action="loyalty" value="">
						<img src="../images/loyalty.jpg" border="0"/>
				   </h:commandLink>
				</td>
				<td width="5px"></td>
				<td align="center" valign="middle">		
				   <h:commandLink action="retention" value="">
						<img src="../images/retention.jpg" border="0"/>
				   </h:commandLink>
				</td>
			</tr>
		</table>
	</h:form>
	</ui:define>
	<ui:define name="body_right_pannel">
	
		<table border="0" width="100%"><tr><td>
		<!-- *************Body Right Pannel TOP Start ***************-->
		                                     
		<div class="right_pannel_social_inside">
		
			<table cellspacing="0" cellpadding="0" bgcolor="#ffffff" border="0">
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
						src="../flash/socialInte.swf?dataXML=#{socialIntelligenceController.dataXml}"  
						height="500px" width="750px"/>
					</object>
				</td>
				<td bgcolor="#F6F6F6">
                                                                                    
                <div style="width:100px; height:100%;">
                
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td colspan="2" class="social_ident" align="center">Legend</td>
                                    
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">Comp0</td>
                                    <td align="center"><img src="../images/bar_social.gif" width="40" /></td>
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">Comp1</td>
                                    <td align="center"><img src="../images/yellow_round.jpg" /></td>
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">Comp2</td>
                                    <td align="center"><img src="../images/red_round.jpg" /> </td>
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">Comp3</td>
                                    <td align="center"><img src="../images/green_round.jpg" /></td>
                                  </tr>
                </table>
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
		
	</ui:define>
</ui:composition>
