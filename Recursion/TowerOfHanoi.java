public class TowerOfHanoi {
    

    public static void ringTransfer(int n , String src , String helper , String dest){

        if(n==1){
            System.out.println("transfer " + n +" ring from  "+ src + " to " +dest);
            return ;
        }
        ringTransfer(n-1, src, dest, helper);
        System.out.println("transfer " + n +" ring from  "+ src + " to " +dest);
       ringTransfer(n-1, helper, src, dest);

    }


    public static void main(String[] args) {
        
ringTransfer(3, "A", "B", "C");

    }

}
