package problem_1028;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "nodeValue = " + val + " leftChild = " + left + " rightChild = " + right;
	}
}


public class Solution1 {

	public static TreeNode recoverFromPreorder(String traversal) {
		Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
		TreeNode[] nodes = new TreeNode[1000];
		TreeNode rootNode = null;
		TreeNode parentNode = null;
		TreeNode currentNode = null;
		int lastLayer = 0;
		int currentLayer = 0;
		int differenceBetweenLayers = 0;
		int offset = 0;
		int numOfAlgarisms = 0;
		StringBuilder numberBuilder = new StringBuilder();
		
		while(!traversal.isBlank()) {
			if(traversal.startsWith("-")) {
				currentLayer++;
				traversal = traversal.substring(1);
			} else {
				while(!traversal.startsWith("-") && !traversal.isBlank()) {
					if(!traversal.isBlank()) {
						numberBuilder.append(traversal.charAt(0));
						numOfAlgarisms++;
						traversal = traversal.substring(1);
					}
				}
				currentNode = new TreeNode(Integer.valueOf(numberBuilder.toString()));
				numberBuilder = new StringBuilder();
				nodes[offset] = currentNode;
				
				if(rootNode == null) rootNode = currentNode;
				childParentMap.put(currentNode, parentNode);
				
				if(parentNode != null) {
					if(parentNode.left == null) parentNode.left = currentNode;
					else if(parentNode.right == null) parentNode.right = currentNode;
				}
				
				offset++;
				lastLayer = currentLayer;
				currentLayer = 0;
			}
			
			differenceBetweenLayers = lastLayer - currentLayer;
			
			if(parentNode == null) {
				parentNode = currentNode;
			}
			
			parentNode = nextParent(currentNode, differenceBetweenLayers, childParentMap);
		}
		
		return rootNode;
	}
	
	private static TreeNode nextParent(TreeNode node, int differenceBetweenLayers, Map<TreeNode, TreeNode> treeMap) {
		TreeNode nextParent = node;
		
		if(differenceBetweenLayers >= 0) {
			for (int i = 0; i <= differenceBetweenLayers; i++) {
				if(treeMap.get(nextParent) != null) nextParent = treeMap.get(nextParent);
			}			
		}
		
		return nextParent;
	}

	public static void main(String[] args) {
		System.out.println(recoverFromPreorder("1-401--349---90--88"));
	}
}
