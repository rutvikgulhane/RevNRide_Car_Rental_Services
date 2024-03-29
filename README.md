# RevNRide_Car_Rental_Services

- The Car Rental Management System is a web-based application that provides car rental services to customers. The system consists of a backend built using Spring Boot and a frontend built using React. The application is secured using JWT authentication, which enables role-based access control to different parts of the application.

- The system has five main entities: User, Roles, UserRole, Car, Localization and Reservation. The User entity stores information about users of the system, including their name, email, and password. The Roles entity defines the various roles that can be assigned to users, such as Admin, Customer, or Manager. The UserRole entity is used to map users to their assigned roles.

- The Car entity contains information about the cars available for rental, such as the make, model, year, and rental rate. The Localization entity stores information about the various locations where cars can be rented from, including their name, address, and contact information. Finally, the Reservation entity is used to store information about reservations made by customers, including the start and end dates of the rental, the customer's information, and the car rented.

- Customers can use the system to search for available cars by location and date, and then make a reservation for the desired car. The rental rate is calculated based on the length of the rental period and the car rented. Customers can also view their past reservations and cancel reservations if necessary.

- Admin users have access to additional functionality, such as the ability to add, update, or remove cars from the fleet, manage localizations, and manage users and their roles. The system also supports the ability to remove customers from the system if needed.

- Overall, the Car Rental Management System provides a user-friendly and secure platform for customers to rent cars, and for admins to manage the rental fleet and associated data.



