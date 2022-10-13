package com.gildedrose.items;

public class ConjuredItem extends Item {
  public ConjuredItem(String name) {
    super(name);
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
    this.quality = Math.max(0, quality - 2);
  }
}
