package com.gildedrose.items;

public class BackstageTicket extends Item {

  public BackstageTicket(String itemName) {
    super(itemName);
  }

  @Override
  public void runDailyUpdate() {
    decreaseDailySellIn();

    if (isSellDatePassed()) {
      zeroQuality();
      return;
    }

    increaseQualityIfLessThan50By(getMaxNumberToIncreaseQualityBy());
  }

  private int getMaxNumberToIncreaseQualityBy() {
    if (sellIn < 5) {
      return 3;
    }
    if (sellIn < 10) {
      return 2;
    }
    return 1;
  }
}
