### How to run the project
First you need to configure your database at the application.properties, then you need to run the backend and the frontend.

### How to run the backend
```bash
cd IdomTestAPI
mvn clean compile exec:java
```

### How to run the frontend
```bash
cd ../IdomTestFrontEnd
npm install
npm run ng serve
```

### Requirements

- JDK 11 or later
- [Oracle Database XE](https://www.oracle.com/database/technologies/appdev/xe.html)
- [Apache Maven](https://maven.apache.org/)
- [NodeJS](https://nodejs.org/en/)
- [Angular](https://angular.io/guide/setup-local)
