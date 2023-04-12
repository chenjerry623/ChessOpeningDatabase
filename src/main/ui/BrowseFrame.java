package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

// UI for browsing openings window
public class BrowseFrame extends JFrame implements ActionListener, WindowListener {

    // current opening database state
    private OpeningDatabase openingDatabase;

    // buttons for returning to menu and operating on openings
    private JButton returnMenuButton;
    private JButton deleteButton;
    private JButton addWinButton;
    private JButton addLossButton;
    private JButton addDrawButton;

    // table of openings and scrollpane to hold the table
    private JTable openingList;
    private JScrollPane listHolder;


    // constants to store column names of table
    private static final String[] COLUMNNAMES = {"NAME", "WINS", "LOSSES", "DRAWS"};

    // constants to store the window size
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 750;


    // MODIFIES: this
    // EFFECTS: creates the window for browsing openings
    BrowseFrame(OpeningDatabase database) {
        this.openingDatabase = database;
        addWindowListener(this);

        makeTable();

        setupFrame();

        makeMenuButton();

        makeWinButton();

        makeLossButton();

        makeDrawButton();

        makeDeleteButton();


        addComponents();
    }

    // MODIFIES: this
    // EFFECTS: adds buttons and labels to the JFrame
    private void addComponents() {
        this.add(returnMenuButton);
        this.add(listHolder);
        this.add(deleteButton);
        this.add(addWinButton);
        this.add(addLossButton);
        this.add(addDrawButton);
    }

    // MODIFIES: this
    // EFFECTS: adds button for deleting openings
    private void makeDeleteButton() {
        deleteButton = new JButton();
        deleteButton.addActionListener(this);
        deleteButton.setBounds(1000, 400, 200, 50);
        deleteButton.add(new JLabel("Delete Opening"));
    }

    // MODIFIES: this
    // EFFECTS: adds button for adding a draw to an opening
    private void makeDrawButton() {
        addDrawButton = new JButton();
        addDrawButton.addActionListener(this);
        addDrawButton.setBounds(1000, 300, 200, 50);
        addDrawButton.add(new JLabel("Add Draw"));
    }

    // MODIFIES: this
    // EFFECTS: adds button for adding a loss to an opening
    private void makeLossButton() {
        addLossButton = new JButton();
        addLossButton.addActionListener(this);
        addLossButton.setBounds(1000, 200, 200, 50);
        addLossButton.add(new JLabel("Add Loss"));
    }

    // MODIFIES: this
    // EFFECTS: adds button for adding a win to an opening
    private void makeWinButton() {
        addWinButton = new JButton();
        addWinButton.addActionListener(this);
        addWinButton.setBounds(1000, 100, 200, 50);
        addWinButton.add(new JLabel("Add Win"));
    }

    // MODIFIES: this
    // EFFECTS: setups up the frame's title, layout, close operation, size and visibility
    private void setupFrame() {
        this.setTitle("Opening Database App");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates a button to return the user to the main menu
    private void makeMenuButton() {
        returnMenuButton = new JButton();
        returnMenuButton.addActionListener(this);
        returnMenuButton.setBounds(1000, 500, 200, 50);
        returnMenuButton.add(new JLabel("Return to Menu"));
    }

    // MODIFIES: this
    // EFFECTS: creates a table and a scrollpane to hold it
    private void makeTable() {
        openingList = new JTable(openingDatabase.convertToArray(), COLUMNNAMES);
        openingList.setBounds(200, 50, 700, 700);

        listHolder = new JScrollPane(openingList);
        listHolder.setSize(700, 700);
    }


    // MODIFIES: this
    // EFFECTS: processes the user's interaction
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnMenuButton) {
            returnToMenu();
        } else if (e.getSource() == deleteButton) {
            int selectedRow = openingList.getSelectedRow();
            openingDatabase.deleteOpening(selectedRow);
            reloadBrowse();
        } else if (e.getSource() == addWinButton) {
            int selectedRow = openingList.getSelectedRow();
            openingDatabase.getOpening(selectedRow).addUserResult(Side.WHITE, Result.WIN);
            reloadBrowse();
        } else if (e.getSource() == addLossButton) {
            int selectedRow = openingList.getSelectedRow();
            openingDatabase.getOpening(selectedRow).addUserResult(Side.WHITE, Result.LOSS);
            reloadBrowse();
        } else if (e.getSource() == addDrawButton) {
            int selectedRow = openingList.getSelectedRow();
            openingDatabase.getOpening(selectedRow).addUserResult(Side.WHITE, Result.DRAW);
            reloadBrowse();
        }
    }

    // MODIFIES: this
    // EFFECTS: opens up a new browse window, then deletes the old instance
    private void reloadBrowse() {
        this.setVisible(false);
        BrowseFrame browseFrame = new BrowseFrame(openingDatabase);
        this.dispose();
    }

    // MODIFIES: this
    // EFFECTS: opens up the menu window, then deletes the browse window
    private void returnToMenu() {
        this.setVisible(false);
        MenuFrame menuFrame = new MenuFrame(openingDatabase);
        this.dispose();
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
