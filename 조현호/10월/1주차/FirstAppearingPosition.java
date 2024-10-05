import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FirstAppearingPosition {
    // set var
    public static int n;
    public static TreeMap<Integer, Integer> m = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            // get number input
            number = sc.nextInt();
            // next?? put the k,v in m
            if(!m.containsKey(number)){
                m.put(number, i+1);
            }
        }
        Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();

        while(it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }
}