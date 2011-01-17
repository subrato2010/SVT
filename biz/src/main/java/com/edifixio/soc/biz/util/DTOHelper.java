package com.edifixio.soc.biz.util;

import java.text.DecimalFormat;

public class DTOHelper {
    private String formatDouble = "#.###";
    
    public double getDoubleNumber(double number) {
        DecimalFormat twoDForm = new DecimalFormat(formatDouble);
        return Double.valueOf(twoDForm.format(Math.abs(number)));
    }

    public String getDoubleFormatedAsString(double number){
        int integerPart = (int) number;
        double decimalPart = number - integerPart;
        //TODO
        return (decimalPart==0)?("" + integerPart):("" +number);
    }
}
