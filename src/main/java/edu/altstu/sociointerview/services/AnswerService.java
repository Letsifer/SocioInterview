package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.Question;
import java.util.List;

/**
 *
 * @author gea
 */
public interface AnswerService {
    
    List<Answer> getAllAnswers();
    
    List<Answer> getQuestionsAnswers(Question question);
    
    Answer getAnswer(Integer id);
    
    Answer saveAnswer(Integer orderNumber, String text, Question question);
}
