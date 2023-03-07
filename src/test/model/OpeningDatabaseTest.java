package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.LeastWinsComparator;
import utility.MostWinsComparator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
