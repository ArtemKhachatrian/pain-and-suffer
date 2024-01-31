package org.painandsuffer.battle;

import org.painandsuffer.battle.status.PublicStatus;
import org.painandsuffer.battle.status.Status;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.characters.adventurers.Adventurer;

public class Battle {

    int roundCounter;

    public void providePvP(Adventurer playerOne, Adventurer playerTwo) {
        System.out.println("Battle begins");
        fightUntilDeath(playerOne, playerTwo);
        printWinnersName(playerOne, playerTwo);
    }

    private void fightUntilDeath(Adventurer playerOne, Adventurer playerTwo) {
        while (playerOne.getHealth() > 0 && playerTwo.getHealth() > 0) {
            roundCounter++;
            checkStatuses(playerOne, playerTwo);
            playerOne.attack(playerTwo);
            playerTwo.attack(playerOne);

        }
    }

    private void checkStatuses(Creature ...creatures) {
        for (Creature creature : creatures) {
            for (Status status : creature.getStatuses()) {
                status.setRoundsDuration(status.getRoundsDuration() - 1);
               //TO DO: status.applyStatusCondition();
                status.removeIfExpired();
            }
        }
    }

    private void printWinnersName(Adventurer playerOne, Adventurer playerTwo) {
        String winnerName = playerOne.getHealth() > 0 ? playerOne.getName() : playerTwo.getName();
        System.out.printf("%s Wins! Honor and glory to the winner!", winnerName);
    }

    public int getRoundCounter() {
        return roundCounter;
    }
}
