package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.Respondent;

/**
 * Интерфейс для подсчета ответов (по сути - главный сервис)
 *
 * @author Евгений
 */
public interface RespondentsService {

    int getRespondentsForAnswer(Respondent filter, Answer answer);
    
    int getRespondentsForCandidate(Respondent filter, Answer answer, Candidate candidate);
}
