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
	<link href="../css/twt.css" rel="stylesheet" type="text/css" />
	<link href="../css/tagsupport.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js" />
	<script language="JavaScript" src="../js/tagsupport.js"></script>
	<script language="JavaScript" src="/TWT/faces/a4j/g/3_3_2.SR1org/richfaces/renderkit/html/scripts/jquery/jquery.js"></script>
	
	<a4j:form id="missingBio" style="margin: 0px; padding: 0px;">
		<table width="410" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0" height="30">
					<table cellpadding="0" cellspacing="0" border="0" width="370">
						<tr height="35">
							<td align="left" valign="middle">
								<font style="color: #EDEDED; padding-left: 20px; width: 110px;">For profile</font>
							</td>
							
							<td align="left" valign="middle" width="260">
								<div class="fileinputs1" style="width: 30px; color: #7D848B;">
             						<twt:menu id="inflalertlist" value="#{popupController.firstTwitterAccount}" 
             							paramName="selectedProfileForBio"        					
										options="#{popupController.accountsMissingBio}" 
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
					<table width="300" cellpadding="0" cellspacing="0" border="0">
						<tr height="30">
							<td valign="middle" colspan="2" align="left"
								class="missingBackground" width="300">ADD YOUR BIO</td>
						</tr>
						<tr>
							<td valign="top" align="left" colspan="2">
								<table width="300" cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td valign="top" align="left">
											<textarea name="bioText" id="bioText" onkeydown="countBioLimitChars();" onkeyup="countBioLimitChars();" onfocus="if(this.value=='Tell something about yourself in less than 160 characters.') this.value='';countBioLimitChars();" onblur="if(this.value=='') this.value='Tell something about yourself in less than 160 characters.';">Tell something about yourself in less than 160 characters.</textarea>
										</td>
										<td valign="top" align="left">
										<div id="bioWords" class="tweet-counter">0/160</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="80">
				<td valign="middle" align="left">
					<table width="380" cellpadding="0" cellspacing="0" border="0" style="margin-left: 10px;">
						<tr>
							<td valign="bottom" align="left">
								<a4j:commandButton actionListener="#{popupController.updateUserProfileBio}" 
									image="../images/Alert/General/submitButtonOrange.gif" style="border: 0px;"
									onclick="parent.document.getElementById('GRButton').click();" 
									onmouseover="changeImage(this,'../images/Alert/Rollover/submitButtonOrangeRollover.gif');" 
						    		onmouseout="changeImage(this,'../images/Alert/General/submitButtonOrange.gif');">
								</a4j:commandButton>
								
						    </td>
							<td valign="bottom" align="right">
								<a onclick="parent.document.getElementById('floatingDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
									href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;">
									CLOSE
								</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
			
	</a4j:form>
</ui:composition>
