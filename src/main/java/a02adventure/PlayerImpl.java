package a02adventure;

public class PlayerImpl implements Player {
  private final String name;
  private Position playerPosition;
  private final Inventory playerInventory;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException("Need a name");
    }
    this.name = name;
    this.playerPosition = new PositionImpl(startX, startY);
    this.playerInventory = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return this.playerPosition;
  }

  @Override
  public Inventory getInventory() {
    return this.playerInventory;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void move(Direction direction) {
    this.playerPosition = this.playerPosition.getNeighbor(direction);
  }
}
