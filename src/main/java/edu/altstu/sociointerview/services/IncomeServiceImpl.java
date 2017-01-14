package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.dao.IncomeDao;
import edu.altstu.sociointerview.entities.Income;
import edu.altstu.sociointerview.entities.QIncome;
import java.util.List;

/**
 *
 * @author gea
 */
public class IncomeServiceImpl implements IncomeService{

    private IncomeDao incomeDao = new IncomeDao();
    
    @Override
    public Income getIncome(Integer id) {
        return incomeDao.getEntity(QIncome.income.orderNumber.eq(id));
    }

    @Override
    public List<Income> getAllIncomes() {
        return incomeDao.getListOfEntities(null);
    }
    
}
