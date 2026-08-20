/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiff(Node root) {
        return solve(root);
    }

    int solve(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int ans = Integer.MIN_VALUE;

        if (node.left != null) {
            ans = Math.max(ans, node.data - node.left.data);
            ans = Math.max(ans, solveWithAncestor(node.left, node.data));
        }

        if (node.right != null) {
            ans = Math.max(ans, node.data - node.right.data);
            ans = Math.max(ans, solveWithAncestor(node.right, node.data));
        }

        return ans;
    }

    int solveWithAncestor(Node node, int maxAncestor) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int ans = maxAncestor - node.data;

        maxAncestor = Math.max(maxAncestor, node.data);

        ans = Math.max(ans, solveWithAncestor(node.left, maxAncestor));
        ans = Math.max(ans, solveWithAncestor(node.right, maxAncestor));

        return ans;
    }
}