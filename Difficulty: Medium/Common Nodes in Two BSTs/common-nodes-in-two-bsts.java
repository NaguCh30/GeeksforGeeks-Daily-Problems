/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/


class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node curr1 = r1;
        Node curr2 = r2;

        while (curr1 != null || curr2 != null ||
               !s1.isEmpty() || !s2.isEmpty()) {

            // Inorder traversal of first BST
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            // Inorder traversal of second BST
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            if (top1.data == top2.data) {
                ans.add(top1.data);

                curr1 = top1.right;
                curr2 = top2.right;

                s1.pop();
                s2.pop();
            }
            else if (top1.data < top2.data) {
                s1.pop();
                curr1 = top1.right;
            }
            else {
                s2.pop();
                curr2 = top2.right;
            }
        }

        return ans;
    }
}
