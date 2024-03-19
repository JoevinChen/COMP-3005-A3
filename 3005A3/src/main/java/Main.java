import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Creating a new object to connect
        Operations operations = new Operations();
        operations.connectDatabase();

        //Scanner to take user input
        Scanner stringScan = new Scanner(System.in);
        //Boolean to keep the loop running
        boolean isContinue = true;
        while (isContinue) {
            //Printing out all options for the user
            System.out.println("Press 1 to view all students");
            System.out.println("Press 2 to add a student");
            System.out.println("Press 3 to update a student email");
            System.out.println("Press 4 to delete a student");
            System.out.println("Press 5 to exit");
            //Takes user input
            Scanner input = new Scanner(System.in);
            int userInput = input.nextInt();
            //Checks for user input bound
            //Notifying which option they chose
            System.out.println("You chose option " + userInput);
            if (userInput > 5 || userInput < 0) {
                isContinue = false;
                break;
            }
            //To exit
            if (userInput == 5) {
                isContinue = false;
            }
            //Call listStudents method to print out all students
            else if (userInput == 1) {
                operations.getAllStudents();
            }
            //Calls addStudent, while asking for all the information
            else if (userInput == 2) {
                System.out.println("Enter the first name of the student: ");
                String firstName = stringScan.nextLine();
                System.out.println("Enter the last name of the student: ");
                String lastName = stringScan.nextLine();
                System.out.println("Enter the email of the student: ");
                String email = stringScan.nextLine();
                System.out.println("Enter the date of enrollment of the student: ");
                String date = stringScan.nextLine();
                operations.addStudent(firstName, lastName, email, Date.valueOf(date));
            }
            //CAlls updateStudentEmail, while asking for all the information
            else if (userInput == 3) {
                System.out.println("Enter the student ID of the student: ");
                String studentID = stringScan.nextLine();
                System.out.println("Enter the new email of the student: ");
                String email = stringScan.nextLine();
                operations.updateStudentEmail(Integer.valueOf(studentID),email);
            }
            //Calls deleteStudent, while asking for all the information
            else if (userInput == 4) {
                System.out.println("Enter the student ID of the student: ");
                String studentID = stringScan.nextLine();
                operations.deleteStudent(Integer.valueOf(studentID));
            }

        }
    }

}
