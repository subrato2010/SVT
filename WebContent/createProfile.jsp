<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
<link href="../css/profile.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<a4j:loadScript src="../js/custom-form-elements.js" />
<script language="JavaScript" src="../js/popup.js"></script>
<script language="JavaScript" src="../js/all.js"></script>
<script language="JavaScript" src="../js/editProfile.js"></script>
<script language="JavaScript" src="../js/twitterChannelNew.js"></script>

<script language="JavaScript">
	//<![CDATA[		           		
	    
		function closePopup12(str) {
			if(str == true || str == 'true')
				parent.location.href='./twt.jsp';
			else
				parent.location.href='../Logout';
		}      
		
	//]]>		
</script>

<f:view contentType="text/html">
	<a4j:outputPanel rendered="#{!userProfileController.closable}">
	<h:form id="createProfile" enctype="multipart/form-data">
			<t:inputHidden value="#{userProfileController.completeFlag}" />
			<h:inputHidden value="#{backingBean.cityColor}"/>
			<h:inputHidden value="#{twitterController.twtmessage}"/>
	<div class="createProfileTotal"	>
	  <table width="400" border="0" cellpadding="0" cellspacing="0" align="center">
		
<!--  ============================================ STEP 1 ============================================ -->		
		<tr>
			<td height="10" colspan="2" align="left" valign="top">
				<div class="createProfileTop">
				<div class="createProfileTop1"></div>
				<div class="createProfileTop2">
				<font class="createProfileTop2Green">STEP ONE</font><br/>
				<font class="createProfileTop2Gary">Validate your Contact Info</font>
				</div><div class="createProfileTop3"></div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="left" valign="top">
				<table width="400" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top" align="right" class="edit_left_text" style="padding-right:5px; width: 120px;">
							<font style="color: #FF0000;">*</font>Name
						</td>
						<td valign="top" align="left" class="edit_left_text" style="width: 268px;">
							<h:inputText id="name" value="#{userProfileController.userProfile.name}" 
						 		styleClass="edit_right_textCreateProfile"  
								 style="background-image: none; border-width: 2px; font-size: 12px;padding-left: 3px; width: 268px;;
								 color: rgb(125, 132, 139);background-color: #{backingBean.nameColor}" />
							<div style="font-weight: normal; width: 200px; color:#F17A4B;">
								<h:outputText value="#{backingBean.nameErrMsg}"/>
							</div>
						</td>
					</tr>
				</table>
			</td>
			</tr>		
		<tr>
	    	<td colspan="2" align="left" valign="top">
	    		<table width="400" border="0" cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td class="edit_left_text" align="right" style="padding-right:5px; width: 120px;">
	    					<font style="color: #FF0000;">*</font>Title
	    				</td>
	    				<td valign="top" align="left" class="edit_left_text">
	    					<h:inputText id="title" value="#{userProfileController.userProfile.title}" 
						 		styleClass="edit_right_textCreateProfile"  
						 		style="background-image: none; border-width: 2px; font-size: 12px; width: 268px;;
								color: rgb(125, 132, 139); padding-left: 3px;background-color: #{backingBean.titleColor}" />
								<div style="font-weight: normal; width: 200px; color:#F17A4B;">
									<h:outputText value="#{backingBean.titleErrMsg}"/>
								</div>
	    				</td>
	    			</tr>
	    		</table>
			</td>
	    </tr>		
		<tr>
			<td colspan="2" align="left" valign="top">
				<table width="400" border="0" cellpadding="0" cellspacing="0">
	    			<tr>
	    				<td class="edit_left_text" align="right" style="padding-right:5px; width: 120px;">
	    					Company
	    				</td>
	    				<td valign="top" align="left" class="edit_left_text">
	    					<h:inputText id="company" value="#{userProfileController.userProfile.company}" 
							 requiredMessage="Name can't be blank." styleClass="edit_right_textCreateProfile"  
							 style="background-image: none; border-width: 2px; font-size: 12px; width:267px;color: rgb(125, 132, 139); 
							 padding-left: 3px;" />
	    				</td>
	    			</tr>
	    		</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="left" valign="top">
				<div class="createProfileTop">
					<div class="createProfileTop1"></div>
					<div class="createProfileTop4">
						<font class="createProfileTop2Gary">Reporting</font>
						<br/>
						<font class="createProfileTop2Gary1">Enter upto 3 Email address you'd like to send daily and monthly <font style="padding-left:10px;">activity reports.</font></font>
					</div>
					<div class="createProfileTop3">
					</div>
				</div>			
			</td>
		</tr>			
		<tr>
			<td align="left" valign="top" colspan="2">
				<table width="400" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" valign="top" class="edit_left_textEPP"><font style="color: #FF0000; padding-left:19px;">*</font>Email Address<br /></td>
						<td align="right" valign="top" style="padding-right:4px;">
							<h:inputText id="email" value="#{userProfileController.userProfile.emailAddress}"
								styleClass="edit_right_textAdd"  
							    style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 223px; 
								background-color: #{backingBean.mailCol};"/>
							<br/>
							<div style="width:200px; font-weight: normal; float: left; text-align: left; padding-left: 15px;" class="edit_left_textGreen">
								<div style="font-weight: normal; color:#F17A4B; overflow: hidden; height: auto;">
									<h:outputText value="#{backingBean.mailErr}"/>
								</div>
							</div>
						</td>
						<td align="left" valign="top">
							<h:commandLink value="" 
								onmousedown="setScrollValue();"
								actionListener="#{userProfileButtonHandler.addReportingEmailAddress}" 
								style="text-decoration: none;">
                          			<img src="../images/addButton.gif"	                          			 
	                          			border="0" 
	                          			width="41"/>
                          	</h:commandLink>
						</td>
					</tr>
				</table>
			 </td>
		</tr>
		<tr><td></td>
			<td colspan="2" align="right" valign="top">
				<table width="270" border="0" cellspacing="0" cellpadding="0">
					<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail1 eq '')}">
						<tr>
							<td class="edit_left_textBlue" valign="top" align="left">
								<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
									   checked="checked" onClick="SingleSelect('chkrpt',this);"
									   class="styled"/>
							</td>
							<td class="edit_left_textBlue" valign="top" align="left">
							    <div style="padding-left: 2px; overflow: hidden; height: auto; width: 200px;">#{userProfileController.userProfile.reportingEmail1}</div>
							</td>
							<td valign="top" align="right" class="edit_left_textGreen">
								<h:commandLink value="REMOVE" 
											actionListener="#{userProfileButtonHandler.removeReportingEmailAddress}" 
											style="text-decoration: none; color: #7EBE4C;">
											<f:attribute name="reportingEmail" value="1" /> 
			                     </h:commandLink>
							</td>
						</tr>
						<tr>
							<td colspan="3" height="10">
								<div style="border-bottom: 1px solid #DDDDDD;"></div>
							</td>	
						</tr>
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail2 eq '')}">
						<tr>
							<td class="edit_left_textBlue" valign="top" align="left">
								<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
									   checked="checked" onClick="SingleSelect('chkrpt',this);"
									   class="styled"/>
							</td>
							<td class="edit_left_textBlue" valign="top" align="left">
							    <div style="padding-left: 2px; overflow: hidden; height: auto; width: 200px;">#{userProfileController.userProfile.reportingEmail2}</div>
							</td>
							<td valign="top" align="right" class="edit_left_textGreen">
								<h:commandLink value="REMOVE" 
											actionListener="#{userProfileButtonHandler.removeReportingEmailAddress}" 
											style="text-decoration: none; color: #7EBE4C;">
											<f:attribute name="reportingEmail" value="2" /> 
			                     </h:commandLink>
							</td>
						</tr>
						<tr>
							<td colspan="3" height="10">
								<div style="border-bottom: 1px solid #DDDDDD;"></div>
							</td>	
						</tr>
					</a4j:outputPanel>
					<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail3 eq '')}">
						<tr>
							<td class="edit_left_textBlue" valign="top" align="left">
								<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
									   checked="checked" onClick="SingleSelect('chkrpt',this);"
									   class="styled"/>
							</td>
							<td class="edit_left_textBlue" valign="top" align="left">
							    <div style="padding-left: 2px; overflow: hidden; height: auto; width: 200px;">#{userProfileController.userProfile.reportingEmail3}</div>
							</td>
							<td valign="top" align="right" class="edit_left_textGreen">
								<h:commandLink value="REMOVE" 
											actionListener="#{userProfileButtonHandler.removeReportingEmailAddress}" 
											style="text-decoration: none; color: #7EBE4C;">
											<f:attribute name="reportingEmail" value="3" /> 
			                     </h:commandLink>
							</td>
						</tr>
						<tr>
							<td colspan="3" height="10">
								<div style="border-bottom: 1px solid #DDDDDD;"></div>
							</td>	
						</tr>
					</a4j:outputPanel>
				</table>
			</td>
		</tr>
		<tr height="30">
			<td colspan="2" align="left" valign="top">
				<table width="400" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top" align="right" class="edit_left_textEPP" width="130">
							<font style="color: #FF0000; padding-right: 6px;"></font>Timezone
						</td>
						<td valign="top" align="left" class="edit_left_textEPP">
							<div class="fileinputs1choose">
							<t:selectOneMenu id="timezone" value="#{userProfileController.userProfile.timezone}" 
	                         styleClass="timezone" onchange="selectedItem('createProfile:timezone','vktimezone',this.value);">	                                    				 
    	            		<f:selectItems value="#{userProfileController.timeZoneOptions }" />
        	        		</t:selectOneMenu>
            	    		<div class="forcombo">
                	   			<input id="vktimezone" type="text" value="#{userProfileController.userProfile.timezoneSelected}" 
                	    	   class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 3px; 
                	           background-image: none;color:#7D848B; font-size:10px; font-weight:bold; width:230px;"/>
                   			 </div>       
							</div>
						</td>
					</tr>
				
				</table>
			</td>
		</tr>
