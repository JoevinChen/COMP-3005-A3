
1. Clone the repository for github
2. Open a new database in PostgreSQL and run the query below to create the table:
    CREATE TABLE students (
        student_id SERIAL PRIMARY KEY,
        first_name TEXT NOT NULL,
        last_name TEXT NOT NULL,
        email TEXT NOT NULL UNIQUE,
        enrollment_date DATE
    );
3. Then Populate the table with information by running this query:
    INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
    ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
    ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
    ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

5. Then in the Main.java file modify the port number, user, password and file name as needed

4. Then run the main function of Main.java file to start the program. Following instructions listed in the terminal

Video Demo Youtube Link:

