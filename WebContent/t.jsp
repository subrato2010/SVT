<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	<head>
	<title>:: twitter optimizer ::</title>
	
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<a4j:loadScript src="/js/custom-form-elements.js" />
	<script language="JavaScript" src="../js/popup.js" />

	</head>
	<script language="JavaScript">
      function closeP(){
      	var bd = parent.document.getElementById("floatingDiv");
      	bd.style.display = "none";
      	var bd = parent.document.getElementById("backDrop");
     	 bd.style.display = "none";
      }
      function sSelect()
      {
          var myselect=document.getElementById("createProfile:sel");
          for (var i=0; i &lt; myselect.options.length; i++)
          {
              if (myselect.options[i].selected == true){
                  document.getElementById("vk").value = myselect.options[i].text;
                  break;
              }
          }	
      }
      function selectedItem(listObjectname, inputObjectname, selectedValue)
      {
           var myselect=document.getElementById("createProfile:" + listObjectname);
          for (var i=0; i &lt; myselect.options.length; i++)
          {
              if (myselect.options[i].selected == true){
                  document.getElementById(inputObjectname).value = myselect.options[i].text;
                  break;
              }
          }
      }
      function selectedBrand(listObjectname, inputObjectname, selectedValue)
      {
           var myselect=document.getElementById(listObjectname);
          for (var i=0; i &lt; myselect.options.length; i++)
          {
              if (myselect.options[i].selected == true){
                  document.getElementById(inputObjectname).value = myselect.options[i].text;
                  break;
              }
          }
      }
   </script>
	<body>
	<f:view>
	<div class="listDivTopGET" id="list_x6" onmouseover="setInList(true);" onmouseout="setInList(false);">
						 <div class="listDivTopGETTop"></div>
						 <div class="listDivTopGETMiddle">
						
						 <table width="180" cellpadding="0" cellspacing="0" height="100%"
							style="margin-left: 10px;" border="0" align="left">
							<tr>
								<td valign="top" align="left">
								<a4j:repeat value="#{twitterController.geoLocationListOfHandler}"
												var="geoLocationList" rowKeyVar="i">
								
								<a4j:outputPanel rendered="#{i==0}">
								<table width="180" border="0" cellpadding="0" cellspacing="0" height="40">
								<tr>
									<td valign="middle" align="center" width="35"><input
										type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
										checked="checked" onclick="SingleSelect('chkrpt',this);"
										class="styled" /></td>
										<td valign="middle" align="left" class="alertSelect" width="145">#{geoLocationList}</td>
								</tr>
								</table>
								
								</a4j:outputPanel>
								<a4j:outputPanel rendered="#{!(i==0)}">
								<table width="180" border="0" cellpadding="0" cellspacing="0" height="40">
								<tr>
								<td valign="middle" align="center" width="35"><input
										type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
										onclick="SingleSelect('chkrpt',this);"
										class="styled" /></td>
										<td valign="middle" align="left" class="alertSelect" width="145">#{geoLocationList}</td>
								</tr>
								</table>
								
								</a4j:outputPanel>
								</a4j:repeat>
								</td>
							</tr>
						
								<tr>
									<td valign="top" align="left" colspan="2" class="closeOrangeText"
										height="40">
									<div
										style="width: 114px; padding-left: 4px; padding-bottom: 4px; padding-right: 4px; padding-top: 4px; border: 1px solid #77C442; margin-left: 8px;">
									<a href="#"
										style="font-family: Arial, Helvetica, sans-serif; font-size: 11px; color: #77C442; text-decoration: none;"
										onclick="parent.document.getElementById('list_x6').style.display='none'; openPopup('Search Locations', '', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 250, 450, 520, 240, 10, false, true, false, 'searchLocation.jsp');">
											SEARCH LOCATIONS</a>
										</div>
									</td>
								</tr>
						</table>
					</div>
					<div class="listDivTopGETBottom"></div>
					<div class="listBottomDiv"></div>
				</div>
				
				<div id="toggleTextGEO" style="display: none; width: 320px; height: 10px; border:1px solid #ffffff;  background-color: #969696;">
					 <div id="TGTOTAL">
					 <div id="TG" style="width: 280px; height: 10px; float: left;">
					 <input type="text" name="addlocation" id="addlocation" value="ADD YOUR LOCATION"
					 style="width: 260px; border:0px solid; padding-left:6px; background-image: none; background-color: #969696; color: #FFFFFF; font-family: Arial,Verdana,sans-serif; font-size: 9px; "
					 onclick="document.getElementById('TGTOTAL1').style.display='block'; document.getElementById('TGTOTAL').style.display='none';"/> 
					 </div>
					 <div id="TG1" style="float: right; width: 32px; height: 10px;">
					 	
					 	<div id="TG3" style="float: right; width: 16px; height: 10px;">
					 	<a href="#" onclick="toggleTextGEOOFF(); closeList('x6');"><img src="../images/GEOclose.gif" border="0" height="15"/></a>
					 	</div>
					 </div>
					 </div>
					 
					 <a4j:outputPanel rendered="#{twitterController.yourLocation eq 'GETTING YOUR LOCATION'}"> 
					 	<div id="TGTOTAL1" style="display: none; background-color: #969696; height: 15px; width: 320px; border: 0">
					 	<div id="TG" style="width: 260px; height: 15px; float: left;">
					 	<h:inputText value="GETTING YOUR LOCATION"
					 		style="height: 15px; width: 260px; border-right:0px solid; padding-left:6px; background-image: none; background-color: #969696; color: #FFFFFF; font-family: Arial,Verdana,sans-serif; font-size: 9px; " onfocus="toggleList3('x6');" onblur="toggleTextGEOOFF(); closeList('x6');  document.getElementById('TGTOTAL1').style.display='none';  document.getElementById('TGTOTAL').style.display='none';" 
					 		onclick="document.getElementById('TGTOTAL').style.display='none';"/>
					 	</div>
					 		<div id="TG4" style="float: right; width: 32px; height: 15px;">
					 		<div id="TG5" style="float: left; width: 16px; height: 15px;">
					 			<img src="../images/GEogetting.gif" border="0"/>
					 		</div>
					 		<div id="TG6" style="float: right; width: 16px; height: 15px;">
					 		<a href="#" onclick="toggleTextGEOOFF(); closeList('x6');">
					 			<img src="../images/GEOclose.gif" border="0"/>
					 		</a>
					 	</div>
					 		</div>
					 		</div>
					 	
					 </a4j:outputPanel> 
					 
					 
					 <a4j:outputPanel rendered="#{!(twitterController.yourLocation eq 'GETTING YOUR LOCATION')}"> 
					 	<div id="TGTOTAL1" style="display: none; height: 15px; width: 320px;  background-color:#ffffff; " >
					 	<div id="TG" style="width: 260px; height: 15px; float: left;">
					 	<h:inputText id="addlocation" value="FROM #{twitterController.yourLocation}"
					 		style="height: 15px; width: 260px; border:0px solid; background-color:#ffffff; border-right:0px solid; padding-left6px; background-image: none; color: #77C442; font-family: Arial,Verdana,sans-serif; font-size: 9px; " onfocus="toggleList3('x6');"  
					 		onclick="document.getElementById('TGTOTAL').style.display='none';"/>
					 	</div>
					 		<div id="TG4" style="float: right; width: 30px; height: 15px;">
					 	
					 	<div id="TG5" style="float: left; width: 12px; height: 15px;">
					 			<a href="#" onclick="toggleList3('x6');" style="cursor: hand;" onblur="closeList('x6'); document.getElementById('TGTOTAL1').style.display='none';  document.getElementById('TGTOTAL').style.display='block';">
					 			<img src="../images/geoWhiteDrop.gif" border="0" />
					 			</a>
					 		</div>
					 	<div id="TG6" style="float: right; width: 14px; height: 15px;">
					 		<a href="#" onclick="toggleTextGEOOFF(); closeList('x6');">
					 			<img src="../images/geoWhiteClose.gif" border="0" />
					 		</a>
					 	</div>
					 </div>
					 </div>	
					
					 </a4j:outputPanel>
					 </div>
					
					<div id="main_x6">
				</div>
	</f:view>
	</body>
	</ui:composition>
