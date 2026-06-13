import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        Map<String,Integer> resultMap = new HashMap();
        for (String key: recipe.keySet()){
            if (available.containsKey(key))
            {
                resultMap.put(key,(int)(available.get(key)/recipe.get(key)));
            }
            else
                return 0;
        }
        return Collections.min(resultMap.values());
    }
    public static void main(String[] args){
        System.out.print(PeteBaker.cakes(
                Map.of("flour", 500, "sugar", 200, "eggs", 1),
                Map.of("flour", 1200, "sugar", 1200, "eggs", 5, "milk", 200)
        ));
    }
}