package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class OpeningTest extends OpeningValueTester {

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
    public void detailedConstructorTest() {
        Opening testOpening2 = new Opening("SECOND TEST!!", 50, 30, 40);
        assertEquals("SECOND TEST!!", testOpening2.getOpeningName());
        assertEquals(50, testOpening2.getWinCount());
        assertEquals(30, testOpening2.getLossCount());
        assertEquals(40, testOpening2.getDrawCount());
        assertEquals(120, testOpening2.getTotalGames());
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
        assertEquals(20, this.testOpening.getWinCount());
        assertEquals(20, this.testOpening.getTotalGames());
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
        assertEquals(20, this.testOpening.getTotalGames());
        assertEquals(20, this.testOpening.getLossCount());
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
        assertEquals(20, this.testOpening.getTotalGames());
        assertEquals(0, this.testOpening.getLossCount());
        assertEquals(20, this.testOpening.getDrawCount());
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
        this.testOpening.addUserResult(Side.WHITE, Result.LOSS);
        assertEquals(2, this.testOpening.getWinCount());
        assertEquals(4, this.testOpening.getTotalGames());
        assertEquals(1, this.testOpening.getLossCount());
        assertEquals(1, this.testOpening.getDrawCount());
    }

    @Test
    public void displayInfoTest() {
        this.testOpening.displayInfo();
    }

    @Test
    public void convertToArrayTest() {
        Opening testOpening2 = new Opening("test", 50, 30, 40);
        String[] result = {"test", "50", "30", "40"};
        assertEquals(testOpening2.convertToArray()[0],"test");
        assertEquals(testOpening2.convertToArray()[1],"50");
        assertEquals(testOpening2.convertToArray()[2],"30");
        assertEquals(testOpening2.convertToArray()[3],"40");
    }

    @Test
    public void toJsonTest() {
        try {
            testOpening.toJson();
        } catch (Exception e) {
            fail("Something went wrong!");
        }
    }

}