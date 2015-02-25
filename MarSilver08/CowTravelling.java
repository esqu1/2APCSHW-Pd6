import java.io.*;
import java.util.*;

public class CowTravelling{
    private char[][] pasture;
    private int time;

    public static void main(String[] args) {
	Scanner s = new Scanner("ctravel.in");
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctravel.out")));
	pasture = new int[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	time = Integer.parseInt(s.next());
	
	
    }
}
