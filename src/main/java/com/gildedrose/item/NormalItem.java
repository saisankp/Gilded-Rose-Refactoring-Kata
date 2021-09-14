package com.gildedrose.item;

import com.gildedrose.model.AbstractGildedRoseItem;
import com.gildedrose.model.Item;

public class NormalItem extends AbstractGildedRoseItem {
	 public NormalItem(Item item) {
	        super(item);
	    }

	    @Override
	    public void updateQuality() {
	        decrementQuality();
	        decrementSellIn();
	        if (hasExpired()) {
	            decrementQuality();
	        }
	    }
}