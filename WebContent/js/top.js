/**
 * author: tapasb
 */

function showScoreTooltip(respectTo, whatToShow) {
	document.getElementById(whatToShow).style.display = "block";
	document.getElementById(whatToShow).style.top = jQuery(respectTo).offset().top - 15;
	document.getElementById(whatToShow).style.left = jQuery(respectTo).offset().left + 20;
}

var timeout	= 500;
var closetimer = 0;
var actionDiv = 0;

function showUserList() {
	var mainListItem = document.getElementById("filter:LIST");
	var submMenu = document.getElementById("submenu");
	
	submMenu.style.display = "block";
	submMenu.style.top = jQuery(mainListItem).offset().top - 6 + "px";
	submMenu.style.left = jQuery(mainListItem).offset().left + 206 + "px";
}

function showActionPopup(id) {	
	cancelCloseTime();

	if(actionDiv) actionDiv.style.display = "none";

	var twitterActions = "#twitterActions_" + id;
	var twitterOptActions = "twitterOptActions_" + id;
	actionDiv = document.getElementById(twitterOptActions);
	actionDiv.style.display = "block";			
	actionDiv.style.top = jQuery(twitterActions).offset().top + 25;
	actionDiv.style.left = jQuery(twitterActions).offset().left - 70;

}

function closeActionPopup() {
	if(actionDiv) actionDiv.style.display = "none";
}

function closeActionPopupTime() {
	closetimer = window.setTimeout(closeActionPopup, timeout);
}

