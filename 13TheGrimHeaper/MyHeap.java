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

    public int compare(int a, int b){
	// for MAXHEAP: returns 1 if a > b, 0 otherwise.
	// for MINHEAP: returns 1 if a < b, 0 otherwise.
	// convention: compare(parent, child)
	return mode == MAXHEAP ? (a > b ? 1 : 0) : (a < b ? 1 : 0);
    }
	
    
    public void resize(){
	if(data[0] == data.length - 1){
	    int[] newdata = new int[data.length * 2];
	    for (int i = 0; i < data.length; i++) {
		newdata[i] = data[i];
	    }
	data = newdata;
	}
    }

    public void add(int value){
	resize();
	data[data[0] + 1] = value;
	data[0] += 1;
	addHelp(data[0] + 1);
    }

    public void addHelp(int index){
	if(compare(data[index / 2],data[index]) == 0){
	    int temp = data[index / 2];
	    data[index / 2] = data[index];
	    data[index] = temp;
	    addHelp(index / 2);
	}
    }

    public int remove(){
	int value = data[1];
	data[1] = data[data[0]];
	data[0] -= 1;
	removeHelp(1);
	return value;
    }

    public void removeHelp(int index){
	if(compare(data[index],data[index * 2]) == 0){
	    int temp = data[index];
	    data[index] = data[index * 2];
	    data[index * 2] = temp;
	    removeHelp(index * 2);
	}else if(compare(data[index],data[index * 2 + 1]) == 0){
	    int temp = data[index];
	    data[index] = data[index * 2 + 1];
	    data[index * 2 + 1] = temp;
	    removeHelp(index * 2 + 1);
	}
    }
    
}
