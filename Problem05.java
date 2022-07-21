package daytest;

/**
 * @Author hu
 * @Date 2022/7/11 9:28
 * <p>
 * 根据前序和中序遍历构造二叉树
 */

public class Problem05 {
    public static long fB(long i) { // t: o(2^n)
        if (i <= 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fB(i - 1) + fB(i - 2);
    }

    public static long fB1(long n) { //t: o(n)
        if (n < 2) {
            return 1;
        }
        long first = 0;
        long second = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        //System.out.println(fB(10));
        System.out.println(fB1(100));
    }
}
