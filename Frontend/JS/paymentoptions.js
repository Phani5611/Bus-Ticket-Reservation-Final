window.onload = function() {
    // Extract the bookingId from the URL query string
    const urlParams = new URLSearchParams(window.location.search);
    const bookingId = urlParams.get('bookingId');

    // Handle the credit and debit card button click events
    if (bookingId) {
        document.getElementById('creditCardButton').addEventListener('click', function() {
            window.location.href = `creditCardPayment.html?bookingId=${bookingId}`;
        });

        document.getElementById('debitCardButton').addEventListener('click', function() {
            window.location.href = `debitCardPayment.html?bookingId=${bookingId}`;
        });

        // Fetch the booking details from the backend using the bookingId
        fetch(`http://localhost:8080/booking/${bookingId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Booking not found');
                }
                return response.json();  // Parse the response as JSON
            })
            .then(data => {


                // Retrieve the fare from the response (check if 'fare' is available in the response object)
                if (data && data.fare) {
                    const fare = data.fare;
                    // Display the fare on the page
                    document.getElementById('fared').innerText = `${fare}`;
                } else {
                    console.error('Fare not found in the response.');
                    alert('Fare information is missing.');
                }
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
