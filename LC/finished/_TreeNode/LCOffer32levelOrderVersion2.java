package finished._TreeNode;

import java.util.*;

public class LCOffer32levelOrderVersion2 {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        boolean isList1 = true;
        for (int i = 0; i < 10; i++) {
            Deque tmp;
            if (isList1) {
                tmp = list;
            } else {
                tmp = list2;
            }
            tmp.offer(i);
            isList1 = !isList1;
        }
        System.out.println();

        LCOffer32levelOrderVersion2 l = new LCOffer32levelOrderVersion2();

        TreeNode n7 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2, n6, n7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        List<List<Integer>> lists = l.levelOrder(n1);
        System.out.println(lists);

    }


    /*
    执行耗时:1 ms,击败了78.33% 的Java用户
	内存消耗:41.1 MB,击败了68.07% 的Java用户
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
            add(null);
        }};
        ArrayList<Integer> tmpList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add(tmpList);
                tmpList=new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                tmpList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderLC(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

}
