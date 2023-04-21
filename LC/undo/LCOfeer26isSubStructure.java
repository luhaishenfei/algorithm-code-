package undo;

import finished._TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LCOfeer26isSubStructure {


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //record B's head node
        TreeNode recordB = B;

        List bList = new ArrayList();
        Deque<TreeNode> stackB = new LinkedList<>();
        stackB.push(B);
        while (!stackB.isEmpty()) {
            TreeNode n = stackB.pop();
            if (n == null) break;
            bList.add(n);
            stackB.push(n.left);
            stackB.push(n.right);


        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(A);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            stack.push(n.right);
            stack.push(n.left);
            if (A.left == B.left) {
            }


        }


        if (A.val == B.val) {
            A = A.left;
            B = B.left;
        } else {
            B = recordB;
        }

        return false;
    }
}
