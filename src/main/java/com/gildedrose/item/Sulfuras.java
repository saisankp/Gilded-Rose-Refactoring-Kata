package com.gildedrose.item;

import com.gildedrose.model.GildedRoseItem;

public class Sulfuras implements GildedRoseItem {
	@Override
    public void updateQuality() {
		//Legendary items never get sold or decrease in quality.
    }
}
