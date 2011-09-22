<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk">
	
	<link href="../css/profile.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="../js/all.js"></script>
	<script language="JavaScript" src="../js/svt.js"></script>		
    <script language="JavaScript" src="../js/popup.js"></script>
	<script language="JavaScript" src="../js/designMainScreen.js"></script>
	<script language="JavaScript">
		function coloseListRefreshing(str)
		{
			if(str == true || str == 'true')
			{
				var bd = parent.document.getElementById("floatingDiv1");
				bd.style.display = "none";
				var bd = parent.document.getElementById("backDrop");
				bd.style.display = "none";
				parent.location.href="./twitterChannelOptimization.jsp?refresh=0";
			}
		}
	</script>
	
<f:view>
	<body onload="coloseListRefreshing('#{twitterController.loadRefreshPage}');">
	<h:inputHidden value="#{replyTwitterDataController.referenceName}"/>
	<a4j:outputPanel rendered="#{(twitterController.loadRefreshPage eq false)}">
		
	    <table width="100%" cellpadding="0" cellspacing="0" border="0" style="margin-top: 20px;">
	    	<tr>
	    		<td valign="top"  width="100%" align="center" style="font-size: 30px; padding-left: 42px;" 
	    				class="authAlert">
		    		Refresh List?
				</td>
			</tr>
			<tr>
			
	    		<td valign="top" align="center" class="authAlertText">
	    		Warning: TBD  
	    		</td>
	    	</tr>
	    	<tr>
	    		<h:form>
<!--	    		<input type="hidden" value="TestValues" id="hiddenRefresh"/>-->
	    		<td height="48" align="left" style="padding-left: 10px;">
	    			<h:commandButton value="Refresh List" id="refreshTwittPopup" 
							actionListener="#{twitterController.twittMessage}" 
							style="text-decoration: none; font-size: 12px; cursor:pointer;
							background-image: none; border-color:transparent;
							background-color: transparent; color: #7AC142; font-weight: bold;"
							onclick="javascript:coloseListRefreshing('#{twitterController.loadRefreshPage}'); document.getElementById('floatingDiv1').style.display='none'; document.getElementById('backDrop').style.display='none';">
					</h:commandButton>
				</td>
				
				<td style="padding-top: 7px;"><a href="#"
					onclick="parent.document.getElementById('floatingDiv1').style.display='none'; parent.document.getElementById('backDrop').style.display='none';"
					style="text-decoration: none; padding-top: 5px;"> <font
					class="edit_left_text1"
					style="color: #7AC142; font-size: 11px;">CANCEL</font> </a>
				</td>
	    		</h:form>
	    	</tr>
	    </table>
	    </a4j:outputPanel>
	    </body>
</f:view>
<script>
	//parent.location.href="twitterChannelOptimization.jsp?refresh=0";
	//coloseListRefreshing('#{twitterController.loadRefreshPage}');
</script>
</ui:composition>
