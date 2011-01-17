
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">
	
	<ui:define name="title">
		#{inboundController.currentMenu.title}
	</ui:define>
	<ui:define name="menu">

		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{inboundController }"/>
		</ui:include>

	</ui:define>

	<ui:define name="tabs">
		<ui:include src="/inc/dashBoardTabs.jsp">
			<ui:param name="currentTab" value="inbound"/>
		</ui:include>
	</ui:define>

	<ui:define name="body_right_pannel">


		<!-- *************Body Right Pannel TOP Start ***************-->
		<div id="right_pannel_top"><ui:include
			src="inc/inboundMetrics.jsf" /></div>
		<!-- *************Body Right Pannel TOP End ***************-->


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
				<h:outputText value="#{inboundController.currentMenu.currentCategoryDTO.categoryDesc }"/>
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


		<!-- include popup div -->
		<ui:include src="inc/popup.jsf" />


	</ui:define>


</ui:composition>
