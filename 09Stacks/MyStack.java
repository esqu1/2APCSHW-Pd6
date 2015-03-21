import java.util.*;
public class MyStack<T>{
    private LinkedList<T> list;

    public T push(T item){
	list.add(0,item);
	return item;
    }

    public T pop(){
	T s = list.get(0);
	list.remove(0);
	return s;
    }

    public T peek(){
	return list.get(0);
    }

    public boolean empty(){
	return list.size() == 0;
    }
	
	
			
}
