package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.dao.QuestionDao;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.util.IdsPool;
import java.util.List;

/**
 *
 * @author Евгений
 */
public class QuestionServiceImpl implements QuestionServices{

    private QuestionDao questionDao = new QuestionDao();
    
    @Override
    public List<Question> getAllQuestions() {
        return questionDao.getListOfEntities(null);
    }

    @Override
    public Question saveQuestion(String text, boolean needCandidate) {
        Question question = new Question();
        question.setText(text);
        question.setNeedCandidate(needCandidate);
        return questionDao.insertOrUpdateEntity(question, IdsPool.getQuestionPool().getValue());
    }
    
}
