# employees

### Dependencies

- Java 1.8
- Python 2.7
- Local installation of MySQL 5.7.21


### Database Setup

1. Create a user `dropwizard`
2. Create a database `employees` and give `dropwizard` full permissions
3. Run the SQL script


### Testing

##### Assumptions

- The employee table will be empty when the script is run
- Employees are created with IDs in ascending order of when they were added. Strictly sequential IDs are *not* assumed.

##### Testing process

1. Compile the service with `mvn package`.
1. Update the config.yml with the password for database user `dropwizard`
1. Launch the service with the command `java -jar target/employees-1.0-SNAPSHOT.jar server config.yml`
1. Run the SQL script `src/test/load_data.sql` to load testing data (departments and titles)
1. Run the the script `test.py`. This script will:
  - Run a sequence of POST requests to add new employees
  - Test that the proper error codes are returned for invalid requests
  - Run a sequence of GET requests to find the employees in various departments
  - Sort the actual and expected output in order of employee ID
  - Test that the record count is the same
  - Check every field in the actual output against the expected output
  - Also test that ill-formed requests are rejected
  
  

### Design choices

1. Departments and titles are predefined in the database; they are not free-form text
1. The same title string can be used in multiple departments, but still designates different positions
1. Employees have a unique ID. Employees IDs are ascending in the order that the employees are created (currently using MySQL autoincrement, but not necessarily).
1. When creating a new employee through the API, the record will be returned with its new ID
1. The exact same record can exist in the same department more than once, while still designating separate employees (I once worked with two programmers who were both named David Smith)
1. I used an enhanced version of SimpleDateFormat that is extremely strict.
1. The DAO implementations are hidden behind interfaces that could be mocked. Because this is such a simple project, and the DAOs don't have very much logic, I didn't bother making unit test mocks, and instead covered all testing through the the `test.py` script.
1. I added another endpoing, /getEmployee/{id}, for testing purposes.