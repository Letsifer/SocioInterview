package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author gea
 */
public enum UsingInternet {

    UNSELECTED("Не выбран"),
    EveryDay("Практически ежедневно"),
    SometimesWeek("Несколько раз в неделю"),
    SometimesMonth("Несколько раз в месяц"),
    SometimesYear("Эпизодически, но не менее 1 раза в полгода"),
    DoNotUse("Не пользуюсь"),
    HardToSay("Затрудняюсь ответить");

    private String description;

    private UsingInternet(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
