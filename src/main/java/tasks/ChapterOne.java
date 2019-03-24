package tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * {9 / 9)
 *
 * Created by Влад on 01.12.2018.
 */
public class ChapterOne {
    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.1
    // 01.12.2018

    public static boolean isUniqueOne(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUniqueTwo(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.2
    // 01.12.2018

    public static boolean isPermutation(String one, String two) {
        if (one.length() != two.length())
            return false;

        Map<Character, Integer> mapOne = new HashMap<Character, Integer>();
        Map<Character, Integer> mapTwo = new HashMap<Character, Integer>();

        fillMap(mapOne, one);
        fillMap(mapTwo, two);

        for (int i = 0; i < one.length(); i++) {
            char c = two.charAt(i);
            if (mapOne.get(c) == null) {
                return false;
            }
            if (!mapOne.get(c).equals(mapTwo.get(c))) {
                return false;
            }
        }

        return true;
    }

    private static void fillMap(Map<Character, Integer> map, String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.get(c) == null)
                map.put(c, 0);
            else {
                int counter = map.get(c);
                map.put(c, ++counter);
            }
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.3
    // 01.12.2018

    public static char[] URLify(String string, int number) {
        int difference = string.length() - number;
        char[] chars = string.toCharArray();
        char[] url = new char[chars.length];
        int j = 0;

        for (int i = 0; i < chars.length - difference; i++) {
            if (chars[i] != ' ')
                url[i + j] = chars[i];
            else {
                url[i + j++] = '%';
                url[i + j++] = '2';
                url[i + j] = '0';
            }
        }

        return url;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.4
    // 02.12.2018

    public static boolean isPalindrome(String string) {
        int[] chars = new int[128];
        int spaceCounter = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == ' ')
                spaceCounter++;
            chars[c]++;
        }

        if ((string.length() - spaceCounter) % 2 == 0) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0 && chars[i] % 2 != 0 && i != ' ')
                    return false;
            }
        } else {
            boolean checked = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0 && chars[i] % 2 != 0 && i != ' ') {
                    if (checked)
                        return false;
                    checked = true;
                }
            }
        }

        return true;
    }

    public static boolean isPalindromeOptimized(String string) {
        int[] chars = new int[128];
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            chars[c]++;
        }

        boolean foundOdd = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 == 1 && i != ' ') {
                if (foundOdd)
                    return false;
                foundOdd = true;
            }
        }

        return true;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.5
    // 15.12.2018

    public static boolean isOneAway(String one, String two) {
        int difference = one.length() - two.length();
        if (difference < -1 && difference > 1)
            return false;
        int[] chars = new int[128];
        for (char c : one.toCharArray()) {
            chars[c]++;
        }
        for (char c : two.toCharArray()) {
            chars[c]--;
        }
        int twoTimes = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                twoTimes++;
                if (twoTimes > 2)
                    return false;
            }
        }

        return true;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.6
    // 16.12.2018

    public static String compress(String string) {
        StringBuilder sb = new StringBuilder(string.length() * 2);
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            counter++;
            if (i + 1 >= string.length() || string.charAt(i) != string.charAt(i + 1)) {
                sb.append(string.charAt(i)).append(counter);
                counter = 0;
            }
        }

        return sb.toString().length() < string.length() ? sb.toString() : string;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.7
    // 16.12.2018

    public static int[][] rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[j][matrix.length - (i + 1)] = matrix[i][j];
            }
        }

        return result;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.8
    // 16.12.2018

    public static void zeroMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setZeros(matrix, i, j);
                }
            }
        }
    }

    private static void setZeros(int[][] matrix, int i, int j) {
        for (int k = 0; k < matrix[i].length; k++) {
            matrix[i][k] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    // 1.9
    // 16.12.2018

    // Не получилось даже забрутфорсить, решение оказалось несложным, но догадаться не вышло.
}
