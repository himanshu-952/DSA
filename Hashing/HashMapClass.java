
import java.util.*;
public class HashMapClass {
    public static void main(String[] args) {
        
        HashMap<String , Integer> hm= new HashMap<>();
        hm.put("Himanshu" , 21);
        hm.put("khushi" , 19);

        Set<String> keys= hm.keySet();

        for (String k : keys) {
            System.out.println("Age of " +k + " is "+ hm.get(k));
        }

    }
}
