package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.hibernate.HibernateQuery;
import edu.altstu.sociointerview.entities.QRespondent;
import edu.altstu.sociointerview.entities.Respondent;
import edu.altstu.sociointerview.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Евгений
 */
public class RespondentsDao extends AbstractDao<Respondent, Integer> {

    @Override
    protected Respondent getEntityFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Respondent>(session)
                .from(QRespondent.respondent)
                .where(expression)
                .fetchOne();
    }

    @Override
    protected Respondent getEntityFromSession(Integer id, Session session) {
        return getEntityFromSession(QRespondent.respondent.id.eq(id), session);
    }

    @Override
    protected List<Respondent> getListOfEntitiesFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Respondent>(session)
                .from(QRespondent.respondent)
                .where(expression)
                .fetch();
    }

    public int findNumber(BooleanExpression expression) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            int number = new HibernateQuery<Respondent>(session)
                    .from(QRespondent.respondent)
                    .where(expression)
                    .fetch()
                    .size();
            session.getTransaction().commit();
            return number;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
