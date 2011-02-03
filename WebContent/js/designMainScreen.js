function toggleOM() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
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
function toggleIM() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextIM");
	var text = document.getElementById("displayTextIM");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 
function toggleE() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextE");
	var text = document.getElementById("displayTextE");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 

function toggleR() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextR");
	var text = document.getElementById("displayTextR");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 
function toggleL() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextL");
	var text = document.getElementById("displayTextL");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 
function toggleD() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextD");
	var text = document.getElementById("displayTextD");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 
function toggleRet() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextRet");
	var text = document.getElementById("displayTextRet");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 
function toggleIn() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextIn");
	var text = document.getElementById("displayTextIn");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 

function toggleS() {
	// use toggleText(divToExpand, clickedtext) instead of this non-standard function
	var ele = document.getElementById("toggleTextS");
	var text = document.getElementById("displayTextS");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		//image.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		//text.innerHTML = "hide";
	}
} 

function toggleTextListBox(divToExpand, clickedtext) {
	var ele = document.getElementById(divToExpand);
	var text = document.getElementById(clickedtext);
	if(ele.style.display == "block") {
    		ele.style.display = "none";
    		text.style.color="#8B8B8B";
  	}
	else {
		ele.style.display = "block";
		text.style.color="#2874ae";
	}
}

function toggleText(divToExpand, clickedtext) {
	var ele = document.getElementById(divToExpand);
	var text = document.getElementById(clickedtext);
	if(ele.style.display == "block") {
    		ele.style.display = "none";
    		//text.style.color="#8B8B8B";
  	}
	else {
		ele.style.display = "block";
		text.style.color="#2874ae";
	}
}

function toggleTextGradeClick(divToExpand, clickedtext) {
	var ele = document.getElementById(divToExpand);
	var text = document.getElementById(clickedtext);
	if(ele.style.display == "block") {
    		ele.style.display = "none";
    		text.style.color="#8B8B8B";
  	}
	else {
		ele.style.display = "block";
		text.style.color="#2874ae";
	}
}

function toggleMouseOver(divToExpand, clickedtext) {
	var ele = document.getElementById(divToExpand);
	var text = document.getElementById(clickedtext);
	if(ele.style.display == "block"){ // means it is in open state
		if(rgbConvert(text.style.color)=="#2874ae"){
		}		
	}else{ // means it is in close state
		if(rgbConvert(text.style.color)=="#8b8b8b" || text.style.color == ""){
			text.style.color="#2874ae"; // blue mouseover
		}else{
			text.style.color="#8B8B8B"; // Gray mouseout
		}
	}
}

function rgbConvert(str) {
   str = str.replace(/rgb\(|\)/g, "").split(",");
   str[0] = parseInt(str[0], 10).toString(16).toLowerCase();
   str[1] = parseInt(str[1], 10).toString(16).toLowerCase();
   str[2] = parseInt(str[2], 10).toString(16).toLowerCase();
   str[0] = (str[0].length == 1) ? '0' + str[0] : str[0];
   str[1] = (str[1].length == 1) ? '0' + str[1] : str[1];
   str[2] = (str[2].length == 1) ? '0' + str[2] : str[2];
   return ('#' + str.join(""));
}