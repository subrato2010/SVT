<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:twt="http://richfaces.org/session-data-helper">
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<link href="../css/tagsupport.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js"></script>
	<script language="JavaScript" src="../js/tagsupport.js"></script>	
	<script language="JavaScript" src="/TWT/faces/a4j/g/3_3_2.SR1org/richfaces/renderkit/html/scripts/jquery/jquery.js"></script>
	
	 <script>
		//<![CDATA[
		        var counter = 1;
		        var intervalID;

	            function updateProgress(i)
	             {
	                $('missingProfilePic:progressBar').component.setValue(counter*5);
	                if ((counter++)>20)
		            {
	                    clearInterval(intervalID);
	                }
	            }
		            
	            function startProgress()
	            {
           	 		counter = 1;
	                $('missingProfilePic:progressBar').component.enable();
	                $('missingProfilePic:progressBar').component.setValue(1);
	                intervalID = setInterval(updateProgress,100);

	            }

	            function checkContent(str)
	            {
	            	if(str.length > 0)
		            {
	            		var dot = str.lastIndexOf("."); 
	            		var ext = str.substr(dot+1).toLowerCase();

	            		if(ext == 'jpg' || ext == 'jpeg' || ext == 'bmp' || ext == 'png' || ext == 'gif')
	            		{
	            			document.getElementById('missingProfilePic:picUpdateButton').style.display = "block";
	            			document.getElementById('fileSelectDiv').innerHTML = "";
	            		}
	            		else
		            	{
			            	document.getElementById('fileSelectDiv').innerHTML = "Images must be of type GIF,JPG,PNG.";
		            	}
		            }	            	
	            }
		//]]> 
      </script>
	<h:form id="missingProfilePic" enctype="multipart/form-data">
	<table width="410" border="0" cellspacing="0" cellpadding="0" height="80%">
		<tr>
			<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"
				height="30">
			<table cellpadding="0" cellspacing="0" border="0" width="370">
				<tr height="35">
					<td align="left" valign="middle">
						<font style="color: #EDEDED; padding-left: 20px; width: 110px;">For profile</font>
					</td>
					<td align="left" valign="middle" width="260">
						
						<div class="fileinputs1" style="width: 30px; color: #7D848B;">							
             				<twt:menu id="inflalertlist" value="#{popupController.firstTwitterAccount}" 
             					paramName="selectedProfileForImg"             					
								options="#{popupController.accountsMissingProfPics}" 
								style="background-image: url('../images/dropCombo.gif');width:264px; height:22px;"
								listStyle="width:264px;"
								optionStyle="width:242px;">																			
							</twt:menu>
			            </div>			            					
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td valign="top" align="center">
				<table width="380" cellpadding="0" cellspacing="0" border="0">
					<tr height="30">
						<td valign="middle" colspan="2" align="left"
							class="missingBackground">ADD YOUR PICTURE</td>
					</tr>
					
					<tr>
						<td valign="top" align="left" width="80">
							<a4j:outputPanel id="bkgImageUpload">
								<div id="miss_cust_img">
									<img src="#{popupController.profileImageURL}" width="80px" height="85px"/>
								</div>
							</a4j:outputPanel>
						</td>
						<td valign="top" align="left" height="25">
						<table width="280" border="0" cellpadding="0" cellspacing="0"
							style="margin-left: 6px;">
							<tr>
								<td valign="top" align="left">
								<div class="fileinputs">
								<t:inputFileUpload value="#{popupController.userProfileImage}" styleClass="file"
									storage="file" accept="image/jpg,image/jpeg,image/gif,image/png"
									onchange="document.getElementById('fk1').value = this.value; checkContent(document.getElementById('fk1').value);" />
								<div class="fakefile">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top" align="left"><input id="fk1"
											class="edit_right_file_browse" style="width: 205px;" /></td>
										<td valign="top" align="left"><img
											src="../images/browseBurtton.gif" /></td>
									</tr>
								</table>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="top" align="left" class="missingUpload">UPLOAD<br />
									<rich:progressBar mode="client" id="progressBar"/>								
								</td>
							</tr>
							<tr>
								<a4j:outputPanel rendered="#{!(popupController.backgroundUpdate)}">
									<div class="missingUpload" id="fileSelectDiv" style="padding-left: 5px;"></div>
								</a4j:outputPanel>

								<a4j:outputPanel rendered="#{(popupController.backgroundUpdate)}">
									<div class="missingUpload" id="fileSelectDiv" 
										style="padding-left: 5px; color: #77C442;">Profile picture updated</div>
								</a4j:outputPanel>

								<div class="missingUpload" id="fileSelectDiv" style="padding-left: 5px;"></div>
								<td valign="top" align="left" class="missingMatter">Images	must be smaller than 700k. GIF,JPG,PNG.</td>
								
							</tr>
						</table>
						</td>
					</tr>
					<tr height="40">
						<td valign="middle" align="left" colspan="2">
						<table width="380" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td valign="bottom" align="left">
								
								
								<h:commandLink id="picUpdateButton" actionListener="#{popupController.uploadUserProfileImage}" style="display: none;">
									<img src="../images/Alert/updateButtonOrange.gif" border="0" style="margin-right: 5px; cursor: pointer;" 
									onclick="startProgress();clickLink('missingProfilePic:refreshImage')"/>
								</h:commandLink>
								
								<a4j:commandButton id="refreshImage" reRender="bkgImageUpload" style="visibility:hidden;"/>
								
								</td>
								<td valign="bottom" align="right"><a
									onclick="parent.document.getElementById('floatingDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none'; parent.document.getElementById('GRButton').click();"
									href="#" class="closeOrangeTextAlert"
									style="color: #F2A413; text-decoration: none;"> CLOSE </a></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
		
	</h:form>
</ui:composition>
