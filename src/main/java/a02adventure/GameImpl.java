package a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("Map or Player can't be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return this.player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return this.player.getInventory().getNumItems() == this.map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + this.map.getCell(this.player.getPosition()).getName());
    System.out.println(this.map.getCell(this.player.getPosition()).getDescription());
    if (this.map.getCell(this.player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.map.getCell(this.player.getPosition()).visit();
  }

  @Override
  public void openChest() {
    if (!this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    } else if (this.map.getCell(this.player.getPosition()).hasChest()
        && this.map.getCell(this.player.getPosition()).getChest().isEmpty()) {
      System.out.println("The chest is empty.");
    } else {
      System.out.println(
          "You collected these items: "
              + this.map.getCell(this.player.getPosition()).getChest().getItems());
      this.player
          .getInventory()
          .transferFrom(this.map.getCell(this.player.getPosition()).getChest());
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    try {
      this.map.getCell(this.player.getPosition().getNeighbor(direction));
    } catch (IndexOutOfBoundsException indexException) {
      return false;
    }
    if (this.map.getCell(this.player.getPosition().getNeighbor(direction)) == null) {
      return false;
    }
    return true;
  }

  @Override
  public void move(Direction direction) {
    if (!canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      this.player.move(direction);
      printCellInfo();
    }
  }
}
