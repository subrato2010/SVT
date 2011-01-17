<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">


<f:view>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="220px">    
                            <div id="top_pannel_left">
                            <img src="../images/comp_logo.jpg" />
                            </div>
                        </td>
                            <td width="1005px">
                        
                                            <table width="99%" border="0" cellpadding="0" cellspacing="0" style="margin-left:10px">	
                                              <tr>
                                                <td colspan="9">
                                                
                                                                <table width="100%" border="0">
                                                                  <tr>
                                                                    <td class="matter_top_search" width="175" style="padding-left:8px">Brand(s)</td>
                                                                   
                                                                    <td class="matter_top_search" width="175" style="padding-left:12px">Product(s)</td>
                                                                
                                                                    <td class="matter_top_search" width="175" style="padding-left:12px">Benchmark Report(s)</td>
                                                                   
                                                                   <td class="matter_top_search" width="175" style="padding-left:12px">Campaign(s)</td>
                                                                     <td colspan="3"></td>
                                                                   <td class="matter_top_search" width="175"></td>
                                                                  </tr>
                                                                </table>

                                                 </td>
                                              </tr>
                                              <tr>
                                              
                                                <td colspan="9">
                                                

 
 
 
 
 
 <table width="781px" border="0" height="30px">
  <tr>
    <td width="184px" valign="top">
    
    	
<div class="mainDiv" id="main_x">
<div class="captionDiv">Create or View</div> 
<div class="textDiv" >
	<input  type="text" value="" class="fakeText" onBlur="closeList('x');" onClick="toggleList('x')" readonly="readonly" style="cursor:auto; text-align:right; "/>
</div>
    
</div>
<div class="listDiv" id="list_x" onmouseover="setInList(true);" onmouseout="setInList(false);">
	<ui:repeat value="#{listItemMgr.brandDTOList}" var="brand">
	              <div class="itemDiv"><a href="#" class="optiontext">
	               #{brand.brandName}</a>
	               </div>
	             </ui:repeat>
	
		<div class="listBottomDiv"  ></div>
</div>
    	
    	
    	
    	

    </td>
    <td></td>
	<td width="184px" valign="top">
		<div class="mainDiv" id="main_x1">
			<div class="captionDiv">Create or View</div> 
			<div class="textDiv">
				<input  type="text" value="" class="fakeText" onBlur="closeList('x1');" onClick="toggleList('x1')" readonly="readonly" style="cursor:auto; text-align:right; "/>
			</div>			    
		</div>
		<div class="listDiv" id="list_x1" onmouseover="setInList(true);" onmouseout="setInList(false);">
			<ui:repeat value="#{listItemMgr.productDTOList}" var="product">
				<div class="itemDiv">
					<a href="#" class="optiontext">#{product.productName}</a>
				</div>
			</ui:repeat>
			<div class="listBottomDiv"  ></div>
		</div>
	</td>

   	<td></td>
   	<td width="184px" valign="top">
		<div class="mainDiv" id="main_x2">
			<div class="captionDiv">Create or View</div> 
			<div class="textDiv">
				<input  type="text" value="" class="fakeText" onBlur="closeList('x2');" onClick="toggleList('x2')" readonly="readonly" style="cursor:auto; text-align:right; "/>
			</div>			    
		</div>
		<div class="listDiv" id="list_x2" onmouseover="setInList(true);" onmouseout="setInList(false);">
			<ui:repeat value="#{listItemMgr.benchmarkDTOList}" var="benchmark">
				<div class="itemDiv">
					<h:outputLink styleClass="optiontext" value="" >
					#{benchmark.benchMarkName}
					<f:param name="benchmarkId" value="#{benchmark.benchMarkId}"/>
					</h:outputLink>
					
				</div>
			</ui:repeat>
			<div class="listBottomDiv"  ></div>
		</div>
	</td>

   	<td></td>

  	<td width="184px" valign="top">
  	
  	
<div class="mainDiv" id="main_x3">
<div class="captionDiv">Create or View</div> 
<div class="textDiv">
	<input  type="text" value="" class="fakeText" onBlur="closeList('x3');" onClick="toggleList('x3')" readonly="readonly" style="cursor:auto; text-align:right; "/>
</div>
    
</div>
<div class="listDiv" id="list_x3" onmouseover="setInList(true);" onmouseout="setInList(false);">
	
		<ui:repeat value="#{listItemMgr.roiCampaignDTOList}" var="campaign">
			              <div class="itemDiv">
			              
			              <a  href="overallROIEdit.jsp?campaignId=#{campaign.campaignId}" 
			              	class="optiontext">
			               #{campaign.campaignName}
			               </a>
			               </div>
			             </ui:repeat>
		
		
		<div class="listBottomDiv"  ></div>
</div>


	</td>
    <td width="15px" align="center" valign="middle"><img src="../images/border.jpg" height="20" /></td>
 	<td width="183px" valign="top">
<div class="mainDiv_green" id="main_x4">
<div class="captionDiv" style="color:#ffffff;">Create or View</div> 
<div class="textDiv">
	<input  type="text" value="" class="fakeText" onBlur="closeList('x4');" onClick="toggleList('x4')" readonly="readonly" style="cursor:auto; text-align:right; "/>
      
</div>
</div>
<div class="listDiv_green" id="list_x4" onmouseover="setInList(true);" onmouseout="setInList(false);">
<ui:repeat value="#{listItemMgr.exportDTOList}" var="export">
    <div class="itemDiv_green">
	    <a  href="#{export.name}" class="optiontext">
	     	#{export.name}
	    </a>
    </div>
  
</ui:repeat>
<div class="listBottomDiv_green"></div>
</div>

	</td>
  </tr>
</table>
                                        
                                                </td>
                                              </tr>
                                            
                                            </table>
                        
                         </td>
                          </tr>
                        </table>





</f:view>
</html>