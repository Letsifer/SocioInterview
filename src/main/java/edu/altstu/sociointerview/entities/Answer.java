package edu.altstu.sociointerview.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(schema = "interview", name = "answers")
@NoArgsConstructor
public class Answer extends BasicEntity<Integer> {

    private String text;
    
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
