package a02adventure;

public class ItemImpl implements Item {
  private final String item;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be nothing");
    }
    this.item = name;
  }

  @Override
  public String getName() {
    return this.item;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (this.item.equals(other.toString())) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
