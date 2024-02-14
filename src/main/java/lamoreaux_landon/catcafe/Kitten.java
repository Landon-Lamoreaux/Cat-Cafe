package lamoreaux_landon.catcafe;

public class Kitten extends FloorArea {

    Kitten() {
        weeklyCost = -20;
        age = 10;
        countdown = 4;
        name = "-K-\n-$" + Math.abs(weeklyCost) + "\n" + countdown;
        totalCost = -200;
    }

    public void nextWeek() {
        countdown--;
        age++;
        totalCost += weeklyCost;
        name = "-K-\n-$" + Math.abs(weeklyCost) + "\n" + countdown;
    }

    public String getInfo(int week)
    {
        return "Kitten" + "\nFloor Changed: " + week + "\nFloor Age: " + week + "\nTotal Cost: " + totalCost + "\nCat Age " + age + "\nWeeks Until Adoption: " + countdown;
    }
}
