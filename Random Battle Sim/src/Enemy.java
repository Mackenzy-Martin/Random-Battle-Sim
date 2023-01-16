import java.util.Random;
public class Enemy extends Character {

    //Values
    private final String[] taunts;
    private final Random r = new Random();

    //Constructor
    public Enemy(String name, int health, Weapon weapon, String[] taunts) {
        super(name, health, weapon);
        this.taunts = taunts;
    }

    //Methods
    @Override
    public void battleCry() {
        System.out.println(this.getName() + ": " + taunts[r.nextInt(this.taunts.length)] + ".");
    }
}