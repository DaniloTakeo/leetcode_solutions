package problem_1957;

public class Solution1 {

	public static void main(String[] args) {
		
		System.out.println(makeFancyString("aaabbaaa"));
	}
	
	public static String makeFancyString(String s) {
		String newString = s;
		
		for (int i = 0; i < s.length(); i++) {
			if(i < s.length() - 2) {
				if(repeatedCharacters(s.charAt(i), s.charAt(i + 1), s.charAt(i + 2))) {
					newString = s.replace(buildCharSequence(s.charAt(i), 2),
							buildCharSequence(s.charAt(i), 1));
				}				
			}
		}
		
		if(identifyRepeatedCharSequence(newString) == true) newString = makeFancyString(newString);

		return newString;
    }

    public static boolean repeatedCharacters(char c, char d, char e) {
		return c == d && c == e;
	}
    
    public static String buildCharSequence(char c, int times) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < times; i++) {
    		sb.append(c);
    	}
    	
    	return sb.toString();
    }
    
    public static boolean identifyRepeatedCharSequence(String s) {
    	boolean b = false;
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(i < s.length() - 2) {
				if(repeatedCharacters(s.charAt(i), s.charAt(i + 1), s.charAt(i + 2))) {
					b = true;
				}				
			}
    	}
    	
    	return b;
    }
}

/** 1957. Delete Characters to Make Fancy String
 *  A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

 

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 */