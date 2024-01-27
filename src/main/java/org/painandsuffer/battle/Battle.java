package org.painandsuffer.battle;

import org.painandsuffer.characters.Adventurer;

import java.util.Scanner;

public class Battle {
    Scanner scanner = new Scanner(System.in);
    public void provideTwoPlayersPvP(){
        greetings();
        providePvP(getAdventurer(),getAdventurer());
    }

    private void greetings() {
    }

    private void providePvP(Adventurer playerOne, Adventurer playerTwo){
        System.out.println("");
        while (playerOne.getHealth() !=0 || playerTwo.getHealth() !=0) {
            playerOne.attack(playerTwo);
            playerTwo.attack(playerOne);
        }
        if (playerOne.getHealth() > 0){
            System.out.println("");
        }
        else System.out.println("");
    }

    private Adventurer getAdventurer(){
        return AdventurerFactory.createAdventurer(getAdventurerName(),getAdventurerClass());
    }

    private AdventurerClass getAdventurerClass(){
        System.out.println("");
        try {
            return AdventurerClass.valueOf(scanner.next());
        } catch (IllegalArgumentException argumentException){
            System.out.println("");
            return getAdventurerClass();
        }
    }

    private String getAdventurerName(){
        System.out.println();
        return scanner.nextLine();
    }







}
