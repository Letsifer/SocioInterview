package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.hibernate.HibernateQuery;
import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.QCandidate;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author gea
 */
public class CandidateDao extends AbstractDao<Candidate, Integer>{

    @Override
    protected Candidate getEntityFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Candidate>(session)
                .from(QCandidate.candidate)
                .where(expression)
                .fetchOne();
    }

    @Override
    protected Candidate getEntityFromSession(Integer id, Session session) {
        return getEntityFromSession(QCandidate.candidate.id.eq(id), session);
    }

    @Override
    protected List<Candidate> getListOfEntitiesFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Candidate>(session)
                .from(QCandidate.candidate)
                .where(expression)
                .fetch();
    }
    
}
