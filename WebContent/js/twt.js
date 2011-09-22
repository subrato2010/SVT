var regexp = /((http.?:)\/\/([^.:\/\s]+)(((\.)([^.,\-:\/\s0-9]{2,}))+)((\/)[0-9\w#!:.?+=&%@!\-\/]*)*)/g	

function countTweetLimitChars(ele, cnt)
{
	
	if(cnt == 'none')
	{
		var countDiv = document.getElementById("tweetWords");
	}
	else
	{
		var countDiv = document.getElementById("tweetWords_"+cnt);
	}
	
	var msg = ele.value;
	
	msg = msg.replace(regexp, '12345678901234567890');
	
	var msgLength = msg.length;
	
	if(msgLength > 140)
	{
		countDiv.innerHTML = 140 - msgLength;
	}
	else
	{
		countDiv.innerHTML = msgLength + '/140';
	}
	
	if(msgLength > 140)
	{
		countDiv.className = 'tweet-counter-red';
		document.getElementById('composeEnabled_'+cnt).style.display = 'none';
		document.getElementById('composeDisabled_'+cnt).style.display = 'block';
	}
	else
	{
		countDiv.className = 'tweet-counter';
		document.getElementById('composeEnabled_'+cnt).style.display = 'block';
		document.getElementById('composeDisabled_'+cnt).style.display = 'none';
	}
	
}


function countReplyLimitChars()
{
	var countDiv = document.getElementById("tweetReply");
	var msg = document.getElementById('reply:sendReply').value;
	
	//var msgLength = document.getElementById('reply:sendReply').value.length;
	msg = msg.replace(regexp, '12345678901234567890');
	var msgLength = msg.length;
	
	if(msgLength > 140)
	{
		countDiv.innerHTML = 140 - msgLength;
	}
	else
	{
		countDiv.innerHTML = msgLength + '/140';
	}
	
	if(msgLength > 140)
	{
		countDiv.className = 'tweet-counter-red';
		document.getElementById('replyEnabled').style.display = 'none';
		document.getElementById('replyDisabled').style.display = 'block';
	}
	else
	{
		countDiv.className = 'tweet-counter';
		document.getElementById('replyEnabled').style.display = 'block';
		document.getElementById('replyDisabled').style.display = 'none';
	} 	
}

function countLimitChars(cnt)
{
	var countDiv = document.getElementById('numberofWord_'+cnt);
	var msg = document.getElementById('referenceName_'+cnt);
	var msgLength = 0;
	
	if(msg.textContent)
	{
		var msgtxt = msg.textContent.replace(regexp, '12345678901234567890');
		msgLength = msgtxt.length;
	}
	else
	{
		var msgtxt = msg.innerText.replace(regexp, '12345678901234567890');
		msgLength = msgtxt.length;
	}
	
	if(msgLength > 140)
	{
		countDiv.innerHTML = 140 - msgLength;
	}
	else
	{
		countDiv.innerHTML = msgLength + '/140';
	}
	
	if(msgLength > 140)
	{
		countDiv.className = 'one-fourty-red';
		document.getElementById('sendTweetEnabled_'+cnt).style.display = 'none';
		document.getElementById('sendTweetDisabled_'+cnt).style.display = 'block';
	}
	else
	{
		countDiv.className = 'one-fourty';
		document.getElementById('sendTweetEnabled_'+cnt).style.display = 'block';
		document.getElementById('sendTweetDisabled_'+cnt).style.display = 'none';
	}
	
}

function setData(cnt)
{
	var msg = document.getElementById('referenceName_'+cnt);
	
	if(msg.textContent)
	{
		document.getElementById('individualTweet_'+cnt).value = msg.textContent;
	}
	else
	{
		document.getElementById('individualTweet_'+cnt).value = msg.innerText;
	}
	
}

function createDynamicStyle(e)
{

	var unicode = e.keyCode?e.keyCode:e.which;
	
	var charKey;
	charKey = String.fromCharCode(e.keyCode);
	
	if(unicode != 16)
	{ 
		if(e.shiftKey)
		{ 
			
			if(unicode >= 49 && unicode <= 57)
			{
				unicode = unicode - 16;
				
			}						
			
			if(unicode == 48)
			{
				unicode = 41;
			}
			
			charKey = String.fromCharCode(unicode);
			
		}
		else
		{ 
			charKey = charKey.toLowerCase(charKey);
		}
	}
	
	if((unicode >=16 && unicode <=20) || unicode == 27 || unicode == 8 || unicode == 13 || (unicode >=32 && unicode <=47) 
	|| (unicode >=91 && unicode <=93) || (unicode >=91 && unicode <=93) || (unicode >=96 && unicode <=109) 
	|| (unicode >=111 && unicode <=123) || (unicode >=144 && unicode <=145) || (unicode >=186 && unicode <=192) 
	|| (unicode >=219 && unicode <=222))
	
	{
			return false;
	}
	
	else
	{
		
		insertHtmlAtCursor(charKey);
	
		if (window.event) //IE
		{
			window.event.keyCode = 0;
			window.event.returnValue = null;
		}
		else //Firefox
		{
			e.preventDefault();
		}
	}	
	
}


function insertHtmlAtCursor(ch)
{
	
	var range, node;
	if (window.getSelection && window.getSelection().getRangeAt)
	{
		var sel = window.getSelection();
		range = sel.getRangeAt(0);
		range.deleteContents();
		var textNode = createNode(ch);
		range.insertNode(textNode);

		// Move caret to the end of the newly inserted text node
		
		range.setStart(textNode, 1);
		range.setEnd(textNode, 1);

		sel.removeAllRanges();
		sel.addRange(range);
		
	}
	else if (document.selection && document.selection.createRange)
	{
		document.selection.createRange().pasteHTML("<font color=\"#707379\">" + ch + "</font>");
	}
}

function createNode(ch)
{
	var newFont = document.createElement('font')
	newFont.innerHTML = ch;
	newFont .color = "#707379";
	return newFont;
}

function resetText()
{
	var countDiv = document.getElementById("tweetWords");
	
	document.getElementById('happenning:tweetInput').value = '';
	countDiv.innerHTML = '0/140';
	countDiv.className = 'tweet-counter';
}

function display(id, side)
{
	  if (window.getSelection)
	  {
	    var str = window.getSelection();
	  }
	  else if (window.selection && window.selection.createRange)
	  {
	    var range = window.selection.createRange();
	    var str = range.text;
	  } 
	  else if (document.getSelection)
	  {
	    var str = document.getSelection();
	  }
	  else if (document.selection && document.selection.createRange)
	  {
	    var range = document.selection.createRange();
	    var str = range.text;
	  }
	  else
	  {
	    var str = "Sorry, this is not possible with your browser.";
	  }
	  	   
	  document.getElementById('populateTokenText').value = str;
	  document.getElementById('populateTokenId').value = id;
	  
	  if(document.getElementById('populateTokenText').value.length > 0)
	  {
		  document.getElementById('countDetailsText_'+id).innerHTML = '';
		  
		  var divPos = getElementPosition('referenceName_'+id);
		  var divScrollHeight = document.getElementById('mainRTOBodyBottomLower').scrollTop;
		  		  
		  var posLeft = divPos.offsetLeft;
		  var posTop = divPos.offsetTop - 40 - divScrollHeight;
		  
		  document.getElementById('countdetails_'+id).style.left = posLeft + 'px';
		  document.getElementById('countdetails_'+id).style.top = posTop + 'px';
		  
		  document.getElementById('countdetails_'+id).style.display = 'block';
		  document.getElementById('countDetailsLoader_'+id).style.display = 'block';
		  
		  //clickLink('twtText:populateTokenHidden');
		  rtopSuggestionText(str, ('countDetailsText_'+id), ('countDetailsLoader_'+id));
	  }
	  
	  document.getElementById('twtTxtSelected'+side+'_'+id).value = str
	  
}

function setCountData()
{
	var id = document.getElementById('populateTokenId').value;
	var countVal = document.getElementById('tokenCount').value;
	
	document.getElementById('countDetailsLoader_'+id).style.display = 'none';
	document.getElementById('countDetailsText_'+id).innerHTML = countVal + " instances";

}

function displayOff(id)
{
	document.getElementById('countDetailsText_'+id).innerHTML = '';
	document.getElementById('countdetails_'+id).style.display = 'none';
}

function showTwitterLogoToolTip(id)
{
	var browserVer = navigator.appName;
	
	if(browserVer == 'Microsoft Internet Explorer')
	{
		var topDivHeight = getElementPosition('toggleTextRTO').offsetTop; 
		var imgPos = getElementPosition('twitterLogo_'+id).offsetTop;
		var imgPosLeft = getElementPosition('twitterLogo_'+id).offsetLeft;
		
		imgPos = (imgPos - topDivHeight - 10);
		document.getElementById('twitterLogotextAreaTooltip_'+id).style.top = imgPos + 'px';
		document.getElementById('twitterLogotextAreaTooltip_'+id).style.left = imgPosLeft + 'px';
		document.getElementById('twitterLogotextAreaTooltip_'+id).style.display = 'block';	
	}
	else
	{
		var divScrollHeight = document.getElementById('mainRTOBodyBottomLower').scrollTop;
		var imgPos = getElementPosition('twitterLogo_'+id).offsetTop;
		
		imgPos = (imgPos - divScrollHeight);
		document.getElementById('twitterLogotextAreaTooltip_'+id).style.top = imgPos + 'px';
		document.getElementById('twitterLogotextAreaTooltip_'+id).style.display = 'block';
	}	
	
}

function hideTwitterLogoToolTip(id)
{
	document.getElementById('twitterLogotextAreaTooltip_'+id).style.display = 'none';
}


function showTwitterActions(id)
{
	var browserVer = navigator.appName;
	
	if(browserVer == 'Microsoft Internet Explorer')
	{
		var topDivHeight = getElementPosition('toggleTextRTO').offsetTop; 
		var imgPos = getElementPosition('twitterActions_'+id).offsetTop;
		var imgPosLeft = getElementPosition('twitterActions_'+id).offsetLeft;
		
		imgPos = (imgPos - topDivHeight + 14);
		document.getElementById('twitterOptActions_'+id).style.top = imgPos + 'px';
		document.getElementById('twitterOptActions_'+id).style.left = imgPosLeft + 'px';
		document.getElementById('twitterOptActions_'+id).style.display = 'block';	
	}
	else
	{
		var divScrollHeight = document.getElementById('mainRTOBodyBottomLower').scrollTop;
		var imgPos = getElementPosition('twitterActions_'+id).offsetTop;
		
		imgPos = (imgPos - divScrollHeight + 24);
		document.getElementById('twitterOptActions_'+id).style.top = imgPos + 'px';
		document.getElementById('twitterOptActions_'+id).style.display = 'block';
	}	
	
}

function hideTwitterActions(id)
{
	document.getElementById('twitterOptActions_'+id).style.display = 'none';
}



function getCursorXY(e)
{
	document.getElementById('cursorX').value = (window.Event) ? e.pageX : event.clientX + (document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft);
	document.getElementById('cursorY').value = (window.Event) ? e.pageY : event.clientY + (document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop);
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


function hideAll()
{
	jQuery("div.countDetailsDiv").hide();
	jQuery("div.countDetailsDivNew").hide();
	
}

function hideAllNew()
{
	jQuery("div.countDetailsDivNew").hide();
	if(currentICElement){
		currentICElement = null;
	}
}

function hideAllActions()
{
	jQuery("div.twitterOptActionsLeft").hide();
	jQuery("div.twitterOptActionsRight").hide();
}

function showSchedule(type)
{
	if(type == 'Manual')
	{
		document.getElementById('autoSchedule').style.display = 'none';
		document.getElementById('happeningRightTotal').className = 'happeningRightTotalManual';
		document.getElementById('manualSchedule').style.display = 'block';
		document.getElementById('scheduleType_none').value = 'M';
		
	}
	
	if(type == 'Auto')
	{
		document.getElementById('manualSchedule').style.display = 'none';
		document.getElementById('happeningRightTotal').className = 'happeningRightTotalManual';
		document.getElementById('autoSchedule').style.display = 'block';
		document.getElementById('scheduleType_none').value = 'A';
	}
	//alert(document.getElementById('scheduleType_none').value);
}

function showSchedules(type, id)
{
	if(type == 'Manual')
	{
		document.getElementById('autoSchedule_'+id).style.display = 'none';
		document.getElementById('happeningRightTotal_'+id).className = 'happeningRightTotalManual';
		document.getElementById('manualSchedule_'+id).style.display = 'block';
		document.getElementById('scheduleType_'+id).value = 'M';
		
	}
	
	if(type == 'Auto')
	{
		document.getElementById('manualSchedule_'+id).style.display = 'none';
		document.getElementById('happeningRightTotal_'+id).className = 'happeningRightTotalManual';
		document.getElementById('autoSchedule_'+id).style.display = 'block';
		document.getElementById('scheduleType_'+id).value = 'A';
	}
}

function setDateValue(id,ele)
{
	document.getElementById('rtopScheduleDate_'+id).value = ele.value;
	document.getElementById('happenning:calendarManualInputDate').value = ele.value;
}

function setTimeValue(id,ele)
{
	document.getElementById('rtopScheduleTime_'+id).value = ele.value;
	document.getElementById('happenning:manualTimeList').value = ele.value;
}


function setDateValues(id,ele)
{
	document.getElementById('rtopScheduleDate_'+id).value = ele.value;
	document.getElementById('happenning:scheduledTweetsRepeat:'+id+':calendarManualInputDate').value = ele.value;
}

function setTimeValues(id,ele)
{
	document.getElementById('rtopScheduleTime_'+id).value = ele.value;
	document.getElementById('happenning:scheduledTweetsRepeat:'+id+':manualTimeList').value = ele.value;
}



function setAutoDateValue(id,ele)
{
	document.getElementById('rtopScheduleDate_'+id).value = ele.value;
	document.getElementById('happenning:calendarAutoInputDate').value = ele.value;
}

function setAutoTimeValue(id,ele)
{
	document.getElementById('rtopScheduleTime_'+id).value = getTime12Hr(ele.value); //ele.value;
	document.getElementById('happenning:autoTimeList').value = getTime12Hr(ele.value); //ele.value;
}

function setAutoDateValues(id,ele)
{
	document.getElementById('rtopScheduleDate_'+id).value = ele.value;
	document.getElementById('happenning:scheduledTweetsRepeat:'+id+':calendarAutoInputDate').value = ele.value;
}

function setAutoTimeValues(id,ele)
{
	document.getElementById('rtopScheduleTime_'+id).value = ele.value;
	document.getElementById('happenning:scheduledTweetsRepeat:'+id+':autoTimeList').value = ele.value;
}

function callWhatsHappeningJS(){
	var txt = jQuery('#tweet');
	txt.attr("value", " ");
	doQueryDefault();
	document.getElementById('scheduleType_none').value = 'A';
}


function getInputSelection(input) {
    var start = 0, end = 0;
    input.focus();
    if (    typeof input.selectionStart == "number" &&
            typeof input.selectionEnd == "number") {

        start = input.selectionStart;
        end = input.selectionEnd;
    } else if (document.selection && document.selection.createRange) {
        var range = document.selection.createRange();
        if (range) {
            var inputRange = input.createTextRange();
            var workingRange = inputRange.duplicate();
            var bookmark = range.getBookmark();
            inputRange.moveToBookmark(bookmark);
            workingRange.setEndPoint("EndToEnd", inputRange);
            end = workingRange.text.length;
            workingRange.setEndPoint("EndToStart", inputRange);
            start = workingRange.text.length;
        }
    }
    return {
        start: start,
        end: end,
        len: end - start
    };
}

function checkChar(evt, ele, cnt)
{
    evt = evt || window.event;
	//var eleId = document.getElementById('happenning:tweetInput');
    
    var eleId = ele.id;
    var keyCode = evt.keyCode;
	var spaceKey = (keyCode == 32);
    var deleteKey = (keyCode == 46);
	var backspaceKey = (keyCode == 8);
    var sel, deletedText, val;
    
	if(spaceKey)
	{
		var ch = ele.value;
		
		if(cnt == 'none')
		{
			document.getElementById('textSelectedForGrade').value = ch;
		}
		else
		{
			document.getElementById('textSelectedForGrade_'+cnt).value = ch;
		}
		
		var spacePos = doGetCaretPosition(ele);
		var newStr = ele.value.substring(0,spacePos);
		var lastIndexOfSpace = newStr.lastIndexOf(' ');
		var totalLen = ch.length;

		newStr = newStr.substring(lastIndexOfSpace, totalLen);

		if(newStr != ' ')
		{
			if(cnt == 'none')
			{
				document.getElementById('textSelected').value = newStr;
				document.getElementById('whatsHappeningSuggestText').innerHTML = '';
				//clickLink('happenning:viewTextSuggestionHidden');
			}
			else
			{
				document.getElementById('textSelected_'+cnt).value = newStr;
				document.getElementById('whatsHappeningSuggestText_'+cnt).innerHTML = '';
				//clickLink('happenning:viewTextSuggestionsHidden');
			}
			
		}
	}
	
    if (deleteKey || backspaceKey)
	{
        val = ele.value;
        
        sel = getInputSelection(ele);
        	
		if (sel.len)
		{
            deletedText = val.slice(sel.start, sel.end);
        }
		else
		{
			
            deletedText = val.charAt(deleteKey ? sel.start : sel.start-1);
        }

		//document.getElementById('textSelected').value = deletedText;
		
		if(hasWhiteSpace(deletedText))
		{
			
			if(cnt == 'none')
			{
				document.getElementById('whatsHappeningSuggestText').innerHTML = '';
				document.getElementById('textSelected').value = newStr;
				document.getElementById('textSelectedForGrade').value = subtractStrings(ele.value, deletedText);
				//clickLink('happenning:viewTextSuggestionHidden');
				
			}
			else
			{
				document.getElementById('whatsHappeningSuggestText_'+cnt).innerHTML = '';
				document.getElementById('textSelected_'+cnt).value = newStr;
				document.getElementById('textSelectedForGrade_'+cnt).value = subtractStrings(ele.value, deletedText);
				//clickLink('happenning:viewTextSuggestionsHidden');
				
			}
			
		}
    }
}

function hasWhiteSpace(s)
{
	return /\s/g.test(s);
}

function subtractStrings(bigStr, smallStr)
{ 
   var pos = bigStr.lastIndexOf(smallStr); 
   
   if( pos == -1 )
   { 
      return bigStr; 
   } 
   else
   { 
      var result = bigStr.substr(0, pos) + bigStr.substr(pos + smallStr.length); 
	 return result; 
   }
}

function countRetweetLimitChars()
{
	var countDiv = document.getElementById("reTweet");
	var msg = document.getElementById('retweetText');
	var msgLength = 0;
	
	if(msg.textContent)
	{
		var msgtxt = msg.textContent.replace(regexp, '12345678901234567890');
		msgLength = msgtxt.length;
	}
	else
	{
		var msgtxt = msg.innerText.replace(regexp, '12345678901234567890');
		msgLength = msgtxt.length;
	}
	
	if(msgLength > 140)
	{
		countDiv.innerHTML = 140 - msgLength;
	}
	else
	{
		countDiv.innerHTML = msgLength + '/140';
	}
	
	if(msgLength > 140)
	{
		countDiv.className = 'tweet-counter-red';
		//document.getElementById('reTweetEnabled').style.display = 'none';
		//document.getElementById('reTweetDisabled').style.display = 'block';
	}
	else
	{
		countDiv.className = 'tweet-counter';
		//document.getElementById('reTweetEnabled').style.display = 'block';
		//document.getElementById('reTweetDisabled').style.display = 'none';
	}
}

function setRTOPTweetMsg(ele, cnt)
{
	document.getElementById("twtMessage_"+cnt).value = ele.value;
}

function renderDivs(cnt)
{
	if(cnt == 'none')
	{
		document.getElementById('WhatHappenDrop').style.display='block'; 
		document.getElementById('gradeLoader').style.display='block'; 
		document.getElementById('gradeDefaultDiv').style.display='none'; 
		document.getElementById('gradeDiv').style.display='none';
	}
	else
	{
		document.getElementById('WhatHappenDrop_'+cnt).style.display='block'; 
		document.getElementById('gradeLoader_'+cnt).style.display='block'; 
		document.getElementById('gradeDefaultDiv_'+cnt).style.display='none'; 
		document.getElementById('gradeDiv_'+cnt).style.display='none';
	}
}

function resetDivs(cnt)
{
	if(cnt == 'none')
	{
		document.getElementById('WhatHappenDrop').style.display='block'; 
		document.getElementById('gradeLoader').style.display='none'; 
		document.getElementById('gradeDefaultDiv}').style.display='block'; 
		document.getElementById('gradeDiv}').style.display='block';
		//document.getElementById('textSelected').value = '';
		//document.getElementById('textSelectedForGrade').value = '';
	}
	else
	{
		document.getElementById('WhatHappenDrop_'+cnt).style.display='block';
		document.getElementById('gradeLoader_'+cnt).style.display='none';
		document.getElementById('gradeDefaultDiv_'+cnt).style.display='block';
		document.getElementById('gradeDiv_'+cnt).style.display='block';
		//document.getElementById('textSelected_'+cnt).value = '';
		//document.getElementById('textSelectedForGrade_'+cnt).value = '';
	}
}

function expandInputDiv(index)
{
	if(document.getElementById('inputDiv_'+index).style.display == 'none')
	{
		document.getElementById('inputDiv_'+index).style.display = 'block';
		document.getElementById('collapse_'+index).innerHTML = '<img src="../images/minus.gif" border="0"/>';
	}
	else
	{
		document.getElementById('inputDiv_'+index).style.display = 'none';
		document.getElementById('collapse_'+index).innerHTML = '<img src="../images/plus.png" border="0"/>';
	}
}

function showPopupTooltip(elemID,cnt)
{
	var imgPosTop = getElementPosition(elemID).offsetTop;
	var imgPosLeft = getElementPosition(elemID).offsetLeft;
	
	imgPosTop = (imgPosTop - 18);
	imgPosLeft = (imgPosLeft + 14);
	
	document.getElementById('twitterLogotextAreaTooltip_'+cnt).style.top = imgPosTop + 'px';
	document.getElementById('twitterLogotextAreaTooltip_'+cnt).style.left = imgPosLeft + 'px';
	document.getElementById('twitterLogotextAreaTooltip_'+cnt).style.display = 'block';	
}

function hidePopupTooltip(cnt)
{
	if(document.getElementById('twitterLogotextAreaTooltip_'+cnt).style.display == 'block')
	{
		document.getElementById('twitterLogotextAreaTooltip_'+cnt).style.display = 'none';
	}
	
}

function getTime12Hr(value){
	//safari in apple mac returns time like '9:00 AM GMT -4.0'
	if(value.indexOf("GMT")>=0){
		value = value.substring(0,value.indexOf("GMT"));
	}
	returnString = value;
	
	var hoursMins = value.split(":");
    hours = hoursMins[0];
	mins = hoursMins[1];
	mins = mins.replace(/\s+$/,"");

	// Chrome returns value in 24hrs format (this is bug), this method will take care of this issue
	if(returnString.indexOf("M") >= 0){//FF and IE ( 12hrs )
		// no need to do anything, 
		//except if (hrs between 01-09, then remove "0" from  prefix
		if(hours < 10){
			returnString = hours.replace(0,'') + ":" + mins;
		}
		return returnString;
	}else{ // for Chrome
		
		if(hours == 0){
		   returnString = hours + ":" + mins + " AM";
		}else if(hours == 12){
		   returnString = hours + ":" + mins + " PM";
		}else if(hours > 12){
		   returnString = (hours - 12) + ":" + mins + " PM";
		}else if(hours < 10){
			returnString= hours.replace(0,'') + ":" + mins + " AM";
		}else{
			returnString= value + " AM";
		}
		return returnString;
	}
}

function setScheduleTime(id){
	
	if(document.getElementById('manualSchedule').style.display == 'block'){
	//alert('manual' + document.getElementById('happenning:manualTimeList').value);
	document.getElementById('rtopScheduleTime_' + id).value = document.getElementById('happenning:manualTimeList').value;
	}else{
	//alert('auto' + document.getElementById('happenning:autoTimeList').value);
	document.getElementById('rtopScheduleTime_' + id).value = document.getElementById('happenning:autoTimeList').value;

	}

	}
