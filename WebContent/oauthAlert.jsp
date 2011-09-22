<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
<link href="../css/profile.css" rel="stylesheet" type="text/css" />

<f:view>
	<h:inputHidden value="#{replyTwitterDataController.referenceName}"/>
    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="margin-top: 20px;">
    	<tr>
    		<td valign="top" align="center" class="authAlert">
	    		OOPS !!! 
			</td>
		</tr>
		<tr>
		
    		<td valign="top" align="center" class="authAlertText">
    		Authentication Failed.
    		</td>
    	</tr>
    </table>
</f:view>
</ui:composition>
