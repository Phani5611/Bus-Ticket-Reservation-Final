document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Create a FormData object to collect form data
    var formData = new FormData(this);

    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });
    
   // Convert the plain object to JSON
   var jsonData = JSON.stringify(dataObject);

   // Perform the fetch request
   fetch('http://localhost:8080/booking', {
       method: 'POST',
       headers: {
           'Content-Type': 'application/json'
       },
       body: jsonData
   })
    .then(response => {
        if (response.ok) {
            window.location.href = 'NewPayment.html'; // Redirect to a thank you page
        } else {
            console.error('Form submission failed');
        }
    })
    .catch(error => console.error('Error:', error));
});