<!--  ============================================ STEP 2 ============================================ -->				
			<tr>
				<td height="10" colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1"></div>
						<div class="createProfileTop2">
							<font class="createProfileTop2Green">STEP TWO</font>
							<br/>
							<font class="createProfileTop2Gary">Setup your Twitter Accounts</font>
						</div>
						<div class="createProfileTop3"></div>
					</div>
				</td>
			</tr>
			<tr>
				<td align="left" valign="top" colspan="2">
				<table width="400" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" valign="top" class="edit_left_textEPP" style="padding-left:13px;">
							<font style="color: #FF0000;">*</font>Twitter Accounts<br />
							<font style="font-weight: normal">(Limit 5)</font>
						</td>
						<td align="right" valign="top">
							<h:inputText id="twtAcc" value="#{userProfileController.userProfile.twitterAccountNameSelf}"
								styleClass="edit_right_textAdd"  
								style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 212px;margin-right:4px;
								background-color: #{backingBean.twittAccCol}" required="false"/>
							<br/>
							<div style="width:200px; font-weight: normal; float: left; text-align: left; padding-left: 5px;" class="edit_left_textGreen">
								<div style="font-weight: normal; color:#F17A4B; overflow: hidden; height: auto;">
									<h:outputText value="#{backingBean.twittAccErr}"/>
								</div>
							</div>
						</td>
						<td align="left" valign="top">
							<h:commandLink value="" 
								onmousedown="setScrollValue();"
								actionListener="#{userProfileButtonHandler.addTwitterAccountHandler}" 
								style="text-decoration: none;">
                          			<img src="../images/addButton.gif"	                          			 
	                          			border="0" 
	                          			width="41"/>
                          	</h:commandLink>
						</td>					
					</tr>
				</table>
			  	</td>
			</tr>
			<tr>
				<td align="right" valign="top" colspan="2">
				<a4j:repeat value="#{userProfileController.userProfile.selfTwtAccounts}" var="editProf" rowKeyVar="i">
				<table width="250" border="0" cellspacing="0" cellpadding="0">
					<tr>
							<td width="20">
								  <h:commandLink value="" 
										actionListener="#{userProfileButtonHandler.removeTwitterAccount}" 
										style="text-decoration: none;">
										<f:attribute name="twitterId" value="#{editProf.twitterAccountId}" /> 
		                          			<img src="../images/smallClose.PNG" border="0"/>
		                          	</h:commandLink>
								</td>
							<a4j:outputPanel rendered="#{!(editProf.accessToken == null)}">
								<td width="20"><img src="../images/selectCheck.gif" border="0" /></td>
								<td class="edit_left_textGreen" valign="top" align="left" width="100">
									<div style="padding-right: 2px; width: 90px; height: auto; overflow: hidden;">@#{editProf.twitterUsername}</div>
								</td>
							</a4j:outputPanel>
							
							<a4j:outputPanel rendered="#{(editProf.accessToken == null)}">
								<td width="20"><img src="../images/selectCheck1.gif" border="0" /></td>
								<td class="edit_left_textGreen" valign="top" align="left" width="100">
									<div style="padding-right: 10px; width: 90px; height: auto; overflow: hidden; color: #6BA6D2;">@#{editProf.twitterUsername}</div>
								</td>
							</a4j:outputPanel>
							
							<td valign="top" align="left" width="125">
							<div class="fileinputs1Band">
							<select id="brand#{i}"	class="band" onChange="selectedBrand('brand#{i}', 'vkb#{i}', this.value)"
							value="#{editProf.brndProdInds}">
								<option value="BRAND">BRAND</option>
								<option value="PRODUCT">PRODUCT</option>
								<option value="INDUSTRY">INDUSTRY</option>

							</select>
							<div class="fakefile1Band">
							<input id="vkb#{i}" name="vkb#{i}" type="text" value="#{editProf.brndProdInds}" class="vk_text"  
								   style="background-image: none; background-color: transparent; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;"/></div>
							</div>
							</td>
						</tr>
						<a4j:outputPanel rendered="#{(editProf.accessToken == null)}">
						<tr>
							<td class="edit_left_textGreen" valign="top" align="left" colspan="4" width="200"
							style="color: #6BA6D2;">
							
							<h:commandLink value="SEND AUTHENTICATION" id="createProfile" 
							style="background-image: inherit; background: transparent; background-color: transparent;
									color: #6BA6D2; border-color: transparent;cursor: pointer; font-size: 11px;
									font-family: Verdana,Arial,Helvetica,sans-serif;text-align: left; text-indent: 0px; text-decoration: none;" 
									target="_parent" actionListener="#{twitterController.autenticateTwitterUser}">
									<f:param name="authName" value="#{editProf.twitterUsername}"/>
									<f:param name="from" value="createProfileAuth"/>
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
				</a4j:repeat>
				</td>
			</tr>
			<tr>
				<td align="right" valign="top" colspan="2">
			<ui:include src="/editProfileHandler.jsp">
					<ui:param name="competitorhandlername" value="Competitor #1"/>
					<ui:param name="inputtext1" value="1"/>				
					<ui:param name="inputtext1value" value="#{userProfileController.userProfile.twitterCmptAccountName1}"/>
					<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol}"/>
					<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr}"/>
					<ui:param name="addbuttonlistener" value="#{userProfileButtonHandler.validateTwitterAccountCmptHandler1}"/>
					<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle1}"/>
			</ui:include>
			<ui:include src="/editProfileHandler.jsp">
					<ui:param name="competitorhandlername" value="Competitor #2"/>
					<ui:param name="inputtext1" value="2"/>				
					<ui:param name="inputtext1value" value="#{userProfileController.userProfile.twitterCmptAccountName2}"/>
					<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol2}"/>
					<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr2}"/>
					<ui:param name="addbuttonlistener" value="#{userProfileButtonHandler.validateTwitterAccountCmptHandler2}"/>
					<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle2}"/>
			</ui:include>
			<ui:include src="/editProfileHandler.jsp">
					<ui:param name="competitorhandlername" value="Competitor #3"/>
					<ui:param name="inputtext1" value="3"/>				
					<ui:param name="inputtext1value" value="#{userProfileController.userProfile.twitterCmptAccountName3}"/>
					<ui:param name="inputtext1bgcolor" value="#{backingBean.compTwittAccCol3}"/>
					<ui:param name="cmpttwitteraccerr" value="#{backingBean.compTwittAccErr3}"/>
					<ui:param name="addbuttonlistener" value="#{userProfileButtonHandler.validateTwitterAccountCmptHandler3}"/>
					<ui:param name="cmptlist" value="#{userProfileController.userProfile.compTwtAccountsHandle3}"/>
			</ui:include>
			</td>
			</tr>

