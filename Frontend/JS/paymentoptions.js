// Extract the bookingId from the URL query string
const urlParams = new URLSearchParams(window.location.search);
const bookingId = urlParams.get('bookingId');
if (bookingId) {
    
    document.getElementById('creditCardButton').addEventListener('click', function() {
        window.location.href = `http://127.0.0.1:5500/HTML/creditCardPayment.html?bookingId=${bookingId}`;
    });
}
if (bookingId) {
    
    document.getElementById('debitCardButton').addEventListener('click', function() {
        window.location.href = `http://127.0.0.1:5500/HTML/debitCardPayment.html?bookingId=${bookingId}`;
    });
 
}


window.onload = function() {
    // Extract the bookingId from the URL query string
    const urlParams = new URLSearchParams(window.location.search);
    const bookingId = urlParams.get('bookingId');  
    
    if (bookingId) {
        // Make a GET request to the backend to fetch the booking details by bookingId
        fetch(`http://localhost:8080/booking/${bookingId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Booking not found');
                }
                return response.json();
            })
            .then(data => {
                console.log('Booking details:', data); 

                // Retrieve the fare from the response
                const fare = data.fare;

                // Display the fare on the page
                document.getElementById('fared').innerText = `${fare} `;
            })
            .catch(error => {
                console.error('Error fetching booking details:', error);
                alert('Could not retrieve booking details');
            });
    } else {
        console.error('Booking ID not found in the URL');
        alert('Invalid booking ID');
    }
};


