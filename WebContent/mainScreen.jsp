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
	<script language="JavaScript" src="../js/swfobject.js"></script>
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/custom-form-elements.js"></script>
    <script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js"></script>
	<script language="JavaScript" src="../js/editProfile.js"></script>
	<script language="JavaScript" src="../js/twitterChannelNew.js"></script>
	<script language="JavaScript" src="../js/top.js"></script>
	<title>Channel Performance | Optimizer</title>
	<body style="margin: 0px;">
    <f:view>

<a4j:include viewId="templates/twitterTemplates/commonPopup.jsp" />
      <div class="page" id="pageT">
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
									<div class="mainScreenMenu">
										<div class="mainScreenMenuLeft">
											<img src="../images/channelPerformanceSelected.gif" border="0"/>
										</div>
										<div class="mainScreenMenuMiddle">
										</div>
										<div  class="mainScreenMenuRight">
											<a href="twitterChannelOptimization.jsp">
											<img src="../images/channelOptimization.gif" border="0"
											onmouseover="changeImage(this,'../images/channelOptimization_rollover.gif');" onmouseout="changeImage(this,'../images/channelOptimization.gif');"/>
											</a>
										</div>
									</div>
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
                                  <td valign="top" align="center">
                                            <div class="bodyTopSecond">
                                            	<div style="width: 1040px; height: auto;">
                                            		<div style="width: 1040px; background-color: #ededed;">
                                            	 		<div class="topFirsthd">Overall Performance
                                            	 		<h:graphicImage value="../images/bulb.gif" 
										       				onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
										      				<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										          				<span><h:outputText value="Your overall performance is a combination of your outbound and inbound performance. It is calculated for both you and your competitor average."
										          				 style="text-align: left;"/></span>
										      				</rich:toolTip>
										 				</h:graphicImage>
                                            	 		</div>
                                            	 	</div>
                                            	 	<div style="width: 1040px; height: auto;">
                                            	 		<div style="width: 110px; height: 20px; float: left;">
                                            	 		</div>
                                            	 		<h:form id="overallForm"  style="width:110px; float:left;">
                                            	 		<div style="width: 110px; height: 20px; float: left;"  class="topFirstTablehdCategory">
                                            	 		<a id="displayTextOM" href="javascript:toggleText('toggleTextOM','displayTextOM');" style="text-decoration: none;"  
                                                                        onmouseover="toggleMouseOver('toggleTextOM','displayTextOM');" 
                                                                        onMouseOut="toggleMouseOver('toggleTextOM','displayTextOM');"
                                                                        class="topFirstTablehdCategory">
                                                                        OVERALL
                                                                        </a>
                                                                        
						                             <h:graphicImage value="../images/bulb.gif" 
											         onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
											        <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
											            <span><h:outputText value="Your Overall Score is based on your Inbound and Outbound performance relative to your competitors. It is a gauge to track your marketing investment and return." /></span>
											        </rich:toolTip>
											   		</h:graphicImage>
                                            	 		</div>
                                            	 		</h:form>
                                            	 		
							     <h:form id="dashboardsiForm" style="float: left;">                                                          
							 		<div style="width: 816px; height: 20px; float: right;" class="topFirstTablehdCategory">
							 		   
							 		   <ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Sentiment"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextS','displayTextSentiment');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextS','displayTextSentiment');"/>				
											<ui:param name="scrollto" value="toggleTextS"/>
											<ui:param name="tooltip" value="Analysis of your brand, product and industry presence that measures positive, neutral and negative references in 'Twitterverse'."/>
									</ui:include>
									
							 		   <ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Engagement"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextE','displayTextEngagement');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextE','displayTextEngagement');"/>								
											<ui:param name="scrollto" value="toggleTextE"/>
											<ui:param name="tooltip" value="The level of engagement or dialogue that your Twitter profiles generate within the 'Twitterverse'. There are 5 levels of engagement and each calculates several metrics to score a Twitter profile on a scale of 1 (low) to 5 (high). The metrics used for measuring engagement include the following: # tweets/day, #tweets/week, # bit.ly url references/week, # hashtag references/week, # @mentions/replies/week, # retweets/week, # followers, # friends, # RT/day, # @mentions/week."/>
									</ui:include>
									<ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Conversion"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextRet','displayTextConversion');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextRet','displayTextConversion');"/>
											<ui:param name="scrollto" value="toggleTextRet"/>
											<ui:param name="tooltip" value="A measure of activity that Twitter drives to your online marketing channels."/>
									</ui:include>                                                          
							        <ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Demographics"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextD','displayTextDemographics');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextD','displayTextDemographics');"/>
											<ui:param name="scrollto" value="toggleTextD"/>
											<ui:param name="tooltip" value="A measure of the characteristics of your friends, followers and influencers."/>
									</ui:include> 
									<ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Loyalty"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextL','displayTextLoyalty');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextL','displayTextLoyalty');"/>
											<ui:param name="scrollto" value="toggleTextL"/>
											<ui:param name="tooltip" value="A measure of your ability to consistently reach as many influencers with your message through the 'Twitterverse'."/>
									</ui:include> 
									<ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Influence"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextIn','displayTextInfluence');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextIn','displayTextInfluence');"/>
											<ui:param name="scrollto" value="toggleTextIn"/>
											<ui:param name="tooltip" value="A measure of many factors that relate to an ability to attract and maintain a strong following in Twitter. There are 5 levels of influence rated on a scale of 1 (low) to 5 (high). The metrics used for measuring influence including the following: follower/following ratio, # listing by your followers, # promoted tweets that have been RT (retweeted), # of replies, and positive average sentiment score."/>
									</ui:include> 
									<ui:include src="/dashboardSI.jsp">
											
											<ui:param name="siname" value="Reach"/>
											<ui:param name="jvmethod" value="javascript:toggleText('toggleTextR','displayTextReach');"/>
											<ui:param name="jvmethod1" value="javascript:toggleMouseOver('toggleTextR','displayTextReach');"/>
											<ui:param name="scrollto" value="toggleTextR"/>
											<ui:param name="tooltip" value="A measure of your ability to consistently reach as many influencers with your message through the 'Twitterverse'."/>
									</ui:include> 
									</div>  
								</h:form>			
                                            	 	</div>
                                            	 	<h:form id="dashboardOverallDataForm">
													
                                            	 		<a4j:repeat value="#{channelPerformanceController.overallPerformanceDummy}" var="overall" rowKeyVar="i">
                                            	 		<div id="mainOverallTotalBox">
                                             	 		<div id="mainOverallTotalBoxLeft" class="topFirstTablehdCategory">
	                                             	 		<a4j:outputPanel rendered="#{overall.customer}">
	                                             	 		<div id="mainOverallTotalBoxLeft1">Your Grade</div>
	                                             	 		</a4j:outputPanel>
	                                             	 		<a4j:outputPanel rendered="#{!(overall.customer)}">
	                                             	 		<div id="mainOverallTotalBoxLeft1">Competitors'</div>
	                                             	 		</a4j:outputPanel>
                                             	 		</div>
                                            	 		<div id="mainOverallTotalBoxMiddle" class="topFirstTablehdCategory">
                                            	 		<table width="75" height="35" align="center">
                                            	 		<tr>
                                            	 			<td valign="top" align="center">
                                             	 			<div id="mainOverallTotalBoxLeftData" style="margin-top: 2px;">
											<a id="overallGrade" href="#toggleTextOM" onclick="javascript:toggleTextGradeClick('toggleTextOM','displayTextOM');"
											style="color:F79902; text-decoration: none; font-size: 22px; font-weight:bold;">
											#{overall.overallGrade}
											</a>
										</div>
								<div id="mainOverallTotalBoxLeftImg">
									<a onclick=	'document.getElementById("captionDiv_y").innerHTML=document.getElementById("captionDiv").innerHTML; document.getElementById("dashboardOverallDataForm:trendGraph:graphPerformanceEndDateInputDate").value=document.getElementById("templatedatetwitterForm:performanceEndDateInputDate").value; populateValueForTendingGraph("#{overall.customer}","Overall", "1")' href="#">								
										  <img src="../images/wave.gif"  border="0"  style="margin-top:4px"/>
									</a>									
								</div>
                                            	 			</td>
                                            	 		</tr>
                                            	 		</table>
                                            	 		
                                            	 		</div>
                                            	 		<div id="mainOverallTotalBoxRight" class="topFirstTablehdCategory">
					               <ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>					               
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Sentiment"/>
											<ui:param name="gradevalue" value="#{overall.sentimentGrade}"/>
											<ui:param name="sentimentpopup" value="sentiments.jsp"/>
											<ui:param name="sentimentpopupicon" value="Sent1.gif"/>	
											<ui:param name="scrollto" value="toggleTextS"/>					
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextS','displayTextSentiment');"/>
									</ui:include>
									<ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>									
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Engagement"/>
											<ui:param name="gradevalue" value="#{overall.engagementGrade}"/>
											<ui:param name="sentimentpopup" value=""/>
											<ui:param name="sentimentpopupicon" value=""/>
											<ui:param name="scrollto" value="toggleTextE"/>
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextE','displayTextEngagement');"/>
									</ui:include> 
									<ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Conversion"/>
											<ui:param name="gradevalue" value="#{overall.retentionGrade}"/>
											<ui:param name="sentimentpopup" value=""/>
											<ui:param name="sentimentpopupicon" value="dollar.png"/>
											<ui:param name="scrollto" value="toggleTextRet"/>
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextRet','displayTextConversion');"/>
									</ui:include>
									<ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Demographics"/>
											<ui:param name="gradevalue" value="#{overall.demographicsGrade}"/>
											<ui:param name="sentimentpopup" value=""/>
											<ui:param name="sentimentpopupicon" value=""/>
											<ui:param name="scrollto" value="toggleTextD"/>
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextD','displayTextDemographics');"/>
									</ui:include>
									<ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Loyalty"/>
											<ui:param name="gradevalue" value="#{overall.loyaltyGrade}"/>
											<ui:param name="sentimentpopup" value=""/>
											<ui:param name="sentimentpopupicon" value=""/>
											<ui:param name="scrollto" value="toggleTextL"/>
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextL','displayTextLoyalty');"/>
									</ui:include>
									<ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>									
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Influence"/>
											<ui:param name="gradevalue" value="#{overall.influenceGrade}"/>
											<ui:param name="sentimentpopup" value="influencePopup.jsp"/>
											<ui:param name="sentimentpopupicon" value="inful1.gif"/>
											<ui:param name="scrollto" value="toggleTextIn"/>							
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextIn','displayTextInfluence');"/>
									</ui:include>
									<ui:include src="/dashboardOverallData.jsp">
											<ui:param name="customer" value="#{overall.customer}"/>									
											<ui:param name="tablewidth" value="100"/>
											<ui:param name="name" value="Reach"/>
											<ui:param name="gradevalue" value="#{overall.reachGrade}"/>
											<ui:param name="sentimentpopup" value=""/>
											<ui:param name="sentimentpopupicon" value=""/>
											<ui:param name="scrollto" value="toggleTextR"/>
											<ui:param name="jvmethod" value="javascript:toggleTextGradeClick('toggleTextR','displayTextReach');"/>
									</ui:include>
                                            	 		</div>
                                            	 		
                                            	 	</div>
                                            	 	
                                            	 	</a4j:repeat>
                                            	 	
                                            	 	 <a4j:include viewId="trending.jsp" id="trendGraph"/>
                                            	 		</h:form>
                                            		
                                            	</div>
                                               
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
         	<h:form id="targetListForm" style="margin:0px">        	
         	<table width="1050" border="0" style="margin-left:20px">
				<tr>
				<td width="900"></td>
				<td class="topFirstTablehdCategory" width="150" align="right">Change your Target:
					<h:graphicImage value="../images/bulb.gif" 
		         		onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
				        <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
				            <span><h:outputText value="Your target is the level of improvement that you choose as your goal. You can change your target to reflect how aggressively you'd like to improve your performance relative to your competitors." /></span>
				        </rich:toolTip>
		   			</h:graphicImage>
				</td>
				<td align="right" valign="middle">
				<t:selectOneMenu id="changeTarget" value="#{channelPerformanceController.targetId}" immediate = "true" 						 
						 onchange="document.getElementById('templatedatetwitterForm:dummyholder1').value=this.value;						 
						 change();
                         document.getElementById('targetSelected').value='changedtarget';
						 clickLink('templatedatetwitterForm:fromprofilesubmit');"
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
	                 		<td width="170" class="topFirstTablehdCategory" valign="middle" align="left">
	                 		 <font style="font-weight: normal;">(Sorted by most underperforming metric relative to the competitor average)</font></td>
	                 		<td width="120" valign="middle" align="center">
	                 		<table width="110" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 					<h:commandLink id="yv1" value="Your Average Daily Volume (Current)" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="1" />
											<f:param name="col" value="yv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
							     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
							         <span><h:outputText value="We calculate the Average Daily Volume by taking an average of your volumes for the previous 14 days." /></span>
							     </rich:toolTip>
							</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		</td>	                 		
	                 		<td width="225" class="topFirstTablehdCategory" valign="middle" align="center">
	                 		<table width="190" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 				<h:commandLink id="cv1" value="Competitors' Average Daily Volume (Current)" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="1" />
											<f:param name="col" value="cv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
								     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
								         <span><h:outputText value="We calculate the Average Daily Volume by taking an average of your competitors' volumes for the previous 14 days." /></span>
								     </rich:toolTip>
									</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		
	                 		  
	                 		</td>
	                 		<td width="120" valign="middle" align="center">
	                 		<table width="110" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 					<h:commandLink id="yb1" value="Your Average Daily Volume (Benchmark)" 
											actionListener="#{channelPerformanceController.submitQuery}" 
											style="color:#8B8B8B; text-decoration: none; background-image:none;">
											<f:param name="si" value="1" />
											<f:param name="col" value="yv" />
											<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
											<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
	                          			</h:commandLink>
	                 				</td>
	                 				<td valign="middle" align="left">
	                 				<h:graphicImage value="../images/bulb.gif" 
							      onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulb.gif';">
							     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
							         <span><h:outputText value="Your baseline average daily volume or the date your campaign started." /></span>
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
										<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
										<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
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
	                 		<!--<td width="100" valign="middle" align="center">
	                 		<table width="100" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="center" class="topFirstTablehdCategory">
	                 				<h:commandLink id="pi1" value="% Increase" 
										actionListener="#{channelPerformanceController.submitQuery}" 
										style="color:#8B8B8B; text-decoration: none; background-image:none;">
										<f:param name="si" value="1" />
										<f:param name="col" value="pi" />
										<f:param name="minDate" value="#{channelPerformanceController.minDate}" />
										<f:param name="maxDate" value="#{channelPerformanceController.maxDate}" />
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
	                 		--><td width="150" valign="middle" align="center">
	                 		<table width="110" cellpadding="0" cellspacing="0">
	                 			<tr>
	                 				<td valign="middle" align="right" class="topFirstTablehdCategory" style="padding-right:4px">
	                 				Campaign Progress
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
								         <span><h:outputText value="Alerts are notifications of real time activity in Twitter that has been captured for you to act on and improve your performance." /></span>
								     </rich:toolTip>
									</h:graphicImage>
	                 				</td>
	                 			</tr>
	                 		</table>
	                 		
	                 		</td>
	                 		<td width="100" class="topFirstTablehdCategory" valign="middle" align="center"></td>
	 					</tr>
                 <a4j:repeat value="#{rtopHandler.outboundMetricsDummy}" var="overallOutbounds" rowKeyVar="i">
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
                 		<td width="120" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
                 			<table cellspacing="0" cellpadding="0" border="0" width="120">
									<tr>
										<td class="topFirstTablehdCategoryDataLast" align="center" valign="middle">
											<a4j:outputPanel rendered="#{overallOutbounds.dataProcessed}">#{overallOutbounds.custVolumeRoundUp}</a4j:outputPanel>
											<a4j:outputPanel rendered="#{!(overallOutbounds.dataProcessed)}"><img src="../images/gears.gif" border="0"/></a4j:outputPanel>
										</td>
										<td  align="left" valign="middle" width="30">
											<a4j:outputPanel rendered="#{(overallOutbounds.custVolumeTrend == 1)}">
												<h:graphicImage value="../images/uparrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Up: Volume over the last 14 days has been trending up overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
											</a4j:outputPanel>
											<a4j:outputPanel rendered="#{(overallOutbounds.custVolumeTrend == -1)}">
												<h:graphicImage value="../images/downarrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Down: Volume over the last 14 days has been trending down overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
											</a4j:outputPanel>
										</td>
									</tr>
								</table>	
                 		</td>
                 		<td width="225" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
                 			<table cellspacing="0" cellpadding="0" border="0" width="120">
								<tr>
									<td class="topFirstTablehdCategoryDataLast" align="center" valign="middle">
										<a4j:outputPanel rendered="#{overallOutbounds.dataProcessed}">#{overallOutbounds.cmptVolumeRoundUp}</a4j:outputPanel>
										<a4j:outputPanel rendered="#{!(overallOutbounds.dataProcessed)}">NA</a4j:outputPanel>
									</td>
									<td  align="left" valign="middle" width="30">
										<a4j:outputPanel rendered="#{(overallOutbounds.cmptVolumeTrend == 1)}">
											<h:graphicImage value="../images/uparrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Up: Volume over the last 14 days has been trending up overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
										</a4j:outputPanel>
										<a4j:outputPanel rendered="#{(overallOutbounds.cmptVolumeTrend == -1)}">
											<h:graphicImage value="../images/downarrow.gif" style="border: 0">
													<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										         		<span>
										         			<h:outputText value="Trending Down: Volume over the last 14 days has been trending down overall." />
										         		</span>
										     		</rich:toolTip>
												</h:graphicImage>
										</a4j:outputPanel>
									</td>
								</tr>
							</table>
                 		</td>
                 		<td width="120" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
							<a4j:outputPanel rendered="#{overallOutbounds.dataProcessed}">#{overallOutbounds.calculatedYourVolumeRoundUp}</a4j:outputPanel>
							<a4j:outputPanel rendered="#{!(overallOutbounds.dataProcessed)}">NA</a4j:outputPanel>
                 		</td>
                 		<td width="110" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
							<a4j:outputPanel rendered="#{overallOutbounds.dataProcessed}">#{overallOutbounds.currentTargetRawString}</a4j:outputPanel>
							<a4j:outputPanel rendered="#{!(overallOutbounds.dataProcessed)}">NA</a4j:outputPanel>
                 		</td>
                 		<!--
                 		<td width="100" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
                 			<a4j:outputPanel rendered="#{overallOutbounds.dataProcessed}">#{overallOutbounds.percentIncreaseRawScale100}%</a4j:outputPanel>
							<a4j:outputPanel rendered="#{!(overallOutbounds.dataProcessed)}">NA</a4j:outputPanel>
                 		</td>
                 		-->
                 		<td width="150" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
						<a4j:repeat value="#{overallOutbounds.counter}">
							<h:graphicImage value="../images/orangeFlameSmall.gif" 
						      onmouseover="this.src='../images/orangeFlameSmall.gif';" onmouseout="this.src='../images/orangeFlameSmall.gif';">
						     <rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
						         <span><h:outputText value="Flames represent actual performance degradation in this metric." /></span>
						     </rich:toolTip>
							</h:graphicImage>
						</a4j:repeat>
								
						<a4j:repeat value="#{overallOutbounds.starCounter}">
							<h:graphicImage value="../images/yellowStarSmall.gif" 
					      		onmouseover="this.src='../images/yellowStarSmall.gif';" onmouseout="this.src='../images/yellowStarSmall.gif';" style=" margin-right:5px">
					     		<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
					         		<span><h:outputText value="Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal." /></span>
					     		</rich:toolTip>
							</h:graphicImage> 
						</a4j:repeat>		     
						</td>
                 		<td valign="middle" align="left" width="100">
                 		
                 		<table style="table-layout: fixed;" class="topFirstTablehdCategoryDataLast1">
						    <tr>
						        <td valign="top" align="left">#{overallOutbounds.alertMessage}</td>
						    </tr>
						</table>
                 		
                 		
                 		</td>
                 		<td width="100" class="topFirstTablehdCategoryDataLast" valign="middle" align="center">
