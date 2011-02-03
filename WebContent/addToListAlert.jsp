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
	<table width="780" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  	<td class="optiAlert" align="left" valign="middle" bgcolor="#D0D0D0"  height="30">
  	<table>
  		<tr height="35">
  			<td align="left" valign="middle">
  			<font style="color: #EDEDED; padding-left: 20px;">For profile</font> 
  			</td>
  			<td align="left" valign="middle">
  			<div class="fileinputs1" style="width: 30px; color: #7D848B;">
                       		<t:selectOneMenu id="profile" value="abcd" 
                             				 styleClass="state11" onchange="selectedItem('profile', 'vkprofile', this.value)">
                             	<f:selectItem  itemValue="@Customer1" enabledClass="state11" />
                             	<f:selectItem itemValue="@Customer2" enabledClass="state11" />
                             	<f:selectItem itemValue="@Customer3"  enabledClass="state11"/>
                             	<f:selectItem itemValue="@Customer4"  enabledClass="state11"/>
                             	<f:selectItem itemValue="@Customer5"  enabledClass="state11"/>
                             	<f:selectItem itemValue="@Customer6" enabledClass="state11"/>
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
<table width="750" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
  <tr bgcolor="#F2F2F2">
    <td width="50" align="center" valign="top" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><img src="../images/Logo1.gif" border="0"/></td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><font class="topFirstTablehdCategory">User ID</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">@influencer #1</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">First</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">John</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Last</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">Marks</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Title</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">CEO at Netezza</font>
    </td>
    <td align="center" valign="middle" width="130" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <img src="../images/Alert/addToListButton.gif"  border="0"
      style=" margin-right:5px; cursor: pointer;" 
      onclick="parent.document.getElementById('GRButton1').click(); parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; this.src='../images/Alert/addToListButtonRollover.gif';"/>
    
    
    </td>
    <td align="center" valign="middle" width="45" style="border-bottom:4px solid #ffffff;"><img src="../images/Alert/closeGaryButton.gif" border="0"/></td>
  </tr>




  <tr bgcolor="#F2F2F2">
    <td width="50" align="center" valign="top" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><img src="../images/Logo1.gif" border="0"/></td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><font class="topFirstTablehdCategory">User ID</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">@influencer #1</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">First</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">John</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Last</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">Marks</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Title</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">CEO at Netezza</font>
    </td>
    <td align="center" valign="middle" width="130" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
	<img src="../images/Alert/addToListButton.gif"  border="0"
      style=" margin-right:5px; cursor: pointer;" 
      onclick="parent.document.getElementById('GRButton2').click(); parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; this.src='../images/Alert/addToListButtonRollover.gif';"/>
    </td>
    <td align="center" valign="middle" width="45" style="border-bottom:4px solid #ffffff;">
    <img src="../images/Alert/closeGaryButton.gif" border="0"/></td>
  </tr>




  <tr bgcolor="#F2F2F2">
    <td width="50" align="center" valign="top" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><img src="../images/Logo1.gif" border="0"/></td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><font class="topFirstTablehdCategory">User ID</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">@influencer #1</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">First</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">John</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Last</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">Marks</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Title</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">CEO at Netezza</font>
    </td>
    <td align="center" valign="middle" width="130" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
	<img src="../images/Alert/addToListButton.gif"  border="0"
      style=" margin-right:5px; cursor: pointer;" 
      onclick="parent.document.getElementById('GRButton3').click(); parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; this.src='../images/Alert/addToListButtonRollover.gif';"/>
    </td>
    <td align="center" valign="middle" width="45" style="border-bottom:4px solid #ffffff;"><img src="../images/Alert/closeGaryButton.gif" border="0"/></td>
  </tr>



  <tr bgcolor="#F2F2F2">
    <td width="50" align="center" valign="top" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><img src="../images/Logo1.gif" border="0"/></td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;"><font class="topFirstTablehdCategory">User ID</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">@influencer #1</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">First</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">John</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Last</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">Marks</font>
    </td>
    <td align="left" valign="middle" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
    <font class="topFirstTablehdCategory">Title</font>
    <br/>
    <font class="topFirstTablehdCategoryDrop">CEO at Netezza</font>
    </td>
    <td align="center" valign="middle" width="130" style="border-bottom:4px solid #ffffff; border-right:4px solid #ffffff;">
	<img src="../images/Alert/addToListButton.gif"  border="0"
      style=" margin-right:5px; cursor: pointer;" 
      onclick="parent.document.getElementById('GRButton4').click(); parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; this.src='../images/Alert/addToListButtonRollover.gif';"/>
    </td>
    <td align="center" valign="middle" width="45" style="border-bottom:4px solid #ffffff;"><img src="../images/Alert/closeGaryButton.gif" border="0"/></td>
  </tr>

  <tr>
    <td colspan="7" headers="10"></td>
  </tr>
<tr>
    <td colspan="6" align="left" valign="top">
    
    <a href="#" onclick="parent.document.getElementById('GRButton').click(); parent.document.getElementById('floatingDiv1').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none';">
    <img src="../images/Alert/submitButtonOrange.gif" border="0"/>
    </a>
    
    
    
    </td>
    <td class="closeOrangeText" valign="middle">
    <a onclick="parent.document.getElementById('floatingDiv1').style.display='none'; parent.document.getElementById('backDrop').style.display='none'; parent.document.getElementById('ALMore').style.display='none'; parent.document.getElementById('ALMore1').style.display='none'; parent.document.getElementById('ALMore2').style.display='none'; parent.document.getElementById('ALMore3').style.display='none'; parent.location.reload();" href="#" class="closeOrangeTextAlert" style="color: #F2A413; text-decoration: none;">
    CLOSE
    </a>
    </td>
  </tr>


</table>
</td>
</tr>
</table>



	
</ui:composition>
