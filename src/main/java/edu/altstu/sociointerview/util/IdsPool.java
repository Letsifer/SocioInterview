package edu.altstu.sociointerview.util;

/**
 *
 * @author Евгений
 */
public class IdsPool {
    private static IdsPool respondentsPool = null, questionPool = null, answerPool = null, respAnswerPool = null;
    
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
    
    public static IdsPool getAnswerPool() {
        if (answerPool == null) {
            answerPool = new IdsPool(0);
        }
        return answerPool;
    }
    
    public static IdsPool getRespAnswerPool() {
        if (respAnswerPool == null) {
            respAnswerPool = new IdsPool(0);
        }
        return respAnswerPool;
    }
    
    private int currentValue;
    
    public IdsPool(int start) {
        currentValue = start + 1;
    }
    public int getValue() {
        return currentValue++;
    }
}
