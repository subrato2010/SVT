<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/editProfile.js"></script>
	<script language="JavaScript" src="../js/twitterChannelNew.js"></script>
	<a4j:loadScript src="/js/custom-form-elements.js" />
	
<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
		<a4j:repeat value="#{makePagination.paginator.currentList}"
													var="geoLocationList" rowKeyVar="i">
			<div style="color: #77c442; text-decoration: none; padding-left: 10px;" 
											styleClass="searchDetailsGreen">
				<h:outputLabel value="#{geoLocationList}"/>
			</div>
		</a4j:repeat>
		
	</f:view>
</body>
</ui:composition>

