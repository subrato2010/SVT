function showSWF(id, swf, divName, width, height, flashvars){

	var swfVersionStr = "10.2.0";
	var xiSwfUrlStr = "playerProductInstall.swf";
	
	var params = {};
	params.quality = "high";
	params.wmode = "opaque";
	params.allowscriptaccess = "sameDomain";
	params.allowfullscreen = "true";
	var attributes = {};
	attributes.id = id;
	attributes.name = id;
	attributes.align = "middle";
	swfobject.embedSWF(
		swf, divName, 
		width, height, 
		swfVersionStr, xiSwfUrlStr, 
		flashvars, params, attributes);
		
}

var dashCount = 6;
var scoreCount = 4;
var currentScoreChartId = "os_0";


function setDashCount(count){
	dashCount = count;
}
function setScoreCount(count){
	scoreCount = count;
}
function setCurrentScoreChartId(id){
	currentScoreChartId = id;
}

function dashBoardClickHandler(str, flashNumber)
{	
	dashBoardHighlight(flashNumber, dashCount);
}
function scoreClickHandler(flashNumber)
{	
	scoreHighlight(flashNumber, scoreCount);
}

function dashBoardHighlight(iSentiment, count){
	
	for (var i=0; i< count; i++)
	{
		if(i == iSentiment){
			
			document.getElementById("dash_table_" + i).style.display = "block";
			document.getElementById("flashSpan_" + i).style.display = "block"
			document.getElementById("tr_" + i).style.backgroundColor = "#efeef3";
			document.getElementById("tr_" + i).style.border = "1px solid #e0e0e0";
		}else{
			
			document.getElementById("dash_table_" + i).style.display = "none";
			document.getElementById("flashSpan_" + i).style.display="none"	
			document.getElementById("tr_" + i).style.backgroundColor = "#FFFFFF";
			document.getElementById("tr_" + i).style.border = "0px solid #FFFFFF";
		}
	}
}

function scoreHighlight(iFlash, count){

	for (var i=0; i< count; i++)
	{
		if(i == iFlash){
			document.getElementById("bigFlashDiv_" + i).style.display = "block";
			document.getElementById("flashSpan_" + i).style.display = "block"
			setCurrentScoreChartId("os_"+i);
			document.getElementById("tr_"+i).style.backgroundColor = "#EFEEF3";
			document.getElementById("tr_" + i).style.border = "1px solid #e0e0e0";
		}else{
			document.getElementById("bigFlashDiv_" + i).style.display = "none";
			document.getElementById("flashSpan_" + i).style.display="none"	
			document.getElementById("tr_"+i).style.backgroundColor = "transparent";
			document.getElementById("tr_" + i).style.border = "0px solid transparent";
		}
	}
}


function outerClick(label){
	label = escape(label);
	window.location = "dashBoard.jsp?channelName=" + label;
}

function openDashboard(label){
	
	label = escape(label);
	var sentimentName = document.getElementById("sIntellegence:sentimentName").value;
	window.location = "dashBoard.jsp?channelName=" + label + "&sentimentName="+sentimentName;
}

function innerClick(label){
	window.location = label.toLowerCase()+ ".jsp";
}

function highlightMenu(index, channel)
{
	if(!(channel == "Overall Score" ))
	{ 
		
		var tableObj = document.getElementById("table_"+ index);
		tableObj.className = "menuheaderHL";
		
		var imgObj = document.getElementById("dot_" + index);
		var str  = imgObj.src.replace(".gif" , "h.gif");
		imgObj.src = str;
		
	    var swf = currentScoreChartId;
	    
	    var container;
	    //alert("appname = " + navigator.appName);
	    if (navigator.appName.indexOf("Microsoft") >= 0 || navigator.appName.indexOf("Netscape") >= 0)
	    {
	        container = document;
	    }
	    else
	    {
	        container = window;
	    }
	    
	   if(container.getElementById(swf) != null){
	    	
		   container.getElementById(swf).highLight(channel);
	    }
 
	}
}
function deHighlightMenu( index, channel)
{
	if(!(channel == "Overall Score" ))
	{ 
	
		var tableObj = document.getElementById("table_"+ index);
		tableObj.className = "menuheader";
		
		var imgObj = document.getElementById("dot_" + index);
		var str  = imgObj.src.replace("h.gif" , ".gif");
		imgObj.src = str;
		
		var swf = currentScoreChartId;
	    var container;
	    //alert(navigator.appName);
	    if (navigator.appName.indexOf("Microsoft") >= 0 || navigator.appName.indexOf("Netscape") >= 0)
	    {
	    	
	        container = document;
	    }
	    else
	    {
	        container = window;
	    }
	    if(container.getElementById(swf) != null){
	    	
	    	container.getElementById(swf).deHighLight(channel);
	    }
	}
}

