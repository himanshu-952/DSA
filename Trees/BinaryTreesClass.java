import java.util.*;
import java.util.LinkedList;

public class BinaryTreesClass {

    static class Node{
        int data;
        Node leftnode;
        Node rightnode;

        public Node(int data){
            this.data=data;
            this.leftnode=null;
            this.rightnode=null;
        }

    }

    static class BinaryTree{
        static int idx;
          public static Node buildTree(int[] preorder) {
        idx = -1;  // Reset idx before starting the build
        return build(preorder);
    }
    
        public static Node build(int[] preorder){
            ++idx;
            if(preorder[idx]==-1){
                return null ;
            }
           
           
          Node root= new Node(preorder[idx]);
          root.leftnode=build(preorder);
          root.rightnode=build(preorder);
           
          return root;

        }

        public static void Preorder(Node root){
            if(root==null){
                return;
                
            }
            System.out.print(root.data+" ");
            Preorder(root.leftnode);
            Preorder(root.rightnode);
        }

        public static void Inorder(Node root){
            if(root==null){
                return;
                
            }
              Inorder(root.leftnode);
              System.out.print(root.data+" ");
              Inorder(root.rightnode);

        }

        public static void Postorder(Node root){
            if(root==null){
                return;
                
            }
        Postorder(root.leftnode);
        Postorder(root.rightnode);
        System.out.print(root.data+" ");
        }

        public static void LevelOrder(Node root){
            
            Queue<Node> q= new LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node pointer=q.peek();
                if(pointer==null){
                    System.out.println();
                    q.remove();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                  
                    q.add(null);
                    }
                
                }
                else{
                    q.remove();
                    System.out.print(pointer.data+" ");
                    if(pointer.leftnode!=null){
                        q.add(pointer.leftnode);

                    }
                    if(pointer.rightnode!=null){
                        q.add(pointer.rightnode);
                    }
                }
            }  
            }
            
            public static int height(Node root){
                
                if(root==null){
                    return 0;
                }
               
            
                return Math.max( height(root.leftnode),   height(root.rightnode))+1;
                
            }
          
            public static int countnodes(Node root){
                if(root==null){
                    return 0;
                }
                return countnodes(root.leftnode)+countnodes(root.rightnode)+1;
            }




           public static int SumOfNodes(Node root) {
           if (root == null) {
               return 0;
            }
              int leftSum = SumOfNodes(root.leftnode);
               int rightSum = SumOfNodes(root.rightnode);
               return leftSum + rightSum + root.data;
}

     public static int diameter_approach1(Node root){
        if(root==null){
            return 0;
        }
        int leftdiam= diameter_approach1(root.leftnode);
        int rightdiam= diameter_approach1(root.rightnode);
        int diamtTroughNode= height(root.leftnode)+height(root.rightnode)+1;

        return Math.max(Math.max(leftdiam , rightdiam), diamtTroughNode);
     }

    static class InfoOfDiameter{
        int height , diam;

      public InfoOfDiameter(int d , int h){
            this.diam=d;
            this.height=h;
        }
     }

     public static InfoOfDiameter diameter_approach2(Node root){
        if(root==null){
            return new InfoOfDiameter(0,0) ;
        }
        InfoOfDiameter leftinfo= diameter_approach2(root.leftnode);
        InfoOfDiameter rightinfo= diameter_approach2(root.rightnode);

        int finalDiam=Math.max(Math.max(leftinfo.diam, rightinfo.diam), leftinfo.height+rightinfo.height+1);
       int finalheight= Math.max(leftinfo.height , rightinfo.height)+1;

        return new InfoOfDiameter(finalDiam ,finalheight); 
     }
   
    public static boolean isSubtree(Node root , Node subroot){
        if(root==null){
            return false;
        }

        if(subroot.data==root.data){
             if(identical(root, subroot)){
                return true;
             }
        }

        

        return isSubtree(root.leftnode, subroot)||
        isSubtree(root.rightnode, subroot) ;

    }

    public static boolean identical(Node root , Node subroot){
        if(root==null && subroot==null){
            return true;
            
        }
        if( (root==null  || subroot==null)){
            return false;
        }

        if(root.data!=subroot.data){
            return false;
        }
        

        


        return 
        identical(root.leftnode, subroot.leftnode) &&
        identical(root.rightnode, subroot.rightnode) ;


    }
     
    static class InfoOfHorizontalDistance{
       Node node;
        int hd ;

        public InfoOfHorizontalDistance(Node root , int hd){
            this.node=root;
            this.hd=hd;
        }
        
    }

    public static void TopLevelView(Node root){

        Queue<InfoOfHorizontalDistance> q= new LinkedList<>();
        HashMap<Integer , InfoOfHorizontalDistance> map=new HashMap<>();

        int min=0;
        int max=0;

        q.add(new InfoOfHorizontalDistance(root, 0));

        while(!q.isEmpty()){
            InfoOfHorizontalDistance curr=q.remove();
           

                 if(!map.containsKey(curr.hd)){
                map.put(curr.hd , curr);
            }
            if(curr.hd<min){
                        min=curr.hd;
                    }
                    if(curr.hd>max){
                        max=curr.hd;
                    }

                if(curr.node.leftnode!=null){
                    q.add(new InfoOfHorizontalDistance(curr.node.leftnode, curr.hd-1));
                    
                }
                if(curr.node.rightnode!=null){
                    q.add(new InfoOfHorizontalDistance(curr.node.rightnode, curr.hd+1));
                    
                }
            }

        

        for(int i=min ; i<=max ;i++){
            System.out.print(map.get(i).node.data+" ");
        }


    }

    public static void KthLevel(Node root , int level){
        int i=1;
     printKLevel(root , i , level);
    }

    public static void printKLevel(Node root , int i , int level){

        if(root==null){
            return ;
        }
        if(i==level){
            System.out.print(root.data+" ");
            return ;
        }
        printKLevel(root.leftnode, i+1, level);
        printKLevel(root.rightnode, i+1, level);
    }
