/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {

    public int getCount(Node root, int k) {

        List<Integer> leafLevels = new ArrayList<>();

        findLeaves(root, 1, leafLevels);

        Collections.sort(leafLevels);

        int count = 0;

        for (int level : leafLevels) {

            if (level > k) {
                break;
            }

            k -= level;
            count++;
        }

        return count;
    }

    private void findLeaves(Node root, int level, List<Integer> leafLevels) {

        if (root == null) {
            return;
        }

        // If this is a leaf node
        if (root.left == null && root.right == null) {
            leafLevels.add(level);
            return;
        }

        findLeaves(root.left, level + 1, leafLevels);
        findLeaves(root.right, level + 1, leafLevels);
    }
}