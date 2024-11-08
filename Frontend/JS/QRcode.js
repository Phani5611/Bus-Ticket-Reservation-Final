function qrgenerate(){

	// Getting the data from the local storage
	
var QRname = localStorage.getItem('NAME')
	var QRphone =localStorage.getItem('PHONE')
	var QRfrom =localStorage.getItem('FROM')
	var QRto =localStorage.getItem('TO')
    var QRdate =localStorage.getItem('DATE')
   
 console.log(QRname+QRphone+QRfrom+QRto+QRdate+bookingId)
var url = "https://chart.googleapis.com/chart?cht=qr&chs=200x200&chl=Name :"+ QRname + " " +"%0aPhone :" +QRphone+" "+"%0aFrom : "+QRfrom+" "+"%0aTo :"+ QRto +" "+"%0aDate And Time :"+QRdate +" "+ "%0aBooking ID :"+bookingId;

var ifr = `<iframe src="${url}" height="200" width="200"></iframe>`;

    document.getElementById('qrcode').innerHTML = ifr;
}
function cancellation(){
   let a = confirm("Are you sure to cancel the ticket ?")
   if(a==true){
	return window.location.href='cancel.html';
   }
   else{
	return false;
   }
	
}