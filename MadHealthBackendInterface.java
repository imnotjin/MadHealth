import java.io.FileNotFoundException;
import java.util.List;

public interface MadHealthBackendInterface{
    public void loadData(String filename) throws FileNotFoundException;
    public List<String> findFoods();
    public List<Float> getCurrentIntake();
}
