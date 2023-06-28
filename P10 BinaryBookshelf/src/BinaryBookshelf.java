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
import java.util.ArrayList;
/**
 * models a BST full of books
 * @author ericr
 *
 */
public class BinaryBookshelf {

  private TreeNode<Book> root;
  private int size;
  private Attribute[] sortList;

  /**
   * constructor that takes in how the BST should be sorted
   * @param sortList
   * @throws IllegalArgumentException if length is not 4, has repeating elements,
   *  elements are null, or does not start with author
   */
  public BinaryBookshelf(Attribute[] sortList) throws IllegalArgumentException{
    //throws exceptions
    //length is not 4
    if(sortList.length != 4) { 
      throw new IllegalArgumentException("size not equal to 4");
    }
    //has null elements
    for(int i = 0; i<sortList.length; i++) {
      if (sortList[i].equals(null)) {
        throw new IllegalArgumentException("has null elements");
      }
    }
    //repeating elements
    for(int i = 0; i<sortList.length-1; i++) {
      for(int j = i+1; j<sortList.length; j++) {
        if(sortList[i].equals(sortList[j])) {
          throw new IllegalArgumentException("same elements");
        }
      }
    }
    //elements does not start with author
    if(!sortList[0].equals(Attribute.AUTHOR)) {
      throw new IllegalArgumentException("Author is not first element");
    }

    this.sortList = sortList;
    this.size = 0;
    this.root = null;
  }

  /**
   * resets this BST
   */
  public void clear() {
    this.size = 0;
    this.root = null;
  }

  /**
   * helper method to compare two books
   * @param one
   * @param two
   * @return a negative is one is less than two, 0 if equal, and a positive if one is more than two
   */
  public int compareToHelper(Book one, Book two) {
    for(int i = 0; i<sortList.length; i++) { //loop through all the elements
      if(one.compareTo(two, sortList[i]) != 0) { //if the two are not equal
        return one.compareTo(two, sortList[i]); //return which on is bigger/smaller
      }
    }
    return 0; //return 0 if completely equal
  }

  /**
   * returns if the BST contain book
   * @param book
   * @return
   */
  public boolean contains (Book book) {
    boolean doesContain = containHelper(book, root);
    return doesContain;
  }

  /**
   * recursive helper method for contains
   * @param book
   * @param current
   * @return
   */
  protected boolean containHelper(Book book, TreeNode<Book> current) {
    if(current != null) { //if current node is not null
      //if current book is the book were looking for, return true
      if(current.getData().equals(book)) {
        return true;
      }
      boolean toReturn = false;
      //traverse the left of the node
      if(containHelper(book, current.getLeft())==true) {
        toReturn = true;
      }
      //traverse the right node
      if(containHelper(book, current.getRight())==true) {
        toReturn = true;
      }    
      return toReturn;
    }
    //return false current node does not exist
    return false;
  }

  /**
   * returns a String of the order of the Attributes
   * @return
   */
  public String getAttributeOrder() {
    String toReturn = "";
    //loop through sortList and add elements
    for (int i = 0; i < sortList.length; i++) {
      toReturn = toReturn + (i+1) + ":" + sortList[i];
      if(i != 3) {
        toReturn = toReturn + " ";
      }
    }
    //returning the String
    return toReturn;
  }

  /**
   * method to return all book by author
   * @param authorName
   * @return
   */
  public ArrayList<Book> getBooksByAuthor​(String authorName) {
    return getBooksByAuthorHelper​(authorName, root);
  }

  /**
   * recursive helper method to traverse BST
   * @param authorName
   * @param current
   * @return
   */
  protected ArrayList<Book> getBooksByAuthorHelper​(String authorName, TreeNode<Book> current) {
    //return arrylist
    ArrayList<Book> toReturn = new ArrayList<Book>();
    //if current node is not null
    if(current != null) {
      //add all books of the left hand node and its children if author matches
      if(current.getLeft() != null) {
        toReturn.addAll(getBooksByAuthorHelper​(authorName, current.getLeft()));
      }
      //add the current book if the author matches
      if(authorName.equals(current.getData().getAuthor())) {
        toReturn.add(current.getData());
      }
      //add all books of the right hand node and its children if author matches
      if(current.getRight() != null) {
        toReturn.addAll(getBooksByAuthorHelper​(authorName, current.getRight()));
      }
    }
    //return arrylist: empty if current node is null node,
    return toReturn;
  }

  /**
   * method to return the root of this BST
   * @return
   */
  protected TreeNode<Book> getRoot() {
    return root; 
  }

  /**
   * method that adds a book to the BST where it belongs
   * @param book
   * @throws IllegalArgumentException if the book to be added is already in BST
   */
  public void insertBook(Book book) throws IllegalArgumentException {
    //throw exception if book is in BST already
    if(contains(book)) {
      throw new IllegalArgumentException("book is already in BST");
    }
    insertBookHelper(book, root);
  }

  /**
   * recursive helper method to traverse BST
   * @param book
   * @param current
   */
  public void insertBookHelper(Book book, TreeNode<Book> current) {
    //base cases
    //add at root
    if(size==0) {
      root = new TreeNode<Book>(book);
      size++;
    }
    //add at left node
    else if(current.getLeft() == null) {
      current.setLeft(new TreeNode<Book>(book));
      size++;
    }
    //add at right node
    else if(current.getRight() == null) {
      current.setRight(new TreeNode<Book>(book));
      size++;
    }
    //traversing BST to call function recursively 
    else {
      if(compareToHelper(current.getData(), book)<0) {
        insertBookHelper(book, current.getLeft());
      }
      if(compareToHelper(current.getData(), book)>=0) {
        insertBookHelper(book, current.getRight());
      } 
    }
  }

  /**
   * method to return if BST is empty
   * @return
   */
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    return false;
  }

  /**
   * method that returns the size of BST
   * @return
   */
  public int size() {
    return size;
  }

  /**
   * method that returns BST as a String
   */
  public String toString() {
    String toReturn = toStringHelper(root);
    return toReturn;
  }

  /**
   * Recursive helper method to traverse BST
   * @param current
   * @return
   */
  public String toStringHelper(TreeNode<Book> current) {
    //return String
    String toReturn = "";
    if(current != null) {
      //traverse left side
      if(current.getLeft() != null) {
        toReturn += toStringHelper(current.getLeft());
      }
      //add current node
      toReturn += "\n" + current.getData().toString();
      //traverse right side
      if(current.getRight() != null) {
        toReturn += toStringHelper(current.getRight());
      }
    }
    return toReturn;
  }
}
