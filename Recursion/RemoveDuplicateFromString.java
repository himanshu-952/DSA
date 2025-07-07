public class RemoveDuplicateFromString {
    public static String removeDuplicate(String old, int n, boolean arr[] , String res){

        if(n==old.length()){
            return res;
        }

        if(arr[old.charAt(n)-'a']==false){
             arr[old.charAt(n)-'a']=true;
          return   removeDuplicate(old, n+1, arr, res+old.charAt(n));

        }
        else{
          return  removeDuplicate(old, n+1, arr, res);
        }
        



    }
    public static void main(String[] args) {
        System.out.println(removeDuplicate("abaccd", 0, new boolean[26], ""));
    }
}
