package com.gildedrose.patterns;

public class ItemBuilder {
	private String name;
	private int sellIn;
	private int quality;
	
	private ItemBuilder(Builder builder) {
		this.name = builder.name;
		this.sellIn = builder.sellIn;
		this.quality = builder.quality;
	}

	public String getName() {
		return name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public static class Builder {

		private String name;
		private int sellIn;
		private int quality;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder sellIn(int sellIn) {
			this.sellIn= sellIn;
			return this;
		}

		public Builder quality (int quality) {
			this.quality = quality;
			return this;
		}

		public ItemBuilder build() {
			return new ItemBuilder(this);
		}
	}
}
