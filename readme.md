#  __**Amazon Statistics Api**__ 
The application is a Spring Boot based solution designed to efficiently handle Amazon statistics. Leveraging technologies such as Spring Web, Spring Security, Spring Cache, MongoDB, Lombok, and Mapstruct, the application seamlessly processes JSON data, transforming it into Java classes, and persistently stores it in the database. The system ensures real-time updates by continuously monitoring the statistics file for any changes.
User interaction is facilitated through secure registration and login functionalities utilizing JSON Web Tokens (JWT). Users can access either general statistics or specific data based on specified parameters. To optimize response times, the application incorporates caching mechanisms, allowing data retrieval from cache instead of directly querying the database. This not only enhances performance but also contributes to a more responsive user experience.
## Technologies used
### Core Technologies:
* ***Java***
* ***Maven***
### Spring Framework:
* ***Spring Boot***
* ***Spring Boot Security***
* ***Spring Cache***
### Database and Persistence:
* ***MongoDb***
### API Documentation:
* ***Swagger***
### Auxiliary Libraries:
* ***Lombok***
* ***MapStruct***