function cancelCloseTime() {
	if(closetimer) {
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}

function toggleCheckBox(imgObj, _hidden, _listId, val) {
	
	var hidden = document.getElementById(_hidden);
	var listId = document.getElementById(_listId);

	var value = jQuery(hidden).attr("value");
	if(value == "false") {
		jQuery(hidden).attr("value", "true");
		jQuery(listId).attr("value", val);
	} else if(value == "true") {
		jQuery(hidden).attr("value", "false");
		jQuery(listId).attr("value", null);
	}
	
	var src = jQuery(imgObj).attr("src");
	if(src == "../images/checkboxOrange.gif") {
		jQuery(imgObj).attr("src", "../images/checkboxOrangeSelect.gif");
	} else if(src == "../images/checkboxOrangeSelect.gif") {
		jQuery(imgObj).attr("src", "../images/checkboxOrange.gif");	
	} 
}

var mouseXDown = 0;
var mouseYDown = 0;
function getMousePositionOnSelectionOnMouseDown(event) {
	var point = getMousePosition(event);
	
	mouseXDown = point.X;
	mouseYDown = point.Y;
}

var mouseXUp = 0;
var mouseYUp = 0;
function getMousePositionOnSelectionOnMouseUp(event) {
	var point = getMousePosition(event);
	
	mouseXUp = point.X;
	mouseYUp = point.Y;
}

function getMousePosition(event) {
	var IE = document.all ? true : false;
	if (IE) { 
		x = event.clientX + document.body.scrollLeft;
		y = event.clientY + document.body.scrollTop;
	} else { 
		x = event.pageX;
		y = event.pageY;
	}  
	
	if (x < 0){
		x = 0;
	}
	if (y < 0){
		y = 0;
	}
	
	return {X:x, Y:y};
}

function displayCountdetailsRTODivOn(id, side, image) {	
	if(document.getElementById('countdetailsRTO' + side + id).style.display == 'block') {
		document.getElementById('countdetailsRTO' + side + id).style.display == 'none';
	}
	
	if (window.getSelection) {
		var str = window.getSelection();
	} else if (window.selection && window.selection.createRange) {
		var range = window.selection.createRange();
	    var str = range.text;
	} else if (document.getSelection) {
	    var str = document.getSelection();
	} else if (document.selection && document.selection.createRange) {
	    var range = document.selection.createRange();
	    var str = range.text;
	} else {
	    var str = "Sorry, this is not possible with your browser.";
	}
	
	if(isBlankString(str)) {
		mouseXDown = 0;
		mouseYDown = 0;
		mouseXUp = 0;
		mouseYUp = 0;
		return;
	}
	
	document.getElementById('populateTokenText').value = str;
	document.getElementById('populateTokenId').value = id;
	  
	if(document.getElementById('populateTokenText').value.length > 0) {			
		document.getElementById('countDetailsTextRTO' + side + id).innerHTML = '';
		  		  
		var posLeft = 0;
		
		if(mouseXDown > mouseXUp) {
			posLeft = mouseXUp + ((mouseXDown - mouseXUp) / 2);
		} else {
			posLeft = mouseXDown + ((mouseXUp - mouseXDown) / 2);
		}
		
		var posTop = mouseYDown - 65;

		document.getElementById('countdetailsRTO' + side + id).style.left = posLeft - 60 + 'px';
		document.getElementById('countdetailsRTO' + side + id).style.top = posTop + 'px';
		document.getElementById('countdetailsRTO' + side + id).style.zIndex = 1000;
		document.getElementById('countdetailsRTO' + side + id).style.display = 'block';
			
		rtopSuggestionTextForCountdetailsRTODiv(str, ('countDetailsTextRTO' + side + id), ('countDetailsLoaderRTO' + side + id), ('countdetailsRTO' + side + 'ImgDiv' + id), ('countdetailsRTO' + side + 'Img' + id), image);							
	}
	  
	document.getElementById('twtTxtSelected' + side + '_' + id).value = str;
	
	mouseXDown = 0;
	mouseYDown = 0;
	mouseXUp = 0;
	mouseYUp = 0;
}

function displayCountdetailsRTODivOff(id, side){
	document.getElementById('countDetailsTextRTO' + side + id).innerHTML = '';
	document.getElementById('countdetailsRTO' + side + id).style.display = 'none';
	document.getElementById('countdetailsRTO' + side + 'ImgDiv' + id).style.display = 'none';
	document.getElementById('countdetailsRTO' + side + 'Img' + id).style.display = 'none';
}

function rtopSuggestionTextForCountdetailsRTODiv(textToSearch, countDetailsTextRTOL, countDetailsLoaderRTOL, countdetailsRTOLImgDiv, countdetailsRTOLImg, image) {
	var url = getRtopURL("profile/1/text");
	var query = "" + textToSearch;
	var all = "" + textToSearch;
	document.getElementById(countDetailsLoaderRTOL).style.display = 'block';
	if (query.length > 0) {
		fetchText(url, query, all, function(data) {			
			for (var ix in data.query) {				
				if(isNaN(ix)) {
					document.getElementById(countDetailsLoaderRTOL).style.display = 'none';
					document.getElementById(countDetailsTextRTOL).innerHTML = "0 instances";
					document.getElementById(countdetailsRTOLImgDiv).style.display = 'block';
	                document.getElementById(countdetailsRTOLImg).style.display = 'block';
	        		document.getElementById(countdetailsRTOLImg).src = image;
					break;
	            }
            	var each = data.query[ix];
                var sname = each.name;
                
                document.getElementById(countDetailsLoaderRTOL).style.display = 'none';
                document.getElementById(countdetailsRTOLImgDiv).style.display = 'block';
                document.getElementById(countdetailsRTOLImg).style.display = 'block';
        		document.getElementById(countdetailsRTOLImg).src = image;
                document.getElementById(countDetailsTextRTOL).innerHTML = Math.abs(each.count) + " instances";
                
                break;                
			}
		});		
	} else {
		document.getElementById(countDetailsLoaderDiv).style.display = 'none';        
	}
}

function isBlankString(str) {
    return (!str || /^\s*$/.test(str));
}


var ctrlKey = 17;

function detectSystem() {
	var os = "Unknown OS";
	if (navigator.appVersion.indexOf("Win") != -1) os = "Windows";
	if (navigator.appVersion.indexOf("Mac") != -1) os = "MacOS";
	if (navigator.appVersion.indexOf("X11") != -1) os = "UNIX";
	if (navigator.appVersion.indexOf("Linux") != -1) os = "Linux";				
	
	var brower = "Unknown Browser";
	if(navigator.userAgent.indexOf("Opera") != -1) brower = "Opera";
	if(navigator.userAgent.indexOf("MSIE") != -1) brower = "IE";
	if(navigator.userAgent.indexOf("Chrome") != -1) brower = "Chrome";
	if(navigator.userAgent.indexOf("Safari") != -1) brower = "Safari";
	if(navigator.userAgent.indexOf("Firefox") != -1) brower = "Firefox";
	
	return {OS:os, Browser:brower};
}

jQuery(document).ready(function() {
	var system = detectSystem();
	if(system.OS == "MacOS" && system.Browser == "Safari") {
		ctrlKey = 91;
	} else if (system.OS == "MacOS" && system.Browser == "Firefox") {
		ctrlKey = 224;
	} else {
		ctrlKey = 17;
	}	
});
 
var ctrlDown = false;
var cKey = 67, vKey = 86, xKey = 88, yKey = 89, zKey = 90;

jQuery(document).keydown(function(e) {	
		if (e.keyCode == ctrlKey) {
			ctrlDown = true;
		}
}).keyup(function(e) {
        if (e.keyCode == ctrlKey) {
        	ctrlDown = false;
        }
});

// Original method is createDynamicStyle
// ref: DMToReturn.jsp
// ref: realTimeOptimizationDataLeft.jsp
// ref: realTimeOptimizationDataRight.jsp
// ref: RTThanks.jsp
function createDynamicStyling(e) {
	var unicode = e.keyCode?e.keyCode:e.which;
	
	var charKey;
	charKey = String.fromCharCode(e.keyCode);
	
	if(unicode != 16) { 
		if(e.shiftKey) { 			
			if(unicode >= 49 && unicode <= 57) {
				unicode = unicode - 16;				
			}						
			
			if(unicode == 48) {
				unicode = 41;
			}
			
			charKey = String.fromCharCode(unicode);			
		}
		else { 
			charKey = charKey.toLowerCase(charKey);
		}
	}
	
	if((unicode >=16 && unicode <=20) || unicode == 27 || unicode == 8 || unicode == 13 || (unicode >=32 && unicode <=47) 
			|| (unicode >=91 && unicode <=93) || (unicode >=91 && unicode <=93) || (unicode >=96 && unicode <=109) 
			|| (unicode >=111 && unicode <=123) || (unicode >=144 && unicode <=145) || (unicode >=186 && unicode <=192) 
			|| (unicode >=219 && unicode <=222)) {
		
		return false;
	} else if (unicode == ctrlKey){
		return false;
	} else if (ctrlDown && (unicode == cKey|| unicode == vKey || unicode == xKey || unicode == yKey || unicode == zKey))  {
		return true;
	} else {		
		insertHtmlAtTheCursor(charKey);
	
		if (window.event) {// IE	
			window.event.keyCode = 0;
			window.event.returnValue = null;
		} else {// Firefox
			e.preventDefault();
		}
	}		
}

//Original method is insertHtmlAtCursor
function insertHtmlAtTheCursor(ch) {	
	var range, node;
	if (window.getSelection && window.getSelection().getRangeAt) {
		var sel = window.getSelection();
		range = sel.getRangeAt(0);
		range.deleteContents();
		var textNode = createFontNode(ch);
		range.insertNode(textNode);

		// Move caret to the end of the newly inserted text node
		
		range.setStart(textNode, 1);
		range.setEnd(textNode, 1);

		sel.removeAllRanges();
		sel.addRange(range);
		
	} else if (document.selection && document.selection.createRange) {
		document.selection.createRange().pasteHTML("<font color=\"#707379\">" + ch + "</font>");
	}
}

//Original method is createNode
function createFontNode(ch) {
	var newFont = document.createElement('font')
	newFont.innerHTML = ch;
	newFont.color = "#707379";
	return newFont;
}

function checkKey(e, obj) {
	if (ctrlDown && (e.keyCode == vKey || e.keyCode == cKey)) {
		event = document.createEvent("KeyboardEvent");
		event.initKeyEvent("paste", true, true, null, false, false, false, false, 9, 0);              
                 obj.dispatchEvent(event);   
	}
}


function cssClassesProvider(day, minDate, maxDate) {
	var _minDate = new Date(minDate);
	var _maxDate = new Date(maxDate);
	
	if(day.date >= _minDate && day.date <= _maxDate) {		
		return 'clickable';
	} else {
		return 'rf-cal-boundary-day';
	}	
}

function clickabilityProvider(day, minDate, maxDate) {
	var _minDate = new Date(minDate);
	var _maxDate = new Date(maxDate);
	
	if(day.date >= _minDate && day.date <= _maxDate) {		
		return true;
	} else {
		return false;
	}	
}

function setResetDate(id, date) {
	document.getElementById('templatedatetwitterForm:benchmarkEndDateInputDate').value = date;
}

function showTitle(element, divId, x, y, title) {	
	var actionTitleDiv = document.getElementById(divId);
	actionTitleDiv.style.display = 'block';	 
	actionTitleDiv.style.left = findPosX(element) - x + "px";
	actionTitleDiv.style.top = findPosY(element) - y + "px";	
	document.getElementById('actionTitleText').innerHTML = title;
}

function hideTitle(divId) {
	document.getElementById(divId).style.display = 'none';
}

jQuery(document).bind("scroll", function() {
	if (jQuery('#WhatHappenDropDiv').is(':visible')) {
		jQuery('#WhatHappenDrop').hide();
		jQuery('#WhatHappenDropDiv').hide();				
	}
	
	if(jQuery('.countDetailsDivRTO').is(':visible')) {
		jQuery('.countDetailsDivRTO').hide();
	}
});		

jQuery('#mainRTOBodyBottomLower').bind("scroll", function() {
	if (jQuery('#WhatHappenDropDiv').is(':visible')) {
		jQuery('#WhatHappenDrop').hide();
		jQuery('#WhatHappenDropDiv').hide();				
	}
	if(jQuery('.countDetailsDivRTO').is(':visible')) {
		jQuery('.countDetailsDivRTO').hide();
	}
});

jQuery(document).bind("click", function() {
	if (jQuery('#WhatHappenDropDiv').is(':visible')) {
		jQuery('#WhatHappenDrop').hide();
		jQuery('#WhatHappenDropDiv').hide();				
	}	
});		
jQuery('#mainRTOBodyBottomLower').bind("click", function() {
	if (jQuery('#WhatHappenDropDiv').is(':visible')) {
		jQuery('#WhatHappenDrop').hide();
		jQuery('#WhatHappenDropDiv').hide();				
	}	
});