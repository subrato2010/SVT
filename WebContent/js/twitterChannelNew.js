
function setProfileId(profileName){
	document.getElementById('captionDiv').innerHTML="@" + profileName;
}
function setSortById(name){
	document.getElementById('captionDivSortby').innerHTML=name;
}
function twitSuccess(str,str1,str2) {
	var totalClicked = str2;
	var len = 0;
	var cnt = 0;
	if(str == 'true' || str == true)  
		{
			len = totalClicked.length;
			//alert('totalOld - '+totalOld+'\n'+'totalClicked - '+totalClicked);
			while(cnt <= len)
				{
					//alert('From while');
					var clicked = parseInt(totalClicked.charAt(cnt))+1;
					//alert('clicked - '+clicked);
					var bd = parent.document.getElementById("realTime"+clicked);
					 //alert("bd-"+bd);
					bd.style.display = "none";
					var bd1 = parent.document.getElementById("msg"+clicked);
					 //alert("bd1-"+bd1);
					bd1.style.display = "block";
					cnt++;
				}
			}
			else
			{
				cnt=1;
				while(cnt < 9)
				{
					var bd = parent.document.getElementById("msg"+cnt);
					bd.style.display = "none";
					cnt++;
				}
			}
	} 
function showPopup1(str)  {
	//alert(str);
	if(str == "editProfileAuth")
		openPopupR('Edit Profile Preferences', '', '#E7E7E7', '#787E89', '*Required', 254, 3, 785, 800, 10, false, true, false, 'editProfile.jsp');
	else if(str == "createProfileAuth")
			parent.location.href='twt.jsp';	 
}

/*function authValidation(str)
		{
			if(str == false || str == 'false')
				var val = openPopup1('Alert !','../images/Alert/alertSign.gif', '#FEA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 150, 465, 270, 10, false, true, false, 'oauthAlert.jsp')
		}
*/

function showPopup2(str)  {
	//alert(str);
	if(str == "editProfileAuth")
		openPopupR('Edit Profile Preferences', '', '#E7E7E7', '#787E89', '*Required', 254, 3, 785, 800, 10, false, true, false, 'editProfile.jsp');
	//else if(str == "createProfileAuth")
			//parent.location.href='twt.jsp';	 
}

function authValidation1(str)  {
	if(str == false || str == 'false')
		var val = openPopup1('Alert !','../images/Alert/alertSign.gif', '#FEA600', '#ffffff', '../images/Alert/closeButtonOrange.gif', 424, 150, 465, 270, 10, false, true, false, 'oauthAlert.jsp');
	
}

/**
 * This method will update RTO Goal percentage and display of star/flame count
 * @param goalValue
 * @param starCount
 * @param flameCount
 * @return
 */
function updateRTOGoalPercentage(goalValue,starCount,flameCount){
	parent.document.getElementById('rtoGoalPercentage').innerHTML=goalValue;
	imgTag = '';
	for(var scount=0; scount<starCount; scount++){
		imgTag += '<img src="../images/yellowStarBig.gif" onmouseover="this.src=\'../images/yellowStarBigRollover.gif\';" onmouseout="this.src=\'../images/yellowStarBig.gif\';" ></img>';
	}
	for(var scount=0; scount<flameCount; scount++){
		imgTag += '<img src="../images/orangeFlameBig.gif" onmouseover="this.src=\'../images/orangeFlameBigRollover.gif\';" onmouseout="this.src=\'../images/orangeFlameBig.gif\';" ></img>';
	}
	if(flameCount>0){ // gray
		parent.document.getElementById('rtoGoalTooltipcontent').innerHTML = 'Flames represent actual performance degradation in this metric.';
		for(var scount=flameCount; scount<5; scount++){
			imgTag += '<img src="../images/grayFlameBig.gif" onmouseover="this.src=\'../images/grayFlameBig.gif\';" onmouseout="this.src=\'../images/grayFlameBig.gif\';" ></img>';
		}		
	}
	if(starCount>0){ // gray 
		parent.document.getElementById('rtoGoalTooltipcontent').innerHTML = 'Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal.';
		for(var scount=starCount; scount<5; scount++){
			imgTag += '<img src="../images/grayStarBig.gif" onmouseover="this.src=\'../images/grayStarBig.gif\';" onmouseout="this.src=\'../images/grayStarBig.gif\';" ></img>';
		}		
	}
	parent.document.getElementById('rtostarcounter').innerHTML=imgTag;
}


/**
 * This method will update RTO Action Optimize section and display the flame count
 * 
 * @param flameCount
 * @param actionLabel
 * 
 */

