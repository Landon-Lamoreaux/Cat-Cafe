package lamoreaux_landon.catcafe;

public class Table extends FloorArea {
    Table() {
        weeklyCost = -50;
        weeklyRevenue = 150;
        name = "-T-\n-$" + Math.abs(weeklyCost) + "\n$" + weeklyRevenue;
        totalCost = -300;
        totalRevenue = 0;
    }

    public String getInfo(int week)
    {
        return "Table" + "\nFloor Changed: " + week + "\nFloor Age: " + week + "\nTotal Cost: " + totalCost + "\nTotal Revenue: " + totalRevenue;
    }

    public void nextWeek()
    {
        totalCost += weeklyCost;
        totalRevenue += 150;
    }
}
