package Strings;

public class ReverseWords {
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // split on one or more spaces
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" ");
        }

        return result.toString();
    }
}

}

