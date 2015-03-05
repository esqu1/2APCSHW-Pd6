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
	System.out.println(pivotindex);

	for(int i = start; i <= end; i++){
	    if(L[i] < L[pivotindex]){
		other[start] = L[i];
		start++;
	    }else if(L[i] > L[pivotindex]){
		other[end] = L[i];
		end--;
	    }
	}
	other[start] = L[pivotindex];
	for(int i = start; i <= end; i++){
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
