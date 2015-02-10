public class Maze{
    private char[][] maze;
    
    public void solveMazeH(char[][]maze, int x, int y){
	if(maze[x][y] == 'x'){
	    //return maze;
	}
	
    }

    public char[][] solveMaze(char[][] maze){
	this.maze = maze;
	int x = 0, y = 0;
	for(int i = 0; i < this.maze.length; i++){
	    for(int j = 0; j < this.maze[0].length; j++){
		if(maze[i][j] == 'S'){
		    x = i;
		    y = j;
		    break;
		}
	    }
	}
				     
	solveMazeH(this.maze, x, y);
	return this.maze;
    }
}
