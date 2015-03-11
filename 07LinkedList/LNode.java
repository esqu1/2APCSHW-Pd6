import java.util.*;
public class LNode{
    private int data;
    private LNode next;
    
    public LNode(){
	data = 0;
    }

    public LNode(int n){
	data = n;
    }
    
    public LNode(int n, LNode l){
	data = n;
	next = l;
    }
    
    public int getData(){
	return data;
    }

    public void setData(int n){
	data = n;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode l){
	next = l;
    }

    
}
