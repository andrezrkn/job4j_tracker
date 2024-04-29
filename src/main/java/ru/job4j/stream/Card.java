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

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public static void main(String[] args) {
       List<Card> card = Stream.of(Suit.values())
               .flatMap(e -> Stream.of(Value.values())
                       .map((l -> new Card(e, l))))
               .toList();
       card.forEach((a) -> {
           System.out.println(a.getSuit());
           System.out.println(a.getValue());
       });
    }
}
