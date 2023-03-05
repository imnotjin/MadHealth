import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FoodReader implements FoodReaderInterface{

    public List<FoodInterface> readFoodsFromFile(String filename) throws FileNotFoundException {
        ArrayList<FoodInterface> foods = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));

        /*
            [0] Food name
            [1] Calcium
            [2] Carbohydrate
            [3] Cholesterol
            [4] Energy
            [5] Fatty acids, total monounsaturated
            [6] Fatty acids, total polyunsaturated
            [7] Fatty acids, total saturated
            [8] Fatty acids, total trans
            [9] Fiber
            [10] Iron
            [11] Protein
            [12] Sodium
            [13] Sugars
            [14] Fat
            [15] Vitamin A
            [16] Vitamin C
         */
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] parts = line.split(",");
            List<String> nutrition = Arrays.asList(parts);
            nutrition.remove(0);
            foods.add(new Food(parts[0], nutrition));
		}
        return foods;
    }
    
}
