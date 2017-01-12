package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.hibernate.HibernateQuery;
import edu.altstu.sociointerview.entities.Answer;
import edu.altstu.sociointerview.entities.QAnswer;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author gea
 */
public class AnswerDao extends AbstractDao<Answer, Integer>{

    @Override
    protected Answer getEntityFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Answer>(session)
                .from(QAnswer.answer)
                .where(expression)
                .fetchOne();
    }

    @Override
    protected Answer getEntityFromSession(Integer id, Session session) {
        return getEntityFromSession(QAnswer.answer.id.eq(id), session);
    }

    @Override
    protected List<Answer> getListOfEntitiesFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Answer>(session)
                .from(QAnswer.answer)
                .where(expression)
                .fetch();
    }
    
}
