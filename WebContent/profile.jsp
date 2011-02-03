<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich">
 <!--*********************************************** Total Page Start *************************************************-->
   <head> 
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/profile.css" rel="stylesheet" type="text/css" />
    <link href="../css/popup.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>	
    <script language="JavaScript" src="../js/popup.js"></script>
    <script language="JavaScript" src="../js/svt.js"></script>
    <a4j:loadScript src="/js/custom-form-elements.js" />	
    <script language="JavaScript">
		function setProfileId(profileName){
		document.getElementById('captionDiv').innerHTML=profileName;
		}
	</script>
	</head>
   	<body>
   		<f:view>
   			<h:form>
    <div class="page">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr>
	        	<td align="left" valign="top">
		            <div class="mainBodyTopTotal">
		               <a4j:include viewId="templates/twitterTemplates/topTemplateTwitter.jsp"/>
		             </div>
	             </td>
           </tr>
            <tr>
            	<td class="welcome_textProfile" align="left" valign="middle" height="30">Profile</td>
           	</tr>
            <tr>
                <td valign="top" align="left">
                <div class="profileTotal">
                     <div class="profileTop">
                          <table width="100%" border="0" height="100%" cellpadding="0" cellspacing="0" style="margin-top:10px">
                               <tr>
                                 <td width="350" valign="top" align="left">
                                     <table width="350" border="0" height="90%">
                                        <tr>
                                           <td valign="bottom" align="left">
                                              <div class="profileName" style="color: #767f87;">
                                               #{userProfileController.userProfile.name}
                                               </div>
                                           </td>
                                           <td width="60" height="40" valign="bottom" align="left">
                                              <img src="../images/demoPerson.png" width="40" height="40"/>
                                              <br/>
                                              <font  class="topFirstTableMatterGreen">
                                              <a href="#" onclick="openPopup('upload Image',400, 90, 500, 300, 7, false, true, false, 'uploadImage.jsp')" style="color:#77C442; text-decoration:none;">
                                              CHANGE
                                              </a>
                                              </font>
                                           </td>
                                         </tr>
                                       </table>
                                     </td>
                                     <td align="right" valign="top">
                                        <font  class="topFirstTableMatterGreen">
                                           <a href="mainScreen.jsp" class="topFirstTableMatterGreen" style="color: #77C442; padding-right: 10px; text-decoration:none;">
                                            <font style="font-size:16px;">CLOSE</font>
                                           </a>
                                        </font>
                                      </td>
                                   </tr>
                               </table>
                         </div>
                         <div class="profileMiddle">
                           <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                 <tr>
                                   <td width="360" valign="top" align="center" style="border-right:1px solid #EEEEEF;">
	                                   <table width="360" border="0" cellpadding="0" cellspacing="0" style="padding-left:30px;">
	                                 <tr>
	                                   <td align="left" valign="top">
	                                   <div class="EPGreen">
	                                 	<a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
	                                  		 <font style="font-size: 14px;">EDIT PROFILE</font>
	                                   	</a>
	                                   </div>
	                                   </td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileText" align="left" valign="top">Name</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.name}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileText" align="left" valign="top">Title</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.title}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileText" align="left" valign="top">Company</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.company}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileText" align="left" valign="top">Work Address</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.workAddressLine1}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.workAddressLine2}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.workAddressLine3}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileText" align="left" valign="top">Phone</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.phone}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileText" align="left" valign="top">Website</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">#{userProfileController.userProfile.website}</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBold" align="left" valign="top">
	                                   <img src="../images/Profile/terametricLogo.gif" border="0"/></td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBoldSI" align="left" valign="top">Subscription Information:</td>
	                                 </tr>
	                                 <tr>
	                                   <td class="profileTextBoldSI1" align="left" valign="top">Free 30 day Trial - completed<br/>
	                                   	Monthly Subscription @ $499/mo.<br/>
	                                       (12 Month Subscription) - X days remaining
	                                       </td>
	                                 </tr>
	                                 <tr>
	                                   <td></td>
	                                 </tr>
	                               </table>
                            	</td>
                                                        
