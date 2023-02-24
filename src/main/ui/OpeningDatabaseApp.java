package ui;

import exceptions.InvalidInputException;
import model.Opening;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Opening Database App
public class OpeningDatabaseApp {

    // Universal Commands
    private static final String QUIT_COMMAND = "q";
    private static final String MENU_COMMAND = "m";
    private static final String ADD_COMMAND = "a";


    // Browse Commands
    private static final String SELECT_COMMAND = "s";
    private static final String CRITERIA_COMMAND = "c";


    // Menu Commands
    private static final String BROWSE_COMMAND = "b";

    // Criteria Commands
    private static final String WIN_COMMAND = "w";
    private static final String LOSSES_COMMAND = "l";
    private static final String DRAWS_COMMAND = "d";

    // Lengths
    private static final String INDEX_LENGTH = "%-10s";
    private static final String NAME_LENGTH = "%-20s";
    private static final String RESULTS_LENGTH = "%-10s";

    // Column names
    private static final String[] COLUMN_NAMES = {"Index", "Name", "Wins", "Losses", "Draws"};

    // Fields to store values for new openings being created
    String tempName;
    int tempWins;
    int tempLosses;
    int tempDraws;
    Opening newOpening;


    private List<Opening> openings; // current opening database
    private List<String> data;      // data to be displayed

    private Scanner input;          // tracks the user's input

    private String command;         // string value of the user's input

    // TODO
    // EFFECTS: runs the opening database application
    public OpeningDatabaseApp() {
        runApp();
    }

    private void runApp() {
        String command = null;      // tracks the user's input as a string

        init();

        displayMenu();



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
        System.out.println("\tb -> (b)rowse your openings");
        System.out.println("\ta -> (a)dd an opening");
        System.out.println("\tq -> (q)uit");

        getNextCommand();

        try {
            processMenuCommand(command);
        } catch (InvalidInputException e) {
            System.out.println("Invalid input, returning to menu...");
            displayMenu();
        }

    }

    // MODIFIES: this
    // EFFECTS:
    private void getNextCommand() {
        command = input.nextLine();
        command = command.toLowerCase();    // convert the command to lowercase, makes handling inputs easier
    }

    // TODO
    // EFFECTS: process the user's command from the menu
    private void processMenuCommand(String command) throws InvalidInputException {
        if (command.equals(BROWSE_COMMAND)) {
            displayBrowse();
        } else if (command.equals(ADD_COMMAND)) {
            addOpening();
        } else if (command.equals(QUIT_COMMAND)) {
            quit();
        } else {
            throw new InvalidInputException();
        }
    }

    // MODIFIES: this
    // EFFECTS: prompts the user to input a new opening and adds it to openings
    private void addOpening() throws InvalidInputException, NumberFormatException {



        openings.add(makeOpening());

        System.out.println("Opening successfully added, returning to menu...");

        displayMenu();

    }


    // EFFECTS: gets the name input from the user
    private String getNameInput() throws InvalidInputException {

        getNextCommand();
        if (command.length() > 0) {
            return command;
        } else {
            throw new InvalidInputException();
        }
    }

    // MODIFIES: this
    // EFFECTS: process the user's name input, setting the database's name value if valid
    private void processNameInput() throws InvalidInputException {

        try {
            tempName = getNameInput();
        } catch (InvalidInputException e) {
            System.out.println("Invalid input, please input the name again:");
            processNameInput();
        }

    }

    // EFFECTS: gets a number input from the user
    private int getNumInput() throws InvalidInputException, NumberFormatException {

        getNextCommand();
        if (Integer.parseInt(command) >= 0) {
            return Integer.parseInt(command);
        } else {
            throw new InvalidInputException();
        }
    }

    // MODIFIES: this
    // EFFECTS: process the user's wins input, setting the tempWins value if valid
    private void processWinsInput() throws InvalidInputException, NumberFormatException {

        try {
            tempWins = getNumInput();
        } catch (InvalidInputException e) {
            System.out.println("Please enter a number greater than or equal to 0:");
            processWinsInput();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number:");
            processWinsInput();
        }
    }

    // MODIFIES: this
    // EFFECTS: process the user's loss input, setting the tempLosses value if valid
    private void processLossInput() throws InvalidInputException, NumberFormatException {

        try {
            tempLosses = getNumInput();
        } catch (InvalidInputException e) {
            System.out.println("Please enter a number greater than or equal to 0:");
            processLossInput();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number:");
            processLossInput();
        }
    }

    // MODIFIES: this
    // EFFECTS: process the user's draw input, setting the tempDraws value if valid
    private void processDrawInput() throws InvalidInputException, NumberFormatException {

        try {
            tempDraws = getNumInput();
        } catch (InvalidInputException e) {
            System.out.println("Please enter a number greater than or equal to 0:");
            processDrawInput();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number:");
            processDrawInput();
        }
    }


