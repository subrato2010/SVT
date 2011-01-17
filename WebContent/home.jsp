<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	 
	<ui:composition template="templates/templateHome.jsp">
	<ui:define name="content">
		<table width="80%">
			<tr>
				<td valign="middle" align="center" height="200px">
				<f:view>
				<rich:panel header=" " headerClass="header-left" bodyClass="homePanel-body">
						<table>
							<tr height="200px">
								<td>Image....</td>
							</tr>
						</table>				
				</rich:panel>	
				</f:view>
				</td>
			</tr>
		</table>
	</ui:define>
	</ui:composition>	
</html>