package lamoreaux_landon.catcafe;

public class Empty extends FloorArea {
    Empty() {
        weeklyCost = -10;
        name = "-E-\n-$" + Math.abs(weeklyCost);
        totalCost = 0;
    }

    public void nextWeek()
    {
        totalCost += weeklyCost;
    }

    public String getInfo(int week)
    {
        return "Empty" + "\nFloor Changed: " + week + "\nFloor Age: " + week + "\nTotal Cost: " + totalCost + "\nTotal Revenue: " + 0;
    }
}
