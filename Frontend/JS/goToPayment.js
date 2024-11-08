// This is your form submission handler
document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    // Create an object to hold the form data
    const formData = {
        name: document.getElementById('name').value,
        phone: document.getElementById('phone').value,
        boarding: document.getElementById('boarding').value,
        destination: document.getElementById('destination').value,
        dateandtime: document.getElementById('date').value
    };

    // Send the data to your Spring Boot backend
    fetch('http://localhost:8080/booking', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' // Set content type to JSON
        },
        body: JSON.stringify(formData) // Convert the form data to JSON
    })
    .then(response => response.json()) // Assuming your backend returns JSON
    .then(data => {
        console.log('Booking Details Saved Successfully', data);
        // Optionally, you can display a success message or redirect the user


          // Redirect to the payment page with the bookingId

          // Get the bookingId from the response
        const bookingId = data.bookingId; 

        // Redirect to payment page with bookingId
       window.location.href = `http://127.0.0.1:5500/HTML/PaymentOptionsPage.html?bookingId=${bookingId}`;
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
