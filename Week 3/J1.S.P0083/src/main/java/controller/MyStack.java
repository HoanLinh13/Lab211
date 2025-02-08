package controller;

import Model.IStack;

import java.util.ArrayList;

public class MyStack implements IStack {
    private ArrayList<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stackValues.add(value);
        System.out.println("Pushed: " + value);
    }

    @Override
    public Integer pop() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        int value = stackValues.remove(stackValues.size() - 1);
        System.out.println("Popped: " + value);
        return value;
    }

    @Override
    public Integer get() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stackValues.get(stackValues.size() - 1);
    }

    @Override
    public void displayStack() {
        System.out.println("Stack: " + stackValues);
    }
}
