package com.gildedrose;

import java.util.Set;

class GildedRose {
  private static final String BACKSTAGE_PASS_TICKET_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
  private static final String AGED_BRIE_NAME = "Aged Brie";

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateOneItem(item);
    }
  }

  private void updateOneItem(Item item) {
    updateItemIfAgedBrie(item);
    updateItemIfSulfuras(item);
    updateItemIfBackstagePass(item);
    updateItemIfNormalItem(item);
  }

  private void updateItemIfNormalItem(Item item) {
    if (Set.of(SULFURAS_ITEM_NAME, AGED_BRIE_NAME, BACKSTAGE_PASS_TICKET_ITEM_NAME).contains(item.name)) {
      return;
    }

    if (item.quality > 0) {
      decreaseQualityByOne(item);
    }

    decreaseSellInByOne(item);

    if (item.sellIn < 0 && item.quality > 0) {
      decreaseQualityByOne(item);
    }
  }

  private void updateItemIfBackstagePass(Item item) {
    if (!item.name.equals(BACKSTAGE_PASS_TICKET_ITEM_NAME)) {
      return;
    }

    if (item.quality < 50) {
      increaseQualityByOne(item);

      if (item.sellIn < 11 && item.quality < 50) {
        increaseQualityByOne(item);
      }

      if (item.sellIn < 6 && item.quality < 50) {
        increaseQualityByOne(item);
      }
    }

    decreaseSellInByOne(item);

    if (item.sellIn < 0) {
      zeroQuality(item);
    }
  }

  private void updateItemIfSulfuras(Item item) {
    if (!item.name.equals(SULFURAS_ITEM_NAME)) {
      // do nothing
    }
  }

  private void updateItemIfAgedBrie(Item item) {
    if (!item.name.equals(AGED_BRIE_NAME)) {
      return;
    }

    if (item.quality < 50) {
      increaseQualityByOne(item);
    }

    decreaseSellInByOne(item);

    if (item.sellIn < 0 && item.quality < 50) {
      increaseQualityByOne(item);
    }
  }

  private void decreaseSellInByOne(Item item) {
    item.sellIn = item.sellIn - 1;
  }

  private void zeroQuality(Item item) {
    item.quality = 0;
  }

  private void decreaseQualityByOne(Item item) {
    item.quality = item.quality - 1;
  }

  private void increaseQualityByOne(Item item) {
    item.quality = item.quality + 1;
  }

}