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
	
	<a4j:loadScript src="/js/custom-form-elements.js" />
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
<table width="500" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
  	<table border="0" cellpadding="0"  cellspacing="0" width="500">
  		<tr height="35">
  			<td align="left" valign="middle" width="110">
  			<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
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
  <tr>
  	<td valign="top" align="center">
  	<table width="500" border="0" align="center" style="margin-top: 10px;">
    
  	<tr>
  	<td  class="influAlert" valign="middle" align="right" style="font-weight: bold;" width="80">
  	Location
  	</td>
  	<a4j:form id="searchLocation">
  	<td valign="top" align="left" class="edit_left_text" width="340" style="padding-bottom: 0px;">
  		
  			<h:inputText id="listname" style="width: 340px; height: 28px; background-image: none; 
  						border: 2px inset #6E7177; padding-left: 10px; 
  						font-size: 12px; color: #737883; font-weight: bold; padding-top: 3px;"
  						value="#{twitterController.searchGEOLocation}"/>
	</td>
		<td valign="top" align="left" class="edit_left_text" width="80">
			<a4j:commandButton 
						image="../images/searchButton.gif"
						oncomplete="parent.document.getElementById('GRButton5').click();"
						actionListener="#{twitterController.searchNearByGeoLocationByPlace}"/>
		</td>
	</a4j:form>  	
  	</tr>
  	<tr>
  		<td valign="top" align="left" class="edit_left_text"  width="80">
  		</td>
  		<td valign="top" align="left" class="edit_left_textN" style="color: #DBDBDB; padding-top: 0px; padding-left: 10px;" width="340">
  		Leave blank to just select nearby city
  		</td>
  		<td valign="top" align="left" class="edit_left_text" width="50">
  		</td>
  		
  	</tr>
  	<tr>
  	<td valign="top" align="left" class="edit_left_text"  width="80">
  		</td>
  	<td  valign="top" align="left" class="closeOrangeTextAlert">
  	
    			<a href="#" onclick="allClose();">
				    <img src="../images/Alert/General/doneButton.gif" border="0"
				    onmouseover="changeImage(this,'../images/Buttons/rollover/doneButtonRollover.gif');" 
					onmouseout="changeImage(this,'../images/Buttons/General/doneButton.gif');"/>
				</a>
    </td>
  	<td valign="middle" align="right"  class="influAlert" width="80">
  	<a onclick="allClose();" href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none; padding-right: 10px;">
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

	
	
</ui:composition>

