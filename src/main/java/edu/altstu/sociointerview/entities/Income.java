package edu.altstu.sociointerview.entities;

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

    private int lowerBorder;

    private int higherBorder;

    private String text;
}
