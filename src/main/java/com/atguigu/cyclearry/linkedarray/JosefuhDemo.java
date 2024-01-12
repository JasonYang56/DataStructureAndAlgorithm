package com.atguigu.cyclearry.linkedarray;

public class JosefuhDemo {

    public static void main(String[] args) {
        CircleLinkedArray circleLinkedArray = new CircleLinkedArray();
//        for(int i=0;i<100;i++){
//            CircleNode tempNode = new CircleNode(i+1,"Num"+String.valueOf(i+1));
//            circleLinkedArray.addNode(tempNode);
//        }
//
//        circleLinkedArray.showArray();

        circleLinkedArray.showJosehuArr(2,2,1);
    }

}



class CircleLinkedArray{
    private CircleNode firstNode;
    private CircleNode lastNode;

    public CircleNode getFirstNode() {
        return firstNode;
    }

    public CircleNode getLastNode() {
        return lastNode;
    }

    public void setFirstNode(CircleNode firstNode) {
        this.firstNode = firstNode;
    }

    public void setLastNode(CircleNode lastNode) {
        this.lastNode = lastNode;
    }

    public void addNode(CircleNode circleNode){
        if(firstNode == null){
            firstNode = circleNode;
            firstNode.setNextNode(firstNode);
            lastNode = firstNode;
        }else{
            CircleNode tempNode = firstNode;
            while (true){
                if(tempNode.getNextNode()!=firstNode){
                    tempNode = tempNode.getNextNode();
                }else{
                    break;
                }
            }
            tempNode.setNextNode(circleNode);
            circleNode.setNextNode(firstNode);
            lastNode =circleNode;
        }
    }

    public void showArray(){
        if(firstNode ==null){
            throw new RuntimeException("链表为空");
        }else{
            CircleNode tempNode;
            if(firstNode == lastNode){
                System.out.println("--"+firstNode.getNodeNo()+"--"+firstNode.getNodeName());
            }else{
                tempNode = firstNode;
                while(true){
                    System.out.println("--"+tempNode.getNodeNo()+"--"+tempNode.getNodeName());
                    tempNode = tempNode.getNextNode();
                    if(tempNode == firstNode){
                        break;
                    }
                }
            }


        }
    }

    public void showJosehuArr(int startNo,int oriNum,int outNum){
        if(startNo<0 || oriNum < 1 ||startNo>oriNum || outNum <0){
            throw new RuntimeException("输入的参数不合法");
        }
        CircleNode tempFirstNode;
        CircleNode tempLastNode;
        for(int i=0;i<oriNum;i++){
            CircleNode tempNode2 = new CircleNode(i+1,"Num"+String.valueOf(i+1));
            this.addNode(tempNode2);
        }
        tempFirstNode = this.firstNode;
        tempLastNode = this.lastNode;
        for(int i=0;i<startNo-1;i++){
            tempFirstNode = tempFirstNode.getNextNode();
            tempLastNode = tempLastNode.getNextNode();
        }
        while(true){
            if(tempLastNode == tempFirstNode){
                System.out.println("最后一个节点信息为"+"--"+tempFirstNode.getNodeNo()+"--"+tempFirstNode.getNodeName());
                break;
            }
            for(int i=0;i<outNum-1;i++){
                tempFirstNode = tempFirstNode.getNextNode();
                tempLastNode = tempLastNode.getNextNode();
            }
            System.out.println("出队列信息为"+"--"+tempFirstNode.getNodeNo()+"--"+tempFirstNode.getNodeName());
            tempLastNode.setNextNode(tempFirstNode.getNextNode());
            tempFirstNode = tempLastNode.getNextNode();
        }
    }
}

class CircleNode{
    private int nodeNo;
    private String nodeName;
    private CircleNode nextNode;

    public CircleNode(int nodeNo, String nodeName) {
        this.nodeNo = nodeNo;
        this.nodeName = nodeName;
    }

    public int getNodeNo() {
        return nodeNo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public CircleNode getNextNode() {
        return nextNode;
    }

    public void setNodeNo(int nodeNo) {
        this.nodeNo = nodeNo;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setNextNode(CircleNode nextNode) {
        this.nextNode = nextNode;
    }
}
