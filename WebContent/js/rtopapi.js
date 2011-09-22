//<![CDATA[
	function closeDIV() {
		document.getElementById('innerTR').style.display='none';
		document.getElementById('locForTweet').value = 'Add your location';
	}
	
	function replace(text, query, selectedText) {
		var lastIndex = text.lastIndexOf(query);
		var subStr = text.substring(0, lastIndex);
		return subStr + selectedText;
	}
	
	function setCaretPosition(ctrl, pos) {
	    if(ctrl.setSelectionRange) {
	        ctrl.focus();
	        ctrl.setSelectionRange(pos,pos);
	    }
	    else if (ctrl.createTextRange) {
	        var range = ctrl.createTextRange();
	        range.collapse(true);
	        range.moveEnd('character', pos);
	        range.moveStart('character', pos);
	        range.select();
	    }
	}
	
	function setSelectedSuggestionText(val) {		
		var textarea = document.getElementById("tweet");
		var suggestText = document.getElementById("textSelected").value;
		
		var newText = replace(textarea.value, globalQuery, val);
		textarea.value = newText;		
		
		document.getElementById('whatsHappeningSuggestText').innerHTML = '';
		document.getElementById('WhatHappenDropDiv').style.display = 'none';
		var idvalue = document.getElementById("objFrom").value;
		document.getElementById(idvalue).value=document.getElementById("tweet").value;
		
		setCaretPosition(document.getElementById("happenning:tweetInput"), newText.length);
		
		/*var textarea = document.getElementById("tweet").value;
		var suggestText = document.getElementById("textSelected").value;
		var caretStartPos = doGetCaretPosition(document.getElementById("tweet"));		
		
		document.getElementById("tweet").value = replace(textarea, globalQuery, val);
		
		caretStartPos = caretStartPos - (suggestText.length);
		var caretEndPos = caretStartPos + (suggestText.length);
		
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
			document.getElementById("tweet").value = subStr1 + val + subStr2;
		}
		else
		{			
			if(subStr1) {
				document.getElementById("tweet").value = subStr1 + ' ' + val + subStr2;
			} else {
				document.getElementById("tweet").value = val + subStr2;
			}				
			
			document.getElementById("tweet").value = subStr1 + ' ' + val + subStr2;
		}

		document.getElementById('whatsHappeningSuggestText').innerHTML = '';
		document.getElementById('WhatHappenDropDiv').style.display = 'none';
		var idvalue = document.getElementById("objFrom").value;
		document.getElementById(idvalue).value=document.getElementById("tweet").value;*/				
		doGrade(keywordArr);
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
	
	function firehiddenTextarea(element,objname){
		document.getElementById("WhatHappenDropDiv").style.position = 'absolute';
		document.getElementById("WhatHappenDropDiv").style.left=(findPosX(element))+ 'px';
		document.getElementById("WhatHappenDropDiv").style.top=(findPosY(element) + 77) + 'px';

		document.getElementById("objFrom").value=element.id;
		document.getElementById("tweet").value=element.value;
		keyupLink(objname);
	}

	function keyupLink(linkId)
	{
	  var fireOnThis = document.getElementById(linkId)
	  if (document.createEvent)
	  {
	    var evObj = document.createEvent('MouseEvents')
	    evObj.initEvent( 'keyup', true, false )
	    fireOnThis.dispatchEvent(evObj)
	  }
	  else if (document.createEventObject)
	  {
		  if(fireOnThis != null){		  
		  fireOnThis.fireEvent('onkeyup')
		  }
	  }
	}
	var keywordArr;
	function doGrade(keywordArr)
	{
		var txt = jQuery('#tweet');
		var txtGrade = txt.val();
		var trimText = jQuery.trim(txtGrade);
		var indexClicked = document.getElementById('indexClk').value;

		if(trimText.length > 0)
		{
			var countBitly = parseInt(countBitlyTags(trimText));
			var countHash = parseInt(countHashTags(trimText));
			var countMentions = parseInt(countMentionsTags(trimText));
			var countContainsValue = parseInt(countContains(trimText, keywordArr)); //DB
			var countTrandingValue = parseInt(countTranding(trimText));// rtop provides
			var countTrendingHashtagValue = parseInt(countTrending(trimText, trendingUpkeywordsHash));// rtop provides
			var countTrendingUrlValue = parseInt(countTrending(trimText, trendingUpkeywordsUrl));// rtop provides
			var countTrendingRefValue = parseInt(countTrending(trimText, trendingUpkeywordsRef));// rtop provides

			var scores = new Array(10,25,30,35,40,45,50,55,60,65,70,75,100,0,2000);
			var grades = new Array("F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+","-","-");

			var countPositive = 0;
			var countNegative = 0;
			var countNeutral = 0;

			//Note: (positive+negative+neutral), has to be 1
			if(totalPositive > totalNegative)
			{
				countPositive=1;
			}
			else if(totalPositive < totalNegative)
			{
				countNegative = 1;
			}
			else if(totalPositive == totalNegative)
			{
				countNeutral=1;
			}
			
			countBitly = (countBitly> 1)?(1):(countBitly);
			countHash = (countHash> 1)?(1):(countHash);
			countMentions = (countMentions> 1)?(1):(countMentions);
			countTrandingValue = (countTrandingValue>1)?(1):(countTrandingValue);
			countTrendingHashtagValue = (countTrendingHashtagValue>1)?(1):(countTrendingHashtagValue);
			countTrendingUrlValue = (countTrendingUrlValue>1)?(1):(countTrendingUrlValue);
			countTrendingRefValue = (countTrendingRefValue>1)?(1):(countTrendingRefValue);
			
			var totalCount = parseInt((10 * countBitly) + (10 * countHash) + (10 * countMentions) + (20 * countPositive) + (-20 * countNegative) + (5 * countNeutral) + (10 * countContainsValue) + (10 * countTrandingValue) + (10 * countTrendingHashtagValue) + (10 * countTrendingUrlValue) + (10 * countTrendingRefValue));
			//document.getElementById('test11').value = "["+ totalCount + "==" + countBitly + "|" + countHash + "|" + countMentions + "|" + countPositive + "|" + countNegative + "|" + countNeutral + "|" + countContainsValue + "|" + countTrandingValue + "|" + countTrendingHashtagValue + "|" + countTrendingUrlValue + "|" + countTrendingRefValue;
			var grade;

			for(var i=0;i<scores.length;i++)
			{
				if(scores[i] > totalCount)
				{
					grade = grades[i];
					break;
				}
			}
			
			document.getElementById('gradeDiv_'+indexClicked).innerHTML = '';
			document.getElementById('gradeDiv_'+indexClicked).innerHTML = grade;
			document.getElementById('rtopGrade_'+indexClicked).value = grade;
			
		}
		
		else
		{
			document.getElementById('gradeDiv_'+indexClicked).innerHTML = '';
			document.getElementById('gradeDiv_'+indexClicked).innerHTML = '<p><img src="../images/greenDotLoader.gif"/></p>';
			document.getElementById('rtopGrade_'+indexClicked).value = '';
		}
	}
	
	function countBitlyTags(str)
	{
		var bitlyTag = 'http://';
		var len = bitlyTag.length;
		var count = 0;
		
		if(len > 0)
		{
			var start = str.indexOf(bitlyTag);
			
			while (start != -1)
			{
				count++;
				start = str.indexOf(bitlyTag, start+len);
			}
		}
		
		return count;
	}
	
	
	function countContains(str, arr)
	{
		var count = 0;
		for (var i = 0; i < arr.length; i++) {
	        	var myRegExp = new RegExp("(^|\\s)" + arr[i].toLowerCase() + "(\\s|$)");
				
				if(myRegExp.test(str.toLowerCase()))
				{
					count++;
				}

	    }
		//if(count > 0)
			//alert('count = ' + count);
		return count;
	}
	
	function countTranding(str){
		return countContains(str, trandingUpkeywords);
	}
	
	function countTrending(str, keyWordsArray){
		return countContains(str, keyWordsArray);
	}
	
	
	function countHashTags(str)
	{
		var hashTag = '#';
		var len = hashTag.length;
		var count = 0;
		
		if(len > 0)
		{
			var start = str.indexOf(hashTag);
			
			while (start != -1)
			{
				count++;
				start = str.indexOf(hashTag, start+len);
			}
		}
		
		return count;
	}
	
	function countMentionsTags(str)
	{
		var mentionsTag = '@';
		var len = mentionsTag.length;
		var count = 0;
		
		if(len > 0)
		{
			var start = str.indexOf(mentionsTag);
			
			while (start != -1)
			{
				count++;
				start = str.indexOf(mentionsTag, start+len);
			}
		}
		
		return count;
	}

	function setTimezoneValue(){
		var now = new Date();
		var str = now.toString();// get the Locale String of the Current Date
		var s = str.split("(");// Split on the first 'character'

		if (s.length == 2)// Making sure the String is in '(TIME FORMAT)'
		{
		   // remove the ending ')'
		    var n = s[1].replace(")", "");

		    // split on words
		    var parts = n.split(" ");

		     var abbr = "";
		     for(i = 0; i < parts.length; i++)
		     {
		        // for each word - get the first letter
		        abbr += parts[i].charAt(0);
		      }
		 
		     // There you have it!
		     // ex. Eastern Daylight Time = EDT
		
		document.getElementById("timezonename").value=abbr;
		
		}
	}

//	moved to whatsHappening.jsp file, for some technical reason, object is not loading properly, on changing of handler
//	jQuery(function() {
//	    var txt = jQuery('#tweet');
//	    alert("creating tweet event" + txt);
//	    txt.data('timeout', null);
//	    txt.keyup(function() {
//	    	alert("keyup pressed......");
//	        clearTimeout(jQuery(this).data('timeout'));
//	        jQuery(this).data('timeout', setTimeout(doQuery, 200));
//	        
//	        jQuery(this).data('timeout', setTimeout(doGrade, 200));
//	    });
//	});
	
	var busy = false;
	var totalPositive=0;
	var totalNegative=0;
	var trandingUpkeywords = new Array();
	var trendingUpkeywordsUrl = new Array();
	var trendingUpkeywordsHash = new Array();
	var trendingUpkeywordsRef = new Array();
			
	/* perform lookup */
	function doQuery() {

		var txt = jQuery('#tweet');
		var all = jQuery.trim(txt.val());
	    var query = txt.val();
	    var curpos = all.length;
		var startpos = all.lastIndexOf(' ');		
		
		var autoDateTime = new Array();
		var indexClicked = document.getElementById('indexClk').value;
		var autoDate = document.getElementById('autoDate');
		var autoTime = document.getElementById('autoTime');
		
		if (startpos < 0) {
			startpos = 0;
		} 
		else{ 
			startpos++;
		}
		
		query = all.substring(startpos, curpos);
		
	    jQuery('#curpos span').html(curpos);
	    jQuery('#startpos span').html(startpos);
	    jQuery('#query span').html(query);
	    jQuery('#text span').html(all);

	    // TODO - change to fully-qualified URL to test cross-domain 
	    var url = getRtopURL("profile/1/text");
	    
	    if (!busy) { 
	        if (query.length) {
	          fetch(url, query, all, 1, function(data) {
	            var ul = jQuery('#WhatHappenDropDiv').empty();
	            var found =0;
                ul.append("							<div id='suggestionTextDiv' style='height: auto; width: 295px;'>");
                var sbuffer = [];                
                // sentiment ( positive/negative/neutral )
                var sentiment = data.sentiment;
    			totalPositive = (sentiment.positive != null)?(sentiment.positive.length):(0);
    			totalNegative = (sentiment.negative != null)?(sentiment.negative.length):(0);
    			autoDateTime = getDateTimeByOffset(data.auto_schedule, '240');
    			autoDate.value = autoDateTime[0];
    			autoTime.value = autoDateTime[1];
    			//alert(isNaN(autoDateTime[0]));
    			//if(!isNaN(autoDateTime[0])){    			
	    			if(indexClicked == 'none')
	    			{
	    				
	    				setAutoDateValue(indexClicked,autoDate);
	    				setAutoTimeValue(indexClicked,autoTime);
	    			}
	    			else
	    			{
	    				setAutoDateValues(indexClicked,autoDate);
	    				setAutoTimeValues(indexClicked,autoTime);
	    			}
    			//}
	    		
	    		var kwIndex = 0;
	    		var kwIndexUrl = 0;
	    		var kwIndexHash = 0;
	    		var kwIndexRef = 0;
	    		trandingUpkeywords = new Array();
	    		trendingUpkeywordsUrl = new Array();
	    		trendingUpkeywordsHash = new Array();
	    		trendingUpkeywordsRef = new Array();

	    		for(var ix in data.trending){
	    			if(isNaN(ix)){
		            	break;
		            }
	    			var trendingeach = data.trending[ix];
	                var sname = trendingeach.name;
	                sname = sname.replace(/\"|>|'/g,'');

	                if(trendingeach != null && trendingeach.count > 0){
	                	if(sname != null){
	                		
		                	if(0 === sname.indexOf('http://')){ // TODO: pls use RegEX instead
		                		trendingUpkeywordsUrl[kwIndexUrl++] = sname;
		                	}else if(0 === sname.indexOf('#')){ // TODO: pls use RegEX instead
		                		trendingUpkeywordsHash[kwIndexHash++] = sname;
		                	}else if(0 === sname.indexOf('@')){ // TODO: pls use RegEX instead
		                		trendingUpkeywordsRef[kwIndexRef++] = sname;
		                	}else{
		                		trandingUpkeywords[kwIndex++] = sname;
		                	}
		                }
	                }
	    		}
	    		
	    		
	            for (var ix in data.query) {
	            	if(isNaN(ix)){
		            	break;
		            }
	            	found=1;
	                var each = data.query[ix];
	                var sname = each.name;
	                sname = sname.replace(/\"|>|'/g,'');

	                //if(each.count > 0){
	                //	trandingUpkeywords[kwIndex++] = sname;
	                //}


	                sbuffer[sbuffer.length] = "								<table width='98%' height='auto' border='0' cellpadding='0' cellspacing='0'>";
	                sbuffer[sbuffer.length] = "									<tr onclick=\"setSelectedSuggestionText('" + sname + "');\" onmouseover=\"this.style.backgroundColor='#E2EECB';\"  onmouseout=\"this.style.backgroundColor='#ffffff';\">";
	                sbuffer[sbuffer.length] = "										<td valign='top' align='center'>";
	                sbuffer[sbuffer.length] = "							    			<div class='dropdownHappenSize'> ";
	                sbuffer[sbuffer.length] = "							    				<div class='dropdownHappenLeft'>";
	                sbuffer[sbuffer.length] = "													<div class='textSuggestName' >" + sname+ "</div>";
	                sbuffer[sbuffer.length] = "							    				</div>";
	                sbuffer[sbuffer.length] = "						        				<div class='dropdownHappenRight'>";
	                sbuffer[sbuffer.length] = "							    					<table width='130' cellpadding='0' cellspacing='0' border='0'>";
	                sbuffer[sbuffer.length] = "							    						<tr>";
	                sbuffer[sbuffer.length] = "							       							<td valign='top' align='left'>";
	                sbuffer[sbuffer.length] = "							       								<div class='dropdownHappenRightFirst'>";
	                sbuffer[sbuffer.length] = "																	<div class='textSuggestCount' >"+Math.abs(each.count)+" INSTANCES</div>";
	                sbuffer[sbuffer.length] = "																</div>";
	                sbuffer[sbuffer.length] = "															</td>";
	                sbuffer[sbuffer.length] = "															<td width='10' valign='top' align='left'>";
	                if(each.count < 0){
		                sbuffer[sbuffer.length] = "															<img src='../images/happenDownArrow.gif' border='0'/>";	                	
	                }else{
	                	sbuffer[sbuffer.length] = "															<img src='../images/happenUpArrow.gif' border='0'/>";	                	
	                }
	                
	                sbuffer[sbuffer.length] = "															</td>";
	                sbuffer[sbuffer.length] = "							       						</tr>";
	                sbuffer[sbuffer.length] = "						        					</table>";
	                sbuffer[sbuffer.length] = "							       				</div>";

	                sbuffer[sbuffer.length] = "											</div>";
	                sbuffer[sbuffer.length] = "							       		</td>";
	                sbuffer[sbuffer.length] = "							       	</tr>";
	                sbuffer[sbuffer.length] = "							   	</table>";


	            }
	            ul.append(sbuffer.join(''));
                ul.append("							</div>");
	            
	            if(found == 1){
	            	jQuery('#WhatHappenDropDiv').show();
	            	doGrade(keywordArr); //********************************SG: You might need this, NK to check and commit
	            }else{
	            	//jQuery('#WhatHappenDropDiv').hide();
	            }
	          });
	          
	        } else {
	          jQuery('#WhatHappenDropDiv').empty();
	          //jQuery('#WhatHappenDropDiv').hide();
	        }
	    }
	}
	
	/* perform lookup */
	function doQueryDefault() {

		var txt = jQuery('#tweet');
		var all = txt.val();
	    var query = txt.val();
		var autoDateTime = new Array();
		var autoDate = document.getElementById('autoDate');
		var autoTime = document.getElementById('autoTime');
		
		var url = getRtopURL("profile/1/text");
		 if (!busy) { 
		fetch(url, query, all, 0, function(data) {
			autoDateTime = getDateTimeByOffset(data.auto_schedule, '240');
			autoDate.value = autoDateTime[0];
			autoTime.value = autoDateTime[1];
			setAutoDateValue('none',autoDate);
			setAutoTimeValue('none',autoTime);
	    });
		}
	}


	function htmlEscape(s) {
	    return document.createTextNode(s?s:'');
	}

	var globalQuery;
	
	function fetch(url, query, text, isTrim, callback) {	
		globalQuery = query;
		//jQuery('#status span').html('waiting...');
	    jQuery.ajax({
	        url: url,
	        contentType: "application/json",
	        data: {
	            query: (isTrim==0)?(query):(jQuery.trim(query)),
	            text: (isTrim==0)?(text):(jQuery.trim(text))
	        },
	        type: "GET",
	        cache: false,
	        dataType: "jsonp",
	        success: function(data) {
	          busy = false;
	          //jQuery('#status span').html('got');
	          callback(data);
	      },
	        error: function(jq, status, err) {
	        busy = false;
	        //jQuery('#status span').html('error');
	        }
	    });

	};
	
	function calcTime(date, offset)
	{
		// to work in all the browser, needs to take of this
		dateReceived = date.replace(/\-/ig, '/').replace('T',' ').split('.')[0];
		
	    // create Date object for current location
	    var d = new Date(dateReceived);
	    var autoScheduleDate = new Array();
	    // convert to msec
	    // add local time zone offset
	    // get UTC time in msec
	   var utc = d.getTime(); // + (d.getTimezoneOffset() * 60000);
	    // create new Date object for different city
	    // using supplied offset
	    var nd = new Date(utc + (3600000*offset));
	    // return time as a array
	    autoScheduleDate[0] = nd.toLocaleDateString(); 
	    autoScheduleDate[1] = nd.toLocaleTimeString(); 
	    autoScheduleDate[2] = nd.getHours();
	    //alert("data received: " + dateReceived + " : " + autoScheduleDate[0] + ":" + autoScheduleDate[1] + ":" + autoScheduleDate[2]);
	    return autoScheduleDate;

	}
	
	function getDateTimeByOffset(date, offset)
	{
		var autoScheduleDate = new Array();
		if(date == null || date == ""){
			return autoScheduleDate;
		}
		// Format from rtop: //2011-08-27T14:00:00.000Z
		var strDt = date;
		var tzOffSet = offset * 60 * 1000; // for EST: offset=240
		var dt = new Date(strDt.substring(0,4), (strDt.substring(5,7) - 1), strDt.substring(8,10),
			strDt.substring(11,13), strDt.substring(14,16), strDt.substring(17,19), 0);

		dt.setTime(dt.getTime() - tzOffSet);
		var rndOffMts = (15) * 60 * 1000; //(15 mins gap)
		dt.setTime(dt.getTime() + (rndOffMts - dt.getTime()%rndOffMts));
		
	    // return time as a array
	    autoScheduleDate[0] = dateFormat(dt, "mm/dd/yyyy");
	    autoScheduleDate[1] = dateFormat(dt, "h:MM TT"); 
	    //alert(autoScheduleDate[0] + "\n" + autoScheduleDate[1]);
	    return autoScheduleDate;
	}
	
	function dateFormat(dt)
	{
		var date = new Date(dt);
		var d  = date.getDate();
		var day = (d < 10) ? '0' + d : d;
		var m = date.getMonth() + 1;
		var month = (m < 10) ? '0' + m : m;
		var yy = date.getYear();
		var year = (yy < 1000) ? yy + 1900 : yy;

		return month + "/" + day + "/" + year;
	}
	
	function timeFormat(time, hr)
	{
		var min;
		var absMin;
		var hrsize = 0;
		if(time != null){
			hrsize=time.indexOf(":");	
		}
	    //if(hr > 9)
	    if(hrsize == 2)
		{
			min = time.substring(3,5);
			min = min/15;
			absMin = parseInt(min);
			min = absMin * 15;
			if(min == "0"){
				min="00";
			}
			time = time.replace(time.substring(3,5),min);
		}
		else
		{
			min = time.substring(2,4);
			min = min/15;
			absMin = parseInt(min);
			min = absMin * 15;
			if(min == "0"){
				min="00";
			}
			time = time.replace(time.substring(2,4),min);
		}
	    return time;
	}
	
	var UTCDate = {
		    convert : function (input){
		        if (!(typeof input === "string")) throw "UTCDate, convert: input must be a string";
		        var d = input.match(/^(\d{4})-(\d{2})-(\d{2})[T ](\d{2}):(\d{2}):(\d{2}(?:\.\d+)?)(Z|(([+-])(\d{2}):(\d{2})))$/i);
		        if (!d) throw "ISODate, convert: Illegal format";
		        return new Date(
		                Date.UTC(d[1],d[2]-1,d[3],d[4],d[5],d[6]|0,(d[6]*1000-((d[6]|0)*1000))|0,d[7]) +
		                (d[7].toUpperCase() ==="Z" ? 0 : (d[10]*3600 + d[11]*60) * (d[9]==="-" ? 1000 : -1000))
		        );
		    },
		    format : function(t,utc){
		        if (typeof t === "string") t = this.convert(t);
		        if (!(t instanceof Date)) throw "ISODate, format: t is not a date object";
		        t = utc ?
		                [t.getUTCFullYear(),t.getUTCMonth(),t.getUTCDate(),t.getUTCHours(),t.getUTCMinutes(),t.getUTCSeconds()] :
		                [t.getFullYear(),t.getMonth(),t.getDate(),t.getHours(),t.getMinutes(),t.getSeconds()];

		        return (t[1] + "/" + t[2] + "/" + t[0] + " " + this.clock12(t[3],t[4]));
				//return this.month[t[1]] + " " +this.ordinal(t[2]) + ", " +t[0] + " @ " + this.clock12(t[3],t[4]);
				
		    },
		    month:["January","February","March","April","May","June","July","September","October","November","December"],
		    ordinal:function(n) {
		        return n+(["th","st","nd","rd"][(( n % 100 / 10) | 0) ===1 ? 0 : n % 10 < 4 ? n % 10 : 0 ]);
		    },
		    clock12:function(h24,m,s){
		        h24%=24;
		        var h12 = h24 % 12;
		        if (h12===0) h12=12;
		        return h12 + ":" +
		                (m<10 ? "0" + m : m) +
		                (isFinite(s) ? ":" + (s<10?"0"+s:s): "") +
		                (h24<12 ? "AM":"PM");
		    }
		};

////////////////////////RTOP Post ////////////////////////
	function getRtopURL( suffix ){
		var url = 'http://twitterroi.terametric.com/rtop/' + suffix; //if null, then take this default
		var elems = document.getElementsByTagName("*");
		for (var i=0, m=elems.length; i<m; i++) {
		    if (elems[i].id && elems[i].id.indexOf("rtopurl") != -1) {
		    	url = elems[i].value + suffix;
		        break;
		    }
		}
		return url;
	}

	function rtopSuggestionText(textToSearch, countDetailsTextDiv, countDetailsLoaderDiv)
	{
		var url = getRtopURL("profile/1/text");
		var query = "" + textToSearch;
		var all = "" + textToSearch;
		
		if (query.length > 0)
		{
			fetchText(url, query, all, function(data){
				//var cdiv = jQuery(countdetailDiv).empty();
				//jQuery(countdetailDiv).show();
				
				for (var ix in data.query)
				{				
					if(isNaN(ix))
					{
						document.getElementById(countDetailsLoaderDiv).style.display = 'none';
						document.getElementById(countDetailsTextDiv).innerHTML = "0 instances";
						break;
		            }
	            	var each = data.query[ix];
	                var sname = each.name;
	                
	                //alert("sname: " + sname + ":" + Math.abs(each.count));
	                //jQuery(countdetailDiv).append(Math.abs(each.count) + " instances");
	                
	                document.getElementById(countDetailsLoaderDiv).style.display = 'none';
	                document.getElementById(countDetailsTextDiv).innerHTML = Math.abs(each.count) + " instances";
	                break;                
				}
				//alert("GOT: " + jQuery('#countdetailDiv'));
				//jQuery(countdetailDiv).show();
			});
			
		}
		else
		{
			document.getElementById(countDetailsLoaderDiv).style.display = 'none';
	        //document.getElementById(countDetailsTextDiv).innerHTML = "String not passed properly";
	        
			//alert("String not passed properly: " + query);
			//jQuery(countDetailsTextDiv).empty();
		}
	}

	var currentICElement;
	function instanceCount(element, textToSearch, textAreaImage, event){
		if(currentICElement){
			if(currentICElement == element)
				return;	
		}
		currentICElement = element;
		if(document.getElementById("instanceDiv")!=null)
		{	
			var left = jQuery(element).offset().left - 60 + (jQuery(element).width() / 2);
			document.getElementById("instanceDiv").style.position = 'absolute';			
						
			if(jQuery(element).offset().left > left) {
				document.getElementById("instanceDiv").style.left = left + 'px';
				document.getElementById("instanceDiv").style.top = jQuery(element).offset().top - 61 + 'px';
			} else {
				var point = getMousePosition(event);
				document.getElementById("instanceDiv").style.left = point.X - 60 + 'px';
				
				var height = jQuery(element).height();
				var Y = point.Y;
				var top = jQuery(element).offset().top;
				
				if(Y > (top + (height/2))) {
					document.getElementById("instanceDiv").style.top = (top + (height/2)) - 61 + "px"; 
				} else {
					document.getElementById("instanceDiv").style.top = top - 61 + 'px';
				}							
			}						 
			
			document.getElementById("instanceDivText").innerHTML = "";
			document.getElementById("instanceDivImg").innerHTML = "";			
			document.getElementById("instanceDiv").style.display = 'block';
			document.getElementById("instanceDivLoader").style.display = 'block';
			
			var url = getRtopURL("profile/1/text");
			var query = "" + textToSearch;
			var all = "" + textToSearch;
			if (query.length > 0)
			{
				fetchText(url, query, all, function(data) {
					//document.getElementById("instanceDiv").innerHTML = "";
					//document.getElementById("instanceDiv").style.display = 'block';
					//document.getElementById("instanceDivLoader").style.display = 'block';
					for (var ix in data.query) {				
						if(isNaN(ix))
						{
							//document.getElementById("instanceDiv").innerHTML = "";
							//document.getElementById("instanceDiv").style.display = 'block';
							
							document.getElementById("instanceDivImg").innerHTML = textAreaImage;
							document.getElementById("instanceDivLoader").style.display = 'none';
							document.getElementById("instanceDivText").innerHTML = "0 instances";							
			            	break;
			            }
		            	var each = data.query[ix];
		                var sname = each.name;
		                
		                //document.getElementById("instanceDiv").innerHTML = "";
		                //document.getElementById("instanceDiv").style.display = 'block';
		                //document.getElementById("instanceDivLoader").style.display = 'block';
		                document.getElementById("instanceDivImg").innerHTML = textAreaImage;
		                document.getElementById("instanceDivLoader").style.display = 'none';
		                document.getElementById("instanceDivText").innerHTML = Math.abs(each.count) + " instances";		                
		                break;                
					}
				});
				
			}
			else
			{
				//document.getElementById("instanceDiv").innerHTML = "";
				document.getElementById("instanceDiv").style.display = 'none';
				document.getElementById("instanceDivLoader").style.display = 'none';
				currentICElement = null;
			}						
		}				
	}
	
//	function instanceCount(element, textToSearch, textAreaImage, event){	
//		if(document.getElementById("instanceDiv") != null) {	
//			var point = getMousePosition(event);
//			
//			
//			var rects =element.getClientRects();			
//			var lastRect = rects[rects.length - 1];
//			var point = getMousePosition(event);
//			var rect = element.getBoundingClientRect()
//			if(point.Y > rect.bottom || point.Y < rect.top) {
//				return;
//			}
//			var left = jQuery(element).offset().left - 60 + (jQuery(element).width() / 2);
//			document.getElementById("instanceDiv").style.position = 'absolute';			
//						
//			if(jQuery(element).offset().left > left) {
//				document.getElementById("instanceDiv").style.left = left + 'px';
//				document.getElementById("instanceDiv").style.top = jQuery(element).offset().top - 61 + 'px';
//			} else {
//				var point = getMousePosition(event);
//				document.getElementById("instanceDiv").style.left = point.X - 60 + 'px';
//				
//				var height = jQuery(element).height();
//				var Y = point.Y;
//				var top = jQuery(element).offset().top;
//				
//				if(Y > (top + (height/2))) {
//					document.getElementById("instanceDiv").style.top = (top + (height/2)) - 61 + "px"; 
//				} else {
//					document.getElementById("instanceDiv").style.top = top - 61 + 'px';
//				}							
//			}						 
//			
//			document.getElementById("instanceDivText").innerHTML = "";
//			document.getElementById("instanceDivImg").innerHTML = "";			
//			document.getElementById("instanceDiv").style.display = 'block';
//			document.getElementById("instanceDivLoader").style.display = 'block';
//			
//			var url = getRtopURL("profile/1/text");
//			var query = "" + textToSearch;
//			var all = "" + textToSearch;
//			if (query.length > 0) {
//				fetchText(url, query, all, function(data) {					
//					for (var ix in data.query) {				
//						if(isNaN(ix)) {
//							document.getElementById("instanceDivImg").innerHTML = textAreaImage;
//							document.getElementById("instanceDivLoader").style.display = 'none';
//							document.getElementById("instanceDivText").innerHTML = "0 instances";							
//			            	break;
//			            }
//		            	var each = data.query[ix];
//		                var sname = each.name;
//		                
//		                document.getElementById("instanceDivImg").innerHTML = textAreaImage;
//		                document.getElementById("instanceDivLoader").style.display = 'none';
//		                document.getElementById("instanceDivText").innerHTML = Math.abs(each.count) + " instances";		                
//		                break;                
//					}
//				});
//				
//			} else {
//				document.getElementById("instanceDiv").style.display = 'none';
//				document.getElementById("instanceDivLoader").style.display = 'none';
//			}						
//		}				
//	}

	function fetchText(url, query, text, callback) {
		//jQuery('#status span').html('waiting...');
	    jQuery.ajax({
	        url: url,
	        contentType: "application/json",
	        data: {
	            query: jQuery.trim(query),
	            text: jQuery.trim(text)
	        },
	        type: "GET",
	        cache: false,
	        dataType: "jsonp",
	        success: function(data) {
	          busy = false;
	          //jQuery('#status span').html('got');
	          callback(data);
	      },
	        error: function(jq, status, err) {
	        busy = false;
	        //jQuery('#status span').html('error');
	        }
	    });

	};	
	
	function hideInstanceDiv() {		
		document.getElementById('instanceDiv').style.display = 'none';
	}

	//////////////////////RTOP Post //////////////////////////	
	
	//]]>	