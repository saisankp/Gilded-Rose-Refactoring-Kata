package com.gildedrose.model;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.BackstagePasses;
import com.gildedrose.item.ConjuredManaCake;
import com.gildedrose.item.NormalItem;
import com.gildedrose.item.Sulfuras;

public final class GildedRoseUtil {

	private GildedRoseUtil() {}

	static GildedRoseItem gildedRoseItem(Item item) {
		if (isAgedBrie(item)) {
			return new AgedBrie(item);
		}
		else if (isBackstagePasses(item)) {
			return new BackstagePasses(item);
		}
		else if (isSulfuras(item)) {
			return new Sulfuras();
		}
		else if(isConjuredManaCake(item)) {
			return new ConjuredManaCake(item);
		}
		return new NormalItem(item);
	}

	static boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	static boolean isBackstagePasses(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	static boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	static boolean isConjuredManaCake(Item item) {
		return item.name.equals("Conjured Mana Cake");
	}
}