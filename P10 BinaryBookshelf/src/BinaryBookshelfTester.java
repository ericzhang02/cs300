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
public class BinaryBookshelfTester {

  /**
   * tester method to test TreeNode
   * @return
   */
  public static boolean testTreeNode() {
    //test 1
    TreeNode<Integer> tester1 = new TreeNode<Integer>(6);
    //make sure left is null
    if(tester1.getLeft() != null) {
      return false;
    }
    //make sure right is null
    if(tester1.getRight() != null) {
      return false;
    }
    //make sure the data is 6
    if (tester1.getData() != 6) {
      return false;
    }
    //make sure the two string returns "6"
    if (!tester1.getData().toString().equals("6")) {
      return false;
    }
    //test 2
    TreeNode<Integer> tester2 = new TreeNode<Integer>(3);
    TreeNode<Integer> tester3 = new TreeNode<Integer>(4);
    tester2.setRight(tester3);
    tester2.setLeft(tester1);
    //make sure child nodes are not null
    if(tester2.getLeft() == null || tester2.getRight() == null) {
      return false;
    }
    //make sure child nodes return the right integers
    if(tester2.getLeft().getData() != 6 || tester2.getRight().getData() != 4) {
      return false;
    }
    //make sure child nodes children are null as well
    if(tester3.getLeft() != null || tester3.getRight() != null) {
      return false;
    }
    //reset the root node
    tester2.setRight(null);
    tester2.setLeft(null);
    //check if the root nodes children are null
    if(tester2.getLeft() != null || tester2.getRight() != null) {
      return false;
    }
    //test 3
    TreeNode<Integer> tester4 = new TreeNode<Integer>(8);
    TreeNode<Integer> tester5 = new TreeNode<Integer>(10);
    TreeNode<Integer> tester6 = new TreeNode<Integer>(9, tester4, tester5);
    //checking that node4s children are null and the data is 8
    if(tester4.getLeft() != null || tester4.getRight() != null || tester4.getData() != 8) {
      return false;
    }
    //checking that node5s children are null and the datat is 10
    if(tester5.getLeft() != null || tester5.getRight() != null || tester5.getData() != 10) {
      return false;
    }
    //checking that node6 returns 8 and its children node return the corect data
    if(tester6.getLeft().getData() != 8 || tester6.getRight().getData() != 10
        || tester6.getData() != 9) {
      return false;
    }
    return true;
  }

