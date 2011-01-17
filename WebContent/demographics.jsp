
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">

	<ui:define name="title">
		Demographics
	</ui:define>
	
	<ui:define name="menu">	
		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{demographicsController}"/>
		</ui:include>
	</ui:define>	

	<ui:define name="tabs">
		<ui:include src="/inc/siTabs.jsp">
				<ui:param name="currentTab" value="#{demographicsController.currentSentimentName}"/>
		</ui:include>
	</ui:define>
	
	<ui:define name="body_right_pannel">
		<ui:include src="/inc/siContent.jsp">
			<ui:param name="commonController" value="#{demographicsController}"/>
		</ui:include>
	</ui:define>
</ui:composition>
