package org.painandsuffer.battle;

import org.painandsuffer.battle.statuses.Status;
import org.painandsuffer.characters.Creature;

import java.util.Iterator;

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
            playerAttack(playerOne, playerTwo);
            playerAttack(playerTwo, playerOne);
        }
    }

    private void playerAttack(Creature player, Creature target) {
        player.makeAction(() -> player.attack(target));
    }

    private void printWinnersName(Creature playerOne, Creature playerTwo) {
        if (playerOne.getHealth() <= 0 && playerTwo.getHealth() <= 0) {
            System.out.println("It's a draw! Both fighters are down!");
        } else {
            String winnerName = playerOne.getHealth() <= 0 ? playerTwo.getName() : playerOne.getName();
            System.out.printf("%s Wins! Honor and glory to the winner!", winnerName);
        }
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }
}
