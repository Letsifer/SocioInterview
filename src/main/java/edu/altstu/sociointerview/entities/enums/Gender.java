package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum Gender {
    UNSELECTED("Не выбран"), MALE("Мужской"), FEMALE("Женский");
    
    private String text;

    private Gender(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
}
