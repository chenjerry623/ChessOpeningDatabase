package ui;

import model.Opening;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Opening Database App
public class OpeningDatabaseApp {

    // Commands
    private static final String BROWSECOMMAND = "b";
    private static final String SEARCHCOMMAND = "s";
    private static final String ADDCOMMAND = "a";
    private static final String QUITCOMMAND = "q";


    private List<Opening> openings; // current opening database

    private Scanner input;          // tracks the user's input

    // TODO
    // EFFECTS: runs the opening database application
    public OpeningDatabaseApp() {
        runApp();
    }

    private void runApp() {
        boolean keepGoing = true;   // tells the program whether or not to continue running
        String command = null;      // tracks the user's input as a string

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();    // convert the command to lowercase, makes handling inputs easier

            if (command.equals(QUITCOMMAND)) {
                keepGoing = false;              // quit the program if the user inputs QUITCOMMAND
            } else {
                processCommand(command);
            }

        }

        System.out.println("\nGoodbye!");

    }

    // EFFECTS: initializes the opening database and scanner
    private void init() {
        openings = new ArrayList<Opening>();
        input = new Scanner(System.in);
        input.useDelimiter("/n");   // tells the scanner to use new lines to separate inputs
    }

    // EFFECTS: displays the app's menu
    private void displayMenu() {
        System.out.println("\nWelcome to your opening database!");
        System.out.println("\nWhat do you want to do?");
        System.out.println("\tb -> browse your openings");
        System.out.println("\ts -> search for an opening");
        System.out.println("\ta -> add an opening");
        System.out.println("\tq -> quit");
    }

    // TODO
    // EFFECTS: process the user's command
    private void processCommand(String command) {

    }

    // TODO
    // REQUIRES: name has a non-zero length
    // MODIFIES: this
    // EFFECTS: prompts the user to input a new opening and adds it to openings
    private void addOpening(String name) {
        // stub
    }

    // TODO
    // EFFECTS: allows user to browse through openings
    private void browseOpening() {
        // stub
    }

    // TODO
    // EFFECTS: allows the user to select an opening from openings
    private void selectOpening() {

    }

    // TODO
    // EFFECTS: filters through the database based on criteria
    private void filterOpenings() {

    }

    // TODO
    // EFFECTS: sorts the database based on criteria
    private void sortOpenings() {

    }


}
