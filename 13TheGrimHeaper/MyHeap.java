import java.util.*;
import java.io.*;
public class MyHeap{
    private int[] data;
    private int mode;
    private final int MAXHEAP = 0;
    private final int MINHEAP = 1;

    public MyHeap(){
	data = new int[2];
	mode = MAXHEAP;
    }
    
    public void resize(){
	if(data[0] == data.length - 1){
	    int[] newdata = new int[data.length * 2];
	    for (int i = 0; i < data.length; i++) {
		newdata[i] = data[i];
	    }
	}
	data = newdata;
    }

    public void add(int value){
	resize();
	data[data[0] + 1] = value;
    }
    
}
