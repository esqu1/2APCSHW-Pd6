import java.util.*;
public class Driver{

    public static void main(String[] args) {
	     Maze m = new Maze("data3.dat");
	      m.solveDFS(false);
        System.out.println(m);
    }

}
