package com.company;

public class Question<T, M> {
    private T number;
    private M value;
    boolean answer = false;

    public Question(T number, M value) {
        this.number = number;
        this.value = value;
    }

    public boolean getAnswer() {
        return answer;
    }

    public T getNumber() {
        return number;
    }

    public M getValue() {
        return value;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
