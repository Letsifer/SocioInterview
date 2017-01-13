package edu.altstu.sociointerview.util;

/**
 *
 * @author Евгений
 */
public class IdsPool {
    private static IdsPool respondentsPool = null, questionPool = null;
    
    public static IdsPool getRespondentPool() {
        if (respondentsPool == null) {
            respondentsPool = new IdsPool(0);
        }
        return respondentsPool;
    }
    
    public static IdsPool getQuestionPool() {
        if (questionPool == null) {
            questionPool = new IdsPool(0);
        }
        return questionPool;
    }
    
    private int currentValue;
    
    public IdsPool(int start) {
        currentValue = start + 1;
    }
    public int getValue() {
        return currentValue++;
    }
}
