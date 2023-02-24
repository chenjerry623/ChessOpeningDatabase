package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpeningTest {

    private Opening testOpening;


    @BeforeEach
    public void runBefore() {
        testOpening = new Opening("Test Opening");
    }

    @Test
    public void constructorTest() {
        assertEquals("Test Opening", testOpening.getOpeningName());
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
        assertEquals(0, this.testOpening.getTotalGames());
    }

    @Test
    public void setWinTest() {
        this.testOpening.setWinCount(50);
        assertEquals(50, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
    }

    @Test
    public void setWinTestMultiple() {
        this.testOpening.setWinCount(50);
        assertEquals(50, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
        this.testOpening.setWinCount(20);
        assertEquals(70, this.testOpening.getWinCount());
        assertEquals(70, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
    }

    @Test
    public void setLossTest() {
        this.testOpening.setLossCount(50);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(50, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
    }

    @Test
    public void setLossTestMultiple() {
        this.testOpening.setLossCount(50);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(50, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
        this.testOpening.setLossCount(20);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(70, this.testOpening.getTotalGames());
        assertEquals(70, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
    }

    @Test
    public void setDrawTest() {
        this.testOpening.setDrawCount(50);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(50, this.testOpening.getDrawCount());
    }

    @Test
    public void setDrawTestMultiple() {
        this.testOpening.setDrawCount(50);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(50, this.testOpening.getDrawCount());
        this.testOpening.setDrawCount(20);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(70, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(70, this.testOpening.getDrawCount());
    }

    @Test
    public void setAllTest() {
        this.testOpening.setDrawCount(50);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(50, this.testOpening.getDrawCount());
        this.testOpening.setLossCount(20);
        assertEquals(0, this.testOpening.getWinCount());
        assertEquals(70, this.testOpening.getTotalGames());
        assertEquals(20, this.testOpening.getLossCount());
        assertEquals(50, this.testOpening.getDrawCount());
        this.testOpening.setWinCount(30);
        assertEquals(30, this.testOpening.getWinCount());
        assertEquals(100, this.testOpening.getTotalGames());
        assertEquals(20, this.testOpening.getLossCount());
        assertEquals(50, this.testOpening.getDrawCount());
        this.testOpening.setDrawCount(10);
        assertEquals(30, this.testOpening.getWinCount());
        assertEquals(60, this.testOpening.getTotalGames());
        assertEquals(20, this.testOpening.getLossCount());
        assertEquals(10, this.testOpening.getDrawCount());
        this.testOpening.setLossCount(10);
        assertEquals(30, this.testOpening.getWinCount());
        assertEquals(50, this.testOpening.getTotalGames());
        assertEquals(10, this.testOpening.getLossCount());
        assertEquals(10, this.testOpening.getDrawCount());
        this.testOpening.setWinCount(20);
        assertEquals(20, this.testOpening.getWinCount());
        assertEquals(40, this.testOpening.getTotalGames());
        assertEquals(10, this.testOpening.getLossCount());
        assertEquals(10, this.testOpening.getDrawCount());
    }

    @Test
    public void addResultTest() {
        this.testOpening.addUserResult(Side.WHITE, Result.WIN);
        assertEquals(1, this.testOpening.getWinCount());
        assertEquals(1, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
        this.testOpening.addUserResult(Side.WHITE, Result.WIN);
        assertEquals(2, this.testOpening.getWinCount());
        assertEquals(2, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(0, this.testOpening.getDrawCount());
        this.testOpening.addUserResult(Side.WHITE, Result.DRAW);
        assertEquals(2, this.testOpening.getWinCount());
        assertEquals(3, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(1, this.testOpening.getDrawCount());
        this.testOpening.addUserResult(Side.WHITE, Result.DRAW);
        assertEquals(2, this.testOpening.getWinCount());
        assertEquals(4, this.testOpening.getTotalGames());
        assertEquals(1, this.testOpening.getLossCount());
        assertEquals(1, this.testOpening.getDrawCount());
    }

}