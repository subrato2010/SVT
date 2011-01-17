// $Author: neelamadhabm $
package com.edifixio.soc.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * superclass for all svt exceptions so we don't create inter-dependencies on underlying frameworks throughout our code. Feel encouraged
 * to sub-class as appropriate
 * 
 * @author Subrato
 */
@SuppressWarnings("serial")
public class SVTException extends Exception
{
   @SuppressWarnings("unused")
   private static final Log log = LogFactory.getLog(SVTException.class);
   private Throwable throwable = null; // the root causing exception

   public SVTException(Throwable t)
   {
      if (t != this) {
         this.setException(t);
      }
      if (t != null) {
         log.error(t.getMessage());
         t.printStackTrace();
      }
   }

   /**
    * Constructs an instance of <code>Exception</code> with the specified detail message.
    * 
    * @param msg
    *           the detail message.
    */
   public SVTException(String msg)
   {
      super(msg);
   }

   private void setException(Throwable t)
   {
      setThrowable(t);
   }

   public void setThrowable(Throwable t)
   {
      throwable = t;
   }

   public Throwable getException()
   {
      return getThrowable();
   }

   public Throwable getThrowable()
   {
      return throwable;
   }

   @Override
   public void printStackTrace()
   {
      if (getException() != null)
         getException().printStackTrace();
      else
         super.printStackTrace();
   }

   @Override
   public StackTraceElement[] getStackTrace()
   {
      if (getException() != null)
         return getException().getStackTrace();
      return super.getStackTrace();
   }
   
   @Override
   public String getMessage()
   {
      if (getException() != null)
         return getException().getMessage();
      else
         return super.getMessage();
   }
}
