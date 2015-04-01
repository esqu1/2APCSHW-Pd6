import java.util.*;
public class Coor{
	private int i1, i2, count;

	public Coor(int i1, int i2, int count){
		this.i1 = i1;
		this.i2 = i2;
		this.count = count;
	}

	public int get1(){
		return i1;
	}

	public int get2(){
		return i2;
	}

	public int getCount(){
		return count;
	}

	public String toString(){
		return "(" + i1 + "," + i2 + ")";
	}

}
