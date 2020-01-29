
package com.david.giczi.calendar.model;

import com.david.giczi.calendar.exceptions.NoSuchMonthException;
import com.david.giczi.calendar.utils.MonthName;
import java.util.GregorianCalendar;

/**
 *
 * @author GicziD
 */
public class Validate {
    
    
    public static boolean isYearValid(String inputData) {
        
        int year;
        
        try{
            
            if(inputData.length() != 4 ) {
                throw new NumberFormatException();
            }
            
            year = Integer.parseInt(inputData);
            
        }catch(NumberFormatException e){
            
            return false;
        }
        
        return year>=1582;
        
     
    }
    
   public static boolean isMonthDayNumberValid(String inputData, MonthName month, int year) {
       
       int day;
       
        try{
            
            if(inputData.length() > 2 ) {
                
                throw new NumberFormatException();
                
            }
            
            day = Integer.parseInt(inputData);
            
            if( 0 > day) {
                
                 throw new NumberFormatException();
            }
            
        }catch(NumberFormatException e){
            
            return false;
        }
       
        switch(month){
            
            case JAN :
            case MAR :
            case MAY :
            case JUL :
            case AUG :
            case OCT :
            case DEC :
                
           return 32 > day;
                
            case FEB :
          
              return  new GregorianCalendar().isLeapYear(year) ?  30 > day : 29 > day ;
            
            case APR :
            case JUN :
            case SEP :
            case NOV :
                
            return 31 > day;
                
            
            default:
                
                throw new NoSuchMonthException();
                    
        }
   } 
    
}
