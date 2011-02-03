
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:t="http://myfaces.apache.org/tomahawk">
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/profile.css" rel="stylesheet" type="text/css" />
    <link href="../css/popup.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
    <script language="JavaScript" src="../js/designMainScreen.js"/>	
	<script language="JavaScript">
			function CloseWindow(str) {
				if(str==false) {

				   var bd = parent.document.getElementById("floatingDiv1");
				   bd.style.display = "none";
				   var bd = parent.document.getElementById("backDrop");
				   bd.style.display = "none";
				   parent.location.reload();
				}
			} 
 	</script>
	<f:view>
	<body onload="CloseWindow(#{!replyTwitterDataController.closable});">
	<a4j:outputPanel rendered="#{!(replyTwitterDataController.closable)}">
   	<h:form id="reply">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<h:inputHidden value="#{replyTwitterDataController.twitterName}"/>
  <tr>
  	<td valign="top" align="center">
  	<table width="95%" border="0" align="center" style="margin-top: 10px;">
  		<tr>
  			<td></td>
  			<td colspan="2" class="influAlert2" align="left" valign="top">
  				<table border="0"  cellspacing="0" cellpadding="0" width="420">
			      <tr bgcolor="#f2f2f2">
				 	<td align="left" width="50"><img src="#{replyTwitterDataController.twitterImagePath}"/></td>
			 		<td align="left" width="340">
				 		<font style="font-weight: normal; color: blue; font-size: 14px;">
				 			#{replyTwitterDataController.twitterMsg}
				 		</font>
			 		</td>
				</tr>
                <tr>
              		<td valign="middle" align="right" colspan="2" height="40">
						<h:commandButton value="" id="reply" image="../images/sendTweetButton.gif"
										 actionListener="#{twitterController.sendReTweet}"
										 style="text-decoration: none;">
                        </h:commandButton>
				     </td>
                  </tr>
     		</table>
     	</td>
     </tr>
  <tr>
    <td class="closeOrangeTextAlert" valign="middle"></td>
  </tr>
  </table>
  </td>
  </tr>
</table>
</h:form>
</a4j:outputPanel>
</body>
</f:view>
</ui:composition>

