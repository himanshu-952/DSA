public class Subsets {

    public static void PrintSubsets(String name , int index , String newstring){
      
    

        if(index==name.length()){
            if(newstring.length()==0){
                System.out.println("null");
            }
            System.out.println(newstring);
            return ;
        }
        PrintSubsets(name, index+1 , newstring+name.charAt(index));
        
        PrintSubsets(name, index+1, newstring);
        
        return ;

    }

    public static void main(String[] args) {
        String name="abc";
        PrintSubsets(name, 0, "");
    }
}
