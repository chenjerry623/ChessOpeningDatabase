// Citation: referenced and based on the example JsonSerializationDemo provided on edx
package persistence;

import model.Opening;
import model.OpeningValueTester;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends OpeningValueTester {

    @Test
    void testWriterInvalidFile() {
        try {
            List<Opening> testDatabase = new ArrayList<>();
            JsonWriter writer = new JsonWriter("data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            List<Opening> testDatabase = new ArrayList<>();
            JsonWriter writer = new JsonWriter("data/testWriterEmptyDatabase.json");
            writer.open();
            writer.write(testDatabase);
            writer.close();

            JsonReader reader = new JsonReader("data/testWriterEmptyDatabase.json");
            testDatabase = reader.read();
            assertEquals(0, testDatabase.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            List<Opening> testDatabase = new ArrayList<>();
            testDatabase.add(new Opening("test1", 40, 50, 30));
            testDatabase.add(new Opening("test2", 38, 46, 21));
            JsonWriter writer = new JsonWriter("data/testWriterGeneralDatabase.json");
            writer.open();
            writer.write(testDatabase);
            writer.close();

            JsonReader reader = new JsonReader("data/testWriterGeneralDatabase.json");
            testDatabase = reader.read();
            assertEquals(2, testDatabase.size());
            checkOpening(testDatabase.get(0), "test1", 40, 50, 30);
            checkOpening(testDatabase.get(1), "test2", 38, 46, 21);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
