/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojo
 */
public class Leetcode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<List<Integer>> res = permute(new int[]{1,2,3});
        System.out.println(res);
        
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> cur = new ArrayList<>();
        // 创建一个临时的数组，用于标记已经遍历的节点位置；
        int[] visited = new int[nums.length];
        backtracking(res,cur,nums,visited); //注意数组cur的写法，一定是在这里new进行初始化
        return res;
        
    }
    
    public static void backtracking(List<List<Integer>> res, ArrayList<Integer> cur, int[] nums, int[]visited){
        if(nums.length == cur.size()){
            res.add(new ArrayList<>(cur)); //注意数组cur的写法，一定是在这里new进行初始化,否则会输出空数组
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(visited[i]==1) continue; //如果为1 ，则表示已经遍历过一次，直接跳过即可！
            visited[i] = 1;
            cur.add(nums[i]);
            backtracking(res,cur,nums,visited);
            visited[i]=0;
            cur.remove(cur.size()-1);
        }
    }
}
