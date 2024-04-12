package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder string = new StringBuilder("");
        Iterator<Character> iterator = evenElements.iterator();
        while (iterator.hasNext()) {
            string.append(iterator.next());
            iterator.next();
        }
        return string.toString();
    }

    private String getDescendingElements() {
        StringBuilder string = new StringBuilder("");
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            string.append(iterator.next());
        }
        return string.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
