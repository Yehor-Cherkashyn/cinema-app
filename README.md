![Tux, the Linux mascot](/kisspng-cinema-film-director-tel.png)
## Cinema-App

This project is a web application for a cinema. 
It allows users to view the schedule of movie sessions and purchase tickets for them. 
The application also has a user registration system, 
as well as a secure section with access rights to various resources, based on user roles. 
Additionally, users can obtain information about movies available at the cinema, 
including their descriptions.

## Features

<ul>
<li>Authentication</li>
<li>Authorization</li>
    <ul>
        <li>Admins with the <code>ADMIN</code> role can perform the following actions:</li>
            <ul>
                <li>Create and delete movies</li>
                <li>Create and delete movie sessions</li>
                <li>Create and delete cinema halls</li>
                <li>View available movies with their description</li>
                <li>View available movie sessions and in which cinema hall they will be</li>
                <li>View available cinema halls</li>
            </ul>
        <li>Users with the <code>USER</code> role can perform the following actions:</li>
            <ul>
                <li>View available movies with their description</li>
                <li>View available movie sessions and in which cinema hall they will be</li>
                <li>View available cinema halls</li>
            </ul>
    </ul>
<li>Registration of new users with creating personal shopping cart</li>
<li>Adding tickets to the shopping cart</li>
<li>Complete the order (with saving date and time)</li>
</ul>

## Getting Started

<ul>
<li>Install JDK, Tomcat, MySQL</li>
<li>Clone the project repository to your local machine</li>
<li>Create an empty schema in your DB</li>
<li>Replace the values of the <code>YOUR_DRIVER</code>, <code>YOUR_DATABASE_URL</code>, 
<code>USER_NAME</code> and <code>PASSWORD</code> properties in <code>db.properties</code> 
(<code>resource</code> directory)
with the appropriate values for your database setup</li>
<li>Build the project using Maven: <code>mvn clean install</code></li>
<li>Deploy the generated WAR file to servlet container such as Tomcat</li>
<li>Login with an existing account (<code>login: admin@gmail.com</code> <code>password: admin123</code> 
with the ADMIN role or <code>login: user@gmail.com</code> <code>password: user123</code>
with the USER role) or register a new one by sending a POST request to <code>.../register</code> endpoint</li>
</ul>

## Structure

<li>controller - contains controllers for endpoints: </li>
    <ul>
        <li>Registration - <code>POST /register</code> - registration new user</li>
        <li>Login - <code>POST /login</code> - authentication</li>
        <li>Logout - <code>GET /logout</code> - invalidate current session</li>
        <li>Cinema Halls: 
            <ul>
                <li><code>GET /cinema-halls/</code> - show all available cinema halls</li>
                <li><code>POST /cinema-halls/</code> - adds a new cinema hall</li>
            </ul>
        <li>Movie: 
            <ul>
                <li><code>GET /movies/</code> - show all available movies</li>
                <li><code>POST /movies/</code> - adds a new movie</li>
            </ul>
        <li>Movie Sessions: 
            <ul>
                <li><code>GET /movie-sessions/available/</code> - show all available movie sessions</li>
                <li><code>POST /movie-sessions/</code> - adds a new movie session</li>
                <li><code>PUT /movie-sessions/${id}/</code> - update movie session by ID</li>
                <li><code>DELETE /movie-sessions/${id}</code> - delete movie session by ID</li>
            </ul>
        <li>Shopping Cart: 
            <ul>
                <li><code>GET /shopping-carts/by-user/</code> - show all tickets added to user's shopping cart</li>
                <li><code>PUT /shopping-carts/movie-sessions/</code> - update shopping cart by movie session ID</li>
            </ul>
        <li>Order: 
            <ul>
                <li><code>GET /orders/</code> - show user's order history</li>
                <li><code>POST /orders/complete</code> - complete order</li>
            </ul>
        <li>User: 
            <ul>
                <li><code>GET /users/by-email/</code> - show user's information by email</li>
            </ul>
<li>dao: Data Access Object interfaces and their implementations</li> 
<li>dto: wrapper for model objects to unify the requests and responses in controllers</li>
<li>exception: custom exception class for DAO's exceptions</li>
<li>lib: contains email and password validators with custom annotations</li>
<li>model: Plain Old Java Objects (POJOs) that represent data</li>
<li>service: Service interfaces and their implementations that perform business logic</li>
<li>util: Utility class used in a project to save DateTime pattern</li>
<li>resources: Non-Java files that save database configurations</li>

## Additional
<li>Model Structure:</li>

![Tux, the Linux mascot](/Model_Structure.png)
</ul>

## Used technologies:

<li>Java <code>v.17.0.5</code></li>
<li>Maven <code>v.3.8.6</code></li>
<li>Spring <code>v.5.3.20</code></li>
<li>Spring Security <code>v.5.6.10</code></li>
<li>Hibernate <code>v.5.6.14.Final</code></li>
<li>MySql <code>v.8.0.22</code></li>
<li>Javax Servlets <code>v.4.0.1</code></li>
<li>Javax Annotations <code>v.1.3.2</code></li>
<li>Tomcat <code>v.9.0.73</code></li>

## Authors

Yehor Cherkashyn

[My LinkerIn](https://www.linkedin.com/in/yehor-cherkashyn-19406b243/)
