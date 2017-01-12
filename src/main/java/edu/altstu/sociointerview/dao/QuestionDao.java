package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.hibernate.HibernateQuery;
import edu.altstu.sociointerview.entities.QQuestion;
import edu.altstu.sociointerview.entities.Question;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author gea
 */
public class QuestionDao extends AbstractDao<Question, Integer> {

    @Override
    protected Question getEntityFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Question>(session)
                .from(QQuestion.question)
                .where(expression)
                .fetchOne();
    }

    @Override
    protected Question getEntityFromSession(Integer id, Session session) {
        return getEntityFromSession(QQuestion.question.id.eq(id), session);
    }

    @Override
    protected List<Question> getListOfEntitiesFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Question>(session)
                .from(QQuestion.question)
                .where(expression)
                .fetch();
    }

}
