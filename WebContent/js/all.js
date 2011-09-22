function toggleOM() {
	var ele = document.getElementById("toggleTextOM");
	var text = document.getElementById("displayTextOM");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 
function toggleTextGEOLoc() {
	var ele = document.getElementById("toggleTextGEO");
	var text = document.getElementById("displayTextGEO");
			ele.style.display = "block";
			ele.style.color = "white";
			 document.getElementById('displayTextGEO').style.color='#ffffff'; 
			 document.getElementById('displayTextGEOOFF').style.color='#8B8B8B'; 
			 document.getElementById('toggleTextGEO').style.backgroundImage='url(../images/addYourLocationText.gif)';
	}
function toggleTextGEOGET() {
	var ele = document.getElementById("toggleTextGEOGET");
	var text = document.getElementById("displayTextGEOGET");
			ele.style.display = "block";
			ele.style.color = "white";
	}
function toggleTextGEOOFF() {
	var ele = document.getElementById("toggleTextGEO");
	var text = document.getElementById("displayTextGEO");
	document.getElementById('TGTOTAL1').style.display='none';
	document.getElementById('TGTOTAL').style.display='block';
			ele.style.display = "none";
			document.getElementById('displayTextGEOOFF').style.color='#ffffff'; 
			document.getElementById('displayTextGEO').style.color='#8B8B8B'; 
			//document.getElementById('toggleTextGEO').style.backgroundImage='url(../images/addYourLocationText.gif)';
	}
function toggleTextGEOOFF1() {
	var ele1 = document.getElementById("toggleTextGEO");
	var text = document.getElementById("displayTextGEO");
			ele1.style.display = "block";
			document.getElementById('displayTextGEOOFF').style.color='#ffffff'; 
			document.getElementById('displayTextGEO').style.color='#8B8B8B'; 
			//document.getElementById('toggleTextGEO').style.backgroundImage='url(../images/addYourLocationText.gif)';
	}

function toggleTextGEO() {
	var ele = document.getElementById("toggleTextGEO");
	var text = document.getElementById("displayTextGEO");
			ele.style.display = "block";
			ele.style.width="320";
			ele.style.height="17";
			document.getElementById('displayTextGEO').style.color='#ffffff'; 
			document.getElementById('displayTextGEOOFF').style.color='#8B8B8B'; 
	}
function toggleTextGEOW() {
	var ele = document.getElementById("TGTOTAL1");
	var ele1 = document.getElementById("TGTOTAL");
	var text = document.getElementById("displayTextGEO");
			ele.style.display = "block";
			ele1.style.display= "none";
			ele.style.width="320";
			ele.style.height="17";
			document.getElementById('displayTextGEO').style.color='#ffffff'; 
			document.getElementById('displayTextGEOOFF').style.color='#8B8B8B'; 
	}
function openRTO() {
	var ele = document.getElementById("toggleTextRTO");
	var text = document.getElementById("displayTextRTO");
	ele.style.display = "block";
} 
function toggleRTO() {
	var ele = document.getElementById("toggleTextRTO");
	var text = document.getElementById("displayTextRTO");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 

function newToggleRTO() {
	var ele = document.getElementById("toggleTextRTO");
	var text = document.getElementById("displayTextRTO");
	
	ele.style.display = "block";
} 

function toggleRTO1() {
	var ele = document.getElementById("toggleTextRTO");
	var text = document.getElementById("displayTextRTO");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
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
var insideList = false;
function setInList(b){
	insideList = b;
	//alert("hi1") ;
}

function closeList(x){
	if(!insideList)
	{
		var list = document.getElementById("list_"+x);

		if(list != null)
			list.style.display = "none";
		if(document.getElementById("submenu") != null){
			document.getElementById("submenu").style.display="none";
		}
	}
}
function change()
{
	preloaderDiv();
	var flag = true;
	var pageHeight = document.getElementById('pageT').offsetHeight
	//alert(pageHeight);
	document.getElementById('transParentDocDiv').style.height=parseInt(pageHeight)+'px';
	document.getElementById('transParentDocDiv').style.display='block';
	//alert("I am inside....");
	return true;
}	
function toggleList(x)
{
	//alert(x) ;
	var list = document.getElementById("list_"+x);
	var main = document.getElementById("main_"+x);
	if(list.style.display == "block")
	{
		list.style.display = "none";
	}
	else
	{
		var x = findPosX(main);
		var y = findPosY(main);
		
		//alert("x= " + x + "  y=" + y) ;
		
		list.style.left = x + 1;
		list.style.top = y+ 31;
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
	
	//function sSelect()
	//{
	   // var myselect=document.getElementById("addToListAlert:sel");
	   // for (var i=0; i &lt; myselect.options.length; i++)
	    //{
	      //  if (myselect.options[i].selected == true){
	          //  document.getElementById("vk").value = myselect.options[i].text;
	          //  break;
	       // }
	    //}	
	//}
	function selectedItem(listObjectname, inputObjectname, selectedValue)
	{
	     var myselect=document.getElementById(listObjectname);
	     if(myselect == null){
	    	 return;
	     }
	    for (var i=0; i < myselect.options.length; i++)
	    {
	        if (myselect.options[i].selected == true){
	            document.getElementById(inputObjectname).value = myselect.options[i].text;
	            break;
	        }
	    }
	}
	function selectedBrand(listObjectname, inputObjectname, selectedValue)
	{
	     var myselect=document.getElementById(listObjectname);
	     if(myselect == null){
	    	 return;
	     }
	    for (var i=0; i < myselect.options.length; i++)
	    {
	        if (myselect.options[i].selected == true){
	            document.getElementById(inputObjectname).value = myselect.options[i].text;
	            break;
	        }
	    }
	}
	
	function checkSelectImage(imagePath)
	{
		//alert(imagePath);
		var checkOrange='checkboxOrange.gif';
		var checkOrangeSelect='checkboxOrangeSelect.gif';
		var spl=imagePath.split('images/');
		if(spl[1]==checkOrange)
		{
			//alert("selected");
			document.getElementById('ckeckboxOrange').src=spl[0]+'images/'+checkOrangeSelect;
		}
		else if(spl[1]==checkOrangeSelect)
		{
			//alert("default");
			document.getElementById('ckeckboxOrange').src=spl[0]+'images/'+checkOrange;
		}
		
	}
	
	function preloaderDiv()
	{
		var img =  document.getElementById('preloader');
		var myWidth = 0, myHeight = 0;
		if( typeof( window.innerWidth ) == 'number' )
		{
			//Non-IE
			myWidth = window.innerWidth;
			myHeight = window.innerHeight;
		}
		else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) )
		{
			//IE 6+ in 'standards compliant mode'
			myWidth = document.documentElement.clientWidth;
			myHeight = document.documentElement.clientHeight;
		}
		else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) )
		{
			//IE 4 compatible
			myWidth = document.body.clientWidth;
			myHeight = document.body.clientHeight;
		}
		  
		myWidth = (myWidth/2) - (img.width/2);
		myHeight = (myHeight/2) - (img.height/2);
		
		document.getElementById('loader').style.display="block";
		
		//img.style.position="fixed";
		
		img.style.left = myWidth+"px";
		img.style.top = myHeight+"px";
	}
	
	function getElementPosition()
	{
		var offsetTrail = document.getElementById('Filter13');
		var offsetLeft = 0;
		var offsetTop = 0;
		while (offsetTrail)
		{
			//offsetLeft += offsetTrail.offsetLeft;
			offsetTop += offsetTrail.offsetTop;
			offsetTrail = offsetTrail.offsetParent;
		}
		if (navigator.userAgent.indexOf('Mac') != -1 && typeof document.body.leftMargin != 'undefined')
		{
			//offsetLeft += document.body.leftMargin;
			offsetTop += document.body.topMargin;
		}
		document.getElementById('submenu').style.top = offsetTop;		
		
	}
	
	//for blocking the blank space during twitter account entry (NEEL)
	function checkKeycode(e) {
		var keycode;
		if (window.event) 
			keycode = window.event.keyCode;
		else if (e) 
			keycode = e.which;
		if(keycode == '32')
			return false;
		return true;
	}
	
	//********** Influence New Popup releated ***************
	
	function ButtonPrev()
	{
		document.getElementById('influPrevButton').style.backgroundColor='#ffffff'; 
		document.getElementById('influPrevButton').style.borderTop='0';
		document.getElementById('influGeneralButton1').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton1').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton2').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton2').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton3').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton3').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton4').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton4').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton5').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton5').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influNextButton').style.backgroundColor='#FBFBFB';
		document.getElementById('influNextButton').style.borderTop='1px solid #DEDEDE';
	}
	function Button1()
	{
		document.getElementById('influGeneralButton1').style.backgroundColor='#ffffff'; 
		document.getElementById('influGeneralButton1').style.borderTop='0';
		document.getElementById('influGeneralButton2').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton2').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton3').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton3').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton4').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton4').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton5').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton5').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influPrevButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influNextButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influNextButton').style.borderTop='1px solid #DEDEDE';
	}
	function Button2()
	{
		document.getElementById('influGeneralButton2').style.backgroundColor='#ffffff'; 
		document.getElementById('influGeneralButton2').style.borderTop='0';
		document.getElementById('influGeneralButton1').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton1').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton3').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton3').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton4').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton4').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton5').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton5').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influPrevButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influNextButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influNextButton').style.borderTop='1px solid #DEDEDE';
	}
	function Button3()
	{
		document.getElementById('influGeneralButton3').style.backgroundColor='#ffffff'; 
		document.getElementById('influGeneralButton3').style.borderTop='0';
		document.getElementById('influGeneralButton1').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton1').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton2').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton2').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton4').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton4').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton5').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton5').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influPrevButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influNextButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influNextButton').style.borderTop='1px solid #DEDEDE';
	}
	function Button4()
	{
		document.getElementById('influGeneralButton4').style.backgroundColor='#ffffff'; 
		document.getElementById('influGeneralButton4').style.borderTop='0';
		document.getElementById('influGeneralButton1').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton1').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton3').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton3').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton2').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton2').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton5').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton5').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influPrevButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influNextButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influNextButton').style.borderTop='1px solid #DEDEDE';
	}
	function Button5()
	{
		document.getElementById('influGeneralButton5').style.backgroundColor='#ffffff'; 
		document.getElementById('influGeneralButton5').style.borderTop='0';
		document.getElementById('influGeneralButton1').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton1').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton3').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton3').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton4').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton4').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton2').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton2').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influPrevButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influNextButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influNextButton').style.borderTop='1px solid #DEDEDE';
	}
	function ButtonNext()
	{
		document.getElementById('influNextButton').style.backgroundColor='#ffffff'; 
		document.getElementById('influNextButton').style.borderTop='0';
		document.getElementById('influGeneralButton1').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton1').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton3').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton3').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton4').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton4').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton2').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton2').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influPrevButton').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influPrevButton').style.borderTop='1px solid #DEDEDE';
		document.getElementById('influGeneralButton5').style.backgroundColor='#FBFBFB'; 
		document.getElementById('influGeneralButton5').style.borderTop='1px solid #DEDEDE';
	}
	
