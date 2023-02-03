package model;

    // represents a single chess opening, with info on the name, win/loss/draws, memorization, tendencies and lines
public class Opening {


    // ASK TA: CAN I SET THESE TO PUBLIC??????
    // constants used to represent sides in a match
    public static final int WHITE = 0;
    public static final int BLACK = 1;


    // constants used to represent result of a match
    public static final int WIN = 0;
    public static final int LOSS = 1;
    public static final int DRAW = 2;

    private String openingName;         // the name of the opening

    private int winCount;               // user's total amount of wins with the opening
    private int lossCount;              // user's total amount of losses with the opening
    private int drawCount;              // user's total amount of draws

    private int winCountWhite;          // user's total amount of wins as white
    private int lossCountWhite;         // user's total amount of losses as white
    private int drawCountWhite;         // user's total amount of draws as white

    private int winCountBlack;          // user's total amount of wins as black
    private int lossCountBlack;         // user's total amount of losses as black
    private int drawCountBlack;         // user's total amount of draws as black

    private int totalGames;             // user's total amount of games with the opening

    private int movesMemorized;         // amount of moves that the user has memorized
    private int memorizeRequired;       // amount of moves that the user aims to memorize

    // TODO
    // ADD TENDENCIES IF EXTRA TIME

    //private PGN moves;          // MAYBE???!!!!?!?!?!? add moves if there is time

    // TODO
    // REQUIRES: name has a non-zero length
    // EFFECTS: openingName is set to name, every other variable is set to 0
    public Opening(String name){
        // stub
    }

    // GETTERS:
    // TODO: maybe simplify getters?(idk if I should)
    public int getWinCount() {
        return winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

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

    // FUNCTION METHODS:

    // TODO
    // REQUIRES: side is either WHITE or BLACK (0 or 1), result is either WIN, LOSS or DRAW (0, 1 or 2)
    // MODIFIES: this (IF REQUIRED: userWinCount, userWinCountWhite, userWinCountBlack,
    //                              userLossCount, userLossCountWhite, userLossCountBlack,
    //                              totalGames)
    // EFFECTS: adds a win for the user for either white or black
    public void addUserResult(int side, int result){
        // stub
    }

    // TODO
    // REQUIRES: moves >= 0
    // MODIFIES: this (IF REQUIRED: memorizeRequired)
    // EFFECTS: sets the amount of memorization required in a line
    public void setMemorizeRequired(int moves){
        // stub
    }

    // TODO
    // REQUIRES: moves >= 0
    // MODIFIES: this (IF REQUIRED: movesMemorized)
    // EFFECTS: sets the amount of moves memorized in a line
    public void setMovesMemorized(int moves){
        // stub
    }

}
