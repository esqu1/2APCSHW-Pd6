import java.util.*;
public class Driver{

  public static void main(String[] args) {
    Maze m = new Maze(args[0]);
    m.solve(Integer.parseInt(args[1]),true);
    //System.out.println(m);
    System.out.println(Arrays.toString(m.solutionCoordinates()));
  }

}
