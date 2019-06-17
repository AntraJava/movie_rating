# Movie Rating backend

## Development 
Using Spring Boot main class to start the app.
### DB 
#### 1. MySQL
Before running the main app, run DB scripts to generate all the tables.
Make sure the datasource is changed in `application.properties` file.

#### 2. H2 - Embedded DB
The branch `h2_as_db` is using embedded database instead of MySQL.
No scripts need to be run.

## Security
Spring Security, DB based user authentication and JWT are used.
### User sign up
basic information of users are saved in DB. Password is bcrypted.
### User log in
Using username or email  +  password to log in. JWT token will be returned for the valid combination.
After that, all API calls needs authorization header.

## Front-end is the project listed in [`rating`](https://github.com/AntraJava/movie_rating_front_end)

## API documents

[Swagger](http://localhost:8080/swagger-ui.html)

## To Do
### No UI changes
* Implement a feature to allow user search by `IMDB` or title.(use the existing search by title field. No UI changes.)
* Implement a feature to list all popular movies when `Popular` button is clicked on home page.(for now it is hard coded. No UI changes.)
* Implement a feature to list all popular Action / Cartoon movies. (for now it is hard coded. No UI changes.)
* Add cache expiration.(need to do some research. No UI changes.)

### UI changes
* Show user's First Name + Last Name on the right upper cover. (Now it is `username-email`, minor UI changes. Need backend changes.)
* Implement delete rating function.(need some UI change)
* Implement edit rating(need UI change)
