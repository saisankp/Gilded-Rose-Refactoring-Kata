package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.model.Item;
import com.gildedrose.patterns.ItemFactory;

class DesignPatternTest {

	@Test
	void testBuildingItemBuilder() {
		Item madeWithFactoryAndBuilderPattern = ItemFactory.newComponent("Made with factory and builder patterns", 1, 2);
		assertEquals("Made with factory and builder patterns" ,madeWithFactoryAndBuilderPattern.name);
		assertEquals(1 ,madeWithFactoryAndBuilderPattern.sellIn);
		assertEquals(2 ,madeWithFactoryAndBuilderPattern.quality);
	}

}
