public class QuickSort {
    public static void print(int arr[]){
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }}
    public static void sort(int arr[] , int fi , int li){
        if(fi>=li){ return;}
        int pvindex=partition(arr , fi , li);
        sort(arr, fi, pvindex-1);
        sort(arr, pvindex+1, li);
    }

    public static int partition(int arr[] , int fi , int li){
        int pivot=li;
        int i=fi-1;

        for(int j=fi ; j<li ;j++){
         if(arr[j]<arr[pivot]){
            i++;
            int temp= arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
         }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[pivot];
        arr[pivot]=temp;
        return pivot=i;
    }
    public static void main(String[] args) {
        int arr[]={7,5,17,8,26,10};
        sort(arr, 0, arr.length-1);
        print(arr);
    }
}
