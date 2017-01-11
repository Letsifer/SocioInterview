package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import edu.altstu.sociointerview.entities.BasicEntity;
import edu.altstu.sociointerview.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Евгений
 */
public abstract class AbstractDao<T extends BasicEntity<PK>, PK extends Serializable> {

    public T getEntity(PK id) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            T entity = getEntityFromSession(id, session);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public T getEntity(BooleanExpression expression) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            T entity = getEntityFromSession(expression, session);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> getListOfEntities(BooleanExpression expression) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            List<T> entities = getListOfEntitiesFromSession(expression, session);
            session.getTransaction().commit();
            return entities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertOrUpdateEntity(T entity) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            insertOrUpdateEntityFromSession(entity, session);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract T getEntityFromSession(BooleanExpression expression, Session session);

    protected abstract T getEntityFromSession(PK id, Session session);

    protected abstract List<T> getListOfEntitiesFromSession(BooleanExpression expression, Session session);

    protected void insertOrUpdateEntityFromSession(T entity, Session session) {
        if (entity.getId() == null) {
            //TODO create ID
            session.save(entity);
        } else {
            session.update(entity);
        }
    }
}
