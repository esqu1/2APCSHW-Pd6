public class NQueens{
    private int[][] board;
    
    public NQueens(int size){
	board = new int[size][size];
    }

    public String name(){
	return "Lin,Brandon";
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

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
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
	board[0][x] = 1;
	boolean val = false;
	for(int i = 0; i < board[0].length; i++){
	    val = val || solveHelp(x,1,i);
	}
	if(val){
	    return true;
	}
	board[0][x] = 0;
	return false;
    }

    public boolean solveHelp(int x, int row, int col){
	//System.out.println(row + "." + col);
	//System.out.println(this);
	//wait(20);
	boolean valid = true;
	if(row == board.length){
	    return true;
	}
	if(col == board[0].length){
	    return false;
	}
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		//System.out.println(board[i][j]);
		//System.out.println(i + " " + j);
		//System.out.println(row + "?" + col);
		if( !(row == i && row == j) && board[i][j] == 1 && ((Math.abs(row - i) == Math.abs(col - j)) || row == i || col == j) ){
		    //System.out.println("meh");
		    valid = false;
		    break;
		}
	    }
	}

	if(!valid){
	    return false;
	}

	board[row][col] = 1;
	valid = false;
	for(int i = 0; i < board[0].length; i++){
	    valid = valid || solveHelp(x,row+1,i);
	}
	if(valid){
	    return true;
	}
	board[row][col] = 0;
	return false;
    }
		
}
