
package com.david.giczi.calendar.model;

import com.david.giczi.calendar.exceptions.NoSuchMonthException;
import com.david.giczi.calendar.utils.MonthName;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author GicziD
 */
public class OrganizingMonthDataForView {
    
    private final MonthName monthName;
    private final List<Day> days;
    private final int year;
    private final List<Integer> dayNumberOfMonth;
    private final List<String>  dayColorOfMonth;
    private final List<String>  namedaysOfMonth;
    private final List<String>  holidaysOfMonth;
    private int numberOfRows;
   

    public OrganizingMonthDataForView(List<Day> days, int year, MonthName monthName) {
        
        this.days = days;
        this.year = year;
        this.monthName = monthName;
        
        dayNumberOfMonth = new ArrayList<>();
        dayColorOfMonth = new ArrayList<>();
        namedaysOfMonth = new ArrayList<>();
        holidaysOfMonth = new ArrayList<>();
        
       createViewLists();
    }

    public List<Integer> getDayNumberOfMonth() {
        return dayNumberOfMonth;
    }

    public List<String> getDayColorOfMonth() {
        return dayColorOfMonth;
    }

    public List<String> getNamedaysOfMonth() {
        return namedaysOfMonth;
    }

    public List<String> getHolidaysOfMonth() {
        return holidaysOfMonth;
    }

    public int getYear() {
        return year;
    }

    public List<Day> getDays() {
        return days;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }
    
     
    public String getNameOfMonth() {
        
        switch(monthName) {
            
            case JAN :
                
                return "Január";
            
             case FEB :
                
                return "Február";
                
             case MAR :
                
                return "Március";
                
             case APR :
                
                return "Április";
                
             case MAY :
                
                return "Május";
                
             case JUN :
                
                return "Június";   
             
             case JUL :
                
                return "Július";
                
             case AUG :
                
                return "Augusztus";
             
              case SEP :
                
                return "Szeptember";
             
              case OCT :
                
                return "Október";
                
              case NOV :
                
                return "November";
                
              case DEC :
                
                return "December";
                
             default:
                 
                 throw new NoSuchMonthException();
        }
        
    }
    
    
    private int getPreviousMonthDaysNumber() {
        
        switch( monthName ) {
           
            case MAR : 
                
                if( new GregorianCalendar().isLeapYear(year) ) {
                    return 29;
                }
                else {
                    return 28;
                }
            
            case JAN :
            case FEB : 
            case APR : 
            case JUN :
            case AUG : 
            case SEP :
            case NOV : return 31;
           
            case MAY : 
            case JUL : 
            case OCT :
            case DEC : return 30;
            
            default:
                throw new NoSuchMonthException();
        }
           
    }
    
       
    
    private void createTheEndOfThePreviousMonthElementsForViewLists(){
        
        
        int dayOfWeek = days.get(0).getDayOfWeek();
        
        
        switch(dayOfWeek){
            
            case 1 :
            
           for(int i = getPreviousMonthDaysNumber()-5 ; i <= getPreviousMonthDaysNumber(); i++) {
               
              
               
               dayNumberOfMonth.add(i);
               dayColorOfMonth.add("grey");
               namedaysOfMonth.add("");
               holidaysOfMonth.add("");
           }
                
            break;  
             
            case 3 :
                
           for(int i = getPreviousMonthDaysNumber() ; i <= getPreviousMonthDaysNumber(); i++) {
               
               dayNumberOfMonth.add(i);
               dayColorOfMonth.add("grey");
               namedaysOfMonth.add("");
               holidaysOfMonth.add("");
               
           }
                
            break; 
            
            case 4 :
                
           for(int i = getPreviousMonthDaysNumber()-1 ; i <= getPreviousMonthDaysNumber(); i++) {
                
               dayNumberOfMonth.add(i);
               dayColorOfMonth.add("grey");
               namedaysOfMonth.add("");
               holidaysOfMonth.add("");
               
           }
                
            break; 
            
            case 5 :
                
           for(int i = getPreviousMonthDaysNumber()-2 ; i <= getPreviousMonthDaysNumber(); i++) {
               
               dayNumberOfMonth.add(i);
               dayColorOfMonth.add("grey");
               namedaysOfMonth.add("");
               holidaysOfMonth.add("");
               
           }
                
            break; 
            
            case 6 :
                
          for(int i = getPreviousMonthDaysNumber()-3 ; i <= getPreviousMonthDaysNumber(); i++) {
               
               dayNumberOfMonth.add(i);
               dayColorOfMonth.add("grey");
               namedaysOfMonth.add("");
               holidaysOfMonth.add("");
               
           }
                
            break;
            
            case 7 :
                
            for(int i = getPreviousMonthDaysNumber()-4 ; i <= getPreviousMonthDaysNumber(); i++) {
               
               dayNumberOfMonth.add(i);
               dayColorOfMonth.add("grey");
               namedaysOfMonth.add("");
               holidaysOfMonth.add("");
           }
                
           
        }
        
    }
    
   private void createTheMonthElementsForViewLists(){
       
      
       for ( int i = 1; i <= days.size(); i++){
           
           dayNumberOfMonth.add(i);
           namedaysOfMonth.add(days.get(i-1).getNames());
           holidaysOfMonth.add(days.get(i-1).getHolidayName());
           
           if( days.get(i-1).getDayOfWeek() == 1 ) {
               
               dayColorOfMonth.add("red");
                
           }
           else if( days.get(i-1).getDayOfWeek() != 1 && !"".equals( days.get(i-1).getHolidayName() )){
               
               dayColorOfMonth.add("red");
           }
           else {
               
                dayColorOfMonth.add("black");
           }
           
           
       }
         
   }
  
   private void createTheBeginOfTheNextMonthElementsForViewLists(){
       
       int sizeValue = 35-dayNumberOfMonth.size();
       
       
       if( dayNumberOfMonth.size() <= 35 ) {
       
       for( int i = 0 ; i < sizeValue; i++ ) {
           
           dayNumberOfMonth.add(i+1);
           dayColorOfMonth.add("grey");
           namedaysOfMonth.add("");
           holidaysOfMonth.add("");
       }
       
       numberOfRows = 4;
       
    }   
       else {
           
       for( int i = 0 ; i < 7 + sizeValue; i++ ) {
           
           dayNumberOfMonth.add(i+1);
           dayColorOfMonth.add("grey");
           namedaysOfMonth.add("");
           holidaysOfMonth.add("");
       }
           
           
           numberOfRows = 5;
       }
       
   }
   
   private void createViewLists(){
       
        createTheEndOfThePreviousMonthElementsForViewLists();
        createTheMonthElementsForViewLists();
        createTheBeginOfTheNextMonthElementsForViewLists();
       
       
   }
   
}
