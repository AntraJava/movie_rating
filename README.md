# Movie Rating backend

## Development 
Using Spring Boot main class to start the app.
Before running, run DB scripts to generate all the tables.
Make sure the datasource is changed in `application.properties` file.

## Front-end is the project listed in [`rating`](https://github.com/AntraJava/movie_rating_front_end)

## To Do
* Implement a feature to allow user search by `IMDB` or title.(use the existing search by title field. No UI changes.)
* Implement a feature to list all popular movies when `Popular` button is clicked on home page.(for now it is hard coded. No UI changes.)
* Implement a feature to list all popular Action / Cartoon movies. (for now it is hard coded. No UI changes.)
* Add cache expiration.(need to do some research. No UI changes.)
* Show user's First Name + Last Name on the right upper cover. (Now it is `username-email`, minor UI changes. Need backend changes.)
* Implement delete rating function.(need some UI change)
* Implement edit rating(need UI change)
