/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxslidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 *
 * @author jojo
 */
/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的
 * k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值  
 *
 * @author jojo
 */
public class MaxSlidingWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 8};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1) {
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }

}
