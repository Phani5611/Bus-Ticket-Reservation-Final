// Function to validate form before submission
function validateForm() {
    var password = document.getElementById("pass").value.trim();  // Trim whitespace
    var confirm_password = document.getElementById("cpass").value.trim();

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

    // Optional: Add a password strength check using regex
    var passwordStrengthRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (!passwordStrengthRegex.test(password)) {
        alert("Password must contain at least one letter, one number, and one special character.");
        return false;
    }

    return true; 
}

// Form Submission -> DB
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    if (!validateForm()) {
        event.preventDefault();  // Prevent form submission if validation fails
        return "Enter Details correctly"; 
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
    .then(response => {
        // Check if response is successful (status code 2xx)
        if (!response.ok) {
            throw new Error('Server error: ' + response.statusText);
        }
        return response.json(); // Parse JSON response
    })
    .then(data => {
        if (data.message) {
            // Display the message from the server in an alert box
           // alert(data.message);
            
            // Redirect to "Registration Successful" page
            window.location.href = "RegThankyou.html";  // Replace with your actual success page URL
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred. Please try again.'); // Display a general error message in an alert box
    });
});
