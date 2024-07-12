package week1.oop;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class exercise4 {
    private final ArrayList<Object> elements;

    // Constructor initializes the stack
    public exercise4() {
        elements = new ArrayList<>();
    }

    // Adds an element to the top of the stack
    public void push(Object element) {
        elements.add(element);
    }

    // Removes and returns the top element of the stack
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}