import java.util.*;
public class StackByJCF {

    public static void pushatbottom(Stack<Integer> s , int data){
   
        if(s.empty()){
            s.push(data);
            return ;
        }
   int no= s.pop();
    pushatbottom(s, data);
    s.push(no);


    }
    public static StringBuilder revstring( StringBuilder input){
          StringBuilder reverse= new StringBuilder();
        Stack<Character> s=new Stack<>();
        for(int i=0 ; i<input.length(); i++){
            s.push(input.charAt(i));
        }
        while(!s.empty()){
            reverse.append(s.pop());
        }
  return reverse ;

    }

    public static void reverseStack(Stack<Integer> s){
       if(s.empty()){
        return ;
       }
        int top =s.pop();
        reverseStack(s);
        pushatbottom(s, top);

    }

    public static void main(String[] args) {
     
        Stack<Integer> s=new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

  
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
    }
    

