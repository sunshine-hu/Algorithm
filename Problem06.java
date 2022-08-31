package daytest;

import static java.lang.Math.pow;

/**
 * @Author hu
 * @Date 2022/7/21 15:47
 * <p>
 * 剪绳子，给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],…,k[m]。请问k[1]x…xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 * <p>
 * <p>
 * 使用贪心算法，时间和空间都为O（1）
 * 动态规划，时间o(n^2),空间o(n)
 */

public class Problem06 {
    //贪心算法
    public static int cutRope(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //尽可能剪长度为3的绳子
        int timesOf3 = length / 3;
        //当剩余长度为4时，剪成2段长度为2的
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) pow(3, timesOf3) * (int) pow(2, timesOf2);
    }

    //动态规划
    public static int cutRope1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[2] = 1;
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i - j]));
                //dp[i]不剪，从j处剪断，为 （i-j）*j  剩下的i-j继续剪
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int s = cutRope(8);
        int s1 = cutRope1(8);
        System.out.println(s);
        System.out.println(s1);
    }
}
