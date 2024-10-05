import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Iterator;

public class VocabList {
    // var
    public static TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
    public static Scanner sc = new Scanner(System.in);
    public static int n = sc.nextInt();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        // this is the for loop which scans values
        for(int i = 0; i < n; i++){
            String tmp = sc.next();
            // then what do we do for the value?
            // first we put the key, value into tm
            // but what value?
            // if the key is first case, value will be 1
            if(!tm.containsKey(tmp))
                tm.put(tmp, 1);
            //else value will be + 1 
            else
                tm.put(tmp, tm.get(tmp) + 1);
        }
        Iterator<Entry<String, Integer>> it = tm.entrySet().iterator();

        while(it.hasNext()){
            Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}