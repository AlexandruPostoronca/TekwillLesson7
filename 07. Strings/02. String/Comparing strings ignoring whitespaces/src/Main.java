import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String lineOne = scanner.nextLine();
        String lineTwo = scanner.nextLine();

        lineOne = lineOne.replace(" ", "");
        lineTwo = lineTwo.replace(" ", "");
        System.out.println(lineOne.equalsIgnoreCase(lineTwo));
    }
}