import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> list;

    public MyStack(MyLinkedList<T> l){
	list = l;
    }

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

    public static void main(String[] args) {
	MyStack<Integer> s = new MyStack<Integer>(new MyLinkedList<Integer>());
	s.push(1);
	s.push(2);
	System.out.println(s.pop());
    }
	
	
			
}
