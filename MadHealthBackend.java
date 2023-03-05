import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class MadHealthBackend implements MadHealthBackendInterface{
    private Hashtable<String, List<String>> hashtable;
    private FoodReader foodReader;
    private ArrayList<String> foodConsumed;

    public void loadData(String filename) throws FileNotFoundException {
        List<FoodInterface> foods = foodReader.readFoodsFromFile(filename);
		for (FoodInterface food : foods)
			addFoodToHashtable(food);
    }

    // key:     food name
    // value:   list of nutrition [0]~[15] Alphabetically
    public void addFoodToHashtable(FoodInterface food){
        hashtable.put(food.getName(), food.getNutrition());
    }

    public List<String> findFoods() {
        Set<String> setOfKeys = hashtable.keySet();
        for (String food : setOfKeys){
            foodConsumed.add(food);
        }
        return foodConsumed;
    }

    public List<Float> getCurrentIntake() {
        List<List<Float>> listOfNutrition = new ArrayList<>();
        Set<String> setOfKeys = hashtable.keySet();
    
        for (String food : setOfKeys){
            List<String> nutritionStrings = hashtable.get(food);
            List<Float> nutritionValues = new ArrayList<>();
            for (String s : nutritionStrings) {
                nutritionValues.add(Float.parseFloat(s));
            }
            listOfNutrition.add(nutritionValues);
        }
    
        List<Float> totalNutrition = new ArrayList<>(listOfNutrition.get(0));
        for (int i = 0; i < totalNutrition.size(); i++){
            for (int j = 1; j < listOfNutrition.size(); j++){
                Float nutrient = totalNutrition.get(i);
                nutrient += listOfNutrition.get(j).get(i);
                totalNutrition.set(i, nutrient);
            }
        }
    
        return totalNutrition;
    }
    
    
}
