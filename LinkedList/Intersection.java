package LinkedList;
import java.util.*;
public class Intersection {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashSet<ListNode> hs= new HashSet<>();
        ListNode a= headA  , b= headB;
        while(a!=null ){
        
           if(hs.contains(a)){
              return a;
           }
           else{
            hs.add(a);
           }
           

           a=a.next ;
          

        }
        while(b!=null ){
           
            
            

           if(hs.contains(b)){
            return b;
           }
           else{
            hs.add(b);
           }
          
           b=b.next;
        }
        
        return null;
        }

  
    }
}

