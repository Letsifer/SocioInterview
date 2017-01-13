package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum Education {

    UNSELECTED("Не выбран"),
    ElementaryAndNotFinishedSecondary("Начальное и неполное среднее"),
    SecondaryCommonPTU("Среднее общее, ПТУ"),
    SecondarySpecial("Среднее специальное"),
    HighAndNotFinishedHigh("Высшее, незаконченное высшее");

    private String description;

    private Education(String description) {
        this.description = description;
    }
}
