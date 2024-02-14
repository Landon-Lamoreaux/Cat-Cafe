package lamoreaux_landon.catcafe;
import javafx.scene.control.Button;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TileView extends Button implements PropertyChangeListener {

    String info;
    Tile tile;

    TileView(Tile theTile)
    {
        tile = theTile;
        tile.addObserver(this);
        info = "-E-\n-$10";
        setText(info);
        setStyle("-fx-background-color: #B8B8B8; -fx-border-color: #969696; -fx-border-width: 4 4 4 4;");
    }

    // GRADING: OBSERVE
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        info = tile.toString();
        setText(info);
        if(info.charAt(1) == 'K') {
            setStyle("-fx-background-color: #2CB6FF; -fx-border-color: #0090DC; -fx-border-width: 4 4 4 4;");
        }
        else if(info.charAt(1) == 'T') {
            setStyle("-fx-background-color: #1CC978; -fx-border-color: #18A362; -fx-border-width: 4 4 4 4;");
        }
        else if(info.charAt(1) == 'C') {
            setStyle("-fx-background-color: #A74FFF; -fx-border-color: #8A14FF; -fx-border-width: 4 4 4 4;");
        }
        else if(info.charAt(1) == 'E') {
            setStyle("-fx-background-color: #B8B8B8; -fx-border-color: #969696; -fx-border-width: 4 4 4 4;");
        }
        else if(info.charAt(1) == 'L') {
            setStyle("-fx-background-color: #FCFF3F; -fx-border-color: #D5D803; -fx-border-width: 4 4 4 4;");
        }
        else if(info.charAt(1) == 'F') {
            setStyle("-fx-background-color: #FF9E00; -fx-border-color: #DA7E00; -fx-border-width: 4 4 4 4;");
        }
    }

    @Override
    public String toString() {
        return info;
    }
}
