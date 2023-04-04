package ui;

import model.EventLog;
import model.Opening;
import model.OpeningDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

// UI screen for adding openings
public class AddFrame extends JFrame implements ActionListener, WindowListener {

    // the current opening database
    private OpeningDatabase openingDatabase;

    // text field for inputting name
    private JTextField nameField;

    // labels for title, win/draw/loss and feedback when an opening is added
    private JLabel titleLabel;
    private JLabel winLabel;
    private JLabel drawLabel;
    private JLabel lossLabel;
    private JLabel addedOpeningLabel;

    // buttons for returning to menu and submitting an opening
    private JButton returnMenuButton;
    private JButton submitOpeningButton;

    // inputs for wins/draws/losses
    private SpinnerModel winInput;
    private SpinnerModel drawInput;
    private SpinnerModel lossInput;
    private JSpinner winSelect;
    private JSpinner drawSelect;
    private JSpinner lossSelect;

    // constants for window size
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 750;


    // MODIFIES: this
    // EFFECTS: creates the window for adding new openings to the database
    AddFrame(OpeningDatabase database) {
        this.openingDatabase = database;
        addWindowListener(this);

        setupFrame();

        // makes title label
        makeTitle();

        // makes button for menu
        makeMenuButton();

        // makes the button for submitting an opening
        makeSubmitButton();

        // makes name input
        makeNameInput();

        // wins label and selector
        makeWinInput();

        // losses label and selector
        makeLossInput();

        // draw label and selector
        makeDrawInput();

        // alert user that opening has been added
        addedOpeningLabel = new JLabel("...");
        addedOpeningLabel.setBounds(200, 650, 200, 50);
        addedOpeningLabel.setVisible(false);


        // add button and label to the frame
        addComponents();


    }

    // MODIFIES: this
    // EFFECTS: adds buttons and labels into the JFrame
    private void addComponents() {
        this.add(returnMenuButton, BorderLayout.EAST);
        this.add(titleLabel);
        this.add(nameField);
        this.add(submitOpeningButton);
        this.add(winSelect);
        this.add(winLabel);
        this.add(lossSelect);
        this.add(lossLabel);
        this.add(drawSelect);
        this.add(drawLabel);
        this.add(addedOpeningLabel);
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

    // MODIFIES: this
    // EFFECTS: sets up a text field that takes the user's Draws input
    private void makeDrawInput() {
        drawInput = new SpinnerNumberModel();
        drawLabel = new JLabel("Draws");
        drawLabel.setBounds(200, 300, 100, 50);
        drawSelect = new JSpinner(drawInput);
        drawSelect.setBounds(200, 350, 100, 50);
    }

    // MODIFIES: this
    // EFFECTS: sets up a text field that takes the user's Losses input
    private void makeLossInput() {
        lossInput = new SpinnerNumberModel();
        lossLabel = new JLabel("Losses");
        lossLabel.setBounds(200, 200, 100, 50);
        lossSelect = new JSpinner(lossInput);
        lossSelect.setBounds(200, 250, 100, 50);
    }

    // MODIFIES: this
    // EFFECTS: sets up a text field that takes the user's Wins input
    private void makeWinInput() {
        winInput = new SpinnerNumberModel();
        winLabel = new JLabel("Wins");
        winLabel.setBounds(200, 100, 100, 50);
        winSelect = new JSpinner(winInput);
        winSelect.setBounds(200, 150, 100, 50);
    }

    // MODIFIES: this
    // EFFECTS: sets up a text field that takes the user's Name input
    private void makeNameInput() {
        nameField = new JTextField("name");
        nameField.setBounds(200, 50, 100, 50);
        nameField.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: creates a button for the user to submit an opening with
    private void makeSubmitButton() {
        submitOpeningButton = new JButton();
        submitOpeningButton.addActionListener(this);
        submitOpeningButton.setBounds(200, 600, 200, 50);
        submitOpeningButton.add(new JLabel("Add Opening"));
    }

    // MODIFIES: this
    // EFFECTS: creates a button for the user to return to the main menu
    private void makeMenuButton() {
        returnMenuButton = new JButton();
        returnMenuButton.addActionListener(this);
        returnMenuButton.setBounds(1000, 500, 200, 50);
        returnMenuButton.add(new JLabel("Return to Menu"));
    }

    // MODIFIES: this
    // EFFECTS: creates a title lable
    private void makeTitle() {
        titleLabel = new JLabel("Add an Opening");
        titleLabel.setBounds(200, 0, 100, 50);
    }

    // MODIFIES: this
    // EFFECTS: processes the user's button input
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnMenuButton) {
            this.setVisible(false);
            MenuFrame menuFrame = new MenuFrame(openingDatabase);
            this.dispose();
        } else if (e.getSource() == submitOpeningButton) {
            String newName = nameField.getText();
            int newWins = (int) winSelect.getValue();
            int newDraws = (int) drawSelect.getValue();
            int newLosses = (int) lossSelect.getValue();
            Opening newOpening = new Opening(newName, newWins, newLosses, newDraws);
            openingDatabase.addOpening(newOpening);
            addedOpeningLabel.setText(newName + " added to database");
            addedOpeningLabel.setVisible(true);
        }
    }

    // EFFECTS: prints out the events
    public void printLog(EventLog el) {
        for (model.Event next : el) {
            System.out.println(next.getDescription());
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        for (model.Event next : EventLog.getInstance()) {
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
