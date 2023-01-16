import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public final class CharacterCreator {
    //Defining values
    Random r = new Random();
    String namesFilePath;
    String titlesFilePath;

    //Constructor
    public CharacterCreator(String namesFilePath, String titlesFilePath) {
        this.namesFilePath = namesFilePath;
        this.titlesFilePath = titlesFilePath;
    }

    //Random Character Generators
    public Enemy generateEnemy(String[] taunts) {
        String name = randomLineFromFile(namesFilePath);
        String title = randomLineFromFile(titlesFilePath);
        Weapon weapon = generateWeapon();
        return new Enemy( name + " " + title, r.nextInt(25, 41), weapon, taunts);
    }

    public Player generatePlayer(String favouriteSaying) {
        String name = randomLineFromFile(namesFilePath);
        String title = randomLineFromFile(titlesFilePath);
        Weapon weapon = generateWeapon();
        return new Player( name + " " + title, r.nextInt(25, 41), weapon, favouriteSaying);
    }

    //Picking out your Weapon
    private Weapon generateWeapon() {
        Weapon[] values = Weapon.values();
        return values[r.nextInt(values.length)];
    }

    // Grabbing random file line
    private String randomLineFromFile(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine().strip());
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            throw new IllegalStateException(e);
        }
        return fileData.get(r.nextInt(0, fileData.size()));
    }
}