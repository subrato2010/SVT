<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:twt="http://richfaces.org/session-data-helper">
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../css/tagsupport.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/editProfile.js"></script>
	<script language="JavaScript" src="../js/twitterChannelNew.js"></script>
	<script language="JavaScript" src="../js/tagsupport.js"></script>
	<script language="JavaScript" src="/TWT/faces/a4j/g/3_3_2.SR1org/richfaces/renderkit/html/scripts/jquery/jquery.js"></script>	

	<f:view contentType="text/html">
		<div id="transParentDocDiv" class="transparentClass"
			style="filter: alpha(opacity = 40); -moz-opacity: 0.4; -khtml-opacity: 0.4; opacity: 0.4; position: absolute; background-color: #000000; display: none; width: 100%; height: 1000px;">
		<table width="100%" border="0" height="100%" style="">
			<tr>
				<td align="center" valign="middle"><img
					src="../images/indicator.gif" border="0" /></td>
			</tr>
		</table>
		</div>
		<a4j:outputPanel rendered="#{userProfileController.closable}">
			<script>
				//alert("needs to be closed...");
				//closeP();
				parent.location.href='twitterChannelOptimization.jsp';
				//parent.location.reload();
			</script>
		</a4j:outputPanel>
		<a4j:outputPanel rendered="#{!userProfileController.closable}">
			<div class="editPage" id="total"><h:form id="editProfile"
				enctype="multipart/form-data">
				<t:inputHidden value="#{userProfileController.completeFlag}" />
				<h:inputHidden value="#{backingBean.cityColor}" />
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0" align="center">
					<tr>
						<td valign="top" align="center" width="320">
						<div class="editPageLeft">
						<table width="320" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Name</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="name" value="#{userProfileController.userProfile.name}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; font-size: 12px;padding-left: 3px; color: rgb(125, 132, 139);background-color: #{backingBean.nameColor}" />
								<div style="font-weight: normal; width: 200px; color: #F17A4B;">
								<h:outputText value="#{backingBean.nameErrMsg}" /></div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Title</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="title" value="#{userProfileController.userProfile.title}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; font-size: 12px; color: rgb(125, 132, 139); padding-left: 3px;background-color: #{backingBean.titleColor}" />
								<div style="font-weight: normal; width: 200px; color: #F17A4B;">
								<h:outputText value="#{backingBean.titleErrMsg}" /></div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Company</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="company"
									value="#{userProfileController.userProfile.company}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);background-color: #{backingBean.companyColor}" />
								<div style="font-weight: normal; width: 200px; color: #F17A4B;">
								<h:outputText value="#{backingBean.companyErrMsg}" /></div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Work Address</td>
								<td class="edit_left_text" valign="top"><h:inputText
									id="adOne"
									value="#{userProfileController.userProfile.workAddressLine1}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);background-color: #{backingBean.workAddressColor}" />
								<div style="font-weight: normal; width: 200px; color: #F17A4B;">
								<h:outputText value="#{backingBean.workAddressErrMsg}" /></div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Address line1</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="adTwo"
									value="#{userProfileController.userProfile.workAddressLine2}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Address line2</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="adThree"
									value="#{userProfileController.userProfile.workAddressLine3}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">City</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="city" value="#{userProfileController.userProfile.city}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);background-color: #{backingBean.cityColor}" />
								<br />
								<font style="font-weight: normal" color="#F17A4B"> <h:outputText
									value="#{backingBean.cityErrMsg}" /> </font></td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">State</td>
								<td class="edit_left_text" align="left" valign="top">
								<table width="200" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top" align="left">
										
										<twt:menu id="state" value="#{userProfileController.userProfile.state }" 
										options="#{userProfileController.stateOptions }" paramName="vkstate"
										style="background-image: url('../images/stateBack.gif');"
										listStyle="width:200px;"
										optionStyle="min-width:162px;"
										/>		
										<!-- 
										<div class="fileinputs1">
										
										<t:selectOneMenu id="state"
											value="#{userProfileController.userProfile.state }"
											styleClass="state"
											onchange="selectedItem('editProfile:state', 'vkstate', this.value)">
											<f:selectItems value="#{userProfileController.stateOptions }" />
										</t:selectOneMenu>
										<div class="fakefile1"><input id="vkstate" type="text"
											class="vk_text"
											style="background-color: transparent; border-width: 0px; background-image: none; color: #7D848B; font-size: 10px; font-weight: bold; padding-bottom: 4px; padding-top: 2px;" />
										</div>
											<script>
												selectedItem('editProfile:state', 'vkstate', '');   
											</script>
										</div>
										 -->
										
										</td>
										<td align="right" class="edit_left_textZip" valign="top"></td>
										<td align="right" valign="top">
										</td>
									</tr>
								</table>
								</td>
							</tr>
							
							
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Zip
										Code</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText id="zip"
											value="#{userProfileController.userProfile.zipCode}"
											style="background-image: none; border-width: 2px; font-size: 12px; color: rgb(125, 132, 139); width: 78px; padding-left:3px; background-color: #{backingBean.zipColor}" />
										<div style="font-weight: normal; color: #F17A4B;"><h:outputText
											value="#{backingBean.zipErrMsg}" /></div></td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Email</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="email" value="#{userProfileController.userProfile.email}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Phone</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="phone" value="#{userProfileController.userProfile.phone}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Website</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="website"
									value="#{userProfileController.userProfile.website}"
									styleClass="edit_right_text"
									style="background-image: none; border-width: 2px; padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Logo</td>
								<td class="edit_left_text" align="left" valign="top">
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
											src="../images/browseBurtton.gif" width="90" height="28" /></td>
									</tr>
								</table>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Facebook</td>
								<td class="edit_left_text" align="left" valign="top"><t:inputText
									value="#{userProfileController.userProfile.facebook}"
									styleClass="edit_right_text"
									style="background-image:none;border-width:2px; font-size:12px;color:#7D848B; padding-left: 3px;"
									onblur="if(this.value.indexOf('http://')==-1){this.value='http://'+this.value};" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Twitter</td>
								<td class="edit_left_text" align="left" valign="top"><t:inputText
									value="#{userProfileController.userProfile.twitter}"
									styleClass="edit_right_text"
									style="background-image:none;border-width:2px; font-size:12px;color:#7D848B; padding-left: 3px;"
									onblur="if(this.value.indexOf('http://')==-1){this.value='http://'+this.value};" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Upload Photo</td>
								<td class="edit_left_text" align="left" valign="top">
								<div class="fileinputs"><t:inputFileUpload
									value="#{userProfileController.photoFile}" styleClass="file"
									storage="file"
									accept="image/jpg,image/jpeg,image/gif,image/png"
									onchange="document.getElementById('fk1').value = this.value;" />
								<div class="fakefile">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top" align="left"><input id="fk1"
											class="edit_right_file_browse" /></td>
										<td valign="top" align="left"><img
											src="../images/browseBurtton.gif" width="90" height="28" /></td>
									</tr>
								</table>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Username</td>
								<td class="edit_left_text" align="left" valign="top"><t:inputText
									value="#{userProfileController.userProfile.uid}"
									readonly="true" styleClass="edit_right_text"
									style="background-image:none;border-width:2px; padding-left: 3px; font-size:12px; color:#7D848B;background-color: #{backingBean.userNameColor}" />
								<div style="font-weight: normal; width: 200px; color: #F17A4B;">
								<h:outputText value="#{backingBean.userNameErrMsg}" /></div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Password</td>
								<td class="edit_left_text" align="left" valign="top">
								<h:inputSecret id="password" redisplay="true" 
									value="#{userProfileController.password}"
									validator="#{userProfileController.validatePassword}"
									styleClass="edit_right_text"
									style="background-image:none;border-width:2px; padding-left: 3px; font-size:12px;color:#7D848B;" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Retype Password</td>
								<td class="edit_left_text" align="left" valign="top">
								<h:inputSecret id="retypePassword" value="#{userProfileController.retypePassword}"
									styleClass="edit_right_text" validator="#{userProfileController.validateRetypePassword}" 
									style="background-image:none;border-width:2px; padding-left: 3px;font-size:12px;color:#7D848B; background-color: #{userProfileController.retypePasswordBackgroundColor}"/>
									
								<div style="font-weight: normal; width: 200px; color: #F17A4B;">
									<h:message for="password" styleClass="errMsg" />
								</div>
								</td>
							</tr>
						</table>
						</div>
						</td>
						<td valign="top" align="center" width="10">
						<div
							style="border-left: 1px solid #ECECEC; height: 1200px; margin-left: 2px; width: 2px;"></div>
						</td>
						<td valign="top" align="center" width="365">
						<div class="editPageRight">
						<table width="365" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td valign="top" align="left">
								<table width="365" cellpadding="0" cellspacing="0">
									<tr>
										<td align="right" valign="top" class="edit_left_textEPP"
											width="110"><font style="color: #FF0000;">*</font>Twitter
										Accounts<br />
										<font style="font-weight: normal">(Limit 5 accounts for
										a single product or brand)</font></td>
										<td align="left" valign="top" width="190">
											<h:inputText onkeypress="return checkKeycode(event);"
											id="twtAcc"
											value="#{userProfileController.userProfile.twitterAccountNameSelf}"
											styleClass="edit_right_textAdd"
											style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 213px; background-color: #{backingBean.twittAccCol}" />
										<div
											style="font-weight: normal; width: 200px; color: #F17A4B; font-size: 11px;"
											class="edit_left_textEPP"><h:outputText
											value="#{backingBean.twittAccErr}" /></div>
										</td>
										<td align="left" valign="top"><h:commandLink value="" 
											actionListener="#{userProfileButtonHandler.addTwitterAccountHandler}"
											style="text-decoration: none;">
											<img src="../images/addButton.gif" border="0" width="41" />
										</h:commandLink></td>
										<!-- onclick="javascript:if(!checkSpace(document.getElementById('editProfile:twtAcc').value)){return false};"  -->
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td valign="top" align="right">
								<div
									style="width: 250px; height: auto; float: right; margin-top: 2px; margin-bottom: 5px;">
								<a4j:repeat
									value="#{userProfileController.userProfile.selfTwtAccounts}"
									var="editProf" rowKeyVar="i">
									<table width="252" border="0" cellspacing="0" cellpadding="0">
										<tr height="20">
											<td width="12"><h:commandLink value=""
												actionListener="#{userProfileButtonHandler.removeTwitterAccount}"
												style="text-decoration: none;">
												<f:attribute name="twitterId"
													value="#{editProf.twitterAccountId}" />
												<img src="../images/smallClose.PNG" border="0" />
											</h:commandLink></td>
											
											<a4j:outputPanel
												rendered="#{!(editProf.accessToken == null) and !(editProf.accessToken eq '')}">
												<td width="20"><img src="../images/selectCheck.gif"
													border="0" /></td>
												<td class="edit_left_textGreen" valign="top" align="left"
													width="120">
												<div class="mailAcc1" style="width: 110px; overflow: hidden;">
												@#{editProf.twitterUsername}</div>
												</td>
											</a4j:outputPanel>
											
											<a4j:outputPanel rendered="#{(editProf.accessToken == null) ||(editProf.accessToken eq '')}">
												<td width="20"><img src="../images/selectCheck1.gif"
													border="0" /></td>
												<td class="edit_left_textGreen" valign="top" align="left"
													width="120">
												<div class="mailAcc1"
													style="color: #6BA6D2; width: 110px; overflow: hidden;">
												@#{editProf.twitterUsername}</div>
												</td>
											</a4j:outputPanel>
											
											<td valign="top" align="right" width="120">
											
											<twt:menu value="#{editProf.brndProdInds}" 
   												paramName="vkb#{i}" strOptions="BRAND,PRODUCT,INDUSTRY"></twt:menu>
							
											</td>
										</tr>
										
										<a4j:outputPanel rendered="#{(editProf.accessToken == null) ||(editProf.accessToken eq '') }">
											<tr>
												<td class="edit_left_textGreen" valign="top" align="right" colspan="4" width="200"
												style="padding-right: 86px; color: #6BA6D2;">
												
												<h:commandLink value="SEND AUTHENTICATION" id="editProfile" 
												style="background-image: inherit; background: transparent; background-color: transparent;
														color: #6BA6D2; border-color: transparent;cursor: pointer; font-size: 11px;
														font-family: Verdana,Arial,Helvetica,sans-serif;text-align: left; text-indent: 0px;
														text-decoration: none;" 
														actionListener="#{twitterController.autenticateTwitterUser}" target="_parent">
														<f:param name="authName" value="#{editProf.twitterUsername}"/>
														<f:param name="from" value="editProfileAuth"/>
												</h:commandLink>
												</td>
											</tr>
										</a4j:outputPanel>
										
										<tr>
											<td colspan="5" height="10">
											<div style="border-bottom: 1px solid #DDDDDD;"></div>
											</td>
										</tr>
									</table>
								</a4j:repeat></div>
								</td>
							</tr>
							<ui:include src="/editProfileHandler.jsp">
								<ui:param name="competitorhandlername" value="Competitor #1" />
								<ui:param name="inputtext1" value="1" />
								<ui:param name="inputtext1value" value="#{userProfileController.userProfile.twitterCmptAccountName1}" />
								<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol}" />
								<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr}" />
								<ui:param name="addbuttonlistener" value="#{userProfileButtonHandler.validateTwitterAccountCmptHandler1}" />
								<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle1}" />
							</ui:include>
							<ui:include src="/editProfileHandler.jsp">
								<ui:param name="competitorhandlername" value="Competitor #2" />
								<ui:param name="inputtext1" value="2" />
								<ui:param name="inputtext1value" value="#{userProfileController.userProfile.twitterCmptAccountName2}" />
								<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol2}" />
								<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr2}" />
								<ui:param name="addbuttonlistener" value="#{userProfileButtonHandler.validateTwitterAccountCmptHandler2}" />
								<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle2}" />
							</ui:include>
							<ui:include src="/editProfileHandler.jsp">
								<ui:param name="competitorhandlername" value="Competitor #3" />
								<ui:param name="inputtext1" value="3" />
								<ui:param name="inputtext1value" value="#{userProfileController.userProfile.twitterCmptAccountName3}" />
								<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol3}" />
								<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr3}" />
								<ui:param name="addbuttonlistener" value="#{userProfileButtonHandler.validateTwitterAccountCmptHandler3}" />
								<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle3}" />
							</ui:include>
							<script>#{userProfileController.userProfile.JSObject}</script>
							<tr>
								<td valign="middle" align="left" bgcolor="#F2F2F2"
									class="edit_left_textEPPHD">Keyword Identification<br />
								<font style="font-weight: normal; font-size: 11px">(Limit
								10 keywords per Brand, Product, Industry separated by a comma)</font></td>
							</tr>
							<tr>
								<td height="8"></td>
							</tr>
							<tr>
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="top" align="right" class="edit_left_textEPP"
											width="90" style="padding-top: 11px;">Profile</td>
										<td valign="top" align="left" width="270"
											style="padding-top: 7px;">
											
										<twt:menu id="profile" value="#{userProfileController.userProfile.keyWordCompanyHandleName}"
											options ="#{userProfileController.userProfile.allCompanyHandlers}"
											style="background-image: url('../images/dropCombo.gif');width:264px; height:22px;"
											listStyle="width:264px;"
											optionStyle="width:242px;"
											onchange="populateKeyword('editProfile:brand','editProfile:product','editProfile:industry',this.value);
												setEnability('#{rich:clientId('brand')}', '#{rich:clientId('brandEnableButton')}', '#{rich:clientId('brandDisableButton')}', '#{rich:clientId('product')}', '#{rich:clientId('productEnableButton')}', '#{rich:clientId('productDisableButton')}', '#{rich:clientId('industry')}', '#{rich:clientId('industryEnableButton')}', '#{rich:clientId('industryDisableButton')}');"
										 />	
										<!-- 
										<div class="fileinputs1" style="width: 30px;">
											<t:selectOneMenu id="profile"
												value="#{userProfileController.userProfile.keyWordCompanyHandleName}"
												styleClass="state11"
												onchange="selectedItem('editProfile:profile', 'vkprofile', this.value); 
												populateKeyword('editProfile:brand','editProfile:product','editProfile:industry',this.value);
												setEnability('#{rich:clientId('brand')}', '#{rich:clientId('brandEnableButton')}', '#{rich:clientId('brandDisableButton')}', '#{rich:clientId('product')}', '#{rich:clientId('productEnableButton')}', '#{rich:clientId('productDisableButton')}', '#{rich:clientId('industry')}', '#{rich:clientId('industryEnableButton')}', '#{rich:clientId('industryDisableButton')}');"
												>
											<f:selectItems value="#{userProfileController.userProfile.allCompanyHandlers}" />
										</t:selectOneMenu>
										<div class="forcombo"><input id="vkprofile" type="text"
											value="#{userProfileController.userProfile.keyWordCompanyHandleName}"
											class="vk_text"
											style="background-color: transparent; border-width: 0px; padding-top: 2px; background-image: none; color: #7D848B; font-size: 10px; font-weight: bold; padding-bottom: 4px" />
										</div>
										<script>
										//sSelect();           
										</script></div>
										
										 -->	
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr height="35">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="middle" align="right" class="edit_left_textEPP" width="90">
											<font style="color: #FF0000;">*</font>Brand
										</td>
										<td valign="middle" align="left" width="190" class="edit_left_textEPP">
											<h:inputText id="brand" value="#{userProfileController.userProfile.keyWordIdentBrand}"
												styleClass="edit_right_textAdd"
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px; background-color: #{backingBean.color}" 
												onkeyup="keyWordValidator(this.value, '#{rich:clientId('brandEnableButton')}', '#{rich:clientId('brandDisableButton')}')" />
											<div style="font-weight: normal; width: 200px; color: #F17A4B;">
												<h:outputText value="#{backingBean.errMsg}" />
											</div>											
										</td>
										<td valign="middle" align="left" class="edit_left_textEPP">
											<h:commandLink value="" id="brandEnableButton"
												actionListener="#{userProfileButtonHandler.addKeyWordBrandHandler}"
												style="text-decoration: none;">
												<img src="../images/addButton.gif" border="0" width="41" />
											</h:commandLink>
											<h:commandLink disabled="true" id="brandDisableButton" style="text-decoration: none; display: none;">
												<img src="../images/addButtonDisable.gif" border="0" width="41" />
											</h:commandLink>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr height="32">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="middle" align="right" class="edit_left_textEPP" width="90">
											<font style="color: #FF0000;">*</font>Product
										</td>
										<td valign="middle" align="left" width="190" class="edit_left_textEPP">
											<h:inputText id="product" value="#{userProfileController.userProfile.keyWordIdentProd}"
												styleClass="edit_right_textAdd"
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px; background-color: #{backingBean.color1}" 
												onkeyup="keyWordValidator(this.value, '#{rich:clientId('productEnableButton')}', '#{rich:clientId('productDisableButton')}')" />
											<div style="font-weight: normal; width: 200px; color: #F17A4B;">
												<h:outputText value="#{backingBean.errMsg1}" />
											</div>
										</td>
										<td valign="middle" align="left" class="edit_left_textEPP">
											<h:commandLink value="" id="productEnableButton"
												actionListener="#{userProfileButtonHandler.addKeyWordProductHandler}"
												style="text-decoration: none;">
												<img src="../images/addButton.gif" border="0" width="41" />
											</h:commandLink>
											<h:commandLink disabled="true" id="productDisableButton" style="text-decoration: none; display: none;">
												<img src="../images/addButtonDisable.gif" border="0" width="41" />
											</h:commandLink>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr height="32">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="middle" align="right" class="edit_left_textEPP" width="90">
											<font style="color: #FF0000;">*</font>Industry
										</td>
										<td valign="middle" align="left" width="190" class="edit_left_textEPP">
											<h:inputText value="#{userProfileController.userProfile.keyWordIdentIndu}"
												id="industry" styleClass="edit_right_textAdd"
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px; background-color: #{backingBean.color2}" 
												onkeyup="keyWordValidator(this.value, '#{rich:clientId('industryEnableButton')}', '#{rich:clientId('industryDisableButton')}')" />
											<div style="font-weight: normal; width: 200px; color: #F17A4B;">
												<h:outputText value="#{backingBean.errMsg2}" />
											</div>
										</td>
										<td valign="middle" align="left" height="10">
											<h:commandLink value="" id="industryEnableButton"
												actionListener="#{userProfileButtonHandler.addKeyWordIndustryHandler}"
												style="text-decoration: none;">
												<img src="../images/addButton.gif" border="0" width="41" />
											</h:commandLink>
											<h:commandLink disabled="true" id="industryDisableButton" style="text-decoration: none; display: none;">
												<img src="../images/addButtonDisable.gif" border="0" width="41" />
											</h:commandLink>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<script>
								selectedItem('editProfile:profile', 'vkprofile', '#{userProfileController.userProfile.keyWordCompanyHandleName}'); 
								populateKeyword('editProfile:brand','editProfile:product','editProfile:industry','#{userProfileController.userProfile.keyWordCompanyHandleName}');							
							</script>
							<tr height="5">
								<td valign="middle" align="center">
								<div
									style="width: 330px; height: 3px; border-bottom: 1px solid #ECECEC;"></div>
								</td>
							</tr>
							<tr height="32">
								<td valign="middle" align="left">
									<div id="googleAnalyLeft" class="edit_left_textEPP">Google Analytics Account</div>
									<div id="googleAnalyright" class="edit_left_textEPP">
									<h:inputText value="#{userProfileController.userProfile.googleAnalyticsUsername}"
												id="google" styleClass="edit_right_textAdd"
												style="background-image:none; border-width:2px; color: rgb(125, 132, 139); font-size:12px;width: 220px;"/>
										<div style="font-weight: normal; width: 200px; color: #F17A4B;">
		          							<h:outputText value="" />
		          						</div>			
									</div>
								</td>
							</tr>
							<tr height="32">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="86"></td>
										<td valign="middle" align="right" class="edit_left_textEPP"
											width="153"><h:inputSecret redisplay="true"
											value="#{userProfileController.userProfile.googleAnalyticsPassword}"
											id="googlePwd"
											style="background-image:none; border-width:2px; color:#E1E2E5; font-size:12px;width: 144px;" />
										</td>
										<td valign="middle" align="left" class="edit_left_textEPP"
											colspan="2">
											<div id="googleLoader">
												<a4j:commandLink value=""
													reRender="gAccountList"
													actionListener="#{userProfileButtonHandler.authenticateGoogleAccount}"
													style="text-decoration: none;"  onclick="document.getElementById('googleLoader').style.display='none'; document.getElementById('inactiveButton').style.display='block';"
													oncomplete="document.getElementById('googleLoader').style.display='block'; document.getElementById('inactiveButton').style.display='none';">
													<img src="../images/authenticateButton.gif" border="0" style="padding-left: 2px;" />
												</a4j:commandLink>
										</div>
										<div id="inactiveButton" style="display: none;">
											<img src="../images/geopreloader2.gif"/>
										</div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr height="40">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="top" align="right" class="edit_left_textEPP"
											width="90"></td>
										<td valign="top" align="left" width="270">
										<h:inputHidden id="googletableid" value="#{userProfileController.userProfile.googleAnalyticsTableId}" />
										<h:inputHidden id="googleAcctname" value="#{userProfileController.userProfile.googleAnalyticsAccount}" />
										<div class="fileinputs1" style="padding-right: 15px;">
										
										<a4j:outputPanel id="gAccountList">
										
											<twt:menu value=""
												options="#{userProfileController.userProfile.allGoogleAccounts1}"
												style="background-image: url('../images/dropCombo.gif');width:264px; height:22px;"
												listStyle="width:264px;"
												optionStyle="width:242px;" 
												onchange="populateText('editProfile:googletableid',this.value);
												populateText('editProfile:googleAcctname',menus[this.id].label);"
											/>
										
											<!-- 
											<t:selectOneMenu id="googleList" immediate="true"
												value=""
												styleClass="state11"
												onchange="selectedItem('editProfile:googleList', 'vkgoogle', this.options[selectedIndex].text);
												populateText('editProfile:googletableid',this.value);
												populateText('editProfile:googleAcctname',this.options[selectedIndex].text);">
												<f:selectItems
													value="#{userProfileController.userProfile.allGoogleAccounts1}" />
											</t:selectOneMenu>
											<div class="forcombo"><input id="vkgoogle" type="text"
												value="#{userProfileController.userProfile.googleAccountSelected}"
												class="vk_text"
												style="background-color: transparent; border-width: 0px; padding-top: 2px; background-image: none; 
												color: #7D848B; font-size: 10px; font-weight: bold; padding-bottom: 4px; width:250px;" />
											</div>
											-->	
											
										</a4j:outputPanel></div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr height="5">
								<td valign="middle" align="center">
								<div
									style="width: 330px; height: 3px; border-bottom: 1px solid #ECECEC;"></div>
								</td>
							</tr>
							
							
							
							<tr height="32">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="middle" align="right" class="edit_left_textEPP"
											width="90" style="font-size: 11px;">Bit.ly Account</td>
										<td valign="bottom" align="left" width="153"
											class="edit_left_textEPP" colspan="2"><h:inputText
											value="#{userProfileController.userProfile.bitlyUsername}"
											id="bitlyId" styleClass="edit_right_textAdd"
											style="background-image:none; border-width:2px; color: rgb(125, 132, 139); font-size:12px;width: 144px;"/>
										
										</td>
										<td valign="middle" align="left" class="edit_left_textEPP"
											colspan="2"><h:commandLink value=""
											actionListener="#{bitlyController.authenticateBitlyAccount}"
											style="text-decoration: none;" target="_parent">
											<img src="../images/authenticateButton.gif" border="0"
												style="padding-left: 2px;" />
										</h:commandLink></td>
										
									</tr>
								</table>
								</td>
							</tr>
														
							<tr height="5">
								<td valign="middle" align="center">
								<div
									style="width: 330px; height: 3px; border-bottom: 1px solid #ECECEC;"></div>
								</td>
							</tr>	
							
							<tr>
								<td valign="middle" align="left">
								<table width="100%" cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td valign="top" align="right" class="edit_left_textEPP">
										<font style="color: #FF0000;">*</font>Improvement <br />
										Level</td>
										<td valign="top" align="left">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											class="edit_left_textEPP1">
											<a4j:repeat value="#{userProfileController.improvementLevel}"
												var="imprLevel" rowKeyVar="i">
												<tr>
													<td></td>
													<td valign="top" align="center" class="edit_left_textEPP2">
													<a4j:outputPanel
														rendered="#{((userProfileController.userProfile.improvementLevelId) eq (imprLevel.improvementLevelId))}">
														<input type="radio" id="chkOne" name="chk"
															value="#{imprLevel.improvementLevelId}"
															onclick="SingleSelect('chk',this);" class="styled"
															checked="checked" />
													</a4j:outputPanel> <a4j:outputPanel
														rendered="#{!((userProfileController.userProfile.improvementLevelId) eq (imprLevel.improvementLevelId))}">
														<input type="radio" id="chkOne" name="chk"
															value="#{imprLevel.improvementLevelId}"
															onclick="SingleSelect('chk',this);" class="styled" />
													</a4j:outputPanel></td>
													<td valign="top" align="left" style="">#{imprLevel.name}<br />
													<font class="edit_left_textEPP3">(#{imprLevel.description})</font>
													</td>
												</tr>
												<tr>
													<td colspan="2" height="6"></td>
												</tr>
											</a4j:repeat>
										</table>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="left" bgcolor="#F2F2F2"
									class="edit_left_textEPPHD">Reporting<br />
								<font style="font-weight: normal; font-size: 11px;">Enter
								up to 3 Email address you'd like to send daily and monthly
								activity reports.</font></td>
							</tr>
							<tr height="32">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="middle" align="right" class="edit_left_textEPP"
											width="90"><font style="color: #FF0000;">*</font>Email
										Address</td>
										<td valign="middle" align="left" width="190"
											class="edit_left_textEPP"><h:inputText
											value="#{userProfileController.userProfile.emailAddress}"
											styleClass="edit_right_textAdd"
											style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px; background-color: #{backingBean.mailCol}" />
										<div
											style="font-weight: normal; width: 200px; color: #F17A4B;">
										<h:outputText value="#{backingBean.mailErr}" /></div>
										</td>
										<td valign="middle" align="left" class="edit_left_textEPP">
										<h:commandLink value=""
											actionListener="#{userProfileButtonHandler.addReportingEmailAddress}"
											style="text-decoration: none;">
											<img src="../images/addButton.gif" border="0" width="41" />
										</h:commandLink></td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td valign="top" align="right"><a4j:outputPanel
									rendered="#{!(userProfileController.userProfile.reportingEmail1 eq '')}">
									<div
										style="width: 275px; height: auto; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="15" align="left" valign="top"><input
												type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
												checked="checked" onClick="SingleSelect('chkrpt',this);"
												class="styled" /></td>
											<td class="edit_left_textBlue" valign="top" align="left"
												width="120">
											<div class="mailAcc1" style="width: 170px; height: auto; word-wrap: break-word; white-space: pre-wrap;">#{userProfileController.userProfile.reportingEmail1}</div>
											</td>
											<td valign="top" align="right" class="edit_left_textGreen">
											<h:commandLink value="REMOVE"
												actionListener="#{userProfileButtonHandler.removeReportingEmailAddress}"
												style="text-decoration: none; color: #7EBE4C;">
												<f:attribute name="reportingEmail" value="1" />
											</h:commandLink></td>
										</tr>
									</table>
									</div>
								</a4j:outputPanel> <a4j:outputPanel
									rendered="#{!(userProfileController.userProfile.reportingEmail2 eq '')}">
									<div
										style="width: 275px; height:auto; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="15" align="left" valign="top"><input
												type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
												checked="checked" onClick="SingleSelect('chkrpt',this);"
												class="styled" /></td>
											<td class="edit_left_textBlue" valign="top" align="left"
												width="120">
											<div class="mailAcc1" style="width: 170px; height: auto; word-wrap: break-word; white-space: pre-wrap;">#{userProfileController.userProfile.reportingEmail2}</div>
											</td>
											<td valign="top" align="right" class="edit_left_textGreen">
											<h:commandLink value="REMOVE"
												actionListener="#{userProfileButtonHandler.removeReportingEmailAddress}"
												style="text-decoration: none; color: #7EBE4C;">
												<f:attribute name="reportingEmail" value="2" />
											</h:commandLink></td>
										</tr>
									</table>
									</div>
								</a4j:outputPanel> <a4j:outputPanel
									rendered="#{!(userProfileController.userProfile.reportingEmail3 eq '')}">
									<div
										style="width: 275px; height:auto; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="15" align="left" valign="top"><input
												type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
												checked="checked" onClick="SingleSelect('chkrpt',this);"
												class="styled" /></td>
											<td class="edit_left_textBlue" valign="top" align="left"
												width="120">
											<div class="mailAcc1" style="width: 170px; height: auto; word-wrap: break-word; white-space: pre-wrap;">#{userProfileController.userProfile.reportingEmail3}</div>
											</td>
											<td valign="top" align="right" class="edit_left_textGreen">
											<h:commandLink value="REMOVE"
												actionListener="#{userProfileButtonHandler.removeReportingEmailAddress}"
												style="text-decoration: none; color: #7EBE4C;">
												<f:attribute name="reportingEmail" value="3" />
											</h:commandLink></td>
										</tr>
									</table>
									</div>
								</a4j:outputPanel></td>
							</tr>
							<tr height="40">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="top" align="right" class="edit_left_textEPP"
											width="90">Timezone</td>
										<td valign="top" align="left" width="270">
										
										<twt:menu id="timezone"
											value="#{userProfileController.userProfile.timezone}"
											options="#{userProfileController.timeZoneOptions }"
											style="background-image: url('../images/dropCombo.gif');width:260px; height:22px; width:264px;"
											listStyle="width:264px; height:240px"
											optionStyle="width:232px;" 
											/>
										
										<!-- 
										<div class="fileinputs1"><t:selectOneMenu id="timezone"
											value="#{userProfileController.userProfile.timezone}"
											styleClass="timezone"
											onchange="selectedItem('editProfile:timezone','vktimezone',this.value);">
											<f:selectItems
												value="#{userProfileController.timeZoneOptions }" />
										</t:selectOneMenu>
										<div class="forcombo"><input id="vktimezone" type="text"
											value="#{userProfileController.userProfile.timezoneSelected}"
											class="vk_text"
											style="background-color: transparent; border-width: 0px; padding-top: 2px; background-image: none; color: #7D848B; font-size: 10px; font-weight: bold; width: 230px; padding-bottom: 3px;" />
										</div>
										</div>
										
										 -->
										</td>
									</tr>
								</table>
								</td>
							</tr>
<!-- 
							<tr>
								<td valign="middle" align="left" bgcolor="#F2F2F2"
									class="edit_left_textEPPHD">Vanity URL<br />
									<a4j:outputPanel rendered="#{(userProfileController.userProfile.vanityUrl eq '' || userProfileController.userProfile.vanityUrl == null)}">
										<font style="font-weight: normal; font-size: 11px;">
											You	have not added a vanity URL.
										</font>
									</a4j:outputPanel>
								</td>
							</tr>
							<tr height="32">
								<td valign="middle" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td valign="middle" align="right" class="edit_left_textEPP"
											width="90">Vanity URL</td>
										<td valign="middle" align="left" width="190"
											class="edit_left_textEPP"><h:inputText
											value="#{userProfileController.userProfile.vanityUrl}"
											class="edit_right_textAdd"
											style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 220px; background-color: #{backingBean.vanityMailCol}" />
										<div
											style="font-weight: normal; width: 200px; color: #F17A4B;">
										<h:outputText value="#{backingBean.vanityMailerr}" /></div>
										</td>
										<td valign="middle" align="left" class="edit_left_textEPP">
											<a4j:commandButton image="../images/addButton.gif" 
											style="width: 41;" actionListener="#{userProfileButtonHandler.addVanityURL}"/>
										</td>
									</tr>
								</table>
								</td>
							</tr>
-->
						</table>
						</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" valign="top" align="left" class="subcHd">
						Subscription Information</td>
					</tr>
					<tr bgcolor="#7EBE4C">
						<td valign="top" align="center" colspan="3">
						<table width="98%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="14" class="subc" valign="top" align="left"><img
									src="../images/selectGreen.gif" border="0" /></td>
								<td class="subc" valign="top" align="left">#{userProfileController.userProfile.subscriptionName}</td>
								<td rowspan="2" valign="middle" align="right" width="225">
								<a href="#" onclick="parent.document.getElementById('floatingDivR').style.display='none'; parent.document.getElementById('GRButton6').click();"> <img
									src="../images/managesubscriptionButton.gif" border="0" /> </a></td>
							</tr>
							<tr>
								<td width="14" class="subc" valign="top" align="left"><img
									src="../images/selectGreen.gif" border="0" /></td>
								<td class="subc" valign="top" align="left">#{userProfileController.userProfile.subscriptionDesc}</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left" colspan="3">
						<table width="200" border="0">
							<tr>
								<td valign="middle" align="left" width="200"><h:commandLink
									value="" actionListener="#{userProfileController.saveProfile}"
									style="text-decoration: none;">
									<img src="../images/save_changes_btn.gif" border="0"
										onmouseover="this.src='../images/save_changes_btnRollover.gif'"
										onmouseout="this.src='../images/save_changes_btn.gif'" />
									<f:param name="closeProfilePopup" value="yes" />
								</h:commandLink></td>
								<td class="edit_left_text1" align="left" width="500"
									style="padding-left: 10px">or</td>
								<td style="padding-top: 7px;"><a href="#"
									onclick="parent.document.getElementById('floatingDivR').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none'; parent.document.getElementById('backDrop').style.display='none';"
									style="text-decoration: none; padding-top: 5px;"> <font
									class="edit_left_text1"
									style="color: #7AC142; font-size: 11px;">CANCEL</font> </a></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			</h:form></div>
		</a4j:outputPanel>
		<h:inputHidden value="#{twitterController.totalClicked}" />
	</f:view>
</ui:composition>
