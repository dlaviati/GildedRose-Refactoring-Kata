package com.gildedrose;

import com.gildedrose.items.*;

import static com.gildedrose.Constants.*;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new NormalItem(("+5 Dexterity Vest")).withSellInValue(10).withQuality(20), //
                new AgedBrie(AGED_BRIE_NAME){}.withSellInValue(2).withQuality(0), //
                new NormalItem(("Elixir of the Mongoose")).withSellInValue(5).withQuality(7), //
                new Sulfuras(SULFURAS_ITEM_NAME){}.withSellInValue(0).withQuality(80), //
                new Sulfuras(SULFURAS_ITEM_NAME){}.withSellInValue(-1).withQuality(80),
                new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(15).withQuality(20),
                new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(10).withQuality(49),
                new BackstageTicket(BACKSTAGE_PASS_TICKET_ITEM_NAME).withSellInValue(5).withQuality(49),
                // this conjured item does not work properly yet
                new NormalItem(("Conjured Mana Cake")).withSellInValue(3).withQuality(6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
