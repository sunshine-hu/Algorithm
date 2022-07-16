package daytest;

import java.util.Arrays;

/**
 * @Author hu
 * @Date 2022/6/28 8:59
 * <p>
 * 题目 ：找出数组中重复的数字。
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某
 * 些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了
 * 几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数
 * {2, 3, 1., 0, 2, 5, 3}, 那么对应的输出是重复的数字2或者3
 * <p>
 * 要求时间复杂度为o(n)，原地置换法
 */

public class Problem01 {
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }
        int flag = 0;
        for (int i = 0; i < length; i++){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    flag = 1;
                    duplication[i] = numbers[i];
                    break; //防止交换到一样的而无尽循环
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return flag > 0 ;
    }

    public static void main(String[] args) {
        int[] arry = {2,3,1,0,2,5,3};
        int[] arry1 = new int[10];
        boolean res = duplicate(arry,7,arry1);
        System.out.println(res);
        System.out.println(Arrays.toString(arry1));
    }

}

