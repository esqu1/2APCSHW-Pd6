public class NQueens{
    private char[][] board;
    
    public NQueens(int size){
	board = new char[size][size];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		board[i][j] = '.';
	    }
	}
    }

    public String name(){
	return "lin.brandon";
    }

    public String toString(){
	String out = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		out += board[i][j] + " ";
	    }
	    out += "\n";
	}
	return out;
    }

    public boolean solve(){
	for(int i = 0; i < board.length; i++){
	    if(solve(i)){
		return true;
	    }
	}
	return false;
    }

    public boolean solve(int x){
	board[0][x] = '@';
	boolean val = false;
	for(int i = 0; i < board[0].length; i++){
	    val = val || solveHelp(x,1,i);
	}
	if(val){
	    return true;
	}
	board[0][x] = '.';
	return false;
    }

    public boolean solveHelp(int x, int row, int col){
	if(row == board.length){
	    return true;
	}
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		if( !(row == i && row == j) && board[i][j] == '@' && ((Math.abs(row - i) == Math.abs(col - j)) || row == i || col == j) ){
		    return false;
		}
	    }
	}
	board[row][col] = '@';
	boolean valid = false;
	for(int i = 0; i < board[0].length; i++){
	    valid = valid || solveHelp(x,row+1,i);
	}
	if(valid){
	    return true;
	}
	board[row][col] = '.';
	return false;
    }

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