<!--  ============================================ STEP 3 ============================================ -->	
			<script>#{userProfileController.userProfile.JSObject}</script>
			<tr>
				<td height="10" colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1"></div>
						<div class="createProfileTop2"><font class="createProfileTop2Green">STEP THREE</font>
							<br/>
							<font class="createProfileTop2Gary">Identify Targeted Keywords<font style="font-size: 12px;">(Limit 1 product/brand)</font></font>
						</div>
						<div class="createProfileTop3"></div>
					</div>
				</td>
			</tr>
			<tr height="30">
				<td colspan="2" align="left" valign="top">
					<table width="400" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td valign="top" align="right" class="edit_left_textEPP" width="120">
							<font style="color: #FF0000;">*</font>Profile
							</td>
							<td valign="top" align="left">
								<div class="fileinputs1choose">				
									<t:selectOneMenu id="profile" 
										value="#{userProfileController.userProfile.keyWordCompanyHandleName}" styleClass="state11" 
										onchange="selectedItem('createProfile:profile', 'vkprofile', this.value); populateKeyword('createProfile:brand','createProfile:product','createProfile:industry',this.value);">
			                    	   <f:selectItems value="#{userProfileController.userProfile.allCompanyHandlers}"/>
			                        </t:selectOneMenu>
								    <div class="forcombo" >
					                    <input id="vkprofile" type="text" 
					                    	  value="#{userProfileController.userProfile.keyWordCompanyHandleName}" class="vk_text"  
					                          style="background-color: transparent; border-width: 0px; padding-top : 3px; 
					                	      background-image: none;color:#7D848B; font-size:10px; font-weight:bold; width:230px;"/>
				   	                </div>
                    			</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="edit_left_textEPP" align="right" valign="middle" style="width: 100px;"></td>
				<td align="left" valign="middle" class="edit_left_textEPP" style="padding-left: 20px;">Separate keywords by a comma.</td>
			</tr>			
			<tr height="30">
				<td colspan="2" align="left" valign="top">
					<table width="400" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top" align="right" class="edit_left_textEPP" width="120">
								<font style="color: #FF0000;">*</font>Brand
							</td>
							<td valign="top" align="left" class="edit_left_textEPP">
								<h:inputText id="brand" value="#{userProfileController.userProfile.keyWordIdentBrand}"
									styleClass="edit_right_textAddCP"  
									style="background-image: none; border-width: 2px; font-size: 12px; 
									color: rgb(125, 132, 139); width: 217px;background-color: #{backingBean.color}"/>								
								<div style="width:200px; font-weight: normal" class="edit_left_textGreen">
									<font  style="font-weight: normal; font-size: 11px; color:#F17A4B;">
										<h:outputText value="#{backingBean.errMsg}"/>
									</font>
								</div>
							</td>
							<td valign="top" align="left" class="edit_left_textEPP">
								<h:commandLink value=""
									onmousedown="setScrollValue();"
									actionListener="#{userProfileButtonHandler.addKeyWordBrandHandler}" 
									style="text-decoration: none;">
	                          			<img src="../images/addButton.gif"	                          				 
	                          				border="0" 
	                          				width="41"/>
	                          	</h:commandLink>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="30">
				<td colspan="2" align="left" valign="top">
					<table width="400" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top" align="right" class="edit_left_textEPP" width="120">
								<font style="color: #FF0000;">*</font>Product
							</td>
							<td valign="top" align="left" class="edit_left_textEPP">
								<h:inputText id="product"
									value="#{userProfileController.userProfile.keyWordIdentProd}"
									styleClass="edit_right_textAddCP"  style="background-image:none; border-width:2px; 
									color:#7D848B; font-size:12px;width: 217px;background-color: #{backingBean.color1}"
									/>
									
									<div style="width:200px; font-weight: normal" color="#F17A4B">
										<font class="edit_left_textGreen" style="font-weight: normal; font-size: 11px; color:#F17A4B;">
											<h:outputText value="#{backingBean.errMsg1}"/>
										</font>
									</div>
							</td>
							<td valign="top" align="left" class="edit_left_textEPP">
								<h:commandLink value="" 					
									onmousedown="setScrollValue();"				
									actionListener="#{userProfileButtonHandler.addKeyWordProductHandler}" 
									style="text-decoration: none;">
	                          			<img src="../images/addButton.gif"	                          				 
	                          				border="0" 
	                          				width="41"/>
	                          	</h:commandLink>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="30">
				<td colspan="2" align="left" valign="top">
					<table width="400" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top" align="right" class="edit_left_textEPP" width="120">
								<font style="color: #FF0000;">*</font>Industry
							</td>
							<td valign="top" align="left" class="edit_left_textEPP">
								<h:inputText value="#{userProfileController.userProfile.keyWordIdentIndu}" id="industry"
									styleClass="edit_right_textAddCP"  style="background-image:none; border-width:2px; 
									color:#7D848B; font-size:12px;width: 217px;background-color: #{backingBean.color2}"
									/>
									
									<div style="width:200px; font-weight: normal" color="#F17A4B">
										<font class="edit_left_textGreen" style="font-weight: normal; font-size: 11px; color:#F17A4B;">
											<h:outputText value="#{backingBean.errMsg2}"/>
										</font>
									</div>
							</td>
							<td valign="top" align="left" class="edit_left_textEPP">
								<h:commandLink value="" 
									onmousedown="setScrollValue();"
									actionListener="#{userProfileButtonHandler.addKeyWordIndustryHandler}" 
									style="text-decoration: none;">
	                          			<img src="../images/addButton.gif"	                          				 
	                          				border="0" 
	                          				width="41"/>
	                          	</h:commandLink>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<script>
				selectedItem('createProfile:profile', 'vkprofile', '#{userProfileController.userProfile.keyWordCompanyHandleName}'); 
				populateKeyword('createProfile:brand','createProfile:product','createProfile:industry','#{userProfileController.userProfile.keyWordCompanyHandleName}');							
			</script>
