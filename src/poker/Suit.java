package poker;

/**
 * @author Groupe A
 * @date 2018-3-10
 */
public enum Suit {
	CLUB("C"), DIAMOND("D"), HEART("H"), SPADE("S");
	private String name;

	Suit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
