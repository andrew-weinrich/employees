USE employees;

CREATE TABLE department (
    department_id INT NOT NULL,
    name NVARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (department_id)
);

CREATE TABLE title (
    title_id INT NOT NULL,
    name NVARCHAR(255) NOT NULL,
    department_id INT NOT NULL REFERENCES department(department_id),
    PRIMARY KEY (title_id)
);

CREATE UNIQUE INDEX name_index ON title (department_id, name);


CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT,
    first_name NVARCHAR(255) NOT NULL,
    last_name NVARCHAR(255) NOT NULL,
    title_id INT NOT NULL REFERENCES title(title_id),
    start_date DATE NOT NULL,
    PRIMARY KEY (employee_id)
);

CREATE UNIQUE INDEX name_index ON employee (first_name, last_name);


INSERT INTO department (department_id, name) VALUES (1, 'Accounting');
INSERT INTO department (department_id, name) VALUES (2, 'Sales');
INSERT INTO department (department_id, name) VALUES (3, 'IT');
INSERT INTO department (department_id, name) VALUES (4, 'HR');

INSERT INTO title (title_id, department_id, name) VALUES (1, 1, 'VP');
INSERT INTO title (title_id, department_id, name) VALUES (2, 1, 'Treasurer');
INSERT INTO title (title_id, department_id, name) VALUES (3, 1, 'Comptroller');
INSERT INTO title (title_id, department_id, name) VALUES (4, 1, 'AR Accountant');
INSERT INTO title (title_id, department_id, name) VALUES (5, 1, 'AP Accountant');
INSERT INTO title (title_id, department_id, name) VALUES (6, 1, 'Account Manager');
INSERT INTO title (title_id, department_id, name) VALUES (7, 2, 'Sales Manager');
INSERT INTO title (title_id, department_id, name) VALUES (8, 2, 'Junior Salesperson');
INSERT INTO title (title_id, department_id, name) VALUES (9, 2, 'Senior Salesperson');
INSERT INTO title (title_id, department_id, name) VALUES (10, 2, 'Account Manager');
INSERT INTO title (title_id, department_id, name) VALUES (11, 3, 'Network Engineer');
INSERT INTO title (title_id, department_id, name) VALUES (12, 3, 'VP');
INSERT INTO title (title_id, department_id, name) VALUES (13, 3, 'CTO');
INSERT INTO title (title_id, department_id, name) VALUES (14, 3, 'Junior Developer');
INSERT INTO title (title_id, department_id, name) VALUES (15, 3, 'Senior Developer');
INSERT INTO title (title_id, department_id, name) VALUES (16, 3, 'Architect');
INSERT INTO title (title_id, department_id, name) VALUES (17, 4, 'VP');
INSERT INTO title (title_id, department_id, name) VALUES (19, 4, 'Manager');
INSERT INTO title (title_id, department_id, name) VALUES (20, 4, 'Benefits Analyst');