<!--  ******************************************RIGHT SITE PROFILE ***************************************-->
                                 <td valign="top" align="center" width="660">
                                                        <table width="600" border="0" cellpadding="0" cellspacing="0">
                                                              <tr>
                                                                <td class="profileText" align="left" valign="top">
                                                                Twitter Authenticated Accounts  
                                                                <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" 
                                                                    style="color:#77C442; text-decoration:none;">
                                                                		<font style="font-weight: normal; color: rgb(126, 190, 76);">ADD ANOTHER</font>
                                                                </a>
                                                                <font style="padding-left: 3px; padding-right: 3px; color: #787E89;">or</font>
                                                                <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
                                                                		
                                                                		<font style="font-weight: normal; color: rgb(126, 190, 76);">CHANGE</font>
                                                                </a>
                                                                </td>
                                                              </tr>
                                                              <a4j:repeat value="#{userProfileController.userProfile.selfTwtAccounts}" 
                                                              			  var="editProf" rowKeyVar="i">
	                                                              <tr>
	                                                                 <td class="profileTextBold" align="left" valign="top">@#{editProf.twitterUsername}</td>
	                                                              </tr>
                                                              </a4j:repeat>
                                                              
                                                              <tr>
                                                                <td class="profileText" align="left" valign="top">
                                                                <br/>Competitor Twitter Non-Authenticated Accounts
                                                                <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" 
                                                                    style="color:#77C442; text-decoration:none;">
                                                                		<font style="font-weight: normal; color: rgb(126, 190, 76);">ADD ANOTHER</font>
                                                                </a>
                                                                <font style="padding-left: 3px; padding-right: 3px; color: #787E89;">or</font>
                                                                <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
                                                                		
                                                                		<font style="font-weight: normal; color: rgb(126, 190, 76);">CHANGE</font>
                                                                </a>
                                                                </td>
                                                              </tr>
                                                              
                                                              <a4j:repeat value="#{userProfileController.userProfile.compTwtAccounts}" 
                                                              			  var="editProf" rowKeyVar="i">
	                                                              <tr>
	                                                                 <td class="profileTextBold" align="left" valign="top">@#{editProf.twitterUsername}</td>
	                                                              </tr>
                                                              </a4j:repeat>
                                                              
                                                              <tr>
                                                                <td class="profileText" align="left" valign="top">
                                                                <br/>Google Analytics Account</td>
                                                              </tr>
                                                              <tr>
                                                                <td valign="middle" align="left" width="200" class="profileTextBold">
                                                                twinbcreative.com
                                                                <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
                                                                		
                                                                		<font style="font-weight: normal; color: rgb(126, 190, 76);">CHANGE</font><br/><br/>
                                                                </a>			
																</td>
                                                              </tr>
                                                              
                                                              <tr>
                                                               <td bgcolor="#EBECEA" class="profileText" 
                                                               	   style="padding-top: 5px; padding-bottom: 5px; padding-left: 5px;">Select the most optimal improvement level based on your competitors' average scores
															   </td>
                                                              </tr>
                                                              <tr>
                                                              		<td valign="middle" align="left">
                                                                        <table width="600" border="0" cellpadding="0" cellspacing="0">
                                                                         <tr>
                                                                            <td class="edit_left_textEPP" align="right" valign="top" width="100">
                                                                            Improvement<br/> Level
                                                                            </td>
                                                                            <td align="left" valign="top" colspan="2" width="500">
                                                                            
                                                                                <table width="500" border="0" cellspacing="0" cellpadding="0" class="edit_left_textEPP1" style="margin-left:10px;">
                                                                                              <tr>
                                                                                                <td valign="top" align="center" width="30">
                                                                                                    <input type="radio" id="chkOne" name="chk" value="aaaa" checked="checked" onClick="SingleSelect('chk',this);" class="styled" />
                                                                                                </td>
                                                                                                <td valign="top" align="left" width="470">Moderate
                                                                                                 <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
		                                                                							<font style="font-weight: normal; color: rgb(126, 190, 76);">CHANGE</font></a>	
                                                                                                	<br />
                                                                                                    <font class="edit_left_textEPP3">(You'd like to close some of the gap between you and your competitor.)</font>
                                                                                                </td>
                                                                                              </tr>
                                                                                              <tr>
                                                                                                <td colspan="2" height="10"></td>
                                                                                              </tr>
                                                                                    </table>
                                                                            </td>
                                                                          </tr>
                                                                        </table>
                                                                    </td>
                                                              </tr>
                                                              <tr>
                                                               <td bgcolor="#EBECEA" class="profileTextBold1" style="padding-left: 5px;">Reporting<br />
    															<font style="font-weight:normal; font-size:11px;">
    																	The following emails will receive a report at the end of the month, at the end of the week, and/or when 
    																		activity changes scores by more than
    																		10% from one day to the next.</font>
																</td>
                                                              </tr>
                                                            <!--<tr height="40">
                                                                <td align="right" valign="middle">
                                                                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                                  <tr>
                                                                    <td class="profileTextBold1">
                                                                    Email Address
                                                                    </td>
                                                                    <td class="edit_left_textEPP" align="left" valign="top">
                                                                    <input type="text" name="name" 
                                                                    		value="Email Address" class="edit_right_textAdd" 
                                                                    		style="width:300px; background-image: none; border-width: 2px; color: #E1E2E5; font-size: 12px;"/>
                                                                    </td>
                                                                  </tr>
                                                                </table>
                                                                </td>
                                                            </tr>
                                                              -->
                                                              <tr>
                                                                <td align="left" valign="top">
                                                                        <table width="50%" border="0" cellspacing="0" cellpadding="0" 
                                                                        		style="margin-left: 145px; margin-top: 10px; margin-bottom: 10px;">
                                                                              <tr>
                                                                                
                                                                                <td valign="top" align="left" class="edit_left_textBlue">
                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                	<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail1 eq '')}">
																						<tr>
																							<td class="edit_left_textBlue" valign="top" align="left">
																								<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
																										checked="checked" onClick="SingleSelect('chkrpt',this);"
																									class="styled"/></td>
																									<td class="edit_left_textBlue" valign="top" align="left">
																								<div class="emailDetails">
																								#{userProfileController.userProfile.reportingEmail1}
																								</div>
																								</td>
																							<td valign="top" align="right" class="edit_left_textGreen">REMOVE</td>
																						</tr>
																						<tr>
																							<td colspan="3" height="10" width="289px;">
																							<div style="border-bottom: 1px solid #DDDDDD;"></div>
																							</td>
																						</tr>
																					</a4j:outputPanel>
                                                                                </table>
                                                                                </td>
                                                                              </tr>
                                                                              
                                                                              <tr>
                                                                                <td valign="top" align="left" class="edit_left_textBlue">
                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                	<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail2 eq '')}">
																						<tr>
																							<td class="edit_left_textBlue" valign="top" align="left">
																									<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
																											checked="checked" onClick="SingleSelect('chkrpt',this);"
																											class="styled" />
																								</td>
																								<td class="edit_left_textBlue" valign="top" align="left">
																										<div class="emailDetails">
																										#{userProfileController.userProfile.reportingEmail2}
																										</div>
																								</td>												
																									<td valign="top" align="right" class="edit_left_textGreen">REMOVE</td>
																						</tr>
																						<tr>
																							<td colspan="3" height="10" width="289px;">
																							<div style="border-bottom: 1px solid #DDDDDD;"></div>
																							</td>
																						</tr>
																						</a4j:outputPanel>
                                                                                </table>
                                                                                </td>
                                                                                <!--
                                                                                <td valign="top" align="right" width="80">
                                                                                 <img src="../images/verifyEmailButton.gif" border="0"/>
                                                                                </td>
                                                                              -->
                                                                              </tr>
                                                                              <tr>
                                                                                <td valign="top" align="left" class="edit_left_textBlue">
                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                	<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail3 eq '')}">
																						<tr>
																							<td class="edit_left_textBlue" valign="top" align="left">
																									<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
																											checked="checked" onClick="SingleSelect('chkrpt',this);"
																											class="styled" />
																								</td>
																								<td class="edit_left_textBlue" valign="top" align="left">
																										<div class="emailDetails">
																											#{userProfileController.userProfile.reportingEmail3}
																										</div>
																										
																								</td>												
																									<td valign="top" align="right" class="edit_left_textGreen">REMOVE</td>
																						</tr>
																						<tr>
																							<td colspan="3" height="10" width="289px;">
																							<div style="border-bottom: 1px solid #DDDDDD;"></div>
																							</td>
													
																						</tr>
																						</a4j:outputPanel>
                                                                                
                                                                                </table>
                                                                                </td>
                                                                              </tr>
                                                                              <!--
                                                                              <tr>
                                                                                <td valign="top" align="left" class="edit_left_textBlue">
                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                	<a4j:outputPanel rendered="#{!(userProfileController.userProfile.reportingEmail3 eq '')}">
																						<tr>
																							<td class="edit_left_textBlue" valign="top" align="left">
																									
																									<input type="checkbox" id="chkReptEmail" name="chkrpt" value="a"
																											checked="" onClick="SingleSelect('chkrpt',this);"
																											class="styled" />
																								
																								<img src="../images/selectCheckGrey.gif"/>
																								</td>
																								<td class="edit_left_textBlue" valign="top" align="left">
																										<font style="padding-left: 10px;">
																											dummydata@abc.com
																										</font>
																										
																								</td>												
																									<td valign="top" align="right" width="90">
                                                                                 							<img src="../images/verifyEmailButton.gif" border="0"/>
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
                                                                        -->
                                                                        </table>
                                                                </td>
                                                              </tr>
                                                             <tr>
                                                                <td class="profileTextBold1" style="padding-left: 5px;padding-top: 3px;">Vanity URL<br />
                                                                <font style="font-weight:normal; font-size:11px;">You have not added a vanity URL yet.</font>
                                                                <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
		                                                              <font style="font-weight: normal; color: rgb(126, 190, 76);">ADD</font></a>	
                                                                </td>
                                                              </tr>
                                                              <!-- 
	                                                             <tr height="60">
                                                                  <td valign="top" align="left">
                                                                          <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                                          <tr>
                                                                          	<br/>
                                                                            <td class="profileTextBold1" align="right" valign="top">Vanity URL</td>
                                                                            <td class="profileTextBold1" align="left" valign="top" colspan="2" style="padding-left: 10px;">
                                                                            <h:inputText  
                                                                            	   class="edit_left_textEPP" 
                                                                            	   style="width:300px; background-image: none; border-width: 2px; color: #7D848B; font-size: 12px; "/></td>
                                                                          </tr>         
                                                                          </table>
                                                                  </td>
                                                              </tr>
                                                              -->
                                                              <tr height="35" valign="middle" align="left">
                                                                <td align="right" valign="top">
                                                                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                                          <tr>
                                                                            <td  class="profileTextBold1" style="padding-left: 5px;">
                                                                               Time Zone
                                                                            </td>
                                                                            <td class="profileTextBold1" align="left" valign="top">
                                                                            (GMT - 5:00) Eastern Time (Us &amp; Canada) 
                                                                            <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
                                                                				<font style="font-weight: normal; color: rgb(126, 190, 76);">CHANGE</font>
                                                                			</a>
                                                                            </td>
                                                                          </tr>
                                                                          
                                                                        </table>
                                                                </td>
                                                              </tr>
                                                              <tr height="30">
                                                                <td align="left" valign="top">
                                                                        <table width="50%" border="0" cellpadding="0" cellspacing="0">
                                                                          <tr>
                                                                            <td  class="profileTextBold1" style="padding-left: 5px;">
                                                                              Benchmark Date
                                                                            </td>
                                                                            <td class="profileTextBold1" align="left" valign="top">
                                                                            11/21/10 to 12/9/10 
                                                                            <a href="#" onclick="openPopup('Edit Profile Preference',254, 3, 770, 800, 10, false, true, false, 'editProfile.jsp')" style="color:#77C442; text-decoration:none;">
                                                                				<font style="font-weight: normal; color: rgb(126, 190, 76);">CHANGE</font>
                                                                			</a>
                                                                            </td>
                                                                          </tr>
                                                                          
                                                                        </table>
                                                                </td>
                                                              </tr>
                                                              <tr>
                                                                <td valign="middle" align="center" height="10">
                                                                </td>
                                                              </tr>
                                                              
                                                              <tr>
                                                                <td valign="middle" align="left" bgcolor="#7EBE4C" height="30">
                                                                <table border="0" height="100%">
                                                                	<tr>
                                                                		<td width="25" align="center" valign="top"><img src="../images/profileLowerLogo.gif"/></td>
                                                                		<td align="left" valign="middle" class="AP">ACCOUNT PROCESSING: <font class="AP1">3 Hours Ago</font></td>
                                                                	</tr>
                                                                
                                                                </table>
                                                                
                                                                </td>
                                                              </tr>
                                                              <tr>
                                                                <td valign="middle" align="center" height="10">
                                                                </td>
                                                              </tr>
                                                              
                                                              <tr>
                                                                <td valign="middle" align="left" bgcolor="#7EBE4C" height="30">
                                                                <table border="0" height="100%">
                                                                	<tr>
                                                                		<td width="25" align="center" valign="top"><img src="../images/profileLowerLogo.gif"/></td>
                                                                		<td align="left" valign="middle" class="AP">DAYS OPTIMIZED: <font class="AP1">125 Days</font></td>
                                                                	</tr>
                                                                
                                                                </table>
                                                                
                                                                </td>
                                                              </tr>
                                                              <tr>
                                                                <td valign="middle" align="center" height="10">
                                                                </td>
                                                              </tr>
														</table>
														</td>
  													</tr>
                                                </table>
            									</div>
                                                <div class="profileBottom">
                                                <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                                                	<tr>
                                                		<td align="left" valign="top" width="360">
                                                		
                                                				<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0" style="margin-left:20px">
                                                					<tr>
                                                						<td width="50"  align="left" valign="middle">
                                                						<img src="../images/Profile/t.gif"/>
                                                						</td>
                                                						<td class="profileTextBold1" align="left" valign="middle" style="font-size: 15px; padding-left: 5px;">
                                                						twitter<br/>
                                                						twitter.com/wtblacklock
                                                						</td>
                                                					</tr>
                                                				
                                                				
                                                				</table>
                                                		
                                                		</td>
                                                		<td align="left" valign="top">
                                                		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="margin-left:20px">
                                                					<tr>
                                                						<td width="50" align="left" valign="middle">
                                                						<img src="../images/Profile/f.gif"/>
                                                						</td>
                                                						<td class="profileTextBold1" align="left" valign="middle" style="font-size: 15px; padding-left: 5px;">
                                                						facebook<br/>
                                                						facebook.com/wtblacklock
                                                						</td>
                                                					</tr>
                                                				
                                                				
                                                				</table>
                                                		</td>
                                                	</tr>
                                                
                                                
                                                </table>
                                                
                                                </div>
                                            </div>
                
                
                
                
                </td>
            
            </tr>
                 
             
                                 
                                     
<!--********************************Header Section End ***************************************-->





            
            <tr>
                <td valign="bottom">
                    <div class="border" style="margin-top:10px;">
                    </div>
                </td>
            </tr>





<!--******************FOOTER START****************-->
            
            <tr>
                <td align="left" valign="top">
                     <a4j:include viewId="templates/twitterTemplates/footer.jsp"/>
                </td>
             </tr> 
             

<!--******************FOOTER END****************-->

       </table>
    </div>   
    </h:form>
    </f:view>
    </body>
   
<!--*********************************************** Total Page End *************************************************-->
</ui:composition>




