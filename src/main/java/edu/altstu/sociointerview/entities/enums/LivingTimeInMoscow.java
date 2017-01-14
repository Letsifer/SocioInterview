package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum LivingTimeInMoscow {

    UNSELECTED("Не выбран"),
    Another("Другой район(город)"),
    LessOne("Менее 1 года"),
    OneToFive("От 1 до 5 лет"),
    SixToTen("От 6 до 10 лет"),
    ElevenOrMore("Свыше 11 лет");

    private String description;

    private LivingTimeInMoscow(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