<!--  ============================================ STEP 4 ============================================ -->	
<!-- 
			<tr>
				<td colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1">
						</div>
						<div class="createProfileTop2">
						<font class="createProfileTop2Green">STEP FOUR</font>
						<br/>
						<font class="createProfileTop2Gary">Set Your Goal</font>
						</div>
						<div class="createProfileTop3">
						</div>
					</div>
				</td>
			</tr>
			
			<tr>
				<td class="edit_left_textEPP" align="right" valign="top" width="100"><font
					style="color: #FF0000;">*</font>Improvement
				Level</td>
				<td align="right" valign="top">
				<table width="280" border="0" cellspacing="0" cellpadding="0"
					class="edit_left_textEPP1">
					<a4j:repeat value="#{userProfileController.improvementLevel}" var="imprLevel" rowKeyVar="i">
						<tr>
							<td>
							</td>
							<td valign="top" align="center">
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
							<td valign="top" align="left">#{imprLevel.name}<br />
							<font class="edit_left_textEPP3">(#{imprLevel.description})</font></td>
						</tr>
						<tr>
							<td colspan="2" height="6"></td>
						</tr>
					</a4j:repeat>
				</table>
				</td>
			</tr>
-->
<!--  ============================================ STEP 5 ============================================ -->	

			<tr>
				<td colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1">
						</div>
						<div class="createProfileTop2">
						<font class="createProfileTop2Green">STEP FOUR</font>
						<br/>
						<font class="createProfileTop2Gary">Link to your Google Analytics Account </font>
						</div>
						<div class="createProfileTop3">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td align="right" valign="top" colspan="2">
					<table width="380" cellpadding="0" cellspacing="0">
						<tr>
							<td class="edit_left_textEPP" align="right" valign="top" width="100">
							Google Analytics<br/>Account
							</td>
							<td class="edit_left_textEPP" align="right" valign="top" width="260">
								<h:inputText value="#{userProfileController.userProfile.googleAnalyticsUsername}" id="google"
									styleClass="edit_right_textAdd"  
									style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width: 260px;" 
									onfocus="if(document.getElementById('createProfile:google').value=='Username') document.getElementById('createProfile:google').value='';"/>
								
								<div style="font-weight: normal; width: 200px; color:#F17A4B; overflow: hidden; height: auto;">
													<h:outputText value=""/>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right" valign="top">
				<table width="380" cellpadding="0" cellspacing="0">
						<tr>
							<td class="edit_left_textEPP" align="right" valign="top" width="100">
							
							</td>
							<td class="edit_left_textEPP" align="right" valign="top" width="260">
								<table width="260" border="0"  cellpadding="0" cellspacing="0">
								<tr>
									<td>
									<h:inputSecret value="#{userProfileController.userProfile.googleAnalyticsPassword}" 
									id="googlePwd"
									style="background-image:none; border-width:2px; color:#E1E2E5; font-size:12px;width: 144px; padding-left: 5px;" onfocus="if(document.getElementById('createProfile:googlePwd').value=='Password') document.getElementById('createProfile:googlePwd').value='';"/>
									</td>
									<td>
										<div id="googleLoader">
											<a4j:commandLink value="" reRender="gAccountList" actionListener="#{userProfileButtonHandler.authenticateGoogleAccount}" 
											   				 style="text-decoration: none;" onclick="document.getElementById('googleLoader').style.display='none'; document.getElementById('inactiveButton').style.display='block';"
											   				 oncomplete="document.getElementById('googleLoader').style.display='block'; document.getElementById('inactiveButton').style.display='none';">
	                        					<img src="../images/Profile/authenticateCPButton.gif" border="0" style="padding-left: 2px;" onload="if(document.getElementById('createProfile:google').value=='') document.getElementById('createProfile:google').value='Username';if(document.getElementById('createProfile:googlePwd').value=='') document.getElementById('createProfile:googlePwd').value='Password';"/>
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
					
					
					</table>
			
					
				</td>
			</tr>
			<tr><td height="5px"></td></tr>
			<tr height="45">
				<td class="edit_left_textEPP" align="right" valign="top"></td>
				<td valign="top" align="left" colspan="2" >
					<h:inputHidden id="googletableid" value="#{userProfileController.userProfile.googleAnalyticsTableId}" />
					<h:inputHidden id="googleAcctname" value="#{userProfileController.userProfile.googleAnalyticsAccount}" />
				
					<div class="fileinputs1state11" style="margin-left: 25px;">
						<a4j:outputPanel id="gAccountList" >
							<t:selectOneMenu id="googleList" immediate="true"
								value=""
								styleClass="state11" 
								onchange="selectedItem('createProfile:googleList', 'vkgoogle', this.options[selectedIndex].text);
												populateText('createProfile:googletableid',this.value);
												populateText('createProfile:googleAcctname',this.options[selectedIndex].text);">
								<f:selectItems value="#{userProfileController.userProfile.allGoogleAccounts1}"/>
							</t:selectOneMenu>
   	                      <div class="forcombo" >
       	                     <input id="vkgoogle" type="text" value="#{userProfileController.userProfile.googleAccountSelected}" 
       	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 2px; 
       	                     		  background-image: none;color:#7D848B; font-size:10px; font-weight:bold; padding-bottom: 4px; width:250px;"/>
           	               </div>
					 	</a4j:outputPanel>
           	       </div>    
				</td>
				
				
				
				<!--<td class="edit_left_textEPP" align="left" valign="top"
					colspan="2">

				<div class="fileinputs1" style="padding-right: 15px;">
                                 <t:selectOneMenu id="acc" value="abcd" 
                                 				 styleClass="state11" onchange="selectedItem('acc', 'vkacc', this.value)">
	                                	<f:selectItem itemValue=" " />
    	                         </t:selectOneMenu>
        	                      <div class="forcombo" >
            	                     <input id="vkacc" type="text" value="Choose an Account" 
            	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 5px; 
            	                     	       background-image: none;color:#7D848B; font-size:10px; font-weight:bold;"/>
                	               </div>     
				      <script>
                         //sSelect();           
                      </script>
                               </div>
				</td>
		--></tr>
		
	<!--  ============================================ STEP 6 ============================================ -->		
		<tr>
			<td colspan="2" align="left" valign="top">
				<div class="createProfileTop">
					<div class="createProfileTop1">
					</div>
					<div class="createProfileTop2">
					<font class="createProfileTop2Green">STEP FIVE</font>
					<br/>
					<font class="createProfileTop2Gary">Link to your Bitly Account </font>
					</div>
					<div class="createProfileTop3">
					</div>
				</div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="right" valign="top">
				<table width="380" cellpadding="0" cellspacing="0">
					<tr>
						<td class="edit_left_textEPP" align="right" valign="top" width="100">Bit.ly Account</td>
						<td class="edit_left_textEPP" align="right" valign="top" width="260">
							<table width="260" border="0"  cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<h:inputText value="#{userProfileController.userProfile.bitlyUsername}" 
											id="bitlyId"
											onblur="toggleAuthenticateBitlyAccountComponent('createProfile:bitlyId', 'createProfile:authenticateBitlyAccountLink', 'createProfile:authenticateBitlyAccountImage');"
											onkeyup="toggleAuthenticateBitlyAccountComponent('bitlyId', 'authenticateBitlyAccountLink', 'authenticateBitlyAccountImage');"
											onmouseup="toggleAuthenticateBitlyAccountComponent('bitlyId', 'authenticateBitlyAccountLink', 'authenticateBitlyAccountImage');"
											styleClass="edit_right_textAdd"
											style="background-image:none; border-width:2px; color:#7D848B; font-size:12px;width:144px;" />
									</td>
									<td>
										<h:commandLink value=""
											id="authenticateBitlyAccountImage" 
											style="text-decoration: none;">
	                       						<img src="../images/Profile/authenticateCPButton.gif" border="0" style="padding-left: 2px;"/>
	                   					</h:commandLink>
										<h:commandLink value=""
											id="authenticateBitlyAccountLink" 
											actionListener="#{bitlyController.authenticateBitlyAccount}" 
											style="text-decoration: none; display: none;" 
											target="_parent">
	                       						<img src="../images/Profile/authenticateCPButton.gif" border="0" style="padding-left: 2px;"/>
	                   					</h:commandLink>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" valign="top" align="left">
				<table  border="0">
					<tr>
						<td valign="middle" align="left">
							<a4j:commandLink value="" oncomplete="closePopup12('#{userProfileController.validationRequired}');" 
								actionListener="#{userProfileController.saveProfile}" 
								style="text-decoration: none;">
			                   	<img src="../images/Profile/saveChangesCPButton.gif" border="0"/>
			                   	<f:param name="closeProfilePopup" value="yes" />
			                   	<f:param name="screenName" value="createprofile"/>
			                </a4j:commandLink>
						</td>
						<td class="edit_left_text1" align="left" style="padding-left:8px">or</td>
						<td style="padding-top: 5px;">
							<a href="#" onclick="parent.location='../Logout';closeP();" 
								style="text-decoration: none; padding-top: 5px; padding-left: 3px">
			                	<font class="edit_left_text1" style="color: #7AC142; font-size: 11;">CANCEL</font>
			                </a>
						</td>
					</tr>
				</table>
			 </td>
		</tr>
		<script>#{userProfileButtonHandler.scrollScript}</script>	
		</table>
	</div>
		<h:inputText style="display: none;" 
			name="scrollValueHidden" 
			id="scrollValueHidden" 
			value="#{userProfileButtonHandler.scrollValue}"/>
	</h:form>
	</a4j:outputPanel>
		<a4j:outputPanel rendered="#{userProfileController.closable}">
		<script>
			closeP()
		</script>
	</a4j:outputPanel>	
	</f:view>
</ui:composition>