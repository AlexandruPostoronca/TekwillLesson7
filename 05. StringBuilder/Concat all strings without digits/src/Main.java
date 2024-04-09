import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        // don't change the code above
        // write your code with StringBuilder here
        for (int i = 0; i < strings.length; i++) {
            char[] newChars = strings[i].toCharArray();
            for (int j = 0; j < newChars.length; j++) {
                if (Character.isLetter(newChars[j])) {
                    System.out.print(newChars[j]);
                }
            }
        }
    }
}