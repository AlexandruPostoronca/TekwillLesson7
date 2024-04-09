import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String words = scanner.next();

        if (words.length() % 2 == 0) {
            for (int i = 0; i < words.length() / 2 - 1; i++) {
                System.out.print(words.charAt(i));
            }
            for (int i = words.length() / 2 + 1; i < words.length(); i++) {
                System.out.print(words.charAt(i));
            }
        }else {
            for (int i = 0; i < words.length() / 2; i++) {
                System.out.print(words.charAt(i));
            }
            for (int i = words.length() / 2 + 1; i < words.length(); i++) {
                System.out.print(words.charAt(i));
            }
        }
    }
}