
//Searching in url for Booking ID
const urlParams = new URLSearchParams(window.location.search);
const bookingId = urlParams.get('bookingId');



function fetchBookingId() {
    // Example booking ID for testing, replace with actual ID if dynamic

   // Fetch booking details from the backend (replace with the correct endpoint)
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
              const jsonString = JSON.stringify(data);  // Convert the data to a JSON string
              qrImage.src = `https://api.qrserver.com/v1/create-qr-code/?data=${encodeURIComponent(jsonString)}&size=200x200`;
          } else {
              console.error("Booking ID not found in the response.");
              document.getElementById('idcode').innerText = "Booking ID not found.";
          }
       })
       .catch(error => {
           console.error('Error fetching booking details:', error);
           document.getElementById('idcode').innerText = "Error fetching booking details.";
       });
}
function cancellation(){
    window.location.href="cancel.html";
}
// Call fetchBookingId when the page loads
window.onload = fetchBookingId;