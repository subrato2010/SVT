<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">
	
	<ui:define name="title">
		Overall Social Intelligence
	</ui:define>
	<ui:define name="menu">
		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{overallSIController }"/>
		</ui:include>
	</ui:define>
	<ui:define name="tabs">
		<ui:include src="/inc/siTabs.jsp">
			<ui:param name="currentTab" value="overallsi"/>
		</ui:include>
	</ui:define>
	<ui:define name="body_right_pannel">
		
		<table border="0" width="100%">
			<tr>
				<td>
		
		<!-- *************Body Right Pannel TOP Start ***************-->
		                                     
		<div class="right_pannel_social_inside">
		
			<table cellspacing="0" cellpadding="0" bgcolor="#ffffff" border="0" width="930" style="border-top: 1px solid #DBDCE0; border-right: 1px solid #DBDCE0;">
			<tr>
				<td style="padding-left:30px; border-right:3px solid #A1CE48; width: 600px">
				
					<object>
						<param name="movie" value="OverAllSocialIntelligence.swf"/>
						<param name="quality" value="high"/>
						<param name="wmode" value="transparent"/>
						<param name="allowscriptaccess" value="sameDomain"/>
						<param name="allowfullscreen" value="true"/>
						<embed type="application/x-shockwave-flash" wmode="transparent"
						src="../flash/OverAllSocialIntelligence.swf?dataXML=#{overallSIController.dataXml}"
						height="500px" width="750px"/>
					</object>
					
				</td> 
				<td bgcolor="#F6F6F6">
                                                                                    
                <div style="width:120px;height:100%;">
                
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td colspan="2" class="social_ident" align="center">Legend</td>                                    
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">NZ</td>
                                    <td align="center"><img src="../images/bar_social.gif" width="60" /></td>
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">ORCL</td>
                                    <td align="center"><img src="../images/yellow_round.jpg" /></td>
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">TDC</td>
                                    <td align="center"><img src="../images/red_round.jpg" /> </td>
                                  </tr>
                                  <tr>
                                    <td class="social_ident1">IBM</td>
                                    <td align="center"><img src="../images/green_round.jpg" /></td>
                                  </tr>
                </table>
                </div>
			 </td>
			</tr>

			<tr>
			<td align="left" style="border-right:3px solid #A1CE48" height="auto">
			
			
			<div style="overflow:auto; height:auto; width: 630px; margin-left: 55px;">
			  <table  cellspacing="0" cellpadding="0" border="0" width="620px;" height="100%">
                         <tr bgcolor="#F2F2F2">
                         	<td class="social_heading" style="text-align: left;">Name</td>
                           <td class="social_heading">Channel Type</td>
                           <td class="social_heading">Influencer Type</td>
                           <td class="social_heading">Total Article Volume</td>
                           <td class="social_heading">Sources</td>
                           <td class="social_heading">Top Domain</td>
                           <td class="social_heading">Top Theme</td>
                           <td class="social_heading">Sentiment Value</td>
                           <td class="social_heading">Energy Value</td>
                           <td class="social_heading">Trust Value</td>
                           <td class="social_heading">Influencer's Influence</td>
                           
                         </tr>
                         <a4j:repeat value="#{socialIntelligenceController.sentimentThemeList }" var="st" rowKeyVar="i">
                         <tr bgcolor="#{((i%2)==0)? '#FFFFFF' : '#F3F3F3'}">
                          <td class="social_text" style="text-align: left;">
                          	<a href="#"  onmouseover="this.style.color='#6F9426'; this.style.textDecoration='underline'; this.style.fontSize='11px'; this.style.cursor='hand';" onmouseout="this.style.fontSize='11px'; this.style.color='#7AC142'; this.style.textDecoration='none';" onclick="openPopup('#{st.influencerName}',324, 90, 777, 643, 10, false, true, false, 'sentiments.jsp?influencerName=#{st.influencerName}')">
                          		#{st.influencerName }
                          	</a>
                          </td>
                           <td class="social_text_inactive">#{st.channelType }</td>
                           <td class="social_text_inactive">#{st.influencerType }</td>
                           <td class="social_text_inactive">#{st.strTotalArticleVol }</td>
                           <td align="center">
                           	<table border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                  	<a4j:outputPanel rendered="#{st.topUserTwitter != null and !(st.topUserTwitter eq '')}">
                                    <td width="26" height="24">
                                    	<a href="#{st.topUserTwitter}" target="new">
                                    		<img src="../images/t.jpg" style="border:0px; padding-left:1px; padding-right:1px;"  onmouseover="this.src='../images/tRollover.gif'" onmouseout="this.src='../images/t.jpg'" width="26"/>
                                    	</a>
                                    </td>
                                    </a4j:outputPanel>
                                    
                                    <a4j:outputPanel rendered="#{st.topUserFacebook != null and !(st.topUserFacebook eq '')}">
                                    <td width="25" height="24">
                                    	<a href="#{st.topUserFacebook}" target="new"><img src="../images/f.jpg" style="border:0px;" onmouseover="this.src='../images/fRollover.gif'" onmouseout="this.src='../images/f.jpg'" width="25"/></a>
                                    </td>
                                    </a4j:outputPanel>
                                    
                                    <a4j:outputPanel rendered="#{st.topUserBlog != null and !(st.topUserBlog eq '')}">
                                    <td width="26" height="24">
                                    	<a href="#{st.topUserBlog}" target="new"><img src="../images/b.jpg" style="border:0px;"  onmouseover="this.src='../images/bRollover.gif'" onmouseout="this.src='../images/b.jpg'" width="26"/></a>
                                    </td>
                                    </a4j:outputPanel>
                                    
                                    <a4j:outputPanel rendered="#{st.topUserImage != null and !(st.topUserImage eq '')}">
                                    <td width="26" height="24">
                                    	<a href="#{st.topUserImage}" target="new"><img src="../images/h.jpg" style="border:0px;" onmouseover="this.src='../images/hRollover.gif'" onmouseout="this.src='../images/h.jpg'" width="26"/></a>
                                    </td>
                                    </a4j:outputPanel>
                                  </tr>
                             </table>
                           </td>
                           <td class="social_text">
                           	<a4j:outputPanel rendered="#{st.topDomainLink != null and !(st.topDomainLink eq '')}">
                           	    <a style="color:#7AC142;" href="#{st.topDomainLink }" target="new"  onmouseover="this.style.color='#6F9426'; this.style.textDecoration='underline'; this.style.fontSize='11px'; this.style.cursor='hand';" onmouseout="this.style.fontSize='11px'; this.style.color='#7AC142'; this.style.textDecoration='none';">Link</a>
                            </a4j:outputPanel>                        
                           </td>
                           <td class="social_text">
                           	<a href="#" onclick="openPopup('#{st.influencerName}',324, 90, 777, 643, 10, false, true, false, 'sentiments.jsp?influencerName=#{st.influencerName}&amp;themeName=#{st.topTheme}')"  onmouseover="this.style.color='#6F9426'; this.style.textDecoration='underline'; this.style.fontSize='11px'; this.style.cursor='hand';" onmouseout="this.style.fontSize='11px'; this.style.color='#7AC142'; this.style.textDecoration='none';">
                           	#{st.topTheme }
                           	</a>
                           </td>
                           <td class="social_text">#{st.strSentimentValue }</td>
                           <td class="social_text">#{st.strEnergyValue }</td>
                           <td class="social_text">#{st.strTrustValue }</td>
                           <td class="social_text">#{st.strInfluencerInfluence }</td> 
                           
                         </tr>
                         </a4j:repeat>
                                                             
                                                              
              </table>
              </div>
			
			
			
              </td>
              <td bgcolor="#f6f6f6"></td>
              </tr>
			</table>
		</div>
		<!-- *************Body Right Pannel TOP END ***************-->
		</td>
		</tr>
		<!-- *************Body Left Pannel BOTTOM Start ***************-->
		<tr>
		<td>
		<div class="right_pannel_bottom" id="body_bottom_open">
			<div class="wt_open">
				<table width="85%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
		
						<p class="matter_home">WHAT'S THIS?<font> <a
							href="javascript:closeMe('body_bottom_open','body_bottom_close')"
							class="close">CLOSE</a></font></p>
						<p class="matter_index">
							An overall measure of social intelligence measured by each communication channel. Each measure of social intelligence is influenced by "outliers", the highest and lowest channel scores.
						</p>
					</td>
					</tr>
				</table>
			</div>
		</div>
		<div style="background-color: #ffffff;">
			<div class="right_pannel_bottom" id="body_bottom_close" style="visibility: hidden;">
				<div class="wt_close">
					<table width="85%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
			
							<p class="matter_home">WHAT'S THIS?<font> <a
								href="javascript:closeMe('body_bottom_close','body_bottom_open')"
								class="close"> OPEN</a></font></p>
			
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		</td>
		</tr>
		</table>
		
		<!-- include popup div -->
		<ui:include src="inc/popup.jsf" />
		
		<!-- *************Body Right Pannel BOTTOM End ***************-->
	</ui:define>
</ui:composition>
