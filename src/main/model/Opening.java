package model;

    // represents a single chess opening, with info on the name, win/loss/draws, memorization, tendencies and lines
public class Opening {

    private String openingName;     // the name of the opening

    private int userWinCount;           // user's total amount of wins with the opening
    private int userLossCount;          // user's total amount of losses with the opening
    private int userWinCountWhite;      // user's total amount of wins as white
    private int userLossCountWhite;     // user's total amount of losses as white
    private int userWinCountBlack;      // user's total amount of wins as black
    private int userLossCountBlack;     // user's total amount of losses as black
    private int drawCount;              // user's total amount of draws
    private int totalGames;             // user's total amount of games with the opening

    private int movesMemorized;         // amount of moves that the user has memorized
    private int movesMemorizedRequired; // amount of moves that the user aims to memorize

        // ADD TENDENCIES IF EXTRA TIME

    //private PGN moves;          // MAYBE???!!!!?!?!?!? add moves if there is time


}
