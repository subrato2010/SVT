      function markSelected(listObjectname, selectedValue)
      {
          var myselect=document.getElementById(listObjectname);
          for (var i=0; i < myselect.options.length; i++)
          {
              //alert(myselect.options[i].text);
	          if(myselect.options[i].text == selectedValue){
	        	  myselect.options[i].selected=true;
	        	  break;
	          }
          }
      }
      function closeP(){
        	var bd = parent.document.getElementById("floatingDiv");
        	bd.style.display = "none";
        	var bd = parent.document.getElementById("backDrop");
       	 bd.style.display = "none";
        } 
      function populateKeyword(inputBrand, inputProduct, inputIndustry, selectedValue)
	  {
	      if(selectedValue == "Customer"){
	    	  document.getElementById(inputBrand).value=customerObj.brandkeyword;
	    	  document.getElementById(inputProduct).value=customerObj.productkeyword;
	    	  document.getElementById(inputIndustry).value=customerObj.industrykeyword;
	      }else if(selectedValue == "Competitor #1"){
	    	  document.getElementById(inputBrand).value=comp1Obj.brandkeyword;
			  document.getElementById(inputProduct).value=comp1Obj.productkeyword;
			  document.getElementById(inputIndustry).value=comp1Obj.industrykeyword;
		  }else if(selectedValue == "Competitor #2"){
	    	  document.getElementById(inputBrand).value=comp2Obj.brandkeyword;
			  document.getElementById(inputProduct).value=comp2Obj.productkeyword;
			  document.getElementById(inputIndustry).value=comp2Obj.industrykeyword;
		  }else if(selectedValue == "Competitor #3"){
	    	  document.getElementById(inputBrand).value=comp3Obj.brandkeyword;
	    	  document.getElementById(inputProduct).value=comp3Obj.productkeyword;
	    	  document.getElementById(inputIndustry).value=comp3Obj.industrykeyword;
	  	  }
	   }    
      
      function populateText(objectname, selectedValue)
  	{
    	  if(document.getElementById(objectname) != null){
    		  document.getElementById(objectname).value=selectedValue;
    	  }
  	}
      
function setEnability(inputBrand, brandEnableButtonId, brandDisableButtonId, inputProduct, productEnableButtonId, productDisableButtonId, inputIndustry, industryEnableButtonId, industryDisableButtonId) {	
	if(document.getElementById(inputBrand).value.split(',').length > 10) {
		document.getElementById(brandEnableButtonId).style.display = 'none';
		document.getElementById(brandDisableButtonId).style.display = 'block';
	} else {
		document.getElementById(brandEnableButtonId).style.display = 'block';
		document.getElementById(brandDisableButtonId).style.display = 'none';
	}
	
	if(document.getElementById(inputProduct).value.split(',').length > 10) {
		document.getElementById(productEnableButtonId).style.display = 'none';
		document.getElementById(productDisableButtonId).style.display = 'block';
	} else {
		document.getElementById(productEnableButtonId).style.display = 'block';
		document.getElementById(productDisableButtonId).style.display = 'none';
	}
	
	if(document.getElementById(inputIndustry).value.split(',').length > 10) {
		document.getElementById(industryEnableButtonId).style.display = 'none';
		document.getElementById(industryDisableButtonId).style.display = 'block';
	} else {
		document.getElementById(industryEnableButtonId).style.display = 'block';
		document.getElementById(industryDisableButtonId).style.display = 'none';
	}
}
