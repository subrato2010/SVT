function openPopup(title, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv");
	var m = document.getElementById("innerMainDiv"); 
	var b = document.getElementById("popupCloseButton"); 
	var h = document.getElementById("popupHeader");
	var t = document.getElementById("title");
	var f = document.getElementById("frame");
	
	d.style.display = "block";
	d.style.left = left + "px";
	
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}

function manageBack()
{
	var winW = 630, winH = 460;

	winW = document.body.clientWidth;
	winH = document.body.clientHeight;

	var bd = document.getElementById("backDrop");
	bd.style.width = winW + "px";
	bd.style.height = winH + "px";
	bd.style.display = "block";
	
	
}
function closePopup(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv");
	d.style.display = "none";
}

var _dragElement;
var _oldZIndex = 0; 
//mouse starting positions 
var _startX = 0;
var _startY = 0; 
//current element offset 
var _offsetX = 0; 
var _offsetY = 0; 

function InitDragDrop() { 
	document.onmousedown = OnMouseDown; 
	document.onmouseup = OnMouseUp; 
}

function OnMouseDown(e) 
{ 

	if (e == null) 
		e = window.event; 
	// IE uses srcElement, others use target 
	var target = e.target != null ? e.target : e.srcElement; 
	// for IE, left click == 1 // for Firefox, left click == 0 
	if ((e.button == 1 && window.event != null || e.button == 0)) 
	{ 
		_dragElement = document.getElementById("floatingDiv");

		// grab the mouse position 
		_startX = e.clientX; 
		_startY = e.clientY; 
		
		// grab the clicked element's position 
		_offsetX = ExtractNumber(_dragElement.style.left);
		_offsetY = ExtractNumber(_dragElement.style.top); 
		
		 _oldZIndex = _dragElement.style.zIndex; 
		 _dragElement.style.zIndex = 10000; 
		 
		 // tell our code to start moving the element with the mouse 
		document.onmousemove = OnMouseMove; 
		
		// cancel out any text selections 
		document.body.focus(); 
		
		// prevent text selection in IE 
		document.onselectstart = function () { return false; }; 
		
		// prevent IE from trying to drag an image 
		target.ondragstart = function() { return false; }; 

		 return false; 
	}
}

function OnMouseUp(e) 
{

	if (_dragElement != null) 
	{ 
		_dragElement.style.zIndex = _oldZIndex; 
		
		// we're done with these events until the next OnMouseDown 
		document.onmousemove = null; 
		document.onselectstart = null; 
		_dragElement.ondragstart = null; 
		// this is how we know we're not dragging 
		_dragElement = null; 
		
	} 
}
function OnMouseMove(e) 
{ 
	if (e == null ) 
		var e = window.event; 
	// this is the actual "drag code" 
	if(_dragElement != null){
		
		_dragElement.style.left = (_offsetX + e.clientX - _startX) + 'px'; 
		_dragElement.style.top = (_offsetY + e.clientY - _startY) + 'px'; 
	}
	
}
function ExtractNumber(value) 
{ 
	var n = parseInt(value); 
	return n == null || isNaN(n) ? 0 : n; 
} 

function ss() {
	var myselect = document.getElementById('sel');
	for ( var i = 0; i < myselect.options.length; i++) {
		if (myselect.options[i].selected == true) {
			document.getElementById('vk').value = myselect.options[i].text;
			break;
		}
	}
}


/******************* Orange Popup ***********************/

function openPopup1(title, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv1");
	var m = document.getElementById("innerMainDiv1"); 
	var b = document.getElementById("popupCloseButton1"); 
	var h = document.getElementById("popupHeader1");
	var t = document.getElementById("title1");
	var f = document.getElementById("frame1");
	
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
			
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}


/*******************2nd Orange Popup ***********************/

function openPopup3(title, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv3");
	var m = document.getElementById("innerMainDiv3"); 
	var b = document.getElementById("popupCloseButton3"); 
	var h = document.getElementById("popupHeader3");
	var t = document.getElementById("title3");
	var f = document.getElementById("frame3");
	
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}


//By Neel
function openPopup11(title,image, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv11");
	var m = document.getElementById("innerMainDiv11"); 
	var b = document.getElementById("popupCloseButton11"); 
	var h = document.getElementById("popupHeader11");
	var t = document.getElementById("title11");
	var f = document.getElementById("frame11");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}
function closePopupNew1(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv11");
	d.style.display = "none";
}
//By Neel
function closePopupNew12(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv12");
	d.style.display = "none";
}

function closePopupNew(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv1");
	d.style.display = "none";
}

var _dragElement;
var _oldZIndex = 0; 
//mouse starting positions 
var _startX = 0;
var _startY = 0; 
//current element offset 
var _offsetX = 0; 
var _offsetY = 0; 

