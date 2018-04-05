package poker;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Groupe A
 * @date 2018-3-11
 * Read the cards from stdin, judge,
 * then announce the results.
 */
public class Croupier {
	Scanner cardReader = new Scanner(System.in);
	ArrayList<Card> player1 = new ArrayList<>();
	ArrayList<Card> player2 = new ArrayList<>();
	Hand p1Hand=new Hand();
	Hand p2Hand=new Hand();
	Judge myJudge=new Judge();
	void startGame() {
		System.out.printf("Player1: ");
		player1.addAll(toCards(this.check()));
		System.out.printf("Player2: ");
		player2.addAll(toCards(this.check()));
		cardReader.close();
		p1Hand.drawCard(player1);
		p2Hand.drawCard(player2);
		System.out.println(myJudge.judger(p1Hand, p2Hand));
	}

	private String[] check() {
		String line;
		line = cardReader.nextLine();
		return line.split(" ");
	}

	ArrayList<Card> toCards(String[] allCard) {
		ArrayList<Card> handCard = new ArrayList<>();
		for (String card : allCard) {
			String[] rs = card.split("");
			handCard.add(new Card(this.toRank(rs[0]), this.toSuit(rs[1])));
		}
		return handCard;
	}

	Rank toRank(String name) {
		switch (name) {
		case "2":
			return Rank.TWO;
		case "3":
			return Rank.THREE;
		case "4":
			return Rank.FOUR;
		case "5":
			return Rank.FIVE;
		case "6":
			return Rank.SIX;
		case "7":
			return Rank.SEVEN;
		case "8":
			return Rank.EIGHT;
		case "9":
			return Rank.NINE;
		case "10":
			return Rank.TEN;
		case "J":
			return Rank.JACK;
		case "Q":
			return Rank.QUEEN;
		case "K":
			return Rank.KING;
		case "A":
			return Rank.ACE;
		default:
			throw new RuntimeException("The Rank "+name+" is not valid");
		}
	}

	Suit toSuit(String name) {
		switch (name) {
		case "C":
			return Suit.CLUB;
		case "S":
			return Suit.SPADE;
		case "H":
			return Suit.HEART;
		case "D":
			return Suit.DIAMOND;
		default:
			throw new RuntimeException("The Suit "+name+" is not valid");
		}
	}
}
