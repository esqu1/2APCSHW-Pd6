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
    /*if(isEmpty()){
      list[0] = t;
      ps[0] = priority;
      return;
    }
    for(int i = head-1; i != tail+1%size; i++){
      if(list[i] == null){
        insert(t,i,priority);
      }else if(priority > ps[i]){
        insert(t, i, priority);
      }
      head--;
      if(head < 0){
        head += list.length;
      }
      tail = (tail + 1) % list.length;
      return;
    }*/
    resizeps();
    addFirst(t);

    ps[head] = priority;
    size += 1;
  }

  public T remove(){
    int h = head;
    int t = tail;
    int loc;
    T thing = null;
    int minp = Integer.MAX_VALUE;
    while(h % size != t){
      if(ps[h%size] < maxp){
        thing = (T)list[h%size];
        maxp = ps[h%size];
	loc = h%size;
      }
      h++;
    }
    list[loc] = list[head];
    ps[loc] = ps[head];
    list[head] = null;
    size--;
    return thing;
  }

  public static void main(String[] args){
    MyDeque<Integer> m = new MyDeque<Integer>(2);
    m.add(6,5);
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    m.add(3,4);
    System.out.println(Arrays.toString(m.list));
    System.out.println(Arrays.toString(m.ps));
    System.out.println(m.head);
    System.out.println(m.tail);

  }
}
