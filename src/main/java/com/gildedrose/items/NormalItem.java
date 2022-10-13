package com.gildedrose.items;

public class NormalItem extends Item {

  public NormalItem(String itemName) {
    super(itemName);
  }

  @Override
  public void runDailyUpdate() {
    if (quality > 0) {
      decreaseQualityByOne();
    }

    decreaseSellInByOne();

    if (sellIn < 0 && quality > 0) {
      decreaseQualityByOne();
    }
  }
}
