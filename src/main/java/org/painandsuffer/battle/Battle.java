package org.painandsuffer.battle;

import org.painandsuffer.battle.statuses.Status;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.characters.adventurers.Adventurer;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Warrior;

public class Battle {

    int roundCounter;

    public void providePvP(Creature playerOne, Creature playerTwo) {
        System.out.println("Battle begins");
        fightUntilDeath(playerOne, playerTwo);
        printWinnersName(playerOne, playerTwo);
    }


    private void fightUntilDeath(Creature playerOne, Creature playerTwo) {
        while (playerOne.getHealth() > 0 && playerTwo.getHealth() > 0) {
            roundCounter++;
            checkStatuses(playerOne, playerTwo);
            playerOne.attack(playerTwo);
            playerTwo.attack(playerOne);

        }
    }

    private void checkStatuses(Creature... creatures) {
        for (Creature creature : creatures) {
            for (Status status : creature.getStatuses()) {
                status.removeIfExpired();
                status.setRoundsDuration(status.getRoundsDuration() - 1);
                //TO DO: status.applyStatusCondition();
            }
        }
    }

    private void printWinnersName(Creature playerOne, Creature playerTwo) {
        String winnerName = playerOne.getHealth() > 0 ? playerOne.getName() : playerTwo.getName();
        System.out.printf("%s Wins! Honor and glory to the winner!", winnerName);
    }

    public int getRoundCounter() {
        return roundCounter;
    }
}
