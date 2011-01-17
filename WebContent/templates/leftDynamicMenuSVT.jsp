<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j">

<f:view>
	<h:form>
	<div class="arrowlistmenu">
	<a4j:repeat value="#{channelController.channelDTOList}" var="channel" rowKeyVar="x">

		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="260px">
				<h:commandLink action="#{menu.selectSpecial}" value=""  style="text-decoration:none;" >
				<table width="100%" height="26" border="0" id="table_#{x}"
					class="#{((channel.channelName eq menu.currentMenu.title)||(channel.channelName eq menu.currentMenu.currentChannelDTO.channelName))? 'menuheader openheader' : 'menuheader'} " 
					cellpadding="0" cellspacing="0" onmouseover="highlightMenu('#{x}', '#{channel.channelName}')" onmouseout="deHighlightMenu('#{x}', '#{channel.channelName}')">
					<tr>
						<td style="padding-left: 10px; width:165px;">
							<h:outputText value="#{channel.channelName}" styleClass="newmenu" />
						</td>
						<td style="" class="menuScore" align="left">
							#{channel.selfChannelSummaryDTO.overallValueInt}
						</td>
						<td align="left" valign="middle" style="padding-left:1px;" >
							<img id="dot_#{x}" src="../images/#{channel.bigDotFilename}#{((channel.channelName eq menu.currentMenu.title)||(channel.channelName eq menu.currentMenu.currentChannelDTO.channelName))? 'h' : ''}.gif" border="0"/>
						</td>
					</tr>
				</table>
				</h:commandLink>
				<ul class="categoryitems">

					<a4j:repeat value="#{menu.categories}" var="category" rendered="#{menu.categories != null and channel.channelName == menu.currentMenu.currentChannelDTO.channelName}">
						<li><h:commandLink action="#{menu.select}" value="#{category.categoryName}" 
							style= "#{(category.categoryName eq menu.currentMenu.title)? 'background-color:#D4FEB8' : ''}"
						 /></li>
					</a4j:repeat>

				</ul>

				</td>
				
			</tr>
		</table>
		
	</a4j:repeat>
	</div>

	</h:form>

</f:view>
</html>