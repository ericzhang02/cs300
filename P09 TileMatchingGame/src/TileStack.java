import java.util.Iterator;

public class TileStack implements StackADT<Tile>, Iterable<Tile>{

  private Node top;
  private int size;

  public TileStack() {
    this.top = null;
    this.size = 0;
  }

  @Override
  public void push(Tile element) {
    Node newTop = new Node(element, top);
    top = newTop;
  }

  @Override
  public Tile pop() {
    Node temp = top;
    top = top.getNext();
    return temp.getTile();
  }

  @Override
  public Tile peek() {
    return top.getTile();
  }

  @Override
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator iterator() {
    TileListIterator itr = new TileListIterator(top);
    return itr;
  }

}
