document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault(); 

    // Get selected option from the boarding dropdown
    const boardingSelect = document.getElementById('boarding');
    const boardingOption = boardingSelect.options[boardingSelect.selectedIndex];  

    // Get selected option from the destination dropdown
    const destinationSelect = document.getElementById('destination');
    const destinationOption = destinationSelect.options[destinationSelect.selectedIndex];

    // Create an object to hold the form data
    const formData = {
        name: document.getElementById('name').value,
        phone: document.getElementById('phone').value,
        boarding_code: boardingSelect.value,
        boarding: boardingOption.text,
        destination_code: destinationSelect.value,
        destination: destinationOption.text,
        dateAndTime: document.getElementById('dateTimeInput').value,
    };
    fetch('http://localhost:8080/booking', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        return response.json(); // Parse the response as JSON
    })
    .then(data => {
    
      if (data.statusCode === 201) {
          const bookingId = data.bookingId;
          if (!bookingId || isNaN(bookingId)) {
              console.error('Invalid bookingId:', bookingId);
              alert('Invalid booking ID. Please try again.');
              return;  // Prevent redirect if bookingId is invalid
          }
          console.log('Booking ID:', bookingId, 'Message:', data.message);
          window.location.href = `PaymentOptionsPage.html?bookingId=${bookingId}`;
      } else {
          console.error('Booking failed:', data.message);
      }

    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred in saving booking details. Please try again later.');
    });
});    