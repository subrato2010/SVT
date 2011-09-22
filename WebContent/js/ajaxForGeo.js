	function setLongLatitude(){
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(getPosition);
		} 
	}
	
	function getPosition(position) {
		var geoLoc = position.coords.latitude + ", " + position.coords.longitude;
		var ele = document.getElementById('geolocationForm:geoposition');
		if(ele.value == '' || ele.value == null)
			ele.value = geoLoc;
		else
			makeLocationVisible();
	}
	
	function makeLocationVisible() {
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
	
	function searchGeoLocation() {
		 if (navigator.geolocation) {
			  navigator.geolocation.getCurrentPosition(showPosition);
		 }
	 }
		
	 function showPosition(position) {
		var geoLoc = position.coords.latitude + ", " + position.coords.longitude;
	 }
	  
	 function checkGEO() 
	 {
	 	flag = false;
	 	if (!(navigator.geolocation)) {
	 		alert("Sorry, your browser does not support geolocation services.");
	 		flag = false;
	 	}  else	 	{
	 		flag = true;
	 	}	
	 	return flag;
	 }
	 
