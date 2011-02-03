package com.edifixio.soc.web.controllers;

import com.edifixio.soc.common.SVTException;

public class GradeList extends BaseWebObject{
    public String calculateColor(String yourGrade, String compititors)
    {
//        char gradeArr[] = yourGrade.toCharArray();
//        char compArr[] = compititors.toCharArray();
        if(yourGrade == null){
            yourGrade="";
        }
        if(compititors == null){
            compititors="";
        }
        float gradeVal=0,compVal=0;
        //for yourGrade
        if(yourGrade.equals("A+"))  gradeVal = A_POSITIVE;
        else if((yourGrade.equals("A")))  gradeVal = A;
        else if(yourGrade.equals("A-"))  gradeVal = A_NEGATIVE;
        
        if(yourGrade.equals("B+"))  gradeVal = B_POSITIVE;
        else if(yourGrade.equals("B")) gradeVal = B;
        else if(yourGrade.equals("B-"))  gradeVal = B_NEGATIVE;
        
        if(yourGrade.equals("C+"))  gradeVal = C_POSITIVE;
        else if(yourGrade.equals("C"))  gradeVal = C;
        else if(yourGrade.equals("C-"))  gradeVal = C_NEGATIVE;
        
      //for CompititorVAlue
        if(compititors.equals("A+"))  compVal = A_POSITIVE;
        else if(compititors.equals("A"))  compVal = A;
        else if(compititors.equals("A-"))  compVal = A_NEGATIVE;
        
        if(compititors.equals("B+"))  compVal = B_POSITIVE;
        else if(compititors.equals("B"))  compVal = B;
        else if(compititors.equals("B-"))  compVal = B_NEGATIVE;
        
        if(compititors.equals("C+"))  compVal = C_POSITIVE;
        else if(compititors.equals("C"))  compVal = C;
        else if(compititors.equals("C-"))  compVal = C_NEGATIVE;
        
        
        if(compVal - gradeVal >= 1 )  
            return "#f26530";
        else if(compVal - gradeVal == -.5 || compVal - gradeVal == 0.0) 
            return "gray";
        else if(compVal - gradeVal == .5) 
        {
            return "gray";
            /*if(compArr[0] == gradeArr[0] && gradeArr.length==1)  return "gray";
            else if(gradeArr.length==2) return "#f26530";
            return "#f26530";*/
        }
        else return "green";
    }

    public static void main(String ar[]) throws SVTException {
        GradeList a = new GradeList();
    }
}
