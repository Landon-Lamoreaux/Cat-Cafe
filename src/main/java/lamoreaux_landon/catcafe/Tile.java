package lamoreaux_landon.catcafe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tile {

    private FloorArea floorarea;
    private PropertyChangeSupport subject;

    private int x;
    private int y;

    Tile(int xx, int yy) {
        floorarea = new Empty();
        subject = new PropertyChangeSupport(this);
        x = xx;
        y = yy;
    }

    // GRADING: SUBJECT
    public void addObserver(PropertyChangeListener obv) {
        subject.addPropertyChangeListener(obv);
    }
    public void removeObserver(PropertyChangeListener obv) { subject.removePropertyChangeListener(obv); }

    public Tile getMe() { return this; }
    public int nextWeek(Layout layout) {
        int additionCost = 0;
        floorarea.nextWeek();
        if( (floorarea instanceof Cat || floorarea instanceof Kitten || floorarea instanceof Lion || floorarea instanceof Flerken) && floorarea.countdown == 0)
        {
            additionCost = -200;
            if (floorarea instanceof Cat) {
                floorarea = new Cat();
            }
            else if (floorarea instanceof Kitten){
                floorarea = new Kitten();
            }
            else if (floorarea instanceof Lion){
                floorarea = new Lion();
                additionCost = -300;
            }
            else {
                floorarea = new Flerken();
                additionCost = -225;
            }
            layout.adopted++;
        }

        // GRADING: TRIGGER
        subject.firePropertyChange("Tile Change", null, floorarea);
        return floorarea.weeklyCost + additionCost + floorarea.weeklyRevenue;
    }

    public int pressed(String selection, Layout layout) {
        switch (selection) {
            case "Table":
                floorarea = new Table();
                break;
            case "Cat":
                floorarea = new Cat();
                break;
            case "Kitten":
                floorarea = new Kitten();
                break;
            case "Empty":
                int cost = -200;
                if (floorarea instanceof Empty)
                    cost = 0;
                floorarea = new Empty();
                floorarea.totalCost = cost;
                break;
            case "View":
                layout.setVertInfo(floorarea.getInfo(layout.week) + "\n(" + (x + 1) + ", " + (y + 1) + ")");
                break;
            case "Lion":
                floorarea = new Lion();
                break;
            case "Flerken":
                floorarea = new Flerken();
                break;
        }

        // GRADING: TRIGGER
        subject.firePropertyChange("Tile Change", null, floorarea);
        return floorarea.totalCost;
    }


    public String getFloorArea()
    {
        if (floorarea instanceof Table)
        {
            return "Table";
        }
        else if (floorarea instanceof Cat)
        {
            return "Cat";
        }
        else if (floorarea instanceof Kitten)
        {
            return "Kitten";
        }
        else if (floorarea instanceof Empty)
        {
            return "Empty";
        }
        else if (floorarea instanceof Lion)
        {
            return "Lion";
        }
        else if (floorarea instanceof Flerken)
        {
            return "Flerken";
        }
        return " ";
    }


    @Override
    public String toString() {
        return floorarea.toString();
    }
}
