import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        String name = scanner.next();

        for (int i = 0; i < name.length(); i++) {
            String ch = (name.charAt(i)+"");
            if (i % 2 != 0){
                String neCh = ch.toLowerCase();
                System.out.print(neCh);
            }else {
                String neCh = ch.toUpperCase();
                System.out.print(neCh);
            }
        }
    }
}