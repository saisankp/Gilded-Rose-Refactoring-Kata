package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import com.gildedrose.model.GildedRose;
import com.gildedrose.model.Item;
import com.gildedrose.patterns.ItemFactory;

class TextTest {

	@Test
	public void preservesBehaviour() throws IOException {
		assertEquals(exerciseCode(5), a5);
	}

	private final static String a5 = "OMGHAI!\n" +
			"-------- day 0 --------\n" +
			"name, sellIn, quality\n" +
			"+5 Dexterity Vest, 10, 20\n" +
			"Aged Brie, 2, 0\n" +
			"Elixir of the Mongoose, 5, 7\n" +
			"Sulfuras, Hand of Ragnaros, 0, 80\n" +
			"Sulfuras, Hand of Ragnaros, -1, 80\n" +
			"Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
			"Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
			"Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
			"Conjured Mana Cake, 3, 6\n" +
			"\n" +
			"-------- day 1 --------\n" +
			"name, sellIn, quality\n" +
			"+5 Dexterity Vest, 9, 19\n" +
			"Aged Brie, 1, 1\n" +
			"Elixir of the Mongoose, 4, 6\n" +
			"Sulfuras, Hand of Ragnaros, 0, 80\n" +
			"Sulfuras, Hand of Ragnaros, -1, 80\n" +
			"Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
			"Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
			"Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
			"Conjured Mana Cake, 2, 4\n" +
			"\n" +
			"-------- day 2 --------\n" +
			"name, sellIn, quality\n" +
			"+5 Dexterity Vest, 8, 18\n" +
			"Aged Brie, 0, 2\n" +
			"Elixir of the Mongoose, 3, 5\n" +
			"Sulfuras, Hand of Ragnaros, 0, 80\n" +
			"Sulfuras, Hand of Ragnaros, -1, 80\n" +
			"Backstage passes to a TAFKAL80ETC concert, 13, 22\n" +
			"Backstage passes to a TAFKAL80ETC concert, 8, 50\n" +
			"Backstage passes to a TAFKAL80ETC concert, 3, 50\n" +
			"Conjured Mana Cake, 1, 2\n" +
			"\n" +
			"-------- day 3 --------\n" +
			"name, sellIn, quality\n" +
			"+5 Dexterity Vest, 7, 17\n" +
			"Aged Brie, -1, 4\n" +
			"Elixir of the Mongoose, 2, 4\n" +
			"Sulfuras, Hand of Ragnaros, 0, 80\n" +
			"Sulfuras, Hand of Ragnaros, -1, 80\n" +
			"Backstage passes to a TAFKAL80ETC concert, 12, 23\n" +
			"Backstage passes to a TAFKAL80ETC concert, 7, 50\n" +
			"Backstage passes to a TAFKAL80ETC concert, 2, 50\n" +
			"Conjured Mana Cake, 0, 0\n" +
			"\n" +
			"-------- day 4 --------\n" +
			"name, sellIn, quality\n" +
			"+5 Dexterity Vest, 6, 16\n" +
			"Aged Brie, -2, 6\n" +
			"Elixir of the Mongoose, 1, 3\n" +
			"Sulfuras, Hand of Ragnaros, 0, 80\n" +
			"Sulfuras, Hand of Ragnaros, -1, 80\n" +
			"Backstage passes to a TAFKAL80ETC concert, 11, 24\n" +
			"Backstage passes to a TAFKAL80ETC concert, 6, 50\n" +
			"Backstage passes to a TAFKAL80ETC concert, 1, 50\n" +
			"Conjured Mana Cake, -1, 0\n" +
			"\n";

	private String exerciseCode(int days) throws IOException {
		Writer printStream = new StringWriter();
		println(printStream, "OMGHAI!");

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
		for (int i = 0; i < days; i++) {
			println(printStream, "-------- day " + i + " --------");
			println(printStream, "name, sellIn, quality");
			for (Item item : items) {
				println(printStream, item);
			}
			println(printStream, "");
			app.updateQuality();
		}
		return printStream.toString();
	}

	private static void println(Writer printStream, Object s) throws IOException {
		printStream.write(s.toString());
		printStream.write("\n");
	}
}