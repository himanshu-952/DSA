import java.util.Arrays;

public class DuplicateNo {
     public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int temp=0;
    for (int j2 = 0; j2 < nums.length-1; j2++) {
        if(nums[j2]==nums[j2+1]){
            temp=nums[j2];
        }
    }
    return temp;
        
    }
}
