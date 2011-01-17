<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	>

	<td valign="middle" align="center" bgcolor="#F2F2F1">
		<table width="100" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="middle" align="right" class="topFirstTablehdCategory2">
					<a id="displayTextData" href="#{jvmethod }" 
						style="color: #{channelPerformanceController.overallColor}; text-decoration: none; font-size: 15px;">
						#{gradevalue}
					</a>
				</td>
				<td valign="middle" align="center">
					<a onclick="openPopup11('Trending of #{name}',false,270, 90, 860, 450, 10, false, true, false, 'trending.jsp')" href="#">
					<!--<a href="#" onclick="openPopup12('Trending of #{name}',true,200, 90, 870, 460, 10, false, true, false, 'trending.jsp')">
						--><img src="../images/wave.gif" border="0"/>
					</a>  
				</td>
				
				<a4j:outputPanel rendered="#{!(sentimentpopup eq '')}">				
					<td valign="middle" align="center">						  
						<a href="#" onclick="openPopup11('@terametric',false,270, 90, 780, 700, 10, false, true, false, '#{sentimentpopup}')">
							<img src="../images/#{sentimentpopupicon }" border="0"/>
						</a>
	 			    </td>																		  
 			    </a4j:outputPanel>
			</tr>
		</table>
	</td>
</ui:composition>