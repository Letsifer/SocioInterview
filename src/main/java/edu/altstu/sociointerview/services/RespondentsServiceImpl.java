package edu.altstu.sociointerview.services;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import edu.altstu.sociointerview.dao.AnswerDao;
import edu.altstu.sociointerview.dao.RespondentsAnswerDao;
import edu.altstu.sociointerview.dao.RespondentsDao;
import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.QAnswer;
import edu.altstu.sociointerview.entities.QCandidate;
import edu.altstu.sociointerview.entities.QRespondent;
import edu.altstu.sociointerview.entities.QRespondentAnswer;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;
import edu.altstu.sociointerview.util.ChartData;
import edu.altstu.sociointerview.util.RespondentFilter;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gea
 */
public class RespondentsServiceImpl implements RespondentsService {

    private RespondentsDao respondentsDao = new RespondentsDao();
    private RespondentsAnswerDao respondetsAnswerDao = new RespondentsAnswerDao();
    private AnswerDao answerDao = new AnswerDao();

    @Override
    public int getRespondentsNumber(RespondentFilter filter) {
//        return respondentsDao.findNumber(respondentToPredicae(filter), session)
        throw new UnsupportedOperationException("Количество пока не ищется");
    }

    @Override
    public List<ChartData> getRespondentsAnswers(RespondentFilter filter, Question question) {
        List<Answer> answers = answerDao.getListOfEntities(QAnswer.answer.question().id.eq(question.getId()));
        BooleanExpression expression = respondentToPredicate(filter);
        return answers.parallelStream().map(ans -> {
            BooleanExpression modified = QRespondentAnswer.respondentAnswer.answer().id.eq(ans.getId());
            return new ChartData(ans.getText(), respondetsAnswerDao.getCountWithExpression(modified.and(expression)));
        })
                .collect(Collectors.toList());
    }

    @Override
    public List<ChartData> getRespondentsForCandidate(RespondentFilter filter, Question question, Candidate candidate) {
        List<Answer> answers = answerDao.getListOfEntities(QAnswer.answer.question().id.eq(question.getId()));
        BooleanExpression expression = QCandidate.candidate.id.eq(candidate.getId()).and(respondentToPredicate(filter));
        return answers.parallelStream().map(ans -> {
            BooleanExpression modified = QRespondentAnswer.respondentAnswer.answer().id.eq(ans.getId());
            return new ChartData(ans.getText(), respondetsAnswerDao.getCountWithExpression(modified.and(expression)));
        })
                .collect(Collectors.toList());
    }

    private BooleanExpression respondentToPredicate(RespondentFilter filter) {
        QRespondent respondent = QRespondent.respondent;
        BooleanExpression exp = betweenExpression(null, filter.getLowerAgeBorder(), filter.getHigherAgeBorder(), respondent.age);
        if (filter.getGender() != Gender.UNSELECTED) {
            exp = andExpression(exp, filter.getGender(), respondent.gender);
        }
        if (filter.getEducation() != Education.UNSELECTED) {
            exp = andExpression(exp, filter.getEducation(), respondent.education);
        }
        if (filter.getEvaluation() != FamityMaterialConditionsEvaluation.UNSELECTED) {
            exp = andExpression(exp, filter.getEvaluation(), respondent.evaluation);
        }
        if (filter.getHaveCar() != HaveCar.UNSELECTED) {
            exp = andExpression(exp, filter.getHaveCar(), respondent.haveCar);
        }

        exp = andExpression(exp, filter.getIncome().getId(), respondent.income().id);

        if (filter.getLivingTimeInMoscow() != LivingTimeInMoscow.UNSELECTED) {
            exp = andExpression(exp, filter.getLivingTimeInMoscow(), respondent.livingTimeInMoscow);
        }
        if (filter.getUsingInternet() != UsingInternet.UNSELECTED) {
            exp = andExpression(exp, filter.getUsingInternet(), respondent.usingInternet);
        }
        if (filter.getWork() != Work.UNSELECTED) {
            exp = andExpression(exp, filter.getWork(), respondent.work);
        }
        return exp;
    }

    private BooleanExpression betweenExpression(BooleanExpression last, Integer lower, Integer higher, NumberPath<Integer> path) {
        if (lower != null) {
            last = andPredicate(last, path.goe(lower));
        }
        if (higher != null) {
            last = andPredicate(last, path.loe(higher));
        }
        return last;
    }

    public <T extends Enum<T>> BooleanExpression andExpression(final BooleanExpression last,
            final T value, final EnumPath<T> path) {
        if (value != null) {
            return andPredicate(last, path.eq(value));
        }
        return last;
    }

    private BooleanExpression andExpression(BooleanExpression last, Integer value, NumberPath<Integer> path) {
        if (value == null) {
            return last;
        }
        return andPredicate(last, path.eq(value));
    }

    private BooleanExpression andPredicate(BooleanExpression last, BooleanExpression append) {
        if (last == null) {
            return append;
        }
        return last.and(append);
    }

}
