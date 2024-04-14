package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder string = new StringBuilder();
        int s = evenElements.size();
        for (int i = 0; i < s; i += 2) {
            string.append(evenElements.pollFirst());
            evenElements.pollFirst();
        }
        return string.toString();
    }

    private String getDescendingElements() {
        StringBuilder string = new StringBuilder();
        int s = descendingElements.size();
        for (int i = 0; i < s; i++) {
            string.append(descendingElements.pollLast());
        }
        return string.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
