package org.painandsuffer.battle;

public enum AdventurerWeapon {

    SWORD,
    STAFF,
    DAGGER;

    public String toString() {
        char firstLetterUppercase = name().charAt(0);
        String nameLowerCase = name().toLowerCase();
        return nameLowerCase.replace(nameLowerCase.charAt(0), firstLetterUppercase);
    }
}
