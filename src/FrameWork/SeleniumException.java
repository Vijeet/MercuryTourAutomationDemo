package FrameWork;

import java.util.Calendar;

/**
 * Created by Vijeet on 11-02-2017.
 */
public class SeleniumException extends Exception {

    public SeleniumException (Exception e){
        System.out.println("Exception encountered : "+ e.getMessage());
        System.out.println("Time : "+ Calendar.getInstance().getTime()+"\nAt:-");
        int i =0;
        for (StackTraceElement st : e.getStackTrace())
        {
            i++;
            System.out.println("Class : " + st.getClassName());
            System.out.println("Method : " +  st.getMethodName());
            System.out.println("Line : " + st.getLineNumber());
            if (i==1)
                System.out.println("Called from:-");
            else if (i==2){
                break;
            }
        }
    }
}
