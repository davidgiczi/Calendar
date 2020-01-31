
package com.david.giczi.calendar.model;

import com.david.giczi.calendar.exceptions.NoSuchMonthException;
import com.david.giczi.calendar.utils.MonthName;
import java.util.Calendar;
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
    
   public static boolean isMonthDayNumberValid(String inputDay, String inputYear, String inputMonth) {
       
       int day;
       
       MonthName month = MonthName.getMonthNameByIndex(Integer.parseInt(inputMonth));
       int year = Integer.parseInt(inputYear);
       
        try{
            
            if(inputDay.length() > 2 ) {
                
                throw new NumberFormatException();
                
            }
            
            day = Integer.parseInt(inputDay);
            
            if( 0 >= day) {
                
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
    
   
   public static boolean isEasterValid(String event, int year, int month, int day){
       
       if( event.toLowerCase().startsWith( "húsvét" ) ) {
           
           if( MonthName.getMonthNameByIndex(month) != MonthName.MAR || 
                   MonthName.getMonthNameByIndex(month) != MonthName.APR ) {
                   
               return false;
       }
       
           
      if( new GregorianCalendar(year, month, day).get(Calendar.DAY_OF_WEEK) != 2 ){
          
            return false;
      }   
  
   }   
   
   return true;
}

   
   
   
}