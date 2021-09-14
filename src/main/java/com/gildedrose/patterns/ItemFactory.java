package com.gildedrose.patterns;

import com.gildedrose.model.Item;

public class ItemFactory {
	public static Item newComponent(String name, int sellIn, int quality) {
		ItemBuilder builder = newBuilder(name, sellIn, quality);
		return new Item(builder.getName(), builder.getSellIn(), builder.getQuality());
	}
	
	private static ItemBuilder newBuilder (String name, int sellIn, int quality) {
		return new ItemBuilder.Builder()
							  .name(name)
							  .sellIn(sellIn)
							  .quality(quality)
							  .build();
	}
}