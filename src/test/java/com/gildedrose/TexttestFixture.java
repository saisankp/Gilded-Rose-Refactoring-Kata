package com.gildedrose;

import com.gildedrose.model.GildedRose;
import com.gildedrose.model.Item;
import com.gildedrose.patterns.ItemFactory;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
        		ItemFactory.newComponent("+5 Dexterity Vest", 10, 20),
				ItemFactory.newComponent("Aged Brie", 2, 0),
				ItemFactory.newComponent("Elixir of the Mongoose", 5, 7),
				ItemFactory.newComponent("Sulfuras, Hand of Ragnaros", 0, 80),
				ItemFactory.newComponent("Sulfuras, Hand of Ragnaros", -1, 80),
				ItemFactory.newComponent("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				ItemFactory.newComponent("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				ItemFactory.newComponent("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				ItemFactory.newComponent("Conjured Mana Cake", 3, 6)};
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
