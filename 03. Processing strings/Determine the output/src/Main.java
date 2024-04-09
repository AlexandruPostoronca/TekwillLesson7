public class Main {
   public static void main(String[] args) {
      // Write your solution here
      String str = "Hello, Java";

      int i = str.length() - 1;
      while (i >= 1) {
         System.out.print(str.charAt(i));
         i--;
      }
   }
}