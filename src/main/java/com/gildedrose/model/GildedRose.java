package com.gildedrose.model;
import static com.gildedrose.model.GildedRoseUtil.gildedRoseItem;

public class GildedRose {
	public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            gildedRoseItem(item).updateQuality();
        }
    }
}