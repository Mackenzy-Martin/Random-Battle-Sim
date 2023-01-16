public abstract class Character {

    //Values
    private int health;
    private int baseHealth;
    private final String name;
    private final Weapon weapon;
    private int wins;

    //Constructor
    public Character(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.baseHealth = health;
        this.weapon = weapon;
    }

    //Getters
    public String getName() {return name;}

    public Weapon getWeapon() {return weapon;}

    public int getHealth() {return health;}

    public int getBaseHealth() {return baseHealth;}

    public int getWins() {return wins;}

    //setter
    public void setHealth(int health) {this.health = health; }

    //Methods
    public void takeDamage(int damage) {health -= damage;}

    public void addWin() {wins += 1;}

    public void resetWins() {wins = 0;}

    public void reset() {health = baseHealth;}

    public abstract void battleCry();
}