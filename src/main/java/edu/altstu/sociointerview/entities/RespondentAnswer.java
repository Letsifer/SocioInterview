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
@Table(schema = "interview", name = "respondents_answers")
@NoArgsConstructor
public class RespondentAnswer extends BasicEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "respondent_id")
    private Respondent respondent;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
