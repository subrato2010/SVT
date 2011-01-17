package com.edifixio.soc.biz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    
    private static final String DB_DATE_FORMAT = "EEE, dd MMM yyyy hh:mm:ss";   //Fri, 31 Jul 2009 16:41:10
    private static final String ROI_DATE_FORMAT = "MM/dd/yyyy";
   
    private static SimpleDateFormat format = new SimpleDateFormat(DB_DATE_FORMAT);
    private static SimpleDateFormat ROIFormat = new SimpleDateFormat(ROI_DATE_FORMAT);
    
    public static Date getDate(String date){
        
       Date dt = null;
       
       try {
           dt = format.parse(date); 
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return dt;
    }
    
    public static String getDate(Date date){
        String dt = null;
        if(date == null)
            return dt;
       
        dt = format.format(date);
        return dt;
    }
    
    public static Ago getTimeAgo(Date date)
    {System.out.println(date);
      Ago ago = new Ago();
     
      long dateInMillis = date.getTime();
      long currentTimeInMillis = System.currentTimeMillis();
      
      long diff = currentTimeInMillis - dateInMillis;
      //months
     
          int months = (int)(diff/(30.00 * 24.00 * 60.00 * 60.00 * 1000.00));
          if (months > 0){
              ago.setMonths(months);
              diff = diff % (30 *24 * 60 * 60 * 1000);
          }
      //days
          int days = (int)(diff/(24.00 * 60.00 * 60.00 * 1000.00));
          if (days > 0){
              ago.setDays(days);
              diff = diff % (24 * 60 * 60 * 1000);
          }
      //hours
          int hours = (int)(diff/( 60.00 * 60.00 * 1000.00));
          if (hours > 0){
             ago.setHours(hours);
              diff = diff % (60 * 60 * 1000);
          }
    //minutes
          int minutes = (int)(diff/(60.00 * 1000.00));
          if (minutes > 0){
             ago.setMinutes(minutes);
              diff = diff % (60 * 1000);
          }   
       
    //seconds
          int seconds = (int)(diff/(1000.00));
          if (seconds > 0){
              ago.setSeconds(seconds);
              diff = diff % (1000);
          }  

      return ago;
    }

    public static class Ago{
        private int months;
        private int days;
        private int hours;
        private int minutes;
        private int seconds;
        
        public int getMonths() {
            return months;
        }
        public void setMonths(int months) {
            this.months = months;
        }
        public int getDays() {
            return days;
        }
        public void setDays(int days) {
            this.days = days;
        }
        public int getHours() {
            return hours;
        }
        public void setHours(int hours) {
            this.hours = hours;
        }
        public int getMinutes() {
            return minutes;
        }
        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }
        public int getSeconds() {
            return seconds;
        }
        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }
        
    }
    
    public static String getROIDate(Date date){
        String strDate = null;
        try{
            strDate = ROIFormat.format(date);
        }catch(Exception e ){
            e.printStackTrace();
        }
        return strDate;
    }
}
