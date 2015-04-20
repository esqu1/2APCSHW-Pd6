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
    /*try{
      T y = getFirst();
      return false;
    }catch(Exception e){
      return true;
    }*/
    return size == 0;
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

  private void insert(T t, int place, int priority){
    resize();
    resizeps();
    T temp = (T)list[place];
    list[place] = t;
    T temp2 = null;
    int ptemp = ps[place];
    ps[place] = priority;
    int ptemp2 = 0;
    for(int i = place+1; i != tail; i++){
      temp2 = (T)list[i%size];
      list[i%size] = temp;
      temp = temp2;
      ptemp2 = ps[i%size];
      ps[i%size] = ptemp;
      ptemp = ptemp2;
    }
  }

  public void add(T t, int priority){
    resizeps();
    addFirst(t);
    ps[head] = priority;
  }

  public T remove(){
    if(size == 1){
      T thingy = removeFirst();
      return thingy;
    }
    int h = head;
    int t = tail;
    int loc = 0;
    T thing = null;
    int minp = Integer.MAX_VALUE;
    while(h % list.length != t){
      if(ps[h%list.length] < minp){
        thing = (T)list[h%list.length];
        minp = ps[h%list.length];
	      loc = h%list.length;
      }
      h++;
    }
    list[loc] = list[head];
    ps[loc] = ps[head];
    list[head] = null;
    size--;
    head = (head + 1) % list.length;
    return thing;
  }

  public static void main(String[] args){
    MyDeque<Integer> m = new MyDeque<Integer>(2);
    m.add(6,5);
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    System.out.println(m.remove());
    /*
    m.add(3,4);
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    System.out.println(m.head);
    System.out.println(m.tail);
    m.add(2,5);
    m.add(123,1);
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    System.out.println(m.head);
    System.out.println(m.tail);
    System.out.println(m.remove());
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    System.out.println(m.size);
    System.out.println(m.head);
    System.out.println(m.tail);
    System.out.println(m.remove());
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    System.out.println(m.size);
    m.add(12,3);
    m.add(1,6);
    m.add(9,7);
    m.add(4,2);
    m.add(7,9);
    m.add(3,6);
    m.add(12,12);
    m.add(4,2);
    m.add(2,1);
    m.add(3,4);
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));*/


  }
}