function InitDragDrop() { 
	document.onmousedown = OnMouseDown; 
	document.onmouseup = OnMouseUp; 
}

function OnMouseDown(e) 
{ 

	if (e == null) 
		e = window.event; 
	// IE uses srcElement, others use target 
	var target = e.target != null ? e.target : e.srcElement; 
	// for IE, left click == 1 // for Firefox, left click == 0 
	if ((e.button == 1 && window.event != null || e.button == 0)) 
	{ 
		_dragElement = document.getElementById("floatingDiv1");

		// grab the mouse position 
		_startX = e.clientX; 
		_startY = e.clientY; 
		
		// grab the clicked element's position 
		_offsetX = ExtractNumber(_dragElement.style.left);
		_offsetY = ExtractNumber(_dragElement.style.top); 
		
		 _oldZIndex = _dragElement.style.zIndex; 
		 _dragElement.style.zIndex = 10000; 
		 
		 // tell our code to start moving the element with the mouse 
		document.onmousemove = OnMouseMove; 
		
		// cancel out any text selections 
		document.body.focus(); 
		
		// prevent text selection in IE 
		document.onselectstart = function () { return false; }; 
		
		// prevent IE from trying to drag an image 
		target.ondragstart = function() { return false; }; 

		 return false; 
	}
}


/******************* Green Popup ***********************/
function openPopup2(title, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv2");
	var m = document.getElementById("innerMainDiv2"); 
	var b = document.getElementById("popupCloseButton2"); 
	var h = document.getElementById("popupHeader2");
	var t = document.getElementById("title2");
	var f = document.getElementById("frame2");
	
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}


function closePopupNew2(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv2");
	d.style.display = "none";
}
function closePopupNew3(){
	var bd = document.getElementById("backDrop1");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv3");
	d.style.display = "none";
}
var _dragElement;
var _oldZIndex = 0; 
//mouse starting positions 
var _startX = 0;
var _startY = 0; 
//current element offset 
var _offsetX = 0; 
var _offsetY = 0; 

function InitDragDrop() { 
	document.onmousedown = OnMouseDown; 
	document.onmouseup = OnMouseUp; 
}

function OnMouseDown(e) 
{ 

	if (e == null) 
		e = window.event; 
	// IE uses srcElement, others use target 
	var target = e.target != null ? e.target : e.srcElement; 
	// for IE, left click == 1 // for Firefox, left click == 0 
	if ((e.button == 1 && window.event != null || e.button == 0)) 
	{ 
		_dragElement = document.getElementById("floatingDiv2");

		// grab the mouse position 
		_startX = e.clientX; 
		_startY = e.clientY; 
		
		// grab the clicked element's position 
		_offsetX = ExtractNumber(_dragElement.style.left);
		_offsetY = ExtractNumber(_dragElement.style.top); 
		
		 _oldZIndex = _dragElement.style.zIndex; 
		 _dragElement.style.zIndex = 10000; 
		 
		 // tell our code to start moving the element with the mouse 
		document.onmousemove = OnMouseMove; 
		
		// cancel out any text selections 
		document.body.focus(); 
		
		// prevent text selection in IE 
		document.onselectstart = function () { return false; }; 
		
		// prevent IE from trying to drag an image 
		target.ondragstart = function() { return false; }; 

		 return false; 
	}
}




function openPopup12(title,image, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv12");
	var m = document.getElementById("innerMainDiv12"); 
	var b = document.getElementById("popupCloseButton12"); 
	var h = document.getElementById("popupHeader12");
	var t = document.getElementById("title12");
	var f = document.getElementById("frame12");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}
function closePopupNew1(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv12");
	d.style.display = "none";
}
//By Neel



function openPopup44(title, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDiv4");
	var m = document.getElementById("innerMainDiv4"); 
	var b = document.getElementById("popupCloseButton4"); 
	var h = document.getElementById("popupHeader4");
	var t = document.getElementById("title4");
	var f = document.getElementById("frame4");
	
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	
	if(title != null){
		t.innerHTML = title;
	}
	
	m.style.width = (width - (border*2))+ "px";
	m.style.height = (height - (border*2)) + "px";
	m.style.marginLeft = border + "px";
	m.style.marginRight = border + "px";
	m.style.marginTop = border+ "px";
	m.style.marginBottom = border+ "px";
	if(f!= null)
	{
		f.width = width - (border*2);
	}
	if(noheader == true){
		h.style.display = "none";
		if(f!= null)
		{
			f.height = (height - (border*2)) + "px";
		}
	}else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; //header = 44px
		}
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(f!= null)
	{
		if(scrollable == true){
			f.scrolling ="yes";
		}
		
		f.src = src;
	}
	InitDragDrop();
}

function closePopupNew4(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	
	var d = document.getElementById("floatingDiv4");
	d.style.display = "none";
}