  /**
   * tester method to test an empty BST
   * @return
   * @throws IllegalArgumentException if an input is invalid
   */
  public static boolean testEmptyTree() throws IllegalArgumentException {
    //invalid inputs
    //test 1
    try {
      //empty arry
      Attribute[] arry1 = new Attribute[4];
      BinaryBookshelf tester1 = new BinaryBookshelf(arry1);
      return false;
    }catch (Exception IllegalArgumentException) {
    }
    //test 2
    try {
      //arry list is not 4
      Attribute[] arry2 = new Attribute[]{Attribute.ID, Attribute.AUTHOR, Attribute.PAGECOUNT};
      BinaryBookshelf tester2 = new BinaryBookshelf(arry2);
      return false;
    } catch (Exception IllegalArgumentException) {
    }
    //test 3
    try {
      //arry had two identical attributes
      Attribute[] arry3 = new Attribute[]{Attribute.ID, Attribute.ID,
          Attribute.PAGECOUNT, Attribute.AUTHOR};
      BinaryBookshelf tester3 = new BinaryBookshelf(arry3);
      return false;
    }catch (Exception IllegalArgumentException) {
    }
    //test 4
    try {
      //arry does not start with author
      Attribute[] arry4 = new Attribute[]{Attribute.ID, Attribute.TITLE,
          Attribute.PAGECOUNT, Attribute.AUTHOR};
      BinaryBookshelf tester4 = new BinaryBookshelf(arry4);
      return false;
    }catch (Exception IllegalArgumentException) {
    }
    //valid inputs
    //test 1
    try {
      //valid arry
      Attribute[] arry5 = new Attribute[]{Attribute.AUTHOR, Attribute.ID, Attribute.TITLE,
          Attribute.PAGECOUNT};
      BinaryBookshelf tester5 = new BinaryBookshelf(arry5);
    }catch (Exception IllegalArgumentException) {
      //return false if a exception is caught on a valid arry
      return false;
    }
    //test 2
    Attribute[] arry6 = new Attribute[]{Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.TITLE,
        Attribute.ID};
    BinaryBookshelf tester6 = new BinaryBookshelf(arry6);
    //checking for size 0
    if(tester6.size() != 0) {
      return false;
    }
    //checking if empty
    if(!tester6.isEmpty()) {
      return false;
    }
    //checking if tostring return a empty string
    if(!tester6.toString().equals("")) {
      return false;
    }
    //checking if getRoot returns null
    if(tester6.getRoot() != null) {
      return false;
    }
    //test 3
    //checking that getAttributeOrder returns the correct String
    if(!tester6.getAttributeOrder().equals("1:AUTHOR 2:PAGECOUNT 3:TITLE 4:ID")) {
      return false;
    }
    //test4
    try {
      //making sure that the BST contain false
      if(tester6.contains(null) != false) {
        return false;
      }
    } catch (Exception e) {
      //return false if an exception is caught on valid input
      return false;
    }
    //test 5
    try {
      //making sure that and getBooksByAuthor returns a empty arry
      if(!(tester6.getBooksByAuthor​("joe").size()==0)) {
        return false;
      }
    } catch (Exception e) {
      //return false if an exception is caught on valid input
      return false;
    }
    return true;
  }

  /**
   * tester method to test InsertBook
   * @return
   */
  public static boolean testInsertBook() {
    //test 1
    Attribute[] arry = new Attribute[]{Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT,
        Attribute.ID};
    BinaryBookshelf tester = new BinaryBookshelf(arry);
    Book book1 =  new Book("The Fellowship of the Ring", 1, "Tolkien", "JRR");
    try {
      tester.insertBook(book1);
    } catch (Exception e) {
      //return false if an exception is caught on valid input
      return false;
    }
    //BST should not be empty
    if(tester.isEmpty() != false) {
      return false;
    }
    //size should be 1
    if(tester.size() != 1) {
      return false;
    }
    //the book at root should be book1
    if(!tester.getRoot().getData().equals(book1)) {
      return false;
    }
    //test 2
    Book book2 = new Book("wuz poppin", 2, "LeGuin", "Ursula");
    try {
      tester.insertBook(book2);
    } catch (Exception e) {
      //return false if an exception is caught on valid input
      return false;
    }
    //make sure that root is not null
    if(tester.getRoot().getLeft() != null) {
      //make sure the left node of the root contain the correct data
      if (!tester.getRoot().getLeft().getData().equals(book2)) {
        return false;
      }
    }
    //make sure size is 2
    if(tester.size() != 2) {
      return false;
    }
    //test 3
    Book book3 = new Book("The Two Towers", 1, "Tolkien", "JRR");
    try {
      tester.insertBook(book3);
    } catch (Exception e) {
      //return false if an exception is caught on valid input
      return false;
    }
    //make sure that root is not null
    if(tester.getRoot().getRight() != null) {
      //make sure the right node of the root contain the correct data
      if (!tester.getRoot().getRight().getData().equals(book3)) {
        return false;
      }
    }
    //make sure size is 3
    if(tester.size() != 3) {
      return false;
    }
    //test 4
    //inserting a book that is already in BST
    try {
      tester.insertBook(book3);
      //return false if an exception is not caught
      return false;
    } catch (Exception IllegalArgumentException) {
    }
    //making sure size is still 3
    if(tester.size() != 3) {
      return false;
    }
    return true;
  }

