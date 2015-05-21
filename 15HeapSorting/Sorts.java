import java.util.*;
public class Sorts{
    
    // Stolen from my MyHeap code (the removeHelp function)
    public static void swapHelp(int index, int[] data){
	if(index * 2 + 1 >= data.length){ //check if it has a child
	    return;
	}
	if((data[index] <= data[index * 2 + 1]) && ((index*2 + 2 >= data.length) || (index * 2 + 1 < data.length &&  && data[index*2 + 1] >= data[index*2 + 2]))){
	    int temp = data[index];
	    data[index] = data[index * 2 + 1];
	    data[index * 2 + 1] = temp;
	    System.out.println(Arrays.toString(data));

	    swapHelp(index * 2 + 1,data);
	}else if(index * 2 + 2 < data.length && data[index] <= data[index * 2 + 2] && data[index*2 + 1] <= data[index*2 + 2]){
	    int temp = data[index];
	    data[index] = data[index * 2 + 2];
	    data[index * 2 + 2] = temp;
	    System.out.println(Arrays.toString(data));

	    swapHelp(index * 2 + 2,data);
	}
	
    }
    
    public static void heap(int[] L){
	int mark = 0;
	for(int i = L.length; i >= 0; i--){
	    if(2*i + 1 < L.length || 2*i + 2 < L.length){ // checks for first node with child from the last
		mark = i;
		break;
	    }
	}
	System.out.println(mark);

	for(int i = mark; i >= 0; i--){
	    swapHelp(i,L);
	}
	System.out.println(Arrays.toString(L));

	
	
    }

    public static void main(String[] args) {
	int[] L = {6,2,5,8,1,4,7,9};
	heap(L);
	System.out.println(Arrays.toString(L));

    }
}
