// TODO CITATION

package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends OpeningValueTester {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("data/noSuchFile.json");
        try {
            List<Opening> o = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("data/testReaderEmptyDatabase.json");
        try {
            List<Opening> o = reader.read();
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("data/testReaderGeneralDatabase.json");
        try {
            List<Opening> o = reader.read();
            assertEquals(2, o.size());
            checkOpening(o.get(0), "test one", 70, 48, 29);
            checkOpening(o.get(1), "test 2", 59, 30, 28);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
