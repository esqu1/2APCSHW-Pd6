import java.util.*;
public class MyQueue<T>{
    private LinkedList<T> list;

    public MyQueue(LinkedList<T> l){
	list = l;
    }

    public boolean add(T t){
	if(t == null){
	    throw new NullPointerException();
	}

    }
    
}
