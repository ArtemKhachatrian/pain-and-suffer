package org.painandsuffer.battle;

import org.painandsuffer.characters.Adventurer;

import java.util.Scanner;

public class Battle {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.provideTwoPlayersPvP();
    }
    public void provideTwoPlayersPvP(){
        greetings();
        Adventurer playerOne = getAdventurer();
        Adventurer playerTwo = getAdventurer();
        providePvP(playerOne,playerTwo);
    }

    private void greetings() {
        System.out.println("Welcome to the game 'Pain and suffer'");
    }

    private void providePvP(Adventurer playerOne, Adventurer playerTwo){
        System.out.println("Battle begins");
        while (playerOne.getHealth() >0 && playerTwo.getHealth() >0) {
            playerOne.attack(playerTwo);
            playerTwo.attack(playerOne);
        }
        if (playerOne.getHealth() > 0){
            System.out.println(playerOne.getName() + "Win!honor and glory to the winner!");
        }
        else System.out.println(playerTwo.getName() + "Win!honor and glory to the winner!");
    }

    private Adventurer getAdventurer(){
        String adventureName = getAdventurerName();
        AdventurerClass adventurerClass = getAdventurerClass();
        return AdventurerFactory.createAdventurer(adventureName,adventurerClass);
    }

    private AdventurerClass getAdventurerClass(){
        System.out.println("Please select your class. You can choose - Warrior, Rogue, Mage");
        System.out.println("To choose one of the classes, please write it.");
        try {
            return AdventurerClass.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException argumentException){
            System.out.println("You write incorrect class");
            return getAdventurerClass();
        }
    }

    private String getAdventurerName(){
        System.out.println();
        return scanner.nextLine();
    }







}
