package LinkedList;
public class RotateList {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy= new ListNode();
     
      ListNode first=head;
      ListNode prev= dummy;
      ListNode last= head;
      prev.next=head;
        for (int i = 0; i < k; i++) {
            
         first=head;
         prev.next=head;

            while (last.next!=null) {
                last=last.next;
                prev.next=prev;
            }
            head=last;
            last.next=first;
            prev.next=null;


        }
        return head;
    }
}
}
