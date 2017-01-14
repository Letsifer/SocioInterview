package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.dao.RespondentsAnswerDao;
import edu.altstu.sociointerview.dao.RespondentsDao;
import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.entities.Respondent;
import edu.altstu.sociointerview.entities.RespondentAnswer;
import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;
import edu.altstu.sociointerview.util.IdsPool;
import edu.altstu.sociointerview.util.InputUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gea
 */
public class InputServiceImpl implements InputService {

    private RespondentsDao respondentsDao = new RespondentsDao();
    private RespondentsAnswerDao respondentsAnswerDao = new RespondentsAnswerDao();
    private QuestionServices questionServices = new QuestionServiceImpl();
    private AnswerService answerService = new AnswerServiceImpl();
    private CandidateService candidateService = new CandidateServiceImpl();

    private final IncomeService incomeService = new IncomeServiceImpl();

    private static final String respondentInfoFilePath = "src/main/resources/respondents.txt";
    private static final String answersInfoFilePath1 = "src/main/resources/answer1.txt";
    private static final String answersInfoFilePath2 = "src/main/resources/answer2.txt";
    private static final String answersInfoFilePath3 = "src/main/resources/answer3.txt";
    private static final String answersInfoFilePath4 = "src/main/resources/answer4.txt";
    private static final String answersInfoFilePath5 = "src/main/resources/answer5.txt";
    private static final String answersInfoFilePath6 = "src/main/resources/answer6.txt";
    private static final String answersInfoFilePath7 = "src/main/resources/answer7.txt";
    private static final String answersInfoFilePath8 = "src/main/resources/answer8.txt";

    @Override
    public void inputRespondentsData() throws Exception {
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
            respondentsDao.insertOrUpdateEntity(respondent, IdsPool.getRespondentPool().getValue());
        }
        input.close();
    }

    //<editor-fold defaultstate="collapsed" desc="input enums">
    private LivingTimeInMoscow switchLivingTime(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return LivingTimeInMoscow.Another;
            case 2:
                return LivingTimeInMoscow.LessOne;
            case 3:
                return LivingTimeInMoscow.OneToFive;
            case 4:
                return LivingTimeInMoscow.SixToTen;
            case 5:
                return LivingTimeInMoscow.ElevenOrMore;
            default:
                throw new IllegalArgumentException("Do not know such number in living time " + value);
        }
    }

    private Gender switchGender(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                throw new IllegalArgumentException("Do not know such number in gender " + value);
        }
    }

    private UsingInternet switchUsingInternet(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return UsingInternet.EveryDay;
            case 2:
                return UsingInternet.SometimesWeek;
            case 3:
                return UsingInternet.SometimesMonth;
            case 4:
                return UsingInternet.SometimesYear;
            case 5:
                return UsingInternet.DoNotUse;
            case 99:
                return UsingInternet.HardToSay;
            default:
                throw new IllegalArgumentException("Do not know such number in using internet " + value);
        }
    }

    private Education switchEducation(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return Education.ElementaryAndNotFinishedSecondary;
            case 2:
                return Education.SecondaryCommonPTU;
            case 3:
                return Education.SecondarySpecial;
            case 4:
                return Education.HighAndNotFinishedHigh;
            default:
                throw new IllegalArgumentException("Do not know such number in education " + value);
        }
    }

    private HaveCar switchHaveCar(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return HaveCar.OneCar;
            case 2:
                return HaveCar.ManyCars;
            case 3:
                return HaveCar.NoCar;
            case 99:
                return HaveCar.HardToSay;
            default:
                throw new IllegalArgumentException("Do not know such number in have car " + value);
        }
    }

    private FamityMaterialConditionsEvaluation switchEvaluation(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return FamityMaterialConditionsEvaluation.Excellent;
            case 2:
                return FamityMaterialConditionsEvaluation.Good;
            case 3:
                return FamityMaterialConditionsEvaluation.Average;
            case 4:
                return FamityMaterialConditionsEvaluation.Bad;
            case 5:
                return FamityMaterialConditionsEvaluation.VeryBad;
            case 99:
                return FamityMaterialConditionsEvaluation.HardToSay;
            default:
                throw new IllegalArgumentException("Do not know such number in evaluation " + value);
        }
    }

    private Work switchWork(int value) throws IllegalArgumentException {
        switch (value) {
            case 1:
                return Work.BudgetNotProduction;
            case 2:
                return Work.BudgetProduction;
            case 3:
                return Work.Businesmen;
            case 4:
                return Work.MerchantNonProduction;
            case 5:
                return Work.MerchantProduction;
            case 6:
                return Work.WarriorOrPolice;
            case 7:
                return Work.NonWorkingPensioner;
            case 8:
                return Work.Housewife;
            case 9:
                return Work.Student;
            case 10:
                return Work.NonWorkig;
            case 99:
                return Work.HardToSay;
            default:
                throw new IllegalArgumentException("Do not know such number in work " + value);
        }
    }
//</editor-fold>

    @Override
    public void inputAnswers() throws Exception {
        inputOneQuestion(answersInfoFilePath1);
        inputOneQuestion(answersInfoFilePath2);
        inputOneQuestion(answersInfoFilePath3);
        inputOneQuestion(answersInfoFilePath4);
        inputOneQuestion(answersInfoFilePath5);
        inputOneQuestion(answersInfoFilePath6);
        inputOneQuestion(answersInfoFilePath7);
        inputOneQuestion(answersInfoFilePath8);
    }

    private void inputOneQuestion(String filename) throws Exception {
        InputUtil input = new InputUtil(filename);
        int questionsNumber = input.nextInt();
        int respondentNumber = input.nextInt();
        for (int i = 0; i < questionsNumber; i++) {
            String text = input.readLine();
            boolean needCandidate = input.nextInt() == 1;
            Question question = questionServices.saveQuestion(text, needCandidate);
            int answerNumber = input.nextInt();
            Map<Integer, Answer> answers = new HashMap<>(answerNumber);
            for (int j = 0; j < answerNumber; j++) {
                int orderNumber = input.nextInt();
                text = input.readLine();
                Answer answer = answerService.saveAnswer(orderNumber, text, question);
                answers.put(orderNumber, answer);
            }
            if (needCandidate) {
                List<Candidate> candidates = candidateService.getAllCandidates();
                for (int k = 0; k < respondentNumber; k++) {
                    Respondent respondent = respondentsDao.getEntity(k + 1);
                    for (int j = 0; j < candidates.size(); j++) {
                        int choice = input.nextInt();
                        Answer answer = answers.get(choice);
                        RespondentAnswer respondentAnswer = new RespondentAnswer();
                        respondentAnswer.setCandidate(candidates.get(j));
                        respondentAnswer.setQuestion(question);
                        respondentAnswer.setAnswer(answer);
                        respondentAnswer.setRespondent(respondent);
                        respondentsAnswerDao.insertOrUpdateEntityFromSession(respondentAnswer, IdsPool.getRespAnswerPool().getValue());
                    }
                }
            } else {
                for (int j = 0; j < respondentNumber; j++) {
                    int choice = input.nextInt();
                    Answer answer = answers.get(choice);
                    RespondentAnswer respondentAnswer = new RespondentAnswer();
                    respondentAnswer.setQuestion(question);
                    respondentAnswer.setAnswer(answer);
                    respondentAnswer.setRespondent(respondentsDao.getEntity(j + 1));
                    respondentsAnswerDao.insertOrUpdateEntityFromSession(respondentAnswer, IdsPool.getRespAnswerPool().getValue());
                }
            }

        }

        input.close();
    }

}
