package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.dao.AnswerDao;
import edu.altstu.sociointerview.dao.CandidateDao;
import edu.altstu.sociointerview.dao.QuestionDao;
import edu.altstu.sociointerview.dao.RespondentsAnswerDao;
import edu.altstu.sociointerview.dao.RespondentsDao;
import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.entities.Respondent;
import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;
import edu.altstu.sociointerview.util.InputUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author gea
 */
public class InputServiceImpl implements InputService{

    private RespondentsDao respondentsDao = new RespondentsDao();
    private RespondentsAnswerDao respondentsAnswerDao = new RespondentsAnswerDao();
    private QuestionServices questionServices;
    private AnswerService answerService;
    private CandidateService candidateService;
    
    private IncomeService incomeService;
    
    private static final String respondentInfoFilePath = "filesystem:${basedir}/src/main/resources/respondents.txt";
    private static final String answersInfoFilePath = "filesystem:${basedir}/src/main/resources/answers.txt";
    
    @Override
    public void inputRespondentsData() throws Exception{
        InputUtil input = new InputUtil(respondentInfoFilePath);
        int respondentNumber = input.nextInt();
        for (int i = 0; i < respondentNumber; i++) {
            Respondent respondent = new Respondent();
            respondent.setPersonalNumber(input.nextInt());
            respondent.setLivingTimeInMoscow(switchLivingTime(input.nextInt()));
            respondent.setGender(switchGender(input.nextInt()));
            respondent.setAge(input.nextInt());
            respondent.setEducation(switchEducation(input.nextInt()));
            respondent.setUsingInternet(switchUsingInternet(input.nextInt()));
            respondent.setHaveCar(switchHaveCar(input.nextInt()));
            respondent.setWork(switchWork(input.nextInt()));
            respondent.setEvaluation(switchEvaluation(input.nextInt()));
            respondent.setIncome(incomeService.getIncome(input.nextInt()));
            respondentsDao.insertOrUpdateEntity(respondent);
        }
        input.close();
    }
    
    //<editor-fold defaultstate="collapsed" desc="input enums">
    private LivingTimeInMoscow switchLivingTime(int value) throws IllegalArgumentException{
        switch(value) {
            case 1: return LivingTimeInMoscow.Another;
            case 2: return LivingTimeInMoscow.LessOne;
            case 3: return LivingTimeInMoscow.OneToFive;
            case 4: return LivingTimeInMoscow.SixToTen;
            case 5: return LivingTimeInMoscow.ElevenOrMore;
            default: throw new IllegalArgumentException("Do not know such number in living time " + value);
        }
    }
    
    private Gender switchGender(int value) throws IllegalArgumentException {
        switch(value) {
            case 1: return Gender.MALE;
            case 2: return Gender.FEMALE;
            default: throw new IllegalArgumentException("Do not know such number in gender " + value);
        }
    }
    
    private UsingInternet switchUsingInternet(int value) throws IllegalArgumentException{
        switch(value) {
            case 1: return UsingInternet.EveryDay;
            case 2: return UsingInternet.SometimesWeek;
            case 3: return UsingInternet.SometimesMonth;
            case 4: return UsingInternet.SometimesYear;
            case 5: return UsingInternet.DoNotUse;
            case 99: return UsingInternet.HardToSay;
            default: throw new IllegalArgumentException("Do not know such number in using internet " + value);
        }
    }
    
    private Education switchEducation(int value) throws IllegalArgumentException {
        switch (value) {
            case 1: return Education.ElementaryAndNotFinishedSecondary;
            case 2: return Education.SecondaryCommonPTU;
            case 3: return Education.SecondarySpecial;
            case 4: return Education.HighAndNotFinishedHigh;
            default: throw new IllegalArgumentException("Do not know such number in education " + value);
        }
    }
    
    private HaveCar switchHaveCar(int value) throws IllegalArgumentException {
        switch(value) {
            case 1: return HaveCar.OneCar;
            case 2: return HaveCar.ManyCars;
            case 3: return HaveCar.NoCar;
            case 99: return HaveCar.HardToSay;
            default: throw new IllegalArgumentException("Do not know such number in have car " + value);
        }
    }
    
    private FamityMaterialConditionsEvaluation switchEvaluation(int value) throws IllegalArgumentException {
        switch(value) {
            case 1: return FamityMaterialConditionsEvaluation.Excellent;
            case 2: return FamityMaterialConditionsEvaluation.Good;
            case 3: return FamityMaterialConditionsEvaluation.Average;
            case 4: return FamityMaterialConditionsEvaluation.Bad;
            case 5: return FamityMaterialConditionsEvaluation.VeryBad;
            case 99: return FamityMaterialConditionsEvaluation.HardToSay;
            default: throw new IllegalArgumentException("Do not know such number in evaluation " + value);
        }
    }
    
    private Work switchWork(int value) throws IllegalArgumentException {
        switch(value) {
            case 1: return Work.BudgetNotProduction;
            case 2: return Work.BudgetProduction;
            case 3: return Work.Businesmen;
            case 4: return Work.MerchantNonProduction;
            case 5: return Work.MerchantProduction;
            case 6: return Work.WarriorOrPolice;
            case 7: return Work.NonWorkingPensioner;
            case 8: return Work.Housewife;
            case 9: return Work.Student;
            case 10: return Work.NonWorkig;
            case 99: return Work.HardToSay;
            default: throw new IllegalArgumentException("Do not know such number in work " + value);
        }
    }
//</editor-fold>

    @Override
    public void inputAnswers() throws Exception {
        InputUtil input = new InputUtil(answersInfoFilePath);
        int questionsNumber = input.nextInt();
        int respondentNumber = input.nextInt();
        for (int i = 0; i < questionsNumber; i++) {
            String text = input.readLine();
            Question question = questionServices.saveQuestion(text);
            boolean needCandidate = input.nextInt() == 1;
            int answerNumber = input.nextInt();
            Map<Integer, Answer> answers = new HashMap<>(answerNumber);
            for (int j = 0; j < answerNumber; j++) {
                text = input.readLine();
                Answer answer = answerService.saveAnswer(text, question);
                answers.put(answer.getId(), answer);
            }
            
            
            for (int j = 0; j < respondentNumber; j++) {
                
            }
        }
        input.close();
    }

    
}
