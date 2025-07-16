import java.util.*;
public class WakestSoilder {

    static class armyrow implements Comparable<armyrow>{
        int soilders;
        int inx;

        public armyrow(int data , int idx){
            this.soilders=data;
            this.inx=idx;
        }

        @Override
        public  int compareTo(armyrow r2){
            if(this.soilders==r2.soilders){
                  return this.inx-r2.inx;
            }
            else{
                return this.soilders-r2.soilders;
            }
        }
    }

    public static void main(String[] args) {
        
        int army[][]={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };

        PriorityQueue<armyrow> pq= new PriorityQueue<>();

        
        for (int i = 0; i < army.length; i++) {
            int count=0;
            for (int j = 0; j < army[0].length; j++) {
                count+=army[i][j]==1?1:0;
            }
            pq.add(new armyrow(count, i));
        }

        int k=2;
         for (int i = 0; i < k ; i++) {
            System.out.println("army no : "+ pq.peek().inx);
            pq.remove();
         }
    }
}
