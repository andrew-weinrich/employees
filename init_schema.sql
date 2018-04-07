USE employees;

CREATE TABLE department (
    department_id INT AUTO_INCREMENT,
    name NVARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (department_id)
);

CREATE TABLE title (
    title_id INT AUTO_INCREMENT,
    name NVARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (title_id)
);

CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT,
    first_name NVARCHAR(255) NOT NULL,
    last_name NVARCHAR(255) NOT NULL,
    title_id INT NOT NULL REFERENCES title(title_id),
    department_id INT NOT NULL REFERENCES department(department_id),
    start_date DATE NOT NULL,
    PRIMARY KEY (employee_id)
);

CREATE UNIQUE INDEX name_index ON employee (first_name, last_name);

