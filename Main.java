import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("How many rows and columns do you want?");
    Scanner input = new Scanner(System.in);
    int row = input.nextInt();
    int col = input.nextInt();
    int numOfSpots = row * col;
    System.out.println("How many mines do you want?");
    int mines = input.nextInt();
    while (mines >= numOfSpots) {
      System.out.println("too many mines try again");
      mines = input.nextInt();
    }
    Buttons gam = new Buttons(false, row, col, mines);
  }
  //hello, this is just to test sonething
}
