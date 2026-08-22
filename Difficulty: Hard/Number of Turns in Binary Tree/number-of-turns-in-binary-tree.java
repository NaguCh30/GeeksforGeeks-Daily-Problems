/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        int i = 0;

        while (i < pathP.length() && i < pathQ.length()
                && pathP.charAt(i) == pathQ.charAt(i)) {
            i++;
        }

        String pPath = pathP.substring(i);
        String qPath = pathQ.substring(i);

        StringBuilder path = new StringBuilder();

        for (int j = pPath.length() - 1; j >= 0; j--) {
            path.append(pPath.charAt(j));
        }

        path.append(qPath);

        int turns = 0;

        for (int j = 1; j < path.length(); j++) {
            if (path.charAt(j) != path.charAt(j - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }

    private boolean findPath(Node root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        path.append('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);
        path.append('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }
}