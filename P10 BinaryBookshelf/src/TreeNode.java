//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P10 BinaryBookself
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang@wisc.edu
// Lecturer: Hobbes LeGault
//

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * @author ericr
 * models a node in a BST
 * @param <T>
 */
public class TreeNode<T> {

  private T data;
  private TreeNode<T> left;
  private TreeNode<T> right;
  
  /**
   * constructor for a node with only data as a param
   * @param data
   */
  public TreeNode (T data){
    this.data = data;
    this.left = null;
    this.right = null;
  }
  
  /**
   * constructor for node with two children nodes
   * @param data
   * @param left
   * @param right
   */
  public TreeNode (T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  /**
   * returns the dtat within a node
   * @return
   */
  public T getData () {
    return data;
  }
  
  /**
   * returns the left node of the current node
   * @return
   */
  public TreeNode<T> getLeft(){
    return left;
  }
  
  /**
   * returns the right node of the current node
   * @return
   */
  public TreeNode<T> getRight(){
    return right;
  }
  
  /**
   * sets the left node of the current node
   * @param left
   */
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }
  
  /**
   * sets the right node of the current node
   * @param right
   */
  public void setRight(TreeNode<T> right) {
    this.right = right;
  }
  
  /**
   * returns the current node as a string
   * @return
   */
  public String toStirng() {
    return data.toString();
  }
}
