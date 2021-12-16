package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GildedRoseTest {

    @Test
    public void itemName_notChange_afterUpdate() {
        // Arrange
        Item[] items = new Item[] { new Item("itemName", 0, 0) };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        assertEquals("itemName", sut.items[0].name);
    }


    @Test
		public void allItem_quality_canNotBe_Negative() {
			Item[] items = new Item[] { new Item("itemName", 1, 0) };
			GildedRose sut = new GildedRose(items);

			// Act
			sut.updateQuality();

			// Assert
			assertEquals(0, sut.items[0].quality);
		}

	@Test
	public void normalItem_decrease_quality() {
		Item[] items = new Item[] { new Item("itemName", 1, 0) };
		GildedRose sut = new GildedRose(items);

		// Act
		sut.updateQuality();
		assertEquals(0, sut.items[0].sellIn);

		sut.updateQuality();

		// Assert
		assertEquals(0, sut.items[0].quality);
		assertEquals(-1, sut.items[0].sellIn);
	}


	@Test
	public void agedBrie_increase_quality() {
		Item[] items = new Item[] { new Item("Aged Brie", 1, 0) };
		GildedRose sut = new GildedRose(items);

		// Act
		sut.updateQuality();

		// Assert
		assertEquals(1, sut.items[0].quality);
		assertEquals(0, sut.items[0].sellIn);

	}

}
