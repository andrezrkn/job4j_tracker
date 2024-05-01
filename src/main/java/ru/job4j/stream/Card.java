package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
       List<Card> card = Stream.of(Suit.values())
               .flatMap(e -> Stream.of(Value.values())
                       .map((l -> new Card(e, l))))
               .toList();
       card.forEach(a -> System.out.println(a.toString()));
    }
}
