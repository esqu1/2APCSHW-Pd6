import java.util.*;
public class MergeSort{

    public static int[] mh(int[] a, int[] b, int count1, int count2, int count3, int[] result){
	
	if(count1 >= a.length){
	    for(int i = count2; i < b.length; i++){
		result[i+count3-count2] = b[i];
	    }
	    return result;
	}
	if(count2 >= b.length){
	    for(int i = count1; i < a.length; i++){
		result[i+count3-count1] = a[i];
	    }
	    return result;
	}	    
	if(a[count1] > b[count2]){
	    result[count3] = b[count2];
	    return mh(a,b,count1,count2+1,count3+1,result);
	}else{
	    result[count3] = a[count1];
	    return mh(a,b,count1+1,count2,count3+1,result);
	}
			
    }
    
    public static int[] merge(int[] a, int[] b){
	int[] result = new int[a.length + b.length];
	return mh(a,b,0,0,0,result);
    }

    public static int[] mergeS(int[] a){
	if(a.length == 1){
	    return a;
	}
	int[] half1 = new int[a.length / 2];
	int[] half2 = new int[a.length - (a.length / 2)];
	for(int i = 0; i < half1.length; i++){
	    half1[i] = a[i];
	}
	for(int i = a.length / 2; i < a.length; i++){
	    half2[i - a.length / 2] = a[i];
	}
	return merge(mergeS(half1), mergeS(half2));
    }

    public static void mergeSort(int[] a){
	int[] b = mergeSort(a);
	for(int i = 0; i < a.length; i++){
	    a[i] = b[i];
	}
    }
    
    public static void main(String[] args){
	int[] test = new int[200000];
	Random r = new Random();
	for(int i = 0; i < test.length; i++){
	    test[i] = r.nextInt(100);
	}
	int[] test2 = {63,54,6,23,5,55,89,10};
	long startTime = System.currentTimeMillis();
	System.out.println(Arrays.toString(mergeSort(test)));
	long endTime = System.currentTimeMillis();
	System.out.println(endTime - startTime);
	


    }
}
