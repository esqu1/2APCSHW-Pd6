import java.util.*;
public class Driver{

  public static void main(String[] args) {
    Maze m = new Maze(args[0]);
    m.solve(4,true);
    System.out.println(m);
  }

}
