package model;

import org.json.JSONObject;
import persistence.Writable;

// represents a single chess opening, with info on the name, win/loss/draws, memorization, tendencies and lines
public class Opening implements Writable, Constants {

    // LAST FILE VERSION WITH OPTIONAL VARIABLES

    private final String openingName;         // the name of the opening

    private int winCount;               // user's total amount of wins with the opening
    private int lossCount;              // user's total amount of losses with the opening
    private int drawCount;              // user's total amount of draws

    // REQUIRES: name has a non-zero length
    // EFFECTS: openingName is set to name, every other variable is set to 0
    public Opening(String name) {
        this.openingName = name;
        this.winCount = 0;
        this.lossCount = 0;
        this.drawCount = 0;
    }

    // REQUIRES: name has a non-zero length; wins, losses and draws must be >= 0
    // EFFECTS: openingName set to name; win/loss/draw parameters set according to inputs
    public Opening(String name, int wins, int losses, int draws) {
        this.openingName = name;
        this.winCount = wins;
        this.lossCount = losses;
        this.drawCount = draws;
    }

    // GETTERS:

    public Integer getWinCount() {
        return winCount;
    }

    public Integer getLossCount() {
        return lossCount;
    }

    public Integer getDrawCount() {
        return drawCount;
    }

    // EFFECTS: returns the sum of the win, loss and draw count. Returns as a long in case of max int size
    public Long getTotalGames() {
        long longWins = winCount;
        long longLosses = lossCount;
        long longDraws = drawCount;

        return longWins + longLosses + longDraws;
    }

    public String getOpeningName() {
        return this.openingName;
    }

    // SETTERS

    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the win count to count, adds (winCount - count) to total win count
    public void setWinCount(int count) {
        this.winCount = count;
    }

    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the loss count to count, adds (winCount - count) to total loss count
    public void setLossCount(int count) {
        this.lossCount = count;
    }

    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the loss count to count, adds (winCount - count) to total loss count
    public void setDrawCount(int count) {
        this.drawCount = count;
    }

    // EFFECTS: displays information about this opening
    public void displayInfo() {
        System.out.println("\\\\\\\\\\\\\\\\ " + openingName + " ////////");
        System.out.println("================================================================");
        System.out.println("Wins:          " + winCount);
        System.out.println("Draws:         " + drawCount);
        System.out.println("Losses:        " + winCount);
        System.out.println("Total Matches: " + this.getTotalGames());
    }


    // FUNCTION METHODS:

    // note: the side parameter isn't currently used, but will be kept in case it's implemented later

    // REQUIRES: side is either WHITE or BLACK, result is either WIN, LOSS or DRAW
    // MODIFIES: this
    // EFFECTS: adds a win/loss to the opening
    public void addUserResult(Side side, Result result) {
        if (result == Result.WIN) {
            winCount++;
            EventLog.getInstance().logEvent(new Event("Win added to " + this.getOpeningName()));
        } else if (result == Result.DRAW) {
            drawCount++;
            EventLog.getInstance().logEvent(new Event("Draw added to " + this.getOpeningName()));
        } else {
            lossCount++;
            EventLog.getInstance().logEvent(new Event("Loss added to " + this.getOpeningName()));
        }
    }

    // EFFECTS: returns the values of this opening as an array
    public String[] convertToArray() {
        String[] result = {openingName, Integer.toString(winCount),
                Integer.toString(lossCount), Integer.toString(drawCount)};


        return result;

    }

    // EFFECTS: returns the opening as a JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("opening name", this.openingName);
        json.put("wins", this.winCount);
        json.put("draws", this.drawCount);
        json.put("losses", this.lossCount);
        return json;
    }


}
