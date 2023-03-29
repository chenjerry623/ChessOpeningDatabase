package persistence;

import org.json.JSONObject;

// Interface for objects which can be converted into a JSON object
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
