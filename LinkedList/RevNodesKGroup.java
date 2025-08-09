package LinkedList;

public class RevNodesKGroup {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
     public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, prev = dummy, next = dummy;

        // Count total number of nodes
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Reverse in k groups
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
