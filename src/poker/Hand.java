package poker;

import java.util.ArrayList;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
class Hand {
	ArrayList<Card> cards = new ArrayList<>();
	private static final Card MINICARD = new Card(Rank.TWO,Suit.CLUB);
	private static final int HAND_LIMIT = 5;
	Card maxCard;

	void drawCard(ArrayList<Card> cards) {
		maxCard = MINICARD;
		this.cards.clear();
		if (cards.size() != HAND_LIMIT)
			throw new RuntimeException("The number of the cards is not valid");
		for (int i = 0; i < HAND_LIMIT; i++) {

			this.cards.add(cards.get(i));
		}
		Card mini = MINICARD;
		for (int i = 0; i < HAND_LIMIT; i++) 	
			if (mini.compareWith(this.cards.get(i)) <= 0)
				mini = this.cards.get(i);
		maxCard = mini;
	}

	int compareto(Hand hand) {
		return this.maxCard.compareWith(hand.maxCard);
	}

	/*
	 * Only use for test
	 */
	ArrayList<Card> getCard() {
		return cards;
	}

	void printHand() {
		System.out.print("HAND: ");
		for (int i = 0; i < HAND_LIMIT; i++)
			System.out.print(cards.get(i) + " ");
	}

}
