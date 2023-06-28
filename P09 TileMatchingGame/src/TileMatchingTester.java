
public class TileMatchingTester {

  public static boolean tileEqualsTester() {
    Tile tester1 = new Tile(Color.BLACK);
    Tile tester2 = new Tile(Color.BLUE);
    Tile tester3 = new Tile(Color.BLACK);
    String tester4 = "Wuz poppin";
    
    if(tester1.equals(tester2) != false) {
      return false;
    }
    if(tester1.equals(tester4) != false) {
      return false;
    }
    if(tester1.equals(tester3) == false) {
      return false;
    }
    return true;
  }
  
  public static boolean tileListIteratorTester(){
    Tile tester1 = new Tile(Color.BLACK);
    Tile tester2 = new Tile(Color.BLUE);
    Tile tester3 = new Tile(Color.BLACK);
    Tile tester4 = new Tile(Color.ORANGE);
    Node test4 = new Node(tester4);
    Node test3 = new Node(tester3, test4);
    Node test2 = new Node(tester2, test3);
    Node test1 = new Node(tester1, test2);
    TileListIterator itr = new TileListIterator(test1);
    if(itr.next().getColor() != Color.BLACK) {
      return false;
    }
    if(itr.next().getColor() != Color.BLUE) {
      return false;
    }
    if(itr.next().getColor() != Color.BLACK) {
      return false;
    }
    if(itr.next().getColor() != Color.BLACK) {
      return false; 
    }

  }

  public static boolean tileStackTester(){}
  
  public static void main(String args[]) {
    System.out.println(tileEqualsTester());
    System.out.println(tileListIteratorTester());
    System.out.println(tileStackTester());
  }}
