<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:t="http://myfaces.apache.org/tomahawk">
    
	    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
	    <link href="../css/popup.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="../js/designMainScreen.js"></script>
		<script language="JavaScript" src="../js/popup.js"></script>	

<f:view>
      <div class="page">

	  <h:form id="onloadFormValue" style="margin-top: 0px;">     
      <h:inputHidden id="tab1" value="#{channelPerformanceController.channelPerformanceTabClick}"/>
     </h:form>
     	<table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td valign="top" align="center">
                 <!--**************************TOP SECTION START*****************************-->
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
                      	<td align="left" valign="top">
                          
                          <div class="mainBodyTopTotal">
                        	  <a4j:include viewId="templates/twitterTemplates/topTemplateTwitter.jsp"/>
                                   	
		                         <div class="mainBodyTop">
									<table width="400" border="0" cellspacing="0" cellpadding="0"
										style="margin-left: 15px; margin-top: 41px;">
										<tr>
											<td valign="bottom" align="center" width="193"><img
												src="../images/channelPerformanceSelected.gif" border="0" /></td>
											<td width="10"></td>
											<td valign="bottom" align="center" width="177"><a
												href="twitterChannelOptimization.jsp"> <img
												src="../images/channelOptimizationGeneral.gif" border="0"
												style="margin-bottom: 4px;" /> </a></td>
											
							
										</tr>
									</table>
								</div>
							 <ui:include src="templates/twitterTemplates/templateDateTwitter.jsp">
							 </ui:include>
                                  
                         <div class="border">
						</div>
                          </div>
                          
                          </td>
                    </tr>
