package poker;

import static org.junit.jupiter.api.Assertions.*;
import static poker.Suit.*;

import java.util.ArrayList;

import static poker.Rank.*;
import org.junit.jupiter.api.Test;
/**
 * @author Groupe A
 * @date 2018-3-11
 */
class CroupierTest {
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Croupier croupier=new Croupier();
	@Test
	void testToRank() {
		assertEquals(ACE,croupier.toRank("A"));
		assertEquals(EIGHT,croupier.toRank("8"));
		assertEquals(FIVE,croupier.toRank("5"));
	}
	
	@Test
	void testToSuit() {
		assertEquals(CLUB,croupier.toSuit("C"));
		assertEquals(SPADE,croupier.toSuit("S"));
		assertEquals(HEART,croupier.toSuit("H"));
	}
	
	@Test
	void testToCard() {
		ArrayList<Card> KS_AS_2C= new ArrayList<>();
		KS_AS_2C.add(new Card(KING,SPADE));
		KS_AS_2C.add(new Card(ACE,SPADE));
		KS_AS_2C.add(new Card(TWO,CLUB));
		String[] Ks_As_2c = { "KS", "AS", "2C" };
		for(int i=0;i<3;i++) {
		assertEquals(KS_AS_2C.get(i).getRank(),croupier.toCards(Ks_As_2c).get(i).getRank());
		assertEquals(KS_AS_2C.get(i).getSuit(),croupier.toCards(Ks_As_2c).get(i).getSuit());
		}
	}

}