function rollover(index){

	var tableObj = document.getElementById("table_"+ index);
	var imgObj = document.getElementById("dot_" + index);
	var className = tableObj.className;

	if(className.indexOf("menuheaderHL") >=0)
	{
		tableObj.className = "menuheader";
		var str  = imgObj.src.replace("h.gif" , ".gif");
		imgObj.src = str;
	}else{
		if(className.indexOf("menuheader") >= 0)
		{
			tableObj.className = "menuheaderHL";
			var str  = imgObj.src.replace(".gif" , "h.gif");
			imgObj.src = str;

		}
	}
}


var oldColor;
function dcMouseOver(td){
	oldColor = td.style.backgroundColor;
	td.style.backgroundColor = "#f8ffef";
}

function dcMouseOut(td){
	td.style.backgroundColor = oldColor;
}
function toggleList(x){
	//alert("hi") ;
	
	var list = document.getElementById("list_"+x);
	var main = document.getElementById("main_"+x);
	if(list.style.display == "block"){
		list.style.display = "none";
	}else{
		var x = findPosX(main);
		var y = findPosY(main);
		//alert("x= " + x + "  y=" + y) ;
		list.style.left = x;
		list.style.top = y+ 31;
		list.style.display = "block";
	}
	
	
}
function toggleList1(x){
	//alert("hi1") ;
	var list = document.getElementById("list_"+x);
	var main = document.getElementById("main_"+x);
	if(list.style.display == "block"){
		list.style.display = "none";
	}else{
		var x = findPosX(main);
		var y = findPosY(main);
		//alert("x= " + x + "  y=" + y) ;
		list.style.left = x-270;
		list.style.top = y-58;
		list.style.display = "block";
		
	}
	
}
function toggleList2(x){
	//alert("hi1") ;
	var list = document.getElementById("list_"+x);
	var main = document.getElementById("main_"+x);
	if(list.style.display == "block"){
		list.style.display = "none";
	}else{
		var x = findPosX(main);
		var y = findPosY(main);
		//alert("x= " + x + "  y=" + y) ;
		list.style.left = x-200;
		list.style.top = y-58;
		list.style.display = "block";
		
	}
	
}
function toggleList3(x){
	//alert("hi") ;
	var list = document.getElementById("list_"+x);
	var main = document.getElementById("main_"+x);
	if(list.style.display == "block"){
		list.style.display = "none";
	}else{
		var x = findPosX(main);
		var y = findPosY(main);
		//alert("x= " + x + "  y=" + y) ;
		list.style.left = x;
		list.style.top = y+ 3;
		list.style.display = "block";
	}
	
}
 function findPosX(obj)
  {
    var curleft = 0;
    if(obj.offsetParent)
        while(1) 
        {
          curleft += obj.offsetLeft;
          if(!obj.offsetParent)
            break;
          obj = obj.offsetParent;
        }
    else if(obj.x)
        curleft += obj.x;
    return curleft;
  }

  function findPosY(obj)
  {
    var curtop = 0;
    if(obj.offsetParent)
        while(1)
        {
          curtop += obj.offsetTop;
          if(!obj.offsetParent)
            break;
          obj = obj.offsetParent;
        }
    else if(obj.y)
        curtop += obj.y;
    return curtop;
  }
  
  
  /*PROFILE PHONE NO CHECKING*/
  

	function formatPhoneNo(phoneVal)
	 {
		if(phoneVal.length >= 10){
		   var arr=phoneVal.split('-');
		   var phnSplitter='';
		   var responsePhnNo='';
			for(i=0;i<arr.length;i++)
			{
			   phnSplitter=phnSplitter+arr[i];
				//alert(arr[i]);
			}
			//alert(phnSplitter.length);
			if(phnSplitter.length>=10)
			 {
				phnSplitter=phnSplitter.substring(0,10);
				//alert(phnSplitter);
				responsePhnNo=phnSplitter.substring(0,3)+'-'+phnSplitter.substring(3,6)+'-'+phnSplitter.substring(6,10);
			 }
			 document.getElementById('editProfile:phone').value=responsePhnNo;
		//alert(responsePhnNo);
		}
	 }

	
	
	
	function toggleList4(x){
		//alert("hi1") ;
		var list = document.getElementById("list_"+x);
		var main = document.getElementById("main_"+x);
		if(list.style.display == "block"){
			list.style.display = "none";
		}else{
			var x = findPosX(main);
			var y = findPosY(main);
			//alert("x= " + x + "  y=" + y) ;
			list.style.left = x-275;
			list.style.top = y-58;
			list.style.display = "block";
			
		}
		
	}
	
	
	function toggleList5(x){
		//alert("hi1") ;
		var list = document.getElementById("list_"+x);
		var main = document.getElementById("main_"+x);
		if(list.style.display == "block"){
			list.style.display = "none";
		}else{
			var x = findPosX(main);
			var y = findPosY(main);
			//alert("x= " + x + "  y=" + y) ;
			list.style.left = x-175;
			list.style.top = y-58;
			list.style.display = "block";
			
		}
		
	}
