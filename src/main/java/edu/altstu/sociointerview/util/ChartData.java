package edu.altstu.sociointerview.util;

/**
 *
 * @author gea
 */
public class ChartData {
    private String legend;
    
    private Integer number;

    public ChartData(String legend, Integer number) {
        this.legend = legend;
        this.number = number;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    
}
