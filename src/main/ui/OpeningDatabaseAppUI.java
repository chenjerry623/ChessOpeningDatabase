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

    // database's initial menu window
    private MenuFrame menuFrame;

    private OpeningDatabase openings; // current opening database

    // EFFECTS: runs the opening database application
    public OpeningDatabaseAppUI() {
    }

    // MODIFIES: this
    // EFFECTS: creates opening database and launches menu page
    public void runApp() {
        openings = new OpeningDatabase();
        menuFrame = new MenuFrame(openings);
    }



}