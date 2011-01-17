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
	}
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
	/*
	function sSelect()
	{
	    var myselect=document.getElementById("addToListAlert:sel");
	    for (var i=0; i &lt; myselect.options.length; i++)
	    {
	        if (myselect.options[i].selected == true){
	            document.getElementById("vk").value = myselect.options[i].text;
	            break;
	        }
	    }	
	}*/
	function selectedItem(listObjectname, inputObjectname, selectedValue)
	{
	     var myselect=document.getElementById(listObjectname);
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
	    for (var i=0; i < myselect.options.length; i++)
	    {
	        if (myselect.options[i].selected == true){
	            document.getElementById(inputObjectname).value = myselect.options[i].text;
	            break;
	        }
	    }
	}
