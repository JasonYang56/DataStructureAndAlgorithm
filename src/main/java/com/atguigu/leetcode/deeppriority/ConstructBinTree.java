package com.atguigu.leetcode.deeppriority;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//public class ConstructBinTree {
//
//    @Test
//    public void testDemo(){
//        String s = "12-23--34--231---288----1";
//        String[] split = s.split("-");
//        for(String ss:split)
//        System.out.println("---->"+ss);
//    }
//}

public class ConstructBinTree {

    @Test
    public void testDemo(){
        ConstructBinTree constructBinTree = new ConstructBinTree();
        String s = "12-23--34--45-56--67--79";
        constructBinTree.recoverFromPreorder(s);
    }
    public TreeNode recoverFromPreorder(String S) {
        // 存储当前节点的路径
        Stack<TreeNode> path = new Stack<TreeNode>();
        // 存储字符串中的位置
        int pos = 0;
        while (pos < S.length()) {
            // 获取当前层数
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            // 获取节点值
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            // 构造当前节点
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                //如果当前节点的深度==当前路径长度（前一个节点是当前节点的父节点）
                if (!path.isEmpty()) {
                    //如果不是第一个节点，前一个节点的左子节点为当前节点
                    path.peek().left = node;
                }
            }else {
                //如果当前节点的深度！=当前路径长度（前一个节点不是当前节点的父节点）
                while (level != path.size()) {
                    //通过queue弹出其他子节点，找到当前节点的父节点
                    path.pop();
                }
                // 找到父节点，因为此时左子节点已确定，所以赋值给右子节点
                path.peek().right = node;
            }
            // 放入queue中
            path.push(node);
        }
        // 全部弹出，只剩根节点
        while (path.size() > 1) {
            path.pop();
        }
        // 返回根
        return path.peek();
    }
}

class TreeNode {
   int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
