package daytest;

/**
 * @Author hu
 * @Date 2022/7/8 10:14
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 给定的字符串长度不超过100。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
 * <p>
 * 时间复杂度O(n)
 */

public class Problem04 {
    public static String replaceBlank(StringBuffer s) {
        int originalLength = s.length() - 1;
        int numberOfBlank = 0;
        for (int i = 0; i <= originalLength; i++) {
            if (s.charAt(i) == ' ') {
                numberOfBlank++;
            }
        }
        int newLength = s.length() + numberOfBlank * 2;
        int p1 = originalLength;
        int p2 = newLength - 1;
        s.setLength(newLength);
        while (p1 >= 0 && p2 > p1) {
            if (s.charAt(p1) == ' ') {
                s.setCharAt(p2--, '0');
                s.setCharAt(p2--, '2');
                s.setCharAt(p2--, '%');
            } else {
                s.setCharAt(p2--, s.charAt(p1));
            }
            p1--;
        }
        return s.toString();

    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println(replaceBlank(str));
    }
}
