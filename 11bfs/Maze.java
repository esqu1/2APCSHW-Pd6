import java.util.*;
import java.io.*;

public class Maze{
  private char[][] maze;
  private int maxx,maxy;
  private int startx,starty;
  private Deque<Coor> deque;
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
        ans += color(38,47)+c;
      }else{
        ans += color(32,40)+c;
      }
    }
    return hide + go(0,0) + ans + "\n" + show + color(37,40);
  }

  public boolean solveBFS(boolean animate){
    return bfshelp(startx, starty, 1, animate);
  }

  public boolean bfshelp(int x, int y, int count, boolean animate){
    deque.addFirst(new Coor(startx, starty));
    Coor c = deque.removeLast();
    if(maze[c.get1()][c.get2()]  == '#'){
      return false;
    }
    if(maze[c.get1()][c.get2()]) == 'E'){

      return true;
    }

    /*
    if(c.get1() > 0 && maze[c.get1() - 1][c.get2()] == ' '){
    deque.addFirst(new Coor(c.get() - 1,c.get2());
    maze[c.get() - 1][c.get2()] = (char)count;
    count++;
  }
  if(c.get1() < maze.length && maze[c.get1() + 1][c.get2()] == ' '){
  deque.addFirst(new Coor(c.get() + 1,c.get2());
  maze[c.get() + 1][c.get2()] = (char)count;
  count++;
}
if(c.get1() > 0 && maze[c.get1() - 1][c.get2()] == ' '){
deque.addFirst(new Coor(c.get() - 1,c.get2());
maze[c.get() - 1][c.get2()] = (char)count;
count++;
}
if(c.get1() > 0 && maze[c.get1() - 1][c.get2()] == ' '){
deque.addFirst(new Coor(c.get() - 1,c.get2());
maze[c.get() - 1][c.get2()] = (char)count;
count++;
}*/

}
}
}
