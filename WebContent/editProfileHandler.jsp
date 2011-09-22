<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:twt="http://richfaces.org/session-data-helper">
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/custom-form-elements.js"></script>
	<tr>
		<td align="right" valign="top" colspan="2">
		<table width="365" align="right">
			<tr>
				<td valign="top" align="right" class="edit_left_textEPP"><font
					style="color: #FF0000;">*</font>#{competitorhandlername}
				TwitterAccounts<br />
				<font style="font-weight: normal">(Limit 5)</font></td>
				<td valign="top" align="left"><h:inputText onkeypress="return checkKeycode(event);"
					id="compTwtAcc#{inputtext1}" value="#{inputtext1value}"
					styleClass="edit_right_textAdd"
					style="background-image:none; border-width:2px; color:#7D848B; width: 210px;font-size:12px;	background-color: #{inputtext1bgcolor}" />
				<br />
				<div style="width: 150px; font-weight: normal; color: #F17A4B;"
					class="edit_left_textGreen"><h:outputText
					value="#{cmpttwitteraccerr}" /></div>
				</td>
				<td align="left" valign="top"><a4j:outputPanel
					rendered="#{inputtext1 eq '1'}">
					<h:commandLink value=""
						onmousedown="setScrollValue();"
						actionListener="#{userProfileButtonHandler.addTwitterAccountCmptHandler1}"
						style="text-decoration: none;">
						<img src="../images/addButton.gif"
	                          border="0" 
	                          width="41"/>
					</h:commandLink>
				</a4j:outputPanel> <a4j:outputPanel rendered="#{inputtext1 eq '2'}">
					<h:commandLink value=""
						onmousedown="setScrollValue();"
						actionListener="#{userProfileButtonHandler.addTwitterAccountCmptHandler2}"
						style="text-decoration: none;">
						<img src="../images/addButton.gif"
	                          border="0" 
	                          width="41"/>
					</h:commandLink>
				</a4j:outputPanel> <a4j:outputPanel rendered="#{inputtext1 eq '3'}">
					<h:commandLink value=""
						onmousedown="setScrollValue();"
						actionListener="#{userProfileButtonHandler.addTwitterAccountCmptHandler3}"
						style="text-decoration: none;">
						<img src="../images/addButton.gif"
	                          border="0" 
	                          width="41"/>
					</h:commandLink>
				</a4j:outputPanel></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td align="right" valign="top" colspan="2"><a4j:repeat
			value="#{cmptlist}" var="editProf" rowKeyVar="i">
			<table width="252" border="0" cellspacing="0" cellpadding="0">
				<tr height="20">
					<td width="12"><h:commandLink value=""
						actionListener="#{userProfileButtonHandler.removeTwitterAccount}"
						style="text-decoration: none;">
						<f:attribute name="twitterId" value="#{editProf.twitterAccountId}" />
						<img src="../images/smallClose.PNG" border="0" />
					</h:commandLink></td>
					<td class="edit_left_textGreen" valign="top" align="left"
						width="120">
					<div class="mailAcc1"
						style="width: 90px; overflow: hidden; color: #F17A4B;">
					@#{editProf.twitterUsername}</div>
					</td>
					<td valign="top" align="right" width="120">

					<twt:menu value="#{editProf.brndProdInds}" 
   								paramName="vkb#{inputtext1}#{i}" strOptions="BRAND,PRODUCT,INDUSTRY"></twt:menu>
					
					<a4j:outputPanel rendered="#{competitorhandlername eq 'Competitor #1'}">
							<div
									style="width: 100px; font-weight: normal; font-weight: normal; font-size: 11px; color: #F17A4B;"
									class="edit_left_textGreen"><h:outputText
									value="#{backingBean.compTwittAccErr}"
									style="font-size: 11px; color:#F17A4B;" />
							</div>
					</a4j:outputPanel>
					<a4j:outputPanel	rendered="#{competitorhandlername eq 'Competitor #2'}">
								<div
									style="width: 100px; font-weight: normal; font-weight: normal; font-size: 11px; color: #F17A4B;"
									class="edit_left_textGreen"><h:outputText
									value="#{backingBean.compTwittAccErr2}"
									style="font-size: 11px; color:#F17A4B;" />
								</div>
					</a4j:outputPanel> 
					<a4j:outputPanel	rendered="#{competitorhandlername eq 'Competitor #3'}">
								<div
									style="width: 100px; font-weight: normal; font-weight: normal; font-size: 11px; color: #F17A4B;"
									class="edit_left_textGreen"><h:outputText
									value="#{backingBean.compTwittAccErr3}"
									style="font-size: 11px; color:#F17A4B;" />
								</div>
					</a4j:outputPanel>
					
					<!-- 
					<div class="fileinputs1Band">
					
						
						<select
							id="brand#{inputtext1}#{i}" class="band"
							onchange="selectedBrand('brand#{inputtext1}#{i}', 'vkb#{inputtext1}#{i}', this.value)"
							value="#{editProf.brndProdInds}">
							<option value="BRAND">BRAND</option>
							<option value="PRODUCT">PRODUCT</option>
							<option value="INDUSTRY">INDUSTRY</option>
						</select> 
						<script language="JavaScript">
							selectedBrand('editProfile:brand#{inputtext1}#{i}', 'vkb#{inputtext1}#{i}', '');																		
						</script>
						<div class="fakefile1Band">
					
					
							<a4j:outputPanel rendered="#{competitorhandlername eq 'Competitor #1'}">
									<input id="vkb#{inputtext1}#{i}" name="vkb#{inputtext1}#{i}"
										type="text" value="#{editProf.brndProdInds}" class="vk_text"
										style="background-image: none; background-color: transparent; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;" />
									<br />
									<div
										style="width: 100px; font-weight: normal; font-weight: normal; font-size: 11px; color: #F17A4B;"
										class="edit_left_textGreen"><h:outputText
										value="#{backingBean.compTwittAccErr}"
										style="font-size: 11px; color:#F17A4B;" />
									</div>
							</a4j:outputPanel> 
							
							<a4j:outputPanel	rendered="#{competitorhandlername eq 'Competitor #2'}">
								<input id="vkb#{inputtext1}#{i}" name="vkb#{inputtext1}#{i}"
									type="text" value="#{editProf.brndProdInds}" class="vk_text"
									style="background-image: none; background:transparent; background-color: #{backingBean.compTwittAccCol2}; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;" />
								<br />
								<div
									style="width: 100px; font-weight: normal; font-weight: normal; font-size: 11px; color: #F17A4B;"
									class="edit_left_textGreen"><h:outputText
									value="#{backingBean.compTwittAccErr2}"
									style="font-size: 11px; color:#F17A4B;" />
								</div>
							</a4j:outputPanel> 
							
							<a4j:outputPanel	rendered="#{competitorhandlername eq 'Competitor #3'}">
								<input id="vkb#{inputtext1}#{i}" name="vkb#{inputtext1}#{i}"
								type="text" value="#{editProf.brndProdInds}" class="vk_text"
								style="background-image: none; background:transparent; background-color: #{backingBean.compTwittAccCol3}; border: 0px; margin-top: 1px; color: #7D848B; font-size: 10px;" />
								<br />
								<div
									style="width: 100px; font-weight: normal; font-weight: normal; font-size: 11px; color: #F17A4B;"
									class="edit_left_textGreen"><h:outputText
									value="#{backingBean.compTwittAccErr3}"
									style="font-size: 11px; color:#F17A4B;" />
								</div>
							</a4j:outputPanel>
						</div>
					</div>
					 -->
					</td>
					
				</tr>
				<tr>
					<td colspan="5" height="10">
					<div style="border-bottom: 1px solid #DDDDDD;"></div>
					</td>
				</tr>
			</table>
		</a4j:repeat></td>
	</tr>
</ui:composition>


