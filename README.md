
# Minibank

Develop an API to open current accounts for existing customers. It provides an endpoint accepting `customerID` and `initialCredit`; it opens an account linked to `customerID`, and if `initialCredit > 0`, performs a transaction. Another endpoint displays user info: Name, Surname, balance, and transactions.


## Project Goals
- Provide a REST API to open current accounts.
- Maintain accurate records of customer details, balances, and transaction history.
- Expose the API via Swagger for easy testing and exploration.


### Prerequisites
- **Java Development Kit (JDK 21+)**
- **Gradle**
- **Eclipse IDE** with Buildship Gradle Integration
- **Node.js and npm angular 18** (for frontend)

### Project Structure
- **Backend**: Spring Boot application using Gradle for dependency management.
- **Frontend**:  Angular UI 


### For Development

-  **Clone the repository**:

  ```
  git clone https://github.com/chrito123/minibank.git
  	
  ```
   
- **Adding Gradle Plugin in Eclipse**: Use the Buildship Gradle Integration plugin.

- **Adding Lombok for Eclipse**:

  - Go to **Help** -> **Install New Software** -> **Work With**: `https://projectlombok.org/p2` -> Install -> Restart Eclipse.

- **Adding MapStruct to the Project**:

  - Add the following plugin to `build.gradle`
  
  ```gradle
  plugins {
      id 'com.diffplug.eclipse.apt' version '3.37.2'
  }
  ```
   - Then run the command on the root folder:
  
  ```
	gradlew eclipseJdtApt eclipseFactorypath eclipseJdt
  ```
  - Restart Eclipse.
  - Right-click on `build.gradle` and refresh.

### Running the Project

-  **Backend**: Run the backend application using :

  ```
  gradlew bootrun
  ```

### Swagger

A Swagger UI can be found at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

### Test

Note: All tests are run when the build is performed.

To run tests manually, use the following command:

```
gradlew test
```

### CI/CD

- Set **SPRING_PROFILES_ACTIVE** in your CI/CD pipeline based on the environment.
- **DB_USERNAME** and **DB_PASSWORD** environment variable needs to be set for the app

### Credits

- **Developer**: Christian Sanchez



