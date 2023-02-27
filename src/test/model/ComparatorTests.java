package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTests {
    private Opening testOpening1;
    private Opening testOpening2;

    private static final int TRUE = -1;
    private static final int EQUAL = 0;
    private static final int FALSE = 1;

    private LeastDrawsComparator lessDraws;
    private LeastLossesComparator lessLoss;
    private LeastMatchesComparator lessMatch;
    private LeastWinsComparator lessWins;
    private MostDrawsComparator moreDraws;
    private MostLossesComparator moreLoss;
    private MostMatchesComparator moreMatch;
    private MostWinsComparator moreWins;

    @BeforeEach
    public void runBefore() {
        testOpening1 = new Opening("Test Opening 1", 50, 40, 80);
        testOpening2 = new Opening("Test Opening 2", 60, 90, 90);
        lessDraws = new LeastDrawsComparator();
        lessLoss = new LeastLossesComparator();
        lessMatch = new LeastMatchesComparator();
        lessWins = new LeastWinsComparator();
        moreDraws = new MostDrawsComparator();
        moreLoss = new MostLossesComparator();
        moreMatch = new MostMatchesComparator();
        moreWins = new MostWinsComparator();
    }

    @Test
    public void LeastDrawsTest() {
        int equalResult = lessDraws.compare(testOpening1, testOpening1);
        int trueResult = lessDraws.compare(testOpening1, testOpening2);
        int falseResult = lessDraws.compare(testOpening2, testOpening1);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

    @Test
    public void LeastLossesTest() {
        int equalResult = lessLoss.compare(testOpening1, testOpening1);
        int trueResult = lessLoss.compare(testOpening1, testOpening2);
        int falseResult = lessLoss.compare(testOpening2, testOpening1);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

    @Test
    public void LeastMatchesTest() {
        int equalResult = lessMatch.compare(testOpening1, testOpening1);
        int trueResult = lessMatch.compare(testOpening1, testOpening2);
        int falseResult = lessMatch.compare(testOpening2, testOpening1);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

    @Test
    public void LeastWinsTest() {
        int equalResult = lessWins.compare(testOpening1, testOpening1);
        int trueResult = lessWins.compare(testOpening1, testOpening2);
        int falseResult = lessWins.compare(testOpening2, testOpening1);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

    @Test
    public void MostDrawsTest() {
        int equalResult = moreDraws.compare(testOpening1, testOpening1);
        int trueResult = moreDraws.compare(testOpening2, testOpening1);
        int falseResult = moreDraws.compare(testOpening1, testOpening2);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

    @Test
    public void MostLossesTest() {
        int equalResult = moreLoss.compare(testOpening1, testOpening1);
        int trueResult = moreLoss.compare(testOpening2, testOpening1);
        int falseResult = moreLoss.compare(testOpening1, testOpening2);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

    @Test
    public void MostMatchesTest() {
        int equalResult = moreMatch.compare(testOpening1, testOpening1);
        int trueResult = moreMatch.compare(testOpening2, testOpening1);
        int falseResult = moreMatch.compare(testOpening1, testOpening2);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }
    @Test
    public void MostWinsTest() {
        int equalResult = moreWins.compare(testOpening1, testOpening1);
        int trueResult = moreWins.compare(testOpening2, testOpening1);
        int falseResult = moreWins.compare(testOpening1, testOpening2);
        assertEquals(EQUAL, equalResult);
        assertEquals(TRUE, trueResult);
        assertEquals(FALSE, falseResult);
    }

}
