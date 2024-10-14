package a02adventure;

import java.util.ArrayList;

public class CellImpl implements Cell {
  private final Position coordinates;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null) {
      throw new IllegalArgumentException("Need a name");
    }
    if (description == null) {
      throw new IllegalArgumentException("Need a description");
    }
    this.coordinates = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
    this.chest = null;
    this.visited = false;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public Position getPosition() {
    return this.coordinates;
  }

  @Override
  public Inventory getChest() {
    if (this.chest == null) {
      return null;
    }
    return this.chest;
  }

  @Override
  public boolean getIsVisited() {
    return visited;
  }

  @Override
  public boolean hasChest() {
    return this.chest != null;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Need a name");
    }
    this.name = name;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Need a description");
    }
    this.description = description;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("Not a chest");
    }
    this.chest = chest;
  }

  @Override
  public void visit() {
    this.visited = true;
  }
}
