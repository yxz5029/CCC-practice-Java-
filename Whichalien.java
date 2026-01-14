import java.util.Scanner;

public class Whichalien {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("How many antennas?");
    int a = sc.nextInt();
    System.out.println("How many eyes?");
    int e = sc.nextInt();
    if (a >= 3 && e <= 4) {
      System.out.println("TroyMartian");
    }
    if (a <= 6 && e >= 2) {
      System.out.println("VladSaturnian");
    }
    if (a <= 2 && e <= 3) {
      System.out.println("GraemeMercurian");
    }
  }
}
