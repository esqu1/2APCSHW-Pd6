import java.util.*;
public class Sorts{
    private static int count;
    
    public static int[] merge(int[] a, int[] b){
	//System.out.println("Merging: " + Arrays.toString(a) + Arrays.toString(b));

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
	//System.out.println("Output: " + Arrays.toString(result));

	return result;
    }

    public static int[] mergeS(int[] a){
	if(a.length <= 1){
	    return a;
	}
	
	return merge(mergeS(Arrays.copyOfRange(a,0,a.length / 2)), mergeS(Arrays.copyOfRange(a,a.length / 2, a.length)));
    }

    public static void mergesort(int[] a){
	int[] b = mergeS(a);
	for(int i = 0; i < a.length; i++){
	    a[i] = b[i];
	}
    }
    
    public static void main(String[] args){
	int[] test = new int[2000000];
	Random r = new Random();
	for(int i = 0; i < test.length; i++){
	    test[i] = r.nextInt(100);
	}
	int[] test2 = {63,54,6,23,5,55,89,10};
	long startTime = System.currentTimeMillis();
	mergesort(test);
	long endTime = System.currentTimeMillis();
	System.out.println(endTime - startTime);
    }
}
