import java.util.ArrayList;

public class PairSum1 {
    
    public static boolean cheaksum(ArrayList<Integer> list , int target){
        int LP=0 , RP=list.size()-1;
        while (LP<RP) {
            if(list.get(LP)+list.get(RP)==target){
                return true;
            }
            if(list.get(LP)+list.get(RP)<target){
                LP++;
            }
            if(list.get(LP)+list.get(RP)>target){
                RP--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(cheaksum(list, 5));
    }
}
