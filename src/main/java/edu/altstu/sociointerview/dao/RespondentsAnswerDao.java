package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.hibernate.HibernateQuery;
import edu.altstu.sociointerview.entities.QRespondentAnswer;
import edu.altstu.sociointerview.entities.RespondentAnswer;
import edu.altstu.sociointerview.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author gea
 */
public class RespondentsAnswerDao {

    public int getCountWithExpression(BooleanExpression expression) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            int number = new HibernateQuery<RespondentAnswer>()
                    .from(QRespondentAnswer.respondentAnswer)
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

    public void insertOrUpdateEntityFromSession(RespondentAnswer entity) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            if (entity.getId() == null) {
                //TODO create ID
                session.save(entity);
            } else {
                session.update(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
