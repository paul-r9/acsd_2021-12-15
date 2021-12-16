package gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            boolean isBackStage = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isAgedOrBackStage = isBackStage || isAgedBrie;

            boolean notSulfurusAndQualityGreaterThan0 = item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros");
            if (!isAgedOrBackStage && notSulfurusAndQualityGreaterThan0) {
                item.quality = item.quality - 1;
            }
            if(isAgedOrBackStage) {
                boolean hasNotReachedMaxQuality = (item.quality < MAX_QUALITY);
                if (hasNotReachedMaxQuality) {
                    item.quality = item.quality + 1;

                    if (isBackStage) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
