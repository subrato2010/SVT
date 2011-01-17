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


    <f:view>
   		<h:form>
   			<div class="page">
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
                 		<div class="TWTLandingPage">
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
          </h:form>
      </f:view>
	  

	  <script language="JavaScript">
      		if(#{userProfileController.userProfile.firstTimeLogin} == true){
      			// load createProfile.jsp
      			// make sure you update firstTimelogin field to false after "save Changes" operation.
       			openPopup('Create Your Profile',400, 3, 410, 800, 10, false, true, false, 'createProfile.jsp')
        		}else{
      		    // load twitterChannelOptimization.jsp
      		    location.href='twitterChannelOptimization.jsp';
      		}
      		
	  </script>
 </ui:composition>

	

