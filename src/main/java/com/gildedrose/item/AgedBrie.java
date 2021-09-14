package com.gildedrose.item;

import com.gildedrose.model.AbstractGildedRoseItem;
import com.gildedrose.model.Item;

public class AgedBrie extends AbstractGildedRoseItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();
        decrementSellIn();
        if (hasExpired()) {
            incrementQuality();
        }
    }
}