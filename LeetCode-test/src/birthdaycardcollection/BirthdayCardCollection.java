/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthdaycardcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jojo
 */
/**
 * HackerCards is a trendy new card game. Each type of HackerCard has a distinct
 * ID number greater that or equals to 1, and the cost of each HackerCard equals
 * its ID number. For example, HackerCard 1 costs 1, HackerCard 5 costs 5, and
 * so on.
 *
 * Leanne already has a collection started. For her birthday, Mike wants to buy
 * her as many cards as he can, but they must cost less than or equals to his
 * budget. He wants to buy one each of some cards she doesn't already have. If
 * he has to make one choice among several, he will always choose the lowest
 * cost option. Determine which cards he will buy.
 *
 * For example, Leanne's collection = [2, 4, 5] and Mike has d = 7 to spend. He
 * can purchase a maximum of 2 cards, the 1 and the 3 to add to her collection.
 * Two other options he has are 1 and 6 (costs more) or 7(fewer cards, costs
 * more)
 *
 * Input: collections[] = [1,3,4] d = 7
 *
 * output: [2,5]  
 *
 * @author jojo
 */
public class BirthdayCardCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] collection = {1, 3, 4};
        int d = 7;
        int[] res = hackerCards(collection, d);
        System.out.println(Arrays.toString(res));

    }

    public static int[] hackerCards(int[] collection, int d) {
        Set<Integer> set = new HashSet<>();
        for (int i : collection) {
            set.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int curSum = 0;
        // 因为尽可能多的卡片数量，所以从最小的卡片开始计算搜索
        for (int i = 1; i < d; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (curSum + i > d) {
                break;
            }
            curSum += 1;
            res.add(i);
        }
        int[] cur = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            cur[i] = res.get(i);

        }
        return cur;
    }

}
