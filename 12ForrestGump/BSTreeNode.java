import java.io.*;
import java.util.*;

public class BSTreeNode<E extends Comparable>{
  private BSTreeNode<E> left, right;
  private E value;

  public BSTreeNode(){

  }

  public BSTreeNode(E e){
    value = e;
  }

  public void setLeft(BSTreeNode<E> groot){
    left = groot;
  }

  public void setRight(BSTreeNode<E> groot){
    right = groot;
  }

  public void setValue(E e){
    value = e;
  }

  public E getValue(){
    return value;
  }

  public BSTreeNode<E> getLeft(){
    return left;
  }

  public BSTreeNode<E> getRight(){
    return right;
  }
}
