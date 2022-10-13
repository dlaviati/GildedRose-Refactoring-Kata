package com.gildedrose.items;

public class AgedBrie extends Item {

  public AgedBrie(String itemName) {
    super(itemName);
  }

  @Override
  public void runDailyUpdate() {
    decreaseDailySellIn();

    increaseQualityIfLessThan50By(1);

    if (isSellDatePassed()) {
      increaseQualityIfLessThan50By(1);
    }
  }
}
