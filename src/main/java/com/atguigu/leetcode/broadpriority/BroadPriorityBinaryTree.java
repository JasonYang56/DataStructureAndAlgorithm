package com.atguigu.leetcode.broadpriority;

import org.junit.Test;

import java.util.*;

public class BroadPriorityBinaryTree {

    public static void main(String[] args) {
//        int[][] edges = new int;
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;

//        List<List<Integer>> res = levelOrder(root);
        List<List<Integer>> res = deepPriority(root);

        for(List<Integer> list:res){
            for(Integer i:list){
                System.out.println("----->"+i);
            }
        }


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 注意 1：一定要先把当前队列的结点总数暂存起来
            int currentSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode front = queue.poll();
                currentLevel.add(front.val);
                // 注意 2：左（右）孩子结点非空才加入队列
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            res.add(currentLevel);
        }
        return res;
    }

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static List<List<Integer>> deepPriority(TreeNode root){

        Deque<Integer> deQueue = new LinkedList<>();
        List<Integer> arrList = new ArrayList<>();
        arrList.addAll(deQueue);

        if(root ==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        Object[] objects = (Integer[])a.toArray();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                tempList.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }

    @Test
    public void test1(){
        Deque<Integer> deQueue = new LinkedList<>();
        deQueue.offerFirst(1);
        deQueue.offerFirst(2);
        deQueue.offerFirst(3);
//        System.out.println(deQueue.);
        List<List<Integer>> arrList = new ArrayList<>();
        arrList.add(new ArrayList<Integer>(deQueue));
        System.out.println();
        HashMap hashMap = new HashMap();

    }

//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> resList = new ArrayList();
//        boolean isTwo = false;
//        if(root==null){
//            return resList;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            Deque<Integer> tempDeQueue = new LinkedList<>();
//            int size = queue.size();
//
//            for(int i=0;i<size;i++){
//                TreeNode tempNode = queue.poll();
//                if(isTwo){
//                    tempDeQueue.offerFirst(tempNode.val);
//                }else{
//                    tempDeQueue.offerLast(tempNode.val);
//                }
//
//                if(tempNode.left!=null){
//                    queue.offer(tempNode.left);
//                }
//                if(tempNode.right!=null){
//                    queue.offer(tempNode.right);
//                }
//                // isTwo=true;
//            }
//
//        }
//        resList.add(new ArrayList<Integer>(tempDeQueue));
//        isTwo = !isTwo;
//    }
//
//        return resList;
//}

}

