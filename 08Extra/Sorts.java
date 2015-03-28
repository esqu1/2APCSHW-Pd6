import java.util.*;
public class Sorts{
    public static String name(){
	return "lin.brandon";
    }
    
    public static void merging(int[] a, int min, int mid, int max){
	int[] result = new int[max - min + 1];
	int count1 = min, count2 = mid, place = 0;
	while(place < result.length){
	    if(count1 >= mid){
		for(int i = count2; i < max; i++){
		    result[place] = a[i];
		    place++;
		}
	    }else if(count2 >= max - mid + 1){
		for(int i = count1; i < mid; i++){
		    result[place] = a[i];
		    place++;
 		}
	    }else if(a[count1] > a[count2]){
		result[place] = a[count2];
		count2++;
		place++;		
	    }else{
		result[place] = a[count1];
		count1++;
		place++;
	    }
	}
	for(int i : result){
	    a[min] = i;
	    min++;
	}
    }

    public static void mergeS(int[] a, int min, int max){
	System.out.println("Min: " + min + " Max: " + max );

	if(max - min <= 1){
	    return;
	}
	int mid = (max + min) / 2;
	mergeS(a,min, mid);
	mergeS(a,mid, max);
	merging(a,min, mid, max);
	
    }

    public static void merge(int[] a){
	if(a.length<= 1){
	    return;
	}	    
	mergeS(a,0,a.length / 2);
	mergeS(a,a.length / 2, a.length);
    }

    /////////////////////////
    // QUICK SORT
    /////////////////////////    
    public static void swap(int[] L, int i1, int i2){
	//if(i1 == i2) return;
	int temp = L[i1];
	L[i1] = L[i2];
	L[i2] = temp;
    }

    public static void insertion(int[] c, int start, int end){
	for(int i = start + 1; i <= end; i++){
	    int j = i;
	    int temp = c[j];
	    while(j > 0 && temp < c[j-1]){
		c[j] = c[j-1];
		j--;
	    }
	    c[j] = temp;
	}
    }

    public static void partition(int[] L, int start, int end){
	if(start >= end){
	    return;
	}
	
	if(end - start < 10){
	    insertion(L,start,end);
	    return;
	}
	int pivot = L[start];
	int low = start, mid = start, high = end;
	while(mid <= high){
	    if(L[mid] < pivot){
		swap(L,low,mid);
		low++;
		mid++;
	    }else if(L[mid] > pivot){
		swap(L,mid,high);
		high--;
	    }else{
		mid++;
	    }
	}
	partition(L,start,low);
	partition(L,mid,end);
	
    }

    public static void quick(int[] L){
	partition(L,0,L.length - 1);
    }

    ////////////////////
    // RADIX SORT
    ////////////////////
    public static void radix(int[] c){
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
	for(int i = 0; i < 10; i++){
	    bucket.add(new ArrayList<Integer>());
	}	    
	int digs = 0;
	while(true){		
	    for(int i = 0; i < c.length; i++){
		bucket.get((c[i] / (int)Math.pow(10,digs)) % 10).add(c[i]);
	    }
	    if(bucket.get(0).size() == c.length){
		return;
	    }
	    int counter = 0;
	    for(int i = 0; i < bucket.size(); i++){
		for(int j = 0; j < bucket.get(i).size(); j++){
		    c[counter] = bucket.get(i).get(j);
		    counter += 1;
		}
		bucket.get(i).clear();
	    }
	    digs += 1;
	}
    }

    public static void main(String[] args){
	int[] c1 = new int[10000000];
	Random r = new Random();
	for (int i = 0; i < c1.length; i++) {
	    c1[i] = r.nextInt(10000);
	}
	int[] c2 = Arrays.copyOf(c1,10000000);
	int[] c3 = Arrays.copyOf(c1,10000000);
	int[] c4 = Arrays.copyOf(c1,10000000);
	int[] c5 = Arrays.copyOf(c1,10000000);
	int[] c6 = Arrays.copyOf(c1,10000000);

	int[] c = {4,2,7,3,7,0,1,34,6,8,2};
	quick(c);
	System.out.println(Arrays.toString(c));
	
	long startTime = System.currentTimeMillis();
	merge(c1);
	long endTime = System.currentTimeMillis();
	System.out.println("MergeSort: " + (endTime - startTime));
	
        startTime = System.currentTimeMillis();
	quick(c2);
        endTime = System.currentTimeMillis();
	System.out.println("QuickSort 20: " + (endTime - startTime));

	
	startTime = System.currentTimeMillis();
	Arrays.sort(c6);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort(): " + (endTime - startTime));
       


	
	


	
    }
    
}
