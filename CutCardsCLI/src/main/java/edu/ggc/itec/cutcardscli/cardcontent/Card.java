package edu.ggc.itec.cutcardscli.cardcontent;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

// images from: https://code.google.com/archive/p/vector-playing-cards/
// background: https://pixabay.com/photos/leaf-clover-green-shamrock-spring-1482948

//deck from: https://www.flickr.com/photos/167981955@N07/albums/72157703569389721

//public record Card(CardValue cardValue, Suit suit) {};

// use class below for jdk < 16
public class Card implements Comparable<Card> {

    public static final String IMGS_PREFIX = "file:images/cards/";
    private Suit suit;
    private CardValue cardValue;
    private Image image;
    public Color color;


    public Card(CardValue cardValue, Color color){ // only used for Jokers
        this.cardValue = cardValue;
        this.suit = null;
        this.color = color;

        if (cardValue.toString().equals("JOKER")) {
            String fName = IMGS_PREFIX + (color == Color.RED ? "red_joker.jpg" : "black_joker.jpg");
            this.image = new Image(fName);
            return;
        }
    }

    public Card(CardValue cardValue, Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
        color = (this.suit == Suit.SPADES || this.suit == Suit.CLUBS) ?
                Color.BLACK : Color.RED;

        String suffix = ".jpg"; //was ".png"
        String rank; // i.e. "QUEEN" becomes "queen"
        if (cardValue.getCardValue() <= 10) {
            rank = String.valueOf(cardValue.getCardValue()); // i.e. "TWO" becomes "2"
        } else if (cardValue.getCardValue() > 10 && cardValue.getCardValue() < 14) { // face cards only
            rank = cardValue().toString().toLowerCase();
            suffix = "2.jpg"; // this suffix used to render richer images on face cards (was "2.png")
        } else { // Aces only
            rank = cardValue().toString().toLowerCase();
        }

        String lcSuit = suit().toString().toLowerCase(); // "HEARTS" becomes "hearts"
        image = new Image(IMGS_PREFIX + rank + "_of_" + lcSuit + suffix);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(cardValue.toString());
        if (cardValue == CardValue.JOKER)
            b.append(", color=" + ((color == Color.BLACK) ? "BLACK" : "RED"));
        else
            b.append((cardValue != CardValue.JOKER) ? (" of " + suit) : "");
        return b.toString();
    }

    public Suit suit() {return suit;}
    public CardValue cardValue() {return cardValue;}
    public Image image() {return image;}


    @Override
    public int compareTo(Card other) {
        int result = 0; // assumes they are equal
        if (cardValue.getCardValue() > other.cardValue.getCardValue()) // I'm bigger!
            result = 1;
        else if (cardValue.getCardValue() < other.cardValue.getCardValue()) // other's bigger
            result = -1;
        return result;
    }
}