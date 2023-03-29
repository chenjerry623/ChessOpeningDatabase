package ui;

import model.*;

import persistence.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import java.awt.event.MouseAdapter;


// Opening Database App
// Citation: save/load section is referenced and based on the example JsonSerializationDemo provided on edx
public class OpeningDatabaseAppUI extends JFrame implements Constants {


    private static class InvalidInputException extends Throwable {
    }

    private static class EmptyDatabaseException extends Throwable{
    }

    private static final String JSON_STORE = "./data/databasefile.json";

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private MenuFrame menuFrame;
    private AddFrame addFrame;


    // Fields to store values for new openings being created

    private OpeningDatabase openings; // current opening database

    private Scanner input;          // tracks the user's input

    // EFFECTS: runs the opening database application
    public OpeningDatabaseAppUI() {
        // TODO: delete later
        runApp();
    }

    public void runApp() {
        makeMenu();
    }

    private void makeMenu() {
        openings = new OpeningDatabase();
        menuFrame = new MenuFrame(openings);
        // TODO: add an icon

    }



}