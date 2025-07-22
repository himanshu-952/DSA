import java.util.*;
public class TriesClass {

    public static node root= new node();

    static class node {
    
        node[] children= new node[26];
        boolean eow=false;
        int freq=0;

        public node(){
            for (int i = 0; i <26; i++) {
                children[i]=null;
            }
        }
        
    }

    public static void insert(String word){
        node curr=root;

        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new node();
            }
            
            curr=curr.children[ch-'a'];
            curr.freq++;
             
        }
        curr.eow=true;
    }

    public static boolean search(String word){

        node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
            return false;
            }
            curr=curr.children[ch-'a'];
        }

        if(curr.eow==true){
            return true;
        }
        else{
            return false;
        }

    }

    public static boolean wordbreak(String key){

        if(key.length()==0){
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            if(search(key.substring(0, i))&&wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;

    }

  public static void prefix(String word) {
    node curr = root;
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        int idx = ch - 'a';

        if (curr.children[idx] == null) return;

        ans.append(ch);
        curr = curr.children[idx];

        if (curr.freq == 1) break;
    }

    System.out.println(ans.toString());
}

  public static boolean startWith(String word){
    node curr=root;
    for (int i = 0; i < word.length(); i++) {
        if(curr.children[word.charAt(i)-'a']==null){
            return false;
        }
        curr=curr.children[word.charAt(i)-'a'];
    }
    return true;
  }

  public static int nodecount(node root , int count){
    if(root==null){
        return 0;
    }
    node curr=root;
    for (int i = 0; i <26; i++) {
        if(curr.children[i]!=null){
            ++count;
          count=  nodecount(curr.children[i], count);
        }
    }
    return count;
  }

  public static int uniqueSubstring(String word){
    for (int i = 0; i <word.length(); i++) {
        insert(word.substring(i));
    }

    int count=0;
     count=nodecount(root, 0);
     return count+1;
  }

    public static void main(String[] args) {
        

        System.out.println(uniqueSubstring("ababa"));

    }
}
