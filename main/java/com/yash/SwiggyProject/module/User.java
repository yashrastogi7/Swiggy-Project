package com.yash.SwiggyProject.module;
import java.util.ArrayList;
public class User {
    private int id;
    private ArrayList<Card> cards = new ArrayList<>();

    public User(int id)
    {
        this.id = id;
    }

    public void addCard(Card card) {

        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
        return;
    }
    public int giveId() {
        return id;
    }
    public ArrayList<Card> giveCards() {
        return cards;
    }
    public String toString() {
        return id + " " + cards.toString();
    }

}
