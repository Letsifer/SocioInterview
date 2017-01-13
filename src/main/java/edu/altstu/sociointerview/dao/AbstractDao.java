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

    public T insertOrUpdateEntity(T entity, PK id) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            entity = insertOrUpdateEntityFromSession(entity, id, session);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract T getEntityFromSession(BooleanExpression expression, Session session);

    protected abstract T getEntityFromSession(PK id, Session session);

    protected abstract List<T> getListOfEntitiesFromSession(BooleanExpression expression, Session session);

    protected T insertOrUpdateEntityFromSession(T entity, PK id, Session session) {
        if (entity.getId() == null) {
            entity.setId(id);
            session.save(entity);
        } else {
            session.update(entity);
        }
        return entity;
    }
}
