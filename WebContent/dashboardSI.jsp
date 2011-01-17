<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">

	<td class="topFirstTablehdCategory" valign="middle" align="center">
		<table width="#{tablewidth}" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
		<tr>
			<td valign="middle" align="center">
				<a id="displayText#{siname}" href="##{scrollto}" onclick="#{jvmethod}" style="text-decoration: none;"
				onmouseover="#{jvmethod1}" onMouseOut="#{jvmethod1}"
				>
					#{siname}
				</a>
			</td>
			<td valign="middle" align="left">
				<h:graphicImage value="../images/bulb.gif" 
       				onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
      				<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
          				<span><h:outputText value="#{tooltip}" /></span>
      				</rich:toolTip>
 				</h:graphicImage>
  			</td>
		</tr>
		</table>
	</td>
</ui:composition>