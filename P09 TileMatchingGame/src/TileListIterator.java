import java.util.Iterator;
import java.util.NoSuchElementException;

public class TileListIterator implements Iterator<Tile> {
  
  private Node curr;
  
  public TileListIterator(Node head) {
    this.curr.setNext(head);
 // Creates a new iterator to iterate through a list of tiles starting from its head
 // head is a reference to the head of the linked list of tiles
 }

  @Override
  public boolean hasNext() {
    if(curr.getNext() != null) {
      return true;
    }
    return false;
  }

  @Override
  public Tile next() throws NoSuchElementException{
    if(curr.getNext() == null) {
      throw new NoSuchElementException("node does not exist");
    }
    curr = curr.getNext();
    return curr.getTile();
  }

}
