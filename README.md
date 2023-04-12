# Chess Opening Database

## A Personal Project by Jerry Chen

This is a program capable of storing/loading databases of chess openings.
These databases can be used to:
- store the user's success rate with an opening 
  - win/loss/draw count
- add results from matches and update the database
- sort openings by criteria such as wins, losses, draws and matches
- save and load databases of openings



The database will also allow the user to add or edit information on openings 
and also load past databases. The database can also be filtered and browsed 
through the criteria listed above.

**Why did I choose to make this project?**

Chess is a game that I grew up playing and still keep as hobby today. It's often hard to decide
which openings to play and study, with so many available to learn. 
This database helps with this problem by helping track which openings you play the most
and find the most success with.

**User Stories**
- As a user, I want to view my win/loss/draws and total games with an opening
- As a user, I want to sort my openings in ascending/descending order of wins/losses/draws/matches
- As a user, I want to add multiple new openings to the database
- As a user, I want to add a result to an opening

- As a user, I want to be able to save my opening database to file
- As a user, I want to be able to be able to load my to-do list from file

PHASE 3:
- As a user, I want to be able to add multiple Openings to an Opening Database
- As a user, I want to be able to load and save the state of the application
- As a user, I want to be able to delete an opening from the database
- As a user, I want to be able to add a win/loss/draw to an opening

## Instructions for Grader

How to view all openings added to the database:
1. Run main.
2. Press the "Browse Openings" button to enter the opening browsing screen.

### First related action to adding Xs to Ys (if this counts):
How to add multiple openings to an opening database:
1. Run main.
2. Press the "Add Openings" button to enter the opening adding screen.
3. Enter the desired name into the name field.
4. Enter the desired amount of wins, losses and draws to the respective fields.
5. Once finished, click the "Submit Opening" button, an opening has now been added to the database.
6. To add another opening, either stay on the opening adding screen and repeat from step 3 
    OR
    press the "Return to Menu" button to return the menu, then repeat from step 2.


### First related action to adding Xs to Ys (if adding openings to database doesn't count):
How to delete an opening:
1. Run main.
2. If the database is empty, use the instructions from earlier to add opening(s) to the database.
3. Press the "Browse Openings" button to enter the opening browsing screen.
4. Using your mouse, click on an opening from the list
5. Click the "Delete Opening" button.

### Second related action to adding Xs to Ys:
How to add a win to an opening (second required action):
1. Run main.
2. If the database is empty, use the instructions from earlier to add opening(s) to the database.
3. Press the "Browse Openings" button to enter the opening browsing screen.
4. Using your mouse, click on an opening from the list.
5. Click the "Add Win" button.

### How to locate visual component:
1. Run main.
2. there's an image of a chess piece on the left hand side of the screen.

### How to save state of the application:
1. Run main
2. If there's no openings in the database yet, add some through the "Add Openings" button.
3. Click the "Save Openings" button.

### How to reload state of the application:
1. Run main
2. Click the "Load Openings" button.

## Phase 4: Task 2
QGD added to opening database

deez added to opening database

example added to opening database

King's Indian added to opening database

Win added to King's Indian

Loss added to deez

Draw added to QGD

deez removed from opening database

example removed from opening database

Ruy Lopez added to opening database

Win added to Ruy Lopez

## Phase 4: Task 3

If I had extra time to work on this project, I would extract some of my code into
helper functions in order to make it easier to understand. For instance, in AddFrame's
actionPerformed function, I would create a helper function for processing the text fields
and creating a new opening, rather than leaving the code in the if statement. 

Additionally, I would make an abstract UIFrame class which all of my window classes (BrowseFrame, AddFrame,
MenuFrame) would extend. This class would contain the constant values WIDTH and HEIGHT as well
as a constructor which sets the class' database value to the input database, adds a window listener
and calls SetupFrame(). This will eliminate duplicate code and ensure that every UI window
will have the same setup parameters if more were to be added in the future. 

Finally, I would use the singleton design pattern for my OpeningDatabase class so that it can be 
accessed universally throughout the code. This means that I would be able to access data about my OpeningDatabase
from any Frame without having to have an OpeningDatabase get passed in as a parameter.

Citation: JsonReader and JsonWriter related classes all took inspiration from the JsonSerializationDemo project
from edx