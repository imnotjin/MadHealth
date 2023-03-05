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
