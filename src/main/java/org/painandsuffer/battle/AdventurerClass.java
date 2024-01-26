package org.painandsuffer.battle;

public enum AdventurerClass {

    WARRIOR,
    MAGE,
    ROGUE,
    PALADIN;

    @Override
    public String toString() {
        char firstLetterUppercase = name().charAt(0);
        String nameLowerCase = name().toLowerCase();
        return nameLowerCase.replace(nameLowerCase.charAt(0), firstLetterUppercase);
    }
}
