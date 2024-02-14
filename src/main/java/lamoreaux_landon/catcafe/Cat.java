package lamoreaux_landon.catcafe;

public class Cat extends FloorArea{

    Cat() {
        weeklyCost = -30;
        age = 52;
        countdown = 8;
        name = "-C-\n-$" + Math.abs(weeklyCost) + "\n" + countdown;
        totalCost =-200;
    }
    public void nextWeek() {
        countdown--;
        age++;
        totalCost += weeklyCost;
        name = "-C-\n-$" + Math.abs(weeklyCost) + "\n" + countdown;
    }

    public String getInfo(int week)
    {
        return "Cat" + "\nFloor Changed: " + week + "\nFloor Age: " + week + "\nTotal Cost: " + totalCost + "\nCat Age " + age + "\nWeeks Until Adoption: " + countdown;
    }
}
