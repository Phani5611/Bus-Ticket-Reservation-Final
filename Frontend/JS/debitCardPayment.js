document.getElementById('debitCardPaymentDetails').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission
    
    // Extract the bookingId from the URL (query string)
    const urlParams = new URLSearchParams(window.location.search);
    const bookingId = urlParams.get('bookingId');

    // Create the form data object
    var formData = new FormData(this);

    // If bookingId is found, add it to the formData object
    if (bookingId) {
        formData.append('bookingId', bookingId);
    } else {
        alert("Booking ID is missing.");
        return; // Stop the form submission if bookingId is not found
    }

    // Convert formData to a plain JavaScript object
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });

    // Convert the JavaScript object to JSON
    var jsonData = JSON.stringify(dataObject);

    // Send the data to the backend via fetch
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
                // Redirect to QRcode.html with bookingId as a query parameter
                window.location.href = `QRcode.html?bookingId=${bookingId}`;
                break;

            case 400: // Bad Request (Invalid data sent)
                alert('Bad Request. Please check your payment details and try again.');
                break;

            case 401: // Unauthorized (e.g., user not authenticated)
                alert('Unauthorized. Please log in and try again.');
                break;

            case 404: // Not Found (wrong endpoint)
                alert('Endpoint not found. Please try again later.');
                break;

            case 500: // Internal Server Error
                alert('Internal Server Error. Please try again later.');
                break;

            case 502: // Bad Gateway (server not responding properly)
                alert('Bad Gateway. The server is down or unreachable.');
                break;

            default: // Handle any other unexpected errors
                alert('Unexpected error: ' + response.statusText);
                break;
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while processing the payment. Please try again.');
    });
});
