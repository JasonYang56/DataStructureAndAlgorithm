package com.atguigu.cyclearry.linkedarray;

import org.jetbrains.annotations.NotNull;
import sun.lwawt.macosx.CSystemTray;

import java.nio.ReadOnlyBufferException;
import java.util.Stack;

public class OnelineLinkedArrayDemo {
    public static void main(String[] args) {

        OnelineLinkedArrayNode head = new OnelineLinkedArrayNode(0,null,null);
        OnelineLinkedArrayList list = new OnelineLinkedArrayList(head);

        OnelineLinkedArrayNode node1 = new OnelineLinkedArrayNode(2,"章三",null);
        OnelineLinkedArrayNode node2 = new OnelineLinkedArrayNode(4,"李四",null);
        OnelineLinkedArrayNode node3 = new OnelineLinkedArrayNode(6,"网五",null);
        OnelineLinkedArrayNode node4 = new OnelineLinkedArrayNode(8,"陈六",null);


        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);
        list.addNode(node4);

        list.showList();

        OnelineLinkedArrayNode node5 = new OnelineLinkedArrayNode(9,"xin陈六",null);

        list.insertNode(node5);
        list.showList();

        OnelineLinkedArrayNode node6 = new OnelineLinkedArrayNode(11,"xin陈六",null);
        list.insertNode(node6);
        list.showList();

        OnelineLinkedArrayNode node7 = new OnelineLinkedArrayNode(10,"xin陈六",null);
        list.insertNode(node7);
        list.showList();

        System.out.println("----------------");
        list.reverseLinkedList(list);
        list.showList();

    }
}

class OnelineLinkedArrayList {
    private OnelineLinkedArrayNode headNode;
//    OnelineLinkedArrayNode node;

    public OnelineLinkedArrayList(OnelineLinkedArrayNode headNode) {
        this.headNode = headNode;
    }

    public void addNode(OnelineLinkedArrayNode node) {
        OnelineLinkedArrayNode tempNode;
        if (headNode.nextNode == null) {
            headNode.nextNode = node;
        } else {
            tempNode = headNode.nextNode;
            while (true) {

                if (tempNode.nextNode == null) {
                    tempNode.nextNode = node;
                    break;
                } else {
                    tempNode = tempNode.nextNode;
                }
            }
        }

    }

    public OnelineLinkedArrayNode findNodeByNo(int nodeNo) {
        if (headNode.nextNode == null) {
            throw new RuntimeException("链表为空");
        } else {
            OnelineLinkedArrayNode tempNode = headNode.nextNode;
            do {
                if (tempNode.nodeNo == nodeNo) {
                    System.out.println("get到节点信息为：" + tempNode.toString());
                    return tempNode;
                }
                tempNode = tempNode.nextNode;
            } while (tempNode != null);
            return null;
        }
    }

    public void updateNode(int nodeNo, String newName) {
        OnelineLinkedArrayNode updateNode = findNodeByNo(3);
        updateNode.nodeName = newName;
        showList();
    }

    public void deleteNode(int nodeNo) {
        if (headNode.nextNode == null) {
            throw new RuntimeException("链表为空");
        } else {
            OnelineLinkedArrayNode tempNode = headNode;
            while (true) {
//                System.out.println("-----");
                if (tempNode.nextNode.nodeNo == nodeNo) {
                    System.out.println("get到待删除节点信息为：" + tempNode.nextNode.toString());
                    if (tempNode.nextNode.nextNode == null) {
                        tempNode.nextNode = null;
                    } else {
                        tempNode.nextNode = tempNode.nextNode.nextNode;
                    }
                    break;
                } else {
                    tempNode = tempNode.nextNode;
                }

                if (tempNode.nextNode == null) {
                    throw new RuntimeException("无法删除，未找到该节点");
                }
            }


        }

    }

    public void showList() {
        if (headNode.nextNode == null) {
            throw new RuntimeException("链表为空");
        } else {
            OnelineLinkedArrayNode tempNode = headNode.nextNode;
            do {
                System.out.println("--->" + tempNode.toString());
                tempNode = tempNode.nextNode;
            } while (tempNode != null);
        }

    }

    public void insertNode(OnelineLinkedArrayNode node) {
        OnelineLinkedArrayNode tempNode = headNode;
        OnelineLinkedArrayNode tempNode2;
        if (tempNode.nextNode == null) {
            throw new RuntimeException("链表为空");
        } else {
            if (findNodeByNo(node.nodeNo) != null) {
                throw new RuntimeException("无法插入，相同序号节点已存在");
            } else {
                do {
                    if(tempNode.nextNode!=null){
                        if (tempNode.nextNode.nodeNo > node.nodeNo) {
                            tempNode2 = tempNode.nextNode;
                            tempNode.nextNode = node;
                            node.nextNode = tempNode2;
                            break;
                        } else {
                            tempNode = tempNode.nextNode;
                        }
                    }else{
                        tempNode.nextNode=node;
                        break;
                    }

                } while (tempNode != null);

            }

        }
    }

    public void reverseLinkedList(@NotNull OnelineLinkedArrayList onelineLinkedArrayList){
        Stack stack = new Stack<OnelineLinkedArrayNode>();
        if(onelineLinkedArrayList.headNode.nextNode==null || onelineLinkedArrayList.headNode.nextNode.nextNode==null){
            throw new RuntimeException("链表为空或者只有一个节点，无需反转") ;
        }else{
            OnelineLinkedArrayNode tempNode = onelineLinkedArrayList.headNode.nextNode;

            while(true){

                stack.add(tempNode);
                tempNode = tempNode.nextNode;
                if(tempNode==null){
                    break;
                }

            }
            onelineLinkedArrayList.headNode.nextNode=null;
            int stackSize = stack.size();
            for(int i = 0;i<stackSize;i++){
                ((OnelineLinkedArrayNode)stack.get(i)).nextNode=null;
            }

            for(int i = 0;i<stackSize;i++){
                if(onelineLinkedArrayList.headNode.nextNode==null){
                    onelineLinkedArrayList.headNode.nextNode = (OnelineLinkedArrayNode) stack.pop();
                }else{
                    onelineLinkedArrayList.addNode((OnelineLinkedArrayNode) stack.pop());
                }
            }
        }
    }

}

class OnelineLinkedArrayNode {
    public int nodeNo;
    public String nodeName;
    public OnelineLinkedArrayNode nextNode;


    public OnelineLinkedArrayNode(int nodeNo, String nodeName, OnelineLinkedArrayNode nextNode) {
        this.nodeNo = nodeNo;
        this.nodeName = nodeName;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "OnelineLinkedArrayNode{" +
                "nodeNo=" + nodeNo +
                ", nodeName='" + nodeName + '\'' +
                '}';
    }

}
