import java.util.*;
import java.io.*;

public class MarBronze08{
    private static int[][] pasture;
    private static int elevation;
    private static int[][] instructions;
    
    
    public static run();
    
    public static void main(String[] args) throws IOException{
	BufferedReader f = new BufferedReader(new FileReader("test.in"));
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	System.out.println(f.readLine());

	StringTokenizer st = new StringTokenizer(f.readLine());
	StringTokenizer s = new StringTokenizer(st.nextToken());
	pasture = new int[Integer.parseInt(s.nextToken())][Integer.parseInt(s.nextToken())];
	elevation = Integer.parseInt(s.nextToken());
	instructions = new int[Integer.parseInt(s.nextToken())][3];
	
	
    }
}
