function openPopup(left, top, width, height, border, noheader, closable, scrollable, src)
{
	var d = document.getElementById("floatingDiv");
	var m = document.getElementById("innerMainDiv"); 
	var b = document.getElementById("popupCloseButton"); 
	var h = document.getElementById("popupHeader");
	var f = document.getElementById("frame");
	
	d.style.display = "block";
	d.style.left = left;
	d.style.top = top;
	d.style.width = width;
	d.style.height = height;
	
	m.style.width = width - (border*2);
	m.style.height = height - (border*2);
	m.style.marginLeft = border;
	m.style.marginTop = border;
	
	f.width = width - (border*2);
	
	if(noheader == true){
		h.style.display = "none";
		f.height = (height - (border*2))  
	}else{
		f.height = height - (border*2) - 44; //header = 44px
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(scrollable == true){
		f.scrolling ="yes";
	}
	
	f.src = src;
}
function closePopup(){
	var d = document.getElementById("floatingDiv");
	d.style.display = "none";
}





function openPopupAlert(left, top, width, height, border, noheader, closable, scrollable, src)
{
	var d = document.getElementById("floatingDiv1");
	var m = document.getElementById("innerMainDiv1"); 
	var b = document.getElementById("popupCloseButton1"); 
	var h = document.getElementById("popupHeader1");
	var f = document.getElementById("frame1");
	
	d.style.display = "block";
	d.style.left = left;
	d.style.top = top;
	d.style.width = width;
	d.style.height = height;
	
	m.style.width = width - (border*2);
	m.style.height = height - (border*2);
	m.style.marginLeft = border;
	m.style.marginTop = border;
	
	f.width = width - (border*2);
	
	if(noheader == true){
		h.style.display = "none";
		f.height = (height - (border*2))  
	}else{
		f.height = height - (border*2) - 44; //header = 44px
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(scrollable == true){
		f.scrolling ="yes";
	}
	
	f.src = src;
}
function closePopup(){
	var d = document.getElementById("floatingDiv1");
	d.style.display = "none";
}

function openPopupDM(left, top, width, height, border, noheader, closable, scrollable, src)
{
	var d = document.getElementById("floatingDivDM");
	var m = document.getElementById("innerMainDivDM"); 
	var b = document.getElementById("popupCloseButtonDM"); 
	var h = document.getElementById("popupHeaderDM");
	var f = document.getElementById("frameDM");
	
	d.style.display = "block";
	d.style.left = left;
	d.style.top = top;
	d.style.width = width;
	d.style.height = height;
	
	m.style.width = width - (border*2);
	m.style.height = height - (border*2);
	m.style.marginLeft = border;
	m.style.marginTop = border;
	
	f.width = width - (border*2);
	
	if(noheader == true){
		h.style.display = "none";
		f.height = (height - (border*2))  
	}else{
		f.height = height - (border*2) - 44; //header = 44px
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(scrollable == true){
		f.scrolling ="yes";
	}
	
	f.src = src;
}
function closePopup(){
	var d = document.getElementById("floatingDivDM");
	d.style.display = "none";
}



function openPopupRT(left, top, width, height, border, noheader, closable, scrollable, src)
{
	var d = document.getElementById("floatingDivRT");
	var m = document.getElementById("innerMainDivRT"); 
	var b = document.getElementById("popupCloseButtonRT"); 
	var h = document.getElementById("popupHeaderRT");
	var f = document.getElementById("frameRT");
	
	d.style.display = "block";
	d.style.left = left;
	d.style.top = top;
	d.style.width = width;
	d.style.height = height;
	
	m.style.width = width - (border*2);
	m.style.height = height - (border*2);
	m.style.marginLeft = border;
	m.style.marginTop = border;
	
	f.width = width - (border*2);
	
	if(noheader == true){
		h.style.display = "none";
		f.height = (height - (border*2))  
	}else{
		f.height = height - (border*2) - 44; //header = 44px
		if(closable != true){
			b.style.display = "none";
		}
	}
	if(scrollable == true){
		f.scrolling ="yes";
	}
	
	f.src = src;
}
function closePopup(){
	var d = document.getElementById("floatingDivRT");
	d.style.display = "none";
}