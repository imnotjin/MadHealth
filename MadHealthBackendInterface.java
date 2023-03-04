import java.util.Hashtable;
import java.util.List;

public interface MadHealthBackendInterface{
    public void loadData();
    public List<String> findFoods();
    public String getCurrentIntake();
}
