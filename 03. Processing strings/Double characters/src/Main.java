import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String words = scanner.nextLine();

        for (int i = 0; i < words.length(); i++) {
            char ch = words.charAt(i);
                System.out.print(ch);
                System.out.print(ch);
        }
    }
}