<!--********************************************* Body Top Section Start ****************************************--> 
                           
             <tr>
               <td valign="top" align="center">
                       <div class="bodyTop">
                          <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <!--************************* Body Top Second Section Start *********************-->             
                                <tr>
                                  <td valign="top" align="left">
                                                   <div class="bodyTopSecond">
                                                      <table width="99%" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                                                            <tr>
                                                                  <td colspan="9" bgcolor="#EDEDED" class="topFirsthd" valign="middle" align="left" width="300">Overall Performance</td>
                                                            </tr>
                                                            <tr>
                                                                  <td class="topFirstTablehdCategory" valign="middle" align="center" width="100"></td>
                                                                  
                                                                  <td class="topFirstTablehdCategory" valign="middle" align="center" style="padding-top: 15px;">
                                                                       <h:form id="overallForm">
                                                                       <table width="75" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                                                                             <tr>
                                                                               <td valign="middle" align="center" width="55">
                                                                               <a id="displayTextOM" href="javascript:toggleText('toggleTextOM','displayTextOM');" style="text-decoration: none;"  
                                                                               onmouseover="toggleMouseOver('toggleTextOM','displayTextOM');" 
                                                                               onMouseOut="toggleMouseOver('toggleTextOM','displayTextOM');"
                                                                               class="topFirstTablehdCategory">
                                                                               OVERALL
                                                                               </a>
                                                                               </td>
                                                                               <td valign="middle" align="left" width="20">
                                                                               
													                             <h:graphicImage value="../images/bulb.gif" 
																		         onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
																		        <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
																		            <span><h:outputText value="Your Overall Score is based on your Inbound and Outbound performance relative to your competitors. It is a gauge to track your marketing investment and return." /></span>
																		        </rich:toolTip>
																		   		</h:graphicImage>
                                                                               
                                                                               </td>
                                                                             </tr>
                                                                       </table>
       																   </h:form>
                                                                   
                                                                  </td>
        <h:form id="dashboardsiForm">                                                          
 		<ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="95"/>
				<ui:param name="siname" value="Sentiment"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextS','displayTextSentiment');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextS','displayTextSentiment');"/>				
				<ui:param name="scrollto" value="toggleTextS"/>
				<ui:param name="tooltip" value="Analysis of your brand, product and industry presence that measures positive, neutral and negative references in 'Twitterverse'."/>
		</ui:include>
		<ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="110"/>
				<ui:param name="siname" value="Engagement"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextE','displayTextEngagement');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextE','displayTextEngagement');"/>								
				<ui:param name="scrollto" value="toggleTextE"/>
				<ui:param name="tooltip" value="The level of engagement or dialogue that your Twitter profiles generate within the 'Twitterverse'. There are 5 levels of engagement and each calculates several metrics to score a Twitter profile on a scale of 1 (low) to 5 (high). The metrics used for measuring engagement include the following: # tweets/day, #tweets/week, # bit.ly url references/week, # hashtag references/week, # @mentions/replies/week, # retweets/week, # followers, # friends, # RT/day, # @mentions/week."/>
		</ui:include>
        <ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="90"/>
				<ui:param name="siname" value="Retention"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextRet','displayTextRetention');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextRet','displayTextRetention');"/>
				<ui:param name="scrollto" value="toggleTextRet"/>
				<ui:param name="tooltip" value="A measure of your ability javascript:scroll('Sentiment');to retain followers, engagement on topics relating to your industry, product and brand over time."/>
		</ui:include>                                                          
        <ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="110"/>
				<ui:param name="siname" value="Demographics"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextD','displayTextDemographics');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextD','displayTextDemographics');"/>
				<ui:param name="scrollto" value="toggleTextD"/>
				<ui:param name="tooltip" value="A measure of the characteristics of your friends, followers and influencers."/>
		</ui:include> 
		<ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="95"/>
				<ui:param name="siname" value="Loyalty"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextL','displayTextLoyalty');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextL','displayTextLoyalty');"/>
				<ui:param name="scrollto" value="toggleTextL"/>
				<ui:param name="tooltip" value="A measure of your ability to consistently reach as many influencers with your message through the 'Twitterverse'."/>
		</ui:include> 
		<ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="95"/>
				<ui:param name="siname" value="Influence"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextIn','displayTextInfluence');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextIn','displayTextInfluence');"/>
				<ui:param name="scrollto" value="toggleTextIn"/>
				<ui:param name="tooltip" value="A measure of many factors that relate to an ability to attract and maintain a strong following in Twitter. There are 5 levels of influence rated on a scale of 1 (low) to 5 (high). The metrics used for measuring influence including the following: follower/following ratio, # listing by your followers, # promoted tweets that have been RT (retweeted), # of replies, and positive average sentiment score."/>
		</ui:include> 
		<ui:include src="/dashboardSI.jsp">
				<ui:param name="tablewidth" value="75"/>
				<ui:param name="siname" value="Reach"/>
				<ui:param name="jvmethod" value="javascript:toggleText('toggleTextR','displayTextReach');"/>
				<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextR','displayTextReach');"/>
				<ui:param name="scrollto" value="toggleTextR"/>
				<ui:param name="tooltip" value="A measure of your ability to consistently reach as many influencers with your message through the 'Twitterverse'."/>
		</ui:include>  
		</h:form>                                                                 
        </tr>

		<!--  Loop here -->
		<h:form id="dashboardOverallDataForm">
		<a4j:repeat value="#{channelPerformanceController.overallPerformanceDummy}" var="overall" rowKeyVar="i">
			<tr>                                                            																
				<a4j:outputPanel rendered="#{overall.customer}">
					<td class="topFirstTablehdCategory1" valign="middle" align="center" width="100" bgcolor="#FBFBFB">Your Grade</td>
				</a4j:outputPanel>
				<a4j:outputPanel rendered="#{!(overall.customer)}">
					<td class="topFirstTablehdCategory1" valign="middle" align="center" width="100" bgcolor="#FBFBFB">Competitors'</td>
				</a4j:outputPanel>
				<td valign="middle" align="left" bgcolor="#F2F2F1" style="border-left:1px solid #E8E8E8">
					<table width="100" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="middle" align="right" class="topFirstTablehdCategory2">
								<a id="overallGrade" href="#toggleTextOM" onclick="javascript:toggleTextGradeClick('toggleTextOM','displayTextOM');"
									style="color:#{channelPerformanceController.overallColor}; text-decoration: none; font-size: 22px;">
									#{overall.overallGrade}
								</a>
							</td>
							<td valign="middle" align="center" width="25">									                
								
								<a onclick="openPopup11('Trending of Overall',false,270, 90, 860, 450, 10, false, true, false, 'trending.jsp')" href="#">
								
									<img src="../images/wave.gif" border="0"/>
								</a>  
							</td>
						</tr>
					</table>
				</td>

				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Sentiment"/>
						<ui:param name="gradevalue" value="#{overall.sentimentGrade}"/>
						<ui:param name="sentimentpopup" value="sentiments.jsp"/>
						<ui:param name="sentimentpopupicon" value="Sent1.gif"/>	
						<ui:param name="scrollto" value="toggleTextS"/>					
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextS','displayTextSentiment');"/>
				</ui:include>
				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Engagement"/>
						<ui:param name="gradevalue" value="#{overall.engagementGrade}"/>
						<ui:param name="sentimentpopup" value=""/>
						<ui:param name="sentimentpopupicon" value=""/>
						<ui:param name="scrollto" value="toggleTextE"/>
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextE','displayTextEngagement');"/>
				</ui:include> 
				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Retention"/>
						<ui:param name="gradevalue" value="#{overall.retentionGrade}"/>
						<ui:param name="sentimentpopup" value=""/>
						<ui:param name="sentimentpopupicon" value=""/>
						<ui:param name="scrollto" value="toggleTextRet"/>
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextRet','displayTextRetention');"/>
				</ui:include>
				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Demographics"/>
						<ui:param name="gradevalue" value="#{overall.demographicsGrade}"/>
						<ui:param name="sentimentpopup" value=""/>
						<ui:param name="sentimentpopupicon" value=""/>
						<ui:param name="scrollto" value="toggleTextD"/>
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextD','displayTextDemographics');"/>
				</ui:include>
				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Loyalty"/>
						<ui:param name="gradevalue" value="#{overall.loyaltyGrade}"/>
						<ui:param name="sentimentpopup" value=""/>
						<ui:param name="sentimentpopupicon" value=""/>
						<ui:param name="scrollto" value="toggleTextL"/>
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextL','displayTextLoyalty');"/>
				</ui:include>
				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Influence"/>
						<ui:param name="gradevalue" value="#{overall.influenceGrade}"/>
						<ui:param name="sentimentpopup" value="influencePopup.jsp"/>
						<ui:param name="sentimentpopupicon" value="inful1.gif"/>
						<ui:param name="scrollto" value="toggleTextIn"/>							
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextIn','displayTextInfluence');"/>
				</ui:include>
				<ui:include src="/dashboardOverallData.jsp">
						<ui:param name="tablewidth" value="100"/>
						<ui:param name="name" value="Reach"/>
						<ui:param name="gradevalue" value="#{overall.reachGrade}"/>
						<ui:param name="sentimentpopup" value=""/>
						<ui:param name="sentimentpopupicon" value=""/>
						<ui:param name="scrollto" value="toggleTextR"/>
						<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextR','displayTextReach');"/>
				</ui:include>
			</tr>                                     
            <tr>
                 <td  height="4" style="border-right:1px solid #E8E8E8;"></td>
                 <td colspan="8" height="4"></td>
           </tr>
		</a4j:repeat>
		</h:form>
		</table>
		</div>
	</td>
