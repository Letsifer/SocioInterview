package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum HaveCar {

    OneCar("Да, есть один автомобиль"), 
    ManyCars("Да, есть более одного автомобиля"), 
    NoCar("Нет"), 
    HardToSay("Затрудняюсь ответить");

    private String description;

    private HaveCar(String description) {
        this.description = description;
    }
}
