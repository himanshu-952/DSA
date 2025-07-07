public class BinaryString {
    public static String solution( int n, char i , String output){

    if(output.length()==n){
        System.out.println();
        return output;
       
        
    }

    if(i=='0'){
     return  solution(n, '0', output+i)+ solution(n, '1', output+i);
      
    }
    else{
        return solution(n, '0', output+i);
    }

    }
    public static void main(String[] args) {
        System.out.println(solution(6, '1', ""));
    }
}
