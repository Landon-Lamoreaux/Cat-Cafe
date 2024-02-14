package lamoreaux_landon.catcafe;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import java.lang.Math;

public class CafeSimView{

    GridPane grid;
    CafeSim cafesim;
    TileView[] tileview;
    CafeSimView(CafeSim sim)
    {
        cafesim = sim;
    }

    // Setting up the grid button panel.
    public GridPane createSimArea(int numButtons) {
        int i;

        grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setHgap(1);
        grid.setVgap(1);

        // Make all the buttons the same height.
        RowConstraints rc1 = new RowConstraints();
        rc1.setVgrow(Priority.ALWAYS);
        rc1.setFillHeight(true);
        rc1.setPercentHeight((double) 100 / (int)Math.sqrt(numButtons));

        // Make the buttons all the same width.
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setFillWidth(true);
        col1.setPercentWidth((double) 100 / (int)Math.sqrt(numButtons));

        for(i = 0; i < Math.sqrt(numButtons); i++)
        {
            grid.getColumnConstraints().add(col1);
            grid.getRowConstraints().add(rc1);
        }

        tileview = new TileView[numButtons];
        for(i = 0; i < numButtons; i++)
        {
            tileview[i] = new TileView(cafesim.tiles[i]);
            tileview[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            grid.add(tileview[i], i%(int)Math.sqrt(numButtons), i/(int)Math.sqrt(numButtons));
        }
        return grid;
    }
}
