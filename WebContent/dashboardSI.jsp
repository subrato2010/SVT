<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	<div style="width: 116px; height: 20px; float: left;"  class="topFirstTablehdCategoryN">
      <a id="displayText#{siname}" href="##{scrollto}" onclick="#{jvmethod}" style="text-decoration: none;"
				onmouseover="#{jvmethod1}" onMouseOut="#{jvmethod1}">
					#{siname}
				</a>
			
				<h:graphicImage value="../images/bulb.gif" 
       				onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
      				<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
          				<span><h:outputText value="#{tooltip}" style="text-align: left;"/></span>
      				</rich:toolTip>
 		</h:graphicImage>
      
      </div>
</ui:composition>