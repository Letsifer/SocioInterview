package edu.altstu.sociointerview.entities;

import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

/**
 *
 * @author gea
 */
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

    @Enumerated(EnumType.STRING)
    private Work work;

    @ManyToOne
    @JoinColumn(name = "income_id")
    private Income income;

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LivingTimeInMoscow getLivingTimeInMoscow() {
        return livingTimeInMoscow;
    }

    public void setLivingTimeInMoscow(LivingTimeInMoscow livingTimeInMoscow) {
        this.livingTimeInMoscow = livingTimeInMoscow;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public UsingInternet getUsingInternet() {
        return usingInternet;
    }

    public void setUsingInternet(UsingInternet usingInternet) {
        this.usingInternet = usingInternet;
    }

    public HaveCar getHaveCar() {
        return haveCar;
    }

    public void setHaveCar(HaveCar haveCar) {
        this.haveCar = haveCar;
    }

    public FamityMaterialConditionsEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(FamityMaterialConditionsEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }
}
