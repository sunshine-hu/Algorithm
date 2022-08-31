package daytest;

/**
 * @Author hu
 * @Date 2022/8/25
 *
 * 打印从1到最大的n位数
 */


public class Problem07 {
    public static void print1ToMaxOfDigits(int n) {
        // 防止非法输入
        if (n <= 0) {
            return;
        }

        // 将number的每个数字为'0'
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }

        while (!increment(number)) {
            printNumber(number);
        }
    }
    /**
     * 在字符串表示的数字上模拟加法
     * @param number
     * @return 是否超过最大数
     */
    public static boolean increment(char[] number) {
        // 是否超过最大数
        boolean isOverflow = false;
        // 进位数
        int nTakeOver = 0;
        int nLenth = number.length;

        for (int i = nLenth-1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLenth-1) {
                nSum++;
            }
            if (nSum >= 10) {
                // 如果在第一个字符产生了进位，则已经是最大的n位数
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                // 如果没有发生进位，那么就不用再改其他位了
                break;
            }
        }
        return isOverflow;
    }

    // 根据字符串打印出数字
    public static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        for (int i = 0; i < nLength; i++) {
            // 遇到第一个非0的字符
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }

            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfDigits(2);
    }

}
