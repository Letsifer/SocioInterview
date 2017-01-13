package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.util.ChartData;
import edu.altstu.sociointerview.util.RespondentFilter;
import java.util.List;

/**
 * Интерфейс для подсчета ответов (по сути - главный сервис)
 *
 * @author Евгений
 */
public interface RespondentsService {
    
    int getRespondentsNumber(RespondentFilter filter);

    List<ChartData> getRespondentsAnswers(RespondentFilter filter, Question question);
    
    List<ChartData> getRespondentsForCandidate(RespondentFilter filter, Question question, Candidate candidate);
}
