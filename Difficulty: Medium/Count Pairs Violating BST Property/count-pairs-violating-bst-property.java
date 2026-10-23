/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private List<Integer> elements;
    private int pairs;

    public int pairsViolatingBST(Node root) {
        // code here
        elements = new ArrayList<>();
        pairs = 0;

        reverseInorder(root);

        return pairs;
    }

    // Right -> Root -> Left (descending order of inorder)
    private void reverseInorder(Node root) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right);

        int count = countSmaller(root.data);
        elements.add(count, root.data);  // sorted order maintain hota hai
        pairs += count;

        reverseInorder(root.left);
    }

    // Kitne elements target se strictly chhote hain (binary search)
    private int countSmaller(int target) {
        int l = 0;
        int r = elements.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (elements.get(mid) >= target) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }

        return ans + 1;
    }
}