</tr>
                                 
                  <!--************************* Body Top Second Section End *********************-->             
                          </table>                                                           
                       </div>
                </td>
             </tr>
           </table>
<!--******************************************Body Top Section  End******************************************-->           
              </td>
         </tr>
         
         <tr>
         	<td>
         	<h:form id="targetListForm">
         	<table width="1050" border="0" style="margin-left:20px">
				<tr>
				<td width="900"></td>
				<td class="topFirstTablehdCategory" width="150" align="right">Change your Target:</td>
				<td align="right" valign="middle">
				<t:selectOneMenu id="changeTarget" value="#{channelPerformanceController.targetId}" immediate = "true" 
						 onchange="document.getElementById('templatedatetwitterForm:dummyholder1').value=this.value;"
						 style="width:130px; padding-left:0px; margin-left:0px; border:0px; color:#C6AD02; font-family:Arial, Helvetica, sans-serif; font-weight:bold; font-size: 12px;">				
                         <f:selectItems value="#{channelPerformanceController.targetOptions}"/>
                </t:selectOneMenu>
               </td>
              </tr>
              </table> 
              </h:form> 
         	</td>
         	
         </tr>
         <tr>
         	<td valign="bottom" align="left" height="10">
             		<div class="border"></div>
             </td>
         </tr>
         
