package poker;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
public class HandTest {

	Hand hand = new Hand();
	Card card2 = new Card(Rank.TWO,Suit.CLUB);
	Card card5 = new Card(Rank.FIVE,Suit.CLUB);
	Card card4 = new Card(Rank.FOUR,Suit.CLUB);
	Card card11 = new Card(Rank.JACK,Suit.CLUB);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw3() {
		ArrayList<Card> deck3 = new ArrayList<Card>();
		deck3.add(card2);
		deck3.add(card5);
		deck3.add(card4);
		deck3.add(card5);
		hand.drawCard(deck3);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw1() {
		ArrayList<Card> deck1 = new ArrayList<Card>();
		deck1.add(card2);
		deck1.add(card2);
		deck1.add(card2);
		deck1.add(card2);
		deck1.add(card2);
		deck1.add(card5);
		hand.drawCard(deck1);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void test1WrongDraw2() {
		ArrayList<Card> deck2 = new ArrayList<Card>();
		hand.drawCard(deck2);
	}

	@Test
	public void test1RightDraw() {
		System.setOut(new PrintStream(outContent));
		ArrayList<Card> deck3 = new ArrayList<Card>();
		String expected = "HAND: 2C 5C JC JC 2C ";
		deck3.add(card2);
		deck3.add(card5);
		deck3.add(card11);
		deck3.add(card11);
		deck3.add(card2);
		hand.drawCard(deck3);
		assertEquals(deck3.get(0), hand.getCard().get(0));
		assertEquals(deck3.get(1), hand.getCard().get(1));
		assertEquals(deck3.get(2), hand.getCard().get(2));
		hand.printHand();
		assertEquals(expected, outContent.toString());
	}

	@Test
	public void testCompareto() {
		ArrayList<Card> deckTest1 = new ArrayList<Card>();
		deckTest1.add(card5);
		deckTest1.add(card5);
		deckTest1.add(card4);
		deckTest1.add(card11);
		deckTest1.add(card11);
		hand.drawCard(deckTest1);
		assertEquals(card11, hand.maxCard);

		ArrayList<Card> deckTest2 = new ArrayList<Card>();// encore une fois
		deckTest2.add(card2);
		deckTest2.add(card4);
		deckTest2.add(card5);
		deckTest2.add(card5);
		deckTest2.add(card2);
		hand.drawCard(deckTest2);
		assertEquals(card5, hand.maxCard);

	}

}
