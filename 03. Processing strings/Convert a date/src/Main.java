import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String data = scanner.nextLine();
        String[] newData=data.split("-");
        String years = String.format("%s",newData[0]);
        String month = String.format("%s",newData[1]);
        String day = String.format("%s",newData[2]);

        System.out.println(month+"/"+day+"/"+years);

    }
}