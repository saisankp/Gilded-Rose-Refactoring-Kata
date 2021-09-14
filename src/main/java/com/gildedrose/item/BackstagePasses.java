package com.gildedrose.item;

import com.gildedrose.model.AbstractGildedRoseItem;
import com.gildedrose.model.Item;

public class BackstagePasses extends AbstractGildedRoseItem {
	public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();
        if (expiresBy(11)) {
            incrementQuality();
        }
        if (expiresBy(6)) {
            incrementQuality();
        }
        decrementSellIn();
        if (hasExpired()) {
            setNoQuality();
        }
    }
}
