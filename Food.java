import java.util.List;

public class Food implements FoodInterface{
    private String name;
    private List<String> nutrition;

    public Food (String name, List<String> nutrition){
        this.name = name;
        this.nutrition = nutrition;
    }

    public String getName() {
        return name;
    }

    public List<String> getNutrition() {
        return nutrition;
    }
    
}
