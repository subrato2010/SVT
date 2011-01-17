<!DOCTYPE html PUBLIC "-//W3C//liD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/liD/xhtml1-transitional.lid">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
	<f:view>
	<h:form>
        <rich:toolBar>			
            <rich:dropDownMenu>
                <f:facet name="label">
                    <h:panelGrid cellpadding="0" cellspacing="0" columns="2"
                        style="vertical-align:middle">
                        <h:outputText value="SOCIALTality Visualization Tool" />
                    </h:panelGrid>
                </f:facet>
                <rich:menuItem submitMode="none">
                    <h:commandLink action="main" >
                        <h:outputText value="Main"></h:outputText>
                    </h:commandLink>
                </rich:menuItem>
            </rich:dropDownMenu>
        </rich:toolBar>
    </h:form>
    </f:view>
    </ui:composition>