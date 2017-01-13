package edu.altstu.sociointerview.controllers;

/**
 *
 * @author gea
 */
public enum ChartType {
    Pie("Круглая"), Bar("Гистограмма");

    private String text;

    private ChartType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
