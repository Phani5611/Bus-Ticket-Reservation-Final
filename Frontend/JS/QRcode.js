

const urlParams = new URLSearchParams(window.location.search);
const bookingId = urlParams.get('bookingId');
function fetchBookingId() {
   fetch(`http://localhost:8080/booking/${bookingId}`)
       .then(response => {
           if (!response.ok) {
               throw new Error("Booking not found");
           }
           return response.json();  // Parse the response as JSON
       })
       .then(data => {
           console.log("Fetched booking data:", data);  // Debugging line to see the response

           // Make sure the bookingId exists in the response
           if (data.bookingId) {
               // Display the booking ID in the frontend
               document.getElementById('idcode').innerText = data.bookingId;
              // Generate the QR code dynamically with the entire data object (encoded as JSON)
              const qrImage = document.getElementById('qrImage');
              const jsonString = JSON.stringify(data);  
              qrImage.src = `https://api.qrserver.com/v1/create-qr-code/?data=${encodeURIComponent(jsonString)}&size=200x200`;
          }   
          else {
              console.error("Booking ID not found in the response.");
              document.getElementById('idcode').innerText = "Booking ID not found.";
          }
       })
       .catch(error => {
           console.error('Error fetching booking details:', error);
           document.getElementById('idcode').innerText = "Error fetching booking details.";
       });
}
function cancellation() {
    if (confirm('Are you sure you want to cancel this booking?')) {
        fetch(`http://localhost:8080/cancel/${bookingId}`, {
            method: 'POST', // Or DELETE, depending on your API implementation
            headers: {
                'Content-Type': 'application/json',
                // Add authorization headers if needed (e.g., 'Authorization': 'Bearer <token>')
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Booking not found or cancellation failed");
            }
            // Check the status code to handle different responses
            switch (response.status) {
                case 200: // Successful cancellation
                    
                    window.location.href = 'cancel.html'; // Redirect to cancel page
                    break;
                case 400: // Bad Request
                    alert('Bad Request. Please check your cancellation details.');
                    break;
                case 401: // Unauthorized
                    alert('Unauthorized. Please log in and try again.');
                    break;
                case 404: // Not Found
                    alert('Booking not found. Please check your booking ID.');
                    break;
                case 500: // Internal Server Error
                    alert('Internal Server Error. Please try again later.');
                    break;
                case 502: // Bad Gateway
                    alert('Bad Gateway. The server is down or unreachable.');
                    break;
                default:
                    alert('Unexpected error: ' + response.statusText);
            }
        })
        .catch(error => {
            console.error('Error fetching cancellation details:', error);
            alert('An error occurred while processing your cancellation.');
        });
    }
}

// Call fetchBookingId when the page loads
window.onload = fetchBookingId;