import java.util.*;
import java.io.*;

public class MarBronze08{
    private static int[][] pasture;
    private static int elevation;
    private static int[][] instructions;
    
    
    public static int run(){
	for(int[] ins : instructions){
	    int max = 9;
	    for(int i = ins[0]; i < ins[0] + 3; i++){
		for(int j = ins[1]; j < ins[1] + 3; j++){
		    if(pasture[i-1][j-1] > max){
			max = pasture[i-1][j-1];
		    }
		}
	    }
	    for(int i = ins[0]; i < ins[0] + 3; i++){
		for(int j = ins[1]; j < ins[1] + 3; j++){
		    if(pasture[i-1][j-1] > max - ins[2]){
			pasture[i-1][j-1] = max - ins[2];
		    }
		}
	    }
	}
	int total = 0;
	for(int[] row : pasture){
	    for(int elev : row){
		if(elev < elevation){
		    total += elevation - elev;
		}
	    }
	}
	return total * 72 * 72;
    }
    public static void main(String[] args) throws IOException{
	//BufferedReader f = new BufferedReader(new FileReader("makelake.in"));

	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("makelake.out")));
	//System.out.println(f.readLine());

	//StringTokenizer st = new StringTokenizer(f.readLine());
	//StringTokenizer s = new StringTokenizer(st.nextToken());

	Scanner s = new Scanner(new BufferedReader(new FileReader("makelake.in")));
	
	pasture = new int[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	elevation = Integer.parseInt(s.next());
	instructions = new int[Integer.parseInt(s.next())][3];
	for(int i = 0; i < pasture.length; i++){
	    for(int j = 0; j < pasture[0].length; j++){
		pasture[i][j] = Integer.parseInt(s.next());
	    }
	}
	for(int i = 0; i < instructions.length; i++){
	    for(int j = 0; j < instructions[0].length; j++){
		instructions[i][j] = Integer.parseInt(s.next());
	    }
	}

	
	out.println(run());
	out.close();
	s.close();
	
    }
}
