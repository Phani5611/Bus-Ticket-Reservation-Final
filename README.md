# Bus Ticket Reservation Using QR Code

**A web application, that can help customers to book bus tickets online, after registering themselves and provide ticket details in the form of QR code.**



- [Demo Video Link](https://drive.google.com/file/d/1HY55cm-LpBKpKGjEpAN5Umdcs8ZD07gd/view?usp=sharing)

## Project Highlights

- Only unique users are registered in the database.

- Authenticated users are only allowed to book the ticket.

- Passwords are encrpyted using B-Crypt library ( strength 12 rounds ).

- Can handle all the CRUD operation features i.e user registration, booking ticket, get ticket details, cancel the ticket .

- Bus fare is calculated dynamically by using per KM distance price.

- Accepts cross-origin HTTP requests.

## Table of Contents

- [Software's ](#softwares-needed)
- [Project Structure](#project-structure)
- [Project Structure Overview](#project-structure-overview)
- [Installation Guide](#steps-to-install-the-project)
- [Dependencies](#dependencies-needed)
- [How to run ?](#how-to-run--test-the-project-)
- [JSON test cases](#json-data-as-test-cases)
- [Contact](#contact)


## Software's Needed

- [JDK 21](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe (sha256))
- [IntelliJ with Maven](https://www.jetbrains.com/idea/download/?section=windows)
- [Postman ( REST Client for Backend Testing )](https://www.postman.com/downloads/)
- [VS Code + Live Server Extension ( if you want open backend and frontend separately )](https://code.visualstudio.com/download)
- [Postgres](https://www.postgresql.org/download/)

## Project Structure

```
├───.idea
├───Backend
│   ├───.idea
│   ├───.mvn
│   │   └───wrapper
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───Bus_Reservation_Nov24
│   │   │   │           └───Bus
│   │   │   │               └───Reservation
│   │   │   │                   └───Backend
│   │   │   │                       └───Dev
│   │   │   │                           └───Nov24
│   │   │   │                               ├───Config                       # All Security Configuration
│   │   │   │                               ├───Controllers                  # Contains URL / HTTP request end point mappings
│   │   │   │                               ├───Model                        # Contains entities of the project
│   │   │   │                               ├───Repository                   # Database layer
│   │   │   │                               └───Service                      # Cotains all the business logic
│   │   │   └───resources
│   │   │       ├───static
│   │   │       └───templates
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───Bus_Reservation_Nov24
│   │                   └───Bus
│   │                       └───Reservation
│   │                           └───Backend
│   │                               └───Dev
│   │                                   └───Nov24
│   └───target
│       ├───classes
│       │   └───com
│       │       └───Bus_Reservation_Nov24
│       │           └───Bus
│       │               └───Reservation
│       │                   └───Backend
│       │                       └───Dev
│       │                           └───Nov24
│       │                               ├───Config                      
│       │                               ├───Controllers                 
│       │                               ├───Model                      
│       │                               ├───Repository                  
│       │                               └───Service                    
│       └───generated-sources
│           └───annotations
└───Frontend                              # Frontend Folder
    ├───Assests                           # Contains all the images for website
    ├───CSS                               # CSS Styling
    ├───HTML                              # HTML code package
    └───JS                                # Javascript source code for connecting frontend and backend

```

## Project Structure Overview
 
- Config - Contains all the security and other configurations.

- Controller - Handles all the HTTP requests from frontend or client.

- Model - Contains entities of the project 

- Repository - Database layer to connect with Postgres

 - Service - All the business and features logic is present here.

## Steps to install the project

1. Download the IDE's / Editor like IntelliJ and VS Code and also make sure you have the Java Development Kit Version 21 installed in your machine.

2. Clone the repository from GitHub to your local machine, [Help](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository).

3. Please check the below mentioned dependencies in `pom.xml` file.

4. Ideally it should be available when you clone the project. In case if not found download them from this [Maven Repository](https://mvnrepository.com/ ).

5. Install Live Server extension in VS Code ( Assuming you separated frontend and backend in two different IDE / Editor).

## Dependencies Needed

- Spring Web

- Spring Security
- Spring JPA
- PostgreSQL Driver
- Lombok

## How to run / test the project ?

1. After successfully following the installation steps.

2. Start the `Live Server in VS Code` and `Spring Boot Server in IntelliJ`.

3. Now register yourself on  the website and enter the login credentials in login page.

4. When you try to enter invalid or no credentials, it doesn't allow you to proceed further.

5. Fill the booking form and after redirecting to payment options page, select the payment methods shown.

6. Enter the details of the payment.

7. Now a QR code is generated, when you scan this QR code with any scanner app it shows the details of the booking.

8. You can also test the backend alone by using software like Postman, which is a REST client and the test cases i.e  [JSON](#json-data-as-test-cases) test cases are given below.

9. When you check the Pg Admin by running the following commands you can see  the data which is stored.

#### SQL Commands to Check the Database

###### 1. To check all the tables
- select tablename
  from pg_catalog.pg_tables
  where schemaname = 'public';

###### 2. Booking Details
- select * from booking_details;

###### 3. Credit Card Details
- select * from credit_card_details;

###### 4. Debit Card Details
- select * from debit_card_details;

###### 5. Passenger Details
- select * from passenger_details;

## JSON Data as Test Cases

##### Passenger Registration
````
{
"username" : "user01",
"name" : "user",
"email" : "user01@gmail.com",
"password" : "user123",
"cpassword" : "user123"
}
````

##### Booking Details
````
{
"name" : "user5611",
"phone" : 1234566788,
"boarding_code" : 01,
"boarding" : "Hyderabad - DSNR",
"destination_code" : 02,
"destination" : "Hyderabad - SECUNDERABAD"
"dateAndTime" :2024-11-21T14:30:00
}
````

##### Card Details
````
{
  "card_number": 1234567890123456,
  "exp_date": 1225,
  "cvv": 123,
  "card_owner_name": "User01"
}
````

## Contact
- Email - phanisaisrinivasmadiraju@gmail.com
- [Linkedin](https://www.linkedin.com/in/phani-sai-srinivas-madiraju-010553191/)


## Thanks for reading :)