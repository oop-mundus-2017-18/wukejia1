package poker;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import hashmap.Card;

import static poker.Rank.*;
import static poker.Suit.*;

/**
 * @author Groupe A
 * @date 2018-3-14
 */

class JudgeTest {
    Judge testJudge = new Judge();
    Hand hand = new Hand();
    static HashMap<Suit, HashMap<Rank, Card>> myCards = new HashMap<>();

    Card getCard(Rank rank, Suit suit) {
        return myCards.get(suit).get(rank);
    }

    ArrayList<Card> toCardList(Rank rank1, Suit suit1, Rank rank2, Suit suit2, Rank rank3, Suit suit3, Rank rank4,
            Suit suit4, Rank rank5, Suit suit5) {

        ArrayList<Card> mylist = new ArrayList<>();
        mylist.add(new Card(rank1, suit1));
        mylist.add(new Card(rank2, suit2));
        mylist.add(new Card(rank3, suit3));
        mylist.add(new Card(rank4, suit4));
        mylist.add(new Card(rank5, suit5));
        return mylist;

    }

    @BeforeAll
    static void initialCard() {
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values()) {
                HashMap<Rank, Card> keyRank = new HashMap<>();
                keyRank.put(rank, new Card(rank, suit));
                myCards.put(suit, keyRank);
            }

    }

    @Test
    void testJudger() {
        ArrayList<Card> cAC_QD_8S_7S_3D = new ArrayList<>();
        cAC_QD_8S_7S_3D = toCardList(ACE, CLUB, QUEEN, DIAMOND, EIGHT, SPADE, SEVEN, SPADE, THREE, DIAMOND);
        ArrayList<Card> cAD_QS_8D_7C_3H = new ArrayList<>();
        cAD_QS_8D_7C_3H = toCardList(ACE, DIAMOND, QUEEN, SPADE, EIGHT, DIAMOND, SEVEN, CLUB, THREE, HEART);
        ArrayList<Card> cKS_QH_10D_5H_2S = new ArrayList<>();
        cKS_QH_10D_5H_2S = toCardList(KING, SPADE, QUEEN, HEART, TEN, DIAMOND, FIVE, HEART, TWO, SPADE);
        ArrayList<Card> cKD_QC_JH_9D_7H = new ArrayList<>();
        cKD_QC_JH_9D_7H = toCardList(KING, DIAMOND, QUEEN, CLUB, JACK, HEART, NINE, DIAMOND, SEVEN, HEART);
        Hand hAC_QD_8S_7S_3D = new Hand();
        Hand hAD_QS_8D_7C_3H = new Hand();
        Hand hKS_QH_10D_5H_2S = new Hand();
        Hand hKD_QC_JH_9D_7H = new Hand();
        hAC_QD_8S_7S_3D.drawCard(cAC_QD_8S_7S_3D);
        hAD_QS_8D_7C_3H.drawCard(cAD_QS_8D_7C_3H);
        hKS_QH_10D_5H_2S.drawCard(cKS_QH_10D_5H_2S);
        hKD_QC_JH_9D_7H.drawCard(cKD_QC_JH_9D_7H);
        assertEquals("tie",testJudge.judger(hAC_QD_8S_7S_3D,hAD_QS_8D_7C_3H));
        assertEquals("player2 win! High Card : KD",testJudge.judger(hKS_QH_10D_5H_2S,hKD_QC_JH_9D_7H));
        
        
    }
    

    @Test
    void testPaireD() {
        ArrayList<Card> c9C_9D_KD_QS_JH = new ArrayList<>();
        c9C_9D_KD_QS_JH = toCardList(NINE, CLUB, NINE, DIAMOND, KING, DIAMOND, QUEEN, SPADE, JACK, HEART);
        ArrayList<Card> c9H_9S_KC_QD_JC = new ArrayList<>();
        c9H_9S_KC_QD_JC = toCardList(NINE, HEART, NINE, SPADE, KING, CLUB, QUEEN, DIAMOND, JACK, CLUB);
        ArrayList<Card> c9C_9D_10H_5H_4S = new ArrayList<>();
        c9C_9D_10H_5H_4S = toCardList(NINE, CLUB, NINE, DIAMOND, TEN, HEART, FIVE, HEART, FOUR, SPADE);
        ArrayList<Card> c9H_9S_10C_8H_4D = new ArrayList<>();
        c9H_9S_10C_8H_4D = toCardList(NINE, HEART, NINE, SPADE, TEN, CLUB, EIGHT, HEART, FOUR, DIAMOND);
        ArrayList<Card> c8C_8D_KD_QS_3H = new ArrayList<>();
        c8C_8D_KD_QS_3H = toCardList(EIGHT, CLUB, EIGHT, DIAMOND, KING, DIAMOND, QUEEN, SPADE, THREE, HEART);
        ArrayList<Card> cJH_JS_KS_QH_3D = new ArrayList<>();
        cJH_JS_KS_QH_3D = toCardList(JACK, HEART, JACK, SPADE, KING, SPADE, QUEEN, HEART, THREE, DIAMOND);
        assertTrue(testJudge.paireDetector(c9C_9D_KD_QS_JH) == testJudge.paireDetector(c9H_9S_KC_QD_JC));
        assertTrue(testJudge.paireDetector(c9C_9D_10H_5H_4S) < testJudge.paireDetector(c9H_9S_10C_8H_4D));
        assertTrue(testJudge.paireDetector(c8C_8D_KD_QS_3H) < testJudge.paireDetector(cJH_JS_KS_QH_3D));

    }

    @Test
    void testBrelanPaireD() {

    }

    @Test
    void paire2D() {
        ArrayList<Card> cAS_AD_KH_KC_QC = new ArrayList<>();
        cAS_AD_KH_KC_QC = toCardList(ACE, SPADE, ACE, DIAMOND, KING, HEART, KING, CLUB, QUEEN, CLUB);
        ArrayList<Card> cAH_AC_KS_KD_QD = new ArrayList<>();
        cAH_AC_KS_KD_QD = toCardList(ACE, HEART, ACE, CLUB, KING, SPADE, KING, DIAMOND, QUEEN, DIAMOND);
        ArrayList<Card> cAS_AD_KH_KC_10H = new ArrayList<>();
        cAS_AD_KH_KC_10H = toCardList(ACE, SPADE, ACE, DIAMOND, KING, HEART, KING, CLUB, TEN, HEART);
        ArrayList<Card> cAH_AC_KS_KD_9H = new ArrayList<>();
        cAH_AC_KS_KD_9H = toCardList(ACE, HEART, ACE, CLUB, KING, SPADE, KING, DIAMOND, NINE, HEART);
        ArrayList<Card> c10S_10D_7H_7C_3H = new ArrayList<>();
        c10S_10D_7H_7C_3H = toCardList(TEN, SPADE, TEN, DIAMOND, SEVEN, HEART, SEVEN, CLUB, THREE, HEART);
        ArrayList<Card> c10H_10C_8D_8S_3D = new ArrayList<>();
        c10H_10C_8D_8S_3D = toCardList(TEN, HEART, TEN, CLUB, EIGHT, DIAMOND, EIGHT, SPADE, THREE, DIAMOND);
        ArrayList<Card> c6S_6D_2H_2C_AC = new ArrayList<>();
        c6S_6D_2H_2C_AC = toCardList(SIX, SPADE, SIX, DIAMOND, TWO, HEART, TWO, CLUB, ACE, CLUB);
        ArrayList<Card> c5C_5D_4C_4H_AH = new ArrayList<>();
        c5C_5D_4C_4H_AH = toCardList(FIVE, CLUB, FIVE, DIAMOND, FOUR, CLUB, FOUR, HEART, ACE, HEART);
        assertTrue(testJudge.paire2Detector(cAS_AD_KH_KC_QC) == testJudge.paire2Detector(cAH_AC_KS_KD_QD));
        assertTrue(testJudge.paire2Detector(cAS_AD_KH_KC_10H) > testJudge.paire2Detector(cAH_AC_KS_KD_9H));
        assertTrue(testJudge.paire2Detector(c10S_10D_7H_7C_3H) < testJudge.paire2Detector(c10H_10C_8D_8S_3D));
        assertTrue(testJudge.paire2Detector(c6S_6D_2H_2C_AC) > testJudge.paire2Detector(c5C_5D_4C_4H_AH));
        

    }

    @Test
    void testCarreD() {

    }

    @Test
    void testSuiteD() {
        ArrayList<Card> cAS_KD_QC_JC_10S = new ArrayList<>();
        cAS_KD_QC_JC_10S = toCardList(ACE, SPADE, KING, DIAMOND, QUEEN, CLUB, JACK, CLUB, TEN, SPADE);
        ArrayList<Card> cAC_KH_QD_JS_10C = new ArrayList<>();
        cAC_KH_QD_JS_10C = toCardList(ACE, CLUB, KING, HEART, QUEEN, DIAMOND, JACK, SPADE, TEN, CLUB);
        ArrayList<Card> c8C_7D_6S_5D_4C = new ArrayList<>();
        c8C_7D_6S_5D_4C = toCardList(EIGHT, CLUB, SEVEN, DIAMOND, SIX, SPADE, FIVE, DIAMOND, FOUR, CLUB);
        ArrayList<Card> cQD_JS_10C_9C_8H = new ArrayList<>();
        cQD_JS_10C_9C_8H = toCardList(QUEEN, DIAMOND, JACK, SPADE, TEN, CLUB, NINE, CLUB, EIGHT, HEART);
        assertTrue(testJudge.suiteDetector(cAS_KD_QC_JC_10S) == testJudge.suiteDetector(cAC_KH_QD_JS_10C));
        assertTrue(testJudge.suiteDetector(c8C_7D_6S_5D_4C) < testJudge.suiteDetector(cQD_JS_10C_9C_8H));

    }

    @Test
    void testfullD() {
        ArrayList<Card> c3H_3D_3S_AD_AC = new ArrayList<>();
        c3H_3D_3S_AD_AC = toCardList(THREE, HEART, THREE, DIAMOND, THREE, SPADE, ACE, DIAMOND, ACE, CLUB);
        ArrayList<Card> c4D_4S_4C_5D_5C = new ArrayList<>();
        c4D_4S_4C_5D_5C = toCardList(FOUR, DIAMOND, FOUR, CLUB, FOUR, CLUB, FIVE, DIAMOND, FIVE, CLUB);
        ArrayList<Card> c7H_7D_7S_KD_KH = new ArrayList<>();
        c7H_7D_7S_KD_KH = toCardList(SEVEN, HEART, SEVEN, DIAMOND, SEVEN, SPADE, KING, DIAMOND, KING, HEART);
        ArrayList<Card> cQH_QD_QS_KS_KC = new ArrayList<>();
        cQH_QD_QS_KS_KC = toCardList(QUEEN, HEART, QUEEN, DIAMOND, QUEEN, SPADE, KING, SPADE, KING, CLUB);
        assertTrue(testJudge.fullDetector(c3H_3D_3S_AD_AC) < testJudge.fullDetector(c4D_4S_4C_5D_5C));
        assertTrue(testJudge.fullDetector(c7H_7D_7S_KD_KH) < testJudge.fullDetector(cQH_QD_QS_KS_KC));
    }

    @Test
    void testColorD() {
        ArrayList<Card> cAC_10C_9C_7C_3C = new ArrayList<>();
        cAC_10C_9C_7C_3C = toCardList(ACE, CLUB, TEN, CLUB, NINE, CLUB, SEVEN, CLUB, THREE, CLUB);
        ArrayList<Card> cAD_10D_9D_7D_3D = new ArrayList<>();
        cAD_10D_9D_7D_3D = toCardList(ACE, DIAMOND, TEN, DIAMOND, NINE, DIAMOND, SEVEN, DIAMOND, THREE, DIAMOND);
        ArrayList<Card> cQC_JC_7C_4C_3C = new ArrayList<>();
        cQC_JC_7C_4C_3C = toCardList(QUEEN, CLUB, JACK, CLUB, SEVEN, CLUB, FOUR, CLUB, THREE, CLUB);
        ArrayList<Card> cQD_10D_7D_4D_3D = new ArrayList<>();
        cQD_10D_7D_4D_3D = toCardList(QUEEN, DIAMOND, TEN, DIAMOND, SEVEN, DIAMOND, FOUR, DIAMOND, THREE, DIAMOND);
        ArrayList<Card> cAS_9S_8S_4S_3S = new ArrayList<>();
        cAS_9S_8S_4S_3S = toCardList(ACE, SPADE, NINE, SPADE, EIGHT, SPADE, FOUR, SPADE, THREE, SPADE);
        ArrayList<Card> cKH_JH_10H_7H_6H = new ArrayList<>();
        cKH_JH_10H_7H_6H = toCardList(KING, HEART, JACK, HEART, TEN, HEART, SEVEN, HEART, SIX, HEART);
        assertTrue(testJudge.colorDetector(cAC_10C_9C_7C_3C) == testJudge.colorDetector(cAD_10D_9D_7D_3D));
        assertTrue(testJudge.colorDetector(cQC_JC_7C_4C_3C) > testJudge.colorDetector(cQD_10D_7D_4D_3D));
        assertTrue(testJudge.colorDetector(cAS_9S_8S_4S_3S) > testJudge.colorDetector(cKH_JH_10H_7H_6H));
    }

    @Test
    void testqfD() {

    }

    @Test
    void testBrelan() {
        ArrayList<Card> c2H_2C_2D_AH_KD = new ArrayList<>();
        c2H_2C_2D_AH_KD = toCardList(TWO, HEART, TWO, CLUB, TWO, DIAMOND, ACE, HEART, KING, DIAMOND);
        ArrayList<Card> c3C_3H_3S_AD_KC = new ArrayList<>();
        c3C_3H_3S_AD_KC = toCardList(THREE, CLUB, THREE, HEART, THREE, SPADE, ACE, DIAMOND, KING, CLUB);
        ArrayList<Card> cKC_KD_KH_3C_8D = new ArrayList<>();
        cKC_KD_KH_3C_8D = toCardList(KING, CLUB, KING, DIAMOND, KING, HEART, THREE, CLUB, EIGHT, DIAMOND);
        ArrayList<Card> cJD_JC_JS_AC_2H = new ArrayList<>();
        cJD_JC_JS_AC_2H = toCardList(JACK, DIAMOND, JACK, CLUB, JACK, SPADE, ACE, CLUB, TWO, HEART);
        assertTrue(testJudge.brelanDetector(c2H_2C_2D_AH_KD) < testJudge.brelanDetector(c3C_3H_3S_AD_KC));
        assertTrue(testJudge.brelanDetector(cKC_KD_KH_3C_8D) > testJudge.brelanDetector(cJD_JC_JS_AC_2H));

    }

}
