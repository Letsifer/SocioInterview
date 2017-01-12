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
@Table(schema = "interview", name = "questions")
@NoArgsConstructor
public class Question extends BasicEntity<Integer> {

    private String text;
    private Boolean needCandidate;
}
