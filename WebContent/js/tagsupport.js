
/*	
 * Menu Tag
 * Functions for Menu Tag 
 * */

var menus = [];

function Menu(){
	this.value = "";
	this.label = "";
}

function toggleList(x) {
	var ele = document.getElementById( x + '_list' );
	var eleI = document.getElementById( x + '_init' );
	if(eleI.value == ''){
		setClosure(x);
		eleI.value = x + '_initiated';
		menus[x + '_hidden'] = new Menu();
	}
	
	if(ele.style.display == "block") {ele.style.display = "none";}
	else {ele.style.display = "block"; }
} 

function selectMe(selectedLabel, selectedValue, x){

	if(document.getElementById(x + '_hidden').value == selectedValue){}
	else{
		document.getElementById(x + '_main').innerHTML = selectedLabel;
		document.getElementById(x + '_hidden').value = selectedValue;
		if(document.getElementById(x + '_param')){
			document.getElementById(x + '_param').value = selectedValue;
		}
		menus[x + '_hidden'].value = selectedValue;
		menus[x + '_hidden'].label = selectedLabel;
		
		document.getElementById(x + '_hidden').onchange();
	}
	
	toggleList(x);
}

function setClosure(x){

	jQuery(document.body).bind('click',function(e) {
		var ele = document.getElementById( x + '_list' );
		if(e.target.id){
			if(e.target.id != (x + '_main'))
			{
				ele.style.display = "none";
			}
		}else{
			ele.style.display = "none";
		}
	});	
}