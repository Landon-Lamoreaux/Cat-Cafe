package lamoreaux_landon.catcafe;

public class Flerken extends FloorArea {
    Flerken() {
        weeklyCost = -20;
        age = 32;
        countdown = 7;
        name = "-F-\n-$" + Math.abs(weeklyCost) + "\n" + countdown;
        totalCost = -225;
    }

    public void nextWeek() {
        countdown--;
        age++;
        totalCost += weeklyCost;
        totalRevenue += weeklyRevenue;
        name = "-F-\n-$" + Math.abs(weeklyCost) + "\n" + countdown;
    }

    public String getInfo(int week)
    {
        return "Flerken" + "\nFloor Changed: " + week + "\nFloor Age: " + week + "\nTotal Cost: " + totalCost + "\nLion Age " + age + "\nWeeks Until Adoption: " + countdown;
    }
}
