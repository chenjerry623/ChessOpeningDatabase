package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// TODO add tests, add name
// class for storing the user's opening database
public class OpeningDatabase implements Constants {

    private List<Opening> openings; // current opening database

    // MODIFIES: this
    // EFFECTS: initializes a new arraylist to store openings
    public OpeningDatabase() {
        openings = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds opening to the database
    public void add(Opening o) {
        openings.add(o);
    }

    // EFFECTS: prints out all of the values in the database
    public void printOpenings() {
        for (Opening o : openings) {
            String indexStr = String.format(INDEX_LENGTH, openings.indexOf(o));
            String nameStr = String.format(NAME_LENGTH, o.getOpeningName());
            String winStr = String.format(RESULTS_LENGTH, o.getWinCount());
            String lossStr = String.format(RESULTS_LENGTH, o.getLossCount());
            String drawStr = String.format(RESULTS_LENGTH, o.getDrawCount());
            String totalStr = String.format(RESULTS_LENGTH, o.getTotalGames());
            System.out.println(indexStr + nameStr + winStr + lossStr + drawStr + totalStr);
        }
    }

    // EFFECTS: returns the size of the database
    public int getSize() {
        return openings.size();
    }

    // EFFECTS: finds an opening based on an index
    public Opening getOpening(int index) {
        return openings.get(index);
    }

    // MODIFIES: this
    // EFFECTS: sorts the opening by criteria
    public void sortOpenings(Comparator<Opening> c) {
        openings.sort(c);
    }

    // MODIFIES: this
    // EFFECTS: adds new opening
    public void addOpening(Opening o) {
        openings.add(o);
    }

}
