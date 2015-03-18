import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private class MyLLIterator<T> implements Iterator<T>{
	private LNode<T> current;

	public MyLLIterator(LNode<T> curl){
	    current = curl;
	}
	
	public boolean hasNext(){
	    try{
		current = current.getNext();
		return true;
	    }catch(Exception e){
		return false;
	    }
	}

	public T next(){
	    current = current.getNext();
	    if(current.getData() == null){
		
		throw new NoSuchElementException();
	    }
	    return current.getData();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    private LNode<T> first, last;
    private int size = 0;

    public Iterator<T> iterator(){
	return new MyLLIterator<T>();
    }

    public String name(){
	return "lin.brandon";
    }
    
    public String toString(){
	String result = "[ ";
	LNode<T> now = first;
	while(now != null){
		result += now.getData() + " ";
		now = now.getNext();
	}
	result += "]";
	return result;	
	    
    }

    public boolean add(T n){
	if(size() == 0){
	    first = new LNode<T>(n);
	    last = first;
	}else{
	    LNode<T> nyeh = new LNode<T>(n);
	    last.setNext(nyeh);
	    last = nyeh;
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public T get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == size() - 1){
	    return last.getData();
	}
	int n = 0;
	LNode<T> now = first;
	for (int i = 0; i < index; i++) {
	    now = now.getNext();
	}
	return now.getData();
    }

    public void set(int index, T value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == size() - 1){
	    last.setData(value);
	    return;
	}
	int n = 0;
	LNode<T> now = first;
	for (int i = 0; i < index; i++) {
	    now = now.getNext();
	}
	now.setData(value);
    }

    public int indexOf(T value){
	int n = 0;
	LNode<T> now = first;
	while(n < size()){
	    if(now.getData() == value){
		return n;
	    }
	    now = now.getNext();
	    n++;
	}
	return -1;
    }

    public void add(int index, T value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    LNode<T> nyeh = new LNode<T>(value,first);
	    first = nyeh;
	}else{
	    int n = 0;
	    LNode<T> now = first;
	    for (int i = 0; i < index - 1; i++) {
		now = now.getNext();
	    }
	    LNode<T> tobe = new LNode<T>(value,now.getNext());
	    now.setNext(tobe);
	    
	}
	size++;
    }

    public boolean remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    first = first.getNext();
	}else{
	    int n = 0;
	    LNode<T> now = first;
	    for (int i = 0; i < index - 1; i++) {
		now = now.getNext();
	    }
	    try{
		now.setNext(now.getNext().getNext());
	    }catch(NullPointerException e){
		now.setNext(null);
		last = now;
	    }
	}
	size--;
	return true;
    }

    public static void main(String[] args){
	MyLinkedList<Integer> l = new MyLinkedList<Integer>();
	l.add(3);
	l.add(4);
	l.remove(1);
	System.out.println(l.get(0));
	l.add(0,1);
	//System.out.println(l.get(1));
	System.out.println(l);
	l.add(1,8);
	l.add(1,9);
	System.out.println(l);
	System.out.println(l.indexOf(9));
	System.out.println(l.indexOf(123));
	l.remove(0);
	System.out.println(l);

	System.out.println(l.size());

	l.remove(l.size() - 1);
	System.out.println(l);
	System.out.println(l.get(1));
	System.out.println(l.get(0));






    }
    
}
