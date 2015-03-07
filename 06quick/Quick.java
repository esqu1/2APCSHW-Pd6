import java.util.*;
public class Quick{

    public static int quickselect(int n, int[] L){
	return partition(L,0,L.length - 1, n);
	
    }

    public static int partition(int[] L, int start, int end, int findindex){
	int[] other = new int[L.length];
	for(int i = 0; i < L.length; i++){
	    if(i < start || i > end){
		other[i] = L[i];
	    }
	}
	

	Random r = new Random();
	int pivotindex = r.nextInt(end - start + 1) + start;
	//System.out.println(pivotindex);


	int min = start;
	int max = end;

	for(int i = start; i <= end; i++){
	    

	    if(L[i] < L[pivotindex]){
		other[min] = L[i];
		min++;
	    }else if(L[i] > L[pivotindex]){
		other[max] = L[i];
		max--;
	    }
	    

	}
	other[min] = L[pivotindex];
	//System.out.println("Continue: " + Arrays.toString(other));

	
	if(min == findindex){
	    //System.out.println("Final List: " + Arrays.toString(other));
	    return other[min];
	}
	
	

	for(int i = 0; i < L.length; i++){
	    L[i] = other[i];
	}

	
	if(min > findindex){
	    return partition(L,start, min - 1, findindex);
	}
	return partition(L, min + 1, end, findindex);
	
    }

    public static void main(String[] args) {
	int[] L = {5,7,8,23,56,15,59,35,60,24,36,57};
	System.out.println(Arrays.toString(L));
	for (int i = 0; i < L.length; i++) {
	    System.out.println("Final: " + quickselect(i,L));
	    L = new int[] {5,7,8,23,56,15,59,35,60,24,36,57};
	    }
	System.out.println(quickselect(4,L));
	Arrays.sort(L);
	System.out.println(Arrays.toString(L));


	

	

    }
    
}
