<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>
	 <f:view>
   			<h:form id="realTimeOptimizationData">
	<table width="505" border="0" cellspacing="0" cellpadding="0"  style="padding-top: 6px; border-bottom:1px solid #F5F5F5;">
		<tr>
			<td valign="middle" align="left" width="60">                                            
            	<h:graphicImage value="#{imglogo}">
            	<div style="text-align: left;">
					<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
				         <span><h:outputText value="Name: "/><h:outputText value="#{twtName}" style="font-weight:normal;"/></span><br/>
				         <span><h:outputText value="Location: "/><h:outputText value="#{twtLocation}" style="font-weight:normal;"/></span><br/>
				         <span><h:outputText value="Tweets: "/><h:outputText value="#{twtTweets}" style="font-weight:normal;"/></span><br/>
				         <span><h:outputText value="Follows: "/><h:outputText value="#{twtFollows}" style="font-weight:normal;"/></span><br/>
				         <span><h:outputText value="Following: "/><h:outputText value="#{twtFollowing}" style="font-weight:normal;"/></span><br/>
				         <span><h:outputText value="Listed: "/><h:outputText value="#{twtListed}" style="font-weight:normal;"/></span><br/>
					</rich:toolTip>
				  </div>
				</h:graphicImage>              
			</td>
			
			<a4j:outputPanel rendered="#{!(msgtype eq 'NEGATIVE')}"> 
            <td width="380" bgcolor="#F2F2F2">
            	<div class="RTOBody"> 
                		<font style="color:#3482BD">@#{twtName}</font> 
                		<font style="color:#6E7177">#{twtMessage}</font>
               	</div>
           	</td>
           	</a4j:outputPanel>
           	
           	<a4j:outputPanel rendered="#{(msgtype eq 'NEGATIVE')}"> 
           	<td width="380" bgcolor="#E14C16">
            	<div class="RTOBody"> 
						<font style="color:#ffffff">@terametric</font> <font style="color:#ffffff">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</font>
               	</div>
           	</td>
           	</a4j:outputPanel>
           	
            <td valign="top" align="center" width="60">
            	<a4j:outputPanel rendered="#{!(msgtype eq 'NEGATIVE')}">  
	            	<a4j:commandButton image="../images/retweet.gif" style="cursor: pointer; padding-bottom:2px;" id="retweet"
	            						actionListener="#{twitterController.sendIndividualTwitt}" immediate="true">
	            		<f:param name="retweet" value="#{tdid}"/>	
				  	</a4j:commandButton>
                </a4j:outputPanel>
                
                <a href="#" onclick="openPopup1('RT(Retweets) to Thank',424, 150, 500, 315, 10, false, true, false, 'reTweet.jsp')">
                	<img src="../images/reply.gif" border="0" />
                </a>
            </td>
        </tr>
        <tr>
			<td width="60"></td>
			<td colspan="2" width="440">
				<div class="RTOBody1">#{twtName}, #{twtDate}, via Search</div>
			</td>
		</tr>
        <tr>
			<td width="60"></td>
            <td colspan="2">
				<table width="440" border="0" cellspacing="0" cellpadding="0" class="topFirstTablehdCategory">
                	<tr>
						<td width="50" valign="top" align="left">
                              <h:graphicImage value="../images/#{textarealogo}" 
     							onmouseover="this.src='../images/#{textarealogo}';" onmouseout="this.src='../images/#{textarealogo}';" style=" margin-right:5px">
    							<rich:toolTip styleClass="tooltip" showEvent="onmouseover" direction="bottom-right" mode="client" layout="block">
        							<span><h:outputText value="#{textarealogotooltip}" /></span>
    							</rich:toolTip>
								</h:graphicImage>
                         </td>
                         <td valign="top" align="center">
                         	<textarea style="width: 280px; height: 70px; background-image: none; border: 2px inset #6E7177; 
                         					margin-right: 5px; color: #{textareacontentcolor}; padding-left: 3px; padding-top: 3px; font-size: 12px;" 
                         					onfocus="if(this.value=='#{textareacontent}') this.value='';" 
                         					onblur="if(this.value=='') this.value='#{textareacontent}';" >#{textareacontent}</textarea>
                         	              
						 </td>
                         <td width="120" valign="bottom">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" height="55">
								<tr><td class="topFirstTablehdCategoryDate" valign="top" align="left">0/140</td></tr>
								<tr><td valign="bottom" align="left" style="font-size: 24px; padding-top: 30px;">
									<a4j:commandButton image="../images/sendTweetButton.gif"
													 style="cursor: pointer;" actionListener="#{twitterController.sendIndividualTwitt}"
													 immediate="true">
												<f:param name="sendTwt" value="#{tdid}"/>	
								  	</a4j:commandButton>
								</td></tr>
                            </table>
						 </td>
					  </tr>
                      <tr>
						 <td width="50" valign="top" align="left"></td>
                         <td valign="top" align="center" colspan="2" class="RTOBody2">Tweet Input: "#{textareafooter}"</td>
                      </tr>
                  </table>
			</td>
		</tr>
	</table>
	</h:form>
	</f:view>
</ui:composition>