package problem_873;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	public static int lenLongestFibSubseq(int[] arr) {
		int length = 0;
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> fibSubseqs = new ArrayList<>();
		List<List<Integer>> aux = new ArrayList<>();
		
		for (int i : arr) {
			list.add(i);
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for(int k = j + 1; k < arr.length; k++) {
					if(arr[i] + arr[j] == arr[k]) {
						fibSubseqs.add(List.of(arr[i], arr[j], arr[k]));
					}
				}
			}
		}
		
		for (List<Integer> s : fibSubseqs) {
			boolean escape = false;
			while(escape == false) {
				if(list.contains(s.get(s.size() - 1) + s.get(s.size() - 2))) {
					ArrayList<Integer> l = new ArrayList<>(s);
					l.add(l.get(l.size() - 1) + l.get(l.size() - 2));
					s = l;
					
					aux.add(s);					
				} else {
					escape = true;
				}
			}
		}
		
		aux.forEach(a -> {
			fibSubseqs.add(a);
		});
		
		for (List<Integer> l : fibSubseqs) {
			if(length < l.size()) {
				length = l.size();
			}
		}
		
		return length;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,7,11,12,14,18};
		
		System.out.println(lenLongestFibSubseq(arr));
	}
}
