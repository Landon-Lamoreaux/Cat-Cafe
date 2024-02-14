package lamoreaux_landon.catcafe;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Layout {
    Label topInfo;
    Label vertInfo;
    GridPane bottomPanel;
    GridPane root;
    GridPane hgrid;
    GridPane grid;
    CafeSimView cafeView;
    Controller controller;
    Button[] resizeButton;
    Button nextweek;

    ToggleGroup group;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioButton r5;
    RadioButton r6;
    RadioButton r7;
    Integer week = 0;
    Integer filled = 0;
    Integer funds = 0;
    Integer adopted = 0;
    CafeSim sim;

    public Layout() {
        int i;
        sim = new CafeSim();
        cafeView = new CafeSimView(sim);

        group = new ToggleGroup();
        root = new GridPane();

        resizeButton = new Button[9];
        for (i = 0; i < 9; i++) {
            resizeButton[i] = new Button((i + 1) + "x" + (i + 1));
        }

        r1 = new RadioButton("Table");
        r2 = new RadioButton("Cat");
        r3 = new RadioButton("Kitten");
        r4 = new RadioButton("Empty");
        r5 = new RadioButton("View");
        r6 = new RadioButton("Lion");
        r7 = new RadioButton("Flerken");

        nextweek = new Button("Next Week");

        topInfo = new Label("Week: " + week + "\nFilled: " + filled + "\nFunds: $" + funds + "\nAdopted: " + adopted);
        topInfo.setScaleY(1);
        topInfo.setScaleX(1);
        vertInfo = new Label("");

        sceneBuilder(9);
        controller = new Controller(sim, this);
    }

    public void sceneBuilder(int numButtons)
    {
        root.getChildren().clear();
        root.getColumnConstraints().clear();
        root.getRowConstraints().clear();

        // Make all the buttons the same height.
        RowConstraints rc1 = new RowConstraints();
        rc1.setVgrow(Priority.ALWAYS);
        rc1.setFillHeight(true);

        // Make the buttons all the same width.
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setFillWidth(true);
        col1.setHalignment(HPos.CENTER);

        cafeView = new CafeSimView(sim);

        grid = cafeView.createSimArea(numButtons);

        root.setAlignment(Pos.CENTER);
        root.setHgap(1);
        root.setVgap(1);

        // Setting up constraints.
        RowConstraints grc1 = new RowConstraints();
        grc1.setPercentHeight(15);
        grc1.setFillHeight(true);
        RowConstraints grc2 = new RowConstraints();
        grc2.setPercentHeight(70);
        grc2.setFillHeight(true);
        grc2.setVgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(col1);
        root.getRowConstraints().addAll(grc1, grc2, grc1);

        // Adding the top information panel.
        topInfo.setTextFill(Color.valueOf("1F83E7FF"));
        topInfo.setAlignment(Pos.CENTER);
        root.add(topInfo, 0, 0);

        // Creating the vertical information panel.
        vertInfo.setAlignment(Pos.CENTER);

        // Creating and setting up the horizontal grid.
        hgrid = new GridPane();
        ColumnConstraints hcol1 = new ColumnConstraints();
        hcol1.setPercentWidth(15);
        hcol1.setHalignment(HPos.CENTER);
        ColumnConstraints hcol2 = new ColumnConstraints();
        hcol2.setPercentWidth(85);
        hgrid.getRowConstraints().add(rc1);
        hgrid.getColumnConstraints().addAll(hcol1, hcol2);
        hgrid.add(vertInfo, 0, 0);
        hgrid.add(grid, 1, 0);
        root.add(hgrid, 0, 1);

        // Adding the bottom information panel to the grid.
        bottomPanelBuilder(root, bottomPanel);
    }

    private void bottomPanelBuilder(GridPane root, GridPane panel)
    {
        int i;
        panel = new GridPane();
        panel.setAlignment(Pos.CENTER);

        ColumnConstraints colleft = new ColumnConstraints();
        colleft.setPercentWidth(15);
        ColumnConstraints colmid = new ColumnConstraints();
        colmid.setPercentWidth(60);
        colmid.setHalignment(HPos.CENTER);
        ColumnConstraints colright = new ColumnConstraints();
        colright.setPercentWidth(25);
        panel.getColumnConstraints().addAll(colleft, colmid, colright);

        RowConstraints rowtop = new RowConstraints();
        rowtop.setPercentHeight(50);
        rowtop.setValignment(VPos.CENTER);
        RowConstraints rowbottom = new RowConstraints();
        rowbottom.setPercentHeight(50);
        rowbottom.setValignment(VPos.BOTTOM);
        panel.getRowConstraints().addAll(rowtop, rowbottom);

        panel.add(nextweek, 0, 1);

        // I would loop this, but I'm too lazy and it works.
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r4.setToggleGroup(group);
        r5.setToggleGroup(group);
        r6.setToggleGroup(group);
        r7.setToggleGroup(group);

        r1.setPadding(new Insets(4, 4, 4, 4));
        r2.setPadding(new Insets(4, 4, 4, 4));
        r3.setPadding(new Insets(4, 4, 4, 4));
        r4.setPadding(new Insets(4, 4, 4, 4));
        r5.setPadding(new Insets(4, 4, 4, 4));
        r6.setPadding(new Insets(4, 4, 4, 4));
        r7.setPadding(new Insets(4, 4, 4, 4));

        HBox radioBox = new HBox();

        radioBox.getChildren().add(r1);
        radioBox.getChildren().add(r6);
        radioBox.getChildren().add(r7);
        radioBox.getChildren().add(r2);
        radioBox.getChildren().add(r3);
        radioBox.getChildren().add(r4);
        radioBox.getChildren().add(r5);
        radioBox.setAlignment(Pos.CENTER);
        panel.add(radioBox, 1, 0);

        HBox hbox = new HBox();
        Label resize = new Label("Resize ");
        hbox.getChildren().add(resize);

        for(i = 0; i < 9; i++)
        {
            if(i != 2 && i != 4 && i != 8) {
                resizeButton[i].setVisible(false);
                resizeButton[i].setManaged(false);
            }
            hbox.getChildren().add(resizeButton[i]);
        }

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setSpacing(2);
        panel.add(hbox, 2, 1);

        root.add(panel, 0, 2);
    }

    public void resetTopText()
    {
        topInfo.setText("Week: " + week + "\nFilled: " + filled + "\nFunds: $" + funds + "\nAdopted: " + adopted);
    }

    public void setVertInfo(String string) {
        vertInfo.setText(string);
    }

    public void resetStoreStats()
    {
        week = 0;
        filled = 0;
        funds = 0;
        adopted = 0;
        resetTopText();
    }
}