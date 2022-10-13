package com.gildedrose;

import com.gildedrose.items.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

class ItemFactoryTest {
  private static final String UNKNOWN_ITEM_NAME = "foo";

  private final ItemFactory itemFactory;

  ItemFactoryTest() {
    itemFactory = new ItemFactory();
  }

  @Test
  void createItemByName_onUnknownName_shouldReturnNormalItem() {
    Item foo = itemFactory.createItemByName(UNKNOWN_ITEM_NAME);

    assertThat(foo).isOfAnyClassIn(NormalItem.class);
  }

  public static Object[][] dataProvider_knownName() {
    return new Object[][] {
        {
            Constants.AGED_BRIE_NAME, AgedBrie.class
        }, {
        Constants.BACKSTAGE_PASS_TICKET_ITEM_NAME, BackstageTicket.class
    }, {
        Constants.SULFURAS_ITEM_NAME, Sulfuras.class
    }, {
        Constants.CONJURED_ITEM_PREFIX, ConjuredItem.class
    }
    };
  }

  @ParameterizedTest
  @MethodSource("dataProvider_knownName")
  void createItemByName_onKnownName_shouldReturnCorrectItem(String name, Class<? extends Item> expectedClass) {
    Item foo = itemFactory.createItemByName(name);

    assertThat(foo).isOfAnyClassIn(expectedClass);
  }

  @Test
  void createItemByName_onNullName_shouldThrowNullPointerException() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> itemFactory.createItemByName(null));
  }
}