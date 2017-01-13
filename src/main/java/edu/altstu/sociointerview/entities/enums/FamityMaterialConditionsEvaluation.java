package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum FamityMaterialConditionsEvaluation {

    UNSELECTED("Не выбран"),
    Excellent("Очень хорошее"),
    Good("Хорошее"),
    Average("Среднее"),
    Bad("Плохое"),
    VeryBad("Очень плохое"),
    HardToSay("Затрубняюсь ответить");

    private String description;

    private FamityMaterialConditionsEvaluation(String description) {
        this.description = description;
    }
}