    // EFFECTS: asks the user for data and creates a new opening
    private Opening makeOpening() throws InvalidInputException {

        System.out.println("Adding an Opening...");
        System.out.println("Opening name:");

        processNameInput();

        System.out.println("Enter (y) if you would like to add additional info, enter any other key otherwise:");
        getNextCommand();

        if (command.equals("y")) {
            System.out.println("Wins:");
            processWinsInput();

            System.out.println("Losses:");
            processLossInput();

            System.out.println("Draws:");
            processDrawInput();


            newOpening = new Opening(tempName, tempWins, tempLosses, tempDraws);
            return newOpening;
        } else {
            newOpening = new Opening(tempName);
            return newOpening;
        }
    }


    // TODO: CONDENSE THE METHOD, MAKE HELPERS
    // EFFECTS: allows user to browse through openings
    private void displayBrowse() throws InvalidInputException {
        String indexCol = String.format(INDEX_LENGTH, "Index");
        String nameCol = String.format(NAME_LENGTH, "Name");
        String winCol = String.format(RESULTS_LENGTH, "Wins");
        String lossCol = String.format(RESULTS_LENGTH, "Losses");
        String drawCol = String.format(RESULTS_LENGTH, "Draws");

        System.out.println(indexCol + nameCol + winCol + lossCol + drawCol);
        for (Opening o : openings) {
            String indexStr = String.format(INDEX_LENGTH, Integer.toString(openings.indexOf(o)));
            String nameStr = String.format(NAME_LENGTH, o.getOpeningName());
            String winStr = String.format(RESULTS_LENGTH, o.getWinCount());
            String lossStr = String.format(RESULTS_LENGTH, o.getLossCount());
            String drawStr = String.format(RESULTS_LENGTH, o.getDrawCount());
            System.out.println(indexStr + nameStr + winStr + lossStr + drawStr);
        }

        System.out.println("\nWhat do you want to do?");
        System.out.println("\ts -> (s)elect an opening");
        System.out.println("\tc -> sort by (c)riteria");
        System.out.println("\ta -> (a)dd an opening");
        System.out.println("\tm -> return to (menu)");
        System.out.println("\tq -> (q)uit");

        getNextCommand();
        try {
            processBrowseCommand(command);
        } catch (InvalidInputException e) {
            System.out.println("Selection not valid. Please try again.");
            getNextCommand();
            processCriteriaCommand();
        }

    }

    // EFFECTS: process the user's command and open the corresponding page
    private void processBrowseCommand(String command) throws InvalidInputException {
        if (command.equals(SELECT_COMMAND)) {
            selectOpening();
        } else if (command.equals(CRITERIA_COMMAND)) {
            displayCriteria();
        } else if (command.equals(ADD_COMMAND)) {
            addOpening();
        } else if (command.equals(MENU_COMMAND)) {
            displayMenu();
        } else if (command.equals(QUIT_COMMAND)) {
            quit();
        } else {
            throw new InvalidInputException();
        }
    }

    // TODO
    // EFFECTS: allows the user to select an opening from openings
    private void selectOpening() {
        System.out.println("Select your opening: ");
    }

    // EFFECTS: quits the application
    private void quit() {
        System.out.println("Goodbye!");
    }

    // MODIFIES: this
    // EFFECTS: rearranges the database based on criteria
    private void displayCriteria() throws InvalidInputException {
        System.out.println("\nWhich criteria do you want to sort by?");
        System.out.println("\tw -> (w)ins)");
        System.out.println("\tl -> (l)osses)");
        System.out.println("\td -> (d)raws)");
        System.out.println("\tm -> return to (m)enu))");
        System.out.println("\tq -> (q)uit");

        getNextCommand();

        try {
            processCriteriaCommand();
        } catch (InvalidInputException e) {
            System.out.println("Selection not valid. Please try again.");
            getNextCommand();
            processCriteriaCommand();
        }

    }

    // MODIFIES: this
    // EFFECTS: based on the user's input, chooses which criteria to sort the database by
    private void processCriteriaCommand() throws InvalidInputException {
        if (command.equals(WIN_COMMAND)) {
            sortByWins();
        } else if (command.equals(LOSSES_COMMAND)) {
            sortByLosses();
        } else if (command.equals(DRAWS_COMMAND)) {
            sortByDraws();
        } else if (command.equals(MENU_COMMAND)) {
            displayMenu();
        } else if (command.equals(QUIT_COMMAND)) {
            quit();
        } else {
            throw new InvalidInputException();
        }
    }

    // TODO
    private void sortByWins() {

    }

    // TODO
    private void sortByLosses() {

    }

    // TODO
    private void sortByDraws() {

    }



}
