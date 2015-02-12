public class Driver{

    public static void main(String[] args){
	int size = 0;
	try{
	    size = Integer.parseInt(args[0]);
	}catch(Exception e){
	    size = 5;
	}
	KnightsTour k = new KnightsTour(size);
	//System.out.println(k);
	if(k.solve(0,0,1)){
	    System.out.println(k);
	}else{
	    System.out.println("no solution");
	}
    }
}
