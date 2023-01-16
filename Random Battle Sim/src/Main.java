import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CharacterCreator charaCreator = new CharacterCreator("Text_Files/Names.txt", "Text_Files/Titles.txt");
        String [] taunts = {"Muh ha ha", "I am your worst feo", "You're not me therefor you suck"};
        Battle battle = new Battle();
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("\n Enter \"A\" to activate the best two out of three tournament, \n Enter \"B\" to run a round robin tournament, \n Enter \"C\" to exit the battle program,");
            String tournament = scan.nextLine();
            tournament = tournament.strip().toUpperCase(Locale.ROOT);
            if (tournament.equals("A")){
                battle.twoOutOfThree(charaCreator.generatePlayer("Mash potatoes"), charaCreator.generateEnemy(taunts));
            }else if (tournament.equals("B")){
                battle.roundRobinTournament(
                        charaCreator.generatePlayer("I am undefeatable"),
                        charaCreator.generatePlayer("Bring it on"),
                        charaCreator.generatePlayer("You don't stand a chance"),
                        charaCreator.generatePlayer("Together we stand"),
                        charaCreator.generatePlayer("I'm hungry"),
                        charaCreator.generatePlayer("Please not the face"),
                        charaCreator.generatePlayer("I'll make you pay"),
                        charaCreator.generatePlayer("Red Robin, Yum"),
                        charaCreator.generatePlayer("I'm armed and ready"),
                        charaCreator.generatePlayer("I'll give you one chance to give up"));
            }else if(tournament.equals("C")){
                break;
            } else {
                System.out.println("-------------------------------Not accepted input!!!-------------------------------");
            };
        };
        System.out.println("Thanks for playing! :)");
    };
};

