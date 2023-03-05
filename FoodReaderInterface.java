import java.io.FileNotFoundException;
import java.util.List;

public interface FoodReaderInterface{
    public List<FoodInterface> readFoodsFromFile(String filename) throws FileNotFoundException;
}