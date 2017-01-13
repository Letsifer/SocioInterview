package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.dao.AnswerDao;
import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.QAnswer;
import edu.altstu.sociointerview.entities.Question;
import java.util.List;

/**
 *
 * @author Евгений
 */
public class AnswerServiceImpl implements AnswerService{

    private AnswerDao answerDao = new AnswerDao();
    
    @Override
    public List<Answer> getAllAnswers() {
        return answerDao.getListOfEntities(null);
    }

    @Override
    public List<Answer> getQuestionsAnswers(Question question) {
        return answerDao.getListOfEntities(QAnswer.answer.question().id.eq(question.getId()));
    }

    @Override
    public Answer getAnswer(Integer id) {
        return answerDao.getEntity(id);
    }

    @Override
    public Answer saveAnswer(Integer id, String text, Question question) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setText(text);
        return answerDao.insertOrUpdateEntity(answer, id);
    }
    
}
