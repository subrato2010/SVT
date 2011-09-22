<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">

	<f:view>
		<a4j:form id="filter">
			<div class="mainBodyBottomUpper55">
				<div class="mainDivTopSB" id="main_x1a">
					<div id="captionDivSortby" class="captionDivTop" style="padding-left: 15px; width: 170px;">
						#{twitterController.filterString}
					</div>
					<div class="textDiv" style="float: left;">
						<h:inputText value="#{twitterController.filterString}"
							styleClass="fakeText"
							onclick="toggleList('x1a');document.getElementById('submenu').style.display='none';"
							onblur="closeList('x1a');" readonly="readonly"
							style="cursor:pointer; width: 35px;" />
					</div>
				</div>
				<div class="listDivTop" id="list_x1a" onmouseover="setInList(true);" onmouseout="setInList(false);">
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter1" class="FilterMenuSmall">
							<a4j:commandButton onclick="change(); setSortById('OFF');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="OFF"
								actionListener="#{twitterController.filterClickListener}"
								id="OFF"
								style="background-image: inherit; background: transparent; background-color: transparent; border-color: transparent;cursor: pointer; font-size: 12px; color: #707071; font-family: Verdana,Arial,Helvetica,sans-serif;text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter1').style.backgroundImage='url(../images/menuback/themeSelectBack.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter1').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter3" class="FilterMenumedi">
							<a4j:commandButton onclick="change(); setSortById('Theme');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Theme"
								actionListener="#{twitterController.filterClickListener}"
								id="THEME"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px; font-family: Verdana,Arial,Helvetica,sans-serif;text-align: left;text-indent: 0px; padding-left: 5px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter3').style.backgroundImage='url(../images/menuback/Allmention.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter3').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>

					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter4" class="FilterMenumedi">
							<a4j:commandButton
								onclick="change(); setSortById('Hashtag');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Hashtag"
								actionListener="#{twitterController.filterClickListener}"
								id="HASHTAG"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 5px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none';newToggleRTO();"
								onmouseover="document.getElementById('Filter4').style.backgroundImage='url(../images/menuback/Allmention.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter4').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter5" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Shortened Urls');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Shortened Urls"
								actionListener="#{twitterController.filterClickListener}"
								id="BITLY"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 5px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter5').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter5').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter6" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Negative Sentiment');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Negative Sentiment"
								actionListener="#{twitterController.filterClickListener}"
								id="NEGATIVE"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter6').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter6').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter7" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Positive Sentiment');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Positive Sentiment"
								actionListener="#{twitterController.filterClickListener}"
								id="POSITIVE"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter7').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter7').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter8" class="FilterMenumedi">
							<a4j:commandButton
								onclick="change(); setSortById('Influencer');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Influencer"
								actionListener="#{twitterController.filterClickListener}"
								id="INFLUENCER"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 5px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter8').style.backgroundImage='url(../images/menuback/brand.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter8').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter9" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Brand Mention');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Brand Mention"
								actionListener="#{twitterController.filterClickListener}"
								id="BRAND"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter9').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter9').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter10" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Product Mention');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Product Mention"
								actionListener="#{twitterController.filterClickListener}"
								id="PRODUCT"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter10').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter10').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter11" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Industry Mention');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Industry Mention"
								actionListener="#{twitterController.filterClickListener}"
								id="INDUSTRY"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter11').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter11').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter15" class="FilterMenuLarge">
							<a4j:commandButton
								onclick="change(); setSortById('Mention');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Mention"
								actionListener="#{twitterController.filterClickListener}"
								id="MENTION"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter15').style.backgroundImage='url(../images/menuback/neg-post.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter15').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter16" class="FilterMenuLarge" style="width: 180px;">
							<a4j:commandButton
								onclick="change(); setSortById('Competitor Mentions');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Competitor Mentions"
								actionListener="#{twitterController.filterClickListener}"
								id="COMPMENTION"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter16').style.backgroundImage='url(../images/menuback/compmention.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none'; document.getElementById('filter:LIST').style.color='#707071'; document.getElementById('Filter13').style.backgroundImage='none';"
								onmouseout="document.getElementById('Filter16').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>
					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter12"
							style="width: 95px; height: 20px; background-repeat: no-repeat;">
							<a4j:commandButton
								onclick="change(); setSortById('Following');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Following" id="FOLLOWING"
								actionListener="#{twitterController.filterClickListener}"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px; font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter12').style.backgroundImage='url(../images/menuback/Allmention.gif)'; this.style.color = '#ffffff'; document.getElementById('submenu').style.display='none';"
								onmouseout="document.getElementById('Filter12').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>

					<div class="itemDivTop" style="padding-bottom: 3px;">
						<div id="Filter13"
							style="width: 211px; height: 18px; background-repeat: no-repeat;">
							<a4j:commandButton
								onclick="change(); setSortById('List');toggleList('x1a');"
								hreflang="javascript:openRTO();" styleClass="optiontext"
								value="Lists" id="LIST"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071;border-color: transparent;cursor: pointer; font-size: 12px; font-family: Verdana,Arial,Helvetica,sans-serif; text-align: left; text-indent: 0px; padding-left: 7px;"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								onmouseover="document.getElementById('Filter13').style.backgroundImage='url(../images/menuback/list.gif)'; this.style.color = '#ffffff'; showUserList();"
								onmouseout="document.getElementById('Filter13').style.backgroundImage='none'; this.style.color='#707071';"
								reRender="updateList" />
						</div>
					</div>

					<div class="listBottomDiv"></div>
				</div>
			</div>

			<div id="submenu" onmouseover="setInList(true);" style="z-index: 10;"
				onmouseout="setInList(false);">
				<a4j:repeat value="#{twitterController.userList}" rowKeyVar="i"
					var="listByUser">
					<div class="itemDivTopFilter" style="padding-bottom: 3px;">
						<div id="Filter14_#{i}" class="submenuBack">
							<a href="#" onclick="change();" class="optiontext"
								style="background-image: inherit; background: transparent; text-decoration: none; background-color: transparent; color: #707071; border-color: transparent; cursor: pointer; font-size: 12px; font-family: Verdana, Arial, Helvetica, sans-serif; text-align: left; text-indent: 0px; padding-left: 0px;"
								onmouseover="document.getElementById('nifty#{i}').style.display='block'; document.getElementById('Filter14_#{i}').style.display='none'; this.style.color = '#ffffff'; document.getElementById('filter:LIST').style.color='#ffffff';document.getElementById('Filter13').style.backgroundImage='url(../images/menuback/list.gif)';"
								onmouseout="document.getElementById('nifty#{i}').style.display='none';; this.style.color='#707071';document.getElementById('Filter14_#{i}').style.display='block';">
								#{listByUser.name} </a>
						</div>
						<div id="nifty#{i}"
							style="display: none; background-color: #508F14; width: 202px; color: #ffffff;">
							<div class="rtop">
								<b class="r1"></b><b class="r2"></b><b class="r3"></b><b
									class="r4"></b>
							</div>

							<a4j:commandLink onclick="change();" styleClass="optiontext"
								value=""
								actionListener="#{twitterController.filterClickListener}"
								id="LIST"
								style="background-image: inherit; background: transparent; background-color: transparent; color: #707071; 
									border-color: transparent; cursor: pointer; font-size: 12px; font-family: Verdana, Arial, Helvetica, sans-serif; 
									text-align: left; text-indent: 0px; padding-left: 0px; text-decoration: none;"
								onmouseover="document.getElementById('nifty#{i}').style.display='block'; 
								document.getElementById('Filter14_#{i}').style.display='none'; 
								this.style.color = '#ffffff'; document.getElementById('filter:LIST').style.color='#ffffff';
								document.getElementById('Filter13').style.backgroundImage='url(../images/menuback/list.gif)';"
								onmouseout="document.getElementById('nifty#{i}').style.display='none';; 
								this.style.color='#707071';document.getElementById('Filter14_#{i}').style.display='block';"
								oncomplete="javascript:document.getElementById('transParentDocDiv').style.display='none'; newToggleRTO();"
								reRender="updateList">
								#{listByUser.name}
								<f:param name="listid" value="#{listByUser.id}" />
							</a4j:commandLink>
							<div class="rbottom">
								<b class="r4"></b><b class="r3"></b><b class="r2"></b><b
									class="r1"></b>
							</div>
						</div>
					</div>
				</a4j:repeat>
			</div>
		</a4j:form>
	</f:view>
</ui:composition>
