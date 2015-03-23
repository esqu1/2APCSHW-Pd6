import java.util.*;
public class LNode<T>{
    private T data;
    private LNode<T> next;

    public String name(){
	return "lin.brandon";
    }
    
    public LNode(T n){
	data = n;
    }
    
    public LNode(T n, LNode<T> l){
	data = n;
	next = l;
    }
    
    public T getData(){
	return data;
    }

    public void setData(T n){
	data = n;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setNext(LNode<T> l){
	next = l;
    }

    
}
