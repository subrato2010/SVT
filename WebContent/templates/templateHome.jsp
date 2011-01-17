<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j">
	<f:view>		
		<head>
			<title>
				<ui:insert name="title" />
			</title>			
			<a4j:loadStyle src="/style/style.css" />
			<ui:insert name="pageCSS"></ui:insert>
			<ui:insert name="pageScripts"></ui:insert>
			
		</head>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>  
		<meta http-equiv="expires" content="-1" />
		<body bgcolor="">
			<table width="100%">
			<tr>
			<td align="center" >
			<div id="container" style="">
				<!-- Header -->
				<div id="header">
					<ui:include src="../inc/header.jsp" /> 
				</div>
				<div id="main">
					<table width="100%">
						<tr>
							<td align="right"></td>
						</tr>
					</table>
					<ui:insert name="content">
					</ui:insert>
			</div>
				
				<!-- Footer -->
				<div id="footer">
					<ui:include src="../inc/footer.jsp" /> 
				</div>
			</div>
			</td>
			</tr>
			</table>
		</body>
	</f:view>
</html>

