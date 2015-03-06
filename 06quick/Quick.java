import java.util.*;
public class Quick{

    public static void partition(int[] L, int start, int end){
	int[] other = new int[L.length];
	for(int i = 0; i < L.length; i++){
	    if(i < start || i > end){
		other[i] = L[i];
	    }
	}
	System.out.println(Arrays.toString(other));

	Random r = new Random();
	int pivotindex = r.nextInt(end - start + 1) + start;
	System.out.println(L[pivotindex]);
	int min = start;
	int max = end;

	for(int i = min; i <= max; i++){
	    System.out.println(L[i]);

	    if(L[i] < L[pivotindex]){
		other[start] = L[i];
		start++;
	    }else if(L[i] > L[pivotindex]){
		other[end] = L[i];
		end--;
	    }
	    System.out.println("NYEH" + Arrays.toString(other));

	}
	
	other[start] = L[pivotindex];
	System.out.println(Arrays.toString(other));

	for(int i = 0; i < L.length; i++){
	    L[i] = other[i];
	}

	
    }

    public static void main(String[] args) {
	int[] L = {5,7,8,23,56,15,59,35,60,24,36,57};
	System.out.println(Arrays.toString(L));

	partition(L,3,9);
	System.out.println(Arrays.toString(L));

    }
    
}
