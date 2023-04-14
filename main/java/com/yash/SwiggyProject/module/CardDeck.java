package com.yash.SwiggyProject.module;
import java.util.ArrayList;
import java.util.Collections;
public class CardDeck {
    private ArrayList<Card> deck;
    public CardDeck() {
        deck = new ArrayList<>();
        for(Suit suits : Suit.values()){
            for(int i = 1; i <= 13; i++){
                deck.add(new Card(i,suits));
            }
        }
        Collections.shuffle(deck);

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
