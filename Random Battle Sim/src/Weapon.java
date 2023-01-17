public enum Weapon {
    //This list will be adjusted whenever I find the time
    BARE_HANDS("Bare Hands", 1, 3),
    BOXING_GLOVES("Boxing Gloves", 3, 5),
    BEAR_HANDS("Bear Hands", 7, 15),
    GOLDEN_GAUNTLETS("Golden Gauntlets", 11, 13),
    RUSTY_HAMMER("Rusty Hammer", 2, 5),
    RUSTY_AXE("Rusty Axe", 2, 6),
    WOODEN_HAMMER("Wooden Hammer", 3, 5),
    WOODEN_AXE("Wooden Axe", 4, 6),
    FARMERS_HAMMER("Farmers Hammer", 6, 8),
    FARMERS_AXE("Farmers Axe", 8, 10),
    COPPER_HAMMER("Copper Hammer", 8, 10),
    COPPER_AXE("Copper Axe", 10, 12),
    IRON_HAMMER("Iron Hammer", 11, 13),
    IRON_AXE("Iron Axe", 12, 14),
    STEEL_HAMMER("Steel Hammer", 13, 14),
    STEEL_AXE("Steel Axe", 13, 15),
    OBSIDIAN_HAMMER("Obsidian Hammer", 15, 17),
    OBSIDIAN_AXE("Obsidian Axe", 15, 17),
    SAPPHIRE_HAMMER("Sapphire Hammer", 17, 19),
    RUBY_AXE("Ruby Axe", 17, 18),
    WAR_HAMMER("War Hammer", 19, 20),
    WAR_AXE("War Axe", 19, 22),
    DAGGER("Dagger", 5, 9),
    JADE_DAGGER("Jade Dagger", 7, 9),
    SHORT_SWORD("Short Sword", 7, 9),
    GREAT_SWORD("Great Sword", 9, 12),
    BOW("Bow", 5, 15),
    LONG_BOW("Long Bow", 7, 17),
    CROSS_BOW("Cross Bow", 8, 14),
    WOODEN_STAFF("Wooden Staff", 7, 8),
    STAFF_OF_STONE("Staff of Stone", 9, 10),
    STAFF_OF_COPPER("Staff of Copper", 9, 11),
    STAFF_OF_IRON("Staff of Iron", 11, 13),
    STAFF_OF_STEEL("Staff of Steel", 15, 17),
    STAFF_OF_OBSIDIAN("Staff of Obsidian", 17, 19),
    STAFF_OF_JEWELS("Staff of Jewels", 21, 23),
    STAFF_OF_DEATH("Staff of Death", 50, 100);

    //Values
    private final String name;
    private final int minDamage;
    private final int maxDamage;

    //Constructor
    Weapon(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }
    
    public int getMaxDamage() {
        return maxDamage;
    }
}
