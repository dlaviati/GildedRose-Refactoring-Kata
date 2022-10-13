package com.gildedrose.items;

public class BackstageTicket extends Item {

  public BackstageTicket(String itemName) {
    super(itemName);
  }

  @Override
  public void runDailyUpdate() {
    if (quality < 50) {
      increaseQualityByOne();

      if (sellIn < 11 && quality < 50) {
        increaseQualityByOne();
      }

      if (sellIn < 6 && quality < 50) {
        increaseQualityByOne();
      }
    }

    decreaseSellInByOne();

    if (sellIn < 0) {
      zeroQuality();
    }

  }
}
