package problem_1957;

public class Solution2 {
    public static String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int len = result.length();

            if (len >= 2 && result.charAt(len - 1) == curr && result.charAt(len - 2) == curr) {
                continue;
            }

            result.append(curr);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("aaabbaaa"));
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
        System.out.println(makeFancyString("aab"));
    }
}
