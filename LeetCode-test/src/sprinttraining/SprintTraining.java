/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprinttraining;

/**
 *
 * @author jojo
 */
public class SprintTraining {

    /**
     * @param args the command line arguments
     */
    /**
     * Imagine there are n points along a straight trail, while a runner run sprints of intervals between those point.
The training plan is an array a[], which implies the runner should run from point a[i] to point a[i+1].

For example, given n = 10, a = [2, 4, 1, 2].
The runner should run from point 2 to point 4,
then turn back from point 4 to point 1,
and then from point 1 to point 2.

Find the point that visited the most by runner after he finished training, i.e. in above example, point 2 is the most visited.
If more than one point are visited the most, find the point with minimum index.
     */
    


    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {2,4,1,2,4,5,4};
        int n = 10;
        int res = getmostvisited(nums,n);
        System.out.println(res);
         
    }
    
    public static int getmostvisited(int[]nums, int n){
        int[] arr = new int[n+2];
        for(int i = 0; i < nums.length-1; i++){
            int start = Math.min(nums[i], nums[i+1]);
            int end = Math.max(nums[i],nums[i+1]);
            arr[start] += 1;
            arr[end+1] -= 1; 
        }
        int res = -1;
        int s = 0;
        int maxI = -1;
        for(int i = 0; i < n+1; i++){
            arr[i] += s;
            s = arr[i];
            if(s > maxI){
                maxI = s;
                res = i;
            }
        }
        return res;
    }
  
}
