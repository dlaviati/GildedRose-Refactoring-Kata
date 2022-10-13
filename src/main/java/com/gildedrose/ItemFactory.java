package com.gildedrose;

import com.gildedrose.items.*;

import static com.gildedrose.Constants.*;

public class ItemFactory {

  public Item createItemByName(String itemName) {
    if (itemName == null) {
      throw new IllegalArgumentException("Blank item name");
    }
    if (itemName.startsWith(CONJURED_ITEM_PREFIX)) {
      return new ConjuredItem(itemName);
    }

    return switch (itemName) {
      case BACKSTAGE_PASS_TICKET_ITEM_NAME -> new BackstageTicket(itemName);
      case SULFURAS_ITEM_NAME -> new Sulfuras(itemName);
      case AGED_BRIE_NAME -> new AgedBrie(itemName);
      default -> new NormalItem(itemName);
    };
  }
}
