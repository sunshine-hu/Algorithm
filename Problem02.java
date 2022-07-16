package daytest;


/**
 * @Author hu
 * @Date 2022/7/5 10:34
 * <p>
 * 题目二：不修改数组找出重复的数字。
 * 在一个长度为 n+l 的数组里的所有数字都在 1,.....,n 的范围内，所以数组
 * 中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能
 * 修改输入的数组 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7},
 * 么对应的输出是重复的数字2或者3
 * <p>
 * 分治思想和抽屉原理， 时间O(nlogn)，空间O(1)
 */

public class Problem02 {

    public static int find_duplicate(int[] arry) {
        int length = arry.length;
        if (length <= 0) {
            return -1;
        }
        int low = 1;
        int high = length - 1;

        while (low < high) {
            int mid = (low + high) / 2 ;
            int count = countRange(arry, length, low, mid);
            if (count > mid - low + 1) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;

    }

    private static int countRange(int[] arry, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arry[i] >= start && arry[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arry = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int result = find_duplicate(arry);
        System.out.println(result);
    }
}
