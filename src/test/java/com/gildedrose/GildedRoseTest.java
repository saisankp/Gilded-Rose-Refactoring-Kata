package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.gildedrose.model.Item;
import com.gildedrose.model.GildedRose;
import com.gildedrose.patterns.ItemFactory;

class GildedRoseTest {
	
	@Test
	void testText() throws IOException {
		TextTest test = new TextTest();
		test.preservesBehaviour();
	}
	
	@Test
	void testFixture() {
		TexttestFixture test = new TexttestFixture();
	}
	
    @Test
    void updateQuality() {
        Item[] items = new Item[] { ItemFactory.newComponent("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    void qualityIncreasesOverTimeForCheese() {
        Item item = ItemFactory.newComponent("Aged Brie", 12, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(4, item.quality);
        gildedRose.updateQuality();
        assertEquals(5, item.quality);
        gildedRose.updateQuality();
        assertEquals(6, item.quality);
        gildedRose.updateQuality();
        assertEquals(7, item.quality);
    }

    @Test
    void qualityDecreasesMoreQuicklyAfterSellByDateForUnknownThings() {
        Item item = ItemFactory.newComponent("foo", 1, 6);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(5, item.quality);
        gildedRose.updateQuality();
        assertEquals(3, item.quality);
        gildedRose.updateQuality();
        assertEquals(1, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void qualityDecreasesOverTimeForUnknownThings() {
        Item item = ItemFactory.newComponent("foo", 2, 3);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(2, item.quality);
        gildedRose.updateQuality();
        assertEquals(1, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void decreaseQualityQuickly() {
    	 Item item = ItemFactory.newComponent("Conjured Mana Cake", 2, 3);
    	 GildedRose gildedRose = new GildedRose(new Item[]{item});
         gildedRose.updateQuality();
    	assertEquals(1, item.quality);
    	
    }
    
    @Test
    void sellInDecreasesEveryDayForMostItems() {
        sellInDecreasesEveryDayForItem(ItemFactory.newComponent("foo", 2, 0));
        sellInDecreasesEveryDayForItem(ItemFactory.newComponent("Backstage passes to a TAFKAL80ETC concert", 2, 0));
        sellInDecreasesEveryDayForItem(ItemFactory.newComponent("Aged Brie", 2, 0));
        sellInDecreasesEveryDayForItem(ItemFactory.newComponent("Conjured Mana Cake", 2, 0));
    }

    @Test
    void sulfurasNeverAges() {
    	//ItemFactory.newComponent("Sulfuras, Hand of Ragnaros", 2, 0);
        Item item = ItemFactory.newComponent("Sulfuras, Hand of Ragnaros", 2, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(2, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(2, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(2, item.sellIn);
    }

    private void sellInDecreasesEveryDayForItem(Item item) {
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(1, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(0, item.sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
    }
}
