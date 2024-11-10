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
        boarding_code: boardingSelect.value,  // The value of the selected boarding option
        boarding: boardingOption.text,       // The text of the selected boarding option
        destination_code: destinationSelect.value, // The value of the selected destination option
        destination: destinationOption.text,  // The text of the selected destination option
        dateandtime: document.getElementById('date').value,
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
        console.log('Backend Response:', data); 
    
        if (data) {
            const bookingId = data.bookingId;  
            console.log('Booking ID:', bookingId); 
            window.location.href = `PaymentOptionsPage.html?bookingId=${bookingId}`;
        } else {
            console.error('Booking failed:', data);
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});    