package a02adventure;

public class MapImpl implements Map {
  private final Cell[][] cellMap;
  private final int numItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and Height must be positive.");
    }
    this.cellMap = new Cell[width][height];
    this.numItems = numItems;
  }

  @Override
  public int getWidth() {
    return this.cellMap.length;
  }

  @Override
  public int getHeight() {
    return this.cellMap[0].length;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IndexOutOfBoundsException("Coordinates out of bounds.");
    }
    return this.cellMap[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getX() < 0
        || position.getX() >= getWidth()
        || position.getY() < 0
        || position.getY() >= getHeight()) {
      throw new IndexOutOfBoundsException("Coordinates out of bounds.");
    }
    return this.cellMap[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IndexOutOfBoundsException("Coordinates out of bounds.");
    }
    this.cellMap[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
