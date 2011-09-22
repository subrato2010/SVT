var curDt = new Date();
	var divisable = 86400000;  // hr*miniute*second*1000 (24*60*60*1000)
//	var enable = #{menuController.dateRangeBean.enable};
     


	function calenderForm(day)
	{
	
      	var bfrdt = '';
    	var afterDt = '';
   
    	return disablementFunction(day , bfrdt , afterDt);
	}
	
	function calenderTo(day)
	{
	
      	var bfrdt = '';
    	var afterDt = '';
   
    	return disablementFunction(day , bfrdt , afterDt);
	}
        function disablementFunction(day , bfrdt , afterDt)
        {
        	// If user wants to enable all the previous and future dates then put bfrdt = '' and afterDt = ''
    		// If user wants to disable all the previous dates and future dates then put bfrdt = '0' and afterDt = '0'
    		// If user wants to enable selected previous dates and enable selected future dates then put bfrdt = 'value' and afterDt = 'value'
    		
    		
        	var enable = true;
        	         
        	if(bfrdt == '')
        	{
        		enable = false;
        	}
            // if the user want to disable the weekend then set the value false
            if (day.isWeekend)
            { 
             //    return false;
            }
             if (curDt==undefined)
             {
                curDt = day.date.getDate;
             }
        	if(enable)
        	{
            	
	       		if((curDt.getTime()/divisable) - (day.date.getTime()/divisable) < bfrdt )  
	            { 
		           
	       			if(afterDt == '')
	       			{
		       			return true;
	       			}
	       			
	       			if((day.date.getTime()/divisable) - (curDt.getTime()/divisable) < afterDt)
	                {
	                	return true;
	              	}
		         		            
	            } 
	      //      else if(curDt.getDate() - day.date.getDate()== 0)
	       		else if((curDt.getTime()/divisable) - (day.date.getTime()/divisable) == 0)
	            {
	                
	            	return true;
	             }
	          
	            else
	            { 
	                return false;  
	            }
        	}
        	
            // if user not interested to disable prev dates
            else
            {
         
            	if(afterDt == '')
       			{
	       			return true;
       			}
       			
       			if((day.date.getTime()/divisable) - (curDt.getTime()/divisable) < afterDt)
                {
                	return true;
              	}
	            	      
	            if(curDt.getDate() - day.date.getDate()== 0)
	            {
	                
	            	return true;
	             }
	          
	            else
	            { 
	                return false;  
	            }
            }
            
        }
