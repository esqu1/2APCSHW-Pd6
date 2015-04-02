import java.util.*;
import java.io.*;

public class Maze{
  private char[][] maze;
  private int[][] para;
  private int[] solution;
  private int maxx,maxy;
  private int startx,starty;
  private MyDeque<Coor> deque = new MyDeque<Coor>();
  //Terminal keycodes to clear the terminal, or hide/show the cursor
  private String clear =  "\033[2J";
  private String hide =  "\033[?25l";
  private String show =  "\033[?25h";

  public Maze(String filename){
    startx = -1;
    starty = -1;
    //read the whole maze into a single string first
    String ans = "";
    try{
      Scanner in = new Scanner(new File(filename));

      //keep reading next line
      while(in.hasNext()){
        String line = in.nextLine();
        if(maxy == 0){
          //calculate width of the maze
          maxx = line.length();
        }
        //every new line add 1 to the height of the maze
        maxy++;
        ans += line;
      }
    }
    catch(Exception e){
      System.out.println("File: " + filename + " could not be opened.");
      e.printStackTrace();
      System.exit(0);
    }

    //copy from the single string to a 2D array
    maze = new char[maxx][maxy];
    for(int i = 0; i < ans.length(); i++){
      char c = ans.charAt(i);
      maze[i % maxx][i / maxx] = c;
      if(c == 'S'){
        startx = i % maxx;
        starty = i / maxx;
      }
    }
    para = new int[maze.length][maze[0].length];
  }

  //terminal specific character to move the cursor
  private String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
  }


  private String color(int foreground,int background){
    return ("\033[0;" + foreground + ";" + background + "m");
  }

  public void clearTerminal(){
    System.out.println(clear);
  }

  public void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public String toString(){
    String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
    for(int i = 0; i < maxx * maxy; i++){
      if(i % maxx == 0 && i != 0){
        ans += "\n";
      }
      char c =  maze[i % maxx][i / maxx];
      if(c == '#'){
        ans += c;
      }else{
        ans += c;
      }
    }
    ans += "\n\n\n";
    /*
    for(int i = 0; i < maxx * maxy; i++){
    if(i % maxx == 0 && i != 0){
    ans += "\n";
  }
  int c =  para[i % maxx][i / maxx];
  if(c == '#'){
  ans += c;
}else{
ans += c;
}
}*/
return hide + go(0,0) + ans + "\n" + show;
}

public void aha(int a, int b, int fin){
  solution = new int[fin * 2];
  solution[solution.length - 1] = a;
  solution[solution.length - 2] = b;
  int count = solution.length - 3;
  while(count > 0 && maze[a][b] != 'S'){
    int[][] set = {
      {a,b-1},
      {a,b+1},
      {a-1,b},
      {a+1,b}
    };
    for(int[] neigh : set){
      if(para[neigh[0]][neigh[1]] == fin - 1){
        maze[neigh[0]][neigh[1]] = '.';
        solution[count] = neigh[0];
        count--;
        solution[count] = neigh[1];
        a = neigh[0];
        b = neigh[1];
        count--;
        fin--;
        break;
      }
    }
  }
}

public void sweep(){
  for(int i = 0; i < maze.length; i++){
    for(int j = 0; j < maze[0].length; j++){
      if(maze[i][j] == 'x' && maze[i][j] != 'S'){
        maze[i][j] = ' ';
      }
    }
  }
}

public boolean solveBFS(boolean animate){
  deque.addLast(new Coor(startx, starty,1));
  while(!deque.isEmpty()){
    Coor c = deque.removeFirst();
    int a = c.get1();
    int b = c.get2();
    int[][] set = {
      {a,b-1},
      {a,b+1},
      {a-1,b},
      {a+1,b}
    };
    for(int[] neigh : set){
      if(maze[neigh[0]][neigh[1]] == 'E'){
        maze[a][b] = 'x';
        para[a][b] = c.getCount();
        para[neigh[0]][neigh[1]] = c.getCount() + 1;
        aha(neigh[0],neigh[1],c.getCount()+1);
        sweep();
        return true;
      }if(maze[neigh[0]][neigh[1]] == ' '){
        para[a][b] = c.getCount();
        deque.addLast(new Coor(neigh[0],neigh[1],c.getCount() + 1));
        maze[a][b] = 'x';
      }
    }

  }
  return false;
}
}
