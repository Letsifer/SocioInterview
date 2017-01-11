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
@Table(schema = "interview", name = "candidates")
@NoArgsConstructor
public class Candidate extends BasicEntity<Integer> {

    private String fio;
    private String description;
}
