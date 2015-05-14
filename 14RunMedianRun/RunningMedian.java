import java.util.*;
public class RunningMedian{
    private MyHeap h1, h2;
    private boolean oneValueOrNah;
    private int median;

    public RunningMedian(){
	h1 = new MyHeap(true); //max heap, left
	h2 = new MyHeap(false);//min heap, right
	oneValueOrNah = false;
    }

    public double getMedian(){
	return oneValueOrNah ? median : ((double) h1.peek() + h2.peek()) / 2;
    }

    public void add(int value){
	if(oneValueOrNah){
	    if(value > median){
		h1.add(median);
		h2.add(value);	
	    }else{
		h1.add(value);
		h2.add(median);
	    }
	    oneValueOrNah = false;
	}else{
	    if(value > h2.peek()){
		median = h2.remove();
		h2.add(value);
	    }else if(value < h1.peek()){
		median = h1.remove();
		h1.add(value);
	    }else{
		median = value;
	    }
	    oneValueOrNah = true;
	}
    }
}
