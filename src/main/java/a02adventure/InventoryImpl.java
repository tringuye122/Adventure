package a02adventure;

import java.util.List;
import java.util.ArrayList;

public class InventoryImpl implements Inventory {
  private List<Item> inventory;

  public InventoryImpl() {
    this.inventory = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    return this.inventory.isEmpty();
  }

  @Override
  public int getNumItems() {
    return this.inventory.size();
  }

  @Override
  public List<Item> getItems() {
    return new ArrayList<Item>(this.inventory);
  }

  @Override
  public void addItem(Item item) {
    this.inventory.add(item);
  }

  @Override
  public void removeItem(Item item) {
    this.inventory.remove(item);
  }

  @Override
  public void clear() {
    this.inventory.removeAll(this.inventory);
  }

  @Override
  public void transferFrom(Inventory other) {
    for (int i = 0; i < other.getNumItems(); i++) {
      Item element = other.getItems().get(i);
      this.inventory.add(element);
    }
    other.clear();
  }
}
