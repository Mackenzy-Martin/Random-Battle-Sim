import java.util.Random;

/**
 * This is where all the fights are done with battles and wars on the horizon.
 */
public class Battle {
    Random r = new Random();

    /**
     *  Takes in 10 contestants for a round-robin style tournament. These contestants are than split into two brackets of 5, then they fight each other to declare the semi-final winners.
     *  The semi-final winners then have an ultimate battle to win the entire tournament.
     *
     * @param contestant1 This is a fighter in the tournament.
     * @param contestant2 This is a fighter in the tournament.
     * @param contestant3 This is a fighter in the tournament.
     * @param contestant4 This is a fighter in the tournament.
     * @param contestant5 This is a fighter in the tournament.
     * @param contestant6 This is a fighter in the tournament.
     * @param contestant7 This is a fighter in the tournament.
     * @param contestant8 This is a fighter in the tournament.
     * @param contestant9 This is a fighter in the tournament.
     * @param contestant10 This is a fighter in the tournament.
     */
    public void roundRobinTournament (Character contestant1, Character contestant2, Character contestant3, Character contestant4, Character contestant5, Character contestant6, Character contestant7,Character contestant8, Character contestant9, Character contestant10) {
        Character[] bracketOne = {contestant1, contestant2, contestant3, contestant4, contestant5};
        Character[] bracketTwo = {contestant6, contestant7, contestant8, contestant9, contestant10};
        Character[] winOne = firstBrackets(bracketOne);
        Character[] winTwo = firstBrackets(bracketTwo);

        winOne[0].resetWins();
        winOne[1].resetWins();
        winTwo[0].resetWins();
        winTwo[1].resetWins();

        Character winnerOne = runBattle(winOne[0], winTwo[1]);
        System.out.println(winnerOne.getName() + " is the winner of the semi-final");
        winnerOne.reset();
        Character winnerTwo = runBattle(winOne[1], winTwo[0]);
        System.out.println(winnerTwo.getName() + " is the winner of the semi-final");
        winnerTwo.reset();

        Character champ = runBattle(winnerOne, winnerTwo);
        System.out.println(champ.getName() + " is the victor of the tournament!!!");
    }

    /**
     * This is where the first brackets of the tournament duke it out.
     *
     * @param bracket This is the respective bracket entering the fight.
     * @return It returns two winners of the fight which is whoever has the most wins after the battle.
     */
    private Character[] firstBrackets (Character[] bracket) {
        int numberOne = 0;
        int numberTwo = 0;
        int numberThree = 0;
        Character[] winners = {null, null};

        //Actual Fight
        while (numberOne != 4) {
            numberTwo += 1;
            Character winner = runBattle(bracket[numberOne], bracket[numberTwo]);
            bracket[numberOne].reset();
            bracket[numberTwo].reset();
            System.out.println(winner.getName() + " won the round.");
            winner.addWin();
            if (numberTwo == 4) {
                numberOne += 1;
                numberTwo = numberOne;
            }
        }

        //Winner Checker
        numberTwo = 4;
        while (winners[1] == null) {
            numberOne = 0;

            while (numberOne != 5 && winners[1] == null) {
                if (bracket[numberOne].getWins() == numberTwo) {
                    winners[numberThree] = bracket[numberOne];
                    numberThree += 1;
                }
                numberOne += 1;
            }
            numberTwo -= 1;
        }
        return winners;
    }

    /**
     * This runs a two out of three battle, the two fighters have separate battles until one fighter wins twice.
     *
     * @param playerCharacter This is a fighter.
     * @param enemyCharacter This is a fighter.
     */
    public void twoOutOfThree(Character playerCharacter, Character enemyCharacter) {
        while (true) {
            Character winner = runBattle(playerCharacter, enemyCharacter);
            boolean isWinner = isWinnerDeclared(winner);
            if (isWinner) {
                if (declareWinner(winner)) {
                    break;
                }
                playerCharacter.reset();
                enemyCharacter.reset();
            }
        }
    }

    /**
     * This is a simple test to make sure that someone actually won the fight.
     *
     * @param winner This is whoever won the battle.
     * @return This will say if the check found a winner.
     */
    private boolean isWinnerDeclared(Character winner) {
        if (winner != null) {
            return true;
        }
        return false;
    }

    /**
     * This will declare who won the battle as well as checking if they won the Two out of Three fight.
     *
     * @param winner This is whoever won the actual fight.
     * @return this will return False unless the winner has two wins in which it returns True to end the battle.
     */
    private boolean declareWinner(Character winner) {
        System.out.println(winner.getName() + " won the fight.");
        winner.addWin();
        if (winner.getWins() == 2) {
            System.out.println(winner.getName() + " won the war!!!");
            return true;
        }
        return false;
    }

    /**
     * This serves to introduce the fighters in the two out of three tournament.
     *
     * @param player The character who is introduces first.
     * @param enemy The character who is introduces second.
     */
    private void introduceCharacters(Character player, Character enemy) {
        System.out.println("\n" + "------------Let the Battle Begin------------" + "\n" +
                player.getName() + " wields their " + player.getWeapon().getName() + ".");
        player.battleCry();
        System.out.println("\n" + enemy.getName() + " wields their " + enemy.getWeapon().getName() + ".");
        enemy.battleCry();
        System.out.println();
    }

    /**
     * This is where the actual battle takes place.
     *
     * @param fighter1 This is the fighter who strikes first.
     * @param fighter2 This is the fighter that strikes second.
     * @return This returns whoever won the battle.
     */
    private Character runBattle(Character fighter1, Character fighter2) {
        introduceCharacters(fighter1, fighter2);
        Character winner = null;
        while (true) {
            if (fighter1.getHealth() > 0){
                winner = fight(fighter1, fighter2);
            }
            if (fighter1.getHealth() > 0){
                winner = fight(fighter2, fighter1);
            }
            if (winner != null) {
                return winner;
            }
        }
    }

    /**
     * This is where a character gets hit.
     *
     * @param attacker The character attacking defender.
     * @param defender The character being attacked by the attacker.
     * @return After checking if the character survived it will either return a winner or null if the defender has more than 0 Health.
     */
    private Character fight(Character attacker, Character defender) {
        int damage = r.nextInt(attacker.getWeapon().getMinDamage(), attacker.getWeapon().getMaxDamage());
        defender.takeDamage(damage);
        battleUpdate(attacker, defender, damage);
        if (defender.getHealth() <= 0) {
            return attacker;
        } else {
            return null;
        }
    }

    /**
     * Print statements that tell you how much damage has been dealt as well as the victims remaining health.
     * 
     * @param attacker The person dealing damage.
     * @param defender The person taking damage.
     * @param damage The amount of damage being dealt/taken.
     */
    private void battleUpdate (Character attacker, Character defender, int damage) {
        System.out.println(attacker.getName() + " hit " + defender.getName() + " for " + damage + " damage.");
        System.out.println(defender.getName() + " HP: " + defender.getHealth() + "\n");
    }
}
