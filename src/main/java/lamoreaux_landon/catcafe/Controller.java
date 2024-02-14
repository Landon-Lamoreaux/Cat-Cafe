package lamoreaux_landon.catcafe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

import javax.swing.*;
import java.util.Objects;

public class Controller {
    private Layout layout;
    private CafeSim cafesim;

    public Controller(CafeSim sim, Layout layout) {
        int i;
        this.layout = layout;
        cafesim = sim;

        for(i = 0; i < 9; i++)
        {
            layout.resizeButton[i].addEventHandler(ActionEvent.ACTION, new resize());
        }

        layout.nextweek.addEventHandler(ActionEvent.ACTION, new NextWeek());
        buildSimButtonHandlers(9);
    }

    public void buildSimButtonHandlers(int numButtons)
    {
        int i;

        for(i = 0; i < numButtons; i++)
        {
            layout.cafeView.tileview[i].addEventHandler(ActionEvent.ACTION, new SimButtonPress(cafesim.tiles[i]));
        }
    }

    private class resize implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            layout.resetStoreStats();
            Button button = (Button)actionEvent.getSource();
            int size = Integer.parseInt(String.valueOf(button.getText().charAt(0)));
            cafesim.resetTiles((int) Math.pow(size, 2));
            layout.sceneBuilder((int) Math.pow(size, 2));
            buildSimButtonHandlers((int) Math.pow(size, 2));
        }
    }

    private class NextWeek implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            layout.week++;
            layout.funds += cafesim.nextWeek(layout);
            layout.filled = cafesim.countFilled();
            layout.resetTopText();
        }
    }

    private class SimButtonPress implements EventHandler<ActionEvent> {
        private Tile tile;
        SimButtonPress(Tile t)
        {
            tile = t;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            String type = tile.getFloorArea();
            String name = "";
            if (layout.group.getSelectedToggle() == null)
                return;

            name = ((RadioButton)(layout.group.getSelectedToggle())).getText();
            layout.funds += tile.pressed(name, layout);
            if((Objects.equals(name, "Table") || Objects.equals(name, "Cat") || Objects.equals(name, "Kitten")) && Objects.equals(type, "Empty"))
            {
                layout.filled++;
            }

            String newType = tile.getFloorArea();
            if (!Objects.equals(type, "Empty") && Objects.equals(newType, "Empty"))
            {
                layout.filled--;
            }
            layout.resetTopText();
        }
    }
}