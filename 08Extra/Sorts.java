import java.util.*;
public class Sorts{
    private static int count;

    public static String name(){
	return "lin.brandon";
    }
    
    public static int[] merging(int[] a, int[] b){
	int[] result = new int[a.length + b.length];
	int count1 = 0, count2 = 0, place = 0;
	while(place < result.length){
	    if(count1 >= a.length){
		for(int i = count2; i < b.length; i++){
		    result[place] = b[i];
		    place++;
		}
	    }else if(count2 >= b.length){
		for(int i = count1; i < a.length; i++){
		    result[place] = a[i];
		    place++;
		}
	    }else if(a[count1] > b[count2]){
		result[place] = b[count2];
		count2++;
		place++;		
	    }else{
		result[place] = a[count1];
		count1++;
		place++;
	    }
	}
	return result;
    }

    public static int[] mergeS(int[] a){
	if(a.length <= 1){
	    return a;
	}
	return merging(mergeS(Arrays.copyOfRange(a,0,a.length / 2)), mergeS(Arrays.copyOfRange(a,a.length / 2, a.length)));
    }

    public static void merge(int[] a){
	int[] b = mergeS(a);
	for(int i = 0; i < a.length; i++){
	    a[i] = b[i];
	}
    }

    /////////////////////////
    // QUICK SORT
    /////////////////////////    
    public static void swap(int[] L, int i1, int i2){
	int temp = L[i1];
	L[i1] = L[i2];
	L[i2] = temp;
    }

    public static int partition(int[] L, int start, int end){
	int pivot = L[(int)(Math.random() * (end - start)) + start];
	int low = 0, mid = 0, high = L.length - 1;
	while(mid <= hi){
	    if(L[mid] < pivot){
		swap(low,mid);
		low++;
		mid++;
	    }else if(L[mid] > pivot){
		swap(mid,high);
		high--;
	    }else{
		mid++;
	    }       
	return count;
    }

    public static void qsh(int[] L, int start, int end){
	if(start >= end){return;}
	int pivotindex = partition(L,start,end);
	qsh(L,start,pivotindex);
	qsh(L,pivotindex+1,end);
    }

    public static void quick(int[] L){
	qsh(L,0,L.length-1);
    }

    ////////////////////
    // RADIX SORT
    ////////////////////
    public static void radix(int[] c){
	ArrayList<Integer>[] bucket = new ArrayList<Integer>[10];
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
	

	long startTime = System.currentTimeMillis();
	merge(c1);
	long endTime = System.currentTimeMillis();
	System.out.println("MergeSort: " + (endTime - startTime));

	startTime = System.currentTimeMillis();
	quick(c2);
	endTime = System.currentTimeMillis();
	System.out.println("QuickSort: " + (endTime - startTime));

	startTime = System.currentTimeMillis();
	radix(c3);
	endTime = System.currentTimeMillis();
	System.out.println("RadixSort: " + (endTime - startTime));

	startTime = System.currentTimeMillis();
	Arrays.sort(c4);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort(): " + (endTime - startTime));





	
    }
    
}
