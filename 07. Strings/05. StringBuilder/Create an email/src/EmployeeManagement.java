import java.util.Scanner;

public class EmployeeManagement {

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String surname = scanner.next();

        String completeEmail =name.concat(surname)+"@work.net"; // write your code here

        System.out.println(completeEmail);
    }
}