import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CalculatingProportions {
    // set var
    public static int n;
    public static TreeMap<String, Integer> m = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String color = new String();
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            // get color input
            color = sc.next();
            // next?? put the k,v in m
            if(!m.containsKey(color)){
                m.put(color, 1);
            }
            else{
                int tmp = m.get(color);
                tmp++;
                m.put(color, tmp);
            }
        }
        Iterator<Entry<String, Integer>> it = m.entrySet().iterator();

        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            
            double outVal = ((double)entry.getValue()/n)*100;
            String formattedPercentage = String.format("%.4f", outVal);

            System.out.println(entry.getKey() + " " + formattedPercentage);
        }
        
    }
}