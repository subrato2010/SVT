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
	<script language="JavaScript" src="../js/all.js" />
	<script language="JavaScript">
      function closeP(){
      var bd = parent.document.getElementById("floatingDiv");
      bd.style.display = "none";
      var bd = parent.document.getElementById("backDrop");
      bd.style.display = "none";
      }
   </script>

</head>
<body>
<f:view>
	
		
			
				<table width="50%" height="70%" border="0" cellpadding="0" cellspacing="0">
					
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px">Logo</td>
								<td class="edit_left_text" align="left">
								<div class="fileinputs"><t:inputFileUpload
									value="#{userProfileController.logoFile}" styleClass="file"
									storage="file"
									accept="image/jpg,image/jpeg,image/gif,image/png"
									onchange="document.getElementById('fk').value = this.value;" />
								<div class="fakefile">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top" align="left"><input id="fk"
											class="edit_right_file_browse" /></td>
										<td valign="top" align="left"><img
											src="../images/browseBurtton.gif" /></td>
									</tr>
								</table>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<table width="200" border="0">
							<tr>
							<td valign="middle" align="left" width="200">
							
                          		<img src="../images/save_changes_btn.gif" border="0"  
                          			 onmouseover="this.src='../images/save_changes_btnRollover.gif'"
                              		 onmouseout="this.src='../images/save_changes_btn.gif'"/>
                        
							
							</td>
							<td class="edit_left_text1" align="left" width="500" style="padding-left:10px">
							or 
							</td>
							<td style="padding-top: 7px;">
								<a href="#" onclick="closeP(); parent.location.reload();" style="text-decoration: none; padding-top: 5px;">
	                               <font class="edit_left_text1" style="color: #7AC142; font-size: 11;">CANCEL</font>
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
