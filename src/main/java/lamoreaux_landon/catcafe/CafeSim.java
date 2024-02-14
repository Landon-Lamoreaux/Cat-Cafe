package lamoreaux_landon.catcafe;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public class CafeSim {

    public Tile[] tiles;
    private int timeSinceReset;

    public CafeSim() {
        timeSinceReset = 0;
        resetTiles(9);
    }

    public void resetTiles(int numTiles)
    {
        int i;

        tiles = new Tile[numTiles];
        for(i = 0; i < numTiles; i++)
        {
            tiles[i] = new Tile(i%(int)Math.sqrt(numTiles), i/(int)Math.sqrt(numTiles));
        }
        timeSinceReset = 0;
    }

    public int nextWeek(Layout layout) {
        int i;
        int cost = 0;
        timeSinceReset++;

        for(i = 0; i < tiles.length; i++)
        {
            cost += tiles[i].nextWeek(layout);
        }
        return cost;
    }

    public int countFilled() {
        int filled = tiles.length;
        int i;

        for (i = 0; i < tiles.length; i++)
        {
            if(Objects.equals(tiles[i].getFloorArea(), "Empty"))
            {
                filled--;
            }
        }
        return filled;
    }
}