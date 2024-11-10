document.getElementById('FormCreditCardDetails').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission
    
    // Extract the bookingId from the URL (query string)
    const urlParams = new URLSearchParams(window.location.search);
    const bookingId = urlParams.get('bookingId');

    // Create the form data object
    var formData = new FormData(this);
    
    // If bookingId is found, add it to the formData object
    if (bookingId) {
         
        formData.append('bookingId', bookingId);
            // Get the credit card button and add an event listener for the click
   
      
    }


    // Convert formData to a plain JavaScript object
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });

    // Convert the JavaScript object to JSON
    var jsonData = JSON.stringify(dataObject);

    // Send the data to the backend
    fetch('http://localhost:8080/creditcardpayment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
    .then(response => response.text()) // Assume server returns plain text
    .then(data => {
        if(data){
            document.getElementById('confirm').addEventListener('click', function() {
                // Redirect to the credit card payment page with the bookingId as a query parameter
                window.location.href = `QRcode.html?bookingId=${bookingId}`;
            });
        }
        console.log('Success:', data);
        // Redirect to success page
       // window.location.href = 'QRcode.html';
       
    })
    .catch((error) => {
        console.error('Error:', error);
        // Optionally, handle errors or show an error message
    });
});
