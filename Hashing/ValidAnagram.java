import java.util.*;
public class ValidAnagram {

    public static boolean anagram(String s, String t){
        HashMap<Character , Integer> hm= new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i) ,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(hm.containsKey(t.charAt(i))){
                if(hm.get(t.charAt(i))>1){
                    hm.put(t.charAt(i),  hm.get(t.charAt(i)) - 1);
                }
                else{
                    hm.remove(t.charAt(i));
                }
            }
            else{
                System.out.println("Not A Anagram");
                return false;
            }
        }
        if(hm.isEmpty()){
            System.out.println("Its A Anagram");
            return true;
        }
        else{
            System.out.println("Not A ANagram");
            return false;
        }
    }

    public static void main(String[] args) {
        String s="race";
        String t= "care";
        anagram(s, t);
    }
}
