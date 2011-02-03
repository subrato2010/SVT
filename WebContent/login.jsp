<html>
<head>
<%! 
		  String color = "";
		  String loginCredentials="";
	%>
<%
			int refreshTimeOut=10000000;
			if(request.getParameter("status")==null)
			{
  %>
  		<script>
	  		window.location.href = "../faces/twt.jsp?status=login";
  		</script>
  <%
			}else if(request.getParameter("status").equals("logout"))
		 		refreshTimeOut = 65;
	 %>
<meta http-equiv="refresh" content="<%=refreshTimeOut%>" />
</head>
<title>:: Twitter Optimization ::</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/popup.css" type="text/css" rel="stylesheet" />
<script language="javascript" src="../js/popup.js">
</script>
<body style="margin: 0px;">
<div class="page">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<!--***********************************  BODY SECTION START ********************************** -->
	<tr>
		<td valign="top" align="center">

		<div class="loginBack">
		<div class="loginInside">
		<form action="j_security_check" name="login" id="login" method="post">
		<table width="90%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" align="left" colspan="2"><img
					src="../images/twitterLOGOMain.gif" border="0" /></td>
			</tr>

			<tr>
				<td valign="top" align="left" width="270">



				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="margin-top: 20px;">

					<%
                              		if(request.getParameter("status")==null) {
                              			color = "";
                          				loginCredentials="";
                              			response.sendRedirect("../faces/twt.jsp?status=logout");
                              		}
                              		else if(request.getParameter("status").equals("login"))	{
                              			request.getSession().setAttribute("info","login");
                              			if(request.getSession().getAttribute("f")==null){
                              				color = "";
                              				loginCredentials="";
                              			}
                              			else if(request.getSession().getAttribute("f").equals("failed")) {
                              				color="red";
                              				loginCredentials="Your login credentials are not valid. Please try "+
                              					"again.";
                              				request.getSession().setAttribute("f","");
		%>
					<table width="96%" border="0" cellpadding="0" cellspacing="0"
						style="border: 1px solid #F90011;">

						<tr>
							<td valign="top" align="left">

							<div
								style="float: left; display: inline; margin-right: 6px; margin-left: 0px; margin-top: 0px;">
							<img src="../images/warning.PNG" /></div>
							<div style="font-size: 9px; float: left; display: inline;"
								class="topChannelPerformanceDateLogin"><font
								style="font-weight: normal;color: <%=color%>;"><%=loginCredentials%></font>
							</div>
							</td>
						</tr>
						<%
                              			}
                              		}
                              		else if(request.getParameter("status").equals("logout"))	{
                              			request.getSession().setAttribute("info","logout");
                              			if(request.getSession().getAttribute("f")==null) {
                              				color = "";
                              				loginCredentials="";
                              			}
                              			else if(request.getSession().getAttribute("f").equals("failed")) {
                              				color="red";
                              				loginCredentials="Your login credentials are not valid. Please try "+
                          									 "again.";
                              				request.getSession().setAttribute("f","");
        %>
						<table width="96%" border="0" cellpadding="0" cellspacing="0"
							style="border: 1px solid #F90011;">

							<tr>
								<td valign="top" align="left">
								<div
									style="float: left; display: inline; margin-right: 6px; margin-left: 0px; margin-top: 0px;">
								<img src="../images/warning.PNG" /></div>
								<div style="font-size: 9px; float: left; display: inline;"
									class="topChannelPerformanceDateLogin"><font
									style="font-weight: normal;color: <%=color%>;"><%=loginCredentials%></font>
								</div>

								</td>
							</tr>
							<%
                              			}
                              		}
        %>
							<tr>
								<td id="uname" class="loginPassword" valign="top" align="left"
									style="margin: 5px;"><input type="text" name="j_username"
									value="Username"
									onfocus="if(this.value=='Username') this.value='';"
									class="inputbox" /></td>
							</tr>
							<tr>
								<td height="10"></td>
							</tr>
							<tr>
								<td id="pass" class="loginPassword" valign="top" align="left"
									style="margin: 5px;"><input type="password"
									name="j_password" value="Password"
									onfocus="if(this.value=='Password') this.value='';"
									class="inputbox" /></td>
							</tr>

							<tr>
								<td height="10"></td>
							</tr>

						</table>

						</td>

						<td valign="middle" align="left" style="padding-left: 20px;">
	 <%
                            if(request.getParameter("status").equals("login")) {
	 %> 
        <img src="../images/loginRightText.gif" border="0" /> 
     <%
                              }if(request.getParameter("status").equals("logout")) {
     %> 
     	<img src="../images/logoutRight.gif" width="389" height="107"
							alt="logout" usemap="#logout" border="0" /> <map name="logout">
							<area shape="rect" coords="8,84,233,99"
								href="http://getsatisfaction.com/twitteroptimizer" alt="logout"
								target="_blank" />
						</map> 
	 <%
                              		}
     %>
						</td>

						</tr>

						<tr>
							<td valign="bottom" align="left" height="30" colspan="2"><a
								href="#" class="forgot_password"
								onclick="openPopup('Forgot Password',324, 90, 777, 343, 10, false, true, false, '../forgotPassword.html')">forgot
							my password</a></td>
						</tr>
						<tr>
							<td height="45" valign="bottom" align="left" colspan="2"><input
								type="image" src="../images/login.gif"
								onmouseover="this.src='../images/loginRollover.gif'"
								onmouseout="this.src='../images/login.gif'" /></td>
						</tr>

						<tr>
							<td id="gap" colspan="2">&nbsp;</td>
						</tr>
					</table>
					</form>
					</div>
					</div>
					</td>
					</tr>

					<tr>
						<td valign="bottom" align="left" height="10">
						<div class="border"></div>
						</td>
					</tr>


					<!--***********************************  BODY SECTION END ********************************** -->
					<!--******************FOOTER START****************-->
					<tr>
						<td align="left" valign="top">
						<div class="footer">

						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top" align="left">
								<div class="footer_left">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="help" valign="top" align="left">Need help?</td>
									</tr>
									<tr>
										<td valign="top" align="left" class="matter">Email us- <a
											style="color: rgb(174, 206, 111); text-decoration: none;"
											onmouseout="this.style.fontSize='12px'; this.style.color='#AECE6F';"
											onmouseover="this.style.color='#63881A'; this.style.cursor='hand';"
											href="mailto:support@terametric.com">support@terametric.com</a>
										</td>
									</tr>
									<tr>
										<td valign="top" align="left">
										<div style="height: 15px;"></div>
										</td>
									</tr>
									<tr>
										<td valign="top" align="left" class="help">Get Twitter
										Optimizer for</td>
									</tr>
									<tr>
										<td valign="top" align="left"><font class="matter1">
										<a href="#" class="forgot_password"
											onclick="openPopup('Get Twitter Optimizer for iPhone',324, 90, 777, 560, 10, false, true, false, '../underConstructionIphone.html')"
											style="color: #AECE6F; text-decoration: none;"> iPhone </a> </font>
										<font class="help">|</font> <font class="matter1"> <a
											href="#" class="forgot_password"
											onclick="openPopup('Get Twitter Optimizer for Android',324, 90, 777, 560, 10, false, true, false, '../underConstructionAno.html')"
											style="color: #AECE6F; text-decoration: none;"> Android </a>
										</font></td>
									</tr>
									<tr>
										<td valign="top" align="left">
										<div style="height: 15px;"></div>
										</td>
									</tr>
									<tr>
										<td valign="top" align="left" class="help">Follow Us On</td>
									</tr>
									<tr>
										<td valign="top" align="left">
										<table width="350" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="center" valign="middle" class="matter1"
													width="40"><a href="http://twitter.com/terametric"
													target="_blank"
													style="color: #AECE6F; text-decoration: none;"> Twitter
												</a></td>
												<td align="center" valign="middle" width="30"><a
													href="http://twitter.com/terametric" target="_blank"> <img
													src="../images/twitterLogo.gif" border="0" /> </a></td>
												<td align="center" valign="middle" class="help" width="20">|</td>
												<td align="center" valign="middle" class="matter1"
													width="40"><a
													href="http://www.facebook.com/Terametric" target="_blank"
													style="color: #AECE6F; text-decoration: none;">
												Facebook </a></td>
												<td align="center" valign="middle" width="30"><a
													href="http://www.facebook.com/Terametric" target="_blank">
												<img src="../images/facebookLogo.gif" border="0" /> </a></td>
												<td align="center" valign="middle" class="help" width="20">|</td>
												<td align="center" valign="middle" class="matter1"
													width="40"><a
													href="http://www.linkedin.com/company/terametric"
													target="_blank"
													style="color: #AECE6F; text-decoration: none;">
												LinkedIn </a></td>
												<td align="center" valign="middle" width="30"><a
													href="http://www.linkedin.com/company/terametric"
													target="_blank"> <img src="../images/inLogo.gif"
													border="0" /> </a></td>
												<td align="center" valign="middle" class="help" width="20">|</td>
												<td align="center" valign="middle" class="matter1"
													width="40"><a
													href="http://terametric.com/component/wordpress/feed"
													target="_blank"
													style="color: #AECE6F; text-decoration: none;"> Updates
												</a></td>
												<td align="center" valign="middle" width="30"><a
													href="http://terametric.com/component/wordpress/feed"
													target="_blank"> <img src="../images/updatesLogo.gif"
													border="0" /> </a></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td valign="top" align="left">
										<div style="height: 10px;"></div>
										</td>
									</tr>
									<tr>
										<td valign="top" align="left"><font class="matter">Twitter
										Optimizer is a product of</font> <font class="matter1">Terametric.com</font>
										<font class="matter"> | </font> <font class="matter1">
										<a href="#" class="forgot_password"
											onclick="openPopup('Privacy & Security',324, 90, 777, 343, 10, false, true, false, '../security.html')"
											style="color: #AECE6F; text-decoration: none; font-size: 12px;">
										Privacy & Security </a> </font></td>
									</tr>
									<tr>
										<td valign="top" align="left" class="matter">&copy; 2010
										Great Minds Interactive, Inc. | Build ph XXXX.XXX.X</td>
									</tr>
								</table>
								</div>
								</td>
								<td valign="top" align="right"><!--<div class="footer_right">
                                        <img src="../images/ANLogo.gif" border="0" />
                                    </div>
                                --></td>
							</tr>
						</table>
						</div>
						</td>
					</tr>
					<!--******************FOOTER END****************-->
				</table>
				</div>
				<!--*********************************************** Total Page End *************************************************-->
				<!-- pupup -->
				<div id="floatingDiv" class="glass" style="display: none;">
				<div id="innerMainDiv" class="innerMain">

				<div class="header" id="popupHeader">
				<div class="menuItem demo active" title="containerIframe"></div>
				<div class="title" id="title"></div>
				<div class="close"><a href="#" onclick="closePopup()"> <img
					id="popupCloseButton" src="../images/close.gif"
					style="border: 0px; padding-top: 5px;" name="but1"
					onmouseover="document.but1.src='../images/closeRollovers.gif'"
					onmouseout="document.but1.src='../images/close.gif'" /> </a></div>
				</div>

				<iframe id="frame" width="10%" height="10%" frameborder="0"
					scrolling="auto"></iframe></div>
				</div>
				<div class="backDrop" id="backDrop" style="display: none;"></div>
</body>
</html>