/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jojo
 */
public class Lc15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = new int[]{-1,-1,0,1};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        // step 1: sort the array,
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // iterate the array to find out if the element meets the requriment
        for(int i = 0; i < nums.length; i++){
            int left = 0;
            int right = nums.length - 1;
            //set up the while loop exit condition
            while(left < right){
                int sum = nums[left] + nums[i] + nums[right];
                // there are three conditions: if the sum equals to 0, it will be added to the arraylist, of the left and right pointer will move to the next idnex.
                if(sum == 0){
                    res.add(Arrays.asList(nums[left], nums[i], nums[right]));
                    while(nums[right] == nums[right - 1]){
                        right--;
                    }
                    while(nums[left] == nums[left + 1]){
                        left++;
                    }
                    right--;
                    left++; 
                    
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }            
            }                 
        }
        return res;       
    }
}
