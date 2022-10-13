package com.gildedrose.items;

public abstract class Item {

  public final String name;
  public int sellIn;
  public int quality;

  public Item(String name) {
    this.name = name;
  }

  public Item withQuality(int quality) {
    this.quality = quality;
    return this;
  }

  public Item withSellInValue(int sellIn) {
    this.sellIn = sellIn;
    return this;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  public abstract void runDailyUpdate();


  void decreaseDailySellIn() {
    this.sellIn--;
  }

  void zeroQuality() {
    this.quality = 0;
  }

  protected boolean isSellDatePassed() {
    return sellIn < 0;
  }

  protected void increaseQualityIfLessThan50By(int value) {
    this.quality = Math.min(50, quality + value);
  }
}
