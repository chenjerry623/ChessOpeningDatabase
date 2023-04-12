package ui;

import model.EventLog;
import model.OpeningDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import persistence.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Menu Page UI
public class MenuFrame extends JFrame implements ActionListener, WindowListener {

    // buttons for navigation and saving/loading
    private JButton addButton;
    private JButton browseButton;
    private JButton saveButton;
    private JButton loadButton;


    // labels for database title and icon
    private JLabel titleLabel;
    private JLabel savedStatusLabel;

    // the current status of the opening database
    private OpeningDatabase openingDatabase;

    // the address for storing json files
    private static final String JSON_STORE = "./data/databasefile.json";

    // Json objects for reading and writing databases
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // ImageIcon for the app's logo
    private ImageIcon databaseLogo;

    // constants for window size
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 750;

    WindowListener listener = new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
            for (model.Event next : EventLog.getInstance()) {
                System.out.println(next.getDescription());
            }
        }
    };

    // MODIFIES: this
    // EFFECTS: constructs the menu JFrame
    MenuFrame(OpeningDatabase database) {

        this.openingDatabase = database;
        addWindowListener(this);

        setupFrame();



        // add title
        addTitle();


        // save labels
        addSaveLabel();

        // add button for adding
        addAddButton();

        // add button for saving
        addSaveButton();

        // add button for loading openings
        addLoadButton();

        // add button for browsing openings
        addBrowseButton();

        // initializes json stuff
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);


        addComponents();

        // redraw all the components to make sure they're all showing
        this.repaint();
        this.revalidate();
    }

    // MODIFIES: this
    // EFFECTS: adds all of the buttons and labels into the JFrame
    private void addComponents() {
        this.add(titleLabel);
        this.add(addButton);
        this.add(saveButton);
        this.add(loadButton);
        this.add(savedStatusLabel);
        this.add(browseButton);
    }

    // MODIFIES: this
    // EFFECTS: creates the button for browsing openings
    private void addBrowseButton() {
        browseButton = new JButton();
        browseButton.addActionListener(this);
        browseButton.setBounds(1000, 400, 200, 50);

        browseButton.add(new JLabel("Browse Openings"));
    }

    // MODIFIES: this
    // EFFECTS: creates the button for loading openings
    private void addLoadButton() {
        loadButton = new JButton();
        loadButton.addActionListener(this);
        loadButton.setBounds(1000, 300, 200, 50);
        loadButton.add(new JLabel("Load Openings"));
    }

    // MODIFIES: this
    // EFFECTS: creates the button for saving openings
    private void addSaveButton() {
        saveButton = new JButton();
        saveButton.addActionListener(this);
        saveButton.setBounds(1000, 200, 200, 50);
        saveButton.add(new JLabel("Save Openings"));
    }

    // MODIFIES: this
    // EFFECTS: creates the button for adding openings
    private void addAddButton() {
        addButton = new JButton();
        addButton.addActionListener(this);
        addButton.setBounds(1000, 100, 200, 50);
        addButton.add(new JLabel("Add Openings"));
    }

    // MODIFIES: this
    // EFFECTS: creates the save status label
    private void addSaveLabel() {
        savedStatusLabel = new JLabel(" ");
        savedStatusLabel.setBounds(500, 500, 500, 50);
        savedStatusLabel.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates title and logo
    private void addTitle() {
        databaseLogo = new ImageIcon("./src/main/ui/chessopeningdatabaseicon.png");
        titleLabel = new JLabel("Chess Opening Database");
        titleLabel.setBounds(200, 100, 400, 300);
        titleLabel.setIcon(databaseLogo);
        titleLabel.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up frame's title, close operation, size and visibility
    private void setupFrame() {
        this.setTitle("Opening Database App");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    // EFFECTS: saves the opening database as a json file in the data folder
    private void saveOpenings() {
        try {
            jsonWriter.open();
            jsonWriter.write(openingDatabase);
            jsonWriter.close();

            savedStatusLabel.setText("Database saved to " + JSON_STORE);
            System.out.println("Saved opening database to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
            savedStatusLabel.setText("Unable to write file to " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads opening database from file
    private void loadOpenings() {
        try {
            openingDatabase = jsonReader.read();
            savedStatusLabel.setText("Loaded openings from " + JSON_STORE);
        } catch (IOException e) {
            savedStatusLabel.setText("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: processes the user's button input
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            this.setVisible(false);
            AddFrame addMenu = new AddFrame(openingDatabase);
            this.dispose();
        } else if (e.getSource() == saveButton) {
            saveOpenings();
        } else if (e.getSource() == loadButton) {
            loadOpenings();
        } else if (e.getSource() == browseButton) {
            this.setVisible(false);
            BrowseFrame browseFrame = new BrowseFrame(openingDatabase);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    // EFFECTS: prints out event logs on window close
    @Override
    public void windowClosing(WindowEvent e) {
        for (model.Event next : EventLog.getInstance()) {
            System.out.println(next.getDate());
            System.out.println(next.getDescription());
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
