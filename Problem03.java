package daytest;

/**
 * @Author hu
 * @Date 2022/7/5 17:08
 */

public class Problem03 {
    public static boolean Find(int[][] arry, int target) {
        int row = 0;
        int col = arry[0].length - 1;
        while (row <= arry.length - 1 && col >= 0) {
            if (arry[row][col] == target) {
                return true;
            } else if (target > arry[row][col]) {
                row++;
            } else {
                col--;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arry = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 10, 15}};
        boolean result = Find(arry, 7);
        System.out.println(result);
    }
}
