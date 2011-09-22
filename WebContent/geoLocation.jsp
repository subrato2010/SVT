<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:s="http://sourceforge.net/projects/easysi">
	<head>
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/designMainScreen.js"></script>
	<script language="JavaScript" src="../js/popup.js" />
	<script language="JavaScript" src="../js/custom-form-elements.js" />
	<script language="JavaScript" src="../js/ajaxForGeo.js"/>
	</head>
	<body>
	<f:view contentType="text/html">
	
		<div id="toggleTextGEO" style="display: none; width: 320px; height: 17px; border:1px solid #ffffff;  background-color: #969696;">
		<a4j:outputPanel id="geoAJAX">	
			 <div id="TGTOTAL">
			 <h:form id="geolocationForm" style="margin: 0px;">
			 <div id="TG" style="width: 280px; height: 15px; float: left; margin-top: 1px;">
			 	<h:inputHidden id="geoposition" value="#{twitterController.geoLatLong}" />
				<div onclick="document.getElementById('TGTOTAL1').style.display='block';document.getElementById('TGTOTAL').style.display='none';">
				<a4j:commandLink id="addlocation" value="ADD YOUR LOCATION "
					 style="height: 15px; width: 280px; border-right:0px solid; padding-left:6px; padding-right:154px; font-weight:normal; background-image: none; background-color: #969696; color: #FFFFFF; font-family: Arial,Verdana,sans-serif; font-size: 11px; text-decoration: none; cursor: pointer;"
					 onclick="if(!checkGEO()){return false}"			 
					 actionListener="#{twitterController.searchGeoLocationForHandler}" reRender="geoAJAX"					 
					 oncomplete="toggleTextGEOW();">
				</a4j:commandLink>
				</div>
				</div>
			</h:form>
			 <div id="TG1" style="float: right; width: 32px; height: 10px;">
			 	
			 	<div id="TG3" style="float: right; width: 16px; height: 10px;">
			 	<a href="#" onclick="toggleTextGEOOFF(); closeList('x6');">
			 	<img src="../images/GEOclose.gif" border="0" height="15" style="padding-top:1px;"/></a>
			 	</div>
			 </div>
			 </div>
			
			 <a4j:outputPanel rendered="#{twitterController.yourLocation eq 'GETTING YOUR LOCATION'}"> 
			 	<div id="TGTOTAL1" style="display: none; background-color: #969696; height: 17px; width: 320px; border: 0">
			 	<div id="TG" style="width: 260px; height: 17px; float: left;">
			 	<h:inputText value="GETTING YOUR LOCATION"
			 		style="width: 260px; border-right:0px solid; padding-left:6px; background-image: none; background-color: #969696; color: #FFFFFF; font-family: Arial,Verdana,sans-serif; font-size: 11px; font-weight: normal; " onfocus="toggleList3('x6');" onblur="toggleTextGEOOFF(); closeList('x6');  document.getElementById('TGTOTAL1').style.display='none';  document.getElementById('TGTOTAL').style.display='none';" 
			 		onclick="document.getElementById('TGTOTAL').style.display='none'; document.getElementById('TGTOTAL1').style.display='block';"/>
			 	</div>
			 		<div id="TG4" style="float: right; width: 32px; height: 15px;">
				 		<div id="TG6" style="float: right; width: 16px; height: 15px;">
				 		<a href="#" onclick="toggleTextGEOOFF(); closeList('x6');">
				 			<img src="../images/GEOclose.gif" border="0" style="padding-top:1px;"/>
				 		</a>
				 		</div>
			 		
			 		<div id="TG5" style="float: left; width: 16px; height: 15px;">
			 			<img src="../images/geopreloader2.gif" border="0" style="padding-top:1px;"/> 
			 		</div>
			 		
		 		</div>
		 		</div>
			 	
			 </a4j:outputPanel> 
			 
			 
			 <a4j:outputPanel rendered="#{!(twitterController.yourLocation eq 'GETTING YOUR LOCATION')}"> 
			 	<div id="TGTOTAL1" style="display: none; height: 17px; width: 320px;  background-color:#ffffff; " >
			 	<div id="TG" style="width: 260px; height: 15px; float: left;">
			 	<div style="height: 15px; width: 260px; border:0px solid; background-color:#ffffff; border-right:0px solid; padding-left:6px; background-image: none; font-family: Arial,Verdana,sans-serif; font-size: 11px; font-weight: normal; " onfocus="toggleList3('x6');"  
			 		onclick="document.getElementById('TGTOTAL').style.display='none';document.getElementById('TGTOTAL1').style.display='block';">
			 			<div style="color:#C7C7C7; padding-right: 4px; float: left; width: 32px;">FROM</div> 
				 	 	<div id="mytestdiv"  style="color: #77C442; float: left; text-align: left;">
				 	 		#{twitterController.yourLocation}
				 	 	</div>
			 		</div>
			 	</div>
			 		<div id="TG4" style="float: right; width: 30px; height: 15px;">
			 	
			 	<div id="TG7" style="float: left; width: 12px; height: 15px;">
			 		<a4j:form>
			 		   <a4j:commandLink oncomplete="toggleList3('x6');document.getElementById('TG5').style.display='none'; document.getElementById('TG7').style.display='block';" style="cursor: hand;" 
			 						 	onblur="closeList('x6'); document.getElementById('TGTOTAL').style.display='none';  
			 						 	document.getElementById('TGTOTAL1').style.display='block';" 
			 						 	actionListener="#{twitterController.searchNearByLocationOnDropDownClicked}"
			 						 	reRender="geoNearByLoc">
			 						 	
			 				<img src="../images/geoWhiteDrop.gif" border="0" style="padding-top:2px;" 
			 				onclick="document.getElementById('TG5').style.display='block';document.getElementById('TGTOTAL1').style.display='block'; document.getElementById('TG7').style.display='none'; document.getElementById('TGTOTAL').style.display='none';closeList('x6');"/>
			 		   </a4j:commandLink>
			 		</a4j:form>
			 	</div>
			 	
			 		<div id="TG5" style="float: left; width: 16px; height: 15px; display: none;">
			 			<img src="../images/geopreloader2.gif" border="0" style="padding-top:1px;"/> 
			 		</div>
			 		
			 	<div id="TG6" style="float: right; width: 14px; height: 15px;">
			 	<a4j:form id="closeBtnForm">
			 		<a4j:commandLink oncomplete="toggleTextGEOOFF(); closeList('x6');" id="closeBtn" 
			 				onclick="document.getElementById('TG7').style.display='none'; document.getElementById('TG5').style.display='block';document.getElementById('closeImg').style.display='none';"
			 					actionListener="#{twitterController.closeButtonOperation}" reRender="geoAJAX">
			 			<img src="../images/geoWhiteClose.gif" border="0" style="padding-top:2px;" id="closeImg"/>
			 		</a4j:commandLink>
			 	</a4j:form>
			 	</div>
			 </div>
			 
			 </div>	
			 </a4j:outputPanel>
			</a4j:outputPanel>
			 </div>
			 
			<!--  <h:inputText value="#{twitterController.yourLocation}"/>  --><!-- Testing purpose  -->
			 
		
	<a4j:outputPanel id="geoNearByLoc">		
			<div class="listDivTopGET" id="list_x6" onmouseover="setInList(true);" onmouseout="setInList(false);">
				 
				 <div class="listDivTopGETTop"></div>
				 <div class="listDivTopGETMiddle">
				
				 <table width="180" cellpadding="0" cellspacing="0" height="100%"
					style="margin-left: 10px;" border="0" align="left">
					<tr>
					  <h:form id="clickFromDrpDwn">
						<td valign="top" align="left">
							<h:inputHidden id="geoValDrpDwn" value="#{twitterController.yourLocation}" />
						<a4j:repeat value="#{twitterController.geoLocationListOfHandler}"
										var="geoLocationList" rowKeyVar="i">
								<table width="180" border="0" cellpadding="0" cellspacing="0" height="40">
								  <tr>
									<td valign="middle" align="left" width="35" class="alertSelect">
										<a4j:outputPanel rendered="#{((twitterController.yourLocation) eq (geoLocationList))}">
											<input type="radio" id="chkReptEmail" 
											   value="#{geoLocationList}" name="chkrpt" checked="checked" class="alertSelect"
											   onclick="clickLink('clickFromDrpDwn:clickSetBean');parent.document.getElementById('mytestdiv').innerHTML=this.value;document.getElementById('list_x6').style.display = 'none';"/>
											   #{geoLocationList}
										</a4j:outputPanel>
										
										<a4j:outputPanel rendered="#{!((twitterController.yourLocation) eq (geoLocationList))}">
											<input type="radio" id="chkReptEmail" 
												   value="#{geoLocationList}" name="chkrpt" class="alertSelect"
												   onclick="clickLink('clickFromDrpDwn:clickSetBean');parent.document.getElementById('mytestdiv').innerHTML=this.value;document.getElementById('list_x6').style.display = 'none';"/>
														#{geoLocationList}
										</a4j:outputPanel>
									</td>
								  </tr>
								</table>
						</a4j:repeat>
						
							<a4j:commandButton id="clickSetBean" style="visibility:hidden;"/> <!-- Fire by Java script -->
						
						</td>
					  </h:form>
					</tr>
				
						<tr>
							<td valign="top" align="left" colspan="2" class="closeOrangeText"
								height="20">
							<div
								style="width: 114px; padding-left: 4px; padding-bottom: 4px; padding-right: 4px; padding-top: 4px; border: 1px solid #77C442; margin-left: 8px;">
							<a href="#" id="searchLocationDropDown"
								style="font-family: Arial, Helvetica, sans-serif; font-size: 11px; color: #77C442; text-decoration: none;"
								onclick="parent.document.getElementById('list_x6').style.display='none'; openPopup('Search Locations', '', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 300, 250, 520, 240, 10, false, true, false, 'searchLocation.jsp');">
									SEARCH LOCATIONS</a>
								</div>
							</td>
						</tr>
				</table>
			</div>
			<div class="listDivTopGETBottom"></div>
			
		</div>
		
		</a4j:outputPanel>
		
		
		
		<div id="main_x6">
		</div>
	</f:view>
	</body>
	</ui:composition>
