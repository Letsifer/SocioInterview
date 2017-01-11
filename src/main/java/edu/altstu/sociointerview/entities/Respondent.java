package edu.altstu.sociointerview.entities;

import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;

/**
 *
 * @author gea
 */
public class Respondent extends BasicEntity<Integer> {

    private Integer personalNumber;
    private Gender gender;
    private LivingTimeInMoscow livingTimeInMoscow;
    private Education education;
    private UsingInternet usingInternet;
    private HaveCar haveCar;
    private FamityMaterialConditionsEvaluation evaluation;
    private Income income;
}
