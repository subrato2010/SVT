<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	>

		<f:view>
		
	            <h:form id="myForm" enctype="multipart/form-data">	  
	             <t:htmlTag value="b"><i>Bold  Italic font</i></t:htmlTag> 
	                     
				<t:inputFileUpload  id="myFileId" value="#{fileUploadController.myFile}" storage="file" immediate="true" required="true"/>
				<h:commandButton action="#{fileUploadController.processMyFile}" value="submit" />
				</h:form>  
				
		</f:view>
</ui:composition>
