import java.util.*;
public class MyLinkedList{
    private LNode first;
    
    public String toString(){
	int result = "[ ";
	LNode now = first;
	while(true){
	    if(now != null){
		result += now.getData() + " ";
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
    }

    public int size(){
	int size = 0;
	LNode now = first;
	while(true){
	    if(now == null){
		break;
	    }
	    size += 1;
	    now = now.getNext();	    
	}
	return size;
    }

    
   
}
