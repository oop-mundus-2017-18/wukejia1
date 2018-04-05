package poker;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
class Card {
	private Rank rank;
	private Suit suit;
	Card(Rank rank,Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	Rank getRank() {
		return this.rank;
	}

	Suit getSuit() {
		return this.suit;
	}
	@Override
	public String toString() {
		return rank+suit.toString();
	}

	public int compareWith(Card card) {
		return this.rank.compareTo(card.rank);
	}
	
	int longValue() {
		return this.getRank().longValue();
	}
	
	int shortValue() {
		return this.getRank().shortValue();
	}
}
