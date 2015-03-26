import java.util.*;
public class MyDeque<T>{
  public Object[] list;
  private int head, tail;
  private int size;

  public MyDeque(){
    list = new Object[10];
    head = 1;
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
      head += list.length;
    }
    list[head] = value;
    size += 1;

  }

  public void addLast(T value){
    resize();
    tail++;
    if(tail != 0 && tail >= list.length){
      tail -= list.length;
    }
    list[tail] = value;
    size += 1;

  }

  public T removeFirst(){
    T value = (T) list[head];
    list[head] = null;
    head++;
    if(head >= list.length){
      head -= list.length;
    }
    size--;
    return value;
  }

  public T removeLast(){
    T value = (T) list[tail];
    list[tail] = null;
    tail--;
    if(tail < 0){
      tail += list.length;
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
    m.addFirst(new Integer(7));
    System.out.println(m.getFirst());
    m.addFirst(new Integer(8));
    System.out.println(m.getFirst());
    m.addFirst(new Integer(5));
    System.out.println(m.getFirst());

    m.addFirst(new Integer(5));
    m.addFirst(new Integer(2));
    m.addFirst(new Integer(1));

    m.addFirst(new Integer(34));
    m.addFirst(new Integer(3));
    m.addFirst(new Integer(23));
    m.addFirst(new Integer(2));
    m.addFirst(new Integer(2));
    m.addFirst(new Integer(5));

    System.out.println(m.getFirst());

    m.addLast(new Integer(4));
    System.out.println(Arrays.toString(m.list));  
    System.out.println(m.getLast());
    System.out.println(m.removeLast());
    System.out.println(m.getLast());

  }
}
