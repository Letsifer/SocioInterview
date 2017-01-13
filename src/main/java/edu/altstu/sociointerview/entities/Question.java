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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getNeedCandidate() {
        return needCandidate;
    }

    public void setNeedCandidate(Boolean needCandidate) {
        this.needCandidate = needCandidate;
    }

    private String text;
    private Boolean needCandidate;
}
