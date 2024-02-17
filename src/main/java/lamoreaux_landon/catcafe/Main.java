package lamoreaux_landon.catcafe;

/*
Complete the following checklist. If you partially completed an item, put a note how it can be checked for what is working for partial credit.


__Yes__ Followed the class OOP diagram
--Yes-- Observer pattern (ignores tiers)


__Yes__ 1.	Tier: Views and tile area
__Yes__ a. All objects (ignoring the sim area) (-1 for each missing)
__Yes__ b. Have a starting number of tiles in sim area
__Yes__ c. Able to add/remove a tile area properly (-33% for each error)
__Yes__ d. Info bar listed correctly with all the required elements (-25% for each error)
__Yes__ f. Tile Text correct in tile area (-25% per error)
__Yes__ g. Radio buttons update properly
__Yes__ h. Selecting a rectangle with “view” updates the tile area info (-50% per error)


__Yes__ 2a Tier: Advanced functionality
__Yes__ a. Next week button has some noticeable effect*
__Yes__ b. Tile areas updated properly on “next” (-33% per error)*
__Yes__ c. Sim info bar updated properly (-25% per error)
__Yes__ d. Selecting a tile after an update shows the new information


__Yes__ 2b: Layout
__Yes__ a. Location of all items in correct spot (-20% per error)
__Yes__ b. Layout still correct on window resize (-20%  for minor error)
__Yes__ c. Resize grid at minimum resets the grid and info (-50% if minor error)
__Yes__ d. Everything still working that is listed above with resize (-50% if minor error)



Final Tier: Extensions 30
Extension 1: 2.a 5pts, added an x,y coordinate to the info panel of each tile.
Extension 2: 2.d 10pts, each tile has a different color.
Extension 3: 2.e 5pts, Every tile has a colored border.
Extension 4: 3.a 10pts, Hitting any number key will resize the grid to that number by that number. You can also hit 'R' to increment the week.
Extension 5: 4.a 5pts, Added a Lion and Flerken tile type to the simulator.
 - Added this extra one in case one of the other ones didn't count ^^.


The grade you compute is the starting point for course staff, who reserve the right to change the grade if they disagree with your assessment and to deduct points for other issues they may encounter, such as errors in the submission process, naming issues, etc.

 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.Screen;

import java.io.IOException;

public class Main extends Application {
    private Layout layout;


    @Override
    public void start(Stage stage) throws IOException {
        int i;
        int x = (int)Screen.getPrimary().getBounds().getMaxX();
        int y = (int)Screen.getPrimary().getBounds().getMaxY();
        layout = new Layout();
        Scene scene = new Scene(layout.root, x*0.65, y*0.5);

        // Setting an array of the resizing key codes.
        KeyCode[] keycode = new KeyCode[]{KeyCode.DIGIT1, KeyCode.DIGIT2, KeyCode.DIGIT3, KeyCode.DIGIT4, KeyCode.DIGIT5, KeyCode.DIGIT6, KeyCode.DIGIT7, KeyCode.DIGIT8, KeyCode.DIGIT9};

        // Setting the key combinations and binding them to an action.
        KeyCombination[] keys = new KeyCodeCombination[9];
        for(i = 0; i < 9; i++)
        {
            keys[i] = new KeyCodeCombination(keycode[i]);
            layout.resizeButton[i].getScene().getAccelerators().put(keys[i], layout.resizeButton[i]::fire);
        }

        KeyCombination keyForward = new KeyCodeCombination(KeyCode.R);
        layout.nextweek.getScene().getAccelerators().put(keyForward, layout.nextweek::fire);

        stage.setTitle("Cat Cafe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}