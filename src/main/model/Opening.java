package model;

// represents a single chess opening, with info on the name, win/loss/draws, memorization, tendencies and lines
public class Opening {

    // LAST FILE VERSION WITH OPTIONAL VARIABLES

    private String openingName;         // the name of the opening

    private int winCount;               // user's total amount of wins with the opening
    private int lossCount;              // user's total amount of losses with the opening
    private int drawCount;              // user's total amount of draws

    // private int winCountWhite;          // user's total amount of wins as white
    // private int lossCountWhite;         // user's total amount of losses as white
    // private int drawCountWhite;         // user's total amount of draws as white

    // private int winCountBlack;          // user's total amount of wins as black
    // private int lossCountBlack;         // user's total amount of losses as black
    // private int drawCountBlack;         // user's total amount of draws as black

    private int totalGames;             // user's total amount of games with the opening

    private int movesMemorized;         // amount of moves that the user has memorized
    private int memorizeRequired;       // amount of moves that the user aims to memorize

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
        this.movesMemorized = 0;
        this.memorizeRequired = 0;
    }

    // TODO FINISH THE REQUIRES EFFECTS
    public Opening(String name, int wins, int losses, int draws, int memorize, int memorizeRequired) {
        this.openingName = name;
        this.winCount = wins;
        this.lossCount = losses;
        this.drawCount = draws;
        this.movesMemorized = memorize;
        this.memorizeRequired = memorizeRequired;
    }

    // GETTERS:
    /*
    public int getWinCountWhite() {
        return winCountWhite;
    }

    public int getLossCountWhite() {
        return lossCountWhite;
    }

    public int getDrawCountWhite() {
        return drawCountWhite;
    }

    public int getWinCountBlack() {
        return winCountBlack;
    }

    public int getLossCountBlack() {
        return lossCountBlack;
    }

    public int getDrawCountBlack() {
        return drawCountBlack;
    }
    */
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

    public int getMovesMemorized() {
        return movesMemorized;
    }

    public int getMemorizeRequired() {
        return memorizeRequired;
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

    // TODO (maybe)
    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the win count of playerSide to count, adds (winCount of playerSide - count) to total win count
    public void setWinCountSide(Side playerSide, int count) {
        if (playerSide == Side.WHITE) {
            // stub
        } else {
            // stub
        }
    }

    // TODO
    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the loss count of playerSide to count, adds (lossCount of playerSide - count) to total win count
    public void setLossCountSide(Side playerSide, int count) {
        if (playerSide == Side.WHITE) {
            // stub
        } else {
            // stub
        }
    }

    // TODO
    // REQUIRES: count >= 0
    // MODIFIES: this
    // EFFECTS: sets the draw count of playerSide to count,, adds (drawCount of playerSide - count) to total win count
    public void setDrawCountSide(Side playerSide, int count) {
        if (playerSide == Side.WHITE) {
            // stub
        } else {
            // stub
        }
    }

    // FUNCTION METHODS:

    // TODO
    // REQUIRES: side is either WHITE or BLACK (0 or 1), result is either WIN, LOSS or DRAW (0, 1 or 2)
    // MODIFIES: this
    // EFFECTS: adds a win for the user for either white or black
    public void addUserResult(Side side, Result result){
        // stub
    }

    // TODO
    // REQUIRES: moves >= 0
    // MODIFIES: this
    // EFFECTS: sets the amount of memorization required in a line
    public void setMemorizeRequired(int moves){
        // stub
    }

    // TODO
    // REQUIRES: moves >= 0
    // MODIFIES: this
    // EFFECTS: sets the amount of moves memorized in a line
    public void setMovesMemorized(int moves){
        // stub
    }

}
