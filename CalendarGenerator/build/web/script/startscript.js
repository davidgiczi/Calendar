
document.getElementById("add").addEventListener("click", addInputField);
document.getElementById("gen").addEventListener("click", sendInputData);
document.getElementById("inyear").addEventListener("blur", function () {

    sendDataForValidation(document.getElementById("inyear").value);

});

var eventnumber = 1;

var eventstring;

var row = "";

var eventstext=[];

function addInputField() {

    document.getElementById("txt").innerHTML = "";

    eventstring = "<h3 style='color: grey'>" + eventnumber + ". esemény neve:</h3>" +
            "<input type='text' size='30'>" +
            "<h3 style='color: grey'>Az esemény napja:</h3>" +
            "<input type='number' min='1' max='31'>";
     
    row = row.concat(eventstring);

    document.getElementById("events").innerHTML = row;
     
    eventnumber++;
}

function sendInputData() {

    document.getElementById("inputdata").submit();


}

function sendDataForValidation(data) {

    var xmlHTTP = new XMLHttpRequest();

    xmlHTTP.onreadystatechange = function () {

        if (xmlHTTP.readyState === 4 && xmlHTTP.status === 200) {

            if (xmlHTTP.responseText === "true") {

                document.getElementById("yearinf").innerHTML = "";
                document.getElementById("gen").disabled = false;
                
            } else {

                document.getElementById("yearinf").innerHTML = "Csak szám lehet az évszám adat és 1581 < értéke < 10000.";
                document.getElementById("gen").disabled = true;
            }

        }

    };

    var url = document.location.protocol + "//" + document.location.host +
            document.location.pathname + "validate?y=" + data;


    xmlHTTP.open("GET", url, true);
    xmlHTTP.send();

}