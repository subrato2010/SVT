
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
<table width="430" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
  	<table>
  		<tr height="35">
  			<td align="left" valign="middle">
  			<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
  			</td>
  			<td align="left" valign="middle">
  			<div class="fileinputs1" style="width: 30px;">
                       		<t:selectOneMenu id="profile" value="abcd" 
                             				 styleClass="state11" onchange="selectedItem('profile', 'vkprofile', this.value)">
                             	<f:selectItem itemValue="@Customer1" />
                             	<f:selectItem itemValue="@Customer2" />
                             	<f:selectItem itemValue="@Customer3" />
                             	<f:selectItem itemValue="@Customer4" />
                             	<f:selectItem itemValue="@Customer5" />
                             	<f:selectItem itemValue="@Customer6"/>
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
  	<table width="85%" border="0" align="center" style="margin-top: 10px;">
    
  	<tr>
  	<td  class="influAlert" valign="top" align="right" style="font-weight: bold;">
  	List Name
  	</td>
  	<td valign="top" align="left" class="edit_left_text">
  	<input type="text" name="listname" style="width: 295px; height: 25px; background-image: none; border: 1px solid #CFCFCF;"/>
	</td>
  	
  	</tr>
  	
  	<tr>
  	<td  class="influAlert" valign="top" align="right" style="font-weight: bold;">
  	Description
  	</td>
  	<td valign="top" align="left" class="edit_left_text">
  	<textarea rows="2" cols="50"></textarea>
  	
	</td>
  	
  	</tr>
  	<tr>
  	<td  valign="top" align="right" style="font-weight: bold;">
  	</td>
  	<td valign="top" align="left" class="influAlert" style="color: #D9D9D9p;">
  	Under 100 characters, optional
	</td>
  	
  	</tr>
  	<tr>
  	<td  class="influAlert" valign="top" align="right" style="font-weight: bold;">
  	Privacy
  	</td>
  	<td valign="top" align="left">
  	<table width="100%">
  		<tr>
  			<td valign="middle" align="left" width="30">
  			<input type="radio" id="chkOne" name="chk" value="aaaa"
					onClick="SingleSelect('chk',this);"
				class="styled" />
  			</td>
  			<td valign="middle" align="left" class="influAlert">
  			<font style="font-weight: bold;">Public</font> - Anyone can follow this list
  			</td>
  		</tr>
  		<tr>
  			<td valign="middle" align="left" width="30">
  			<input type="radio" id="chkOne" name="chk" value="aaaa"
					onClick="SingleSelect('chk',this);"
				class="styled" />
  			</td>
  			<td valign="middle" align="left" class="influAlert">
  			<font style="font-weight: bold;">Private</font> - Only you can access this list
  			</td>
  		</tr>
  	</table>
	</td>
  	
  	</tr>
  	<tr>
  	<td  valign="top" align="left" colspan="2">
  	<table width="100%" cellpadding="0" cellspacing="0">
    		<tr>
    			<td class="closeOrangeTextAlert" align="left" valign="top" width="110">
    			<a href="#" onclick="parent.document.getElementById('floatingDiv3').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';">
				    <img src="../images/Alert/createListButton.gif" border="0"/>
				</a>
    			</td>
    			<td align="left" valign="middle" class="closeOrangeTextAlert">
			    <font style="color: #737883; padding-left: 4px; font-size: 15px;">or</font>  
			    <font style="padding-left: 4px;">
			    <a href="#" onclick="parent.document.getElementById('floatingDiv3').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';" style="color: #F2A413; text-decoration: none;">
			    CANCEL
			    </a>
			    </font>
			    </td>
			    <td valign="middle" align="right" class="influAlert">
  	<a onclick="parent.document.getElementById('floatingDiv3').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';" href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;">
  		CLOSE
  		</a>
	</td>
    		</tr>
    </table>
  	
  	</td>
  	
  	
  	</tr>
  	
  	
  	
  	
  
  </table>
  </td>
  </tr>


</table>




	
	
</ui:composition>

