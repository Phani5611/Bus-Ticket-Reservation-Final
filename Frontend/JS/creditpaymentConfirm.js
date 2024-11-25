document.getElementById('FormCreditCardDetails').addEventListener('submit', function(event) {
    event.preventDefault();
    
    // Extract the bookingId from the URL (query string)
    const urlParams = new URLSearchParams(window.location.search);
    const bookingId = urlParams.get('bookingId');

    var formData = new FormData(this);

    // Append bookingId to formData if it's available
    if (bookingId) {
        formData.append('bookingId', bookingId);
    } else {
        alert("Booking ID is missing.");
        return; // Prevent further processing if bookingId is missing
    }

    // Get the current date and time
    const currentDate = new Date();
    const formattedDateTime = currentDate.toISOString();  // Format the date and time as ISO 8601 string

    // Append the current date and time to formData
    formData.append('dateAndTime', formattedDateTime);

    // Convert formData to a plain JavaScript object
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });

    // Convert the JavaScript object to JSON
    var jsonData = JSON.stringify(dataObject);

    // Send the data to the backend via fetch
    fetch('http://localhost:8080/creditcardpayment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
    .then(response => response.json()) // Parse the response as JSON
    .then(data => {
        // Handle the response status code
        switch (data.statusCode) {
            case 200: // Credit Card details saved successfully
                alert(data.message); // Display the message from the backend
                // Optionally, redirect to a new page using the bookingId
                window.location.href = `QRcode.html?bookingId=${data.bookingId}`;
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

            default: // Handle any other unexpected errors
                alert('Unexpected error: ' + data.message); // Use the message from the backend
                break;
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred while processing the payment. Please try again.');
    });
});
