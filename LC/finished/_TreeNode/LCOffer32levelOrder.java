package finished._TreeNode;

import finished._TreeNode.TreeNode;

import java.util.*;

public class LCOffer32levelOrder {

    //nice
    /*
	执行耗时:1 ms,击败了96.96% 的Java用户
	内存消耗:40.1 MB,击败了89.94% 的Java用户
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> record = new LinkedList<>();
        Deque<TreeNode> list = new LinkedList<>();

        list.offer(root);
        while (list.peek() != null) {
            TreeNode node = list.poll();
            record.add(node.val);
            if (node.left != null) list.offer(node.left);
            if (node.right != null) list.offer(node.right);
        }
        int[] res = new int[record.size()];
        for (int i = 0; i < record.size(); i++) {
            res[i] = record.get(i);
        }
        return res;
    }


    //
    public int[] levelOrderLC(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
