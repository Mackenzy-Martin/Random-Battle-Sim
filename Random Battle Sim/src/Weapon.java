public enum Weapon {
    //This list will be adjusted whenever I find the time
    SHORT_SWORD("Short Sword", 9),
    AXE("Axe", 7),
    GREAT_SWORD("Great Sword", 13),
    BOW("Bow", 12),
    HAMMER("Hammer", 5),
    STAFF("Staff", 12),
    BARE_HANDS("Bare Hands", 1);

    //Values
    private final String name;
    private final int damage;

    //Constructor
    Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}