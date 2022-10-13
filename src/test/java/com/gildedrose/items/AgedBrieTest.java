package com.gildedrose.items;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.gildedrose.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieTest {

  private static Object[][] dataProvider_allValuesTest() {
    return new Object[][] {
        {new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(2).withQuality(0), 1, 1},
        {new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(-1).withQuality(48), -2, 50},

        // Additional edge cases
        {new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(-1).withQuality(49), -2, 50},

    };
  }

  @ParameterizedTest
  @MethodSource("dataProvider_allValuesTest")
  public void updateQuality_forAllPossibleValues_shouldUpdateQualityAndSellInCorrectly(Item item, int sellIn, int quality) {
    item.runDailyUpdate();

    assertThat(item.sellIn).isEqualTo(sellIn);
    assertThat(item.quality).isEqualTo(quality);
  }
}