<!--******************************************* OUTBOUND METRICES SECTION START ******************************************--> 
           <tr>
        	<td valign="top" align="left">
                <div class="bodyTopSecondChannelPerf">  
					<table width="1050" border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #D4D4D4;">
                        <tr  height="25">
                             <td width="24" align="center" valign="middle">
                            	 <a id="displayTextOM" href="javascript:toggleTextListBox('toggleTextOM','displayTextOM');"><img src="../images/grayDropDown.gif" border="0" /></a>
                				</td>
                             <td align="left" valign="middle" width="600">
                                 <table width="600" border="0" cellspacing="0" cellpadding="0">
                                       <tr>
                                         <td valign="middle" align="left">
                                         <h:form id="outboundmetricsForm" style="margin-top:5px; margin-bottom:5px">
                                         <table width="126" cellpadding="0" cellspacing="0">
                                         	<tr>
                                         		<td valign="middle" align="left" class="topFirstTablehdCategory">
                                         		Outbound Metrics
                                         		</td>
                                         		<td valign="middle" align="left">
                                         		<h:graphicImage value="../images/bulb.gif" 
												      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
												     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
												         <span><h:outputText value="A measure of activities that relate to your use of Twitter." /></span>
												     </rich:toolTip>
												</h:graphicImage>
                                         		</td>
                                         	</tr>
                                         
                                         </table>
                                         </h:form>

										 </td>
                                       </tr>
                                 </table>
                              </td>
                             <td align="center" valign="middle" width="158"></td>
                             <td align="center" valign="middle" width="170"></td>
                       </tr>
                 	</table>          
                    <div id="toggleTextOM" style="display: none">  
                    <h:form id="outboundMetricsForm1">        
                 	<table  width="1050" border="0" cellpadding="0" cellspacing="0">
	                 	<tr height="40">
	                 		<td width="24" class="topFirstTablehdCategory" valign="middle" align="center"></td>
	                 		<td width="170" class="topFirstTablehdCategory" style="padding-left:20px;" valign="middle" align="left">
	                 		 <font style="font-weight: normal;">(Sorted by most underperforming metric relative to the competitor average)</font></td>
	                 		<td width="120" valign="middle" align="center">
	                 		<table width="110" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 					<h:commandLink id="yv1" value="Your Volume" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="1" />
											<f:param name="col" value="yv" />
	                          			</h:commandLink>
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
							     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
							         <span><h:outputText value="A total count of metric activity." /></span>
							     </rich:toolTip>
							</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		</td>
	                 		<td width="225" class="topFirstTablehdCategory" valign="middle" align="center">
	                 		<table width="180" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 				<h:commandLink id="cv1" value="Your Competitors' Volume" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="1" />
											<f:param name="col" value="cv" />
	                          			</h:commandLink>
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="A total count of metric activity related to your competitors." /></span>
								     </rich:toolTip>
									</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		
	                 		  
	                 		</td>
	                 		<td width="110" valign="middle" align="center">
	                 		<table width="100" cellpadding="0" cellspacing="0">
	                 		<tr>
	                 			<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 			<h:commandLink id="yt1" value="Your Target" 
										actionListener="#{channelPerformanceController.submitQuery}" 
										style="color:#8B8B8B; text-decoration: none; background-image:none;">
										<f:param name="si" value="1" />
										<f:param name="col" value="yt" />
                          			</h:commandLink>
	                 			</td>
	                 			<td valign="middle" align="left">
	                 			<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
							     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
							         <span><h:outputText value="A measure of how far you are from your goal." /></span>
							     </rich:toolTip>
								</h:graphicImage>
	                 			</td>
	                 		</tr>
	                 		
	                 		</table>
	                 		</td>
	                 		<td width="100" valign="middle" align="center">
	                 		<table width="100" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 				<h:commandLink id="pi1" value="% Increase" 
										actionListener="#{channelPerformanceController.submitQuery}" 
										style="color:#8B8B8B; text-decoration: none; background-image:none;">
										<f:param name="si" value="1" />
										<f:param name="col" value="pi" />
                          			</h:commandLink>
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
								      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="The percentage you've increased your performance relative to your goal." /></span>
								     </rich:toolTip>
									</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		
	                 		</table>
	                 		
	                 		
	                 		</td>
	                 		<td width="150" valign="middle" align="left">
	                 		<table width="110" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="right" class="topFirstTablehdCategory" style="padding-right:4px">
	                 				Performance
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
								      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="Performance towards or against reaching your goal." /></span>
								     </rich:toolTip>
									</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		
	                 		</td>
	                 		<td width="170" class="topFirstTablehdCategory" valign="middle" align="center">
	                 		<table width="100" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="right" class="topFirstTablehdCategory" style="padding-right:4px">Alerts</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
								      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="TBD." /></span>
								     </rich:toolTip>
									</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		
	                 		</td>
	                 		<td width="100" class="topFirstTablehdCategory" valign="middle" align="center"></td>
	 					</tr>
                 <a4j:repeat value="#{channelPerformanceController.outboundMetricsDummy}" var="overallOutbounds" rowKeyVar="i">
                 <tr  bgcolor="#{(i%2==0)?('ededed'):('white')}">
                 		<td width="24" class="topFirstTablehdCategory" valign="middle" align="center"></td>
                 		<td width="170" class="topFirstTablehdCategory" valign="middle" align="left">
								<table width="130" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                                   <tr>
                                     <td align="left" valign="top">
                                        <div class="OM">
                                        #{overallOutbounds.metricsName}
                                        </div>
                                      </td>
                                      <td>
										<h:graphicImage value="../images/bulb.gif" 
										      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
										     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         <span><h:outputText value="#{overallOutbounds.metricsDesc}" /></span>
										     </rich:toolTip>
										</h:graphicImage>
                                      </td>
                                   </tr>
                               </table>
						</td>
                 		<td width="120" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">#{overallOutbounds.custVolumeFormatted}</td>
                 		<td width="225" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">#{overallOutbounds.cmptVolumeFormatted}</td>
                 		<td width="110" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">#{overallOutbounds.custTargetFormatted}</td>
                 		<td width="100" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">#{overallOutbounds.percentIncrease}%</td>
                 		<td width="150" class="topFirstTablehdCategoryDataLast" valign="middle" align="left">
						<a4j:repeat value="#{overallOutbounds.counter}">
							<h:graphicImage value="../images/orangeLogo.gif" 
						      onmouseover="this.src='../images/orangeLogo.gif';" onmouseout="this.src='../images/orangeLogo.gif';">
						     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
						         <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
						     </rich:toolTip>
							</h:graphicImage>
						</a4j:repeat>
								
						<a4j:repeat value="#{overallOutbounds.starCounter}">
							<h:graphicImage value="../images/yellowStar.gif" 
					      		onmouseover="this.src='../images/yellowStar.gif';" onmouseout="this.src='../images/yellowStar.gif';" style=" margin-right:5px">
					     		<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
					         		<span><h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." /></span>
					     		</rich:toolTip>
							</h:graphicImage> 
						</a4j:repeat>		     
						</td>
                 		<td width="170" class="topFirstTablehdCategoryDataLast1" valign="middle" align="left">#{overallOutbounds.alertMessage}</td>
                 		<td width="100" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
						<a href="twitterChannelOptimization.jsp">
							<img src="../images/optimizeButton.gif" border="0"/>
						</a>
						</td>
 					</tr>
 					</a4j:repeat>
                 </table>
                 </h:form>
               <div style="border:1px solid #D4D4D4; margin-top:10px;"></div>      
            </div>         
		</div>
	</td>
     </tr>
     
