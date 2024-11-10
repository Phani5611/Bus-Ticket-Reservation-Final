document.getElementById('debitCardPaymentDetails').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission
    
    // Extract the bookingId from the URL (query string)
    const urlParams = new URLSearchParams(window.location.search);
    const bookingId = urlParams.get('bookingId');

    
    var formData = new FormData(this);

    if (bookingId) {
        formData.append('bookingId', bookingId);
    } else {
        alert("Booking ID is missing.");
        return;
    }
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });

    var jsonData = JSON.stringify(dataObject);

   
    fetch('http://localhost:8080/debitcardpayment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
    .then(response => {
        console.log('Response Status:', response.status);
        
        // Check the response status code
        switch (response.status) {
            case 202: // Payment successful
                alert('Payment Successful!');
               
                window.location.href = `QRcode.html?bookingId=${bookingId}`;
                break;

            case 400: // Bad Request 
                alert('Bad Request. Please check your payment details and try again.');
                break;

            case 401: // Unauthorized 
                alert('Unauthorized. Please log in and try again.');
                break;

            case 404: // Not Found
                alert('Endpoint not found. Please try again later.');
                break;

            case 500: // Internal Server Error
                alert('Internal Server Error. Please try again later.');
                break;

            case 502: // Bad Gateway 
                alert('Bad Gateway. The server is down or unreachable.');
                break;

            default: 
                alert('Unexpected error: ' + response.statusText);
                break;
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while processing the payment. Please try again.');
    });
});
