document.getElementById('debitCardPaymentDetails').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Create a FormData object from the form
    var formData = new FormData(this);

    // Convert FormData to a plain object
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });

    // Convert the plain object to JSON
    var jsonData = JSON.stringify(dataObject);

    // Perform the fetch request
    fetch('http://localhost:8080/debitcardpayment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
    .then(response => response.text()) // Assume server returns plain text
    .then(data => {
        console.log('Success:', data);
        // Redirect to success page
        window.location.href = 'QRcode.html';
    })
    .catch((error) => {
        console.error('Error:', error);
        // Optionally, handle errors or show an error message
    });
});