<!--********************************************* OUTBOUND METRICES SECTION END ***************************************    -->  
		<h:form id="dashboardSIDataForm">
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Inbound Metrics"/>
				<ui:param name="si" value="2"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextIM','displayTextOM');"/>
				<ui:param name="toggleId" value="toggleTextIM"/>
				<ui:param name="data" value="#{channelPerformanceController.inboundMetricsDummy}"/>
				<ui:param name="tooltip" value="A  measure of other's activity with your Twitter profile(s)."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Engagement"/>
				<ui:param name="si" value="3"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextE','displayTextEngagement');"/>
				<ui:param name="toggleId" value="toggleTextE"/>
				<ui:param name="data" value="#{channelPerformanceController.engagementDummy}"/>
				<ui:param name="tooltip" value="The level of engagement or dialogue that your Twitter profiles generate within the 'Twitterverse'. There are 5 levels of engagement and each calculates several metrics to score a Twitter profile on a scale of 1 (low) to 5 (high). The metrics used for measuring engagement include the following: # tweets/day, #tweets/week, # bit.ly url references/week, # hashtag references/week, # @mentions/replies/week, # retweets/week, # followers, # friends, # RT/day, # @mentions/week."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Reach"/>
				<ui:param name="si" value="4"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextR','displayTextReach');"/>
				<ui:param name="toggleId" value="toggleTextR"/>
				<ui:param name="data" value="#{channelPerformanceController.reachDummy}"/>
				<ui:param name="tooltip" value="A measure of your ability to consistently reach as many influencers with your message through the 'Twitterverse'."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Loyalty"/>
				<ui:param name="si" value="5"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextL','displayTextLoyalty');"/>
				<ui:param name="toggleId" value="toggleTextL"/>
				<ui:param name="data" value="#{channelPerformanceController.loyaltyDummy}"/>
				<ui:param name="tooltip" value="A measure of your ability to maintain and grow relationships within the 'Twitterverse'."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Demographics"/>
				<ui:param name="si" value="6"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextD','displayTextDemographics');"/>
				<ui:param name="toggleId" value="toggleTextD"/>
				<ui:param name="data" value="#{channelPerformanceController.demographicsDummy}"/>
				<ui:param name="tooltip" value="A measure of the characteristics of your friends, followers and influencers."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Retention"/>
				<ui:param name="si" value="7"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextRet','displayTextRetention');"/>
				<ui:param name="toggleId" value="toggleTextRet"/>
				<ui:param name="data" value="#{channelPerformanceController.retentionDummy}"/>
				<ui:param name="tooltip" value="A measure of your ability to retain followers, engagement on topics relating to your industry, product and brand over time."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Influence"/>
				<ui:param name="si" value="8"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextIn','displayTextInfluence');"/>
				<ui:param name="toggleId" value="toggleTextIn"/>
				<ui:param name="data" value="#{channelPerformanceController.influenceDummy}"/>
				<ui:param name="tooltip" value="A measure of many factors that relate to an ability to attract and maintain a strong following in Twitter. There are 5 levels of influence rated on a scale of 1 (low) to 5 (high). The metrics used for measuring influence including the following: follower/following ratio, # listing by your followers, # promoted tweets that have been RT (retweeted), # of replies, and positive average sentiment score."/>
		</ui:include>
		<ui:include src="/dashboardSIData.jsp">
				<ui:param name="tablewidth" value="1050"/>
				<ui:param name="siname" value="Sentiment"/>
				<ui:param name="si" value="9"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextS','displayTextSentiment');"/>
				<ui:param name="toggleId" value="toggleTextS"/>
				<ui:param name="data" value="#{channelPerformanceController.sentimentDummy}"/>
				<ui:param name="tooltip" value="Analysis of your brand, product and industry presence that measures positive, neutral and negative references in the 'Twitterverse'."/>
		</ui:include>
		</h:form>
         <tr>
             <td align="left" valign="top">
                 <a4j:include viewId="templates/twitterTemplates/footer.jsp"/>
             </td>
          </tr> 
<!--******************FOOTER END****************-->
    </table>
 </div>  
 </f:view>
 <script language="JavaScript" src="../js/onloadpage.js"></script>
<script>expandcategorylist("#{channelPerformanceController.si}", "#{channelPerformanceController.col}");</script>
<script>setProfileId("#{channelPerformanceController.twitterAccountId}", "#{channelPerformanceController.twitterAccountName}");</script>
</ui:composition>