public static Node lowestCommonAncestor(Node root, int ch1, int ch2) {
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    if (!pathfinder(root, ch1, path1) || !pathfinder(root, ch2, path2)) {
        System.out.println("One or both nodes not found.");
        return null;
    }

    int i = 0;
    while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
        i++;
    }

    Node lca = path1.get(i - 1);
    System.out.println("Lowest Common Ancestor is: " + lca.data);
    return lca;
}

public static boolean pathfinder(Node root, int ch, ArrayList<Node> path) {
    if (root == null) {
        return false;
    }

    path.add(root);

    if (root.data == ch) {
        return true;
    }

    if (pathfinder(root.leftnode, ch, path) || pathfinder(root.rightnode, ch, path)) {
        return true;
    }

    path.remove(path.size() - 1); // Backtrack
    return false;
}


public static int minDistance(Node root , int n1  , int n2){
    Node lca= lowestCommonAncestor(root, n1, n2);

    int n1dist=distfromLca(lca ,n1);
    int n2dist=distfromLca(lca ,n2);

    return n1dist+n2dist;
}

public static int  distfromLca(Node root , int n){

    if(root==null){
        return -1;
    }

    if(root.data==n){
      return 0;
    }
    
    int leftdist=distfromLca(root.leftnode, n);
    int rightdist= distfromLca(root.rightnode, n);

    if(leftdist==-1 && rightdist==-1){
        return -1;
    }

   else{
         return Math.max(leftdist, rightdist)+1;
   }
    
}



    public static int kthancestor(Node root ,int n1, int k){
        if(root==null){
            return -1;

        }

        
        if(root.data==n1){
            return 0;
        }
        
        int leftlevel=kthancestor(root.leftnode, n1, k);
        int rightlevel= kthancestor(root.rightnode, n1, k);

        if( Math.max(leftlevel, rightlevel)+1==k){
            System.out.println(k+" Ancestor is : "+root.data);
            return root.data;
        }
        if(Math.max(leftlevel, rightlevel)+1>k){
            System.out.println("Not founf");
            return -1;
        }

        if(leftlevel==-1 && rightlevel==-1){
            return -1;
        }
        else{
            return Math.max(leftlevel, rightlevel)+1;
        }
    }

    public static int sumtreeTransform(Node root){
        if(root==null){
            return  0;
        }
        
       int data= root.data;
       root.data= sumtreeTransform(root.leftnode)+ sumtreeTransform(root.rightnode);
       
       return data+root.data;
    }




    }
    

    public static void main(String[] args) {
        int[] tree={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1  };
        int[] subtree={2 , 4 ,-1 ,-1 , 5 ,-1 ,-1};
        BinaryTree bintree= new BinaryTree();
        
        Node root=bintree.buildTree(tree);
        
      bintree.sumtreeTransform(root);
        bintree.LevelOrder(root);

    
   
        
       
    }

}
