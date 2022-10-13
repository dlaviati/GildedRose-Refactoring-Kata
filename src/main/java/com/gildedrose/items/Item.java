package com.gildedrose.items;

public abstract class Item {

  public final String name;
  public int sellIn;
  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public Item(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