<a4j:outputPanel rendered="#{overallOutbounds.containsAlertMessage}">
	<a4j:commandLink id="optimizeButton" actionListener="#{channelPerformanceController.optimizeButtonClick}" onclick="change()"
		oncomplete="window.location.href='twitterChannelOptimization.jsp';">
			<img src="../images/optimizeButton.gif" border="0"/>
			<a4j:actionparam name="optimizeAction" value="#{overallOutbounds.alertMessageDTO.jspPageToDisplay}"/>
	</a4j:commandLink>       						                  				
</a4j:outputPanel>			
                		</td>
 					</tr>
 					</a4j:repeat>
                 </table>
                 <h:inputHidden id="selectedHandler" value="#{rtopHandler.selectedHandler}" />
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
				<ui:param name="siname" value="Conversion"/>
				<ui:param name="si" value="7"/>
				<ui:param name="jvmethod" value="javascript:toggleTextListBox('toggleTextRet','displayTextConversion');"/>
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
      </body>
 <script language="JavaScript" src="../js/onloadpage.js"></script>
<script>
   var text = document.getElementById('templatedatetwitterForm:clickedSentiment').value;
   if(text.indexOf("OVERALL") >= 0){
	   //toggleTextListBox('toggleTextIM','displayTextOM');
	   toggleText('toggleTextOM','displayTextOM');
   }
   if(text.indexOf("Sentiment") >= 0){
	   toggleTextListBox('toggleTextS','displayTextSentiment');
   }
   if(text.indexOf("Engagement") >= 0){
	   toggleTextListBox('toggleTextE','displayTextEngagement');
   }
   if(text.indexOf("Conversion") >= 0){
	   toggleTextListBox('toggleTextRet','displayTextConversion');
   }
   if(text.indexOf("Demographics") >= 0){
	   toggleTextListBox('toggleTextD','displayTextDemographics');
   }
   if(text.indexOf("Loyalty") >= 0){
	   toggleTextListBox('toggleTextL','displayTextLoyalty');
   }
   if(text.indexOf("Influence") >= 0){
	   toggleTextListBox('toggleTextIn','displayTextInfluence');
   }
   if(text.indexOf("Reach") >= 0){
	   toggleTextListBox('toggleTextR','displayTextReach');
   }		   
</script>
<script>expandcategorylist("#{channelPerformanceController.si}", "#{channelPerformanceController.col}");</script>
<script>setProfileId("#{channelPerformanceController.twitterAccountId}", "#{channelPerformanceController.twitterAccountName}");</script>
<script>setSelectedHandler("#{channelPerformanceController.twitterAccountName}");</script>

<script language="JavaScript">
  function populateValueForTendingGraph(self, category, mode){
	  document.getElementById('templatedatetwitterForm:trendingCategory').value = category;
	  document.getElementById('templatedatetwitterForm:trendingSelf').value = self;
	  document.getElementById('templatedatetwitterForm:trendingMode').value = mode;
	  clickLink('templatedatetwitterForm:viewTrendingHidden');
  } 
 </script>

</ui:composition>

	

