
document.getElementById("prev").addEventListener("click", getPreviousMonth);
document.getElementById("next").addEventListener("click", getNextMonth);

 var actualyear = parseInt( document.getElementById("actyear").value ) ;
 var actualmonth = document.getElementById("actmonth").value;
 var month;

function getDayNumberByName () {
    
    switch(actualmonth) {
        
        case "Január" :
        
        return 0;
        
        case "Február" :
            
        return 1;
        
        case "Március" :
        
        return 2;
        
        case "Április" :
            
        return 3;
        
        case "Május" :
        
        return 4;
        
        case "Június" :
            
        return 5;
        
        case "Július" :
        
        return 6;
        
        case "Augusztus" :
            
        return 7;
        
        case "Szeptember" :
            
        return 8;
        
        case "Október" :
        
        return 9;
        
        case "November" :
            
        return 10;
        
        case "December" :
            
        return 11;
        
    }
     
}

function getNextMonth() {
    
    
     month = getDayNumberByName();
    
    if( actualyear === 9999 && month === 11) {
        return;
    }
    
    if( month === 11 ) {
        
        month = 0;
        actualyear++;
        
    }
    else{
        
        month++;
        
    }
    
    sendData(); 
    
}

function getPreviousMonth() {
    
    month = getDayNumberByName();
    
    if( actualyear === 1582 && month === 0) {
        return;
    }
    
    if( month === 0 ) {
        
        month = 11;
        actualyear--;
        
    }
    else{
        
        month--;
        
    }
    
    sendData();
   
}

function sendData() {
    
   document.getElementById("actyear").value = actualyear;
   document.getElementById("actmonth").value = month;
     
   document.getElementById("stepper").submit(); 
    
}



