package model;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpeningValueTester {
    protected void checkOpening(Opening o, String name, int wins, int losses, int draws) {
        assertEquals(name, o.getOpeningName());
        assertEquals(wins, o.getWinCount());
        assertEquals(losses, o.getLossCount());
        assertEquals(draws, o.getDrawCount());
    }
}
