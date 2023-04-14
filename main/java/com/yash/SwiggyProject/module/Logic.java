package com.yash.SwiggyProject.module;
import java.util.ArrayList;
import java.util.Scanner;
public class Logic {
    private ArrayList<Card> deck;

    private ArrayList<User> users;

    private ArrayList<Card> drawPile;

    private ArrayList<Card> discardPile;


    public void playGame() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of users max 4 and min 2");
        int numOfusers = sc.nextInt();
        if (numOfusers < 2 || numOfusers > 4) {
            throw new Exception("Invalid number of users ... Retry again....");
        }
        deck = new CardDeck().getDeck();

        users = new ArrayList<>();
        for (int i = 1; i <= numOfusers; i++) {
            User p = new User(i);
            for (int j = 1; j <= 5; j++) {
                p.addCard(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
            users.add(p);

        }

        discardPile = new ArrayList<>();
        discardPile.add(deck.get(0));
        deck.remove(0);

        drawPile = new ArrayList<>();
        for (Card c : deck) {
            drawPile.add(c);
        }


        int UserTurn = 0;
        int direction = 1;

        int numCardsTake = 1;

        while (true) {
            if (drawPile.size() < numCardsTake) {
                System.out.println("Game drawn !! ... Cards are less ... !!!");
                break;
            }

            UserTurn %= numOfusers;
            if (UserTurn < 0) UserTurn += numOfusers;
            UserTurn %= numOfusers;

            boolean matched = false;
            int matchedNumber = -1;
            Card topDiscardCard = discardPile.get(discardPile.size() - 1);
            System.out.println("Discard deck top card = " + discardPile.get(discardPile.size() - 1));

            for (Card currentUserCard : users.get(UserTurn).giveCards()) {


                if (currentUserCard.getCardNumber() == topDiscardCard.getCardNumber() || currentUserCard.getSuit() == topDiscardCard.getSuit()) {


                    if (topDiscardCard.getCardNumber() == 1 || topDiscardCard.getCardNumber() == 11 || topDiscardCard.getCardNumber() == 12 || topDiscardCard.getCardNumber() == 13) {
                        if (currentUserCard.getCardNumber() == topDiscardCard.getCardNumber()) // User cannot play same action card even if available so he will skip.
                            continue;
                    }
                    System.out.println("Cards matched for User " + users.get(UserTurn).giveId() + " Card and new Discard Deck top card = " + currentUserCard);

                    if (numCardsTake > 1) {
                        while (numCardsTake-- > 0) {
                            System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                            users.get(UserTurn).addCard(drawPile.get(drawPile.size() - 1));
                            drawPile.remove(drawPile.size() - 1);
                        }
                        numCardsTake = 1;
                    }

                    users.get(UserTurn).removeCard(currentUserCard);
                    discardPile.add(currentUserCard);
                    matched = true;
                    matchedNumber = currentUserCard.getCardNumber();
                    break;
                }
            }

            if (matched == false) {
                System.out.println("No cards match for User " + users.get(UserTurn).giveId() + " Taking " + numCardsTake + " Card(s)");

                while (numCardsTake-- > 0) {
                    System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                    users.get(UserTurn).addCard(drawPile.get(drawPile.size() - 1));
                    drawPile.remove(drawPile.size() - 1);
                }
                numCardsTake = 1;
            }


            if (matched == true && users.get(UserTurn).giveCards().size() == 0) {

                System.out.println("Congratulations User " + users.get(UserTurn).giveId() + " won the match !!!");

                System.exit(0);
            }

            if (matched == true && matchedNumber == 1) {
                UserTurn += direction;
            }

            if (matched == true && matchedNumber == 13) {
                direction *= -1;
            }

            if (matched == true && matchedNumber == 11) {
                numCardsTake = 4;
            }

            if (matched == true && matchedNumber == 12) {
                numCardsTake = 2;
            }
            UserTurn += direction;

            System.out.println("\t\t\t\t\t\t\t\t\t");
        }
    }
}
