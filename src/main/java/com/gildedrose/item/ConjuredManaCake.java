package com.gildedrose.item;

import com.gildedrose.model.AbstractGildedRoseItem;
import com.gildedrose.model.Item;

public class ConjuredManaCake extends AbstractGildedRoseItem {
	public ConjuredManaCake(Item item) {
        super(item);
	}
	
	@Override
    public void updateQuality() {
        speedyDecrementQuality();
        decrementSellIn();
    }
}
