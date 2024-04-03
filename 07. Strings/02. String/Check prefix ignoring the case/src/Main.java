import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String nume = scanner.nextLine();
        nume = nume.toUpperCase();
       System.out.println(nume.startsWith("J"));
    }
}