function changeImage(objectId, imageName){
		if(objectId!=null && objectId.src!=null)
			objectId.src=imageName;
			}
function setSelectedBrand(listObjectname, inputObjectname, selectedValue)
	{
		 alert(inputObjectname);
	     var mySelect = document.getElementById(listObjectname).value;
	     var inputText = document.getElementById("editProfile:"+inputObjectname);
	     alert("mySelect : "+mySelect);
	     inputText.value = mySelect;
	     alert("inputText : "+inputText.value);
	}
	
	function openList(id)
	{
		var divText = document.getElementById(id);
		if (divText.style.display == 'none')
		{
			divText.style.display = 'block';
		}
		else
		{
			divText.style.display = 'none';
		}
	}
	/*function closeList(id)
	{
		var divText = document.getElementById(id);
		divText.style.display = 'none';
	}*/
	
	function toggleListGraph(x)
	{
		var list = document.getElementById("list_"+x);
		var main = document.getElementById("main_"+x);
		if(list.style.display == "block")
		{
			list.style.display = "none";
		}
		else
		{
			list.style.left = 290;
			list.style.top = 50;
			list.style.display = "block";
		}
		
	}
	
	function selectRating(ele, id)
	{
		
		var val = ele.innerHTML;
		
		switch(val)
		{
			case '1': 
				document.getElementById('selectRating'+1+id).className = 'selectedRatingDiv';
				document.getElementById('selectRating'+2+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+3+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+4+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+5+id).className = 'selectRatingDiv';
				
				break;
				
			case '2': 
				document.getElementById('selectRating'+2+id).className = 'selectedRatingDiv';
				document.getElementById('selectRating'+1+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+3+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+4+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+5+id).className = 'selectRatingDiv';
				break;
				
			case '3': 
				document.getElementById('selectRating'+3+id).className = 'selectedRatingDiv';
				document.getElementById('selectRating'+2+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+1+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+4+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+5+id).className = 'selectRatingDiv';
				break;
				
			case '4': 
				document.getElementById('selectRating'+4+id).className = 'selectedRatingDiv';
				document.getElementById('selectRating'+2+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+3+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+1+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+5+id).className = 'selectRatingDiv';
				break;
				
			case '5': 
				document.getElementById('selectRating'+5+id).className = 'selectedRatingDiv';
				document.getElementById('selectRating'+2+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+3+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+4+id).className = 'selectRatingDiv';
				document.getElementById('selectRating'+1+id).className = 'selectRatingDiv';
				break;
				
			default:
				break;
		
		}
		
	}
	
	function closeRating(id)
	{
		document.getElementById('overallRating'+id).style.display='none';
		document.getElementById('ratingClose'+id).style.display='none';
	}
	
	function trendingGraphClose()
	{
		parent.document.getElementById('graphTwitterId').value=''; 
		parent.document.getElementById('graphDate').value=''; 
		document.getElementById('dashboardOverallDataForm:trendGraph:daily').style.color='#77C442'; 
		document.getElementById('dashboardOverallDataForm:trendGraph:weekly').style.color='#6E7177'; 
		document.getElementById('dashboardOverallDataForm:trendGraph:monthly').style.color='#6E7177';
		parent.document.getElementById('trendingDiv').style.display='none';
		parent.document.getElementById('transParentDiv').style.display='none';
		parent.document.getElementById('transParentDocDiv').style.display='none';
		
	}
	
	function changeNew()
	{
		var pageHeight=parseInt(getDocHeight());
		
		
		
		document.getElementById('transParentDocDiv').style.height="" + pageHeight + "px";
		document.getElementById('transParentDocDiv').style.display='block';

	}

	function getDocHeight() {
	    var D = document;
	    return Math.max(
	        Math.max(D.body.scrollHeight, D.documentElement.scrollHeight),
	        Math.max(D.body.offsetHeight, D.documentElement.offsetHeight),
	        Math.max(D.body.clientHeight, D.documentElement.clientHeight)
	    );
	}

	function getElementPosition(elemID)
	{
	 var offsetTrail = document.getElementById(elemID);
	 var offsetLeft = 0;
	 var offsetTop = 0;
	 while (offsetTrail)
	 {
	  offsetLeft += offsetTrail.offsetLeft;
	  offsetTop += offsetTrail.offsetTop;
	  offsetTrail = offsetTrail.offsetParent;
	 }
	 if (navigator.userAgent.indexOf('Mac') != -1 && typeof document.body.leftMargin != 'undefined')
	 {
	  offsetLeft += document.body.leftMargin;
	  offsetTop += document.body.topMargin;
	 }
	 return {offsetLeft:offsetLeft,offsetTop:offsetTop};
	}
	
	function closeFullScreen()
	{
		document.getElementById('ViewTweetDetails').style.display='none';
		document.getElementById('transParentDocDiv').style.display='none';
	}

