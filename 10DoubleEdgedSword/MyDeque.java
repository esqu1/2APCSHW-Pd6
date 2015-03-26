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
    if(size == list.length){
      Object[] newlist = new Object[size * 2];
      for(int i = 0; i < size; i++){
        newlist[i] = list[(head + i) % size];
      }
      list = newlist;
      head = 0;
      tail = size - 1;
    }
  }

  public void addFirst(T value){
    resize();
    head--;
    if(head < 0){
      head += size;
    }
    list[head] = value;
    size += 1;
  }

  public void addLast(T value){
    resize();
    tail++;
    if(tail >= size){
      tail -= size;
    }
    list[tail] = value;
    size += 1;
  }

  public T removeFirst(){
    T value = (T) list[head];
    list[head] = null;
    head++;
    if(head >= size){
      head -= size;
    }
    size--;
    return value;
  }

  public T removeLast(){
    T value = (T) list[tail];
    list[tail] = null;
    tail--;
    if(tail < 0){
      tail += size;
    }
    size--;
    return value;
  }

  public T getFirst(){
    return (T) list[head];
  }

  public T getLast(){
    return (T) list[tail];
  }

  public static void main(String[] args){
    MyDeque<Integer> m = new MyDeque<Integer>();
  }
}
