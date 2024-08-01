document.getElementById('FormCreditCardDetails').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    var formData = new FormData(this);
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });
    var jsonData = JSON.stringify(dataObject);

    fetch('http://localhost:8080/ccPayment', {
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
        window.location.href = 'TicketBooked.html';
    })
    .catch((error) => {
        console.error('Error:', error);
        // Optionally, handle errors or show an error message
    });
});
