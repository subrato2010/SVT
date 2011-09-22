function change1()
{
	var flag = true;
	var pageHeight = document.getElementById('pageT').offsetHeight;
	//alert(pageHeight);
	document.getElementById('transParentDiv').style.height=parseInt(pageHeight)+'px';
	document.getElementById('transParentDiv').style.display='block';
	return true;
	
}
function openPopup(title, imgLeft, backColor, textColor, closeParameter, left, top, width, height, border, noheader, closable, scrollable, src)
{
	change1();
	var d = document.getElementById("floatingDiv");
	var m = document.getElementById("innerMainDiv"); 
	var b = document.getElementById("popupCloseButton"); 
	var h = document.getElementById("popupHeader");
	var t = document.getElementById("title");
	var s = document.getElementById("imgleft");
	var u = document.getElementById("closeParameter");
	var f = document.getElementById("frame");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	//alert("imgLeft"+imgLeft);
	if(imgLeft != null){
		s.innerHTML = '';
		var imageElem = document.createElement("img");
		imageElem.setAttribute("src", imgLeft);
		imageElem.setAttribute("border", 0);
		s.appendChild(imageElem);
	}
	if(imgLeft == ''){
		s.innerHTML = '';
		s.style.width = '0px';
	}
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
	}
	else{
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
	if(backColor!=null)
	{
		h.style.backgroundColor = backColor;
	}
	if(textColor!=null)
	{
		t.style.color = textColor;
	}
	if(closeParameter != '')
	{
		if(closeParameter.lastIndexOf("/images")!=-1)
		{
			u.innerHTML = '';
			var imageElem = document.createElement("img");
			imageElem.setAttribute("src", closeParameter);
			imageElem.setAttribute("border", 0);
			imageElem.setAttribute("style", "cursor:pointer");
			imageElem.setAttribute("style", "color:#787E89");
			u.appendChild(imageElem);
			var imageTagPreifix = u.innerHTML.toString().split('>')[0]+" ";
			var onclickEvent = "onclick='closePopup();' />";
			u.innerHTML = imageTagPreifix+onclickEvent;
		}
		else
		{
			u.innerHTML = '';
			u.innerHTML = closeParameter;
		}
	}
	//InitDragDrop();
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
	var k = document.getElementById("transParentDiv");
	k.style.display = "none";
	var d = document.getElementById("floatingDiv");
	d.style.display = "none";
	var e = document.getElementById("ALMore");
	e.style.display = "none";
	var f = document.getElementById("ALMore1");
	f.style.display = "none";
	var f = document.getElementById("ALMore2");
	f.style.display = "none";
	var f = document.getElementById("ALMore3");
	f.style.display = "none";
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
function closePopupNew1(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	var d = document.getElementById("floatingDiv11");
	d.style.display = "none";
	var m = document.getElementById("floatingDivInfu");
	m.style.display = "none";
}
//By Neel

function openPopupLogin(title, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDivLogin");
	var m = document.getElementById("innerMainDivLogin"); 
	var b = document.getElementById("popupCloseButtonLogin"); 
	var h = document.getElementById("popupHeaderLogin");
	var t = document.getElementById("titleLogin");
	var f = document.getElementById("frameLogin");
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
	//InitDragDrop();
}
function closePopupLogin(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	var d = document.getElementById("floatingDivLogin");
	d.style.display = "none";
}
function closePopup1(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	var k = document.getElementById("transParentDiv");
	k.style.display = "none";
	var d = document.getElementById("floatingDiv1");
	d.style.display = "none";
	var e = document.getElementById("ALMore");
	e.style.display = "none";
	var f = document.getElementById("ALMore1");
	f.style.display = "none";
	var g = document.getElementById("ALMore2");
	g.style.display = "none";
	var h = document.getElementById("ALMore3");
	h.style.display = "none";
}
function closePopup2(){
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	var d = document.getElementById("floatingDiv1");
	d.style.display = "none";
	var e = document.getElementById("ALMore");
	e.style.display = "none";
	var f = document.getElementById("ALMore1");
	f.style.display = "none";
	var g = document.getElementById("ALMore2");
	g.style.display = "none";
	var h = document.getElementById("ALMore3");
	h.style.display = "none";
}

function openPopup1(title, imgLeft, backColor, textColor, closeParameter, left, top, width, height, border, noheader, closable, scrollable, src)
{
	change1();
	var d = document.getElementById("floatingDiv1");
	var m = document.getElementById("innerMainDiv1"); 
	var b = document.getElementById("popupCloseButton1"); 
	var h = document.getElementById("popupHeader1");
	var t = document.getElementById("title1");
	var s = document.getElementById("imgleft1");
	var u = document.getElementById("closeParameter1");
	var f = document.getElementById("frame1");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	//alert("imgLeft"+imgLeft);
	if(imgLeft != null){
		s.innerHTML = '';
		var imageElem = document.createElement("img");
		imageElem.setAttribute("src", imgLeft);
		imageElem.setAttribute("border", 0);
		s.appendChild(imageElem);
	}
	if(imgLeft == ''){
		s.innerHTML = '';
		s.style.width = '0px';
	}
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
	}
	else{
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
	if(backColor!=null)
	{
		h.style.backgroundColor = backColor;
	}
	if(textColor!=null)
	{
		t.style.color = textColor;
	}
	if(closeParameter != '')
	{
		if(closeParameter.lastIndexOf("/images")!=-1)
		{
			u.innerHTML = '';
			var imageElem = document.createElement("img");
			imageElem.setAttribute("src", closeParameter);
			imageElem.setAttribute("border", 0);
			//imageElem.setAttribute("onclick", 'closePopup1();');
			imageElem.setAttribute("style",'cursor:pointer');
			u.appendChild(imageElem);
			var imageTagPreifix = u.innerHTML.toString().split('>')[0]+" ";
			var onclickEvent = "onclick='closePopup1();' />";
			u.innerHTML = imageTagPreifix+onclickEvent;
		}
		else
		{
			u.innerHTML = '';
			u.innerHTML = closeParameter;
		}
	}
	//InitDragDrop();
}
function openPopup2(title, imgLeft, backColor, textColor, closeParameter, left, top, width, height, border, noheader, closable, scrollable, src)
{	
	change1();
	var d = document.getElementById("floatingDiv1");
	var m = document.getElementById("innerMainDiv1"); 
	var b = document.getElementById("popupCloseButton1"); 
	var h = document.getElementById("popupHeader1");
	var t = document.getElementById("title1");
	var s = document.getElementById("imgleft1");
	var u = document.getElementById("closeParameter1");
	var f = document.getElementById("frame1");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	//alert("imgLeft"+imgLeft);
	if(imgLeft != null){
		s.innerHTML = '';
		var imageElem = document.createElement("img");
		imageElem.setAttribute("src", imgLeft);
		imageElem.setAttribute("border", 0);
		s.appendChild(imageElem);
	}
	if(imgLeft == ''){
		s.innerHTML = '';
		s.style.width = '0px';
	}
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
	}
	else{
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
	if(backColor!=null)
	{
		h.style.backgroundColor = backColor;
	}
	if(textColor!=null)
	{
		t.style.color = textColor;
	}
	if(closeParameter != '')
	{
		if(closeParameter.lastIndexOf("/images")!=-1)
		{
			u.innerHTML = '';
			var imageElem = document.createElement("img");
			imageElem.setAttribute("src", closeParameter);
			imageElem.setAttribute("border", 0);
			//imageElem.setAttribute("onclick", 'closePopup1();');
			imageElem.setAttribute("style",'cursor:pointer');
			u.appendChild(imageElem);
			var imageTagPreifix = u.innerHTML.toString().split('>')[0]+" ";
			var onclickEvent = "onclick='closePopup2();' />";
			u.innerHTML = imageTagPreifix+onclickEvent;
		}
		else
		{
			u.innerHTML = '';
			u.innerHTML = closeParameter;
		}
	}
	//InitDragDrop();
}
function openPopupR(title, imgLeft, backColor, textColor, closeParameter, left, top, width, height, border, noheader, closable, scrollable, src)
{
	change1();
	//createDiv();
	//var newdiv = document.createElement('div');
	 // var divIdName = 'div'+arguments[0];
	  
	var d = document.getElementById("floatingDivR");
	var m = document.getElementById("innerMainDivR"); 
	var b = document.getElementById("popupCloseButtonR"); 
	var h = document.getElementById("popupHeaderR");
	var t = document.getElementById("titleR");
	var s = document.getElementById("imgleftR");
	var u = document.getElementById("closeParameterR");
	var f = document.getElementById("frameR");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	//alert("imgLeft"+imgLeft);
	//newdiv.setAttribute('id',divIdName);
	
	if(imgLeft != null){
		s.innerHTML = '';
		var imageElem = document.createElement("img");
		imageElem.setAttribute("src", imgLeft);
		imageElem.setAttribute("border", 0);
		s.appendChild(imageElem);
	}
	if(imgLeft == ''){
		s.innerHTML = '';
		s.style.width = '0px';
		
	}
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
	}
	else{
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
	if(backColor!=null)
	{
		h.style.backgroundColor = backColor;
	}
	if(textColor!=null)
	{
		t.style.color = textColor;
	}
	if(closeParameter != '')
	{
		if(closeParameter.lastIndexOf("/images")!=-1)
		{
			u.innerHTML = '';
			var imageElem = document.createElement("img");
			imageElem.setAttribute("src", closeParameter);
			imageElem.setAttribute("border", 0);
			imageElem.setAttribute("style", "cursor:pointer");
			imageElem.setAttribute("style", "color:#787E89");
			u.appendChild(imageElem);
			var imageTagPreifix = u.innerHTML.toString().split('>')[0]+" ";
			var onclickEvent = "onclick='closePopup();' />";
			u.innerHTML = imageTagPreifix+onclickEvent;
		}
		else
		{
			u.innerHTML = '';
			u.innerHTML = closeParameter;
		}
	}
	 
	//InitDragDrop();
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
		_dragElement = document.getElementById("floatingDivR");
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
function allClose()
{
	parent.document.getElementById('floatingDiv1').style.display='none';
	parent.document.getElementById('floatingDiv').style.display='none';
	parent.document.getElementById('backDrop').style.display='none'; 
	parent.document.getElementById('transParentDiv').style.display='none';
}

//Added by NEEL on 02-06-2011

function allCloseReply()
{
	parent.document.getElementById('floatingDiv1').style.display='none';
}

//Added by NEEL Ended Here


function allCloseFloteDiv()
{
	parent.document.getElementById('floatingDiv').style.display='none'; 
	
}
function openPopupinfu(title,image, left, top, width, height, border, noheader, closable, scrollable, src)
{
	manageBack();
	var d = document.getElementById("floatingDivInfu");
	var m = document.getElementById("innerMainDivInfu"); 
	var b = document.getElementById("popupCloseButtonInfu"); 
	var h = document.getElementById("popupHeaderInfu");
	var t = document.getElementById("titleInfu");
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

function OnMouseDown(e) 
{ 
if (e == null) 
		e = window.event; 
	// IE uses srcElement, others use target 
	var target = e.target != null ? e.target : e.srcElement; 
	// for IE, left click == 1 // for Firefox, left click == 0 
	if ((e.button == 1 && window.event != null || e.button == 0)) 
	{ 
		_dragElement = document.getElementById("floatingDivInfu");
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

function setRTMsg()
{
	var msg = document.getElementById('retweetText');
	
	if(msg.textContent)
	{
		document.getElementById('reTweetMsg').value = msg.textContent;
	}
	else
	{
		document.getElementById('reTweetMsg').value = msg.innerText;
	}
}

function setTweetMsg()
{
var msg = document.getElementById('retweetText');
	
	if(msg.textContent)
	{
		document.getElementById('reTweetMsg').value = msg.textContent;
	}
	else
	{
		document.getElementById('reTweetMsg').value = msg.innerText;
	}
}

function setRTOPMsg(cnt)
{
	
	if(cnt == 'none')
	{
		document.getElementById('rtopMsg_'+cnt).value = document.getElementById('happenning:tweetInput').value;
	}
	else
	{
		document.getElementById('rtopMsg_'+cnt).value = document.getElementById('tweetInput_'+cnt).value;
	}
}

function countBioLimitChars()
{
	var countDiv = document.getElementById("bioWords");
	var msg = document.getElementById('bioText').value;
	var msgLength = document.getElementById('bioText').value.length;
	
	if(msgLength > 160)
	{
		countDiv.innerHTML = 160 - msgLength;
	}
	else
	{
		countDiv.innerHTML = msgLength + '/160';
	}
	
	if(msgLength > 160)
	{
		countDiv.className = 'tweet-counter-red';
	}
	else
	{
		countDiv.className = 'tweet-counter';
	} 	
}

/************************ tapasb *************************/

function toggleAuthenticateBitlyAccountComponent(txtBx, lnk, img) {	
	var textBox = document.getElementById(txtBx);
	var link = document.getElementById(lnk);
	var image = document.getElementById(img);

	if(textBox.value == null || textBox.value == "") {		
		link.style.display = 'none';
		image.style.display = 'inline';
	} else {
		link.style.display = 'inline';
		image.style.display = 'none';
	}
}

function setScrollValue() {
	var scrollValueHidden = document.getElementById('createProfile:scrollValueHidden');
	var frames = window.parent.frames;
	var iframe = frames["frameR"];
	var x = iframe.document.body.scrollLeft;
	var y = iframe.document.body.scrollTop;
	scrollValueHidden.value = x + ":" + y;
}

function openPopupTB(title, imgLeft, backColor, textColor, closeParameter, left, top, width, height, border, noheader, closable, scrollable, src, id) {
	document.getElementById("actionIdHiddenForm:actionIdHidden").value = id;
	
	change1();
	var d = document.getElementById("floatingDiv");
	var m = document.getElementById("innerMainDiv"); 
	var b = document.getElementById("popupCloseButton"); 
	var h = document.getElementById("popupHeader");
	var t = document.getElementById("title");
	var s = document.getElementById("imgleft");
	var u = document.getElementById("closeParameter");
	var f = document.getElementById("frame");
	d.style.display = "block";
	d.style.left = left + "px";
	d.style.top = top+ "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	
	if(imgLeft != null){
		s.innerHTML = '';
		var imageElem = document.createElement("img");
		imageElem.setAttribute("src", imgLeft);
		imageElem.setAttribute("border", 0);
		s.appendChild(imageElem);
	}
	if(imgLeft == ''){
		s.innerHTML = '';
		s.style.width = '0px';
	}
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
	}
	else{
		if(f!= null)
		{
			f.height = (height - (border*2) - 44)+ "px"; 
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
	if(backColor!=null)
	{
		h.style.backgroundColor = backColor;
	}
	if(textColor!=null)
	{
		t.style.color = textColor;
	}
	if(closeParameter != '')
	{		
		if(closeParameter.lastIndexOf("/images")!=-1)
		{
			u.innerHTML = '';
			var imageElem = document.createElement("img");
			imageElem.setAttribute("src", closeParameter);
			imageElem.setAttribute("border", 0);
			imageElem.setAttribute("style", "cursor:pointer");
			imageElem.setAttribute("style", "color:#787E89");
			u.appendChild(imageElem);
			var imageTagPreifix = u.innerHTML.toString().split('>')[0]+" ";
			
			if(id==3){
				var onclickEvent = "onclick='hideUserListPopup(); closePopupTB();' />";
				u.setAttribute("onclick", "hideUserListPopup(); closePopupTB();")
			} else {
				var onclickEvent = "onclick='closePopupTB();' />";
				u.setAttribute("onclick", "closePopupTB();")
			}
			
			u.innerHTML = imageTagPreifix+onclickEvent;
		}
		else
		{
			u.innerHTML = '';
			u.innerHTML = closeParameter;
		}
	}
}

function doChange() {
	var flag = true;
	var pageHeight = document.getElementById('pageT').offsetHeight;
	document.getElementById('transParentDiv').style.height=parseInt(pageHeight)+'px';
	document.getElementById('transParentDiv').style.display='block';
	return true;	
}

function bringPageView(id) {	
	document.getElementById('transParentDiv').style.display='none';	
	document.getElementById('optimizeAlert'+id).style.display='none';
	document.getElementById('floatingDivTB'+id).style.display='none';
	document.getElementById('backDrop'+id).style.display='none'; 
	change();
	reRenderPanel();
} 

function left(obj) {
	var curleft = 0;
	if (obj.offsetParent) {
		while (1) {
			curleft += obj.offsetLeft;
			if (!obj.offsetParent) {
				break;
			}
				
			obj = obj.offsetParent;
		}
	} else if (obj.x) {
		curleft += obj.x;
	}

	return curleft;
}

function top(obj) {
	var curtop = 0;
	if (obj.offsetParent) {
		while (1) {
			curtop += obj.offsetTop;
			if (!obj.offsetParent) {
				break;
			}
			
			obj = obj.offsetParent;
		}
	} else if (obj.y) {
		curtop += obj.y;
	}

	return curtop;
}

function getScrollPosition(divId) {
        return document.getElementById(divId).scrollTop;
}

function showLoading(divId) {
	document.getElementById(divId).style.display='block';
}

function hideLoading(divId) {	
	document.getElementById(divId).style.display='none';
	return true;
}

function setDynamicLoaderDivStyle(divObj) {	
	var height = document.getElementById('popupDiv').offsetHeight;
    var width = document.getElementById('popupDiv').offsetWidth;
    
    divObj.style.height = height+'px';
    divObj.style.width = width+'px';
    divObj.style.display='block';	
}

function showInfuencePopup(elemID, divToPopupId, firstScrollableDivId, leftSide, topSide) {
	var objElem = document.getElementById(elemID);
	var objDiv = document.getElementById(divToPopupId);
		
	objDiv.style.display = 'block';	
	objDiv.style.left = left(objElem) - leftSide + 'px';
	objDiv.style.top = top(objElem) - topSide - getScrollPosition(firstScrollableDivId) + 'px';
}

function hideInfuencePopup(elemID) {
	var obj = document.getElementById(elemID);
	if(obj.style.display == 'block') {
		obj.style.display = 'none';
	}
}

function hideUserListPopup() {		
	var divCollection = parent.document.getElementsByTagName("div");
    for (var i = 0; i < divCollection.length; i++) {
        if(divCollection[i].getAttribute("class") == "listPopup") {
        	divCollection[i].style.display = "none";
        } 
    }
}

function openCreateNewUserListPopup(title, imgLeft, backColor, textColor, closeParameter, width, height, border, noheader, closable, scrollable, src)
{	
	change1();
	var addNewUserListButtonDiv = document.getElementById('addNewUserListButtonDiv');
	var d = document.getElementById("floatingDiv1");
	var m = document.getElementById("innerMainDiv1"); 
	var b = document.getElementById("popupCloseButton1"); 
	var h = document.getElementById("popupHeader1");
	var t = document.getElementById("title1");
	var s = document.getElementById("imgleft1");
	var u = document.getElementById("closeParameter1");
	var f = document.getElementById("frame1");
	d.style.display = "block";
	d.style.left = left(addNewUserListButtonDiv) - 276 + "px";
	d.style.top = top(addNewUserListButtonDiv) + 40 + "px";
	d.style.width = width+ "px";
	d.style.height = height+ "px";
	//alert("imgLeft"+imgLeft);
	if(imgLeft != null){
		s.innerHTML = '';
		var imageElem = document.createElement("img");
		imageElem.setAttribute("src", imgLeft);
		imageElem.setAttribute("border", 0);
		s.appendChild(imageElem);
	}
	if(imgLeft == ''){
		s.innerHTML = '';
		s.style.width = '0px';
	}
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
	}
	else{
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
	if(backColor!=null)
	{
		h.style.backgroundColor = backColor;
	}
	if(textColor!=null)
	{
		t.style.color = textColor;
	}
	if(closeParameter != '')
	{
		if(closeParameter.lastIndexOf("/images")!=-1)
		{
			u.innerHTML = '';
			var imageElem = document.createElement("img");
			imageElem.setAttribute("src", closeParameter);
			imageElem.setAttribute("border", 0);
			//imageElem.setAttribute("onclick", 'closePopup1();');
			imageElem.setAttribute("style",'cursor:pointer');
			u.appendChild(imageElem);
			var imageTagPreifix = u.innerHTML.toString().split('>')[0]+" ";
			var onclickEvent = "onclick='closePopup2();' />";
			u.innerHTML = imageTagPreifix+onclickEvent;
		}
		else
		{
			u.innerHTML = '';
			u.innerHTML = closeParameter;
		}
	}
	//InitDragDrop();
}

function closePopupX() {
	parent.document.getElementById("frame").src="about:blank";
	parent.document.getElementById('floatingDiv').style.display='none'; 
	parent.document.getElementById('transParentDiv').style.display='none'; 
	parent.document.getElementById('backDrop').style.display='none';
	
	var img =  document.getElementById('preloader');
	var myWidth = 0, myHeight = 0;
	if( typeof( window.innerWidth ) == 'number' )
	{
		//Non-IE
		myWidth = window.innerWidth;
		myHeight = window.innerHeight;
	}
	else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) )
	{
		//IE 6+ in 'standards compliant mode'
		myWidth = document.documentElement.clientWidth;
		myHeight = document.documentElement.clientHeight;
	}
	else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) )
	{
		//IE 4 compatible
		myWidth = document.body.clientWidth;
		myHeight = document.body.clientHeight;
	}
	  
	myWidth = (myWidth/2) - (img.width/2);
	myHeight = (myHeight/2) - (img.height/2);
	
	parent.document.getElementById('loader').style.display="block";
	
	img.style.left = myWidth+"px";
	img.style.top = myHeight+"px";
	
	var flag = true;
	var pageHeight = parent.document.getElementById('pageT').offsetHeight
	parent.document.getElementById('transParentDocDiv').style.height=parseInt(pageHeight)+'px';
	parent.document.getElementById('transParentDocDiv').style.display='block';
	parent.reRenderPanel();
	return true;
}

function closePopupTB(){
	parent.document.getElementById("frame").src="about:blank";
	var bd = document.getElementById("backDrop");
	bd.style.display = "none";
	var k = document.getElementById("transParentDiv");
	k.style.display = "none";
	var d = document.getElementById("floatingDiv");
	d.style.display = "none";
	var e = document.getElementById("ALMore");
	e.style.display = "none";
	var f = document.getElementById("ALMore1");
	f.style.display = "none";
	var f = document.getElementById("ALMore2");
	f.style.display = "none";
	var f = document.getElementById("ALMore3");
	f.style.display = "none";
	
	var actionId = document.getElementById("actionIdHiddenForm:actionIdHidden").value;
	if(actionId == 1 || actionId == 2 || actionId == 3 || actionId == 4 || actionId == 9) {
		change();
		parent.reRenderPanel();
	}	
}

function setMsg(cnt, text) {
	var referenceName = document.getElementById('referenceName_'+cnt);
	var indexOfColon = text.indexOf(':', 0);
	var leftPart = text.substring(0, indexOfColon-1);
	var rightPart = text.substring(indexOfColon, text.length);
	var name = leftPart.substring(3, leftPart.length);	
}

function showPopupDivRespectToElement(elemID, divToPopupId, index, scrollTop) {	
	var iframe = document.getElementById("frame");
	var content = (iframe.contentWindow || iframe.contentDocument);
	
	content.document.getElementById('addToListLoader').style.display = 'none';
	var objElem = content.document.getElementById(elemID);
	var objDiv = document.getElementById(divToPopupId + index);
	
	objDiv.style.display = 'block';
	objDiv.style.top = top(objElem) + 260 - scrollTop + 'px';
	objDiv.style.left = left(objElem) + 448 + 'px';		
	content.document.body.scrollTop = scrollTop;
}

function reRenderForAddToListPanel() {
	var iframe = document.getElementById("frame");
	var content = (iframe.contentWindow || iframe.contentDocument);
	content.document.getElementById('addToListLoader').style.display = 'none';
	//content.renderAddToListPanel();
	callerForRenderScript();
}

function setDynamicLoaderDivStyleForAddToList() {
	var iframe = document.getElementById("frame");
	var content = (iframe.contentWindow || iframe.contentDocument);
	
	var loadingDiv = content.document.getElementById('addToListLoader');
	var floatingDiv = document.getElementById('floatingDiv');
	
	var height = content.document.getElementById('popupDiv').offsetHeight;
    var width = content.document.getElementById('popupDiv').offsetWidth;
	
    loadingDiv.style.height = height+'px';
    loadingDiv.style.width = width+'px';
    loadingDiv.style.display = 'block';
}

var scrollTop = 0;

function callerForRendererOfUserList(elemID, divToPopupId, index) {
	parent.renderUserListPanel(elemID, divToPopupId, index, scrollTop);
}

function setLoaderDivStyle(divObj) {	
	var height = document.getElementById('popupDiv').offsetHeight;
    var width = document.getElementById('popupDiv').offsetWidth;
    
    divObj.style.height = height+'px';
    divObj.style.width = width+'px';
    divObj.style.display='block';	
    
    var iframe = parent.document.getElementById("frame");
	var content = (iframe.contentWindow || iframe.contentDocument);	
	scrollTop = content.document.body.scrollTop;
}

function callerForRenderScript() {	
	var iframe = document.getElementById("frame");
	var content = (iframe.contentWindow || iframe.contentDocument);
	content.renderScript();
}


function keyWordValidator(value, enableButtonId, disableButtonId) {
	if(value.split(',').length > 10) {
		document.getElementById(enableButtonId).style.display = 'none';
		document.getElementById(disableButtonId).style.display = 'block';
	} else {
		document.getElementById(enableButtonId).style.display = 'block';
		document.getElementById(disableButtonId).style.display = 'none';
	}
}

/************************ tapasb *************************/
