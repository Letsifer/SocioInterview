package edu.altstu.sociointerview.entities;

import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(schema = "interview", name = "respondents")
@NoArgsConstructor
public class Respondent extends BasicEntity<Integer> {

    private Integer personalNumber;
    
    private Integer age;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Enumerated(EnumType.STRING)
    private LivingTimeInMoscow livingTimeInMoscow;
    
    @Enumerated(EnumType.STRING)
    private Education education;
    
    @Enumerated(EnumType.STRING)
    private UsingInternet usingInternet;
    
    @Enumerated(EnumType.STRING)
    private HaveCar haveCar;
    
    @Enumerated(EnumType.STRING)
    private FamityMaterialConditionsEvaluation evaluation;
    
    @ManyToOne
    @JoinColumn(name = "income_id")
    private Income income;
}
