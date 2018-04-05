package poker;

/**
 * @author Groupe A
 * @date 2018-2-15
 */
enum Rank {
	TWO("2", 1), THREE("3", 2), FOUR("4", 4), FIVE("5", 8), SIX("6", 16), 
	SEVEN("7", 32), EIGHT("8", 64), NINE("9",128), TEN("10", 256), 
	JACK("J", 512), QUEEN("Q", 1024), KING("K", 2048), ACE("A", 4096);
	
	private String name;
	private int value;

	Rank(String name, int value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return this.name;
	}

	int longValue() {
		return this.value;
	}
	
	int shortValue() {
		return this.ordinal()+2;
	}
}
