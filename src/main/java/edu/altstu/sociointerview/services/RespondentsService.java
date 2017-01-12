package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.entities.Respondent;
import java.util.List;

/**
 * Интерфейс для подсчета ответов (по сути - главный сервис)
 *
 * @author Евгений
 */
public interface RespondentsService {
    
    int getRespondentsNumber(Respondent filter);

    List<Integer> getRespondentsAnswers(Respondent filter, Question question);
    
    List<Integer> getRespondentsForCandidate(Respondent filter, Question question, Candidate candidate);
}
