import java.io.*;
import java.util.*;

public class TreeNode<E>{
  private TreeNode<E> left, right;
  private E value;

  public void setLeft(TreeNode<E> groot){
    left = groot;
  }

  public void setRight(TreeNode<E> groot){
    right = groot;
  }

  public void setValue(E e){
    value = e;
  }

  public E getValue(){
    return value;
  }

  public TreeNode<E> getLeft(){
    return left;
  }

  public TreeNode<E> getRight(){
    return right;
  }
}
