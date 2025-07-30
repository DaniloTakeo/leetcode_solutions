package problem_873;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int iVal = arr[k] - arr[j];
                if (iVal < arr[j] && indexMap.containsKey(iVal)) {
                    int i = indexMap.get(iVal);
                    String key = i + "," + j;
                    int len = dp.getOrDefault(key, 2) + 1;
                    dp.put(j + "," + k, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,3,7,11,12,14,18};
		
		System.out.println(lenLongestFibSubseq(arr));
	}
}
