package com.yash.SwiggyProject.module;

public class Card {
    private int cardNumber;
    private Suit suit;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Card() {
    }

    public Card(int cardNumber, Suit suit) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", suit=" + suit +
                '}';
    }
}
