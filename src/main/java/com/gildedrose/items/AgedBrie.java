package com.gildedrose.items;

public class AgedBrie extends Item {

  public AgedBrie(String itemName) {
    super(itemName);
  }

  @Override
  public void runDailyUpdate() {
    if (quality < 50) {
      increaseQualityByOne();
    }

    decreaseSellInByOne();

    if (sellIn < 0 && quality < 50) {
      increaseQualityByOne();
    }
  }
}
