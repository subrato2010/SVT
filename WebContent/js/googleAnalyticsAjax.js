var xmlhttp
function GetXmlHttpObject()
{
    if (window.XMLHttpRequest)
    {
       return new XMLHttpRequest();
    }
    if (window.ActiveXObject)
    {
      return new ActiveXObject("Microsoft.XMLHTTP");
    }
 return null;
}
function callAjaxMethod()
{
	document.getElementById("result").innerHTML="";
	document.getElementById('selectOpt').innerHTML="";
	var val1=document.getElementById("param1").value;
	var val2=document.getElementById("param2").value;
	if(val1!='' && val2!='')
		getResult(val1,val2);
	return false;
}
function getResult(param1,param2)
{
	var myRand=parseInt(Math.random()*99999999);
	xmlhttp=GetXmlHttpObject();
	if (xmlhttp==null)
	{
		alert ("Your browser does not support Ajax HTTP");
		return;
	}
    var url="GDataController";  
    url=url+"?rand="+myRand+"&operation=operationName"+"&param1="+param1+"&param2="+param2+"&requestFrom=ajax"; 
    
    xmlhttp.onreadystatechange=getOutput;
    xmlhttp.open("POST",url,true);
    xmlhttp.send(null);
}
function getOutput()
{
  if (xmlhttp.readyState==4)
  {
	  var result=xmlhttp.responseText;
	  var resultArr = result.split("|");
	  
	  if(resultArr[0]=="TRUE"){
		 
	  	for(var i=1;i<resultArr.length;i++){
	  		document.getElementById('selectOpt').options[i-1]= new Option(resultArr[i],resultArr[i]);
	  	}	  
	  }else
	  {
	  	//alert(resultArr[1]);
	  }
  }
}