  public static boolean testContains() {
    //case 1
    Attribute[] arry = new Attribute[]{Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT,
        Attribute.ID};
    BinaryBookshelf tester = new BinaryBookshelf(arry);
    Book book1 =  new Book("hey", 1, "Last", "First");
    tester.insertBook(book1);
    //making sure contain returns the true  
    if(!tester.contains(book1)) {
      return false;
    }
    //case 2
    Book book2 =  new Book("hey", 1, "Last", "First");
    Book book3 =  new Book("hello", 1, "Final", "Earliest");
    Book book4 =  new Book("wuzzup", 1, "Not First", "Opening");
    Book book5 =  new Book("yello", 1, "Rear", "Leading");
    Book bookNotInTree =  new Book("greetings", 1, "Aftermost", "Original");
    TreeNode<Book> Node5 = new TreeNode<Book>(book5);
    TreeNode<Book> Node3 = new TreeNode<Book>(book3, Node5, null);
    TreeNode<Book> Node4 = new TreeNode<Book>(book4);
    TreeNode<Book> Node2 = new TreeNode<Book>(book2, Node3, Node4);
    tester.getRoot().setLeft(Node2);
    tester.getRoot().setRight(Node5);
    //correctly contain a book at the root
    if(!tester.contains(book1)) {
      return false;
    }
    //correctly contain a book at the middle
    if(!tester.contains(book3)) {
      return false;
    }
    //correctly contain a book at a leave
    if(!tester.contains(book5)) {
      return false;
    }
    //correctly does not contain a book not in the BST
    if(tester.contains(bookNotInTree)) {
      return false;
    }
    return true;
  }

  public static boolean testGetBooksByAuthor() {
    //test 1
    Attribute[] arry = new Attribute[]{Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT,
        Attribute.ID};
    BinaryBookshelf tester = new BinaryBookshelf(arry);
    Book book1 =  new Book("hey", 1, "Last", "First");
    tester.insertBook(book1);
    //correctly return of an author in the BST
    if (!(tester.getBooksByAuthor​("Last, First").size() == 1)) {
      return false;
    }
    //correctly return of an author not in the BST
    if (!(tester.getBooksByAuthor​("Last, Middle").size() == 0)) {
      return false;
    }
    Book book2 =  new Book("hey", 2, "Last", "First");
    Book book3 =  new Book("hello", 1, "Last", "First");
    Book book4 =  new Book("wuzzup", 1, "Not First", "Opening");
    Book book5 =  new Book("yello", 1, "Last", "First");
    Book book6 =  new Book("greetings", 1, "Last", "First");
    TreeNode<Book> Node5 = new TreeNode<Book>(book5);
    TreeNode<Book> Node3 = new TreeNode<Book>(book3, Node5, null);
    TreeNode<Book> Node4 = new TreeNode<Book>(book4);
    TreeNode<Book> Node2 = new TreeNode<Book>(book2, Node3, Node4);
    TreeNode<Book> Node6 = new TreeNode<Book>(book6);
    tester.getRoot().setLeft(Node2);
    tester.getRoot().setRight(Node6);
    //test 2
    //correctly returns the size of the arry list for an author that appears multiple times
    if(!(tester.getBooksByAuthor​("Last, First").size() == 5)) {
      return false;
    }
    //test 3
    //correctly returns the size of the arry list for an author that does not appear
    if (!(tester.getBooksByAuthor​("Hi, Hello").size() == 0)) {
      return false;
    }
    return true;
  }

  public static boolean runAllTests() {
    //runs all tests and return true if working and false otherwise
    if (!testTreeNode()) {
      return false;
    }
    if(!testEmptyTree()) {
      return false;
    }
    if(!testInsertBook()) {
      return false;
    }
    if(!testContains()) {
      return false;
    }
    if(!testGetBooksByAuthor()) {
      return false;
    }
    return true;
  }

  public static void main(String args[]) {
    //runs runAllTests
    System.out.println("runAllTests:" + runAllTests());
  }

}
