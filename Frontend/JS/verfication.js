function validateForm() {
    var password = document.getElementById("pass").value;
    var confirm_password = document.getElementById("cpass").value;

    // Check if the password length is less than 8 characters
    if (password.length < 8) {
        alert("Password must be at least 8 characters long.");
        return false;
    }

    // Check if the password and confirm password fields match
    if (password !== confirm_password) {
        alert("Password and Confirm Password must be the same.");
        return false; 
    }

    return true; 
}

// Form Submission -> DB
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    
    if (!validateForm()) {
        event.preventDefault(); 
        return; // Exit the function to stop form submission
    }

    // If form is valid, continue with form submission via fetch
    const formData = new FormData(this);
    var dataObject = {};
    formData.forEach(function(value, key) {
        dataObject[key] = value;
    });

    // Convert the plain object to JSON
    var jsonData = JSON.stringify(dataObject);

    // Perform the fetch request
    fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
     .then(response => response.json()) // Parse JSON response
            .then(data => {
                if (data.message) {
                    alert(data.message); // Display the message from the server in an alert box
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('An error occurred. Please try again.'); // Display a general error message in an alert box
            });
        });