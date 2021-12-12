import java.util.*;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;

public class MainApplication {
	public static void main(String[] args) {
		System.out.println("Let's Play Cards!");
		TheTable.PlayCards();
	}
}

class TheTable {

	// CardDeck deck = new CardDeck();
	
	public static void PlayCards() {
		CardDeck.GenerateCardDeck();
		// I now have a card deck

		GamePlayers p = new GamePlayers();
		p.GeneratePlayers();
		// I now have Card Players with Hands of Cards: use the Debugger to verify that you can see this
		
		// my Players have a calcuatel card value Method
		
		// your To Do: For Assignment 8: Is to out WHO the winner player is, based on the cards
		// that the Dealer gave them
		// We will look at additional code formulations later to see how to take and give new cards 
		// in additional rounds of Play
	}
}

class CardDeck {
	public static ArrayList<Card> _cardDeck = new ArrayList<Card>();
	static String[] suites = { "Clubs", "Diamonds", "Hearts", "Spades" };

	public static void GenerateCardDeck() {
		String[] suites;
		int[] cardValue;
		suites = new String[4];
		suites[0] = "Clubs";
		suites[1] = "Diamonds";
		suites[2] = "Hearts";
		suites[3] = "Spades";

		cardValue = new int[13];
		cardValue[0] = 2;
		cardValue[1] = 3;
		cardValue[2] = 4;
		cardValue[3] = 5;
		cardValue[4] = 6;
		cardValue[5] = 7;
		cardValue[6] = 8;
		cardValue[7] = 9;
		cardValue[8] = 10;
		cardValue[9] = 11;
		cardValue[10] = 12;
		cardValue[11] = 13;
		cardValue[12] = 14;

		for (int i = 0; i < suites.length; i++) {
			for (int j = 0; j < cardValue.length; j++) {
				CardDeck._cardDeck.add(new Card(suites[i], cardValue[j]));
			}
		}

		// shuffle the card deck
		Collections.shuffle(CardDeck._cardDeck);
	}
}

class Card {

	private String suite;
	private int suitevalue;
	private int cardvalue;
	// #TODO: Add to the this Class a VALUE Data Attribute
	// set the VALUE of this Card based on Suite and Card Value

	public Card(String _suite, int _cardvalue) {
		this.suite = _suite;
		this.cardvalue = _cardvalue;
	}

	public String toString() {
		return this.suite + " " + this.cardvalue;
	}
}

class GamePlayers {

	public GamePlayers() {

	}

	public static ArrayList<Player> players = new ArrayList<Player>();

	public static void GeneratePlayers() {
		for (int m = 0; m < 4; m++) {
			players.add(new Player("Bill"));
			players.add(new Player("Mary"));
			players.add(new Player("Steve"));
			players.add(new Player("Susan"));
		}
	}

}

class Player {
	public Player(String playerName) {
		PlayerName = playerName;
		setOfCards = new Hand();
		playersCardSet = setOfCards.IssueHand();
	}

	String PlayerName;
	Hand setOfCards;
	Card[] playersCardSet = new Card[5];

	public void CalculateHandValue() {

	}
}

class Hand {
	// the Hand is the cards the player holds

	Card[] PlayersHand = new Card[5];

	public Hand() {

	}

	public Card[] IssueHand() {
		for (int j = 0; j < 5; j++) {
			PlayersHand[j] = (CardDeck._cardDeck).get(j);
		}
		return PlayersHand;
	}

}

