function generateQR(){
	
	var bookingName = document.getElementById('name').value;
	var bookingPhone = document.getElementById('phone').value;
    var bookingFrom = document.getElementById('from');
	var bookingFromText=bookingFrom.options[bookingFrom.selectedIndex].text; // This will take the value from the select options list.
    var bookingTo = document.getElementById('to');
	var bookingToText=bookingTo .options[bookingTo .selectedIndex].text;
    var bookingDate = document.getElementById('date').value;

	// Phone Number Validation
	var phonevalid =document.forms['booking']['phone'].value;
	if(phonevalid>10) {
		alert("Enter the phone number correctly");
	 
	}
	else if(phonevalid<10){
	 alert("Enter the phone number correctly");
	}   
	// Stores the Date in local storage

	localStorage.setItem('NAME',bookingName)
	localStorage.setItem('PHONE',bookingPhone)
	localStorage.setItem('FROM',bookingFromText)
	localStorage.setItem('TO',bookingToText)
	localStorage.setItem("DATE",bookingDate)
	
    return ;

}
function bookingId(){
	var bookingId = Math.floor(Math.random() * 100000000 + 1);
	document.getElementById('id').innerHTML = bookingId;
	//localStorage.setItem("BOOKINGID", bookingId);
}

function farecal(){
	// const fromFare = document.getElementById("from");
	const toFare =document.getElementById("to");
    // const getFromValue =fromFare.options[fromFare.selectedIndex].value;
	const getToValue =toFare.options[toFare.selectedIndex].value;
    // const total=getFromValue+getToValue;
    document.getElementById('fare').innerHTML=getToValue;
	localStorage.setItem('FARE',getToValue)
}



