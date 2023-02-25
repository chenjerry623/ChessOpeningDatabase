package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTests {
    private Opening testOpening1;
    private Opening testOpening2;

    private static int TRUE = -1;
    private static int EQUAL = 0;
    private static int FALSE = 1;

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
        testOpening1 = new Opening("Test Opening 1", 70, 40, 90);
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
        int result = lessDraws.compare(testOpening1, testOpening2);
        assertEquals(EQUAL, result);
    }

    @Test
    public void LeastLossesTest() {
        int result = lessLoss.compare(testOpening1, testOpening2);
        assertEquals(TRUE, result);
    }

    @Test
    public void LeastMatchesTest() {
        int result = lessMatch.compare(testOpening1, testOpening2);
        assertEquals(TRUE, result);
    }

    @Test
    public void LeastWinsTest() {
        int result = lessWins.compare(testOpening1, testOpening2);
        assertEquals(FALSE, result);
    }

    @Test
    public void MostDrawsTest() {
        int result = moreDraws.compare(testOpening1, testOpening2);
        assertEquals(EQUAL, result);
    }

    @Test
    public void MostLossesTest() {
        int result = moreLoss.compare(testOpening1, testOpening2);
        assertEquals(FALSE, result);
    }

    @Test
    public void MostMatchesTest() {
        int result = moreMatch.compare(testOpening1, testOpening2);
        assertEquals(FALSE, result);
    }
    @Test
    public void MostWinsTest() {
        int result = moreWins.compare(testOpening1, testOpening2);
        assertEquals(TRUE, result);
    }

}
