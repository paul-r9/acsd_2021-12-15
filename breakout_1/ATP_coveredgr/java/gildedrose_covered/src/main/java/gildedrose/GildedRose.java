package gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            boolean isBackStage = items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isAgedBrie = items[i].name.equals("Aged Brie");
            boolean isAgedOrBackStage = isBackStage || isAgedBrie;

            boolean notSulfurusAndQualityGreaterThan0 = items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros");
            if (!isAgedOrBackStage && notSulfurusAndQualityGreaterThan0) {
                items[i].quality = items[i].quality - 1;
            }
            if(isAgedOrBackStage) {
                boolean hasNotReachedMaxQuality = (items[i].quality < MAX_QUALITY);
                if (hasNotReachedMaxQuality) {
                    items[i].quality = items[i].quality + 1;

                    if (isBackStage) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
