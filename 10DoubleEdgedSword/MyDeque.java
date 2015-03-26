import java.util.*;
public class MyDeque<T>{
  private Object[] list;
  private int head, tail;
  private int size;

  public MyDeque(){
    list = new Object[10];
    head = 0;
    tail = 0;
  }

  public void resize(){
    Object[] newlist = new Object[size * 2];
    for(int i = 0; i < size; i++){
      newlist[i] = list[(head + i) % size];
    }
    list = newlist;
    head = 0;
    tail = size - 1;
  }

  public void addFirst(T value){
    if(size == list.length){
      resize();
    }
    head--;
    if(head < 0){
      head += size;
    }
    list[head] = value;
    size += 1;
  }

  public void addLast(T value){

  }

  public T removeFirst(){

  }

  public T removeLast(){

  }

  public T getFirst(){

  }

  public T getLast(){

  }

  public static void main(String[] args){

  }
}
