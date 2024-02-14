package lamoreaux_landon.catcafe;

public class Lion extends FloorArea {

    Lion() {
        weeklyCost = -80;
        age = 75;
        countdown = 24;
        weeklyRevenue = 90;
        name = "-L-\n-$" + Math.abs(weeklyCost) + "\n$" + weeklyRevenue + " " + countdown;
        totalCost = -300;
    }

    public void nextWeek() {
        countdown--;
        age++;
        totalCost += weeklyCost;
        totalRevenue += weeklyRevenue;
        name = "-L-\n-$" + Math.abs(weeklyCost) + "\n$" + weeklyRevenue + " " + countdown;
    }

    public String getInfo(int week)
    {
        return "Lion" + "\nFloor Changed: " + week + "\nFloor Age: " + week + "\nTotal Cost: " + totalCost + "\nTotal Revenue: " + totalRevenue + "\nLion Age " + age + "\nWeeks Until Adoption: " + countdown;
    }
}
