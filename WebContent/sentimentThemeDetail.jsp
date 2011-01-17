<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	<a4j:loadStyle src="../style/sentiment.css" />
	
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-store"/>	
	</head>
	<body marginheight="0" marginwidth="0" style="margin:0px;">
	<f:view>
		<h:form>
		<div class="total">
			<!-- #{sentimentThemeDetailController.paginator.currentList } -->
			<!-- Header Part -->
			<div class="heading_total">
				<div class="heading">
					<font class="heading_text">#{sentimentThemeDetailController.header}</font>
				</div>
				<div class="heading2">
					<font class="heading_text2">Channel:</font>
					<font class="heading_text3">#{sentimentThemeDetailController.currentChannelTop}</font>
				</div>
				<div class="heading3">
					<font class="heading_text4">Results #{sentimentThemeDetailController.paginator.begnningIndex} - #{sentimentThemeDetailController.paginator.endIndex} of #{sentimentThemeDetailController.paginator.totalListCount} influencers.</font>
				</div>
				<div class="border_toppannel"></div>

			</div> 
	
			<!-- Middle Part  -->
	
			<div class="lowerpart">
			<table cellspacing="0" cellpadding="0" >
				<a4j:repeat value="#{sentimentThemeDetailController.paginator.currentList }" var="sentiment" rowKeyVar="i">  
					<tr><td>
					<a4j:outputPanel rendered="#{!(sentiment.channelDto.channelName eq sentimentThemeDetailController.currentChannel)}">
						<div class="heading2" style="padding-left:12px;">
							<br/>
							<font class="heading_text2">Channel:</font>
							<font class="heading_text3">#{sentimentThemeDetailController.changedChannel}</font>
							<br/>
						</div>
					</a4j:outputPanel>
					<div class="#{(i%2)>0 ? 'matter_total_gray' : 'matter_total' }">
						<table cellspacing="0" cellpadding="0">
						<tr><td>
						<div class="matter">
							<div style="float:left; width:100%;">
								<font class="matter_text1">#{sentiment.influencerName}</font>
							</div>
							<div style="float:left; width:100%;">
								<font class="matter_text2">#{sentiment.description}</font>
							</div>
							<div style="float:left; width:100%;">
									<a style="text-decoration:none;" href="#{sentiment.link}" target="new"><font class="matter_text3">#{sentiment.link}</font></a>
							</div>
							<font class="matter_text2">#{sentiment.timeAgo } - on</font>
							<font class="matter_text3">#{sentiment.domainLink}</font>
						</div>
						</td></tr>
						<tr><td>
						<div class="matter1">
							<div class="left"><font class="left_text">#{sentiment.sentimentType}</font></div>
							<div class="left_img">
							<h:graphicImage value="../images/popup/heart.gif" border="0"  onmouseover="this.src='../images/popup/heartRollovers.gif'" onmouseout="this.src='../images/popup/heart.gif'">
					        <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
					           <span>Sentiment Value:<br/>This represents where the majority of emotions about a brand, product or industry fall on a scale of 1-5 (1 = very negative, 5 = very positive</span>
					        </rich:toolTip>
					   		</h:graphicImage>
							
							</div>
							<div class="left"><font class="left_text">#{sentiment.sentimentValue}</font></div>
							<div class="left_img">
							
							<h:graphicImage value="../images/popup/energy.gif" border="0"  onmouseover="this.src='../images/popup/energyRollovers.gif'" onmouseout="this.src='../images/popup/energy.gif'">
					        <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
					           <span>Energy Value:<br/>This represents the severity to which the majority of the audience feels the average sentiment value (1 = low, 5 = high).</span>
					        </rich:toolTip>
					   		</h:graphicImage>
							
							
							</div>
							<div class="left"><font class="left_text">#{sentiment.energyValue}</font></div>
							<div class="left_img">
							<h:graphicImage value="../images/popup/lock.gif" border="0"  onmouseover="this.src='../images/popup/lockRollovers.gif'" onmouseout="this.src='../images/popup/lock.gif'">
					        <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
					           <span>Trust Value:<br/>This represents the perception of credibility voiced about a brand, product or industry by the majority of the audience (1 = low, 5 = high).</span>
					        </rich:toolTip>
					   		</h:graphicImage>
							
							</div>
							<div class="left"><font class="left_text">#{sentiment.trustValue}</font></div>
						</div>
						</td></tr>
						</table>
					</div>
					</td></tr>
				</a4j:repeat>
				</table>
				<div style="height:20px;"></div>
			</div>

			<!-- Footer navigations -->
			<div class="footer">
				<div class="footer_left">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="0px"> 
								<h:outputLink value="sentimentThemeDetail.jsp" rendered="#{sentimentThemeDetailController.paginator.previousPossible }">
									<img src="../images/popup/pre.gif" border="0" />
									<f:param name="currentpage" value="#{sentimentThemeDetailController.currentPage - 1 }"/>
								</h:outputLink>
							</td> 
							
							<a4j:repeat value="#{sentimentThemeDetailController.paginator.pageIndexes}" var="index">
								
								<td width="41px" valign="middle" align="center" class="#{(index == sentimentThemeDetailController.currentPage)? 'selected' : 'nonSelected'}">
										<span class="linkSpan">
											<h:outputLink  value="sentimentThemeDetail.jsp" styleClass="index">
												#{index}
												<f:param name="currentpage" value="#{index}"/>
											</h:outputLink>	
										</span>	
								
								</td> 
								
							</a4j:repeat>
							
							<td width="0px"> 
								<h:outputLink styleClass="index" value="sentimentThemeDetail.jsp" rendered="#{sentimentThemeDetailController.paginator.nextPossible }">
									<img src="../images/popup/next.gif" border="0" />
									<f:param name="currentpage" value="#{sentimentThemeDetailController.currentPage + 1 }"/>
								</h:outputLink>
							</td> 
						</tr>
					</table>
				</div>
				
			</div>
		</div>
	</h:form>
	</f:view>
	</body>
</html>