function updateRTOActionOptimizer(flameCount, starCount, actionLabel, divId)
{
	parent.document.getElementById('actionOptimizeLabel'+divId).innerHTML = actionLabel;
	var imgTag = '';
	for(var scount=0; scount<starCount; scount++){
		imgTag += '<img style="margin-left: 4px;" src="../images/yellowStarSmall.gif" onmouseover="this.src=\'../images/yellowStarSmallRollover.gif\';" onmouseout="this.src=\'../images/yellowStarSmall.gif\';" ></img>';
	}
	for(var scount=0; scount<flameCount; scount++){
		imgTag += '<img style="margin-left: 4px;" src="../images/orangeFlameSmall.gif" onmouseover="this.src=\'../images/orangeFlameSmallRollover.gif\';" onmouseout="this.src=\'../images/orangeFlameSmall.gif\';" ></img>';
	}
	if(flameCount>0){ // gray
		//parent.document.getElementById('actionFlameCount'+divId).innerHTML = 'Flames represent actual performance degradation in this metric.';
		for(var scount=flameCount; scount<5; scount++){
			imgTag += '<img style="margin-left: 4px;" src="../images/grayFlameSmall.gif" onmouseover="this.src=\'../images/grayFlameSmall.gif\';" onmouseout="this.src=\'../images/grayFlameSmall.gif\';" ></img>';
		}		
	}
	if(starCount>0){ // gray 
		//parent.document.getElementById('actionFlameCount'+divId).innerHTML = 'Stars represent the progress made for this metric toward reaching your target score, determined by your selected goal.';
		for(var scount=starCount; scount<5; scount++){
			imgTag += '<img style="margin-left: 4px;"  src="../images/grayStarSmall.gif" onmouseover="this.src=\'../images/grayStarSmall.gif\';" onmouseout="this.src=\'../images/grayStarSmall.gif\';" ></img>';
		}		
	}
	parent.document.getElementById('actionFlameCount'+divId).innerHTML = imgTag;
}

function getSelectedText()
{
	var textarea = document.getElementById("happenning:tweetInput");
	document.getElementById('whatsHappeningSuggestText').innerHTML = '';
	
	//getSelectedTextPosition(textarea.value);
	
	if (document.selection)
	{
		textarea.focus();
		var sel = document.selection.createRange();
		
		document.getElementById("textSelected").value = sel.text;
		clickLink('happenning:viewTextSuggestionHidden');
								   
	}
	else
	{
		var len = textarea.value.length;
		var start = textarea.selectionStart;
		var end = textarea.selectionEnd;
		var sel = textarea.value.substring(start, end);
 		
		document.getElementById("textSelected").value = sel;
		clickLink('happenning:viewTextSuggestionHidden');
	}
}

function hideSuggestionText(cnt)
{
	if(cnt == 'none')
	{
		document.getElementById('whatsHappeningSuggestText').innerHTML = '';
		document.getElementById('WhatHappenDrop').style.display='none';
	}
	
	else
	{
		document.getElementById('whatsHappeningSuggestText_'+cnt).innerHTML = '';
		document.getElementById('WhatHappenDrop_'+cnt).style.display='none';
	}	
	
}

function getSelectedTextPosition(fullString)
{
	//alert(fullString);
	if (window.getSelection) 
    {               
        var range = window.getSelection ();                     
        var startPosition = fullString.search(range);
        var getPosition = range.toString();
        var endPosition = parseInt(getPosition.length) + parseInt(startPosition)
        //alert ("@Start position : " + startPosition + " and End position : " + endPosition);        
    }
	else
    {
        if (document.selection.createRange)
        {
            var range = document.selection.createRange ();
            var startPosition = fullString.search(range.text);
            var getPosition = range.text;
            var endPosition = parseInt(getPosition.length) + parseInt(startPosition);
            //alert ("#Start position : " + startPosition + " and End position : " + endPosition);
        }
    }
}

function setSelectedText(val, cnt)
{
	
	if(cnt == 'none')
	{
		var textarea = document.getElementById("happenning:tweetInput").value;
		var suggestText = document.getElementById("textSelected").value;
		var caretStartPos = doGetCaretPosition(document.getElementById("happenning:tweetInput"));
	}
	else
	{
		var textarea = document.getElementById("tweetInput_"+cnt).value;
		var suggestText = document.getElementById("textSelected_"+cnt).value;
		var caretStartPos = doGetCaretPosition(document.getElementById("tweetInput_"+cnt));
	}
	
	caretStartPos = caretStartPos - (suggestText.length);
	
	var caretEndPos = caretStartPos + suggestText.length;
	
	if(caretStartPos == '1')
	{
		var subStr1 = textarea.substring(0, caretStartPos-1);
	}
	else
	{
		var subStr1 = textarea.substring(0, caretStartPos);
	}
	
	var subStr2 = textarea.substring(caretEndPos, textarea.length);
	
	if(caretStartPos == '1')
	{
		if(cnt == 'none')
		{
			document.getElementById("happenning:tweetInput").value = subStr1 + val + subStr2;
		}
		else
		{
			document.getElementById("tweetInput_"+cnt).value = subStr1 + val + subStr2;
		}
		
	}
	else
	{
		if(cnt == 'none')
		{
			document.getElementById("happenning:tweetInput").value = subStr1 + ' ' + val + subStr2;
		}
		else
		{
			document.getElementById("tweetInput_"+cnt).value = subStr1 + ' ' + val + subStr2;
		}
		
	}
	
	if(cnt == 'none')
	{
		document.getElementById('whatsHappeningSuggestText').innerHTML = '';
		document.getElementById('WhatHappenDrop').style.display = 'none';
	}
	else
	{
		document.getElementById('whatsHappeningSuggestText_'+cnt).innerHTML = '';
		document.getElementById('WhatHappenDrop_'+cnt).style.display = 'none';
	}
	
}

function doGetCaretPosition (ctrl)
{

	var CaretPos = 0;
	// IE Support
	if (document.selection)
	{

		ctrl.focus ();
		var Sel = document.selection.createRange ();
		Sel.moveStart ('character', -ctrl.value.length);

		CaretPos = Sel.text.length;
	}
	// Firefox support
	else if (ctrl.selectionStart || ctrl.selectionStart == '0')
	{
		CaretPos = ctrl.selectionStart;
	}	

	return CaretPos;

}
