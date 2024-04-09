import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String nameCity = scanner.nextLine();

        System.out.println(nameCity.endsWith("burg"));
    }
}