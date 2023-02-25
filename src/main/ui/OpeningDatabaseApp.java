package ui;

import exceptions.EmptyDatabaseException;
import exceptions.InvalidInputException;
import model.Opening;
import model.Result;
import model.Side;
import utility.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Opening Database App
public class OpeningDatabaseApp {

    public static final String NEW_LINE = "/n";

    // Fields to store values for new openings being created
    String tempName;
    int tempWins;
    int tempLosses;
    int tempDraws;
    Opening newOpening;

    private List<Opening> openings; // current opening database

    private Scanner input;          // tracks the user's input

    private String command;         // string value of the user's input

    // EFFECTS: runs the opening database application
    public OpeningDatabaseApp() {
        runApp();
    }

    private void runApp() {
        init();

        displayMenu();
    }

    // EFFECTS: initializes the opening database and scanner
    private void init() {
        openings = new ArrayList<>();
        input = new Scanner(System.in);
        input.useDelimiter(NEW_LINE);   // tells the scanner to use new lines to separate inputs
    }

    // MODIFIES: this
    // EFFECTS:
    private void getNextCommand() {
        command = input.nextLine();
        command = command.toLowerCase();    // convert the command to lowercase, makes handling inputs easier
    }

    // MENU FUNCTIONS

    // EFFECTS: displays the app's menu
    private void displayMenu() {

        boolean keepGoing;

        do {
            System.out.println("\nWelcome to your opening database!");
            System.out.println("\nWhat do you want to do?");
            System.out.println("\tb -> (b)rowse your openings");
            System.out.println("\ta -> (a)dd an opening");
            System.out.println("\tq -> (q)uit");

            getNextCommand();

            try {
                processMenuCommand();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Invalid input, returning to menu...");
                keepGoing = true;
            }
        } while (keepGoing);

    }

