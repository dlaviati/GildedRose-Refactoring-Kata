package com.gildedrose;

import com.gildedrose.items.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.gildedrose.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {
  private static final String RANDOM_NAME_1 = "+5 Dexterity Vest";
  private static final String RANDOM_NAME_2 = "Elixir of the Mongoose";
  private static final String RANDOM_NAME_3 = "Leather Armour";

  private static Object[][] dataProvider_allValuesTest() {
    return new Object[][] {
        {new NormalItem((RANDOM_NAME_1)).withSellInValue(10).withQuality(1), 9, 0},
        {new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(2).withQuality(0), 1, 1},
        {new NormalItem((RANDOM_NAME_2)).withSellInValue(5).withQuality(7), 4, 6},
        {new Sulfuras(SULFURAS_ITEM_NAME){}.withSellInValue(0).withQuality(80), 0, 80},
        {new Sulfuras(SULFURAS_ITEM_NAME){}.withSellInValue(-1).withQuality(80), -1, 80},
        {new NormalItem((RANDOM_NAME_3)).withSellInValue(-1).withQuality(80), -2, 78},
        {new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(-1).withQuality(48), -2, 50},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(-1).withQuality(80), -2, 0},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(15).withQuality(20), 14, 21},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(10).withQuality(48), 9, 50},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(5).withQuality(47), 4, 50},

        // Additional edge cases
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(10).withQuality(50), 9, 50},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(10).withQuality(49), 9, 50},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(11).withQuality(48), 10, 49},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(9).withQuality(48), 8, 50},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(6).withQuality(47), 5, 49},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(5).withQuality(49), 4, 50},
        {new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(1).withQuality(80), 0, 80},
        {new NormalItem((RANDOM_NAME_3)).withSellInValue(-1).withQuality(0), -2, 0},
        {new NormalItem((RANDOM_NAME_3)).withSellInValue(-1).withQuality(2), -2, 0},
        {new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(-1).withQuality(49), -2, 50},

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
