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
	if(i1 == i2){
	    return;
	}
	int temp = L[i1];
	L[i1] = L[i2];
	L[i2] = temp;
	
    }

    public static void partition(int[] L, int start, int end){
	//System.out.println("Start: " + start + ", End: " + end);
	
	if(start >= end){
	    return;
	}
	Random r = new Random();
	int pivot1 = L[start];
	int pivot2 = L[end];
	/*if(pivot1 == pivot2){
	    while(pivot1 == pivot2){
		pivot1 = L[(int)(Math.random() * (end - start)) + start];
	    }
	    }*/
	if(pivot1 > pivot2){
	    int temp = pivot1;
	    pivot1 = pivot2;
	    pivot2 = temp;
	}
	//System.out.println("Pivot: " + pivot1);
	//System.out.println("Pivot: " + pivot2);
	int low = start, mid = start, high = end, p1 = start, p2 = end;
	while(mid <= p2){
	    if(L[mid] < pivot1){
		swap(L,low,mid);
		if(p1 != low){
		    swap(L,mid,p1);
		}
		low++;
		p1++;
		mid++;
	    }else if(L[mid] == pivot1){
		swap(L,p1,mid);
		p1++;
		mid++;
	    }else if(L[mid] > pivot1 && L[mid] < pivot2){
		mid++;
	    }else if(L[mid] == pivot2){
		swap(L,p2,mid);
		p2--;
	    }else{
		swap(L,mid,high);
		if(p2 != high){
		    swap(L,p2,mid);
		}
		p2--;
		high--;
	    }	    
	    
	}
	


	//System.out.println(Arrays.toString(L));

	partition(L,start,low);
	partition(L,p1,p2);
	partition(L,high,end);
	
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
	int[] c5 = new int[100000];
	for(int i = 0; i < c5.length; i++){
	    c5[i] = 0;
	}

	int[] c = {4,2,7,3,7,0,1,34,6,8,2};
	quick(c);
	System.out.println(Arrays.toString(c));

	/*

	long startTime = System.currentTimeMillis();
	merge(c1);
	long endTime = System.currentTimeMillis();
	System.out.println("MergeSort: " + (endTime - startTime));
	*/
	long startTime = System.currentTimeMillis();
	quick(c2);
	long endTime = System.currentTimeMillis();
	System.out.println("QuickSort: " + (endTime - startTime));
	/*
	startTime = System.currentTimeMillis();
	radix(c3);
	endTime = System.currentTimeMillis();
	System.out.println("RadixSort: " + (endTime - startTime));
	
	startTime = System.currentTimeMillis();
	Arrays.sort(c4);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort(): " + (endTime - startTime));
	*/
	startTime = System.currentTimeMillis();
	quick(c5);
	endTime = System.currentTimeMillis();
	System.out.println("DupQuickSort: " + (endTime - startTime));

	
	


	
    }
    
}