    // EFFECTS: process the user's command from the menu
    private void processMenuCommand() throws InvalidInputException {

        switch (command) {
            case Commands.BROWSE_COMMAND:
                displayBrowse();
                break;
            case Commands.ADD_COMMAND:
                addOpening();
                break;
            case Commands.QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }

    // EFFECTS: prompts the user to return to the main menu if any key is entered
    private void returnToMenuPrompt() {
        System.out.println("Enter any key to return to the main menu.");
        getNextCommand();
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

    // EFFECTS: gets the name input from the user
    private String getNameInput() throws InvalidInputException {

        getNextCommand();
        if (command.length() > 0 && command.length() < 30) {
            return command;
        } else {
            throw new InvalidInputException();
        }
    }

    // MODIFIES: this
    // EFFECTS: process the user's name input, setting the database's name value if valid
    private void processNameInput() {

        boolean keepGoing;

        do {
            try {
                tempName = getNameInput();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Invalid input, please input the name again:");
                keepGoing = true;
            }
        } while (keepGoing);


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
    private void processWinsInput() throws NumberFormatException {

        boolean keepGoing;

        do {
            try {
                tempWins = getNumInput();
                keepGoing = false;
            } catch (InvalidInputException e) {
                System.out.println("Please enter a number greater than or equal to 0:");
                keepGoing = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number:");
                keepGoing = true;
            }
        } while (keepGoing);

    }

    // MODIFIES: this
    // EFFECTS: process the user's loss input, setting the tempLosses value if valid
    private void processLossInput() throws NumberFormatException {

        boolean keepGoing;

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
    }

    // MODIFIES: this
    // EFFECTS: process the user's draw input, setting the tempDraws value if valid
    private void processDrawInput() throws NumberFormatException {

        boolean keepGoing;

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


    }

    // EFFECTS: asks the user for data and creates a new opening
    private Opening makeOpening() {

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
        String indexCol = String.format(Commands.INDEX_LENGTH, "Index");
        String nameCol = String.format(Commands.NAME_LENGTH, "Name");
        String winCol = String.format(Commands.RESULTS_LENGTH, "Wins");
        String lossCol = String.format(Commands.RESULTS_LENGTH, "Losses");
        String drawCol = String.format(Commands.RESULTS_LENGTH, "Draws");
        String totalCol = String.format(Commands.RESULTS_LENGTH, "Total Matches");

        System.out.println(indexCol + nameCol + winCol + lossCol + drawCol + totalCol);

        for (Opening o : openings) {
            String indexStr = String.format(Commands.INDEX_LENGTH, openings.indexOf(o));
            String nameStr = String.format(Commands.NAME_LENGTH, o.getOpeningName());
            String winStr = String.format(Commands.RESULTS_LENGTH, o.getWinCount());
            String lossStr = String.format(Commands.RESULTS_LENGTH, o.getLossCount());
            String drawStr = String.format(Commands.RESULTS_LENGTH, o.getDrawCount());
            String totalStr = String.format(Commands.RESULTS_LENGTH, o.getTotalGames());
            System.out.println(indexStr + nameStr + winStr + lossStr + drawStr + totalStr);
        }
    }

    // EFFECTS: process the user's command and open the corresponding page
    private void processBrowseCommand() throws InvalidInputException {
        getNextCommand();
        switch (command) {
            case Commands.SELECT_COMMAND:
                selectOpening();
                break;
            case Commands.CRITERIA_COMMAND:
                displayCriteria();
                break;
            case Commands.ADD_COMMAND:
                addOpening();
                break;
            case Commands.MENU_COMMAND:
                displayMenu();
                break;
            case Commands.QUIT_COMMAND:
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
        System.out.println("\tm -> return to (m)enu)");
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
        getNextCommand();

        switch (command) {
            case Commands.WIN_COMMAND:
                logResult(Result.WIN, "Win", o);
                break;
            case Commands.LOSSES_COMMAND:
                logResult(Result.LOSS, "Loss", o);
                break;
            case Commands.DRAWS_COMMAND:
                logResult(Result.DRAW, "Draw", o);
                break;
            case Commands.MENU_COMMAND:
                displayMenu();
                break;
            case Commands.QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }

    private void logResult(final Result r, final String resultStr, Opening o) {
        o.addUserResult(Side.WHITE, r);
        System.out.println(resultStr + " added to" + o.getOpeningName());
        returnToMenuPrompt();
    }

    // EFFECTS: returns the user's selected opening
    private Opening inputSelection() throws InvalidInputException, NumberFormatException, EmptyDatabaseException {
        getNextCommand();
        if (openings.size() == 0) {
            throw new EmptyDatabaseException();
        } else if (0 <= Integer.parseInt(command) && Integer.parseInt(command) <= (openings.size() - 1)) {
            return openings.get(Integer.parseInt(command));
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

        getNextCommand();

        switch (command) {
            case Commands.WIN_COMMAND:
                sortByWins();
                break;
            case Commands.LOSSES_COMMAND:
                sortByLosses();
                break;
            case Commands.DRAWS_COMMAND:
                sortByDraws();
                break;
            case Commands.TOTAL_COMMAND:
                sortByTotal();
                break;
            case Commands.MENU_COMMAND:
                displayMenu();
                break;
            case Commands.QUIT_COMMAND:
                quit();
                break;
            default:
                throw new InvalidInputException();
        }
    }

    // EFFECTS: returns the user's input on whether the list is to be sorted in ascending
    private Boolean inputAscending() throws InvalidInputException {
        boolean result;

        getNextCommand();

        switch (command) {
            case Commands.ASCENDING_COMMAND:
                result = true;
                break;
            case Commands.DESCENDING_COMMAND:
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
            Collections.sort(openings, new LeastWinsComparator());
            System.out.println("Opening database sorted by wins (ascending): ");
        } else {
            Collections.sort(openings, new MostWinsComparator());
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
            Collections.sort(openings, new LeastLosses());
            System.out.println("Opening database sorted by losses (ascending): ");
        } else {
            Collections.sort(openings, new MostLosses());
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
            Collections.sort(openings, new LeastDraws());
            System.out.println("Opening database sorted by draws (ascending): ");
        } else {
            Collections.sort(openings, new MostDraws());
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
            Collections.sort(openings, new LeastMatches());
            System.out.println("Opening database sorted by total matches (ascending): ");
        } else {
            Collections.sort(openings, new MostMatches());
            System.out.println("Opening database sorted by total matches (descending): ");
        }

        displayBrowse();
    }

    // EFFECTS: quits the application
    private void quit() {
        System.out.println("Goodbye!");
    }
}
