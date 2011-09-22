
	function expandcategorylist(selectedcategory, col1){
	   col = "dashboardSIDataForm:" + col1;
	   if(selectedcategory == "1"){
		    col = "outboundMetricsForm1:" + col1;
		    toggleTextListBox('toggleTextOM','displayTextOM');
		    document.getElementById(col + "1").style.color="#2874ae";
	   }else if(selectedcategory == "2"){
		    toggleTextListBox('toggleTextIM','displayTextOM');
		    document.getElementById(col + "2").style.color="#2874ae";
	   }else if(selectedcategory == "3"){
		    toggleTextListBox('toggleTextE','displayTextEngagement');
		    document.getElementById(col + "3").style.color="#2874ae";
	   }else if(selectedcategory == "4"){
		    toggleTextListBox('toggleTextR','displayTextReach');
		    document.getElementById(col + "4").style.color="#2874ae";
	   }else if(selectedcategory == "5"){
		    toggleTextListBox('toggleTextL','displayTextLoyalty');
		    document.getElementById(col + "5").style.color="#2874ae";
	   }else if(selectedcategory == "6"){
		    toggleTextListBox('toggleTextD','displayTextDemographics');
		    document.getElementById(col + "6").style.color="#2874ae";
	   }else if(selectedcategory == "7"){
		    toggleTextListBox('toggleTextRet','displayTextConversion');
		    document.getElementById(col + "7").style.color="#2874ae";
	   }else if(selectedcategory == "8"){
		    document.getElementById(col + "8").style.color="#2874ae";
		    toggleTextListBox('toggleTextIn','displayTextInfluence');


		    
	   }else if(selectedcategory == "9"){
		    toggleTextListBox('toggleTextS','displayTextSentiment');
		    document.getElementById(col + "9").style.color="#2874ae";
	   }		
	}


   if(document.URL.indexOf("listType=1")>0){
	 	document.getElementById('targetType1').value=targetType();
	    toggleOM();
   }else if(document.URL.indexOf("listType=2")>0){
	    document.getElementById('targetType2').value=targetType();
	    toggleIM();
   }else if(document.URL.indexOf("listType=3")>0){
	    document.getElementById('targetType3').value=targetType();
	    toggleE();
   }else if(document.URL.indexOf("listType=4")>0){
	    document.getElementById('targetType4').value=targetType();
	    toggleR();
   }else if(document.URL.indexOf("listType=5")>0){
	    document.getElementById('targetType5').value=targetType();
	    toggleL();
   }else if(document.URL.indexOf("listType=6")>0){
	    document.getElementById('targetType6').value=targetType();
	    toggleD();
   }else if(document.URL.indexOf("listType=7")>0){
	    document.getElementById('targetType7').value=targetType();
	    toggleRet();
   }else if(document.URL.indexOf("listType=8")>0){
	    document.getElementById('targetType8').value=targetType();
	    toggleIn();
   }else if(document.URL.indexOf("listType=9")>0){
	    document.getElementById('targetType9').value=targetType();
	    toggleS();
   }

   if(document.URL.indexOf("si=1")>0){
	    toggleText('toggleTextOM','displayTextOM');
	    document.getElementById(getColId() + "1").style.color="#2874ae";
   }else if(document.URL.indexOf("si=2")>0){
	    toggleText('toggleTextIM','displayTextOM');
	    document.getElementById(getColId() + "2").style.color="#2874ae";
   }else if(document.URL.indexOf("si=3")>0){
	    toggleText('toggleTextE','displayTextEngagement');
	    document.getElementById(getColId() + "3").style.color="#2874ae";
   }else if(document.URL.indexOf("si=4")>0){
	    toggleText('toggleTextR','displayTextReach');
	    document.getElementById(getColId() + "4").style.color="#2874ae";
   }else if(document.URL.indexOf("si=5")>0){
	    toggleText('toggleTextL','displayTextLoyalty');
	    document.getElementById(getColId() + "5").style.color="#2874ae";
   }else if(document.URL.indexOf("si=6")>0){
	    toggleText('toggleTextD','displayTextDemographics');
	    document.getElementById(getColId() + "6").style.color="#2874ae";
   }else if(document.URL.indexOf("si=7")>0){
	    toggleText('toggleTextRet','displayTextRetention');
	    document.getElementById(getColId() + "7").style.color="#2874ae";
   }else if(document.URL.indexOf("si=8")>0){
	    toggleText('toggleTextIn','displayTextInfluence');
	    document.getElementById(getColId() + "8").style.color="#2874ae";
   }else if(document.URL.indexOf("si=9")>0){
	    toggleText('toggleTextS','displayTextSentiment');
	    document.getElementById(getColId() + "9").style.color="#2874ae";
	    //document.getElementById(getColId() + "9").href="#toggleTextS";
   }   

   if(getColId() != null){
   	  document.getElementById(getColId()).style.color="#2874ae";
   }
   
   function targetType(){
   	if(document.URL.indexOf("targettype=A")>0){
   		return "A";
   	}else if(document.URL.indexOf("targettype=VA")>0){
   	    return "VA";
   	}else{
   	    return "M";
   	}
   }
   
   function getColId(){
   	if(document.URL.indexOf("col=yv")>0){
   		return "yv";
   	}else if(document.URL.indexOf("col=cv")>0){
   	    return "cv";
   	}else if(document.URL.indexOf("col=yt")>0){
   	    return "yt";
   	}else if(document.URL.indexOf("col=pi")>0){
   	    return "pi";
   	}
   }