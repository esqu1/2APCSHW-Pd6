public class Driver{

    public static void main(String[] args){
	int size;
	try{
	    size = Integer.parseInt(args[0]);
	}catch(Exception e){
	    size = 8;
	}
	NQueens n = new NQueens(size);
	if(n.solve()){
	    System.out.println(n);
	}
    }
}
