package ui;

import model.Opening;
import model.Result;
import model.Side;
import utility.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Opening Database App
public class OpeningDatabaseApp {

    private static class InvalidInputException extends Throwable {
    }

    private static class EmptyDatabaseException extends Throwable{
    }

    // Universal Commands
    public static final char QUIT_COMMAND = 'q';
    public static final char MENU_COMMAND = 'm';
    public static final char ADD_COMMAND = 'a';
    public static final char ADD_ADDITION_INFO = 'y';
    public static final char NO_COMMAND = 'n';

    // Browse Commands
    public static final char SELECT_COMMAND = 's';
    public static final char CRITERIA_COMMAND = 'c';

    // Menu Commands
    public static final char BROWSE_COMMAND = 'b';

    // Criteria Commands
    public static final char WIN_COMMAND = 'w';
    public static final char LOSSES_COMMAND = 'l';
    public static final char DRAWS_COMMAND = 'd';
    public static final char TOTAL_COMMAND = 't';

    // Ascending/Descending Commands
    public static final char ASCENDING_COMMAND = 'a';
    public static final char DESCENDING_COMMAND = 'd';

    // Lengths
    public static final String INDEX_LENGTH = "%-10s";
    public static final String NAME_LENGTH = "%-30s";
    public static final String RESULTS_LENGTH = "%-15s";

    public static final String NEW_LINE = "/n";

    // Fields to store values for new openings being created

    private List<Opening> openings; // current opening database

    private Scanner input;          // tracks the user's input

    // EFFECTS: runs the opening database application
    public OpeningDatabaseApp() {
    }

    public void runApp() {
        init();
        displayMenu();
    }

    // MODIFIES: this
    // EFFECTS: initializes the opening database and scanner
    private void init() {
        openings = new ArrayList<>();
        input = new Scanner(System.in);
        input.useDelimiter(NEW_LINE);   // tells the scanner to use new lines to separate inputs
    }

    // EFFECTS: returns the user's latest input line. Used for inputting strings and ints
    private String getNextUserInput() {
        return input.nextLine();
    }

    // EFFECTS: returns the user's command, throwing an exception if the command is invalid.
    private char getNextCommand(final char[] options) {

        boolean keepGoing = false;
        String command;

        do {
            if (keepGoing) {
                System.out.println("invalid input, please try again");
            }

            command = input.nextLine();
            command = command.toLowerCase();

            if (command.length() != 1) {
                keepGoing = true;
            } else if (options.length == 0) {
                // if we're accepting any input, stop the loop
                keepGoing = false;
            } else {
                keepGoing = true;
                for (char option : options) {
                    if (command.charAt(0) == option) {
                        keepGoing = false;
                        break;
                    }
                }
            }
        } while (keepGoing);

        return command.charAt(0);
    }

    // MENU FUNCTIONS

    // MODIFIES: this
    // EFFECTS: displays the app's menu
    private void displayMenu() {

        boolean keepGoing;

        do {
            System.out.println("\nWelcome to your opening database!");
            System.out.println("\nWhat do you want to do?");
            System.out.println("\tb -> (b)rowse your openings");
            System.out.println("\ta -> (a)dd an opening");
            System.out.println("\tq -> (q)uit");

            final char[] options = { ADD_COMMAND, BROWSE_COMMAND, QUIT_COMMAND};
            final char command = getNextCommand(options);

            try {
                processMenuCommand(command);
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Invalid input, returning to menu...");
                keepGoing = true;
            }
        } while (keepGoing);

    }

