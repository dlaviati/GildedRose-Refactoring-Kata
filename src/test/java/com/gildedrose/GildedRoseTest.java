package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

  private static Object[][] dataProvider_allValuesTest() {
    return new Object[][] {
        {new Item("+5 Dexterity Vest", 10, 20), 9, 19},
        {new Item("Aged Brie", 2, 0), 1, 1},
        {new Item("Elixir of the Mongoose", 5, 7), 4, 6},
        {new Item("Sulfuras, Hand of Ragnaros", 0, 80), 0, 80},
        {new Item("Sulfuras, Hand of Ragnaros", -1, 80), -1, 80},
        {new Item("Leather Armour", -1, 80), -2, 78},
        {new Item("Aged Brie", -1, 40), -2, 42},
        {new Item("Backstage passes to a TAFKAL80ETC concert", -1, 80), -2, 0},
        {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), 14, 21},
        {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48), 9, 50},
        {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47), 4, 50}
    };
  }

  @ParameterizedTest
  @MethodSource("dataProvider_allValuesTest")
  public void updateQuality_forAllPossibleValues_shouldUpdateQualityAndSellInCorrectly(Item item, int sellIn, int quality) {
    GildedRose application = new GildedRose(new Item[] {item});

    application.updateQuality();

    assertThat(item.sellIn).isEqualTo(sellIn);
    assertThat(item.quality).isEqualTo(quality);
  }
}
