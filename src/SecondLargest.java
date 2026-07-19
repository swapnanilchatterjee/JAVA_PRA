// TCS PRA Practice: Second Largest Element
// Description: Finds the second largest element in an array of N integers after sorting.
// Category: Arrays

import java.util.*;
public class SecondLargest {
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] nums=new Integer[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums,Collections.reverseOrder());
        System.out.println(nums[1]);
    }
}
