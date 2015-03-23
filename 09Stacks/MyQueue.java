import java.util.*;
public class MyQueue<T>{
    private MyLinkedList<T> list;

    public MyQueue(MyLinkedList<T> l){
	list = l;
    }

    public boolean add(T t){
	if(t == null){
	    throw new NullPointerException();
	}
	list.add(t);
	return true;
    }

    public T remove(){
	T lol = list.get(0);
	list.remove(0);
	return lol;
	
    }

    public static void main(String[] args) {
	MyQueue<Integer> q = new MyQueue<Integer>(new MyLinkedList<Integer>());
	q.add(2);
	q.add(4);
	System.out.println(q.remove());
	System.out.println(q.remove());

    }
    
}
