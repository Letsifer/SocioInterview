package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum HaveCar {

    UNSELECTED("Не выбран"),
    OneCar("Да, есть один автомобиль"), 
    ManyCars("Да, есть более одного автомобиля"), 
    NoCar("Нет"), 
    HardToSay("Затрудняюсь ответить");

    private String description;

    private HaveCar(String description) {
        this.description = description;
    }
}
