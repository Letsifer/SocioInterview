package edu.altstu.sociointerview.util;

import edu.altstu.sociointerview.entities.Income;
import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;

/**
 *
 * @author gea
 */
public class RespondentFilter {
    
    private Integer lowerAgeBorder, higherAgeBorder;
    
    private Gender gender;

    private LivingTimeInMoscow livingTimeInMoscow;

    private Education education;

    private UsingInternet usingInternet;

    private HaveCar haveCar;

    private FamityMaterialConditionsEvaluation evaluation;

    private Work work;

    private Income income;

    public RespondentFilter() {
    }
    
    public Integer getLowerAgeBorder() {
        return lowerAgeBorder;
    }

    public void setLowerAgeBorder(Integer lowerAgeBorder) {
        this.lowerAgeBorder = lowerAgeBorder;
    }

    public Integer getHigherAgeBorder() {
        return higherAgeBorder;
    }

    public void setHigherAgeBorder(Integer higherAgeBorder) {
        this.higherAgeBorder = higherAgeBorder;
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
