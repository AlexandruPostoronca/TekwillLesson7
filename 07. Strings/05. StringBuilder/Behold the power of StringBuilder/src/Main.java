public class Main {
   public static void main(String[] args) {
      // Write your solution here
      StringBuilder sb1 = new StringBuilder();
      sb1 = sb1.append("Behold the power of StringBuilder");
      System.out.println(sb1);
      StringBuilder sb2 = new StringBuilder();
      sb2.append("Behold the power of StringBuilder");
      System.out.println(sb2);
      StringBuilder sb3 = new StringBuilder()
              .append("Behold")
              .append("the power of")
              .append("StringBuilder");
      System.out.println(sb3);
      StringBuilder sb4 = new StringBuilder("Behold the power of StringBuilder");
      System.out.println(sb4);
   }
}