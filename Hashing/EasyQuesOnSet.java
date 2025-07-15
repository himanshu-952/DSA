import java.util.*;

public class EasyQuesOnSet {

    public static int distinctNo(int arr[]){
        HashSet<Integer> hs= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        System.out.println( "ans is "+ hs.size());
        return hs.size();
    }

    public static void intersectionAndUnion(int a[] , int b[]){

        HashSet<Integer> hs= new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            hs.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            hs.add(b[i]);
        }
           System.out.print("Union - ");
        for (Integer integer : hs) {
            System.out.print(integer+" ");
        }
           System.out.println();
        hs.clear();

        for (int i = 0; i < a.length; i++) {
            hs.add(a[i]);
        }
        System.out.print(" Intersection - ");
        for (int i = 0; i < b.length; i++) {
            if(hs.contains(b[i])){
            System.out.print(b[i]+" ");
            }
        }

    


    }

    public static void journeyMap(HashMap<String, String> map){

        String first="";
       String next="";
        HashSet<String> hs=new HashSet<>();
        for (String s : map.keySet()) {
            hs.add(map.get(s));
        }

       
        for (String st : map.keySet()) {
            if(!hs.contains(st)){
                first=st;
                
            }
        }

        System.out.print(first);
        while (!map.isEmpty()) {
            
              next=map.get(first);
            System.out.print("->"+next);
            map.remove(first);
            first=next;
        }

    


    }

    public static int largestSubarray0Sum(int arr[]){
        HashMap<Integer , Integer> hm= new HashMap<>();
        int sum=0;
        int largest=0;
        
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }
            else{
                largest=Math.max(largest,i- hm.get(arr[i]));
            }
        }
        System.out.println(largest);
        return largest;

    }

    public static int subArrSumEqK(int arr[] , int k){
        int sum=0;
        int count=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
                
            }
          hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
      
        int arr[]={15,-2,2,-8,1,7,10,23};
        largestSubarray0Sum(arr);
    
    }
}
