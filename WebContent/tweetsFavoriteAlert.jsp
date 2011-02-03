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
	<table width="410" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
  	<table>
  		<tr height="35">
  			<td align="left" valign="middle">
  			<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
  			</td>
  			<td align="left" valign="middle">
  			<div class="fileinputs1" style="width: 30px;">
                       		<t:selectOneMenu id="profile" value="#{twitterAccountDTO.twitterUsername}"
                             				 styleClass="state11" onchange="selectedItem('profile', 'vkprofile', this.value)">
                             	<f:selectItems value="#{userProfileController.allTwitterAccounts}"/>
	                         </t:selectOneMenu>
    	                      <div class="alertDropDown" >
        	                     <input id="vkprofile" type="text" value="@Customer1" 
        	                     	class="vk_text" style="background-color: transparent; border-width: 0px; padding-top : 2px; 
        	                     		  background-image: none;color:#7D848B; font-size:10px; font-weight:bold;"/>
            	               </div>        
      				<script>
      				selectedItem();           
                  </script>
	 		</div>
  			</td>
  		</tr>
  	</table>
  	
  	</td>
  </tr>
  <tr>
  	<td valign="top" align="center">
  	<table width="95%" border="0" align="center" style="margin-top: 10px;">
    <tr>
  	<td><img src="../images/Logo1.gif" border="0"/></td>
  	<td class="influAlertTF3" bgcolor="#F2F2F2" align="center" valign="middle">
  	<div  class="insideAlert">
  	User ID<br/>
  	<font style="font-weight: bold; font-size: 14px;">@influencer#1</font>
  	</div>
  	</td>
  	<td class="influAlert" bgcolor="#F2F2F2" align="center" valign="middle">
  	<div class="insideAlert1">
  	SCORE<br/><font style="color: #76BB44; font-weight: bold; font-size: 18px;">1</font>
  	</div>
  	</td>
  	</tr>
  	
  	<tr>
  	<td></td>
  	<td colspan="2" class="influAlert2" valign="top" align="left">
  		<table width="100%"  border="0" cellpadding="0" cellspacing="0">
					<tr height="20">
						<td valign="middle" align="left" class="influAlertTF1" width="60%">RT Volume</td>
						<td valign="middle" align="left" class="influAlertTF" style="font-size: 18px;">3,456</td>
					</tr>
					<tr height="20">
						<td valign="middle" align="left"  class="influAlertTF1" width="60%"  bgcolor="#F2F2F2">Reply/Mention Volume</td>
						<td valign="middle" align="left" class="influAlertTF" bgcolor="#F2F2F2" style="font-size: 18px;">1,236</td>
					</tr>
					<tr height="20">
						<td valign="middle" align="left"  class="influAlertTF1" width="60%">Type</td>
						<td valign="middle" align="left" class="influAlertTF">
						<font style="font-weight: bold; font-size: 12px; color: #737883;">
						BRAND REFERENCE
						</font>
						</td>
					</tr>
					<tr height="20">
						<td valign="middle" align="left"  class="influAlertTF1" width="60%" bgcolor="#F2F2F2">Influencer Activity</td>
						<td valign="middle" align="left" class="influAlertTF" bgcolor="#F2F2F2" style="font-size: 18px;">6</td>
					</tr>
				
		</table>
	</td>
  	
  	</tr>

<tr>
    <td class="closeOrangeTextAlert" valign="middle"></td>
   
    	
    <td align="left" valign="top" colspan="2">
    	<table width="100%" cellpadding="0" cellspacing="0" style="margin-top: 4px;">
    		<tr>
    			<td class="closeOrangeTextAlert" align="left" valign="top" width="80">
    			<a href="#" onclick="parent.document.getElementById('GRButton').click(); parent.document.getElementById('floatingDiv1').style.display='none';">
				    <img src="../images/Alert/favoriteButtobOrange.gif" border="0"/>
				</a>
    			</td>
    			<td align="left" valign="middle" class="closeOrangeTextAlert">
			    <font style="color: #737883; padding-left: 4px;">or</font>  
			    <font style="padding-left: 4px;">DELETE</font>
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
  </td>
  </tr>


</table>
	
	
	
	
	<!--<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
 
  	

<tr>
    <td colspan="2" align="left" valign="top">
    
    <a href="#" onclick="openPopup2('Optimization Completed',23, 20, 450, 210, 10, false, true, false, 'optimizationComptAlert.jsp')">
    <img src="../images/Alert/followButtonOrange.gif" border="0"/>
    </a>
    
    
    
    </td>
    <td class="closeOrangeText" valign="middle">or DELETE  </td>
  </tr>
  </table>
  </td>
  </tr>


</table>







	--><!--Green POPUP-->
	

	
</ui:composition>
