
package com.david.giczi.calendar.model;

import com.david.giczi.calendar.interfaces.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author GicziD
 */
public class NameDaySearcher implements Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec{
    
     
    
    public static String searchNameDay(String nameDay, String inputYear) {
        
        if( "".equals( nameDay )){
            
            return "";
        }
        
        List<String> store = new ArrayList<>();
        int year = Integer.parseInt(inputYear);
        
       for( int i = 0; i < Jan.NAMES.length; i++ ) {
           
           if( Jan.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Január "+(i+1)+".");
           }
           
       }
       
      List<String> febNames = new ArrayList<>();
       
      Arrays.asList(Feb.NAMES).forEach( names -> febNames.add(names));
        
       if ( new GregorianCalendar().isLeapYear(year) ) {
          
          febNames.set(23, "Szökőnap");
          febNames.set(24, "Mátyás, Jázmin");
          febNames.set(25, "Géza, Cézár, Vanda");
          febNames.set(26, "Edina, Viktor, Győző");
          febNames.set(27, "Ákos, Bátor, Gábor");
          febNames.add("Elemér, Oszvald, Román");
          
          
           
       }
          
      for( int i = 0; i < febNames.size(); i++ ) {
           
           if( febNames.get(i).toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Február "+(i+1)+".");
           }
       
      }        
    
       for( int i = 0; i < Mar.NAMES.length; i++ ) {
           
           if( Mar.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Március "+(i+1)+".");
           }
           
       }
       
       for( int i = 0; i < Apr.NAMES.length; i++ ) {
           
           if( Apr.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Április "+(i+1)+".");
           }
           
       }
       
       
       for( int i = 0; i < May.NAMES.length; i++ ) {
           
           if( May.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Május "+(i+1)+".");
           }
           
       }
        
       for( int i = 0; i < Jun.NAMES.length; i++ ) {
           
           if( Jun.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Június "+(i+1)+".");
           }
           
       }
       
       
       for( int i = 0; i < Jul.NAMES.length; i++ ) {
           
           if( Jul.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Július "+(i+1)+".");
           }
           
       }
       
       for( int i = 0; i < Aug.NAMES.length; i++ ) {
           
           if( Aug.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Augusztus "+(i+1)+".");
           }
           
       }
       
       for( int i = 0; i < Sep.NAMES.length; i++ ) {
           
           if( Sep.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Szeptember "+(i+1)+".");
           }
           
       }
       
       for( int i = 0; i < Oct.NAMES.length; i++ ) {
           
           if( Oct.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("Október "+(i+1)+".");
           }
           
       }
       
       for( int i = 0; i < Nov.NAMES.length; i++ ) {
           
           if( Nov.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("November "+(i+1)+".");
           }
           
       }
       
       for( int i = 0; i < Dec.NAMES.length; i++ ) {
           
           if( Dec.NAMES[i].toLowerCase().contains( nameDay.toLowerCase() )) {
               
               store.add("December "+(i+1)+".");
           }
           
       }
       
     
                  
        return createResultString(nameDay, store);
    }
    
    private static String createResultString(String name, List<String> dates){
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(name).append(" névnapja:").append("<br><br>");
        
        
        if( dates.isEmpty() ){
            
           return builder.append("Nem található.").toString();
       }
           
        dates.forEach( date -> builder.append(date).append("<br>"));
        
        return builder.toString();
        
    }
    
}
