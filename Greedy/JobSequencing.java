import java.util.*;

public class JobSequencing {

    public static class job{
        int no;
        int deadline;
        int profit;

        public job(int i , int d , int p){
            this.no=i;
            this.deadline=d;
            this.profit=p;
        }
    }

 
    public static int MaxProfit(int[][]jobs){
          ArrayList<job> que= new ArrayList<>();
   int currtime=0;
   int max=0;
        for (int i = 0; i < jobs.length; i++) {
     que.add(new job(i, jobs[i][0], jobs[i][1]));
   }

   Collections.sort(que , (a , b)-> b.profit-a.profit);

   ArrayList<Integer> seq= new ArrayList<>();

   for (int i = 0; i < que.size(); i++) {
        job curr= que.get(i);
            if(currtime<curr.deadline){
              max+=curr.profit;
             seq.add(curr.no);
              currtime++;
            }

        }
        while(!seq.isEmpty()){
            System.out.println("Do JOb NO : "+ seq.removeFirst());
        }
        System.out.println("max profit is "+ max);
        return max;

    }
    public static void main(String[] args) {
      int[][] jobs = {
    {1, 20},
    {2, 100},
    {2, 27},
    {1, 19}
};
   
     MaxProfit(jobs);
}}

