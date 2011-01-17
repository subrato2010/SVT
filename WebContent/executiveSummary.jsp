
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"

	template="templates/templateSVT.jsp">

	<ui:define name="title">
		#{executiveSummaryController.currentMenu.title}
	</ui:define>
	<ui:define name="menu">

		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{executiveSummaryController }"/>
		</ui:include>

	</ui:define>

	<ui:define name="tabs">
		<ui:include src="/inc/dashBoardTabs.jsp">
			<ui:param name="currentTab" value="analysis"/>
		</ui:include>
	</ui:define>

	<ui:define name="body_right_pannel">	
         <div id="right_pannel_top">
			<ui:include src="inc/executiveSummaryMetrics.jsf">
				<ui:param name="controller" value="#{executiveSummaryController }"/>
			</ui:include>
		</div>		
	</ui:define>
	
</ui:composition>
