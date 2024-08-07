# Social Assistance Fund API

This project is a simple Spring Boot application designed to manage social assistance fund applications. It provides endpoints to handle CRUD operations for applicants, including approval functionality.

## Prerequisites

Before you begin, ensure you have the following installed:
- JDK 11 or higher
- Maven 3.6.3 or higher
- MySQL database

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/lelambonzo/social-assistance-api.git
   cd social-assistance-api
   ```

2. **Configure the Database**

   Ensure you have a MySQL database set up and create a database named `social_assistance_db`. Import the provided SQL schema to set up the database structure.

3. **Update Database Configuration**

   Edit the `src/main/resources/application.properties` file to match your database settings:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/social_assistance_db
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

   Replace `yourusername` and `yourpassword` with your MySQL credentials.

4. **Build the Application**

   Use Maven to build the application:

   ```bash
   mvn clean install
   ```

5. **Run the Application**

   Start the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

   The API will be accessible at `http://localhost:8080`.

## API Endpoints

- `GET /api/applicants` - Retrieve all applicants
- `POST /api/applicants` - Add a new applicant
- `PUT /api/applicants/{id}` - Update an existing applicant
- `DELETE /api/applicants/{id}` - Delete an applicant
- `PATCH /api/applicants/{id}/approve` - Approve an applicant

## Configuration

- **CORS**: The application is configured to allow requests from `http://localhost:3000`. Adjust this in the `WebConfig` class if your front-end is running on a different origin.

## Testing

To test the API, use tools like Postman or curl to make requests to the endpoints.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

If you have suggestions for improvements or bug fixes, please open an issue or submit a pull request on GitHub.

## Contact

For any questions or feedback, you can reach out at [lelambonzo@gmail.com](mailto:lelambonzo@gmail.com).
