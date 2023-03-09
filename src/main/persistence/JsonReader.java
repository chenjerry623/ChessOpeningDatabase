// Citation: referenced and based on the example JsonSerializationDemo provided on edx


package persistence;

import model.Opening;
import model.OpeningDatabase;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public OpeningDatabase read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseOpeningList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private OpeningDatabase parseOpeningList(JSONObject jsonObject) {
        OpeningDatabase openings = new OpeningDatabase();
        addOpenings(openings, jsonObject);
        return openings;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addOpenings(OpeningDatabase openings, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("openings");
        for (Object json : jsonArray) {
            JSONObject nextOpening = (JSONObject) json;
            addNewOpening(openings, nextOpening);
        }

    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addNewOpening(OpeningDatabase openings, JSONObject jsonObject) {
        String name = jsonObject.getString("opening name");
        int wins = jsonObject.getInt("wins");
        int draws = jsonObject.getInt("draws");
        int losses = jsonObject.getInt("losses");
        Opening newOpening = new Opening(name, wins, losses, draws);
        openings.addOpening(newOpening);
    }
}
