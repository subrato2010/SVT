<!DOCTYPE html PUBLIC "-//W3C//liD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/liD/xhtml1-transitional.lid">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
<div>
<table width="100%">
<tr><td>
<img src="../images/logo.jpeg"/>
</td>

<td>



    <div style="text-align:right;">
	Welcome in &nbsp; <b><h:outputText value="Edifixio"></h:outputText></b>
	| <a href="../logout.jsp">Logout</a>
	</div>

<h:form>
		
		<div style="display: block; float: right">
		<h:outputText value="Skin"></h:outputText>
		<h:selectOneMenu
			value="#{skinBean.skin}" border="0" layout="pageDirection"
			title="Changing skin" style="font-size: 8; font-family: comic"
			onchange="submit()">
			<f:selectItem itemLabel="blueSky" itemValue="blueSky" />
			<f:selectItem itemLabel="emeraldTown" itemValue="emeraldTown" />
			<f:selectItem itemLabel="wine" itemValue="wine" />
			<f:selectItem itemLabel="japanCherry" itemValue="japanCherry" />
			<f:selectItem itemLabel="ruby" itemValue="ruby" />
			<f:selectItem itemLabel="classic" itemValue="classic" />
			<f:selectItem itemLabel="deepMarine" itemValue="deepMarine" />   	    	 

		</h:selectOneMenu></div>

	</h:form>
	</td>
	</tr>
	</table>

</div>
<hr/>
</ui:composition>