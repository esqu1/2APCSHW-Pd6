import java.util.*;
public class MyDeque<T>{
  private Object[] list;
  private int[] ps;
  private int mode;
  private int head, tail;
  private int size;


  public MyDeque(){
    list = new Object[10];
    head = 1;
    tail = 0;
  }

  public MyDeque(int mode){
    this();
    this.mode = mode;
    ps = new int[10];
  }

  public boolean isEmpty(){
    try{
      T y = getFirst();
      return false;
    }catch(NullPointerException e){
      return true;
    }
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

  public void resizeps(){
    if(size == ps.length){
      int[] newlist = new int[size * 2];
      for(int i = 0; i < size; i++){
        newlist[i] = ps[(head + i) % size];
      }
      ps = newlist;
      head = 0;
      tail = size - 1;
    }
  }

  public void addFirst(T value){
    if(value == null){
      throw new NullPointerException();
    }
    resize();
    head--;
    if(head < 0){
      head += list.length;
    }
    list[head] = value;
    size += 1;

  }

  public void addLast(T value){
    if(value == null){
      throw new NullPointerException();
    }
    resize();
    tail++;
    if(tail != 0 && tail >= list.length){
      tail -= list.length;
    }
    list[tail] = value;
    size += 1;

  }

  public T removeFirst(){
    if(size == 0){
      throw new NoSuchElementException();
    }
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
    if(size == 0){
      throw new NoSuchElementException();
    }
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
    if(size == 0){
      throw new NoSuchElementException();
    }
    return (T) list[head];
  }

  public T getLast(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    return (T) list[tail];
  }

  public void add(T t, int priority){
    addFirst(t);
    resizeps();
    head--;
    if(head < 0){
      head += ps.length;
    }
    ps[head] = priority;
    size += 1;
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
    m.removeFirst();
    m.removeFirst();
    System.out.println(m.getFirst());
    m.addFirst(new Integer(3));
    System.out.println(m.getFirst());

  }
}
