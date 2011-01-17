package com.edifixio.soc.ws.common;

public class BaseWebServiceIO {

    protected void copyArray(Object[] old, Object[] newArr)
    {
       for (int i = 0; i < old.length; i++) {
          newArr[i] = old[i];
       }
    }
    protected boolean addObjectToArray(Object[] arr, Object o)
    {
       boolean added = false;
       for (int i = 0; i < arr.length; i++) {
          if (arr[i] == null) {
             arr[i] = o;
             return true;
          }
       }
       return added;
    }

}
