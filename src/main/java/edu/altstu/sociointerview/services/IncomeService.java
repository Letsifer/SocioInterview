package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Income;
import java.util.List;

/**
 *
 * @author gea
 */
public interface IncomeService {
    Income getIncome(Integer id);
    
    List<Income> getAllIncomes();
}
