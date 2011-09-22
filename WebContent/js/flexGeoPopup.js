var globalObj;

function setURL() {}

function resizePopUpWindow(len) {
	document.getElementById('geoLocSWF').style.height=len;
	document.getElementById('flexEmbed').style.height=len;	
}

function setLocationNameToComponet(str) {
	var clickedObj = globalObj.id;
	if(clickedObj == 'getLocFromFlex')
		parent.document.getElementById('locForTweet').value = str; // use for tweet
	if(clickedObj == 'addReplyLocation')
		document.getElementById('locForTweet').value = str; // use for tweet
	globalObj.innerHTML = str;
	if(document.getElementById('geoPopUp') !=null)
		document.getElementById('geoPopUp').style.display='none'; 
	else
		parent.document.getElementById('geoPopUp').style.display='none';
	
	//used in reply.jsp(Started here)
		parent.document.getElementById('floatingDiv').style.height = 270;
		parent.document.getElementById('innerMainDiv').style.height = 250;
		parent.document.getElementById('frame').style.height = 200;
	//used in reply.jsp(Ended here)
}

function viewPopup(obj) {
	
	if(document.getElementById('geoPopUp') == null)
		parent.document.getElementById('geoPopUp').style.display='block';
	else
		document.getElementById('geoPopUp').style.display='block';
	
	if(document.getElementById('geoLocSWF') !=null) 
		document.getElementById('geoLocSWF').style.height=75;
	else
		parent.document.getElementById('geoLocSWF').style.height=75;
	
	if(document.getElementById('flexEmbed') !=null)
		document.getElementById('flexEmbed').style.height=75;
	else
		parent.document.getElementById('flexEmbed').style.height=75;
	
	globalObj = obj;
}