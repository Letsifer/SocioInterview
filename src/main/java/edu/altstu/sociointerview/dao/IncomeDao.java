package edu.altstu.sociointerview.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.hibernate.HibernateQuery;
import edu.altstu.sociointerview.entities.Income;
import edu.altstu.sociointerview.entities.QIncome;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author gea
 */
public class IncomeDao extends AbstractDao<Income, Integer> {

    @Override
    protected Income getEntityFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Income>(session)
                .from(QIncome.income)
                .where(expression)
                .fetchOne();
    }

    @Override
    protected Income getEntityFromSession(Integer id, Session session) {
        return getEntityFromSession(QIncome.income.id.eq(id), session);
    }

    @Override
    protected List<Income> getListOfEntitiesFromSession(BooleanExpression expression, Session session) {
        return new HibernateQuery<Income>(session)
                .from(QIncome.income)
                .where(expression)
                .fetch();
    }

}
