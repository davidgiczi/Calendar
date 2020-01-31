
document.getElementById("add").addEventListener("click", addInputField);
document.getElementById("add").addEventListener("click", addDataToFields);
document.getElementById("add").addEventListener("click", disabledButtons);
document.getElementById("gen").addEventListener("click", sendInputData);
document.getElementById("inyear").addEventListener("blur", validate);
document.getElementsByName("inputmonth")[0].addEventListener("change", validate);

var eventnumber = 1;

var eventstring;

var row = "";

var inputdatastring = "";

var inputs = [];


function addInputField() {

    document.getElementById("txt").innerHTML = "";

    eventstring = "<h3 style='color: grey'>" + eventnumber + ". esemény neve:</h3>" +
            "<input name='"+eventnumber+"event' id='"+eventnumber+"e' value='' type='text' size='30'>" +
            "<h3 style='color: grey'>Az esemény napja:</h3>" +
            "<input name='"+eventnumber+"date' id='"+eventnumber+"d' onblur='validate()' value='' type='number' min='1' max='31'>";
     
    row = row.concat(eventstring);

    document.getElementById("events").innerHTML = row;
      
    eventnumber++;
       
}

function validate() {
    
   concatEventsAndDates();
   sendDataForValidation(inputdatastring);
  
    
}

function concatEventsAndDates() {
    
    inputdatastring = "";
    inputs = [];
    
    for( var i = 1; i < eventnumber; i++) {
       
       var event = document.getElementById(i+"e").value;
       var date = document.getElementById(i+"d").value;
      
       inputs.push(event);
       inputs.push(date);
      
      inputdatastring = inputdatastring.concat(event+","+date+",");
   
  }
    
    concatYearAndMonth();
   
}
function concatYearAndMonth() {
    
  var year = document.getElementById("inyear").value;
  var month = document.getElementsByName("inputmonth")[0].value;
    
  inputdatastring = inputdatastring.concat(year+","+month);
    
}

function addDataToFields() {
    
    var id = 1;
    
    for( var i = 0 ; i < inputs.length ; i++) {
        
       if( i%2 === 0  ) {
           
          document.getElementById(id+"e").value = inputs[i];
         
       }
      else {
          
         document.getElementById(id+"d").value = inputs[i];
         id++;
      }
        
    }
}

function disabledButtons() {
    
    document.getElementById("add").disabled = true;
    document.getElementById("gen").disabled = true;
   
}


function sendInputData() {
   
    document.getElementById("inputdata").submit();

}

function sendDataForValidation(data) {

    var xmlHTTP = new XMLHttpRequest();

    xmlHTTP.onreadystatechange = function () {

        if (xmlHTTP.readyState === 4 && xmlHTTP.status === 200) {

            var response = xmlHTTP.responseText;
            
            document.getElementById("inf").innerHTML = response;  
            
            
            if (response === "") {
                
                document.getElementById("gen").disabled = false;
                document.getElementById("add").disabled = false;
                
            } else {
                
                document.getElementById("gen").disabled = true;
                document.getElementById("add").disabled = true;
                
            }

        }

    };

    var url = document.location.protocol + "//" + document.location.host +
            document.location.pathname + "validate?data=" + data;


    xmlHTTP.open("GET", url, true);
    xmlHTTP.send();

}

