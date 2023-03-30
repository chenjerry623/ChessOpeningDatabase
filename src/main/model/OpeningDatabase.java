package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// class for storing the user's opening database
public class OpeningDatabase implements Constants {

    private List<Opening> openings; // current opening database

    // MODIFIES: this
    // EFFECTS: initializes a new arraylist to store openings
    public OpeningDatabase() {
        openings = new ArrayList<>();
    }


    // EFFECTS: prints out all the values in the database
    public void printOpenings() {
        for (Opening o : openings) {
            final String indexStr = String.format(INDEX_LENGTH, openings.indexOf(o));
            final String nameStr = String.format(NAME_LENGTH, o.getOpeningName());
            final String winStr = String.format(RESULTS_LENGTH, o.getWinCount());
            final String lossStr = String.format(RESULTS_LENGTH, o.getLossCount());
            final String drawStr = String.format(RESULTS_LENGTH, o.getDrawCount());
            final String totalStr = String.format(RESULTS_LENGTH, o.getTotalGames());
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

    // EFFECTS: returns array of openings
    public List<Opening> getOpenings() {
        return this.openings;
    }

    // MODIFIES: this
    // EFFECTS: sorts the opening by criteria
    public void sortOpenings(Comparator<Opening> c) {
        openings.sort(c);
    }

    public String[][] convertToArray() {
        String[][] result = new String[openings.size()][4];
        for (int i = 0; i < openings.size(); i++) {
            result[i][0] = openings.get(i).convertToArray()[0];
            result[i][1] = openings.get(i).convertToArray()[1];
            result[i][2] = openings.get(i).convertToArray()[2];
            result[i][3] = openings.get(i).convertToArray()[3];
        }
        return result;
    }

    // MODIFIES: this
    // EFFECTS: adds new opening
    public void addOpening(Opening o) {
        openings.add(o);
    }

    // MODIFIES: this
    // EFFECTS: removes the selected opening
    public void deleteOpening(int index) {
        openings.remove(index);
    }

}
