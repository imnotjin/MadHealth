import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MadHealthBackend implements MadHealthBackendInterface{
    private Hashtable<String, NutritionInterface> hashtable;
    private ArrayList<String> foodConsumed;

    public void loadData() {
        
    }

    public List<String> findFoods() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFoods'");
    }

    public String getCurrentIntake() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentIntake'");
    }
    
}
