package com.gildedrose.items;

public class NormalItem extends Item {

  public NormalItem(String itemName) {
    super(itemName);
  }

  @Override
  public void runDailyUpdate() {
    decreaseDailySellIn();

    decrementQualityIfGreaterThan0();

    if (isSellDatePassed()) {
      decrementQualityIfGreaterThan0();
    }
  }

  private void decrementQualityIfGreaterThan0() {
    if (quality > 0) {
      this.quality--;
    }
  }
}
