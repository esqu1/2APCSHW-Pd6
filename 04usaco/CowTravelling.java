import java.io.*;
import java.util.*;

public class CowTravelling{
    private static char[][] pasture;
    private static int time;
    private static int x1,y1,x2,y2;
    private static int[][] dp;
    

    public static int find(int a, int b, int ttime){
	if(a < 0 || a >= pasture.length || b < 0 || b >= pasture[0].length){
	    return 0;
	}
	if(time == ttime && (a != x2 || b != y2)){
	    return 0;
	}
	if(time == ttime && a == x2 && b == y2){
	    return 1;
	}
	if(pasture[a][b] == '*'){
	    return 0;
	}
	return find(a+1,b,ttime+1) + find(a-1,b,ttime+1) + find(a,b+1,ttime+1) + find(a,b-1,ttime+1);
	
    }

    public static void main(String[] args) throws Exception{
	Scanner s = new Scanner(new BufferedReader(new FileReader("ctravel.in")));
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctravel.out")));
	pasture = new char[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	dp = new int[pasture.length][pasture[0].length];
	time = Integer.parseInt(s.next());
	for(int i = 0; i < pasture.length; i++){
	    String t = s.next();
	    for(int j = 0; j < pasture[0].length; j++){
		pasture[i][j] = t.charAt(j);
	    }
	}
	x1 = Integer.parseInt(s.next()) - 1;
	y1 = Integer.parseInt(s.next()) - 1;
	x2 = Integer.parseInt(s.next()) - 1;
	y2 = Integer.parseInt(s.next()) - 1;
	out.write(find(x1,y1,0) + "\n");
	System.out.println(find(x1,y1,0));

    }
}
