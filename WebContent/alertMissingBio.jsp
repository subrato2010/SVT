
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

<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
	<tr>
 		<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
 		<table width="390" border="0" cellpadding="0" cellspacing="0">
 			<tr height="35">
 				<td align="left" valign="middle" width="110">
 					<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
 				</td>
 				<td align="left" valign="middle">
 					<div class="fileinputs1">
                    	<t:selectOneMenu id="inflalertlist" value=""
                        	styleClass="state11" onchange="selectedItem('inflalertlist', 'vkinflalertlist', this.value)">
                            	<f:selectItems value="#{channelPerformanceController.selfTwitterAccounts}"/>
                		</t:selectOneMenu>
                 		<div class="alertDropDown" >
                    		<input id="vkinflalertlist" type="text" value="#{channelPerformanceController.firstSelfTwitterAccounts}" 
                    			class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 2px; 
                    				background-image: none;color:#7D848B; font-size:10px; font-weight:bold;"/>
  	               		</div>        
						<script>selectedItem('profile', 'vkprofile', '');</script>
					</div>
				</td>		
			</tr>
		</table>  	
  		</td>
  	</tr>


	<tr>
    <td class="closeOrangeTextAlert" valign="middle"></td> 	
    <td align="left" valign="top">
	    <table width="100%" cellpadding="0" cellspacing="0">
	    	<tr>
	    		<td class="closeOrangeTextAlert" align="left" valign="top" width="80">
	    			<a href="#" onclick="parent.document.getElementById('GRButton').click(); 
	        			parent.document.getElementById('floatingDiv1').style.display='none';">
					    <img src="../images/Alert/General/followButtonOrange.gif" border="0" width="82" 
				    	onmouseover="changeImage(this,'../images/Alert/Rollover/followButtonOrangeRollover.gif');" 
				    	onmouseout="changeImage(this,'../images/Alert/General/followButtonOrange.gif');" />
					</a>
	    		</td>
	   		</tr>    	
	   	</table>
    </td>
	</tr>
	
  	<tr>
  	<td align="right" valign="top"  colspan="3">
  		<a onclick="parent.document.getElementById('floatingDiv1').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.location.reload();" href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;">
  		CLOSE
  		</a>
  	</td>
  	</tr>
  </table>
  
</ui:composition>

