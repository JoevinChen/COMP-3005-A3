import java.sql.*;

public class Operations {
    Connection conn;

    public void connectDatabase(){
        //Change these values as needed to test
        String portNumber = "5432";
        String name = "A3TEST";

        //Populating variables needed to start a connection
        String url = "jdbc:postgresql://localhost:" + portNumber + "/" + name;
        String user = "postgres";
        String password = "admin";

        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            // Connect to the database
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
            } else {
                System.out.println("Failed to establish connection.");
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() throws SQLException{
        //Creating a statement
        Statement statement = conn.createStatement();
        statement.executeQuery("SELECT * FROM students");
        ResultSet resultSet = statement.getResultSet();

        //Looping through every student
            while(resultSet.next()){
                //Printing their information with a tab to keep spacing neat
                System.out.print(resultSet.getString("student_id") +" \t");
                System.out.print(resultSet.getString("first_name") +" \t");
                System.out.print(resultSet.getString("last_name") +" \t");
                System.out.print(resultSet.getString("email") +" \t");
                System.out.print(resultSet.getString("enrollment_date") +" \t");
                System.out.println();
            }
        System.out.println();
    }

    public void addStudent(String first_name, String last_name, String email, Date enrollment_date) throws SQLException{
        String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        //Inserting information into the table
        PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, email);
            statement.setDate(4, enrollment_date);
            statement.executeUpdate();
    }

    public void updateStudentEmail(int student_id, String new_email)throws SQLException{
        String query = "UPDATE students SET email = ? WHERE student_id = ?";
        //Updating the table
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,new_email);
        statement.setInt(2, student_id);
        statement.executeUpdate();
    }

    public void deleteStudent(int student_id)throws SQLException{
        String query = "DELETE FROM students where student_id = ?";
        //Deleting the student
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1,student_id);
        statement.executeUpdate();
    }
}
