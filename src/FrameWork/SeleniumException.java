package FrameWork;

import java.util.Calendar;

/**
 * Created by Vijeet on 11-02-2017.
 */
public class SeleniumException extends Exception {

    public SeleniumException(String s){
        super(s);
    }
    public SeleniumException (){
    }
     public String toString(){

         String s = "Exception encountered : "+ getMessage();
         s+="\nTime : "+ Calendar.getInstance().getTime()+"\nAt:-";
         int i =0;
         for (StackTraceElement st : getStackTrace())
         {
             i++;
             s+="\nClass : " + st.getClassName();
             s+="\nMethod : " +  st.getMethodName();
             s+="\nLine : " + st.getLineNumber();
             if (i==1)
                 s+="\nCalled from:-";
             else if (i==2){
                 break;
             }
         }
         return s;
     }
}
