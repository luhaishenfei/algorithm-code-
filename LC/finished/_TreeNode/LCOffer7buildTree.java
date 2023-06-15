package finished._TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LCOffer7buildTree {
    public static void main(String[] args) {
        LCOffer7buildTree l = new LCOffer7buildTree();

//        TreeNode n0=new TreeNode(3,
//                new TreeNode(9),            new TreeNode(20,
//                                        new TreeNode(15),new TreeNode(7))
//                );
//        int[] ints1={3,1,2,4};
//        int[] ints2={1,2,3,4};

        int[] ints1 = {1, 2};
        int[] ints2 = {1, 2};

//        TreeNode n1=l.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        TreeNode n1 = l.buildTreeLC(ints1, ints2);
        System.out.println(n1);
    }

    /*
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
    */

    /*

                            1,
             2,                    3,
       4,            5,         6,       7,
     8,   9,      10
    pre[1,2,4,8,9,5,10,3,6,7]
    in[8,4,9,2,10,5,1,6,3,7]
     */

    //    f*ck,finally
    /*
    执行耗时:4 ms,击败了28.16% 的Java用户
	内存消耗:42 MB,击败了34.04% 的Java用户
     */
    int pIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getRoot(0, inorder.length, preorder, inorder);
    }

    /*
    //int pIdx
    //int iStart
    //int iEnd
    */
    private TreeNode getRoot(int iStart, int iEnd, int[] preorder, int[] inorder) {
        if (iStart >= iEnd || pIdx >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[pIdx]);
        TreeNode lNode = null;
        TreeNode rNode = null;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == preorder[pIdx]) {
                pIdx++;
                lNode = getRoot(iStart, i, preorder, inorder);
                rNode = getRoot(i + 1, iEnd, preorder, inorder);
                break;
            }
        }
        node.left = lNode;
        node.right = rNode;
        return node;
    }





    /**
     * 递归法
     *
     * @param preorder 前序遍历列表
     * @param inorder 中序遍历列表
     * @return 二叉树
     */
    /*
    https://blog.csdn.net/Lammonpeter/article/details/118060914#%E6%A0%B9%E6%8D%AE%E5%89%8D%E5%BA%8F%E5%92%8C%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91
     */
    /*
    执行耗时:1 ms,击败了99.79% 的Java用户
	内存消耗:42.1 MB,击败了30.25% 的Java用户
     */
    public TreeNode buildTreeLC(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie,
                                     Map<Integer, Integer> map) {
        // 递归终止条件
        if (pe < ps || ie < is) {
            return null;
        }

        // 递归本层次需要做的事情
        // 获取根节点
        TreeNode root = new TreeNode(preorder[ps]);
        // 获取根节点在中序遍历结果序列中的位置
        int ri = map.get(preorder[ps]);
        // 确定左子树的数量，从而可以从前序遍历中找到左子树和右子树
        int leftChildTreeNodeNum = ri - is;

        // 递归过程
        root.left = buildTreeHelper(preorder, ps + 1, ps + leftChildTreeNodeNum, inorder, is, ri - 1, map);
        root.right = buildTreeHelper(preorder, ps + leftChildTreeNodeNum + 1, pe, inorder, ri + 1, ie, map);
        return root;
    }


    //迭代
    public TreeNode buildTreeLC2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }




}
