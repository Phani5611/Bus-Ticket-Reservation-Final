// Extract the bookingId from the URL query string
const urlParams = new URLSearchParams(window.location.search);
const bookingId = urlParams.get('bookingId');

// Check if bookingId exists (for safety)
if (bookingId) {
    // Get the credit card button and add an event listener for the click
    document.getElementById('creditCardButton').addEventListener('click', function() {
        // Redirect to the credit card payment page with the bookingId as a query parameter
        window.location.href = `http://127.0.0.1:5500/HTML/creditCardPayment.html?bookingId=${bookingId}`;
    });
}
if (bookingId) {
    // Get the credit card button and add an event listener for the click
    document.getElementById('debitCardButton').addEventListener('click', function() {
        // Redirect to the credit card payment page with the bookingId as a query parameter
        window.location.href = `http://127.0.0.1:5500/HTML/debitCardPayment.html?bookingId=${bookingId}`;
    });
}

