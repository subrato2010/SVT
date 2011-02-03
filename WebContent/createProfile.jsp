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

	</head>
	<script language="JavaScript">
      function closeP(){
      	var bd = parent.document.getElementById("floatingDiv");
      	bd.style.display = "none";
      	var bd = parent.document.getElementById("backDrop");
     	 bd.style.display = "none";
      }
      function sSelect()
      {
          var myselect=document.getElementById("createProfile:sel");
          for (var i=0; i &lt; myselect.options.length; i++)
          {
              if (myselect.options[i].selected == true){
                  document.getElementById("vk").value = myselect.options[i].text;
                  break;
              }
          }	
      }
      function selectedItem(listObjectname, inputObjectname, selectedValue)
      {
           var myselect=document.getElementById("createProfile:" + listObjectname);
          for (var i=0; i &lt; myselect.options.length; i++)
          {
              if (myselect.options[i].selected == true){
                  document.getElementById(inputObjectname).value = myselect.options[i].text;
                  break;
              }
          }
      }
      function selectedBrand(listObjectname, inputObjectname, selectedValue)
      {
           var myselect=document.getElementById(listObjectname);
          for (var i=0; i &lt; myselect.options.length; i++)
          {
              if (myselect.options[i].selected == true){
                  document.getElementById(inputObjectname).value = myselect.options[i].text;
                  break;
              }
          }
      }
   </script>
	<body>
	<f:view>
	<a4j:outputPanel rendered="#{!userProfileController.closable}">
	<h:form id="createProfile" enctype="multipart/form-data">
	<t:inputHidden value="#{userProfileController.completeFlag}" />
	<h:inputHidden value="#{backingBean.cityColor}"/>
	<div class="createProfileTotal"	>
	  <table width="340" border="0" cellpadding="0" cellspacing="0" align="center">
		
		
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
			<td class="edit_left_text" align="right" style="padding-right:5px">Name</td>
			<td class="edit_left_text" align="left">
				<h:inputText id="name" value="#{userProfileController.userProfile.name}" 
						 required="true" class="edit_right_textCreateProfile"  
						 style="background-image: none; border-width: 2px; font-size: 12px;width:267px; color: rgb(125, 132, 139); padding-left: 3px;" />
			</td>
		</tr>
		
		<tr>
	    	<td class="edit_left_text" align="right" style="padding-right:5px">Title</td>
			<td class="edit_left_text" align="left">
				<h:inputText id="title" value="#{userProfileController.userProfile.title}" 
						 required="true" requiredMessage="Name can't be blank." class="edit_right_textCreateProfile"  
						 style="background-image: none; border-width: 2px; font-size: 12px; width:267px;color: rgb(125, 132, 139); padding-left: 3px;" />
			</td>
		</tr>
		
		<tr>
		   <td class="edit_left_text" align="right" style="padding-right:5px">Company</td>
			<td class="edit_left_text" align="left">
				<h:inputText id="company" value="#{userProfileController.userProfile.company}" required="true" 
							 requiredMessage="Name can't be blank." class="edit_right_textCreateProfile"  
							 style="background-image: none; border-width: 2px; font-size: 12px; width:267px;color: rgb(125, 132, 139); padding-left: 3px;" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1">
						</div>
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
				<table width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td align="right" valign="top" class="edit_left_textEPP">
										<font style="color: #FF0000;">*</font>Email Address<br />
										</td>
										<td align="left" valign="top">
										<h:inputText id="email" value="#{userProfileController.userProfile.emailAddress}"
										class="edit_right_textAdd"  
					style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 223px;
					background-color: #{backingBean.mailCol}"
					/>
					<br/>
					<font style="font-weight: normal" color="#F17A4B">
						<h:outputText value="#{backingBean.mailErr}"/>
					</font>
						</td>
						<td align="left" valign="top">
						<input type="image" src="../images/addButton.gif" border="0" width="41" />
						</td>
					</tr>
				</table>
			  </td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
					<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail1 eq '')}">
						<tr>
							<td class="edit_left_textBlue" valign="top" align="left">
								<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
										checked="checked" onClick="SingleSelect('chkrpt',this);"
									class="styled"/></td>
									<td class="edit_left_textBlue" valign="top" align="left">
								<font style="padding-left: 2px;">#{userProfileController.userProfile.reportingEmail1}</font>
								</td>
							<td valign="top" align="right" class="edit_left_textGreen">REMOVE</td>
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
											class="styled" />
								</td>
								<td class="edit_left_textBlue" valign="top" align="left">
										<font style="padding-left: 2px;">
											#{userProfileController.userProfile.reportingEmail2}
										</font>
										
								</td>												
									<td valign="top" align="right" class="edit_left_textGreen">REMOVE</td>
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
									class="styled" /></td>
								<td class="edit_left_textBlue" valign="top" align="left">
								<font style="padding-left: 2px;">#{userProfileController.userProfile.reportingEmail3}</font>
								</td>												
							<td valign="top" align="right" class="edit_left_textGreen">REMOVE</td>
							<!-- td valign="top" align="left" width="80"><img
								src="../images/verifyEmailButton.gif" border="0" /></td> -->
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
				<td class="edit_left_textEPP" align="right" valign="top">
				<font style="color: #FF0000; padding-right: 6px;">*</font>Timezone
				</td>
				<td class="edit_left_textEPP" align="left" valign="top" colspan="2">
					<div class="fileinputs1choose">
					<t:selectOneMenu id="timezone" value="abcd" 
	                         styleClass="timezone" onchange="selectedItem('timezone','vktimezone',this.value);">	                                    				 
    	            	<f:selectItems value="#{userProfileController.timeZoneOptions }" />
        	        </t:selectOneMenu>
            	    <div class="forcombo">
                	   <input id="vktimezone" type="text" value="Select a timezone"  
                	    	   class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 3px; 
                	           background-image: none;color:#7D848B; font-size:10px; font-weight:bold; width:230px;"/>
                    </div>       
					</div>
				</td>
			</tr>
			<tr>
				<td height="10" colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1">
						</div>
						<div class="createProfileTop2">
						<font class="createProfileTop2Green">STEP TWO</font>
						<br/>
						<font class="createProfileTop2Gary">Setup your Twitter Accounts</font>
						</div>
						<div class="createProfileTop3">
						</div>
					</div>
				</td>
			</tr>


			<tr>
				<td align="left" valign="top" colspan="2">
				<table width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td align="right" valign="top" class="edit_left_textEPP">
										<font style="color: #FF0000;">*</font>Twitter Accounts<br />
										<font style="font-weight: normal">(Limit 5)</font>
										</td>
										<td align="left" valign="top">
										<h:inputText id="twtAcc" value="#{backingBean.twitterAccountName}"
										class="edit_right_textAdd"  
					style="background-image:none; border-width:2px; color:#7D848B; font-size:12px; width: 205px;
					background-color: #{backingBean.twittAccCol}" required="false"/>
					<br/>
					<font style="font-weight: normal" color="#F17A4B">
						<h:outputText value="#{backingBean.twittAccErr}"/>
					</font>
						</td>
						<td align="left" valign="top">
							<h:commandLink value="" 
								actionListener="#{backingBean.validateTwitterAccountHandler}" 
								style="text-decoration: none;">
                          			<img src="../images/addButton.gif" border="0" width="41"/>
                          	</h:commandLink>
						</td>					
						</tr>
				</table>
			  </td>
			</tr>
			<tr>
				<td align="right" valign="top" colspan="2">
				<table width="70%" border="0" cellspacing="0" cellpadding="0">
								<a4j:repeat value="#{userProfileController.userProfile.selfTwtAccounts}" var="editProf" rowKeyVar="i">
									<tr>
										<td><img src="../images/smallClose.PNG" border="0" /></td>
										<td><img src="../images/selectCheck.gif" border="0" /></td>
										<td class="edit_left_textGreen" valign="top" align="left">
											<font style="padding-right: 10px;">@#{editProf.twitterUsername}</font>
										</td>
										
										<td valign="top" align="left">
										<div class="fileinputs1Band">
										<select id="brand#{i}"	class="band" onChange="selectedBrand('brand#{i}', 'vkb#{i}', this.value)">
											<option value="Brand">BRAND</option>
											<option value="Product">PRODUCT</option>
											<option value="Industry">INDUSTRY</option>

										</select>
										<div class="fakefile1Band">
										<input id="vkb#{i}" type="text" value="BRAND" class="vk_text"  
											   style="background-image: none; background-color: transparent; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;"/></div>
										</div>
										</td>
									</tr>
									<tr>
										<td colspan="5" height="10">
										<div style="border-bottom: 1px solid #DDDDDD;"></div>
										</td>
									</tr>
									</a4j:repeat>
								</table>
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

			<tr>
				<td height="10" colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1">
						</div>
						<div class="createProfileTop2">
						<font class="createProfileTop2Green">STEP THREE</font>
						<br/>
						<font class="createProfileTop2Gary">Identify Targeted Keywords<font style="font-size: 12px;">(Limit 1 product/brand)</font></font>
						</div>
						<div class="createProfileTop3">
						</div>
					</div>
				</td>
			</tr>
			<tr height="40">
				<td class="edit_left_textEPP" align="right" valign="middle">
				<font style="color: #FF0000;">*</font>Profile
				</td>
				<td align="left" valign="middle">

				<div class="fileinputs1choose">
				
				<t:selectOneMenu id="profile" value="#{twitterAccountDTO.twitterUsername}"
                    				 styleClass="state11" onchange="selectedItem('profile', 'vkprofile', this.value)">
                    	<f:selectItems value="#{userProfileController.allTwitterAccounts}"/>
                 </t:selectOneMenu>
				    <div class="forcombo" >
                     <input id="vkprofile" type="text" value="Competitor #1" 
                     	class="vk_text"  style="background-color: transparent; border-width: 0px; padding-top : 3px; 
                	           background-image: none;color:#7D848B; font-size:10px; font-weight:bold; width:230px;"/>
   	               </div>      
                 </div>
				</td>
			</tr>
			
			<tr>
				<td class="edit_left_textEPP" align="right" valign="middle">
				
				</td>
				<td align="left" valign="middle" class="edit_left_textEPP">Separate keywords by a comma.
				</td>
			</tr>
			
			<tr>
				<td class="edit_left_textEPP" align="right" valign="middle">
				<font style="color: #FF0000;">*</font>Brand</td>
				<td align="left" valign="middle">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td align="left" valign="top" class="edit_left_textEPP" >
							<h:inputText id="brand" value="#{userProfileController.userProfile.keyWordIdentBrand}"
									class="edit_right_textAddCP"  
									style="background-image: none; border-width: 2px; font-size: 12px; 
									color: rgb(125, 132, 139); width: 217px;background-color: #{backingBean.color}"
									/>
								
								<div style="width:200px; font-weight: normal" color="#F17A4B">
									<h:outputText value="#{backingBean.errMsg}"/>
								</div>
							</td>
							<td align="left" valign="top">
							<input type="image" src="../images/addButton.gif" border="0"  width="41" />
							</td>
						</tr>
					</table>
				
				</td>
			</tr>
			<tr>
				<td class="edit_left_textEPP" align="right" valign="middle">
				<font style="color: #FF0000;">*</font>Product
				</td>
				<td align="left" valign="middle">
				<table width="100%"  cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="left" valign="top" class="edit_left_textEPP" >
							<h:inputText id="product"
									value="#{userProfileController.userProfile.keyWordIdentProd}"
									class="edit_right_textAddCP"  style="background-image:none; border-width:2px; 
									color:#7D848B; font-size:12px;width: 217px;background-color: #{backingBean.color1}"
									/>
									
									<div style="width:200px; font-weight: normal" color="#F17A4B">
										<h:outputText value="#{backingBean.errMsg1}"/>
									</div>
							</td>
							<td align="left" valign="top">
							<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
							</td>
						</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td class="edit_left_textEPP" align="right" valign="middle">
				<font style="color: #FF0000;">*</font>Industry
				</td>
				<td align="left" valign="middle">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="left" valign="top" class="edit_left_textEPP" >
							<h:inputText value="#{userProfileController.userProfile.keyWordIdentIndu}" id="industry"
									class="edit_right_textAddCP"  style="background-image:none; border-width:2px; 
									color:#7D848B; font-size:12px;width: 217px;background-color: #{backingBean.color2}"
									/>
									
									<div style="width:200px; font-weight: normal" color="#F17A4B">
											<h:outputText value="#{backingBean.errMsg2}"/>
									</div>
							</td>
							
							<td align="left" valign="top">
							<input type="image" src="../images/addButton.gif" border="0"  width="41"/>
							</td>
						</tr>
				</table>
				</td>
			</tr>
			
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
				<td class="edit_left_textEPP" align="right" valign="top"><font
					style="color: #FF0000;">*</font>Improvement
				Level</td>
				<td align="left" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
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
			<tr>
				<td colspan="2" align="left" valign="top">
					<div class="createProfileTop">
						<div class="createProfileTop1">
						</div>
						<div class="createProfileTop2">
						<font class="createProfileTop2Green">STEP FIVE</font>
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
							<td class="edit_left_textEPP" align="right" valign="top">
							<font style="color: #FF0000;">*</font>Google Analytics<br/>Account
							</td>
							<td class="edit_left_textEPP" align="left" valign="top" width="200">
							<input type="text" name="name"
					value="Username" class="edit_right_textAddCP"
					style="background-image:none; border-width:2px; font-size:12px; width: 272px;color: rgb(125, 132, 139);"/>
							</td>
						</tr>
					
					
					</table>
				</td>
			</tr>
			<tr>
				<td class="edit_left_textEPP" align="right" valign="top" width="180"></td>
				<td class="edit_left_textEPP" align="left" valign="top">

				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-left: 2px;">
					<tr>
						<td valign="bottom" align="left"  style="padding-left:3px">
						<input type="text"
							name="name" value="Password" class="edit_right_textAddCP"
							style="background-image:none; border-width:2px; font-size:12px; width: 167px;color: rgb(125, 132, 139);" />
					    </td>
					    <td style="width: 10px;"></td>
						<td valign="top" align="left">
						<input type="image"
							src="../images/Profile/authenticateCPButton.gif" border="0" /></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr><td height="5px"></td></tr>
			<tr height="45">
				<td class="edit_left_textEPP" align="right" valign="top"></td>
				<td valign="top" align="left" colspan="2" >
										<div class="fileinputs1state11">
										<t:selectOneMenu id="acc" value="abcd" 
                                 				 styleClass="state11" onchange="selectedItem('acc', 'vkacc', this.value)">
	                                		<f:selectItem itemValue=" " />
    	                         		</t:selectOneMenu>
										
											<div class="forcombo" >
	            	                     	<input id="vkacc" type="text" value="Choose an Account" 
	            	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 3px; 
                	           background-image: none;color:#7D848B; font-size:10px; font-weight:bold; width:230px;"/>
	                	               		</div>
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
			
			<tr>
				<td colspan="2" valign="top" align="left">
				<table  border="0">
					<tr>
							<td valign="middle" align="left">
							<h:commandLink value="" 
									actionListener="#{userProfileController.saveProfile}" 
									style="text-decoration: none;">
                          		<img src="../images/Profile/saveChangesCPButton.gif" border="0"/>
                          	</h:commandLink>
							</td>
							<td class="edit_left_text1" align="left" style="padding-left:8px">
							or 
							</td>
							<td style="padding-top: 5px;">
								<a href="#" onclick="closeP(); parent.location.reload();" style="text-decoration: none; padding-top: 5px; padding-left: 3px">
	                               <font class="edit_left_text1" style="color: #7AC142; font-size: 11;">CANCEL</font>
	                            </a>
							</td>
					</tr>
				</table>
			  </td>
			</tr>
		</table>
	</div>
	</h:form>
	</a4j:outputPanel>
		<a4j:outputPanel rendered="#{userProfileController.closable}">
		<script>
			closeP()
			parent.location.href='twitterChannelOptimization.jsp';
		</script>
	</a4j:outputPanel>
	</f:view>
	</body>
	</ui:composition>
