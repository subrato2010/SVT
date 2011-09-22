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
    <script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
    <script language="JavaScript" src="../js/designMainScreen.js"/>	
 	<a4j:loadScript src="/js/custom-form-elements.js" />
<f:view contentType="text/html">
<table width="430" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
  	<table border="0" cellpadding="0"  cellspacing="0">
  		<tr height="35">
  			<td align="left" valign="middle">
  			<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
  			</td>
  			<td align="left" valign="middle">
  				<div id="geoLocatonPopupName">
  						@#{twitterController.firstCustomerName}
  				</div>
  			</td>
  		</tr>
	</table>
  	</td>
  </tr>
  <tr>
  	<td valign="top" align="center">
  	<table width="370" border="0" align="center" style="margin-top: 10px;">
    
  	<tr>
  	<h:form>
	  	<td  class="influAlert" valign="middle" align="right" style="font-weight: bold;" width="50">
	  	Location
	  	</td>
	  	<td valign="top" align="left" class="edit_left_text" width="290">
	  		
	  			<h:inputText id="listname" style="width: 290px; height: 28px; background-image: none; 
	  						border: 2px inset #6E7177; padding-left: 10px; 
	  						font-size: 12px; color: #737883; font-weight: bold; padding-top: 3px;"
	  						value="#{twitterController.searchGEOLocation}"/>
	  						
		</td>
		<td valign="top" align="left" class="edit_left_text" width="30">
			
				<h:commandButton 
					image="../images/searchButton.gif"
					oncomplete="parent.document.getElementById('GRButton5').click();"
					actionListener="#{twitterController.searchNearByGeoLocationByPlace}"/>
		</td>
	</h:form>
  	</tr>
  	
  	<tr>
  		<td valign="top" align="left" class="edit_left_text"  width="50">
  		</td>
  		<td valign="top" align="left" class="edit_left_textN" style="color: #CCCCCC; padding-top: 0px; padding-left: 10px; " width="290">
  		Leave blank to just select nearby city
  		</td>
  		<td valign="top" align="left" class="edit_left_text" width="30">
  		</td>
  		
  	</tr>
  	<tr>
  		<td valign="top" align="left" class="edit_left_text"  width="50">
  		</td>
  		<td valign="top" align="left" class="edit_left_text" style="color: #DBDBDB; padding-top: 0px;" width="290">
  		

		<table width="290" border="0" cellpadding="0" cellspacing="0" height="100%">
			
			<tr>
				<td valign="top" align="left" width="300">
				<div style="width: 290px; height: 4px; overflow: hidden; border-bottom: 1px solid #CCCCCC">
				</div>
				</td>
			</tr>
			
			<!-- <h:inputText value="#{twitterController.searchGeolocationFieldBlank}"/>  --> <!-- for testing -->
			
				
				<a4j:form>
					<a4j:repeat value="#{makePagination.paginator.currentList}"
													var="geoLocationList" rowKeyVar="i">
												
						<tr bgcolor="#{(i%2==0)?('ededed'):('white')}">
							<td valign="middle" align="left" height="40">
								<div style="width: 290px; height: auto; overflow: hidden;">
									<a4j:commandLink style="color: #77c442; text-decoration: none" 
											styleClass="searchDetailsGreen"	value="#{geoLocationList}" 
											actionListener="#{twitterController.updateGeoLocationForHandler}"
											oncomplete="parent.document.getElementById('mytestdiv').innerHTML='#{twitterController.yourLocation}';allClose();">
											<f:param name="newLocation" value="#{geoLocationList}"/>
									</a4j:commandLink>
									
									<!--
									   <font class="searchDetailsGreen">#{geoLocationList}</font><br/>
										<font class="searchDetailsGray">Back Bay, 02110</font>
									-->
								</div>
							</td>
						</tr>	
					</a4j:repeat>
				</a4j:form>	
			
			
			<tr>
				<td valign="middle" align="left" height="40">
				<div style="width: 290px; height: auto; overflow: hidden;">
				<table width="290" border="0" cellpadding="0" cellspacing="0">
				
				<tr>
					<td width="0px"> 
						<h:outputLink value="searchLocationDetails.jsp" rendered="#{makePagination.paginator.previousPossible }">
							
							<div>
						    	<div style="float: left; width: 220px; height: 1px;">
						    		<img alt="Next" src="../images/PrevGreen.gif" border="0"/>
						    	</div>
						    	<div style="float: right; width: 200px; height: 30px; text-decoration: none;"> 
						    		PREV
						    	</div>
						    </div>
							<f:param name="currentpage" value="#{makePagination.currentPage - 1 }"/>
						</h:outputLink>
					</td> 
				
					
					<td width="25" valign="top" align="center" class="searchDetailsGreenNav">|</td>
					
					<a4j:repeat value="#{makePagination.paginator.pageIndexes}" var="index">
						<td width="41px" valign="middle" align="center" class="#{(index == makePagination.currentPage)? 'selected' : 'nonSelected'}">
							<!--
								<span class="linkSpan">
									<h:outputLink  value="searchLocationDetails.jsp" styleClass="index">
										#{index}
										<f:param name="currentpage" value="#{index}"/>
									</h:outputLink>	
								</span>	
						   -->
						</td> 
					</a4j:repeat>
					
					
					<td width="0px"> 
						<h:outputLink styleClass="index" value="searchLocationDetails.jsp" rendered="#{makePagination.paginator.nextPossible }">
							
							<div>
						    	<div style="float: left; width: 230px; height: 0px; text-decoration: none;">
									NEXT
						    	</div>
						    	<div style="float: right; width: 200px; height: 30px;"> 
						    		<img alt="Next" src="../images/NextGreen.gif" border="0"/>
						    	</div>
						    </div>
						
							<f:param name="currentpage" value="#{makePagination.currentPage + 1 }"/>
						</h:outputLink>
					</td> 
					<td width="185" valign="top" align="center"></td>
				</tr>
				
				</table>
				
				</div>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left" width="300">
				<div style="width: 290px; height: 4px; overflow: hidden; border-bottom: 1px solid #CCCCCC">
				</div>
				</td>
			</tr>
		</table>

  		</td>
  		<td valign="top" align="left" class="edit_left_text" width="30">
  		</td>
  	</tr>
  	<tr>
  		<td valign="top" align="left" class="edit_left_text" width="50">
  		</td>
  		<td class="closeOrangeTextAlert" align="left" valign="top" width="290">
  		<a href="#" onclick="allClose();">
				    <img src="../images/cancelButton.gif" border="0"/>
		</a>
  		</td>
  		<td valign="middle" align="right" class="influAlert" width="30">
	  		<a onclick="allClose();" href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;">
	  		CLOSE
	  		</a>
		</td>
  		
  	</tr>
 </table>
 </td>
 </tr>
 </table>
 </f:view>
</ui:composition>

