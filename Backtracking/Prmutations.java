public class Prmutations {

    public static void permutations(String name , String newstring ){

        if(name.length()==0){
System.out.println(newstring);
return ;
        }
       for(int i=0 ; i<name.length(); i++){
        char curr=name.charAt(i);

        String temp =name.substring(0, i)+name.substring(i+1, name.length());

        permutations(temp, newstring+curr);
       }

    }

    public static void main(String[] args) {
        String name="abc";
        permutations(name, "");
        
    }
}
