package ui;

import model.OpeningDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistence.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Menu Page UI
public class MenuFrame extends JFrame implements ActionListener {

    private JButton addButton;
    private JButton browseButton;
    private JButton saveButton;
    private JButton loadButton;


    private JLabel titleLabel;
    private JLabel savedStatusLabel;
    private JLabel databaseIcon;

    private OpeningDatabase openingDatabase;

    private static final String JSON_STORE = "./data/databasefile.json";

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private ImageIcon databaseLogo;

    MenuFrame(OpeningDatabase database) {

        openingDatabase = database;

        // TODO: refactor into constants
        this.setTitle("Opening Database App");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 1080);
        this.setVisible(true);

        databaseLogo = new ImageIcon(getClass().getResource("chessopeningdatabaseicon.png"));

        // add title
        titleLabel = new JLabel("Chess Opening Database");
        titleLabel.setBounds(200, 50, 200, 300);
        titleLabel.setIcon(databaseLogo);
        titleLabel.setVisible(true);


        // save labels
        savedStatusLabel = new JLabel(" ");
        savedStatusLabel.setBounds(500, 500, 500, 50);
        savedStatusLabel.setVisible(true);

        // add button for adding
        addButton = new JButton();
        addButton.addActionListener(this);
        addButton.setBounds(1000, 100, 200, 50);
        addButton.add(new Label("Add Openings"));

        // add button for saving
        saveButton = new JButton();
        saveButton.addActionListener(this);
        saveButton.setBounds(1000, 200, 200, 50);
        saveButton.add(new Label("Save Openings"));

        // add button for loading openings
        loadButton = new JButton();
        loadButton.addActionListener(this);
        loadButton.setBounds(1000, 300, 200, 50);
        loadButton.add(new Label("Load Openings"));

        // add button for browsing openings
        browseButton = new JButton();
        browseButton.addActionListener(this);
        browseButton.setBounds(1000, 400, 200, 50);
        browseButton.add(new Label("Browse Openings"));

        // initializes json stuff
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);


        this.add(titleLabel);
        this.add(addButton);
        this.add(saveButton);
        this.add(loadButton);
        this.add(savedStatusLabel);
        this.add(browseButton);

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
            System.out.println("Loaded openings from " + JSON_STORE);
            savedStatusLabel.setText("Loaded openings from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
            savedStatusLabel.setText("Unable to read from file: " + JSON_STORE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            System.out.println("Opening Add Screen");
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
}
