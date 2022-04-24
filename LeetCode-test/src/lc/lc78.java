/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojo
 */
public class lc78 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res =subsets(nums);
        System.out.println(res.toString());
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        // create a new list to store outputs
        List<List<Integer>> res = new ArrayList<>();
        // use dfs to iterate every element
        dfs(res,nums,0,new ArrayList<>());
        return res;
        
    }
    public static void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> temp){
        // when we find the index == nums.length means there are no more elements needs to be added into the subset
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // there are two operations,  add the new element,
        temp.add(nums[index]);
        dfs(res,nums,index + 1, temp);
        temp.remove(temp.size() - 1);
        // another one does not add the new element.
        dfs(res,nums,index + 1, temp);
    }
    
}

