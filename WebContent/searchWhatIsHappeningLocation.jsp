<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/editProfile.js"></script>
	<script language="JavaScript" src="../js/twitterChannelNew.js"></script>
	<script language="JavaScript" src="../js/flexGeoPopup.js"></script>
	
	<script language="JavaScript">
		function closeWindowForAllButton()
		{
			parent.document.getElementById('geoPopUp').style.display='none';
			document.getElementById('geoPopUp').style.display='none';

			//used in reply.jsp(Started here)
				parent.document.getElementById('floatingDiv').style.height = 270;
				parent.document.getElementById('innerMainDiv').style.height = 250;
				parent.document.getElementById('frame').style.height = 200;
			//used in reply.jsp(Ended here)
		}
		
	</script>
	
	<a4j:loadScript src="/js/custom-form-elements.js" />
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
	<tr>
	  	<td class="optiAlert" align="left" valign="middle" bgcolor="#FFA600"  height="30">
	  	<table border="0" cellpadding="0"  cellspacing="0">
	  		<tr>
	  			<td style="color: rgb(255, 255, 255); font-size: 20px; padding-left: 5px;" align="left">
	  				Search Location
	  			</td>
	  			<td>
	  				<img alt="alert" src="../images/Alert/closeButtonOrange.gif"
	  				 border="0" align="right" style="padding-right:1px; padding-top:3px; padding-bottom:3px; cursor: pointer;" 
	  					onclick="closeWindowForAllButton();"/>
	  			</td>
	  		</tr>
	  		
	  		<tr height="30" bgcolor="#D0D0D0">
	  			<td align="left" valign="middle" colspan="2">
	  				<table>
	  					<tr>
	  						<td>
	  							<font style="color: #EDEDED; padding-left: 5px;">For profile</font> 
					  		</td>
					  			<td align="left" valign="middle">
					  				<div id="geoLocatonPopupName">
					  				@#{twitterController.firstCustomerName}
					  				</div>
					  		</td>
	  					</tr>
	  				</table>
	  			</td>
	  		</tr>
		</table>
	  	</td>
	</tr>
  <tr>
  	<td valign="top" align="center">
  	<table width="0" border="0" align="left" style="padding-left:15px" bgcolor="#FFFFFF">
    
  	<tr>
  	<a4j:form id="searchLocation">
  	<td valign="top" align="left" colspan="3" class="edit_left_text" width="340" style="padding-bottom: 0px;">
  		
  			<div id="geoLocSWF" style="float:left;">
			  	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" 
						id="GeoRTO" width="100%" height="100%"
						codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
						<param name="movie" value="GeoRTO.swf" />
						<param name="quality" value="high" />
						<param name="bgcolor" value="#FFFFFF" />
						<param name="allowScriptAccess" value="sameDomain" />
						<embed 
							quality="high" bgcolor="#869ca7"
							name="GeoRTO"
							align="center" width="400" height="75"
							wmode="opaque"
							play="true"
							loop="false"
							allowScriptAccess="sameDomain"
							type="application/x-shockwave-flash"
							pluginspage="http://www.adobe.com/go/getflashplayer" id="flexEmbed">
						</embed>
				</object>
	   		</div>
	</td>
	</a4j:form>  	
  	</tr>
  	<tr>
<!--  	
	<td valign="top" align="left" class="edit_left_text"  width="80">
  	</td>
-->
  	<td  valign="top" align="left" class="closeOrangeTextAlert" style="padding-left:70px">
    			<a href="#">
				    <img src="../images/Alert/General/doneButton.gif" border="0" 
				    onclick="closeWindowForAllButton();"/>
				</a>
    </td>
  	<td valign="middle" align="right"  class="influAlert" width="80">
  	<a onclick="closeWindowForAllButton();"
  		href="#" class="closeOrangeTextAlert" 
  				style="color: #F2A413; text-decoration: none; padding-right: 10px;">CLOSE</a>
  		</td>
  	</tr>
	</table>
</td>
</tr>
</table>
</f:view>
</body>
	<script language="JavaScript">
		var str = location.href; 
		var pos = str.indexOf('faces');
		var sbStr =str.substr(0,pos-1);
		if(document.getElementById('flexEmbed') != null){
			document.getElementById('flexEmbed').src = "../flash/GeoRTO.swf?urlFromPage="+sbStr+"/GatewayServletLocation";
		}
		
	</script>
</ui:composition>

