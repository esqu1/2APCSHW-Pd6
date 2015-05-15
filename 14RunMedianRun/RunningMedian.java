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
	    if(h2.getSize() > 0 && value > h2.peek()){
		median = h2.remove();
		h2.add(value);
	    }else if(h1.getSize() > 0 && value < h1.peek()){
		median = h1.remove();
		h1.add(value);
	    }else{
		median = value;
	    }
	    oneValueOrNah = true;
	}
    }

    public static void main(String[] args) {
	RunningMedian r = new RunningMedian();
	r.add(5);
	r.add(6);
	r.add(7);
	r.add(4);
	r.add(3);
	r.add(2);
	r.add(8);
	r.add(1);
	r.add(9);
	System.out.println(r.getMedian());

    }
}
