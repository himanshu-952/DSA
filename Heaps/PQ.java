import java.util.*;
public class PQ {

    static class Student implements Comparable<Student>{
        String name;
        int marks;
         public Student(String name , int m){
            this.name=name;
            this.marks=m;

         }
         @Override
         public int compareTo(Student s2){
              return s2.marks-this.marks;
         }
    }
    public static void main(String[] args) {

        PriorityQueue<Student> pq= new PriorityQueue<>();
       
        pq.add(new Student("rk", 17));
        pq.add(new Student("pk", 15));
        pq.add(new Student("Hk", 1));

        while (!pq.isEmpty()) {
            System.out.println(pq.remove().marks);
        }
       

    }
}