    // MODIFIES: this
    // EFFECTS: process the user's command from the menu
    private void processMenuCommand(final char command) throws InvalidInputException {

        switch (command) {
            case BROWSE_COMMAND:
                displayBrowse();
                break;
            case ADD_COMMAND:
                addOpening();
                break;
            case QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }

    // MODIFIES: this
    // EFFECTS: prompts the user to return to the main menu if any key is entered
    private void returnToMenuPrompt() {
        System.out.println("Enter any key to return to the main menu.");
        final char[] options = {};
        getNextCommand(options);
        displayMenu();
    }

    // ADD OPENING FUNCTIONS

    // MODIFIES: this
    // EFFECTS: prompts the user to input a new opening and adds it to openings
    private void addOpening() throws NumberFormatException {

        openings.add(makeOpening());

        System.out.println("Opening successfully added, returning to menu...");

        displayMenu();

    }

    // EFFECTS: gets the name input from the user and checks if the length is acceptable
    private String getNameInput() throws InvalidInputException {

        final String userInput = getNextUserInput();
        if (userInput.length() > 0 && userInput.length() < 30) {
            return userInput;
        } else {
            throw new InvalidInputException();
        }
    }


    // EFFECTS: process the user's name input, setting and returning tempName's value if valid
    private String processNameInput() {

        boolean keepGoing;
        String tempName = null;
        do {
            try {
                tempName = getNameInput();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Invalid input, please input the name again:");
                keepGoing = true;
            }
        } while (keepGoing);

        return tempName;
    }

    // EFFECTS: returns a numerical input from the user
    private int getNumInput() throws InvalidInputException, NumberFormatException {

        final String userInput = getNextUserInput();
        if (Integer.parseInt(userInput) >= 0) {
            return Integer.parseInt(userInput);
        } else {
            throw new InvalidInputException();
        }
    }

    // EFFECTS: process the user's wins input, setting and returning the tempWins value if valid
    private int processWinsInput() throws NumberFormatException {

        boolean keepGoing;
        int tempWins = 0;

        do {
            try {
                tempWins = getNumInput();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a number greater than or equal to 0:");
                keepGoing = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (1 - 2147483647):");
                keepGoing = true;
            }
        } while (keepGoing);

        return tempWins;
    }


    // EFFECTS: process the user's loss input, setting and returning the tempLosses value if valid
    private int processLossInput() throws NumberFormatException {

        boolean keepGoing;
        int tempLosses = 0;

        do {
            try {
                tempLosses = getNumInput();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a number greater than or equal to 0:");
                keepGoing = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number:");
                keepGoing = true;
            }
        } while (keepGoing);

        return tempLosses;
    }


    // EFFECTS: process the user's draw input, setting and returning the tempDraws value if valid
    private int processDrawInput() throws NumberFormatException {

        boolean keepGoing;
        int tempDraws = 0;

        do {
            try {
                tempDraws = getNumInput();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a number greater than or equal to 0:");
                keepGoing = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number:");
                keepGoing = true;
            }
        } while (keepGoing);

        return tempDraws;
    }


    // EFFECTS: asks the user for data and returns a new opening from the inputs
    private Opening makeOpening() {

        System.out.println("Adding an Opening...");
        System.out.println("Opening name (29 characters max):");

        final String tempName = processNameInput();

        System.out.println("Enter (y) if you would like to add additional info, otherwise enter (n):");

        final char[] options = { ADD_ADDITION_INFO, NO_COMMAND};
        final char command = getNextCommand(options);

        Opening newOpening;

        if (command == ADD_ADDITION_INFO) {
            System.out.println("Wins:");
            final int tempWins = processWinsInput();

            System.out.println("Losses:");
            final int tempLosses = processLossInput();

            System.out.println("Draws:");
            final int tempDraws = processDrawInput();

            newOpening = new Opening(tempName, tempWins, tempLosses, tempDraws);
        } else {
            newOpening = new Opening(tempName);
        }
        return newOpening;
    }

    // BROWSE FUNCTIONS

    // MODIFIES: this
    // EFFECTS: displays the opening database, then prompts user to interact with the table
    private void displayBrowse() {

        printTable();

        System.out.println("\nWhat do you want to do?");
        System.out.println("\ts -> (s)elect an opening");
        System.out.println("\tc -> sort by (c)riteria");
        System.out.println("\ta -> (a)dd an opening");
        System.out.println("\tm -> return to (m)enu");
        System.out.println("\tq -> (q)uit");

        boolean keepGoing;

        do {
            try {
                processBrowseCommand();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Selection not valid. Please try again.");
                keepGoing = true;
            }
        } while (keepGoing);
    }

    // EFFECTS: displays the openings in the database as a table
    private void printTable() {
        String indexCol = String.format(INDEX_LENGTH, "Index");
        String nameCol = String.format(NAME_LENGTH, "Name");
        String winCol = String.format(RESULTS_LENGTH, "Wins");
        String lossCol = String.format(RESULTS_LENGTH, "Losses");
        String drawCol = String.format(RESULTS_LENGTH, "Draws");
        String totalCol = String.format(RESULTS_LENGTH, "Total Matches");

        System.out.println(indexCol + nameCol + winCol + lossCol + drawCol + totalCol);

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

    // MODIFIES: this
    // EFFECTS: process the user's command and open the corresponding page
    private void processBrowseCommand() throws InvalidInputException {

        final char[] options = { SELECT_COMMAND, CRITERIA_COMMAND, ADD_COMMAND, MENU_COMMAND, QUIT_COMMAND};
        final char command = getNextCommand(options);

        switch (command) {
            case SELECT_COMMAND:
                selectOpening();
                break;
            case CRITERIA_COMMAND:
                displayCriteria();
                break;
            case ADD_COMMAND:
                addOpening();
                break;
            case MENU_COMMAND:
                displayMenu();
                break;
            case QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }



    // SELECT OPENING FUNCTIONS

    // MODIFIES: this, o
    // EFFECTS: allows the user to select an opening from openings
    private void selectOpening() throws NumberFormatException {
        System.out.println("Input the index of the opening you want to select:");
        Opening selectedOpening;

        boolean keepGoing;

        do {
            try {
                selectedOpening = inputSelection();
                selectedOpening.displayInfo();
                selectOptions(selectedOpening);
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a valid index: ");
                keepGoing = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number: ");
                keepGoing = true;
            } catch (EmptyDatabaseException e) {
                System.out.println("Database is empty, returning to menu...");
                displayMenu();
                keepGoing = false;
            }
        } while (keepGoing);


    }

    // MODIFIES: this, o
    // EFFECTS: prompts the user to select what to do with the opening
    private void selectOptions(Opening o) throws InvalidInputException {

        System.out.println("\nWhat do you want to do next?");
        System.out.println("\tw -> add a (w)in");
        System.out.println("\tl -> add a (l)oss");
        System.out.println("\td -> add a (d)raw");
        System.out.println("\tm -> return to (m)enu");
        System.out.println("\tq -> (q)uit");

        boolean keepGoing;

        do {
            try {
                processSelect(o);
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a valid input:");
                keepGoing = true;
            }
        } while (keepGoing);
    }

    // MODIFIES: this, o
    // EFFECTS: adds a win/loss/draw to o, depending on user's input
    private void processSelect(Opening o) throws InvalidInputException {

        final char[] options = { WIN_COMMAND, LOSSES_COMMAND, DRAWS_COMMAND, MENU_COMMAND, QUIT_COMMAND };
        final char command = getNextCommand(options);

        switch (command) {
            case WIN_COMMAND:
                logResult(Result.WIN, "Win", o);
                break;
            case LOSSES_COMMAND:
                logResult(Result.LOSS, "Loss", o);
                break;
            case DRAWS_COMMAND:
                logResult(Result.DRAW, "Draw", o);
                break;
            case MENU_COMMAND:
                displayMenu();
                break;
            case QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }

    // MODIFIES: this, o
    // EFFECTS: adds the result r to the opening's result count
    private void logResult(final Result r, final String resultStr, Opening o) {
        o.addUserResult(Side.WHITE, r);
        System.out.println(resultStr + " added to" + o.getOpeningName());
        returnToMenuPrompt();
    }

    // EFFECTS: returns the user's selected opening
    private Opening inputSelection() throws InvalidInputException, NumberFormatException, EmptyDatabaseException {
        final String userInput = getNextUserInput();
        if (openings.size() == 0) {
            throw new EmptyDatabaseException();
        } else if (0 <= Integer.parseInt(userInput) && Integer.parseInt(userInput) <= (openings.size() - 1)) {
            return openings.get(Integer.parseInt(userInput));
        } else {
            throw new InvalidInputException();
        }
    }

    // SORT BY CRITERIA FUNCTIONS:

    // MODIFIES: this
    // EFFECTS: rearranges the database based on criteria
    private void displayCriteria() {
        System.out.println("\nWhich criteria do you want to sort by?");
        System.out.println("\tw -> (w)ins");
        System.out.println("\tl -> (l)osses");
        System.out.println("\td -> (d)raws");
        System.out.println("\tt -> (t)otal matches");
        System.out.println("\tm -> return to (m)enu");
        System.out.println("\tq -> (q)uit");

        boolean keepGoing;

        do {
            try {
                processCriteriaCommand();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Selection not valid. Please try again.");
                keepGoing = true;
            }
        } while (keepGoing);
    }

    // MODIFIES: this
    // EFFECTS: based on the user's input, chooses which criteria to sort the database by
    private void processCriteriaCommand() throws InvalidInputException {

        final char[] options = { WIN_COMMAND, LOSSES_COMMAND, DRAWS_COMMAND,
                TOTAL_COMMAND, MENU_COMMAND, QUIT_COMMAND };
        final char command = getNextCommand(options);

        sortByCommand(command);
    }

    // MODIFIES: this
    // EFFECTS: sorts the openings database based on user's command
    private void sortByCommand(char command) throws InvalidInputException {
        switch (command) {
            case WIN_COMMAND:
                sortByWins();
                break;
            case LOSSES_COMMAND:
                sortByLosses();
                break;
            case DRAWS_COMMAND:
                sortByDraws();
                break;
            case TOTAL_COMMAND:
                sortByTotal();
                break;
            case MENU_COMMAND:
                displayMenu();
                break;
            case QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }

    // EFFECTS: returns the user's input on whether the list is to be sorted in ascending
    private Boolean inputAscending() throws InvalidInputException {
        boolean result;

        final char[] options = { ASCENDING_COMMAND, DESCENDING_COMMAND };
        final char command = getNextCommand(options);

        switch (command) {
            case ASCENDING_COMMAND:
                result = true;
                break;
            case DESCENDING_COMMAND:
                result = false;
                break;
            default:
                throw new InvalidInputException();
        }

        return result;
    }

    // MODIFIES: this
    // EFFECTS: sorts the list in ascending/descending order of wins, depending on the user's input
    private void sortByWins() {

        boolean isAscending = false;    // tracks whether the list is ascending

        System.out.println("How would you like to sort by wins?");
        System.out.println("\ta -> (a)scending");
        System.out.println("\td -> (d)escending");

        boolean keepGoing;

        do {
            try {
                isAscending = inputAscending();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a valid input:");
                keepGoing = true;
            }
        } while (keepGoing);

        if (isAscending) {
            openings.sort(new LeastWinsComparator());
            System.out.println("Opening database sorted by wins (ascending): ");
        } else {
            openings.sort(new MostWinsComparator());
            System.out.println("Opening database sorted by wins (descending): ");
        }

        displayBrowse();
    }


    // MODIFIES: this
    // EFFECTS: sorts the list in ascending/descending order of losses, depending on the user's input
    private void sortByLosses() {
        boolean isAscending = false;    // tracks whether the list is ascending

        System.out.println("How would you like to sort by losses?");
        System.out.println("\ta -> (a)scending");
        System.out.println("\td -> (d)escending");

        boolean keepGoing;

        do {
            try {
                isAscending = inputAscending();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a valid input:");
                keepGoing = true;
            }
        } while (keepGoing);

        if (isAscending) {
            openings.sort(new LeastLossesComparator());
            System.out.println("Opening database sorted by losses (ascending): ");
        } else {
            openings.sort(new MostLossesComparator());
            System.out.println("Opening database sorted by losses (descending): ");
        }

        displayBrowse();
    }

    // MODIFIES: this
    // EFFECTS: sorts the list in ascending/descending order of draws, depending on the user's input
    private void sortByDraws() {
        boolean isAscending = false;    // tracks whether the list is ascending

        System.out.println("How would you like to sort by draws?");
        System.out.println("\ta -> (a)scending");
        System.out.println("\td -> (d)escending");

        boolean keepGoing;

        do {
            try {
                isAscending = inputAscending();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a valid input:");
                keepGoing = true;
            }
        } while (keepGoing);

        if (isAscending) {
            openings.sort(new LeastDrawsComparator());
            System.out.println("Opening database sorted by draws (ascending): ");
        } else {
            openings.sort(new MostDrawsComparator());
            System.out.println("Opening database sorted by draws (descending): ");
        }

        displayBrowse();
    }

    // MODIFIES: this
    // EFFECTS: sorts the list in ascending/descending order of total matches, depending on the user's input
    private void sortByTotal() {
        boolean isAscending = false;    // tracks whether the list is ascending

        System.out.println("How would you like to sort by total matches?");
        System.out.println("\ta -> (a)scending");
        System.out.println("\td -> (d)escending");

        boolean keepGoing;

        do {
            try {
                isAscending = inputAscending();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a valid input:");
                keepGoing = true;
            }
        } while (keepGoing);



        if (isAscending) {
            openings.sort(new LeastMatchesComparator());
            System.out.println("Opening database sorted by total matches (ascending): ");
        } else {
            openings.sort(new MostMatchesComparator());
            System.out.println("Opening database sorted by total matches (descending): ");
        }

        displayBrowse();
    }

    // EFFECTS: quits the application
    private void quit() {
        System.out.println("Goodbye!");
    }
}