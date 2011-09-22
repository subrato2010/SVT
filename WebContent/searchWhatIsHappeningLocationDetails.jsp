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
	
	
	<script language="JavaScript">
		function init() {
			var str = location.href; 
			var pos = str.indexOf('faces');
			var sbStr =str.substr(0,pos-1);
			var	locName = document.getElementById('locForTweet').value;
			document.getElementById('flexEmbedList').src = "../flash/NearByList.swf?locName="+locName+"&amp;locationNameFromList="+sbStr+"/GatewayServletLocation";
		}
		function viewFlexLocationList() {
			document.getElementById('geoNearbyListPopUp').style.display='block';
			document.getElementById('flexEmbedList').style.height=300;
			document.getElementById('flexEmbedList').style.width=300;
			init();
			
		}
		function setLocationNameToComponetFromList(str) {
			parent.document.getElementById('getLocFromFlex').innerHTML = str;
			parent.document.getElementById('locForTweet').value = str;
			//parent.document.getElementById('objAdd').innerHTML = str;
			parent.document.getElementById('geoNearbyListPopUp').style.display='none';
		}
	</script>
	
	<a4j:loadScript src="/js/custom-form-elements.js" />
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
	
  <tr>
  	<td valign="baseline" align="left">
  	<table width="100%" border="0" align="left" height="100%">
    
  	<tr>
  	
  	<td valign="top" align="left" colspan="3" class="edit_left_text" width="340" style="padding-bottom: 0px;">
  		
  			<div id="geoLocListSWF" style="float:left;">
			  	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" 
						id="NearByList" width="100%" height="100%"
						codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
						<param name="movie" value="NearByList.swf" />
						<param name="quality" value="high" />
						<param name="bgcolor" value="#FFFFFF" />
						<param name="allowScriptAccess" value="sameDomain"/>
						<param name="loc" id="locID" value="CA"/>
						<embed 
							quality="high" bgcolor="#869ca7"
							name="NearByList"
							align="center" width="300" height="300"
							wmode="opaque"
							play="true"
							loop="false"
							allowScriptAccess="sameDomain"
							type="application/x-shockwave-flash"
							pluginspage="http://www.adobe.com/go/getflashplayer" id="flexEmbedList">
						</embed>
				</object>
	   		</div>
	</td>
	 	
  	</tr>
  	<tr>
  	<td valign="middle" align="right"  class="influAlert" width="80">
  	<a onclick="parent.document.getElementById('geoNearbyListPopUp').style.display='none';" 
  	href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none; padding-right: 10px;">
  		CLOSE
  		</a>
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
	var locName;
	
	if(document.getElementById('locForTweet') == null)
		locName = "";
	else
		locName = document.getElementById('locForTweet').value;
	if(document.getElementById('flexEmbedList') != null){
		document.getElementById('flexEmbedList').src = "../flash/NearByList.swf?locName="+locName+"&amp;locationNameFromList="+sbStr+"/GatewayServletLocation";
	}

</script>		

</ui:composition>

