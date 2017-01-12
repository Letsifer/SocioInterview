package edu.altstu.sociointerview.entities.enums;

/**
 *
 * @author Евгений
 */
public enum Work {
    
    BudgetNotProduction("Работаю в бюджетной непроизводственной сфере (образование, здравоохранение, культура, соцзащита)"),
    BudgetProduction("Работаю в бюджетной производственной сфере "),
    Businesmen("Бизнесмен, предприниматель"),
    MerchantNonProduction("Работаю в коммерческой организации (непроизводственная сфера)"),
    MerchantProduction("Работаю в коммерческой организации (производственная сфера)"),
    WarriorOrPolice("Военнослужащий, полиция и т.д."),
    NonWorkingPensioner("Неработающий пенсионер, в т.ч. по инвалидности"),
    Housewife("Домохозяйка и/или в отпуске по уходу за ребенком"),
    Student("Учащийся, студент (дневного отделения)"),
    NonWorkig("Безработный, ищу работу"),
    HardToSay("Затрудняюсь ответить /Отказ от ответа");
    
    private String description;

    private Work(String description) {
        this.description = description;
    }
    
    
}
