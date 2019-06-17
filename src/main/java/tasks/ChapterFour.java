package main.java.tasks;

import main.java.CtCILibrary.TreeNode;

/**
 * {5 / 12)
 *
 * Created by Влад on 24.03.2019.
 */
public class ChapterFour {
    private static int count = 0;
    /* ------------------------------------------------------------------------------------------------------------- */
    // 4.1
    // 11.02.2019

    /* ------------------------------------------------------------------------------------------------------------- */
    // 4.2
    // 13.02.2019

     /* ------------------------------------------------------------------------------------------------------------- */
    // 4.3
    // 07.04.2019

    /* ------------------------------------------------------------------------------------------------------------- */
    // 4.4
    // 07.04.2019

    /* ------------------------------------------------------------------------------------------------------------- */
    // 4.6
    // 17.06.2019

    public static TreeNode successor(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            return findNext(node);
        }
    }

    private static TreeNode findNext(TreeNode node) {
        if (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            } else {
                return findNext(node.parent);
            }
        } else {
            return null;
        }
    }
}
