public class Subset {

    public static void printAllString(String input, int i , String Output){

        if(i==input.length()){
            System.out.println(Output);
            return;
        }
        // include
        printAllString(input,i+1, Output+input.charAt(i));
        
        //exclude
        printAllString(input, i+1, Output);

    }

    public static void main(String[] args) {
        String name="abc";
        printAllString(name, 0, "");
    }
}
