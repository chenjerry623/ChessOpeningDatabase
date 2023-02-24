package model;

// represents a single chess opening, with info on the name, win/loss/draws, memorization, tendencies and lines
public class Opening {

    // LAST FILE VERSION WITH OPTIONAL VARIABLES

    private String openingName;         // the name of the opening

    private int winCount;               // user's total amount of wins with the opening
    private int lossCount;              // user's total amount of losses with the opening
    private int drawCount;              // user's total amount of draws

    private int totalGames;             // user's total amount of games with the opening

    // TODO
    // ADD TENDENCIES IF EXTRA TIME

    //private PGN moves;          // MAYBE???!!!!?!?!?!? add moves if there is time

    // TODO
    // REQUIRES: name has a non-zero length
    // EFFECTS: openingName is set to name, every other variable is set to 0
    public Opening(String name) {
        this.openingName = name;
        this.winCount = 0;
        this.lossCount = 0;
        this.drawCount = 0;
    }

    // TODO FINISH THE REQUIRES EFFECTS
    public Opening(String name, int wins, int losses, int draws) {
        this.openingName = name;
        this.winCount = wins;
        this.lossCount = losses;
        this.drawCount = draws;
    }

    // GETTERS:

    public int getWinCount() {
        return winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public String getOpeningName() {
        return this.openingName;
    }

    // SETTERS

    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the win count to count, adds (winCount - count) to total win count
    public void setWinCount(int count) {
        // stub
    }

    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the loss count to count, adds (winCount - count) to total loss count
    public void setLossCount(int count) {
        // stub
    }

    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the loss count to count, adds (winCount - count) to total loss count
    public void setDrawCount(int count) {
        // stub
    }


    // FUNCTION METHODS:

    // TODO
    // REQUIRES: side is either WHITE or BLACK (0 or 1), result is either WIN, LOSS or DRAW (0, 1 or 2)
    // MODIFIES: this
    // EFFECTS: adds a win for the user for either white or black
    public void addUserResult(Side side, Result result){
        // stub
    }


}
