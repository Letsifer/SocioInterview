package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Question;
import java.util.List;

/**
 *
 * @author Евгений
 */
public interface QuestionServices {
    
    Question getQuestion(Integer id);
    
    List<Question> getAllQuestions();
    
    Question saveQuestion(String text, boolean needCandidate);
}
