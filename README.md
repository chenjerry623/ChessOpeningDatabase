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

FOR GUI VERSION:
- As a user, I want to be able to add multiple Openings to an Opening Database
- As a user, I want to be able to load and save the state of the application
- As a user, I want to be able to delete an opening from the database
- As a user, I want to be able to add a win/loss/draw to an opening

## Instructions for Use (GUI Version)

How to view all openings added to the database:
1. Run main.
2. Press the "Browse Openings" button to enter the opening browsing screen.

### How to add multiple openings to an opening database:
1. Run main.
2. Press the "Add Openings" button to enter the opening adding screen.
3. Enter the desired name into the name field.
4. Enter the desired amount of wins, losses and draws to the respective fields.
5. Once finished, click the "Submit Opening" button, an opening has now been added to the database.
6. To add another opening, either stay on the opening adding screen and repeat from step 3 
    OR
    press the "Return to Menu" button to return the menu, then repeat from step 2.

### How to delete an opening:
1. Run main.
2. If the database is empty, use the instructions from earlier to add opening(s) to the database.
3. Press the "Browse Openings" button to enter the opening browsing screen.
4. Using your mouse, click on an opening from the list
5. Click the "Delete Opening" button.

### How to add a win to an opening (second required action):
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


Citation: JsonReader and JsonWriter related classes all took inspiration from the JsonSerializationDemo project
from the CPSC210 edx course(https://edge.edx.org/courses/course-v1:UBC+CPSC210+all/)
