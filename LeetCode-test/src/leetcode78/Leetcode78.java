/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojo
 */
public class Leetcode78 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println(list.toString());
    }
        static List<String> list = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        //   边界条件判断
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""，因为是2开始的，所以这个string中也是索引为2 的才开始有效
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;

    }
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    static StringBuilder temp = new StringBuilder();
    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public static void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串，当满足这个条件就开始收集结果
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];  //将num指向的数字转为int
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}