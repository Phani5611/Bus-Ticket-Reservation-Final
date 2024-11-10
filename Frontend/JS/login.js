document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();  // Prevent form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const loginDetails = {
        username: username,
        password: password
    };

    // Send login request to the backend
    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginDetails)
    })
    .then(response => {
        // Check if the response is successful (status 200)
        if (!response.ok) {
            window.location.href='LoginFailed.html';
            return response.json().then(data => {
                throw new Error(data.message || "Login failed");
            });
        }
        return response.json();  // Parse the JSON response if successful
    })
    .then(data => {
        if (data) {
            // Successful login, redirect to the next page
            window.location.href = 'bookingDetails.html';
        } else {
            // Display error message if login fails
            document.getElementById('errorMessage').innerText = data.message || "Invalid username or password";
        }
    })
    .catch(error => {
        // Display error message for any issues during login
        console.error('Login error:', error);
        document.getElementById('errorMessage').innerText = error.message || "Something went wrong";
    });
});
