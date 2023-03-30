package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.LeastWinsComparator;
import utility.MostWinsComparator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OpeningDatabaseTest implements Constants {

    OpeningDatabase testDatabase;
    Opening testOpening1;
    Opening testOpening2;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void runBefore() {
        testDatabase = new OpeningDatabase();
        testOpening1 = new Opening("test 1", 50, 40, 30);
        testOpening2 = new Opening("test 2", 345, 43, 65);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void addGetSizeTest() {
        assertEquals(0, testDatabase.getSize());
        testDatabase.addOpening(new Opening("test1"));
        assertEquals(1, testDatabase.getSize());
        testDatabase.addOpening(new Opening("test2"));
        assertEquals(2, testDatabase.getSize());
    }

    @Test
    public void printOpeningsTest() {
        testDatabase.printOpenings();
        assertEquals("", outputStreamCaptor.toString().trim());
        testDatabase.addOpening(testOpening1);
        String indexStr = String.format(INDEX_LENGTH, 0);
        String nameStr = String.format(NAME_LENGTH, "test 1");
        String winStr = String.format(RESULTS_LENGTH, 50);
        String lossStr = String.format(RESULTS_LENGTH, 40);
        String drawStr = String.format(RESULTS_LENGTH, 30);
        String totalStr = String.format(RESULTS_LENGTH, 120);
        testDatabase.printOpenings();
        assertEquals(indexStr + nameStr + winStr + lossStr + drawStr + totalStr + "\r\n", outputStreamCaptor.toString());
    }

    @Test
    public void getOpeningTest() {
        testDatabase.addOpening(testOpening1);
        assertEquals(testOpening1, testDatabase.getOpening(0));
        testDatabase.addOpening(testOpening2);
        assertEquals(testOpening1, testDatabase.getOpening(0));
        assertEquals(testOpening2, testDatabase.getOpening(1));
    }

    @Test
    public void sortOpeningTest() {
        testDatabase.addOpening(testOpening1);
        testDatabase.addOpening(testOpening2);
        testDatabase.sortOpenings(new MostWinsComparator());
        assertEquals(testOpening2, testDatabase.getOpening(0));
        assertEquals(testOpening1, testDatabase.getOpening(1));
        testDatabase.sortOpenings(new LeastWinsComparator());
        assertEquals(testOpening2, testDatabase.getOpening(1));
        assertEquals(testOpening1, testDatabase.getOpening(0));
    }

    @Test
    public void deleteOpeningTest() {
        testDatabase.addOpening(testOpening1);
        testDatabase.deleteOpening(0);
        assertEquals(0,testDatabase.getSize());
        assertFalse(testDatabase.getOpenings().contains(testOpening1));
    }

    @Test
    public void convertToArrayTest() {
        testDatabase.addOpening(testOpening1);
        testDatabase.addOpening(testOpening2);
        String[] result = {"test 1", "50", "40", "30"};
        String[] result2 = {"test 2", "345", "43", "65"};
        String[][] results = {result, result2};
        assertEquals(testDatabase.convertToArray()[0][0],"test 1");
        assertEquals(testDatabase.convertToArray()[0][1],"50");
        assertEquals(testDatabase.convertToArray()[0][2],"40");
        assertEquals(testDatabase.convertToArray()[0][3],"30");
        assertEquals(testDatabase.convertToArray()[1][0],"test 2");
        assertEquals(testDatabase.convertToArray()[1][1],"345");
        assertEquals(testDatabase.convertToArray()[1][2],"43");
        assertEquals(testDatabase.convertToArray()[1][3],"65");
    }
}
