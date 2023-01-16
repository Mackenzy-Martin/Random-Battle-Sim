public class Player extends Character {

    //Values
    private final String favouriteSaying;

    //Constructor
    public Player(String name, int health, Weapon weapon, String favouriteSaying) {
        super(name, health, weapon);
        this.favouriteSaying = favouriteSaying;
    }

    //Methods
    @Override
    public void battleCry() {System.out.println(getName() + ": " + favouriteSaying + ".");}
}
