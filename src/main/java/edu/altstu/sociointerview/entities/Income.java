package edu.altstu.sociointerview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
@Entity
@Table(schema = "interview", name = "incomes")
@NoArgsConstructor
public class Income extends BasicEntity<Integer> {

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "lower_border")
    private Integer lowerBorder;

    @Column(name = "higher_border")
    private Integer higherBorder;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
