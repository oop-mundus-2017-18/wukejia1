package poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Groupe A
 * @date 2018-2-19
 */
class CardTest {

	@Test
	void createAndTest() {

		Card r5Card = new Card(Rank.FIVE,Suit.CLUB);
		assertEquals(Rank.FIVE, r5Card.getRank());
		assertTrue(r5Card.toString().equals("5C"));
		Card r3Card = new Card(Rank.THREE,Suit.CLUB);
		assertEquals(0, r5Card.compareWith(r5Card));
		assertTrue(r5Card.compareWith(r3Card) > 0);

	}
}
