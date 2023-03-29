package ui;

import model.Opening;
import model.OpeningDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class BrowseFrame extends JFrame implements ActionListener {

    private OpeningDatabase openingDatabase;


    private JButton returnMenuButton;

    private JTable openingList;
    private JScrollPane listHolder;

    private static final String[] COLUMNNAMES = {"NAME", "WINS", "LOSSES", "DRAWS"};

    BrowseFrame(OpeningDatabase database) {
        this.openingDatabase = database;

        openingList = new JTable(openingDatabase.convertToArray(), COLUMNNAMES);
        openingList.setBounds(200, 50, 700, 700);

        listHolder = new JScrollPane(openingList);
        listHolder.setSize(700, 700);

        this.setTitle("Opening Database App");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 1080);
        this.setVisible(true);

        returnMenuButton = new JButton();
        returnMenuButton.addActionListener(this);
        returnMenuButton.setBounds(1000, 500, 200, 50);
        returnMenuButton.add(new Label("Return to Menu"));



        this.add(returnMenuButton);
        this.add(listHolder);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnMenuButton) {
            System.out.println("Returning to Menu");
            this.setVisible(false);
            MenuFrame menuFrame = new MenuFrame(openingDatabase);
            this.dispose();
        }
    }
}
