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
		
}
