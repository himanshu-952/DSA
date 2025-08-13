package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartioning {
    class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        List<String> path= new ArrayList<>();

        helper(s, res, path, 0);
   return res;

    }

    public static void helper(String s , List<List<String>> res ,  List<String> path , int idx ){

        if(idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i <s.length(); i++) {
            if(pallindrome(s, idx, i)){
                path.add(new String(s.substring(idx, i+1)));
                helper(s, res, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public static boolean pallindrome(String s, int start , int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }
}
}
