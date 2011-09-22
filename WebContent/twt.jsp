<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/profile.css" rel="stylesheet" type="text/css" />
    <link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
    <script language="JavaScript" src="../js/designMainScreen.js"></script>
    
    <script language="JavaScript">

	function authValidation1(str)  {
		if(str == false || str == 'false')
			var val = openPopup1('Alert !','../images/Alert/alertSign.gif', '#FEA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 150, 465, 270, 10, false, true, false, 'oauthAlert.jsp')
	}
	</script>
	<title>Setup| Optimizer for Twitter</title>
    <f:view>
   		<h:form>
	   		<div id="transParentDiv" class="transparentClass" style="filter:alpha(opacity=40);
		     -moz-opacity:0.4;
		     -khtml-opacity: 0.4;
		     opacity: 0.4;
		     position:absolute;
		     background-color: #000000;
		     display: none;width:100%; height:1000px;" >
		     </div>
   			<div class="page" id="pageT">
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" height="100%">
            	<tr>
                <td valign="top" align="center">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr>
							<td align="left" valign="top">
								<div class="mainBodyTopTotal">
									<a4j:include viewId="templates/twitterTemplates/topTemplateTwitter.jsp"/>
									
	                          	</div>
                            </td>
                        </tr>
                     </table>
                 </td>
                 </tr>
                 <tr>
                 	<td valign="top" align="center">
                 		<div class="TWTLandingPage"  style="height: 500px; padding-top: 0px;">
                 		</div>
                 	</td>
                 </tr>
                 <tr>
             		<td align="left" valign="bottom">
                 		<a4j:include viewId="templates/twitterTemplates/footer.jsp"/>
             		</td>
          </tr> 
                 
             </table>          
             </div>
             <h:inputHidden id="postToRTOP" value="#{userProfileController.postToRTOP}" />
          </h:form>
      </f:view>
	  

	  <script language="JavaScript">
      		if(#{userProfileController.userProfile.firstTimeLogin} == true){
      			// load createProfile.jsp
      			// make sure you update firstTimelogin field to false after "save Changes" operation.
       			openPopupR('Create Your Profile', '', '#E7E7E7', '#787E89', '*Required', 400, 3, 460, 800, 10, false, true, false, 'createProfile.jsp')
        		}else{
      		    // load twitterChannelOptimization.jsp
      		    location.href='twitterChannelOptimization.jsp';
      		}

      		//alert('validate credentials :'+'#{twitterController.validCredentials}');
      		//alert('OPen edit profile :'+'#{twitterController.openEditProfile}');
      		
      		if('#{twitterController.openEditProfile}' == 'createProfileAuth'){
     	   			authValidation1('#{twitterController.validCredentials}'); 
      		}     		
	  </script>
   </ui:composition>

	

