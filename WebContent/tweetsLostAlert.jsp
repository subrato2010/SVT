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
	<script language="JavaScript" src="../js/designMainScreen.js"></script>
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	
	<f:view contentType="text/html">
	<h:inputHidden value="#{twitterController.profileImageAndLocationFirstTime}"/>
		<div id="refreshpopup">
   	  	<table width="100%" border="0" cellpadding="0" cellspacing="0" height="100%">
   	  	<tr>
   	  		<td valign="middle" align="center">
   	  			<div id="refreshpopup_inside">
	   	  			<div id="refresh_top">
	   	  				<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	   	  					<tr>
	   	  						<td valign="middle" align="center" width="40">
	   	  							<img alt="alert" src="../images/Alert/alertSign.gif"/>
	   	  						</td>
	   	  						<td valign="middle" align="left"  class="titlerefresh" width="330">
	   	  							Tweets will be Lost
	   	  						</td>
	   	  						<td valign="middle" align="center" width="40">
	   	  						<a onclick="parent.document.getElementById('refreshpopup').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
									href="#">
	   	  							<img alt="alert" src="../images/Alert/closeButtonOrange.gif" border="0"/>
	   	  							</a>
	   	  						</td>
	   	  					</tr>
	   	  				</table>
	   	  				</div>	
	   	  				 <div id="refresh_bottom">
		   	  				<table width="410" border="0" cellspacing="0" cellpadding="0" height="100%">
								<tr>
									<h:inputHidden value="#{channelPerformanceController.targetName}" />
									<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"
										height="30">
									<table width="410" border="0" cellpadding="0" cellspacing="0">
										<tr height="35">
											<td align="left" valign="middle" width="100"><font
												style="color: #EDEDED; padding-left: 15px;">For profile</font></td>
											<td align="left" valign="middle" width="300"
												style="color: #ffffff; font-weight: bold;">@#{twitterController.clickedCustomer}</td>
										</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td valign="top" align="center">
									<a4j:form id="tweetLost">
										<table width="95%" border="0" align="center"
											style="margin-top: 10px;">
											<tr>
												<td valign="middle" align="left" height="40" bgcolor="#F2F2F2">
												<font class="tweelLostHD">WARNING!</font></td>
											</tr>
											<tr>
												<td valign="middle" align="left" class="tweelLostMatter"
													height="50">Continuing will fetch another set of tweets and<br/>
												cause you to lose the current set.</td>
											</tr>
											<tr>
												<td valign="middle" align="left" class="tweelLostMatter"
													height="50s">
													<table width="100%">
													<tr>
														<td valign="top" align="left" class="tweelLostMatter" style="padding-left: 0px;">Are you sure you want to continue?</td>
														<td valign="top" align="right">
														
															<div id="activeButton">
															   <a4j:commandButton id="refreshList" 
																			actionListener="#{twitterController.twittMessage}"
																			style="text-decoration: none; font-size: 12px; cursor:pointer;
																			background-image: none; border-color:transparent;
																			background-color: transparent; color: #F2A413; font-weight: bold;"
																			oncomplete="javascript:document.getElementById('transParentDiv').style.display='none'; newToggleRTO();"
																			image="../images/Alert/continue.gif" reRender="updateList" 
																			onclick="document.getElementById('activeButton').style.display='none'; document.getElementById('inactiveButton').style.display='block';">
																</a4j:commandButton>
															</div>
															<div id="inactiveButton" style="display: none;">
															<img src="../images/preloader3.gif"/>
															</div>
														</td>
													</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td align="left" valign="top">
												<table width="100%">
													<tr>
														<td align="left" valign="top" class="closeOrangeTextAlert">
															<h:selectBooleanCheckbox id="ckeckboxOrange" value="true"
																valueChangeListener="#{twitterController.onAlwaysAskClicked}" 
																onselect="performOperation(this);"/>
																ALWAYS ASK
													    </td>
														<td align="right" valign="top"><a
															onclick="parent.document.getElementById('refreshpopup').style.display='none'; parent.document.getElementById('transParentDiv').style.display='none';"
															href="#" class="closeOrangeTextAlert"
															style="color: #F2A413; text-decoration: none;">CLOSE</a></td>
													</tr>
												</table>
												</td>
											</tr>
										</table>
									</a4j:form>
									</td>
								</tr>
							</table>
   	  				    </div>
    	  			</div>
   	  		</td>
   	  	</tr>
   	  	
   	  	</table>
   	  </div>
	</f:view>
</ui:composition>
