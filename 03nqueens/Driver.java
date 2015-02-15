public class Driver{

    public static void main(String[] args){
	NQueens n = new NQueens(9);
	if(n.solve(0)){
	    System.out.println(n);
	}
    }
}
