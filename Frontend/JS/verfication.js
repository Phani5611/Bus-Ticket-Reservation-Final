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
    event.preventDefault(); 

    if (!validateForm()) {
        return; // Exit if form is not valid
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
        console.log('Response Status:', response.status); 

        // Check if the response status is 201 (Created)
        if (response.status === 201) {
            // If successful, redirect to the "Registration Successful" page
            window.location.href = "http://127.0.0.1:5500/HTML/RegThankyou.html";
        }
        // If registration failed due to some client-side error 
        else if (response.status === 400) {
            alert('Registration failed: Invalid data provided.');
        }
        else if(response.status===409){
            alert("user already exsist.")
        }
        // If server error occurred
        else if (response.status >= 500 && response.status < 600) {
            alert('Server error. Please try again later.');
        }
        // Handle other errors 
        else {
            alert('Unexpected error: ' + response.statusText);
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred: ' + error.message); 
    });
});

