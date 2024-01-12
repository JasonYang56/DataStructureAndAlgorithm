package com.atguigu.tree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};

        Node headNode = createHuffmanTree(arr);

        preQuery(headNode);
    }

    public static void preQuery(Node root){
        if(root!= null){
            root.preQuery();
        }else{
            System.out.println("空树！！！");
        }
    }

    public static Node createHuffmanTree(int arr[]){
        List<Node> nodeList = new ArrayList<Node>();
        for(int i=0;i<arr.length;i++){
            Node node = new Node(arr[i]);
            nodeList.add(node);
        }
        Collections.sort(nodeList);
//        System.out.println(nodeList);
        while(nodeList.size()>1){
            Node lNode = nodeList.get(0);
            Node rNode = nodeList.get(1);
            Node parentNode = new Node(lNode.value+rNode.value);
            parentNode.leftNode = lNode;
            parentNode.rightNode = rNode;
            nodeList.remove(lNode);
            nodeList.remove(rNode);
            nodeList.add(parentNode);
            Collections.sort(nodeList);
        }
        return nodeList.get(0);
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

    public void preQuery(){
        System.out.println(this);
        if(this.leftNode != null){
            this.leftNode.preQuery();
        }
        if(this.rightNode != null){
            this.rightNode.preQuery();
        }
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return this.value-o.value;
    }
}
