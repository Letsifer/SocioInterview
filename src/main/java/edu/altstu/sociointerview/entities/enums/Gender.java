package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum Gender {
    MALE("Мужской"), FEMALE("Женский");
    
    private String text;

    private Gender(String text) {
        this.text = text;
    }
    
}
