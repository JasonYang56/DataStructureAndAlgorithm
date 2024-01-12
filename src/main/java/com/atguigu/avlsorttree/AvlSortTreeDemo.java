package com.atguigu.avlsorttree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class AvlSortTreeDemo {

    public static void main(String[] args) {
//        int arr[] = {4,3,6,5,7,8};
//        int arr[] = {10,12,8,9,7,6};
        int arr[] = {10,11,7,6,8,9};
        SortTree sortTree = new SortTree(null);

        for(int i=0;i<arr.length;i++){
            sortTree.add(new Node(arr[i]));
        }

//        sortTree.midQuery();
//        sortTree.leftRotate();
//        System.out.println(sortTree.root);
//        System.out.println(sortTree.root.leftNode);
//        System.out.println(sortTree.root.rightNode);
//        System.out.println(sortTree.root.leftNode.leftNode);
//        System.out.println(sortTree.root.leftNode.rightNode);
//        System.out.println(sortTree.root.rightNode.leftNode);
//        System.out.println(sortTree.root.rightNode.rightNode);

//        System.out.println("ori height is :"+sortTree.root.leftHeight());
//        System.out.println("ori height is :"+sortTree.root.rightHeight());
//        sortTree.rightRotate();
//        System.out.println("new height is :"+sortTree.root.leftHeight());
//        System.out.println("new height is :"+sortTree.root.rightHeight());

        System.out.println(sortTree.root);
        System.out.println(sortTree.root.leftNode);
        System.out.println(sortTree.root.rightNode);
        System.out.println(sortTree.root.leftNode.leftNode);
        System.out.println(sortTree.root.leftNode.rightNode);
        System.out.println(sortTree.root.rightNode.leftNode);
        System.out.println(sortTree.root.rightNode.rightNode);
//
//
//        System.out.println(sortTree.root);
    }


}

class SortTree{
    public Node root;

    public SortTree(Node root) {
        this.root = root;
    }

    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
//        if(root.leftHeight()-root.rightHeight()>1){
//
//        }
//
//        if(root.rightHeight()-root.leftHeight()>1){
//
//        }
    }
    public void midQuery(){
        root.midQuery();
    }

    public void leftRotate(){
        root.leftRotate();
    }

    public void rightRotate(){
        root.rightRotate();
    }

    public int height(){
        return root.height();
    }

    public int leftHeight(){
        return root.leftHeight();
    }

    public int rightHeight(){
        return root.rightHeight();
    }


}

class Node implements Comparable<Node>{
    public int value;
    public Node leftNode;
    public Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if(this.value>node.value){
            if(this.leftNode==null){
                this.leftNode = node;
            }else{
                this.leftNode.add(node);
            }
        }else{
            if(this.rightNode==null){
                this.rightNode = node;
            }else{
                this.rightNode.add(node);
            }
        }

        if(this.rightHeight()-this.leftHeight()>1){
            if(this.rightNode != null && this.rightNode.leftHeight()>this.rightNode.rightHeight()){
                this.rightNode.rightRotate();
            }
            this.leftRotate();
            return;
        }

        if(this.leftHeight()-this.rightHeight()>1){
            if(this.leftNode != null && this.leftNode.rightHeight()>this.leftNode.leftHeight()){
                this.leftNode.leftRotate();
            }
            this.rightRotate();
        }

    }

    //
    public void leftRotate(){
        Node newNode = new Node(value);
        newNode.leftNode = this.leftNode;
        newNode.rightNode = this.rightNode.leftNode;
        this.value = this.rightNode.value;
        this.leftNode = newNode;
        this.rightNode = this.rightNode.rightNode;

    }

    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.rightNode = this.rightNode;
        newNode.leftNode = this.leftNode.rightNode;
        this.value = this.leftNode.value;
        this.rightNode = newNode;
        this.leftNode = this.leftNode.leftNode;

    }

    public int height(){
        return Math.max(this.leftNode==null?0:this.leftNode.height(),this.rightNode==null?0:this.rightNode.height())+1;
    }

    public int leftHeight(){
        if(this.leftNode==null){
            return 0;
        }else{
            return this.leftNode.height();

        }
    }

    public int rightHeight(){
        if(this.rightNode==null){
            return 0;
        }else {
            return this.rightNode.height();
        }
    }

    public void midQuery(){
        if(this.leftNode != null){
            this.leftNode.midQuery();
        }
        System.out.println(this);
        if(this.rightNode != null){
            this.rightNode.midQuery();
        }
    }



    @Override
    public int compareTo(@NotNull Node o) {
        return this.value-o.value;
    }

//    public static void test(){
//        String str = "asd fa sd f";
//        String[] strArr = str.split(" ");
//        ArrayList list = new ArrayList<Integer>();
//        Arrays.copyOfRange()
//
//                Integer.M
//    }

}
