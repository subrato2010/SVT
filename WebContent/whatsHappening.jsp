<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	
<script language="JavaScript" src="../js/calenderComp.js"></script>
<script language="JavaScript" src="../js/flexGeoPopup.js"></script>
<script language="JavaScript" src="../js/popup.js"></script>
<script language="JavaScript" src="../js/date.format.js"></script>


<f:view contentType="text/html">
	<a4j:outputPanel id="whatsHappening">
	
	<!-- When you are rerending this panel, the object is not creating properly, so
	     the below block is moved out from rtopapi.js to here... -->
	<script language="JavaScript">
	//<![CDATA[
	jQuery(function() {
		keywordArr = #{rtopHandler.keywordsJSArray};
	    var txt = jQuery('#tweet');
	    txt.data('timeout', null);
	    txt.keyup(function() {
	        clearTimeout(jQuery(this).data('timeout'));
	        jQuery(this).data('timeout', setTimeout(doQuery, 200));
	        jQuery(this).data('timeout', setTimeout(function(){doGrade(keywordArr);}, 200));
	    });
	});
	//]]>
	</script>
	
	
	
	<h:form id="happenning" style="margin: 0px;">
		
		<input type="hidden" id="timezonename" name="timezonename" value=""/>
		
		<input type="hidden" id="autoDate" name="autoDate" value=""/>
		<input type="hidden" id="autoTime" name="autoTime" value=""/>
	
	       <div id="happeningTotalDiv" class="HappeningTotal" onclick="document.getElementById('WhatHappenDrop').style.display='none';document.getElementById('WhatHappenDropDiv').style.display='none';">
	       		
	       		<div class="HappeningTotalTop">
	       			<div class="HappeningTotalTopTitle">
		       			<table width="100%" height="30" cellpadding="0" cellspacing="0" border="0">
			       			<tr>
				       			<td valign="middle" align="left" class="TitleHappeningStyle">
				       			COMPOSE &amp; SCHEDULE
				       			</td>
			       			</tr>
		       			</table>
	       			</div>
	       		</div>
	       		
	       		<div id="happeningLoader_none" class="happeningLoader">
			    	<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="center"><img id="preloader" src="../images/preloader3.gif" alt="preloader"/></td>
						</tr>
					</table>
				</div>
				
	       		<div class="HappeningBottomTotal">
	       			
	       			<div class="HappeningBottomLeft">
	       				<div class="HappeningBottomLeftImg">
	       					<img src="#{twitterController.ownerProfileImage}"/>
	       				</div>
	       				<div class="HappeningBottomLeftText">
		       				<div style="width: 305px; height: 80px;">
		       					<h:inputTextarea value="#{twitterController.twtmessage}" cols="45" rows="4" id="tweetInput" 
		       					styleClass="RTOWhatsHappeningText" 
		       					onkeydown="countTweetLimitChars(this,'none');checkChar(event,this,'none');" 
		       					onkeyup="countTweetLimitChars(this,'none'); firehiddenTextarea(this,'tweet');" 
		       					onfocus="countTweetLimitChars(this,'none');document.getElementById('indexClk').value='none';"/>
		       				</div>		       				
		       				
		       				<div id="type" style="width: 0px; height: 0px;">
								<textarea id="tweet" cols="45" rows="3" class="RTOWhatsHappeningText" style="visibility: hidden;"></textarea>
							</div>
							
		       				<div id="WhatHappenDropDiv" class="happeningDropTotal"></div>
		       				
		       				<input type="hidden" id="objFrom" value=""/>
		       						       				
		       				<input type="hidden" name="scheduleType_none" id="scheduleType_none" value="A"/>
		       				<input type="hidden" id="textSelected" name="textSelected_none" value=""/>
		       				<input type="hidden" id="textSelectedForGrade" name="textSelectedForGrade_none" value=""/>
		       				
		       				<a4j:commandLink id="viewTextSuggestionHidden" reRender="suggestionInstance,overallComposeFirstPanel"
		       					actionListener="#{rtopHandler.viewTextSuggestion}" style="text-decoration: none; visibility: hidden;" 
								onclick="renderDivs('none');" oncomplete="resetDivs('none');">
								<f:param name="suggestionTokenAction" value="viewTextSuggestion"/>
							
							</a4j:commandLink>
		       				
	       					<a4j:outputPanel id="suggestionInstance">
	       						
		       					<div id="WhatHappenDrop" class="happeningDropTotal">
		       					
		       					<a4j:outputPanel rendered="#{!rtopHandler.tokenAvailable}">
									<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="center">
												<div class="noSuggestion" onclick="hideSuggestionText('none');">No Result! <br/> Click Here to close</div>
											</td>
										</tr>
									</table>
	    						</a4j:outputPanel>
		                        	
		                        	<div id="whatsHappeningSuggestText" style="height: auto; width: 295px;">
			                        	<a4j:repeat value="#{rtopHandler.textSuggestionTokens}" var="suggestionTokens" rowKeyVar="i">
				                        	
				                        	<table width="90%" height="auto" border="0" cellpadding="0" cellspacing="0">
				                        	<tr>
				                        		<td valign="top" align="center">
				                        			<div id="dropdownHappen#{i}" class="dropdownHappenSize"> 
				                        				<div class="dropdownHappenLeft">
				                        					                        					
				                        					<a4j:commandLink value="#{suggestionTokens.name}" styleClass="textSuggestName"
				                        					onmouseover="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#E2EECB';"
				                        					onmouseout="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#ffffff';"
				                        					onclick="setSelectedText('#{suggestionTokens.name}','none');"/>
				                        					
				                        				</div>
				                        				<div class="dropdownHappenRight">
							                        		<table width="130" cellpadding="0" cellspacing="0" border="0">
							                        			<tr>
							                        				<td valign="top" align="left">
							                        				<div class="dropdownHappenRightFirst">
							                        				
							                        					<a4j:commandLink value="#{suggestionTokens.abscount} INSTANCES" styleClass="textSuggestCount"
				                        									onmouseover="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#E2EECB';" 
				                        									onmouseout="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#ffffff';"
				                        									onclick="setSelectedText('#{suggestionTokens.name}','none');"/>
							                        				</div>
							                        				</td>
							                        				
							                        				<td width="10" valign="top" align="left">
							                        					<a4j:outputPanel rendered="#{suggestionTokens.trendup}"><img src="../images/happenUpArrow.gif" border="0"/></a4j:outputPanel>
							                        					<a4j:outputPanel rendered="#{!(suggestionTokens.trendup)}"><img src="../images/happenDownArrow.gif" border="0"/></a4j:outputPanel>
							                        				</td>
							                        			</tr>
							                        		</table>
				                        				</div>
				                        			</div>
				                        		</td>
				                        	</tr>
				                        	</table>
			                        	</a4j:repeat>
		                        	</div>	
		                        </div>
	                        </a4j:outputPanel>
	                        
	                        <div class="HappenBottomLeftMiddle2"   id="whatisHappeningGEO">
	                        <table>
	                        <!--
	                        	<tr id="innerTR">
	                        		<td width="150">
	                        			<div id="getLocFromFlex" onclick="viewPopup(this);"
			                        		 style="font-weight: normal; color: rgb(126, 190, 76); font-size: 14px; font-style: normal;
				                              	font-variant: normal; cursor: pointer; text-decoration: none">
				                              	Add your location
			                        	</div>
	                        		</td>
	                        		<td>
	                        			<img src="../images/twitterDrop.gif" border="0" style="cursor: pointer"
	                        				onclick="viewFlexLocationList()"/>
	                        		</td>
	                        		<td>
	                        			<img src="../images/smallClose.PNG" border="0" style="cursor: pointer"
	                        			onclick="closeDIV();"/>
	                        		</td>
	                        	</tr>
	                        -->
	                        </table>
	                        	<!--
		                           -->
	                        </div>
	                        <div style="width: 428px; display:none;border-width: .5em; 
	                        		border-style: solid; border-color: gray;" 
	                        	id="geoPopUp">
	                        	
	                        </div>
	                        
	                       <div style="width: 305px; display:none; border-width: .5em; 
	                       		  	   border-style: solid; border-color: gray;" 
	                        	id="geoNearbyListPopUp">
	                        	
	                       </div> 
	                       
							
	<!-- onclick="openPopup('Search Locations', '', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 300, 250, 454, 390, 10, false, true, false, 'searchWhatIsHappeningLocation.jsp');" -->
	                        
	       				<!-- 
	       					<div class="HappenBottomLeftMiddle3">
	       						 <img alt="Add" src="../images/AddTweetDisable.png" border="0"  style="cursor: pointer;" width="105" height="20"/>
	       					</div>
	       				-->
	       				</div>
	       				<div class="happenbottomLeftSend">
	       				<table width="100%"  border="0" cellspacing="0" cellpadding="0" height="55">
	                      <tr>
	                        <td class="topFirstTablehdCategoryDateNEW" valign="top" align="left">
	                            <div class="tweet-counter" id="tweetWords">0/140</div>
	                        </td>
	                      </tr>
	                      <tr>
	                        <td valign="middle" align="left">
	                        	<input type="hidden" name="rtopMsg_none" id="rtopMsg_none" value=""/>
	                        	
	                        	<div id="composeEnabled_none">
		                           	<a4j:commandLink value="" id="whatIsHappening" reRender="overallComposeFirstPanel" actionListener="#{twitterController.broadcastGlobalMessage}" 
										style="text-decoration: none;" onclick="document.getElementById('happeningLoader_none').style.display='block';" 
										oncomplete="resetText(); document.getElementById('transParentDocDiv').style.display='none';document.getElementById('happeningLoader_none').style.display='none';">
		                              	<img src="../images/tweetNowButtomGeneral.png" border="0" onmouseover="changeImage(this,'../images/tweetNowButtonrollover.png');" onmouseout="changeImage(this,'../images/tweetNowButtomGeneral.png');" style="cursor: pointer; text-decoration: none;"/>
		                          	</a4j:commandLink>
												
									<a4j:commandLink id="sendManualSchedule" reRender="scheduledTweetsPanel,overallComposeFirstPanel"	
									actionListener="#{rtopHandler.persistScheduleData}" style="text-decoration: none; cursor: pointer; border: 0px;"
									onclick="setTimezoneValue();setRTOPMsg('none');setScheduleTime('none');document.getElementById('indexClk').value='none';document.getElementById('happeningLoader_none').style.display='block';" 
									oncomplete="document.getElementById('scheduledText').innerHTML='SCHEDULED'; document.getElementById('happenning:tweetInput').value='';document.getElementById('happeningLoader_none').style.display='none';callWhatsHappeningJS();">
									<img src="../images/scheduleTweetGeneral.png" border="0" onmouseover="changeImage(this,'../images/scheduleTweetRollover.png');" onmouseout="changeImage(this,'../images/scheduleTweetGeneral.png');" style="cursor: pointer; text-decoration: none;"/>
	                        		<f:param name="twitterUserName" value="#{twitterController.firstCustomerName}"/>
	                        		</a4j:commandLink>
                        		</div>
                        		
                        		<div id="composeDisabled_none" style="display: none;">
                        			<img src="../images/tweetNowGray.png" border="0" width="121" style="text-decoration: none;"/>
                        			<img src="../images/scheduleTweetGray.png" border="0" width="121" style="text-decoration: none;"/>
                        		</div>
				                        	
	                          <input type="hidden" id="locForTweet" name="locForTweet"/>
	                        </td>
	                      </tr>
	                   </table>
	       			</div>
	       			</div>
	       			
	       		<a4j:outputPanel id="overallComposeFirstPanel">
	       			<div class="happeningRight">
	                    <div id="happeningRightTotal" class="happeningRightTotalManual">
		                      <div class="happeningRightTotalLeft">
		                        <div class="happeningRightTotalLeftTop">
			                        <div class="happeningRightTotalLeftTitle">Grade</div>
			                           <div class="happeningRightTotalLeftImg">
			                              <h:graphicImage value="../images/bulbGrayGeo.gif" onmouseover="this.src='../images/bulb_green.gif';"  onmouseout="this.src='../images/bulbGrayGeo.gif';">
												<rich:toolTip styleClass="tooltipGrade" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
													<span>
														<h:outputText value="Your tweet is graded on its ability to generate conversion activity in the twittersphere. It is based on the construction (whether it contains a bit.ly, hashtag, @references etc.) and trending components (how much activity and influence it has relative to its construction)."/>
													</span>
												</rich:toolTip>
										   </h:graphicImage>
										</div>
		                       	</div>
		                        <div class="happeningRightTotalLeftBottom" >
		                        	<table width="100" border="0" cellpadding="0" cellspacing="0"  height="100%">
		                        		<tr>
		                        		<td valign="middle" align="center" class="topFirstTableGrade">
		                        		
			                        		<div id="gradeLoader" class="gradeLoader">
												<img alt="preloader" style="position: center; margin-top:-10px; margin-left: 30px;" src="../images/greenRoundedLoader.gif" id="gradePreloader"/>
											</div>
											
											<input type="hidden" id="rtopGrade_none" name="rtopGrade_none" value=""/>
											<div id="gradeDiv_none">
												<h:outputText value="#{rtopHandler.trendingGrades}"  rendered="#{rtopHandler.trendingGradeSet}" />
												<h:graphicImage value="../images/greenDotLoader.gif" rendered="#{!rtopHandler.trendingGradeSet}" />
											</div>
											
			                        		
		                        		</td>
		                        		</tr>
		                        	</table>
		                        </div>
		                    </div>
	                    <!--  AUTO SCHEDULE  -->
	                    <div id="autoSchedule" class="happeningRightTotalRightAuto">
	                      <div style="width: 277px; height: 22px;">	  
	                        <div class="happeningRightTotalRightTitle">Schedule</div>
	                            <div class="happeningRightTotalRightImg">
	                             <h:graphicImage value="../images/bulbGrayGeo.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulbGrayGeo.gif';">
									<rich:toolTip styleClass="tooltipGrade" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										<span>
											<h:outputText value="Your tweet can be automatically scheduled based on trending activity of one or more components of the tweet trending high or you can manually schedule it on your own."/>
										</span>
									</rich:toolTip>
								</h:graphicImage>
								</div>
							</div>
							<div class="happeningRightTotalRightTopManual">
								<div class="happeningRightTotalRightTopLeft">
									<div class="happeningRightTotalRightTopLeftImg">
										<div class="happeningRightTotalRightTopLeftImg1">
											<img src="../images/manual_graybtn.gif" border="0" style="cursor: pointer;" onclick="showSchedule('Manual');setTimeValue('none',document.getElementById('happenning:autoTimeList'));"/>
										</div>
										<div class="happeningRightTotalRightTopLeftImg2">
											<img src="../images/green_auto.gif" border="0"/>
										</div>
									</div>
									<div class="happeningRightTotalRightTopLeftTimeAuto">AUTO</div>
								</div>
								
								<div class="happeningRightTotalRightTopRight">
									<div class="happeningRightTotalRightTopCalender">
										<table cellpadding="2" cellspacing="2" bgcolor="gray">
											<tr>
												<td valign="top" align="left">
													<rich:calendar id="calendarAuto" value="#{rtopHandler.scheduleDate}" inputSize="10" cellWidth="9" 
													cellHeight="12" datePattern="MM/dd/yyyy" 
													onchanged="showSchedule('Manual');setDateValue('none',this);"/>
												</td>
											</tr>
										</table>
									</div>
										<div class="happeningRightTotalRightTopDrop">
											<t:selectOneMenu id="autoTimeList" value="#{rtopHandler.scheduleTime}" styleClass="scheduleDropDown" 
											onchange="showSchedule('Manual');setTimeValue('none',this);">
                								<f:selectItems value="#{rtopHandler.manualScheduleTimes}"/>
             								</t:selectOneMenu>
										</div>
								</div>
								
							</div>
	                   </div>
	                   
	                   
	                   <!--  MANUAL SCHEDULE -->	                  
	                   <div id="manualSchedule" class="happeningRightTotalRightManual">
	                      <div style="width: 277px; height: 22px;">	  
	                        <div class="happeningRightTotalRightTitle">Schedule</div>
	                            <div class="happeningRightTotalRightImg">
	                             <h:graphicImage value="../images/bulbGrayGeo.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulbGrayGeo.gif';">
									<rich:toolTip styleClass="tooltipGrade" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
										<span>
											<h:outputText value="You can manually schedule your tweet on your own."/>
										</span>
									</rich:toolTip>
								</h:graphicImage>
								</div>
							</div>
							
							<div class="happeningRightTotalRightTopManual">
								<div class="happeningRightTotalRightTopLeft">
									<div class="happeningRightTotalRightTopLeftImg">
										<div class="happeningRightTotalRightTopLeftImg1">
											<img src="../images/manual_btn.gif" border="0" style="cursor: pointer;"/>
										</div>
										<div class="happeningRightTotalRightTopLeftImg2">
											<img src="../images/auto.gif" border="0" style="cursor: pointer;" onclick="showSchedule('Auto');"/>
										</div>
									</div>
									<div id="scheduledText" class="happeningRightTotalRightTopLeftTimeManual">NOT SCHEDULED</div>
								</div>
								
								<div class="happeningRightTotalRightTopRight">
									<div class="happeningRightTotalRightTopCalender">
										<table cellpadding="2" cellspacing="2" bgcolor="gray">
											<tr>
												<td valign="top" align="left">
													<input type="hidden" name="rtopScheduleDate_none" id="rtopScheduleDate_none" value="#{rtopHandler.scheduleDate}"/>
													<rich:calendar id="calendarManual" value="#{rtopHandler.scheduleDate}" inputSize="10" cellWidth="9" cellHeight="12" 
													datePattern="MM/dd/yyyy" onchanged="document.getElementById('rtopScheduleDate_none').value=this.value;"/>
												</td>
												
											</tr>
										</table>
									</div>
										<div class="happeningRightTotalRightTopDrop">
											<input type="hidden" name="rtopScheduleTime_none" id="rtopScheduleTime_none" value="#{rtopHandler.scheduleTime}"/>
          									<t:selectOneMenu id="manualTimeList" value="#{rtopHandler.scheduleTime}" styleClass="scheduleDropDown" 
          									onchange="document.getElementById('rtopScheduleTime_none').value=this.value; document.getElementById('happenning:autoTimeList').value = this.value;">
                								<f:selectItems value="#{rtopHandler.manualScheduleTimes}"/>
             								</t:selectOneMenu>
										</div>
								</div>
								
							</div>
	                   </div>
	                   
	               </div>
	            </div>
	      </a4j:outputPanel>
	      
	   </div>
	       
	  <!-- Start Repeat Block for Compose & Schedule -->
	    <a4j:outputPanel id="scheduledTweetsPanel">
	    
	    	<a4j:commandLink id="viewTextSuggestionsHidden" reRender="suggestionInstancePanel,gradesPanel"
    				actionListener="#{rtopHandler.viewTextSuggestion}" style="text-decoration: none; visibility: hidden;" 
    				onclick="renderDivs(document.getElementById('indexClk').value);"
    				oncomplete="resetDivs(document.getElementById('indexClk').value);">
			
				<f:param name="suggestionTokenAction" value="viewTextSuggestion"/>
							
			</a4j:commandLink>
			
			<input type="hidden" id="indexClk" name="indexClk" value=""/> 
		     
		   <a4j:repeat id="scheduledTweetsRepeat" value="#{twitterController.scheduledTweets}" var="scheduled" rowKeyVar="rtop">
		   
		   		<div id="happeningLoader_#{rtop}" class="happeningLoader">
			    	<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="middle" align="center"><img id="preloader" src="../images/preloader3.gif" alt="preloader"/></td>
						</tr>
					</table>
				</div>
				 
		     	<div class="HappeningBottomTotalSchedule" onclick="document.getElementById('WhatHappenDrop_#{rtop}').style.display='none';">
	       			
	       			<div class="HappeningBottomLeft">
	       				<div class="HappeningBottomLeftImg">
	       					<img src="#{twitterController.ownerProfileImage}"/>
	       				</div>
	       				<div class="HappeningBottomLeftText">
		       				<div style="width: 305px; height: 80px;">
		       				
		       					<input type="hidden" name="twtMessage_#{rtop}" id="twtMessage_#{rtop}" value="#{twitterController.twtmessage}"/>
		       					
		       					<textarea cols="45" rows="4" id="tweetInput_#{rtop}" class="RTOWhatsHappeningText" 
		       					onkeydown="countTweetLimitChars(this,'#{rtop}'); checkChar(event,this,'#{rtop}');" 
		       					onkeyup="countTweetLimitChars(this,'#{rtop}');setRTOPTweetMsg(this,'#{rtop}'); firehiddenTextarea(this,'tweet');" 
		       					onfocus="countTweetLimitChars(this,'#{rtop}');document.getElementById('indexClk').value='#{rtop}';">#{scheduled.tweetMessage}</textarea>
		       				</div>
		       				
		       				<input type="hidden" id="textSelected_#{rtop}" name="textSelected_#{rtop}" value=""/>
		       				<input type="hidden" id="textSelectedForGrade_#{rtop}" name="textSelectedForGrade_#{rtop}" value=""/>
		       				<input type="hidden" name="scheduleType_#{rtop}" id="scheduleType_#{rtop}" value=""/>
		       				
	       					<a4j:outputPanel id="suggestionInstancePanel">
	       						
		       					<div id="WhatHappenDrop_#{rtop}" class="happeningDropTotal">
		       					
		       					<a4j:outputPanel rendered="#{!rtopHandler.tokenAvailable}">
									<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td valign="middle" align="center">
												<div class="noSuggestion" onclick="hideSuggestionText('#{rtop}');">No Result! <br/> Click Here to close</div>
											</td>
										</tr>
									</table>
	    						</a4j:outputPanel>
		                        	
		                        	<div id="whatsHappeningSuggestText_#{rtop}" style="height: auto; width: 295px;">
			                        	<a4j:repeat value="#{rtopHandler.textSuggestionTokens}" var="suggestionTokens" rowKeyVar="i">
				                        	
				                        	<table width="90%" height="auto" border="0" cellpadding="0" cellspacing="0">
				                        	<tr>
				                        		<td valign="top" align="center">
				                        			<div id="dropdownHappen#{i}" class="dropdownHappenSize"> 
				                        				<div class="dropdownHappenLeft">
				                        					                        					
				                        					<a4j:commandLink value="#{suggestionTokens.name}" styleClass="textSuggestName"
				                        					onmouseover="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#E2EECB';"
				                        					onmouseout="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#ffffff';"
				                        					onclick="setSelectedText('#{suggestionTokens.name}','#{rtop}');"/>
				                        					
				                        				</div>
				                        				<div class="dropdownHappenRight">
							                        		<table width="130" cellpadding="0" cellspacing="0" border="0">
							                        			<tr>
							                        				<td valign="top" align="left">
							                        				<div class="dropdownHappenRightFirst">
							                        				
							                        					<a4j:commandLink value="#{suggestionTokens.abscount} INSTANCES" styleClass="textSuggestCount"
				                        									onmouseover="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#E2EECB';" 
				                        									onmouseout="document.getElementById('dropdownHappen#{i}').style.backgroundColor='#ffffff';"
				                        									onclick="setSelectedText('#{suggestionTokens.name}','#{rtop}');"/>
							                        				</div>
							                        				</td>
							                        				
							                        				<td width="10" valign="top" align="left">
							                        					<a4j:outputPanel rendered="#{suggestionTokens.trendup}"><img src="../images/happenUpArrow.gif" border="0"/></a4j:outputPanel>
							                        					<a4j:outputPanel rendered="#{!(suggestionTokens.trendup)}"><img src="../images/happenDownArrow.gif" border="0"/></a4j:outputPanel>
							                        				</td>
							                        			</tr>
							                        		</table>
				                        				</div>
				                        			</div>
				                        		</td>
				                        	</tr>
				                        	</table>
			                        	</a4j:repeat>
		                        	</div>	
		                        </div>
	                        </a4j:outputPanel>
	                        
	                        <div class="HappenBottomLeftMiddle2"   id="whatisHappeningGEO">
	                        <table>
	                        	<!--
	                        	<tr id="innerTR">
	                        		<td width="150">
	                        			<div id="getLocFromFlex" onclick="viewPopup(this);"
			                        		 style="font-weight: normal; color: rgb(126, 190, 76); font-size: 14px; font-style: normal;
				                              	font-variant: normal; cursor: pointer; text-decoration: none">
				                              	Add your location
			                        	</div>
	                        		</td>
	                        		<td>
	                        			<img src="../images/twitterDrop.gif" border="0" style="cursor: pointer"
	                        				onclick="viewFlexLocationList()"/>
	                        		</td>
	                        		<td>
	                        			<img src="../images/smallClose.PNG" border="0" style="cursor: pointer"
	                        			onclick="closeDIV();"/>
	                        		</td>
	                        	</tr>
	                        -->
	                        </table>
	                        	<!--
		                           -->
	                        </div>
	                        <div style="width: 428px; display:none;border-width: .5em; 
	                        		border-style: solid; border-color: gray;" 
	                        	id="geoPopUp">
	                        	
	                        </div>
	                        
	                       <div style="width: 305px; display:none; border-width: .5em; 
	                       		  	   border-style: solid; border-color: gray;" 
	                        	id="geoNearbyListPopUp">
	                        	
	                       </div> 
	                       
							
	<!-- onclick="openPopup('Search Locations', '', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 300, 250, 454, 390, 10, false, true, false, 'searchWhatIsHappeningLocation.jsp');" -->
	                        
	       					<div class="HappenBottomLeftMiddle3">
	       						<!-- 
	       							 <img alt="Add" src="../images/AddTweetDisable.png" border="0"  style="cursor: pointer;" width="105" height="20"/>
	       						-->
								 
								 <a4j:commandLink actionListener="#{rtopHandler.removeScheduledTweetFromDB}" reRender="scheduledTweetsPanel" 
								 	style="text-decoration: none; cursor: pointer; border: 0px;" onclick="setRTOPMsg('#{rtop}');document.getElementById('indexClk').value='#{rtop}';document.getElementById('happeningLoader_#{rtop}').style.display='block';"
								 	oncomplete="document.getElementById('happeningLoader_#{rtop}').style.display='none';">
								 
								 	<img alt="Remove" src="../images/remove_tweet.gif" border="0"  style="cursor: pointer;" width="106" height="21" onmouseover="changeImage(this,'../images/removeTweet_rollover.gif');" onmouseout="changeImage(this,'../images/remove_tweet.gif');" />
								 	<f:param name="twitterUserName" value="#{twitterController.firstCustomerName}"/>
									<f:param name="scheduleId" value="#{scheduled.rtopScheduleId}"/>
									<f:param name="scheduleGrade" value="#{scheduled.grade}"/>	
								 </a4j:commandLink>
								 
	       					</div>
	       				</div>
	       				<div class="happenbottomLeftSend">
	       				<table width="100%"  border="0" cellspacing="0" cellpadding="0" height="55">
	                      <tr>
	                        <td class="topFirstTablehdCategoryDateNEW" valign="top" align="left">
	                            <div class="tweet-counter" id="tweetWords_#{rtop}">0/140</div>
	                        </td>
	                      </tr>
	                      <tr>
	                        <td valign="middle" align="left">
	                        	<input type="hidden" name="rtopMsg_#{rtop}" id="rtopMsg_#{rtop}" value=""/>
	                        	
	                        	<div id="composeEnabled_#{rtop}">
		                           	<a4j:commandLink value="" id="whatIsHappening" reRender="scheduledTweetsPanel"
										actionListener="#{twitterController.broadcastGlobalMessage}" 
										style="text-decoration: none;" onclick="document.getElementById('twtMessage_#{rtop}').value=document.getElementById('tweetInput_#{rtop}').value; document.getElementById('indexClk').value='#{rtop}';document.getElementById('happeningLoader_#{rtop}').style.display='block';" 
										oncomplete="resetText(); document.getElementById('transParentDocDiv').style.display='none';document.getElementById('happeningLoader_#{rtop}').style.display='none';">
		                              	<img src="../images/tweetNowButtomGeneral.png" border="0" onmouseover="changeImage(this,'../images/tweetNowButtonrollover.png');" onmouseout="changeImage(this,'../images/tweetNowButtomGeneral.png');" style="cursor: pointer; text-decoration: none;"/>
		                          	  	<f:param name="scheduleId" value="#{scheduled.rtopScheduleId}"/>
		                          	  	<f:param name="scheduleGrade" value="#{scheduled.grade}"/>
		                          	</a4j:commandLink>
											
								  <a4j:commandLink id="sendManualSchedule" reRender="scheduledTweetsPanel"
									actionListener="#{rtopHandler.persistScheduleData}" style="text-decoration: none; cursor: pointer; border: 0px;"
									onclick="setRTOPMsg('#{rtop}');document.getElementById('indexClk').value='#{rtop}';document.getElementById('happeningLoader_#{rtop}').style.display='block';"
									oncomplete="document.getElementById('happeningLoader_#{rtop}').style.display='none';callWhatsHappeningJS();">
									<img src="../images/scheduleTweetGeneral.png" border="0" onmouseover="changeImage(this,'../images/scheduleTweetRollover.png');" onmouseout="changeImage(this,'../images/scheduleTweetGeneral.png');" style="cursor: pointer; text-decoration: none;"/>
									<f:param name="twitterUserName" value="#{twitterController.firstCustomerName}"/>
									<f:param name="scheduleId" value="#{scheduled.rtopScheduleId}"/>
									<f:param name="scheduleGrade" value="#{scheduled.grade}"/>												
	                        	 </a4j:commandLink>
                        	 </div>
                        	 
                        	 <div id="composeDisabled_#{rtop}" style="display: none;">
                        		<img src="../images/tweetNowGray.png" border="0" width="121" style="text-decoration: none;"/>
                        		<img src="../images/scheduleTweetGray.png" border="0" width="121" style="text-decoration: none;"/>
                        	</div>
				                        	
	                          <input type="hidden" id="locForTweet" name="locForTweet"/>
	                        </td>
	                      </tr>
	                   </table>
	       			</div>
	       			</div>
	       			
	       			<div class="happeningRight">
	                    <div id="happeningRightTotal_#{rtop}" class="happeningRightTotalManual">
	                      
	                     <a4j:outputPanel id="gradesPanel"> 
		                      <div class="happeningRightTotalLeft">
		                        <div class="happeningRightTotalLeftTop">
			                        <div class="happeningRightTotalLeftTitle">Grade</div>
			                           <div class="happeningRightTotalLeftImg">
			                              <h:graphicImage value="../images/bulbGrayGeo.gif" onmouseover="this.src='../images/bulb_green.gif';"  onmouseout="this.src='../images/bulbGrayGeo.gif';">
												<rich:toolTip styleClass="tooltipGrade" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
													<span>
														<h:outputText value="Your tweet is graded on its ability to generate conversion activity in the twittersphere. It is based on the construction (whether it contains a bit.ly, hashtag, @references etc.) and trending components (how much activity and influence it has relative to its construction)."/>
													</span>
												</rich:toolTip>
										   </h:graphicImage>
										</div>
		                       	</div>
		                        <div class="happeningRightTotalLeftBottom" >
		                        	<table width="100" border="0" cellpadding="0" cellspacing="0"  height="100%">
		                        		<tr>
		                        		<td valign="middle" align="center" class="topFirstTableGrade">
		                        		
			                        		<div id="gradeLoader_#{rtop}" class="gradeLoader">
												<img alt="preloader" style="position: center; margin-top:-10px; margin-left: 30px;" src="../images/greenRoundedLoader.gif" id="gradePreloader"/>
											</div>
											
											<input type="hidden" id="rtopGrade_#{rtop}" name="rtopGrade_#{rtop}" value=""/>
											
											<div id="gradeDiv_#{rtop}">
												<h:outputText value="#{scheduled.grade}" rendered="#{scheduled.gradeExists}"/>
												<h:graphicImage value="../images/greenDotLoader.gif" rendered="#{!scheduled.gradeExists}"/>
											</div>
			                        		
		                        		</td>
		                        		</tr>
		                        	</table>
		                        </div>
		                    </div>
	                    </a4j:outputPanel>
	                    
		                    <div id="autoSchedule_#{rtop}" class="happeningRightTotalRightAuto">
		                      <div style="width: 277px; height: 22px;">	  
		                        <div class="happeningRightTotalRightTitle">Schedule</div>
		                            <div class="happeningRightTotalRightImg">
		                             <h:graphicImage value="../images/bulbGrayGeo.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulbGrayGeo.gif';">
										<rich:toolTip styleClass="tooltipGrade" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
											<span>
												<h:outputText value="Your tweet can be automatically scheduled based on trending activity of one or more components of the tweet trending high or you can manually schedule it on your own."/>
											</span>
										</rich:toolTip>
									</h:graphicImage>
									</div>
								</div>
								<div class="happeningRightTotalRightTopManual">
									<div class="happeningRightTotalRightTopLeft">
										<div class="happeningRightTotalRightTopLeftImg">
											<div class="happeningRightTotalRightTopLeftImg1">
												<img src="../images/manual_graybtn.gif" border="0" style="cursor: pointer;" onclick="showSchedules('Manual','#{rtop}');"/>
											</div>
											<div class="happeningRightTotalRightTopLeftImg2">
												<img src="../images/green_auto.gif" border="0"/>
											</div>
										</div>
										<div class="happeningRightTotalRightTopLeftTimeAuto">AUTO</div>
									</div>
									
									<div class="happeningRightTotalRightTopRight">
										<div class="happeningRightTotalRightTopCalender">
											<table cellpadding="2" cellspacing="2" bgcolor="gray">
												<tr>
													<td valign="top" align="left">
														<rich:calendar id="calendarAuto" value="#{scheduled.scheduleDate}" inputSize="10" cellWidth="9" 
														cellHeight="12" datePattern="MM/dd/yyyy" onchanged="showSchedules('Manual','#{rtop}');setDateValues('#{rtop}',this);"/>
													</td>
												</tr>
											</table>
										</div>
											<div class="happeningRightTotalRightTopDrop">
												<t:selectOneMenu id="autoTimeList" value="#{scheduled.scheduleTime}" styleClass="scheduleDropDown" onchange="showSchedules('Manual','#{rtop}');setTimeValues('#{rtop}',this);">
		                							<f:selectItems value="#{rtopHandler.manualScheduleTimes}"/>
		             							</t:selectOneMenu>
											</div>
									</div>
									
								</div>
		                   </div>
	                   	
		                    <div id="manualSchedule_#{rtop}" class="happeningRightTotalRightManual">
		                      <div style="width: 277px; height: 22px;">	  
		                        <div class="happeningRightTotalRightTitle">Schedule</div>
		                            <div class="happeningRightTotalRightImg">
		                             <h:graphicImage value="../images/bulbGrayGeo.gif" onmouseover="this.src='../images/bulb_green.gif';" onmouseout="this.src='../images/bulbGrayGeo.gif';">
										<rich:toolTip styleClass="tooltipGrade" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
											<span>
												<h:outputText value="You can manually schedule your tweet on your own."/>
											</span>
										</rich:toolTip>
									</h:graphicImage>
									</div>
								</div>
								
								<div class="happeningRightTotalRightTopManual">
									<div class="happeningRightTotalRightTopLeft">
										<div class="happeningRightTotalRightTopLeftImg">
											<div class="happeningRightTotalRightTopLeftImg1">
												<img src="../images/manual_btn.gif" border="0" style="cursor: pointer;"/>
											</div>
											<div class="happeningRightTotalRightTopLeftImg2">
												<img src="../images/auto.gif" border="0" style="cursor: pointer;" onclick="showSchedules('Auto', '#{rtop}');"/>
											</div>
										</div>
										<div id="scheduledText" class="happeningRightTotalRightTopLeftTimeManual">SCHEDULED</div>
									</div>
									<div class="happeningRightTotalRightTopRight">
										<div class="happeningRightTotalRightTopCalender">
											<table cellpadding="2" cellspacing="2" bgcolor="gray">
												<tr>
													<td valign="top" align="left">
													
													<input type="hidden" name="rtopScheduleDate_#{rtop}" id="rtopScheduleDate_#{rtop}" value="#{scheduled.scheduleDate}"/>
															<rich:calendar id="calendarManual" value="#{scheduled.scheduleDate}" inputSize="10" 
																cellWidth="9" cellHeight="12" datePattern="MM/dd/yyyy" 
																onchanged="document.getElementById('rtopScheduleDate_#{rtop}').value=this.value;"/>
													</td>
													
												</tr>
											</table>
										</div>
											<div class="happeningRightTotalRightTopDrop">
											<input type="hidden" name="rtopScheduleTime_#{rtop}" id="rtopScheduleTime_#{rtop}" value="#{scheduled.scheduleTime}"/>
	          									<t:selectOneMenu id="manualTimeList" value="#{scheduled.scheduleTime}" styleClass="scheduleDropDown" onchange="document.getElementById('rtopScheduleTime_#{rtop}').value=this.value;">
	                								<f:selectItems value="#{rtopHandler.manualScheduleTimes}"/>
	             								</t:selectOneMenu>
												
											</div>
									</div>
								</div>
		                   </div>
		                   
		                   <a4j:outputPanel layout="none" rendered="#{scheduled.scheduleType == 'M'}">
			                   <script>
			                   		showSchedules('Manual','#{rtop}')
			                   </script>
		                   </a4j:outputPanel>
		                   
		                   <a4j:outputPanel layout="none" rendered="#{scheduled.scheduleType == 'A'}">
			                   <script>
			                   		showSchedules('Auto','#{rtop}')
			                   </script>
		                   </a4j:outputPanel>
	                   
	               </div>
	            </div>
	       </div>
		       
		  </a4j:repeat>
	   </a4j:outputPanel> 
	       
	   <!-- End Repeat Block for Compose & Schedule -->    

	       
	       	
	     </div>
	     
	     </h:form>
	    </a4j:outputPanel>
	
	<script language="JavaScript">
		//<![CDATA[
			callWhatsHappeningJS();
		//]]>	
	</script>
    </f:view>
    </ui:composition>
