package problem_1028;

import java.util.ArrayDeque;
import java.util.Deque;


public class Solution2 {
	public static TreeNode recoverFromPreorder(String traversal) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		int i = 0, n = traversal.length();

		while (i < n) {
			int depth = 0;
			// Conta a profundidade
			while (i < n && traversal.charAt(i) == '-') {
				depth++;
				i++;
			}

			// Pega o valor numérico
			int val = 0;
			while (i < n && Character.isDigit(traversal.charAt(i))) {
				val = val * 10 + (traversal.charAt(i) - '0');
				i++;
			}

			TreeNode node = new TreeNode(val);

			// Garante que o tamanho da stack seja igual à profundidade atual
			while (stack.size() > depth) {
				stack.pop();
			}

			// Conecta com o pai (topo da pilha)
			if (!stack.isEmpty()) {
				TreeNode parent = stack.peek();
				if (parent.left == null) parent.left = node;
				else parent.right = node;
			}

			stack.push(node);
		}

		// Último da pilha é a raiz (bottom)
		while (stack.size() > 1) {
			stack.pop();
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		TreeNode root = recoverFromPreorder("1-2--3--4-5--6--7");
		printPreOrder(root);
	}

	private static void printPreOrder(TreeNode node) {
		if (node == null) return;
		System.out.print(node.val + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
}
