import java.util.*;
public class Sorts{

    public static String name(){
	return "lin.brandon";
    }


    public static void swap(int[] L, int i1, int i2){
	int temp = L[i1];
	L[i1] = L[i2];
	L[i2] = temp;
    }

    public static int partition(int[] L, int start, int end){
	Random r = new Random();
	int pivotindex = r.nextInt(end - start + 1) + start;
	int pivot = L[pivotindex];
	int count = start;
	int ender = end;
	swap(L,ender,pivotindex);
	

	
	for(int i = count; i < end; i++){
	    if(L[ender] > L[i]){
		swap(L,count,i);
		count++;
	    }
	}

	swap(L,ender,count);
	
	
	return count;
	
    }

    public static void qsh(int[] L, int start, int end){
	if(start >= end){	    return;
	}
	int pivotindex = partition(L,start,end);
	System.out.println(pivotindex);

	qsh(L,start,pivotindex);
	qsh(L,pivotindex+1,end);
    }

    public static void quickSort(int[] L){
	qsh(L,0,L.length-1);
    }

    public static void main(String[] args) {
	int[] L = new int[5];
	Random r = new Random();
	for (int i = 0; i < L.length; i++) {
	    //L[i] = r.nextInt(100);
	    L[i] = 0;
	}
	System.out.println(Arrays.toString(L));

	
	quickSort(L);
	System.out.println(Arrays.toString(L));

    }
    
}
