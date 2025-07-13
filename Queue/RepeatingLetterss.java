
import java.util.*;
import java.util.LinkedList;
public class RepeatingLetterss {
    
    public static String NoRepeat(String input){
        Queue<Character> q= new LinkedList<>();
        int freq[]= new int[26];
        String output="";
        for (int i = 0; i <input.length() ; i++) {
            q.add(input.charAt(i));
           freq[input.charAt(i)-'a']++;
           if(freq[q.peek()-'a']<=1){
            
            
                output+=q.peek();
            
            
           }
           else{
            
            while(!q.isEmpty()&&freq[q.peek()-'a']>1){
            q.remove();
            }
            if(q.isEmpty()){
                output+="-1";
            }
            else{
                output+=q.peek();
            }

           }
        }
 return output;
    }

    public static void main(String[] args) {
         String name="aaabccxb";
         String output=NoRepeat(name);
         System.out.println(output);
    }
}
