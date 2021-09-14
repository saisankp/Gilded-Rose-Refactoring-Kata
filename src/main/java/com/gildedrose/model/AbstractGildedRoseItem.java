package com.gildedrose.model;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {
	private final Item item;

    protected AbstractGildedRoseItem(Item item) {
        this.item = item;
    }
    
    protected void setNoQuality() {
        item.quality = 0;
    }

    protected void decrementSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean hasExpired() {
        return expiresBy(0);
    }

    protected boolean expiresBy(int expiryTime) {
        return item.sellIn < expiryTime;
    }

    protected void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
    
    protected void speedyDecrementQuality() {
    	if(item.quality > 0) {
    		item.quality = item.quality - 2;
    	}
    }

    public void incrementQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}