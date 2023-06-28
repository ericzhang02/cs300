// File header comes here

/**
 * This class models a Tile of a specific color
 *
 */
/**
 * @author mouna
 *
 */
public class Tile {
  private Color color; // color of this Tile

  /**
   * Creates a Tile with a specific color
   * @param color color to be assigned to this tile
   */
  public Tile(Color color) {
    this.color = color;
  }

  /**
   * Gets the color of this tile
   * @return the color of this tile
   */
  public Color getColor() {
    return color;
  }


  /**
   * Returns a string representation of this tile
   * @return the color of this tile as a string
   */
  @Override
  public String toString() {
    return color.name();
  }

  
  /**
   * Checks whether this tile equals to the other object provided as input
   * @return true if other is a Tile and has the same color as this tile
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Tile) {
      if(((Tile) other).getColor() == this.color) {
        return true;
      }
    }
    // TODO complete the implementation of this method
    return false; // default return statement added to resolve compiler errors
  }
}