package ui;

import model.Opening;
import model.OpeningDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// UI screen for adding openings
public class AddFrame extends JFrame implements ActionListener {

    private OpeningDatabase openingDatabase;

    private JTextField nameField;

    private JLabel titleLabel;
    private JLabel winLabel;
    private JLabel drawLabel;
    private JLabel lossLabel;
    private JLabel addedOpeningLabel;

    private JButton returnMenuButton;
    private JButton submitOpeningButton;

    private SpinnerModel winInput;
    private SpinnerModel drawInput;
    private SpinnerModel lossInput;

    private JSpinner winSelect;
    private JSpinner drawSelect;
    private JSpinner lossSelect;

    AddFrame(OpeningDatabase database) {
        openingDatabase = database;
        // TODO: refactor into constants
        // TODO: refactor into smaller functions
        this.setTitle("Opening Database App");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 1080);
        this.setVisible(true);

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

    private void makeDrawInput() {
        drawInput = new SpinnerNumberModel();
        drawLabel = new JLabel("Draws");
        drawLabel.setBounds(200, 300, 100, 50);
        drawSelect = new JSpinner(drawInput);
        drawSelect.setBounds(200, 350, 100, 50);
    }

    private void makeLossInput() {
        lossInput = new SpinnerNumberModel();
        lossLabel = new JLabel("Losses");
        lossLabel.setBounds(200, 200, 100, 50);
        lossSelect = new JSpinner(lossInput);
        lossSelect.setBounds(200, 250, 100, 50);
    }

    private void makeWinInput() {
        winInput = new SpinnerNumberModel();
        winLabel = new JLabel("Wins");
        winLabel.setBounds(200, 100, 100, 50);
        winSelect = new JSpinner(winInput);
        winSelect.setBounds(200, 150, 100, 50);
    }

    private void makeNameInput() {
        nameField = new JTextField("name");
        nameField.setBounds(200, 50, 100, 50);
        nameField.addActionListener(this);
    }

    private void makeSubmitButton() {
        submitOpeningButton = new JButton();
        submitOpeningButton.addActionListener(this);
        submitOpeningButton.setBounds(200, 600, 200, 50);
        submitOpeningButton.add(new Label("Add Opening"));
    }

    private void makeMenuButton() {
        returnMenuButton = new JButton();
        returnMenuButton.addActionListener(this);
        returnMenuButton.setBounds(1000, 500, 200, 50);
        returnMenuButton.add(new Label("Return to Menu"));
    }

    private void makeTitle() {
        titleLabel = new JLabel("Add an Opening");
        titleLabel.setBounds(200, 0, 100, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnMenuButton) {
            System.out.println("Returning to Menu");
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



}
