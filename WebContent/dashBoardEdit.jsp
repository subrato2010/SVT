<?xml version="1.0" encoding="ISO-8859-1" ?>
<html xmlns="http://www.w3.org/1999/xhtml" 
	xmlns:f="http://java.sun.com/jsf/core" 
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>
<a4j:loadStyle src="../style/style.css"/>
<a4j:loadStyle src="../style/edit.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-store"/>	
<title>EDIT</title>
</head>
<body>
<f:view>
<a4j:outputPanel rendered="#{!dashboardEditController.closable}">
<h:form>

		<input type="hidden" name="index" value="#{dashboardEditController.index}"/>
		<h:inputHidden value="#{userProfileController.completeFlag}"/>
		
		<table width="95%" border="0" style="margin-top:20px; margin-left:20px" cellpadding="0" cellspacing="0">
				<tr>
                  <td width="230px"><div></div></td>
                  <a4j:repeat value="#{dashboardEditController.dashBoardMatricsBean.headers}" var="comp">
                  		<td class="graph_data_hd1" align="center">#{comp.name}</td>
                  </a4j:repeat>
                </tr>
                <tr>
                  <td colspan="5"><div class="graph_border"></div></td>
              
                </tr>
		</table>
		<div class="lowerpart">
		<table width="95%" border="0" style="margin-top:20px; margin-left:20px" cellpadding="0" cellspacing="0">
                
                <a4j:repeat value="#{dashboardEditController.dashBoardMatricsBean.rows}" var="row"> 
                
                <tr height="50px">
                  <td class="graph_data_hd" align="left" width="230px">
                  	<h:form>
                  	<a href="#" style="color: #6E7177"  class="graph_data_hd" onmouseover="this.style.color='#63881A'; this.style.fontSize='13px'; this.style.cursor='hand';" onmouseout="this.style.fontSize='13px'; this.style.color='#6E7177';">
                  				#{row.subCategoryName}<br/>#{row.categoryDTO.categoryName}
					</a>
                  			
                  	<h:graphicImage value="../images/bulb.jpg" rendered="#{row.description != null}" 
                  				onmouseover="this.src='../images/bulb_green.jpg';" onmouseout="this.src='../images/bulb.jpg';">
					        <rich:toolTip  styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block" rendered="#{row.description != null}"
					         onshow="" onhide="" >
					            <span><h:outputText value="#{row.description}" /></span>
					        </rich:toolTip>
					</h:graphicImage>
                  	<br />
                  	<a href="#" style="color: #B0B0B0"  class="graph_data_hd" onmouseover="this.style.color='#A2C759'; this.style.fontSize='13px'; this.style.cursor='hand';" onmouseout="this.style.fontSize='13px'; this.style.color='#B0B0B0';">
					   	1M Average
					</a>
                  	</h:form>
                  </td>
                  
                  <a4j:repeat value="#{row.sentimentList}" var="sentiment">
                  	<td class="graph_data_number" align="center">
	                  	<h:inputText value="#{sentiment.sentimentValue}" style="color: #7AC142; font-size: 24px; height:40px; width:60px;"  styleClass="graph_data_number" />
                  	</td>
                  </a4j:repeat>

                </tr>
                
                </a4j:repeat>
                
               
     	</table>
		</div>
		
		<h:commandLink action="#{dashboardEditController.save }" >
             <img src="../images/roi/roi_save.gif" border="0" style="padding-left:15px;padding-top:14px;"/>
        </h:commandLink>
		
</h:form>
</a4j:outputPanel>

<a4j:outputPanel rendered="#{dashboardEditController.closable}">
		<script>
				parent.location.reload();
		</script>
</a4j:outputPanel>

</f:view>
</body>
</html>