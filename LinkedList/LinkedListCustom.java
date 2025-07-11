
public class LinkedListCustom {
   
    public static class Node{
        int data;
        Node next;
   
   public Node(int data){
       this.data=data;
       this.next=null;
   }}
public static Node head;
public static Node tail;
public static int size;

public void addFirst(int data){
    Node newNode= new Node(data);
    if(head==null){
        head=tail=newNode;
        size++;
        return;
    }
    newNode.next=head;
    head=newNode;
    size++;
}
public  void addAtIndex(int index , int data){
    Node pointer=head;
    Node newNode= new Node(data);
    if(index==0){
        head=newNode;
        size++;
        if(tail==null){
            tail=newNode;
         
        }
        return ;
    }
    for(int i=0 ; i<index-1 ; i++){
        if(pointer==null){
            System.out.println("out of bounds");
            return ;
        }
      pointer=pointer.next;
      
      
    }
    if(pointer==null){
        System.out.println("out of bounds");
        return ;
    }
    newNode.next=pointer.next;
    pointer.next=newNode;
    size++;
    if(newNode.next==null){
        tail=newNode;
        
    }
    
}
public void addLast(int data){
    Node newNode= new Node(data);
    if(tail==null){
        tail=head=newNode;
        size++;
    return ;
}
    tail.next=newNode;
    tail=newNode;
    size++;
}


public  void removeFirst(){
    if(size==0){
        System.out.println("not a linked list");
        return ;
    }
    if(size==1){
        head=tail=null;
        size--;
        return ;
    }
    head=head.next;
    size--;
}
public void removeLast(){
    if(size==0){
        System.out.println("empty list");
        return ;
    }
    if(size==1){
        head=tail=null;
        size--;
        return;
    }
    Node pointer= head;
   for(int i=0 ; i<size-2; i++){
    pointer=pointer.next;
   }
   pointer.next=null;
   tail=pointer;
   size--;
}

public int search(int no){
    Node pointer= head;
    int index=0;
    while(pointer!=null){
        if(pointer.data==no){
            System.out.println(index);
         return index;
        }
        else{
            pointer=pointer.next;
            index++;
        }
    }
    return -1;
}
public int searchByRecursion(int no , Node head ){

    if(head==null){
        return -1;
    }
    if(head.data==no){
        return 0;
    }
    int index= searchByRecursion(no, head.next);
    if(index==-1){
        return -1;}

        return index+1;
      
}
public static Node reverse(){

  
        Node prev = null;
        Node curr =tail= head;
        Node next = null;
    
        while (curr != null) {
            next = curr.next;  // save next
            curr.next = prev;  // reverse pointer
            prev = curr;       // move prev forward
            curr = next;       // move curr forward
        }
    
        head = prev;  // update head to the new front of the list
        return head;
        

}

public void removeFromEnd(int n){

    Node curr= head;
    Node remove;
    if(n==size){
        head=head.next;
        return ;
    }

    for(int i=0 ; i<size-n-1; i++){
      
        curr=curr.next;
    }
    remove=curr.next;
    curr.next=remove.next;
    remove.next=null;

}
public static boolean pallindrome(){
    Node first=head;
    Node mid= midnode();

    Node prev=null;
    Node curr=mid.next;
    Node next;
    
     while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        
     }
     mid.next=null;
     Node second= prev;
    while(second!=null){
        if(first.data!=second.data){
          return false;
        }
        first=first.next;
        second=second.next;
    }
return true;
}
public static Node midnode(){
    Node slow= head;
    Node fast= head;
    while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
}

public static boolean detectCycle(){
    Node slow=head;
    Node fast= head;

    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            System.out.println("cycle detected");
            return true;
        }
      
    }
    return false;
}
 
public static void removeCycle(){
    if(detectCycle()){
     Node slow=head;
    Node fast= head;

    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            System.out.println("cycle detected now removing");
           break;
        }
    }
    slow=head;
    if(fast==slow){
        while(fast.next!=slow){
            fast=fast.next;
        }
    }
  else{

    while(fast.next!=slow){
        slow=slow.next;
        fast=fast.next;
       
    }
  }

    fast.next=null;

}
}

public static Node MergeSort(Node head ){
  
    if(head==null || head.next==null){
        return head;
    }
    Node mid=mid(head);
    Node right=mid.next;
    mid.next=null;
  Node newleft=  MergeSort(head);
   Node newright= MergeSort(right);
   return merge(newleft , newright);

}
public static Node mid(Node head){
     Node slow= head , fast=head.next;
    while (fast!=null&&fast.next!=null) {
        slow=slow.next;
        fast=fast.next.next;

    }
  
    return slow;
}
public static Node merge(Node left ,Node right){

   Node temp= new Node(-1);
   Node pointer=temp;

    while(left!=null&&right!=null){
        if(left.data<right.data){
          pointer.next=left;
          left=left.next;
          pointer=pointer.next;
        }
        else{
          pointer.next=right;
          right=right.next;
          pointer=pointer.next;
        }
    }

    while(left!=null){
        pointer.next=left;
        pointer=pointer.next;
        left=left.next;
    }
    while(right!=null){
        pointer.next=right;
        pointer=pointer.next;
        right=right.next;
    }

    return temp.next;

}

 public static Node zigzag(){
    
  Node mid= midnode();
  Node prev=null;
  Node curr=mid.next;
  Node next=null;
  mid.next=null;
  while(curr!=null){
    next=curr.next;
    curr.next=prev;
    prev=curr;
    curr=next;
    
    
  }
  Node first=head , last=prev  ;
  while(first!=null&&last!=null){
    Node newfcurr=first.next;
    Node newlcurr=last.next;
    first.next=last;
    last.next=newfcurr;
    first=newfcurr ;
     last=newlcurr;

  }
  return head;

 }

public static void print(Node head){
    Node pointer= head;
   while (pointer!=null) {
    System.out.print(pointer.data+"->");
    pointer=pointer.next;
    
   }
   System.out.print("null");
   System.out.println();
}
    
    public static void main(String[] args) {
        
        LinkedListCustom ll= new LinkedListCustom();
       ll.addFirst(2);
       ll.addFirst(16);
       ll.addFirst(7);
       ll.addFirst(12);
       ll.addFirst(26);
       ll.addFirst(1);
       ll.addFirst(13);
   
       

   print(head);
    
     
    
      
        

    }

}