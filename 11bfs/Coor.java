import java.util.*;
public class Coor{
	private int i1, i2;

	public Coor(int i1, int i2){
		this.i1 = i1;
		this.i2 = i2;
	}

	public int get1(){
		return i1;
	}

	public int get2(){
		return i2;
	}

	public String toString(){
		return "(" + i1 + "," + i2 + ")";
	}

}