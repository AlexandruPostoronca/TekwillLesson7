import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String number = scanner.next();
        char[] newNumbers = new char[number.length()];
        int secondNumber = 0;
        int firstNumbers = 0;

        for (int i = 0; i < number.length(); i++) {
            newNumbers[i] = number.charAt(i);
        }

        for (int i = 0; i < newNumbers.length / 2; i++) {
            firstNumbers += Character.getNumericValue(newNumbers[i]);
        }
        for (int i = newNumbers.length / 2; i < newNumbers.length; i++) {
            secondNumber += Character.getNumericValue(newNumbers[i]);
        }
        System.out.println(firstNumbers != secondNumber ? "Regular" : "Lucky");
    }
}
