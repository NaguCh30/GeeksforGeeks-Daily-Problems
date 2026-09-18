/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    int prev = -1;
    int min = Integer.MAX_VALUE;

    public int absDiff(Node root) {
        inorder(root);
        return min;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Current
        if (prev != -1) {
            min = Math.min(min, root.data - prev);
        }

        prev = root.data;

        // Right
        inorder(root.right);
    }
}