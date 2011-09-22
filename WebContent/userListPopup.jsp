<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../css/twt.css" rel="stylesheet" type="text/css" />	
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<a4j:form id="userList">
		<a4j:jsFunction name="renderUserListPanel" reRender="userListPanel" oncomplete="showPopupDivRespectToElement('#{rtopHandler.elemID}', '#{rtopHandler.divToPopupId}', '#{rtopHandler.index}', '#{rtopHandler.scrollTop}')">
			<a4j:actionparam name="elemID" assignTo="#{rtopHandler.elemID}" />
			<a4j:actionparam name="divToPopupId" assignTo="#{rtopHandler.divToPopupId}" />
			<a4j:actionparam name="index" assignTo="#{rtopHandler.index}" />
			<a4j:actionparam name="scrollTop" assignTo="#{rtopHandler.scrollTop}" />
		</a4j:jsFunction>
		<a4j:outputPanel id="userListPanel" layout="block" rendered="#{rtopHandler.iIndex >= 0}">						
			<div id="listPopup_#{rtopHandler.iIndex}" class="listPopup">
				<div id="ListPopupInnerLeft" style="width: 7px; height: 11px; float: left; background-image: url(../images/UserListPopup/arrow.png); margin-top: 20px;">
				</div>	
				<div id="ListPopupInnerRight" style="width: 195px; height: auto; float: right;">
					<div id="popupRightTop" style="width: 195px; height: 5px; background-image: url(../images/UserListPopup/top.png); background-repeat: no-repeat;">
					</div>
					<div id="popupRightMiddle" style="width: 195px; height: auto; background-image: url(../images/UserListPopup/middle.png); background-repeat: repeat;">
						<a4j:outputPanel id="jym">
							<table width="180" cellpadding="0" cellspacing="0" height="100%"
								style="margin-top: 6px; margin-left: 10px;">
								<a4j:repeat id="userListRepeat" value="#{rtopHandler.userList}" rowKeyVar="i" var="listByUser">
									<tr>
										<td valign="middle" align="center" width="55" style="padding-left: 8px;" height="30">
											<a4j:outputPanel layout="block">
												<img id="checkImg#{i}" src="../images/checkboxOrange.gif" style="width: 13px; height: 13px;" 
													onclick="toggleCheckBox(this, '#{rich:clientId('hiddenCheckBox')}', '#{rich:clientId('hiddenListId')}', '#{listByUser.id}');"/>												
												<h:inputHidden id="hiddenCheckBox" value="#{rtopHandler.checkBoxes[i]}" />
												<h:inputHidden id="hiddenListId" value="#{rtopHandler.listIds[i]}" />																																																																																																						
											</a4j:outputPanel>																														
										</td>
										<td valign="middle" align="left" class="alertSelect" width="145">
											<div id="listNameDiv#{i}" style="width: 170px; height: auto; word-wrap: break-word; white-space: pre-wrap; margin-left: 10px;">
												<h:outputText style="padding-right: 8px;"
													value="#{listByUser.name}" />
											</div></td>
									</tr>
								</a4j:repeat>
								<tr>
									<td valign="top" align="left" colspan="2"
										class="closeOrangeText" height="40">
										<div id="addNewUserListButtonDiv" style="width: 120px; padding-left: 4px; padding-bottom: 4px; padding-right: 4px; padding-top: 4px; border: 1px solid #F2A413; margin-left: 8px;">
											<a4j:commandLink actionListener="#{popupController.addInfulencerToList}" 
												style="font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #F2A413; text-decoration: none;"
												onclick="document.getElementById('addNewUserListButtonDiv').style.display='none'; document.getElementById('disableSubmitDiv').style.display='block'; setDynamicLoaderDivStyleForAddToList();"																						
												reRender="jym"
												oncomplete="document.getElementById('listPopup_#{rtopHandler.iIndex}').style.display='none'; reRenderForAddToListPanel();">
												SUBMIT
												<!-- onclick="openCreateNewUserListPopup('Create a new list', '../images/Alert/alertSign.gif', '#FFA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 450, 340, 10, false, true, false, 'CreateNewListAlert.jsp'); parent.document.getElementById('backDrop').style.display='none'; -->
												<a4j:actionparam name="actionsInfluencersId" value="#{rtopHandler.actionsInfluencersId}" />
											</a4j:commandLink>
										</div>
										<div id="disableSubmitDiv" style="display: none; cursor: wait; height: 15px; width: 120px; padding-left: 4px; padding-bottom: 4px; padding-right: 4px; padding-top: 4px; border: 1px solid #F2A413; margin-left: 8px;">
											<table width="100%" cellspacing="0" cellpadding="0" border="0">
												<tbody>
													<tr>
														<td width="20%" valign="middle" align="left" style="font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #F2A413;">
															SUBMIT
														</td>
														<td valign="middle" align="left">
															<img src="../images/addLoading.gif" alt="loading" height="15" style="margin-left: 15px;" />
														</td>
													</tr>
												</tbody>
											</table>																						
										</div>
									</td>
								</tr>
							</table>
						</a4j:outputPanel>
					</div>
					<div id="popupRightBottom" style="width: 195px; height: 5px; background-image: url(../images/UserListPopup/bottom.png); background-repeat: no-repeat;">
					</div>				
				</div>							
			</div>
		</a4j:outputPanel>
	</a4j:form>											
</ui:composition>