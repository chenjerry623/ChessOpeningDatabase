package model;

// Constant values and commands used in the code
public interface Constants {
    // Universal Commands
    char QUIT_COMMAND = 'q';
    char MENU_COMMAND = 'm';
    char ADD_COMMAND = 'a';
    char ADD_ADDITION_INFO = 'y';
    char NO_COMMAND = 'n';

    // Browse Commands
    char SELECT_COMMAND = 's';
    char CRITERIA_COMMAND = 'c';

    // Menu Commands
    char BROWSE_COMMAND = 'b';
    char SAVE_COMMAND = 's';
    char LOAD_COMMAND = 'l';

    // Criteria Commands
    char WIN_COMMAND = 'w';
    char LOSSES_COMMAND = 'l';
    char DRAWS_COMMAND = 'd';
    char TOTAL_COMMAND = 't';

    // Ascending/Descending Commands
    char ASCENDING_COMMAND = 'a';
    char DESCENDING_COMMAND = 'd';

    // Lengths
    String INDEX_LENGTH = "%-10s";
    String NAME_LENGTH = "%-30s";
    String RESULTS_LENGTH = "%-15s";

    String NEW_LINE = "/n";
}
