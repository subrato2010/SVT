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
	<a4j:outputPanel rendered="#{!userProfileController.closable}">
		<div class="editPage" id="total">
			<h:form id="editProfile" enctype="multipart/form-data">
			<t:inputHidden value="#{userProfileController.completeFlag}"/>
			<h:inputHidden value="#{backingBean.cityColor}"/>
				<table width="715" height="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top" align="center" width="320">
						<div class="editPageLeft">

						<table width="320" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Name</td>
								<td class="edit_left_text" align="left" valign="top">
								<h:inputText id="name" value="#{userProfileController.userProfile.name}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; font-size: 12px;padding-left: 3px; 
									color: rgb(125, 132, 139);background-color: #{backingBean.nameColor}" />
									
									<div style="font-weight: normal; width: 200px; color:#F17A4B;">
										<h:outputText value="#{backingBean.nameErrMsg}"/>
									</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px"  valign="top">Title</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="title" value="#{userProfileController.userProfile.title}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; font-size: 12px; 
									color: rgb(125, 132, 139); padding-left: 3px;background-color: #{backingBean.titleColor}" />
									
									<div style="font-weight: normal; width: 200px; color:#F17A4B;">
										<h:outputText value="#{backingBean.titleErrMsg}"/>
									</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Company</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="company"
									value="#{userProfileController.userProfile.company}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);background-color: #{backingBean.companyColor}"/>
									
									<div style="font-weight: normal; width: 200px; color:#F17A4B;">
										<h:outputText value="#{backingBean.companyErrMsg}"/>
									</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Work Address</td>
								<td class="edit_left_text" valign="top"><h:inputText id="adOne"
									value="#{userProfileController.userProfile.workAddressLine1}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);background-color: #{backingBean.workAddressColor}"/>
									
									<div style="font-weight: normal; width: 200px; color:#F17A4B;">
										<h:outputText value="#{backingBean.workAddressErrMsg}"/>
									</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Address line1</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="adTwo"
									value="#{userProfileController.userProfile.workAddressLine2}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" /></td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Address line2</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="adThree"
									value="#{userProfileController.userProfile.workAddressLine3}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" /></td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">City</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="city" value="#{userProfileController.userProfile.city}"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);background-color: #{backingBean.cityColor}"/>
									<br/>
									<font style="font-weight: normal" color="#F17A4B">
										<h:outputText value="#{backingBean.cityErrMsg}"/>
									</font>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right" 
									style="padding-right: 5px" valign="top">State</td>
								<td class="edit_left_text" align="left" valign="top">

								<table width="200" border="0" cellspacing="0" cellpadding="0">
									<tr>

										<td valign="top" align="left">
										<div class="fileinputs1">
										<t:selectOneMenu id="state"	value="#{userProfileController.userProfile.state }"
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
				                      </script></div>
										</td>

										<td align="right" class="edit_left_textZip" valign="top">Zip
										Code</td>
										<td align="right" valign="top">
										<h:inputText id="zip"
											value="#{userProfileController.userProfile.zipCode}" 
											style="background-image: none; border-width: 2px; font-size: 12px; color: rgb(125, 132, 139); 
												   width: 78px;background-color: #{backingBean.zipColor}" />
										
											<div style="font-weight: normal; color:#F17A4B;">
												<h:outputText value="#{backingBean.zipErrMsg}"/>
											</div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Email</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="email" value="#{userProfileController.userProfile.email}"
									required="true" requiredMessage="THIS IS NOT A VALID ENTRY"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" /></td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Phone</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="phone" value="#{userProfileController.userProfile.phone}"
									required="true" requiredMessage="THIS IS NOT A VALID ENTRY"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" /></td>
							</tr>

							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Website</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputText
									id="website"
									value="#{userProfileController.userProfile.website}"
									required="true" requiredMessage="THIS IS NOT A VALID ENTRY"
									class="edit_right_text"
									style="background-image: none; border-width: 2px; 
									padding-left: 3px;font-size: 12px; color: rgb(125, 132, 139);" /></td>
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
											src="../images/browseBurtton.gif" width="90" height="28"/></td>
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
									style="background-image:none;border-width:2px; font-size:14px;color:#7D848B; padding-left: 3px;"
									onblur="if(this.value.indexOf('http://')==-1){this.value='http://'+this.value};" />
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Twitter</td>
								<td class="edit_left_text" align="left" valign="top"><t:inputText
									value="#{userProfileController.userProfile.twitter}"
									styleClass="edit_right_text"
									style="background-image:none;border-width:2px; font-size:14px;color:#7D848B; padding-left: 3px;"
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
											src="../images/browseBurtton.gif"  width="90" height="28"/></td>
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
									style="background-image:none;border-width:2px; padding-left: 3px;
									font-size:12px; color:#7D848B;background-color: #{backingBean.userNameColor}" />
									
									<div style="font-weight: normal; width: 200px; color:#F17A4B;">
										<h:outputText value="#{backingBean.userNameErrMsg}"/>
									</div>
								</td>
							</tr>
							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Password</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputSecret
									id="password" value="#{userProfileController.password }"
									validator="#{userProfileController.validatePassword}"
									styleClass="edit_right_text"
									style="background-image:none;border-width:2px; padding-left: 3px;
									font-size:12px;color:#7D848B;" />
								</td>
							</tr>

							<tr>
								<td class="edit_left_text" align="right"
									style="padding-right: 5px" valign="top">Retype Password</td>
								<td class="edit_left_text" align="left" valign="top"><h:inputSecret
									id="retypePassword"
									value="#{userProfileController.retypePassword}"
									styleClass="edit_right_text"
									style="background-image:none;border-width:2px; 
									padding-left: 3px;font-size:12px;color:#7D848B;"
									validator="#{userProfileController.validateRetypePassword}" />
									<div style="font-weight: normal; width: 200px; color:#F17A4B;">
									<h:message for="password" styleClass="errMsg" />
									</div>
								</td>
							</tr>
						</table>

						</div>
						</td>
						<td valign="top" align="center" width="10">
							<div style="border-left: 1px solid #ECECEC; height: 1000px; margin-left: 2px; width: 2px;"></div>
						</td>
						<td valign="top" align="center" width="375">
						<div class="editPageRight">
							<table width="375" cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td valign="top" align="left">
									
										<table width="100%" cellpadding="0" cellspacing="0">
											<tr>
												<td align="right" valign="top" class="edit_left_textEPP" width="127">
												<font style="color: #FF0000;">*</font>Twitter Accounts<br />
												<font style="font-weight: normal">(Limit 5 accounts for a single product or brand)</font>
												</td>
												<td align="left" valign="top" width="190">
												<h:inputText id="twtAcc"
												class="edit_right_textAdd"  
											style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;
											background-color: #{backingBean.twittAccCol}" required="false" />
											<div style="font-weight: normal; width: 200px; color:#F17A4B; font-size: 11px;">
												<h:outputText value="#{backingBean.twittAccErr}"/>
											</div>
												</td>
												<td align="left" valign="top">
													<h:commandLink value="" style="text-decoration: none;" 
													actionListener="#{backingBean.validateTwitterAccountHandler}">
						                          			<img src="../images/addButton.gif" border="0" width="41"/>
						                          	</h:commandLink>
												</td>
												
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td valign="top" align="left">
										<a4j:repeat value="#{userProfileController.userProfile.selfTwtAccounts}" var="editProf" rowKeyVar="i">
											
											<div style="width:250px; height:20px; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 5px;">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr height="20">
													
													<td width="12"><img src="../images/smallClose.PNG" border="0" /></td>
													<td width="12"><img src="../images/selectCheck.gif" border="0" /></td>
													<td class="edit_left_textGreen" valign="top" align="left" width="100">
														<div class="mailAcc1">@#{editProf.twitterUsername}</div>
													</td>
													
													<td valign="top" align="right" width="120">
													<div class="fileinputs1Band">
													<select id="brand#{i}"	class="band" onChange="selectedBrand('brand#{i}', 'vkb#{i}', this.value)">
														<option value="Brand">BRAND</option>
														<option value="Product">PRODUCT</option>
														<option value="Industry">INDUSTRY</option>
			
													</select>
													<div class="fakefile1Band"><input id="vkb#{i}" type="text" value="BRAND"
														class="vk_text"   style="background-image: none; background-color: transparent; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;"/></div>
													</div>
													</td>
												</tr>
											</table>
											</div>
											
											
										</a4j:repeat>		
									</td>
								</tr>
								
								<ui:include src="/editProfileHandler.jsp">
										<ui:param name="competitorhandlername" value="Competitor #1"/>
										<ui:param name="inputtext1" value="1"/>				
										<ui:param name="inputtext1value" value="#{backingBean.twitterCmptAccountName1}"/>
										<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol}"/>
										<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr}"/>
										<ui:param name="addbuttonlistener" value="#{backingBean.validateTwitterAccountCmptHandler1}"/>
										<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle1}"/>
								</ui:include>
								<ui:include src="/editProfileHandler.jsp">
										<ui:param name="competitorhandlername" value="Competitor #2"/>
										<ui:param name="inputtext1" value="2"/>				
										<ui:param name="inputtext1value" value="#{backingBean.twitterCmptAccountName2}"/>
										<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol2}"/>
										<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr2}"/>
										<ui:param name="addbuttonlistener" value="#{backingBean.validateTwitterAccountCmptHandler2}"/>
										<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle2}"/>
								</ui:include>
								<ui:include src="/editProfileHandler.jsp">
										<ui:param name="competitorhandlername" value="Competitor #3"/>
										<ui:param name="inputtext1" value="3"/>				
										<ui:param name="inputtext1value" value="#{backingBean.twitterCmptAccountName3}"/>
										<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol3}"/>
										<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr3}"/>
										<ui:param name="addbuttonlistener" value="#{backingBean.validateTwitterAccountCmptHandler3}"/>
										<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle3}"/>
								</ui:include>
								
								<!--<tr>
									<td valign="top" align="left">
										<table width="100%" cellpadding="0" cellspacing="0" border="0">
											<tr>
												<td valign="top" align="right" class="edit_left_textEPP" width="127">
												<font style="color: #FF0000;">*</font>Competitor Twitter Accounts<br />
												<font style="font-weight: normal">(Limit 5)</font>
												</td>
												<td valign="top" align="left" width="190" style="padding-top:7px">
													<h:inputText value="" id="compTwtAcc"
												class="edit_right_textAdd"  
												style="background-image:none; border-width:2px; color:#7D848B; font-size:11px; 
												background-color: #{backingBean.compTwittAccCol}"
												/>
												
												<div style="font-weight: normal; width: 200px; color:#F17A4B; font-size:11px;">
													<h:outputText value="#{backingBean.compTwittAccErr}"/>
												</div>
												</td>
												<td valign="top" align="left" style="padding-top:6px">
												<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								
								<tr>
									<td valign="top" align="left">
										<a4j:repeat value="#{userProfileController.userProfile.compTwtAccounts}" var="editProf" rowKeyVar="i">
										<div style="width:250px; height:20px; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											
											<tr>
												<td width="100"></td>
												<td width="18"><img src="../images/smallClose.PNG" border="0" /></td>
												<td class="edit_left_textGreen" valign="top" align="left" width="120">
												
													<div class="mailAcc">@#{editProf.twitterUsername}</div>
												</td>
												<td valign="top" align="right" width="120">
												<div class="fileinputs1Band">
												<select id="brand2#{i}"	class="band" onChange="selectedBrand('brand2#{i}', 'vkb2#{i}', this.value)">
													<option value="Brand">BRAND</option>
													<option value="Product">PRODUCT</option>
													<option value="Industry">INDUSTRY</option>
		
												</select>
												<div class="fakefile1Band"><input id="vkb2#{i}" type="text" value="BRAND"
													class="vk_text"   style="background-image: none; background-color: transparent; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;"/></div>
												</div>
												</td>
											</tr>
											
											
										</table>
										</div>
										
										</a4j:repeat>
									</td>
								</tr>
						-->
								<tr>
									<td valign="middle" align="left"  bgcolor="#F2F2F2" class="edit_left_textEPPHD">
										Keyword
										Identification<br/><font style="font-weight: normal; font-size:11px">(Limit 5 keywords per Brand, Product, Industry separated by a comma)</font>
									</td>
								</tr>
								<tr>
									<td height="8"></td>
								</tr>
								<tr>
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="top" align="right" class="edit_left_textEPP" width="90" style="padding-top:11px;">
											Profile
											</td>
											<td valign="top" align="left" width="270" style="padding-top:7px;">
												<div class="fileinputs1" style="width: 30px;">
				                               		<t:selectOneMenu id="profile"	value="#{twitterAccountDTO.twitterUsername}"
														styleClass="state11" 
														onchange="selectedItem('editProfile:profile', 'vkprofile', this.value)">
														<f:selectItems value="#{userProfileController.allTwitterAccounts}"/>
													</t:selectOneMenu>
				            	                      <div class="forcombo" >
				                	                     <input id="vkprofile" type="text" value="Competitor #1" 
				                	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 2px; 
				                	                     		  background-image: none;color:#7D848B; font-size:10px; font-weight:bold; padding-bottom: 4px"/>
				                    	               </div>        
												      <script>
								                         //sSelect();           
								                      </script>
	                                   			</div>
											</td>
										</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td height="5">
									</td>
								</tr>
								<tr height="35">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="right" class="edit_left_textEPP" width="90">
												<font style="color: #FF0000;">*</font>Brand
											</td>
											<td valign="middle" align="left" width="190" class="edit_left_textEPP">
												<h:inputText
												id="brand" value="#{userProfileController.userProfile.keyWordIdentBrand}"
												class="edit_right_textAdd"  
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px;
												background-color: #{backingBean.color}"
												/>
												<div style="font-weight: normal; width: 200px; color:#F17A4B;">
													<h:outputText value="#{backingBean.errMsg}"/>
												</div>
											</td>
											<td valign="middle" align="left" class="edit_left_textEPP">
											<input type="image" src="../images/addButton.gif" border="0"  width="41" />
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
												<h:inputText id="product"
												value="#{userProfileController.userProfile.keyWordIdentProd}"
												class="edit_right_textAdd"  
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px;
												background-color: #{backingBean.color1}"
												/>
												<div style="font-weight: normal; width: 200px; color:#F17A4B;">
													<h:outputText value="#{backingBean.errMsg1}"/>
												</div>
											</td>
											<td valign="middle" align="left" class="edit_left_textEPP">
												<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
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
												<h:inputText value="#{userProfileController.userProfile.keyWordIdentIndu}" id="industry"
												class="edit_right_textAdd"  
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px;
												background-color: #{backingBean.color2}"
												/>
												<div style="font-weight: normal; width: 200px; color:#F17A4B;">
													<h:outputText value="#{backingBean.errMsg2}"/>
												</div>
											</td>
											<td valign="middle" align="left" class="edit_left_textEPP">
												<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
											</td>
										</tr>
									
									</table>
									
									</td>
								</tr>
								<tr>
									<td valign="middle" align="center" height="10">
									<div style="width: 330px; height: 3px; border-bottom: 1px solid #ECECEC;"></div>
									</td>
								</tr>
								
								
								
								<tr height="32">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="right" class="edit_left_textEPP" width="90" style="font-size: 10px;">
												<font style="color: #FF0000">*</font>Google Analytics Account
											</td>
											<td valign="middle" align="left" width="190" class="edit_left_textEPP" colspan="2">
												<h:inputText id="google"
												class="edit_right_textAddCP1"  
												style="background-image:none; border-width:2px; font-size:12px;
												background-color: white; width: 264px;"
												/>
												<div style="font-weight: normal; width: 200px; color:#F17A4B;">
													<h:outputText value=""/>
												</div>
											</td>
											
										</tr>
									
									</table>
									
									</td>
								</tr>
								<tr height="32">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="86"></td>
											<td valign="middle" align="right" class="edit_left_textEPP" width="153">
												<input type="Password" name="name" value="Password" class="edit_right_textAddCP1"
												style="background-image:none; border-width:2px; color: #E1E2E5; font-size:12px; width: 144px;" />
											</td>
											<td valign="middle" align="left" class="edit_left_textEPP" colspan="2">
												<img src="../images/authenticateButton.gif" border="0" style="padding-left: 2px;"/>
											</td>
											
										</tr>
									
									</table>
									</td>
								</tr>
								
								<tr height="40">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="top" align="right" class="edit_left_textEPP" width="90">
											
											</td>
											<td valign="top" align="left" width="270">
												<div class="fileinputs1" style="padding-right: 15px;">
	                                    			<t:selectOneMenu id="acc" value="abcd" 
	                                    				 styleClass="state11" onchange="selectedItem('editProfile:acc', 'vkacc', this.value)">
    	                                			<f:selectItem itemValue=" " />
        	                         				</t:selectOneMenu>
				            	                      <div class="forcombo" >
				                	                     <input id="vkacc" type="text" value="Choose an Account" 
				                	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 2px; 
				                	                     	       background-image: none;color:#7D848B; font-size:10px; font-weight:bold; padding-bottom: 4px;"/>
				                    	               </div>     
												      <script>
								                         //sSelect();           
								                      </script>
                                   				</div>
											</td>
										</tr>
									
									</table>
									
									</td>
								</tr>
								<tr height="5">
									<td valign="middle" align="center">
									<div style="width: 330px; height: 3px; border-bottom: 1px solid #ECECEC;"></div>
									</td>
								</tr>
								<tr>
									<td valign="middle" align="left">
										<table width="100%" cellpadding="0" cellspacing="0" border="0">
											<tr>
												<td valign="top" align="right" class="edit_left_textEPP">
													<font style="color: #FF0000;">*</font>Improvement <br/>Level
												</td>
												<td valign="top" align="left">
													<table width="100%" border="0" cellspacing="0" cellpadding="0"
														class="edit_left_textEPP1">
														<a4j:repeat value="#{userProfileController.improvementLevel}" var="imprLevel" rowKeyVar="i">
														<tr>
															<td>
															</td>
															<td valign="top" align="center" class="edit_left_textEPP2">
															<a4j:outputPanel rendered="#{((userProfileController.userProfile.improvementLevelId) eq (imprLevel.improvementLevelId))}">
															<input type="radio" id="chkOne" name="chk" value="#{imprLevel.improvementLevelId}" 
																   onClick="SingleSelect('chk',this);" class="styled"
																   checked="checked"/>
														    </a4j:outputPanel>

															<a4j:outputPanel rendered="#{!((userProfileController.userProfile.improvementLevelId) eq (imprLevel.improvementLevelId))}">
															<input type="radio" id="chkOne" name="chk" value="#{imprLevel.improvementLevelId}" 
																   onClick="SingleSelect('chk',this);" class="styled"
																   />
														    </a4j:outputPanel>


															</td>
															<td valign="top" align="left" style="">#{imprLevel.name}<br />
															<font class="edit_left_textEPP3">(#{imprLevel.description})</font></td>
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
									<td valign="middle" align="left"  bgcolor="#F2F2F2" class="edit_left_textEPPHD">
										Reporting<br />
										<font style="font-weight: normal; font-size: 11px;">Enter
										up to 3 Email address you'd like to send daily and monthly
										activity reports.</font>
									</td>
								</tr>
								
								<tr height="32">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="right" class="edit_left_textEPP" width="90">
												<font style="color: #FF0000;">*</font>Email Address
											</td>
											<td valign="middle" align="left" width="190" class="edit_left_textEPP">
												<h:inputText
												value="#{userProfileController.userProfile.emailAddress}" class="edit_right_textAdd"
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 220px;
												background-color: #{backingBean.mailCol}"
												/>
												<div style="font-weight: normal; width: 200px; color:#F17A4B;">
													<h:outputText value="#{backingBean.mailErr}"/>
												</div>
											</td>
											<td valign="middle" align="left" class="edit_left_textEPP">
												<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
											</td>
										</tr>
									
									</table>
									
									</td>
								</tr>
								<tr>
									<td valign="top" align="right">
										
											<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail1 eq '')}">
											<div style="width:250px; height:20px; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												
												<td width="15" align="left" valign="top">
												<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
													checked="checked" onClick="SingleSelect('chkrpt',this);"
												class="styled"/>
												</td>
												<td class="edit_left_textBlue" valign="top" align="left" width="120">
												
													<div class="mailAcc1">#{userProfileController.userProfile.reportingEmail1}</div>
												</td>
												<td valign="top" align="right">
												
												</td>
											</tr>
											
											</table>
											</div>
											</a4j:outputPanel>
											<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail2 eq '')}">
											<div style="width:250px; height:20px; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												
												<td width="15" align="left" valign="top">
												<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
														checked="checked" onClick="SingleSelect('chkrpt',this);"
														class="styled" />
												</td>
												<td class="edit_left_textBlue" valign="top" align="left" width="120">
												
													<div class="mailAcc1">#{userProfileController.userProfile.reportingEmail2}</div>
												</td>
												<td valign="top" align="right">
												
												</td>
											</tr>
											
											</table>
											</div>
											</a4j:outputPanel>
											<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail3 eq '')}">
											<div style="width:250px; height:20px; border-bottom: 1px solid #DDDDDD; float: right; margin-top: 2px; margin-bottom: 2px;">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												
												<td width="15" align="left" valign="top">
												<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
													checked="checked" onClick="SingleSelect('chkrpt',this);"
												class="styled" />
												</td>
												<td class="edit_left_textBlue" valign="top" align="left" width="120">
												
													<div class="mailAcc1">#{userProfileController.userProfile.reportingEmail3}</div>
												</td>
												<td valign="top" align="right">
												
												</td>
											</tr>
											
											</table>
											</div>
											</a4j:outputPanel>
										
									</td>
								</tr>
								
								
								<tr height="40">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="top" align="right" class="edit_left_textEPP" width="90">
											Timezone
											</td>
											<td valign="top" align="left" width="270">
												<div class="fileinputs1">
				                                    <t:selectOneMenu id="timezone" value="abcd" 
				                                    				 styleClass="timezone" onchange="selectedItem('editProfile:timezone','vktimezone',this.value);">	                                    				 
			    	                                <f:selectItems value="#{userProfileController.timeZoneOptions }" />
			        	                         	</t:selectOneMenu>
				            	                       <div class="forcombo">
				                	                     <input id="vktimezone" type="text" value="Select a timezone"  
				                	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 2px; 
				                	                     	background-image: none;color:#7D848B; font-size:10px; font-weight:bold; width:230px; padding-bottom: 3px;"/>
				                    	               </div>        
												</div>
											</td>
										</tr>
									
									</table>
									
									</td>
								</tr>
								
								<tr>
									<td valign="middle" align="left"  bgcolor="#F2F2F2" class="edit_left_textEPPHD">
										Vanity
										URL<br />
										<font style="font-weight: normal; font-size: 11px;">You have not added a vanity URL.</font>
									</td>
								</tr>
								
								
								<tr height="32">
									<td valign="middle" align="left">
									
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="right" class="edit_left_textEPP" width="90">
												Vanity URL
											</td>
											<td valign="middle" align="left" width="190" class="edit_left_textEPP">
												<h:inputText
												value="#{userProfileController.userProfile.vanityUrl}" class="edit_right_textAdd"
												style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 220px;
												background-color: #{backingBean.vanityMailCol}" 
												/>
												<div style="font-weight: normal; width: 200px; color:#F17A4B;">
														<h:outputText value="#{backingBean.vanityMailerr}"/>
													</div>
											</td>
											<td valign="middle" align="left" class="edit_left_textEPP">
												<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
											</td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
						</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" valign="top" align="left"  class="subcHd">
						Subscription Information
						</td>
						
					</tr>
					<tr bgcolor="#7EBE4C">
						<td valign="top" align="center" colspan="3">
						<table width="98%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="14" class="subc" valign="top" align="left"><img
									src="../images/selectGreen.gif" border="0" /></td>
								<td class="subc" valign="top" align="left">Free 30 day
								Trial - Completed</td>
								<td rowspan="2" valign="middle" align="center">
								<a href="http://terametric.recurly.com" target="_blank">
									<img src="../images/managesubscriptionButton.gif" border="0" />
								</a>
								</td>
							</tr>
							<tr>

								<td width="14" class="subc" valign="top" align="left"><img
									src="../images/selectGreen.gif" border="0" /></td>
								<td class="subc" valign="top" align="left">Monthly
								Subscription @ $499/mo. (12 months Subscription) - XX days
								remaining</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left" colspan="3">
						<table width="200" border="0">
							<tr>
							<td valign="middle" align="left" width="200">
							<h:commandLink value="" 
									actionListener="#{userProfileController.saveProfile}" 
									style="text-decoration: none;">
                          		<img src="../images/save_changes_btn.gif" border="0"  
                          			 onmouseover="this.src='../images/save_changes_btnRollover.gif'"
                              		 onmouseout="this.src='../images/save_changes_btn.gif'"/>
                          	</h:commandLink>
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
			</h:form>
		</div>
	</a4j:outputPanel>
	<a4j:outputPanel rendered="#{userProfileController.closable}">
		<script>
			parent.location.reload();
		</script>
	</a4j:outputPanel>
</f:view>
</body>
</ui:composition>
