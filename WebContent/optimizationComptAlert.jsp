<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
     <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/popup.css" rel="stylesheet" type="text/css" />
<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
  <tr>
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0">
  	<font style="color: #EDEDED; padding-left: 20px;">For profile</font> <font style="color: #8D8D8D;">@username</font></td>
  </tr>
    <tr>
  	<td height="10"></td>
  </tr>
    <tr>
  	<td class="optiAlert1" align="center" valign="middle">Congratulations!</td>
  </tr>
    <tr>
  	<td class="optiAlert2" align="center" valign="middle">You've optimized your profile successfully.</td>
  </tr>
  <tr>
  	<td align="center" valign="middle">
  	<a onclick="parent.location.reload(); parent.document.getElementById('floatingDiv2').style.display='none'; parent.document.getElementById('backDrop').style.display='none';" href="#" class="optiAlert3" style="color: #55A618; text-decoration: none; padding-left:350px">
  	CLOSE
  	</a>
  	</td>
  </tr>


</table>
</ui:composition>
