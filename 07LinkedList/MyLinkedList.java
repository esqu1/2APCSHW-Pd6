import java.util.*;
public class MyLinkedList{
    private LNode first;
    private int size = 0;
    
    public String toString(){
	String result = "[ ";
	LNode now = first;
	while(true){
	    if(now != null){
		result += now.getData() + " ";
		now = now.getNext();
	    }else{
		break;
	    }
	}
	result += "]";
	return result;	
	    
    }

    public void add(int n){
	if(size() == 0){
	    first = new LNode(n);
	}else{
	    LNode now = first;
	    for (int i = 0; i < size() - 1; i++) {
		now = now.getNext();
	    }
	    now.setNext(new LNode(n));
	}
	size++;
    }

    public int size(){
	return size;
    }

    public int get(int index){
	int n = 0;
	LNode now = first;
	for (int i = 0; i < index; i++) {
	    now = now.getNext();
	}
	return now.getData();
    }

    public void set(int index, int value){
	int n = 0;
	LNode now = first;
	for (int i = 0; i < index; i++) {
	    now = now.getNext();
	}
	now.setData(value);
    }

    public int indexOf(int value){
	int n = 0;
	LNode now = first;
	while(true){
	    if(now.getData() == value){
		return n;
	    }
	    now = now.getNext();
	    n++;
	}
    }

    public void add(int index, int value){
	if(index == 0){
	    LNode nyeh = new LNode(value,first);
	    first = nyeh;
	}else{
	    int n = 0;
	    LNode now = first;
	    for (int i = 0; i < index - 1; i++) {
		now = now.getNext();
	    }
	    LNode tobe = new LNode(value,now.getNext());
	    now.setNext(tobe);
	    size++;
	}
    }

    public void remove(int index){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    first = first.getNext();
	}
	int n = 0;
	LNode now = first;
	for (int i = 0; i < index - 1; i++) {
	    now = now.getNext();
	}
	try{
	    now.setNext(now.getNext().getNext());
	}catch(NullPointerException e){
	    now.setNext(null);
	}
	size--;
    }

    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
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

    }
    
}
